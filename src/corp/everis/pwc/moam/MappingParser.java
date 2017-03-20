package corp.everis.pwc.moam;

import java.io.File;
import java.io.PrintWriter;
import java.rmi.UnmarshalException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import corp.everis.pwc.raw.ASSOCIATEDSOURCEINSTANCE;
import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.FOLDER;
import corp.everis.pwc.raw.GROUP;
import corp.everis.pwc.raw.INSTANCE;
import corp.everis.pwc.raw.MAPPING;
import corp.everis.pwc.raw.POWERMART;
import corp.everis.pwc.raw.REPOSITORY;
import corp.everis.pwc.raw.SHORTCUT;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.SOURCEFIELD;
import corp.everis.pwc.raw.TABLEATTRIBUTE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TARGETLOADORDER;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;

public class MappingParser {
	/*
	 * Comment or uncomment the following blocks to select what to print or not.
	 * If you want to debug an expression, you can set everything to false except
	 * bPrintExp (boolean print expression) and bPrintDetails.
	 */

	//	private static boolean bPrintExp = false;
	// 	private static boolean bPrintFil = false;
	//	private static boolean bPrintJnr = false;
	// 	private static boolean bPrintLkp = false;
	//	private static boolean bPrintSrt = false;
	//	private static boolean bPrintAgg = false;
	//	private static boolean bPrintDetails = false;
	private static boolean bPrintExp = true;
	private static boolean bPrintFil = true;
	private static boolean bPrintJnr = true;
	private static boolean bPrintLkp = true;
	private static boolean bPrintSrt = true;
	private static boolean bPrintAgg = true;
	private static boolean bPrintDetails = true;

	private static String SQLToExport = "";

	/**
	 * The following string determines the inputfile, the local root is
	 * C:\Users\ydelvaul\ownCloud
	 */
	private static String sourceFile = "./OSITEST/OSI_TESTMAPPING.XML";

	/**
	 * The following string is the path to the folder containing the outputfolders.
	 * XML for the different mappings.
	 * DDL for the table-ddl's
	 * FILE for the different input/outputfiles.
	 */
	private static String outputPath = "./OSITEST/";

	/**
	 * Set bformat to false if you want to be able to import it into pwc,
	 * true if you want to be able to read the resulting XML.
	 */
	private static boolean bformat = false;

	/**
	 * Set to SQL or Spanish, depending on the output you require.
	 */
	public static String language = "SQL";

	/**
	 * 	Set if we want to generate the DDL of the tables or not.
	 */
	static boolean bDdl = true;

	/**
	 * 	Set if we want to generate the files with the headers or not.
	 */
	static boolean bFlatfile = true;

	@SuppressWarnings("unused")
	private static boolean firstrun = true;
	private static ArrayList<MAPPING> mappings = new ArrayList<MAPPING>();

	public static void main(String[] args){
		try {
			File fInputFile = new File(sourceFile);
			final JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(fInputFile);
			fc.setDialogTitle("Select the XML of the mapping you want to dissect");
			//fc.showOpenDialog(null);
			
			if(null!=fc.getSelectedFile())
				fInputFile = fc.getSelectedFile();
			POWERMART pwM = new POWERMART();
			try{
				pwM = (POWERMART) JAXB.unmarshal(fInputFile,  POWERMART.class);
			}catch (Exception e){
				throw new UnmarshalException("Error",e);
			}

			if (pwM instanceof POWERMART){
				/*
				 * If the parsed file is a POWERMART object, we can continue and start dissecting.
				 */
				FOLDER folder = new FOLDER();
				for(FOLDER f : pwM.getREPOSITORY().get(0).getFOLDER()){
					/*
					 * We copy the elements of each folder into a new one, so we can access the shortcuts from other mappings etc.
					 */
					folder.getCopy(f);
				}
				/*
				 * We go down the rabbithole...
				 */
				selectTargets(folder);
				try(  PrintWriter out = new PrintWriter( outputPath+"queries.sql" )  ){
					out.println( SQLToExport );
				}catch (Exception e) {
					Main.writeError(e);
				}

				
			}else{
				/*
				 *  ALERT USER OF PARSING ERROR
				 */
				throw new Exception();
			}
		}catch(UnmarshalException e){
			JOptionPane.showMessageDialog(null, "Unable to process the file. \n Please make sure the filename and path are correct.\n"+e.toString());
			System.exit(1);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unable to process the file.\n"+e.toString());
			System.exit(1);
		}

	}

	/**
	 *  This function starts to dissect the workflow, and calls the checkPrev function for each target.
	 * 
	 * 	@param	f	This is the specific folder we ware going to check.
	 */
	private static void selectTargets (FOLDER f){
		List<TARGET> targets = new ArrayList<TARGET>();
		for(MAPPING mOriginal : f.getMAPPING() ){
			/*
			 *  	We add the targets of the folder to an list,
			 *  	so that we keep the original targets separated from the new ones. 
			 * 		We need to check the targetinstancenames since we will
			 * 		use the connectors to browse backwards in the mapping.
			 */
			for(TARGET tgt : f.getTARGET()){
				for(INSTANCE inst : mOriginal.getINSTANCE()){
					if(inst.getTRANSFORMATIONNAME().equals(tgt.getNAME()) ||
							inst.getTRANSFORMATIONNAME().equals("Shortcut_to_"+tgt.getNAME()) ){
						TARGET newTgt = new TARGET(tgt);
						newTgt.setNAME(inst.getNAME());
						targets.add(newTgt);
					}
				}

			}
			/*
			 * 	We start looping the targets and call the checkPrev function for each one.
			 */
			for(TARGET tgt : targets){
				checkPrev(tgt, mOriginal,f);
			}

		}


	}

	/**
	 * 	This function checks the predecessing transformations from the given target, in the 
	 * 	given mapping.
	 * 
	 * 	@param	tgt			The target which will be analyzed.
	 * 	@param	mOriginal	The original mapping.
	 * 	@param 	f			The folder, containing the sources and targets. 
	 */

	private static void checkPrev(TARGET tgt, MAPPING mOriginal,FOLDER f){
		// We look up all the transformations predecessing the target in the original mapping 
		// and store this information in a list.
		List<TRANSFORMATION> transformations = findPredecessor(tgt.getNAME(),mOriginal);
		TARGET newTarget = new TARGET();
		Iterator<TRANSFORMATION> itPreList = transformations.iterator();
		ArrayList<SOURCE> sources = new ArrayList<SOURCE>();
		ArrayList<TARGET> targets = new ArrayList<TARGET>();
		ArrayList<TRANSFORMATION> sqs = new ArrayList<TRANSFORMATION>();
		// We iterate this list
		while(itPreList.hasNext()){
			// We select the next transformation, storing it in the variable 'pre'.
			TRANSFORMATION pre = (TRANSFORMATION) itPreList.next();	
			//System.out.println(pre.getTYPE()+"\n");
			if(pre.getTYPE().equals("Source Qualifier")){
				//TODO 
				/*
				 * In case our transformation is a source qualifier, we know it doesn't have any transformation before this.
				 * We just make a mapping consisting of the Source, the SQtransformation 
				 * and the next transformationsource as target.
				 */
				POWERMART pmSQ = new POWERMART("30-11-2016","1");
				REPOSITORY rep = new REPOSITORY("NEWREP","DB2","Latin1","1");
				FOLDER newFol = new FOLDER(pre.getNAME()+"_folder","","NOTSHARED","EVERIS","","rwx---r--",""); 
				MAPPING newMap = new MAPPING("m_"+pre.getNAME(),"","1","YES","1");
				/*
				 * We search for the source.
				 */
				SOURCE source = new SOURCE();
				INSTANCE instance = new INSTANCE(getInstance(pre.getNAME(), mOriginal));
				if(null!=instance.getASSOCIATEDSOURCEINSTANCE()){
					INSTANCE sourceInstance = new INSTANCE(getInstance(instance.getASSOCIATEDSOURCEINSTANCE().get(0).getNAME(), mOriginal));
					for(SOURCE s : f.getSOURCE()){
						if(s.getNAME().equals(sourceInstance.getTRANSFORMATIONNAME())){
							source = new SOURCE(s);
						}
					}
				}
				newFol.getSOURCE().add(source);
				newFol.getTARGET().add(tgt);
				newMap.getTRANSFORMATION().add(pre);
				for(CONNECTOR c : mOriginal.getCONNECTOR()){
					if(c.getFROMINSTANCETYPE().equals("Source Definition") && c.getFROMINSTANCE().equals(source.getNAME()) && c.getTOINSTANCE().equals(pre.getNAME())){
						newMap.getCONNECTOR().add(c);
					}else
						if(c.getFROMINSTANCE().equals(pre.getNAME()) && c.getFROMINSTANCETYPE().equals("Source Qualifier") && c.getTOINSTANCE().equals(tgt.getNAME())){
							newMap.getCONNECTOR().add(c);
						}


				}
				newMap.getINSTANCE().addAll(createInstances((ArrayList<TARGET>)newFol.getTARGET(), (ArrayList<SOURCE>)newFol.getSOURCE(), null, (ArrayList<TRANSFORMATION>)newMap.getTRANSFORMATION()));
				newFol.getMAPPING().add(newMap);
				rep.getFOLDER().add(newFol);
				pmSQ.getREPOSITORY().add(rep);
				writeToXML(pmSQ);

			}else
				if("Union Transformation".equals(pre.getTEMPLATENAME())){
					//TODO 
					// In case it's an union:
					// We iterate it's groups.
					for(GROUP g : pre.getGROUP()){
						// FOR EACH GROUP, WE NEED:
						// SOURCE: SEARCH CONNECTORS FOR TARGET UNION + FIELD WITH THAT GROUP
						// LOOP TRANSFIELDS FROM UNION, GET NAME WHERE GROUP = GROUP
						// LOOP CONNECTORS, TARGET = TRANSFIELD + UNION
						// CREATE SELECT INSERT FROM PREVIOUS TRANS
						// I.E. EXP - UNIONGR1 - JOINER --> EXP - JOINERSRC
						/*	ArrayList<String> sourceNames = new ArrayList<String>();
						ArrayList<TRANSFORMFIELD> transformfields = new ArrayList<TRANSFORMFIELD>();
						ArrayList<CONNECTOR> newConns = new ArrayList<CONNECTOR>();
						for(TRANSFORMFIELD tf : pre.getTRANSFORMFIELD())
							if(tf.getGROUP().equals(g.getNAME()))
								for(CONNECTOR c : mOriginal.getCONNECTOR())
									if(c.getTOFIELD().equals(tf.getNAME()) && c.getTOINSTANCE().equals(pre.getNAME()))
										for(CONNECTOR cTgt : mOriginal.getCONNECTOR())
											for(FIELDDEPENDENCY fd : pre.getFIELDDEPENDENCY())
												if(tf.getNAME().equals(fd.getINPUTFIELD()))
													if(cTgt.getFROMINSTANCE().equals(pre.getNAME()) && cTgt.getFROMFIELD().equals(fd.getOUTPUTFIELD())){
														newConns.add(new CONNECTOR(c.getFROMFIELD(),"TGT_"+c.getFROMINSTANCE(),"Source Definition",
																"Source Qualifier","SQ_TGT_"+c.getFROMINSTANCE(),fd.getOUTPUTFIELD()));
														newConns.add(new CONNECTOR(tf.getREFFIELD(),"SQ_TGT_"+c.getFROMINSTANCE(),"Source Qualifier",
																"Target Definition",cTgt.getTOINSTANCE(),fd.getOUTPUTFIELD()));
														transformfields.add(tf);
														if(!sourceNames.contains(c.getFROMINSTANCE()))
															sourceNames.add(c.getFROMINSTANCE());
													}
						for(String s : sourceNames){
							TARGET newTgt = new TARGET("TGT_"+s,"1","DB2","1"); 
							for(TRANSFORMFIELD tf : transformfields){
								for(FIELDDEPENDENCY fd : pre.getFIELDDEPENDENCY())
									if(tf.getNAME().equals(fd.getINPUTFIELD())){
										TARGETFIELD tgtf = new TARGETFIELD(transfieldToTgtField(tf));
										tgtf.setNAME(fd.getOUTPUTFIELD());
										newTgt.getTARGETFIELD().add(tgtf);
									}
							}
						}

						mOriginal.getCONNECTOR().addAll(newConns);


						 */


						ArrayList<CONNECTOR> groupConnectors = new ArrayList<CONNECTOR>();
						ArrayList<TRANSFORMATION> groupSourceTrans = new ArrayList<TRANSFORMATION>();
						ArrayList<TRANSFORMFIELD> groupSourceTFs = new ArrayList<TRANSFORMFIELD>();
						ArrayList<TARGET> groupTargets = new ArrayList<TARGET>();
						ArrayList<CONNECTOR> groupTargetConns = new ArrayList<CONNECTOR>();
						ArrayList<TRANSFORMFIELD> unionGroupTfs = new ArrayList<TRANSFORMFIELD>();
						// For all groups except for the one called output 
						// (so all the inputgroups).
						if(!g.getNAME().equals("OUTPUT")){
							// We iterate all the transformfields of the union. 
							for(TRANSFORMFIELD tf : pre.getTRANSFORMFIELD()){
								// We check if the transformfield is part of the currently selected group g.
								if(tf.getGROUP().equals(g.getNAME())){
									// We look for the connector of that specific transformationfield
									// by iterating all the connectors,
									for(CONNECTOR c : mOriginal.getCONNECTOR()){
										// and checking if the toinstance and tofield correspond with what we're looking for.
										if(c.getTOINSTANCE().equals(pre.getNAME()) && c.getTOFIELD().equals(tf.getNAME())){
											// We store this connector in a separate list.
											CONNECTOR newConn = new CONNECTOR(c);
											// We change the name of the targetinstance of this connector to the  
											// given targetname,
											newConn.setTOINSTANCE(tgt.getNAME()+g.getORDER());
											// and we change the type of targetinstance to target definition as well.
											newConn.setTOINSTANCETYPE("Target Definition");
											if(!groupConnectors.contains(newConn))
												groupConnectors.add(newConn);
											// We then look for the transformation from where the connector leaves.
											for(TRANSFORMATION sourceTrans : mOriginal.getTRANSFORMATION()){
												// To do so we iterate the original transformations and compare the frominstancename
												// and doublecheck the instance isn't in our list yet.
												if(c.getFROMINSTANCE().equals(sourceTrans.getNAME()) && !groupSourceTrans.contains(sourceTrans)){
													groupSourceTrans.add(sourceTrans);
													for(TRANSFORMFIELD srcTF : sourceTrans.getTRANSFORMFIELD()){
														if(srcTF.getNAME().equals(c.getFROMFIELD())&&!groupSourceTFs.contains(srcTF)){
															groupSourceTFs.add(srcTF);
														}
													}

												}

											}

										}else
											if(c.getFROMINSTANCE().equals(pre.getNAME()) && c.getFROMFIELD().equals(tf.getNAME().substring(0,tf.getNAME().length() - g.getORDER().length()))){
												/*
												 * We create the connector from the sourcequalifier to the target, and
												 * from the source to the sourcequalifier.
												 */
												CONNECTOR newConn = new CONNECTOR(c);
												newConn.setFROMINSTANCE("SQ_"+tgt.getNAME()+g.getORDER());
												newConn.setFROMFIELD(tf.getNAME());
												newConn.setFROMINSTANCETYPE("Source Qualifier");
												newConn.setTOINSTANCETYPE("Target Definition");
												if(!groupTargetConns.contains(newConn))
													groupTargetConns.add(newConn);

												newConn = new CONNECTOR(c);
												newConn.setTOINSTANCE("SQ_"+tgt.getNAME()+g.getORDER());
												newConn.setTOFIELD(tf.getNAME());
												newConn.setFROMINSTANCE(tgt.getNAME()+g.getORDER());
												newConn.setFROMFIELD(tf.getNAME());
												newConn.setFROMINSTANCETYPE("Source Definition");
												newConn.setTOINSTANCETYPE("Source Qualifier");
												if(!groupTargetConns.contains(newConn))
													groupTargetConns.add(newConn);

												/*
												 * We loop all the targets of the folder and check
												 * if there is a connector going from our transformationname
												 * to the targetname. 
												 */
												for(TARGET t : f.getTARGET()){
													if(t.getNAME().equals(c.getTOINSTANCE())){
														if(!groupTargets.contains(t))
															groupTargets.add(t);
													}
												}
											}
									}
									/*
									 * We save the transformfields of this uniongroup in a list.
									 */
									unionGroupTfs.add(tf);
								}
							}
							/*
							 * 	We add the connectors we created to the original mapping.
							 */
							mOriginal.getCONNECTOR().addAll(groupConnectors);
							mOriginal.getCONNECTOR().addAll(groupTargetConns);
							/*
							 *  We create a new target with the name of the original target followed by the groupnumber,
							 *  which will be used in the modified mapping.
							 */
							TARGET groupTarget = new TARGET(tgt.getNAME()+g.getORDER(),"1","DB2","1");
							for(TRANSFORMFIELD untf : pre.getTRANSFORMFIELD()){
								for(TRANSFORMFIELD tf : unionGroupTfs){
									if(untf.getNAME().equals(tf.getNAME())){
										TARGETFIELD newTgtField = new TARGETFIELD(tf.getNAME(),tf.getDATATYPE(),"NOT A KEY",
												tf.getPRECISION(),tf.getSCALE(),"NULL",tf.getFIELDNUMBER());

										switch (newTgtField.getDATATYPE()){
										case "string" : newTgtField.setDATATYPE("varchar");
										break;
										case "number" : newTgtField.setDATATYPE("integer");

										break;
										case "number(p,s)" : newTgtField.setDATATYPE("integer");

										break;
										case "decimal" :			newTgtField.setDATATYPE("decimal");
										break;
										case "date/time" : 	newTgtField.setDATATYPE("date");
										break;
										case "bigint" : 
											newTgtField.setDATATYPE("bigint");
											break;
										case "double" : 
											newTgtField.setDATATYPE("decimal");
											break;
										case "binary" : newTgtField.setDATATYPE("integer");

										break;
										case "integer" :newTgtField.setDATATYPE("integer");

										break;
										case "nstring" :newTgtField.setDATATYPE("varchar");
										break;
										case "real" :newTgtField.setDATATYPE("integer");
										break;
										case "small integer" :newTgtField.setDATATYPE("varchar");
										break;
										case "text" :newTgtField.setDATATYPE("varchar");
										break;
										default: newTgtField.setDATATYPE(newTgtField.getDATATYPE());
										break;
										}
										groupTarget.getTARGETFIELD().add(newTgtField);
									}
								}
							}
							/*
							 * We add the target to our folder.
							 */
							if(!f.getTARGET().contains(groupTarget))
								f.getTARGET().add(groupTarget);

							tgt.setDATABASETYPE("DB2");
							/*
							 * We create a new source, who will have the same fields
							 * as the target.
							 */
							SOURCE groupSource = targetToSource(groupTarget);
							if(!f.getSOURCE().contains(groupSource))
								f.getSOURCE().add(groupSource);

							/*
							 * 	To make sure that only the target of our group is added to our mapping we need to 
							 * 	create a new targetlist and add it there. This is the group we will pass along later.
							 * 	The same happens with the sources.
							 */
							ArrayList<TARGET> tempTgt = new ArrayList<TARGET>();
							tempTgt.add(tgt);
							sources.add(groupSource);
							ArrayList<SOURCE> tempSrcs = new ArrayList<SOURCE>();
							tempSrcs.add(groupSource);
							/*
							 * We create our PowermartObject with the createMapping function.
							 */
							POWERMART pm = createMapping(tempTgt, null, tempSrcs, mOriginal, g);
							/*
							 * 	We call writeToXML to export the mapping/powermart.
							 */
							writeToXML(pm);


							newTarget = sourceToTarget(groupSource);

							/*
							 * We add the newTarget to our folder
							 */
							if(!f.getTARGET().contains(newTarget))
								f.getTARGET().add(newTarget);
							/*
							 * We continue our travel down the connectors of the original mapping.
							 */
							if(!newTarget.getNAME().startsWith("SQ_")){
								checkPrev(newTarget, mOriginal, f);	
							}
						}
					}

				}
			/*
			 *  We check if the transformation is a router or not. In case it is,
			 *  we will change each router group to a filter.
			 */
				else if(pre.getTYPE().equals("Router")){
					//TODO
					for(GROUP g : pre.getGROUP()){
						/*
						 * 	We check loop every group, except the INPUTgroup.
						 */
						ArrayList<String> targetTrans = new ArrayList<String>();
						ArrayList<TRANSFORMFIELD> tfs = new ArrayList<TRANSFORMFIELD>();
						if(!g.getNAME().equals("INPUT")){
							for(TRANSFORMFIELD tf : pre.getTRANSFORMFIELD())
								if(tf.getGROUP().equals(g.getNAME()))
									for(CONNECTOR c : mOriginal.getCONNECTOR()){
										if(c.getFROMFIELD().equals(tf.getNAME()) && c.getFROMINSTANCE().equals(pre.getNAME())){
											if(!targetTrans.contains(c.getTOINSTANCE()))
												targetTrans.add(c.getTOINSTANCE());
											tfs.add(tf);
										}

									}

							for(String s : targetTrans){
								/*
								 * 	We create a new filtertransformation.
								 */
								TRANSFORMATION newFilter = new TRANSFORMATION("FIL_"+s,"Filter","1","NO","1");
								/*
								 * 	We add the filtercondition to a tableattribute and add it to the transformation.
								 * 	In case there is no condition (i.e. defaultgroup) we set the condition to true.
								 */
								if(null != g.getEXPRESSION()){
									TABLEATTRIBUTE taFC = new TABLEATTRIBUTE("Filter Condition",g.getEXPRESSION()); // la condición del filtro.
									newFilter.getTABLEATTRIBUTE().add(taFC);
								}else{
									TABLEATTRIBUTE taFC = new TABLEATTRIBUTE("Filter Condition","TRUE"); // la condición del filtro.
									newFilter.getTABLEATTRIBUTE().add(taFC);
								}
								TABLEATTRIBUTE taTL	= new TABLEATTRIBUTE("Tracing Level","Normal"); // el tracing level del filtro.
								newFilter.getTABLEATTRIBUTE().add(taTL);

								/*
								 * 	We loop the transformfields of the router and check if it's
								 * 	part of our current group or not.
								 */
								for(TRANSFORMFIELD tf : pre.getTRANSFORMFIELD()){
									if(tf.getGROUP().equals(g.getNAME()) || tf.getGROUP().equals("INPUT")){
										/*
										 * 	We create a new transformfield based on this one, change it's
										 * 	porttype to Input/output, and add it to our filter.
										 */
										TRANSFORMFIELD newTf = new TRANSFORMFIELD(tf);
										if(!pre.getTYPE().equals("Sorter"))
											newTf.setPORTTYPE("INPUT/OUTPUT");
										newFilter.getTRANSFORMFIELD().add(newTf);
									}
								}
								/*
								 * 	We add our new filter to the list of transformations of the original mapping.
								 */
								mOriginal.getTRANSFORMATION().add(newFilter);
								/*
								 * 	We're going to create new connectors for our filter and add it to our mapping.
								 */
								ArrayList<CONNECTOR> newConnectors = new ArrayList<CONNECTOR>();
								boolean cont = false;
								for(CONNECTOR c : mOriginal.getCONNECTOR()){
									for(TRANSFORMFIELD tf : newFilter.getTRANSFORMFIELD()){
										if(tf.getGROUP().equals(g.getNAME())){
											if(c.getTOFIELD().equals(tf.getREFFIELD()) && c.getTOINSTANCE().equals(pre.getNAME())){
												CONNECTOR cNew = new CONNECTOR(c);
												cNew.setTOFIELD(tf.getREFFIELD());
												cNew.setTOINSTANCE(newFilter.getNAME());
												cNew.setTOINSTANCETYPE("Filter");
												newConnectors.add(cNew);	
											}else if(c.getFROMINSTANCE().equals(pre.getNAME()) && c.getFROMFIELD().equals(tf.getNAME()) ){
												CONNECTOR cNew = new CONNECTOR(c);
												cNew.setFROMINSTANCE(newFilter.getNAME());
												cNew.setFROMINSTANCETYPE("Filter");
												cNew.setTOINSTANCETYPE("Target Definition");
												newConnectors.add(cNew);
												/*
												 * 	In case we don't find a connector that comes from our target, 
												 * 	we leave the boolean cont as false.
												 */
												if(tgt.getNAME().equals(c.getTOINSTANCE()))
													cont = true;
											}
										}	
									}
								}
								/*
								 * 	In case we didn't find connectors going from our group to the given target we skip it.
								 */
								if(cont){
									/*
									 * 	We add our new connectors to our original mapping.
									 */
									mOriginal.getCONNECTOR().addAll(newConnectors);
									/*
									 * 	We create a new source based on our new filter.
									 */
									SOURCE source = new SOURCE("TGT_"+pre.getNAME(),"DB2","","","1","","DB2","1");
									for(TRANSFORMFIELD tf : pre.getTRANSFORMFIELD()){
										if(tf.getGROUP().equals("INPUT")){
											source.getSOURCEFIELD().add(transfieldToSrcField(tf));
										}
									}
									/*
									 * 	We create a target based on our previously created source.
									 * 	This target will be used as target for the mapping that will be generated 
									 * 	after this one.	We add ot to our original mapping so we can use it later. 
									 */
									newTarget = sourceToTarget(source);
									if(!f.getTARGET().contains(newTarget))
										f.getTARGET().add(newTarget);

									/*
									 *  We look up all the transformations predecessing our transformation in the original mapping. 
									 */
									List<TRANSFORMATION> preTransformations = findPredecessor(newFilter.getNAME(),mOriginal);
									Iterator<TRANSFORMATION> itPrePreList = preTransformations.iterator();


									/*
									 *  We iterate this list.
									 */
									while(itPrePreList.hasNext()){
										/*
										 *  We store the transformation in variable prepre.
										 */
										TRANSFORMATION prePre = (TRANSFORMATION) itPrePreList.next();
										/*
										 *  And we connect it to the target in the original mapping.
										 */
										mOriginal = connectTargetToTrans (newTarget,prePre, mOriginal);
									}
									/*
									 *  We then call the genPartialMapping function which will process all of the info created before.
									 */
									//genPartialMapping(newFilter,mOriginal,tgt,f,newTarget);
									ArrayList<TARGET> tgts = new ArrayList<TARGET>();
									ArrayList<SOURCE> srcs = new ArrayList<SOURCE>();
									tgts.add(tgt);
									srcs.add(source);
									writeToXML(createMapping(tgts, newFilter, srcs, mOriginal, null));
								}

							}

						}
						/*
						 * In case the next target isn't a sourcequalifier, we continue our loop.
						 */
						if(null != newTarget.getNAME() && !newTarget.getNAME().startsWith("SQ_")){
							checkPrev(newTarget, mOriginal, f);	
						}
					}
				}else 
					if(pre.getTYPE().equals("Joiner")){
						//TODO
						/*
						 * Going to create a whole mapping from zero here and pass it to writeXML,
						 * since we need to generate separate instances etc, too much hassle to do it 
						 * in an other way at the moment
						 */
						POWERMART pmJoin = new POWERMART("30-11-2016","1");
						REPOSITORY rep = new REPOSITORY("NEWREP","DB2","Latin1","1");
						FOLDER newFol = new FOLDER(pre.getNAME()+"_folder","","NOTSHARED","EVERIS","","rwx---r--",""); 
						MAPPING newMap = new MAPPING("m_"+pre.getNAME(),"","1","YES","1");
						ArrayList<TRANSFORMATION> sourceTransformations = new ArrayList<TRANSFORMATION>();
						ArrayList<CONNECTOR> conns = new ArrayList<CONNECTOR>();
						int i = 0;
						/*
						 * 	We start of by searching the connectors from our original joiner
						 * 	so we can find it's source and target. We create new connectors with
						 * 	the information we found. We will add an integer behind our source and
						 * 	targetnames, so we can distinguish our different sources.
						 */
						for(CONNECTOR c : mOriginal.getCONNECTOR()){
							if(c.getTOINSTANCE().equals(pre.getNAME())){
								for(TRANSFORMATION t : mOriginal.getTRANSFORMATION()){
									if(c.getFROMINSTANCE().equals(t.getNAME())){
										if(!sourceTransformations.contains(t)){
											i++;
											sourceTransformations.add(t);
										}
										CONNECTOR copy = new CONNECTOR(c);
										copy.setTOINSTANCE("SQ_TGT_"+pre.getNAME()+i);
										copy.setTOINSTANCETYPE("Source Qualifier");
										copy.setFROMFIELD(c.getTOFIELD());
										copy.setFROMINSTANCE("TGT_"+pre.getNAME()+i);
										copy.setFROMINSTANCETYPE("Source Definition");
										conns.add(copy);
										copy = new CONNECTOR(c);
										copy.setFROMINSTANCE("SQ_TGT_"+pre.getNAME()+i);
										copy.setFROMINSTANCETYPE("Source Qualifier");
										copy.setFROMFIELD(c.getTOFIELD());
										conns.add(copy);



									}
								}
							}
						}
						/*
						 * 	We doublecheck we found transformations predecessing our joiner. 
						 */
						if(!sourceTransformations.isEmpty()){
							i = 0;
							for(TRANSFORMATION sourceTrans : sourceTransformations){
								i++;
								/*
								 *  We create a source for each sourcetransformation,
								 *  based on our joiner. 
								 */
								SOURCE src = new SOURCE(createSource(sourceTrans));
								/*	
								 * We create a target for the sourcetrans,
								 * and rename it (targetname followed by int).
								 */
								TARGET t = new TARGET(sourceToTarget(src));
								if(!f.getTARGET().contains(t)){
									f.getTARGET().add(t);
								}
								mOriginal = connectTargetToTrans (t,sourceTrans, mOriginal);
								t.setNAME(t.getNAME()+i);
								/*
								 *  We add the target to our original folder.
								 */
								if(!newFol.getTARGET().contains(t)){
									targets.add(t);
								}
								/*
								 *  We add the source to our new folder.
								 */
								if(!newFol.getSOURCE().contains(src)){
									newFol.getSOURCE().add(src);
									sources.add(src);
								}
								/*
								 *  We create a sourceQualifier for our source, rename it
								 *  and add it to our list and new mapping.
								 */
								TRANSFORMATION sq = new TRANSFORMATION(createSQ(src));
								sq.setNAME(sq.getNAME()+i);
								newMap.getTRANSFORMATION().add(sq);
								sqs.add(sq);

								/*
								 * We create our instances for the source and sourcequalifier,
								 * and add them to our new mapping.
								 */
								newMap.getINSTANCE().add(new INSTANCE("DB2",src.getNAME()+i,"SOURCE","NO","Source Definition",src.getNAME()));
								mOriginal.getINSTANCE().add(new INSTANCE("DB2",src.getNAME()+i,"SOURCE","NO","Source Definition",src.getNAME()));
								INSTANCE inst = new INSTANCE(sq.getNAME(),"TRANSFORMATION",null,"Source Qualifier",sq.getNAME());
								ASSOCIATEDSOURCEINSTANCE asso = new ASSOCIATEDSOURCEINSTANCE(src.getNAME()+i);
								inst.getASSOCIATEDSOURCEINSTANCE().add(asso);
								newMap.getINSTANCE().add(inst);
								mOriginal.getINSTANCE().add(inst);

								/*
								 *  We create the connectors to our target.
								 */
								for(SOURCEFIELD sf : src.getSOURCEFIELD()){
									for(CONNECTOR c : mOriginal.getCONNECTOR()){
										if(c.getFROMINSTANCE().equals(pre.getNAME()) && c.getFROMFIELD().equals(sf.getNAME())){
											c.setTOINSTANCETYPE("Target Definition");
											if(!conns.contains(c))
												conns.add(c);
										}
									}

								}

							}
							/*
							 *  We add the target of our joiner to the new folder.
							 */
							if(!newFol.getTARGET().contains(tgt))
								newFol.getTARGET().add(tgt);
							newMap.getINSTANCE().add(new INSTANCE(tgt.getNAME(),"TARGET","NO","Target Definition",tgt.getNAME()));
							/*
							 *  We add the joiner to our new mapping.
							 */
							newMap.getTRANSFORMATION().add(pre);
							newMap.getINSTANCE().add(new INSTANCE(pre.getNAME(),"TRANSFORMATION","NO","Joiner",pre.getNAME()));

							/*
							 *  We add our connectors to the mapping.
							 */
							newMap.getCONNECTOR().addAll(conns);

							/*
							 * 	We add the mapping to our new folder, the folder to 
							 * 	our new repository, and the repository to our powermart,
							 * 	after which we export it to XML.
							 */
							newFol.getMAPPING().add(newMap);
							rep.getFOLDER().add(newFol);
							pmJoin.getREPOSITORY().add(rep);
							writeToXML(pmJoin);


							/*
							 * 	We create a new target based on our joiner.
							 */
							newTarget = sourceToTarget(createSource(pre));
							if(!newTarget.getNAME().startsWith("SQ_")){
								checkPrev(newTarget, mOriginal, f);	
							}

						}
					}else{
						/*
						 *  In case our transformation isn't an union (or later also a router),
						 *  we create a source based on our transformation.
						 */
						SOURCE source = createSource(pre);

						/*
						 * 	We create a target based on this source.
						 */
						newTarget = sourceToTarget(source);

						/*
						 *  In case the target hasn't been added to our folder yet, we add it.
						 */
						if(!f.getTARGET().contains(newTarget))
							f.getTARGET().add(newTarget);

						/*
						 *  We look up all the transformations predecessing our transformation in the original mapping. 
						 */
						List<TRANSFORMATION> preTransformations = findPredecessor(pre.getNAME(),mOriginal);
						Iterator<TRANSFORMATION> itPrePreList = preTransformations.iterator();

						/*
						 *  We iterate this list.
						 */
						while(itPrePreList.hasNext()){
							/*
							 *  We store the transformation in variable prepre.
							 */
							TRANSFORMATION prePre = (TRANSFORMATION) itPrePreList.next();
							/*
							 *  And we connect it to the target in the original mapping.
							 */
							mOriginal = connectTargetToTrans (newTarget,prePre, mOriginal);
						}
						/*
						 *  We then call the genPartialMapping function which will process all of the info created before.
						 */

						genPartialMapping(pre,mOriginal,tgt,f,newTarget);
						/*
						 *  In case the targetname doesn't contain SQ_ we can assume it's not a sourceQualifier
						 *  and in this case we want to call ourselves again, passing the newTarget as the new Target.
						 */
						if(!pre.getNAME().startsWith("SQ_")){
							checkPrev(newTarget, mOriginal, f);	
						}
					}
		}
	}

	/**
	 * 	This function generates different parts of a mapping, with the given data.
	 * 	
	 * 	@param	pre			The transformation which will be the base of the new mapping.
	 * 	@param	mOriginal	The original mapping.
	 * 	@param	tgt			The target of this mapping.
	 * 	@param	f			The folder.
	 * 	@param	newTarget	The target which will be used to create the source of this mapping.
	 * 	
	 */
	private static void genPartialMapping (TRANSFORMATION pre,MAPPING mOriginal,TARGET tgt,FOLDER f,TARGET newTarget){
		ArrayList<TARGET> targets = new ArrayList<TARGET>();
		ArrayList<SOURCE> sources = new ArrayList<SOURCE>();
		// With the given transformation we create a new source.
		SOURCE source = createSource(pre);

		// With this new source we create a new Target.
		newTarget = sourceToTarget(source);
		newTarget.setNAME("TGT_"+pre.getNAME());

		// We add this new target to our folder.
		// We will compose a list of targetnames to make sure we don't have duplicates
		List<String> checkTargetList = new ArrayList<String>();
		for(TARGET checkDUB : f.getTARGET()){
			checkTargetList.add(checkDUB.getNAME());
		}
		// In case the target hasn't been added to our folder yet, we add it.
		if(!checkTargetList.contains(newTarget.getNAME()))
			f.getTARGET().add(newTarget);

		// We look for the transformations predecessing the our basetransformation, and store them in a list.
		List<TRANSFORMATION> preTransformations = findPredecessor(pre.getNAME(),mOriginal);
		Iterator<TRANSFORMATION> itPrePreList = preTransformations.iterator();

		// We iterate this list and connect each of these transformations to the newly created target.
		while(itPrePreList.hasNext()){
			TRANSFORMATION prePre = (TRANSFORMATION) itPrePreList.next();
			mOriginal = connectTargetToTrans (newTarget,prePre, mOriginal);
		}

		// We create a mapping with this target, source and the updated mapping,
		// after which we will write it to XML.
		targets.add(tgt);
		sources.add(source);

		POWERMART pm = createMapping(targets, pre, sources,mOriginal,null);
		writeToXML(pm);
	}

	/**
	 * 	This function creates a new powermart based on the parts we generated before.
	 * 
	 * 	@param	targets		The targets of the mapping.
	 * 	@param	pre			The transformation which will be the base of the mapping.
	 * 	@param	sources		The sources of the mapping.
	 * 	@param 	mapping		The mapping itself
	 * 	@param 	g			The group of the transformation we are processing.
	 * 	@return				a POWERMART-object based on the mapping generated before.
	 */
	static POWERMART createMapping(ArrayList<TARGET> targets,TRANSFORMATION pre,ArrayList<SOURCE> sources,MAPPING mapping, GROUP g){
		// We create a new mapping, folder, repository and powermart with the given data.
		MAPPING newMapping = new MAPPING();
		FOLDER newFolder = new FOLDER();
		REPOSITORY newRep = new REPOSITORY("NEWREP","DB2","Latin1","1");
		POWERMART pm = new POWERMART("30-11-2016","1");
		ArrayList<TRANSFORMATION> sqs = new ArrayList<TRANSFORMATION>();

		// In case the given transformation isn't null
		if(null != pre){
			// we name the new mapping and folder based on the transformation
			newMapping = new MAPPING("m_"+ pre.getNAME(),"","1","YES","1");
			newFolder = new FOLDER(pre.getNAME()+"_folder","","NOTSHARED","EVERIS","","rwx---r--",""); //UUID, last param, could be necessary, 55cd59eb-588d-4840-8dee-97c3257a4945
		}
		// otherwise we name the mapping and folder after the given target.
		else{
			newMapping = new MAPPING("m_"+ sources.get(0).getNAME(),"","1","YES","1");
			newFolder = new FOLDER(sources.get(0).getNAME()+"_folder","","NOTSHARED","EVERIS","","rwx---r--",""); //UUID, last param, could be necessary, 55cd59eb-588d-4840-8dee-97c3257a4945
		}


		/*
		 * Source: we add the new source to the newly created folder.
		 */
		for(SOURCE source : sources){
			for(SOURCEFIELD sf : source.getSOURCEFIELD()){
				switch (sf.getDATATYPE()){
				case "string" : sf.setDATATYPE("varchar");
				break;
				case "number" : sf.setDATATYPE("integer");
				sf.setLENGTH("11");
				break;
				case "decimal" : sf.setLENGTH("17");
				sf.setDATATYPE("decimal");
				break;
				case "date/time" : 	sf.setDATATYPE("date");
				sf.setLENGTH("29");
				break;
				case "bigint" : sf.setLENGTH("19");
				sf.setDATATYPE("bigint");
				break;
				case "double" : sf.setLENGTH("15");
				sf.setDATATYPE("decimal");
				break;
				case "binary" : sf.setDATATYPE("integer");
				sf.setLENGTH("19");
				break;
				case "integer" :sf.setDATATYPE("integer");
				sf.setLENGTH("10");
				break;
				case "nstring" :sf.setDATATYPE("varchar");
				break;
				case "real" :sf.setDATATYPE("integer");
				break;
				case "small integer" :sf.setDATATYPE("varchar");
				break;
				case "text" :sf.setDATATYPE("varchar");
				break;
				default: sf.setDATATYPE(sf.getDATATYPE());
				break;
				}
				sf.setUSAGEFLAGS("");
			}
			newFolder.getSOURCE().add(source);

			/*
			 * Source Qualifier: we add the new sourcequalifier to the mapping
			 */
			TRANSFORMATION sq = new TRANSFORMATION() ;
			if(null != pre){
				sq = createSQ(pre);	
				newMapping.getTRANSFORMATION().add(sq);
			}else{
				sq = createSQ(source);
				for(TRANSFORMFIELD tf : sq.getTRANSFORMFIELD()){
					tf.setNAME(tf.getNAME());
					if(tf.getDATATYPE().equals("varchar"))
						tf.setDATATYPE("string");
				}
				newMapping.getTRANSFORMATION().add(sq);
			}
			sqs.add(sq);
		}
		/*
		 * Target: we add the new target to the newly created folder.
		 */
		for(TARGET target : targets){
			target.setDATABASETYPE("DB2");
			for(TARGETFIELD tf : target.getTARGETFIELD())
				if(tf.getDATATYPE().equals("string"))
					tf.setDATATYPE("varchar");
				else if(tf.getDATATYPE().equals("int"))
					tf.setDATATYPE("integer");
				else if(tf.getDATATYPE().equals("number"))
					tf.setDATATYPE("integer");
				else if(tf.getDATATYPE().equals("number(p,s"))
					tf.setDATATYPE("integer");

			newFolder.getTARGET().add(target);
		}
		/*
		 * Transformation: in case the transformation isn't null, we add it to the mapping.
		 */
		if(null != pre){
			newMapping.getTRANSFORMATION().add(pre);
		}

		/*
		 * Connectors: we create connectors for our target, source, transformation and sourcequalifier
		 * and add them to our mapping.
		 */
		newMapping.getCONNECTOR().addAll(createConnectors(targets,sources,pre,sqs,mapping,g));

		/*
		 *  Instances: we create instances for our target, source, transformation and sourcequalifier
		 *  and add them to our mapping.
		 */
		for(INSTANCE inst : createInstances(targets,sources,pre,sqs)){
			if(!newMapping.getINSTANCE().contains(inst)){
				newMapping.getINSTANCE().add(inst);
			}

		}


		/*
		 * Targetloadorder: we create a targetloadorder for our target and add it to the mapping.
		 */
		for(TARGET target : targets){
			TARGETLOADORDER tglo = new TARGETLOADORDER();
			tglo = new TARGETLOADORDER();
			tglo.setORDER("1");
			tglo.setTARGETINSTANCE(target.getNAME());
			newMapping.getTARGETLOADORDER().add(tglo);
		}
		/*
		 * No info for the mapping on the following subjects 
		 * NO mappingdependencies
		 * NO erpvalue
		 * NO mappingvariable
		 * NO metadataextension
		 */

		/*
		 * We add the mapping to the folder, add the folder to the repository, 
		 * the repository to the powermart and return the powermart.
		 */
		newFolder.getMAPPING().add(newMapping);
		newRep.getFOLDER().add(newFolder);
		pm.getREPOSITORY().add(newRep);

		return pm;

	}

	/**
	 * 	This function will return a list of transformations that are the sources of the given transformation name.
	 * 	
	 * 	@param	transName	The name of the transformation.
	 * 	@param	mOriginal	The original mapping, from which we will use it's connectors.
	 * 	@return				A list of TRANSFORMATION-objects
	 */
	private static List<TRANSFORMATION> findPredecessor (String transName,MAPPING mOriginal){
		List<TRANSFORMATION> tgtPreList = new ArrayList<TRANSFORMATION>();
		// We loop the connectors of the original mapping.
		for(CONNECTOR c : mOriginal.getCONNECTOR()){
			// We check if the toinstance is equal to the transformationname.
			if(c.getTOINSTANCE().equals(transName)){
				// In case it is, we loop the transformations from the original mapping 
				for(TRANSFORMATION t : mOriginal.getTRANSFORMATION()){
					// and in case thee frominstance of our connector equals the transformation name 
					// and it hasn't been added before to our list, we add it.
					if(c.getFROMINSTANCE().equals(t.getNAME()) && !tgtPreList.contains(t)){
						tgtPreList.add(t);
					}
				}
			}
		}
		// We return our list of transformations containing all the predecessors.
		return tgtPreList;
	}  

	/**
	 *	This function creates a SOURCE-objects based on a transformation.
	 *	
	 *	@param	t	The transformation used as a base.
	 *	@return		The generated SOURCE-object.
	 */
	private static SOURCE createSource (TRANSFORMATION t){
		/*
		 * We create an integer that keeps the physicaloffset between the fields, 
		 * and one that keeps count of the fieldnumber.
		 */
		Integer physicaloffset = 0;
		Integer fieldNumber = 1;
		SOURCE s = new SOURCE();

		/*
		 *	In case our transformation is a sourcequalifier, we name the source like the sourcequalifier. 
		 *	Otherwise we name it 'TGT_' followed with the name of the transformation 
		 */
		if(t.getNAME().startsWith("SQ_"))
			s = new SOURCE(t.getNAME(),"DB2","","","1","OWNERNAME","DB2","1");
		else
			s = new SOURCE("TGT_"+t.getNAME(),"DB2","","","1","OWNERNAME","DB2","1");

		/*
		 * 	We loop over each of the transformation transformfields and check if it's
		 * 	an input, input/output or output-port. Depending on this information we know
		 * 	if we have to add it to the source or not.
		 */
		for(TRANSFORMFIELD tf : t.getTRANSFORMFIELD()){
			if(tf.getPORTTYPE().contains("INPUT")){
				/*
				 * SOURCEFIELDS: the transformationfield is an inputport, so we create a new sourcefield, 
				 * we update the physicaloffset and fieldnumber.
				 */
				SOURCEFIELD sf = new SOURCEFIELD(tf.getNAME(),"","",tf.getDATATYPE(),"NOT A KEY",tf.getPRECISION(),"0","NULL","","0","ELEMITEM","",
						"0",tf.getPRECISION(),Integer.toString(physicaloffset),tf.getPRECISION(),Integer.toString(fieldNumber),"0","NO");
				physicaloffset = physicaloffset +Integer.parseInt(tf.getPRECISION());
				fieldNumber ++;
				/*
				 * We convert the datatype if necessary from pwc to DB notation.
				 */
				switch (tf.getDATATYPE()){
				case "string" : sf.setDATATYPE("varchar");
				break;
				case "number" : sf.setDATATYPE("integer");
				sf.setLENGTH("11");
				break;
				case "decimal" : sf.setLENGTH("17");
				sf.setDATATYPE("decimal");
				break;
				case "date/time" : 	sf.setDATATYPE("date");
				sf.setLENGTH("29");
				break;
				case "bigint" : sf.setLENGTH("19");
				sf.setDATATYPE("bigint");
				break;
				case "double" : sf.setLENGTH("15");
				sf.setDATATYPE("decimal");
				break;
				case "binary" : sf.setDATATYPE("integer");
				sf.setLENGTH("19");
				break;
				case "integer" :sf.setDATATYPE("integer");
				sf.setLENGTH("10");
				break;
				case "nstring" :sf.setDATATYPE("varchar");
				break;
				case "real" :sf.setDATATYPE("integer");
				break;
				case "small integer" :sf.setDATATYPE("varchar");
				break;
				case "text" :sf.setDATATYPE("varchar");
				break;
				default: sf.setDATATYPE(tf.getDATATYPE());
				break;
				}
				/*
				 * We add the new sourcefield to the source.
				 */
				s.getSOURCEFIELD().add(sf);

			}
		}

		/* 
		 * We return the new source.
		 */
		return s;
	}

	/**
	 *	This function creates a SourceQualifier TRANSFORMATION-object based on the given transformation.
	 *
	 *	@param 	t	The transformation used as base.
	 *	@return		The generated TRANSFORMATION-object.
	 */
	private static TRANSFORMATION createSQ (TRANSFORMATION t){
		// We create a new transformation that will be our sourcequalifier.
		TRANSFORMATION sq = new TRANSFORMATION("SQ_"+t.getNAME(),"Source Qualifier","1","NO","1");
		TABLEATTRIBUTE ta;

		/*
		 * 	We add all the transformfields that are input from the original transformation 
		 * 	to our new one,	and set all the porttypes to input/output.
		 */
		for(TRANSFORMFIELD tf : t.getTRANSFORMFIELD()){
			if(tf.getPORTTYPE().contains("INPUT")){
				TRANSFORMFIELD tnew = new TRANSFORMFIELD(tf);
				tnew.setPORTTYPE("INPUT/OUTPUT");
				sq.getTRANSFORMFIELD().add(tnew);
			}
		}

		/*
		 * We create the necessary tableattributes for our transformation.
		 */
		ta = new TABLEATTRIBUTE("SQL Query","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("User Defined Join","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Source Filter","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Number Of Sorted Ports","0");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Tracing Level","Normal");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Select Distinct","NO");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Is Partitionable","NO");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Pre SQL","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Post SQL","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Output is deterministic","NO");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Output is repeatable","NEVER");
		sq.getTABLEATTRIBUTE().add(ta);

		return sq;
	}

	/**
	 *	This function creates a SourceQualifier TRANSFORMATION-object based on the given SOURCE-object.
	 *
	 *	@param 	src	The SOURCE used as base.
	 *	@return		The generated TRANSFORMATION-object.
	 */
	static TRANSFORMATION createSQ (SOURCE src){
		// We create our new transformation-object that will hold our sourcequalifier.
		TRANSFORMATION sq = new TRANSFORMATION("SQ_"+src.getNAME(),"Source Qualifier","1","NO","1");
		TABLEATTRIBUTE ta;

		/*
		 * For each sourcefield we create a transformationfield and set it's settings.
		 */
		for(SOURCEFIELD sf : src.getSOURCEFIELD()){
			TRANSFORMFIELD tnew = new TRANSFORMFIELD(sf.getNAME(),"string","INPUT/OUTPUT",sf.getPRECISION(),sf.getSCALE());
			switch(sf.getDATATYPE()){
			case "varchar" : tnew.setDATATYPE("string");
			break;
			default: tnew.setDATATYPE(sf.getDATATYPE());
			break;

			}
			tnew.setPORTTYPE("INPUT/OUTPUT");
			sq.getTRANSFORMFIELD().add(tnew);

		}

		/*
		 * We create the necessary tableattributes for our transformation.
		 */
		ta = new TABLEATTRIBUTE("SQL Query","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("User Defined Join","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Source Filter","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Number Of Sorted Ports","0");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Tracing Level","Normal");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Select Distinct","NO");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Is Partitionable","NO");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Pre SQL","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Post SQL","");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Output is deterministic","NO");
		sq.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Output is repeatable","NEVER");
		sq.getTABLEATTRIBUTE().add(ta);

		return sq;
	}

	/**
	 *	This function creates a SOURCE-object based on the given TARGET-object.
	 *
	 *	@param 	t	The TARGET used as base.
	 *	@return		The generated SOURCE-object.
	 */
	private static SOURCE targetToSource(TARGET t){
		// We keep two variables, to store the physicaloffset and the fieldnumber.
		int physicaloffset = 0;
		int fieldnumber = 0;

		// We create our source-object.
		SOURCE s = new SOURCE(t.getNAME(),"DB2","","","1","OWNERNAME","DB2","1");

		/*
		 * For each targetfield we create a new sourcefield, we update the fieldnumber and the physicaloffset,
		 * after which we add the sourcefield to the source.
		 */
		for(TARGETFIELD tf : t.getTARGETFIELD()){
			fieldnumber++;
			SOURCEFIELD sf = new SOURCEFIELD(tf.getNAME(),tf.getBUSINESSNAME(),tf.getDESCRIPTION(),tf.getDATATYPE(),tf.getKEYTYPE(),tf.getPRECISION(),
					tf.getSCALE(),tf.getNULLABLE(),"0","0","ELEMITEM","","0",tf.getPRECISION(),Integer.toString(physicaloffset),tf.getPRECISION(),
					Integer.toString(fieldnumber),"0","NO");
			physicaloffset = physicaloffset + Integer.parseInt(tf.getPRECISION());
			s.getSOURCEFIELD().add(sf);
		}

		// We return our source-object.
		return s;

	}

	/**
	 *	This function creates a TARGET-object based on the given SOURCE-object.
	 *
	 *	@param 	s	The SOURCE used as base.
	 *	@return		The generated TARGET-object.
	 */
	private static TARGET sourceToTarget(SOURCE s){
		// We create a new target-object.
		TARGET t = new TARGET(s.getNAME(),"1","DB2","1");
		/*
		 * We create a new targetfield for each sourcefield.
		 */
		for(SOURCEFIELD sf : s.getSOURCEFIELD()){
			TARGETFIELD tf = new TARGETFIELD(sf.getNAME(),sf.getDATATYPE(),sf.getKEYTYPE(),sf.getPRECISION(),sf.getSCALE(),sf.getNULLABLE(),sf.getFIELDNUMBER());
			switch (tf.getDATATYPE()){
			case "string" : tf.setDATATYPE("varchar");
			break;
			case "number" : tf.setDATATYPE("integer");
			break;
			case "number(p,s)" : tf.setDATATYPE("integer");
			break;
			case "double" : tf.setDATATYPE("decimal");
			break;
			default: tf.setDATATYPE(tf.getDATATYPE());
			}
			t.getTARGETFIELD().add(tf);
		}	
		// We return our new target.
		return t;
	}

	/**
	 * 	This function will connect a given target with it's transformation.
	 * 
	 * 	@param	t							The target we want to connect.
	 * 	@param	sourceTransformation		The transformation we want to connect.
	 * 	@param	oriM						The original mapping.
	 * 	@return								The modified mapping.
	 */
	private static MAPPING connectTargetToTrans(TARGET t, TRANSFORMATION sourceTransformation, MAPPING oriM){
		// We store the original mapping in a local variable.
		MAPPING m = oriM;
		// We loop all the connectors of our original mapping. 
		for(CONNECTOR c : m.getCONNECTOR()){
			/*
			 *  In case the fromInstance is equal with our transformation and the toInstance with our target,
			 *  we can change the toInstance to the transformationname. 
			 */
			if(c.getFROMINSTANCE().equals(sourceTransformation.getNAME()) && t.getNAME().equals("TGT_"+c.getTOINSTANCE())){
				c.setTOINSTANCE(t.getNAME());
			}
		}
		// We add a new instance for our target to the mapping.
		m.getINSTANCE().add(new INSTANCE(t.getNAME(),"Target Instance","NO","TARGET",t.getNAME()));

		// We return the mapping.
		return m;
	}

	/**
	 *	This function creates the necessary connectors for the given data.
	 *
	 *	@param	targets		The targets for which we want to create connectors.
	 *	@param	sources		The sources for which we want to create connectors.
	 *	@param	trns		The transformation for which we want to create connectors.
	 *	@param	sqs			The sourcequalifier-transformations for which we want to create connectors.
	 *	@param	mapping		The	original mapping.
	 *	@param 	g			The group of the transformation.
	 *	@return				An arraylist containing the generated connectors.
	 */
	private static ArrayList<CONNECTOR> createConnectors (ArrayList<TARGET> targets,ArrayList<SOURCE> sources, TRANSFORMATION trns, 
			ArrayList<TRANSFORMATION>sqs,MAPPING mapping, GROUP g){
		ArrayList<CONNECTOR> conns = new ArrayList<CONNECTOR>();

		// In case the given transformation isn't null,  
		if(null != trns){
			// we store the transformation in a local variable.
			TRANSFORMATION t = trns;
			// We loop the transformfields of the transformation.
			for(TRANSFORMFIELD tf : t.getTRANSFORMFIELD()){
				for(SOURCE source : sources){
					if(tf.getPORTTYPE().equals("INPUT")){
						conns.add(new CONNECTOR(tf.getNAME(),source.getNAME(),"Source Definition","Source Qualifier","SQ_"+t.getNAME(),tf.getNAME()));
						conns.add(new CONNECTOR(tf.getNAME(),"SQ_"+t.getNAME(),"Source Qualifier",t.getTYPE(),t.getNAME(),tf.getNAME()));	
					}else 
						/* In case the porttype of the field is output, we look for the connector that connects the field
						 * in our transformation to the target, and change the instancetype of that field to target definition.
						 * We then add the connector to our list.
						 */
						if(tf.getPORTTYPE().equals("OUTPUT") || tf.getPORTTYPE().equals("LOOKUP/OUTPUT")){
							for(TARGET target : targets){
								for(CONNECTOR c : mapping.getCONNECTOR()){
									if(c.getFROMINSTANCE().equals(t.getNAME()) && c.getTOINSTANCE().equals(target.getNAME())){
										c.setTOINSTANCETYPE("Target Definition");
										conns.add(c);
									}
								}
							}
						}else 
							/*
							 * In case the porttype is input/output we create a connector from source to sourcequalifier,
							 * from sourcequalifier to transformation, and from transformation to target, and add all of
							 * them to our list.
							 */
							if(tf.getPORTTYPE().contains("INPUT/OUTPUT")){
								conns.add(new CONNECTOR(tf.getNAME(),source.getNAME(),"Source Definition","Source Qualifier","SQ_"+t.getNAME(),tf.getNAME()));
								conns.add(new CONNECTOR(tf.getNAME(),"SQ_"+t.getNAME(),"Source Qualifier",t.getTYPE(),t.getNAME(),tf.getNAME()));

								for(TARGET target : targets){
									for(CONNECTOR c : mapping.getCONNECTOR()){
										if(c.getFROMINSTANCE().equals(trns.getNAME()) && c.getTOINSTANCE().equals(target.getNAME()) && c.getFROMFIELD().equals(tf.getNAME())){
											if(null == g){
												CONNECTOR tgtConn = new CONNECTOR(tf.getNAME(),t.getNAME(),t.getTYPE(),"Target Definition",target.getNAME(),c.getTOFIELD());
												if(!conns.contains(tgtConn))
													conns.add(tgtConn);
											}else{
												if(tf.getGROUP().equals(g.getNAME())){
													CONNECTOR tgtConn = new CONNECTOR(tf.getNAME(),t.getNAME(),t.getTYPE(),"Target Definition",target.getNAME(),c.getTOFIELD());
													if(!conns.contains(tgtConn))
														conns.add(tgtConn);
												}
											}
										}
									}		
								}
							}
				}
			}
		}else{
			/*
			 * In case we don't have a transformation we connect our sourcequalifiers to the target. 
			 * We create a connector for each transformfield connecting our source with our sourcequalifier and
			 * sourcequalifier with our target. We then add them to our list.
			 */			
			for(SOURCE source : sources){
				for(TRANSFORMATION sq : sqs){
					for(CONNECTOR c : mapping.getCONNECTOR()){
						if(c.getFROMINSTANCE().equals(source.getNAME()) && c.getTOINSTANCE().equals(sq.getNAME())){
							for(SOURCEFIELD sf : source.getSOURCEFIELD()){
								if(c.getFROMFIELD().equals(sf.getNAME()) && !conns.contains(c))
									conns.add(c);
							}
						}else {
							for(TARGET target : targets){
								if(c.getTOINSTANCE().equals(target.getNAME()) && c.getFROMINSTANCE().equals(sq.getNAME())){
									for(TARGETFIELD tf : target.getTARGETFIELD())
										if(tf.getNAME().equals(c.getTOFIELD()))
											if(!conns.contains(c))
												conns.add(c);
								}
							}

						}
					}
				}
			}
		}
		// We return our list of connectors.
		return conns;
	}

	/**
	 * 	This function creates the necessary INSTANCE-objects for our mapping.
	 * 
	 * 	@param	targets		The target for which we want to create an INSTANCE-objects.
	 * 	@param	sources		The source for which we want to create an INSTANCE-objects.
	 * 	@param	trns		The transformation for which we want to create an INSTANCE-objects.
	 * 	@param	sqs			The sourcequalifiertransformation for which we want to create an INSTANCE-objects.
	 * 	@return				An arraylist of INSTANCE-objects containing our generated INSTANCE-objects.		
	 */
	static ArrayList<INSTANCE> createInstances(ArrayList<TARGET> targets, ArrayList<SOURCE> sources, TRANSFORMATION trns, ArrayList<TRANSFORMATION> sqs){
		ArrayList<INSTANCE> instances = new ArrayList<INSTANCE>();

		/*
		 * We create an instance-object for our source, target and sourcequalifier.
		 * We check if we have a transformation or not, in case we do we also create 
		 * an instance for it. We add all these instances to our list.
		 */
		for(SOURCE source : sources){
			INSTANCE insrc = new INSTANCE(source.getNAME(),"SOURCE","NO","Source Definition",source.getNAME());
			insrc.setDBDNAME("DB2");
			instances.add(insrc);
		}
		for(TARGET target : targets){
			instances.add(new INSTANCE(target.getNAME(),"TARGET","NO","Target Definition",target.getNAME()));
		}

		if(null != trns)
			instances.add(new INSTANCE(trns.getNAME(),"TRANSFORMATION","NO",trns.getTYPE(),trns.getNAME()));
		for(TRANSFORMATION sq : sqs){
			INSTANCE insq = new INSTANCE(sq.getNAME(),"TRANSFORMATION","NO",sq.getTYPE(),sq.getNAME());
			ASSOCIATEDSOURCEINSTANCE aso = new ASSOCIATEDSOURCEINSTANCE(sq.getNAME().substring(3));
			insq.getASSOCIATEDSOURCEINSTANCE().add(aso);
			instances.add(insq);
		}
		// We return our list of instances.
		return instances;
	}

	/**
	 * 	This function will look for the instance in the given mapping
	 * 	corresponding with the given name as a string and return it.
	 * 
	 * 	@param	s	String containing the name of the instance we're looking for.
	 * 	@param	m	Mapping in which we want to look for the instance
	 * 	@return		The instance we we're looking for.
	 */

	private static INSTANCE getInstance(String s, MAPPING m){
		for(INSTANCE instance : m.getINSTANCE()){
			if(instance.getNAME().equals(s)){
				return instance;
			}
		}
		return null;
	}



	/**
	 * 	This function will rename the type of the transformation to
	 * 	an incorrect value in case we don't want to print it's details in 
	 * 	the console. This is just used for debugging, if we want to be selective
	 * 	in which kind of transformation we want to analyze/output in the console.
	 * 
	 * 	@param	t	The transformation we want to change it's type from (or leave alone).
	 * 	@return		The same transformation with it's type changed (or not).
	 */

	private static TRANSFORMATION writeOrNot(TRANSFORMATION t){
		switch(t.getTYPE()){
		case "Expression" : 
			if(!bPrintExp)
				t.setTYPE("Exp");
			break;
		case "Filter" : 
			if(!bPrintFil)
				t.setTYPE("Fil");
			break;
		case "Aggregator" : 
			if(!bPrintAgg)
				t.setTYPE("Agg");
			break;
		case "Lookup Procedure" : 
			if(!bPrintLkp)
				t.setTYPE("Lkp");
			break;
		case "Joiner" : 
			if(!bPrintJnr)
				t.setTYPE("Jnr");
			break;
		case "Sorter" : 
			if(!bPrintSrt)
				t.setTYPE("Srt");
			break;

		}
		return t;
	}

	/**
	 * 	This function converts the POWERMART-object to XML using the JAXB-library
	 * 
	 * 	@param	pwM	The object we want to convert to XML.
	 */

	public static void writeToXML(POWERMART pwM){
		try{
			if(!mappings.contains(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(0))){
				mappings.add(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(0));
				File file = new File(outputPath+"/xml/"+ pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(0).getNAME() +".XML");
				int i = 1;
				while (file.exists()){
					file = new File(outputPath+"/xml/"+ pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(0).getNAME() +i+".XML");
					i++;
				}
				JAXBContext jaxbContext = JAXBContext.newInstance(POWERMART.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


				jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING,"ISO-8859-1");
				jaxbMarshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<!DOCTYPE POWERMART SYSTEM \"powrmart.dtd\">\n");
				if(bformat){jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);}
				jaxbMarshaller.marshal(pwM,file);
				//jaxbMarshaller.marshal(pwM,System.out);
				/*
				 * 	We call desc to describe the mapping in SQL or Spanish.
				 */
				desc(pwM.getREPOSITORY().get(0).getFOLDER().get(0));
			}

		}catch(JAXBException e){
			Main.writeError(e);
		}

	}

	/**
	 * 	This function will describe the mapping in the given folder in 
	 * 	a SQL query or in Spanish, depending on what's selected on top.
	 * 
	 *  @param	f	The folder which contains the mapping.
	 */

	public static void desc(FOLDER f){
		for(MAPPING m : f.getMAPPING()){
			ArrayList<SOURCE> transSources = new ArrayList<SOURCE>();
			ArrayList<TARGET> transTargets = new ArrayList<TARGET>();
			for(TRANSFORMATION t : m.getTRANSFORMATION()){
				if(!t.getTYPE().equals("Source Qualifier")){
					for(CONNECTOR c : m.getCONNECTOR()){
						if(c.getTOINSTANCE().equals("SQ_"+t.getNAME())){
							for(SOURCE source : f.getSOURCE()){
								if(c.getFROMINSTANCE().equals("TGT_" +t.getNAME()) && !transSources.contains(source)){
									transSources.add(source);
								}
							}
						}else if(c.getTOINSTANCE().startsWith("SQ_TGT_"+t.getNAME())){
							for(SOURCE source : f.getSOURCE()){
								if(c.getFROMINSTANCE().startsWith("TGT_" +t.getNAME()) && !transSources.contains(source)){
									transSources.add(source);
								}
							}
						}else 
							if(c.getFROMINSTANCE().equals(t.getNAME())){

								for(TARGET target : f.getTARGET()){
									if(c.getTOINSTANCE().equals(target.getNAME()) && !transTargets.contains(target)){
										transTargets.add(target);
									}
								}
							}
					}
					/*
					 * We implement a check for unconnected lookups...
					 */
					if(transTargets.isEmpty()){
						for(TRANSFORMFIELD tf : t.getTRANSFORMFIELD()){
							for(TARGET tgt : f.getTARGET()){
								if(null!=tf.getEXPRESSION() && tf.getEXPRESSION().contains(tgt.getNAME())){
									transTargets.add(tgt);
								}
							}
							for(SHORTCUT sc : f.getSHORTCUT()){
								if(null!=tf.getEXPRESSION() && tf.getEXPRESSION().contains(sc.getNAME())){
									for(TARGET tgt : f.getTARGET()){
										if(sc.getREFERENCEDDBD().equals(tgt.getNAME())){
											transTargets.add(tgt);
										}
									}
								}
							}
						}
					}
					t = writeOrNot(t);
					switch(t.getTYPE()){
					case "Expression" : 
						Expression exp = new Expression(t,transSources,transTargets,(ArrayList<CONNECTOR>) m.getCONNECTOR());
						System.out.println("EXPRESSION " + t.getNAME());
						SQLToExport = SQLToExport + "EXPRESSION " + t.getNAME()+"\n";
						exp.toSentence();
						if(bPrintDetails)
							System.out.println(exp.getSentence()+"\n");
						SQLToExport = SQLToExport + "EXPRESSION " + t.getNAME()+"\n";
						break;
					case "Aggregator" : 
						Aggregator agg = new Aggregator(t,transSources,transTargets,(ArrayList<CONNECTOR>) m.getCONNECTOR());
						System.out.println("AGGREGATOR " + agg.getNAME());
						SQLToExport = SQLToExport + "AGGREGATOR " + agg.getNAME()+"\n";
						agg.toSentence();
						if(bPrintDetails)
							System.out.println(agg.getSentence()+"\n");
						SQLToExport = SQLToExport + agg.getSentence()+"\n";
						break;
					case "Filter" : 
						Filter fil = new Filter(t,transSources,transTargets,(ArrayList<CONNECTOR>) m.getCONNECTOR());
						System.out.println("FILTER " + t.getNAME());
						SQLToExport = SQLToExport + "FILTER " + t.getNAME()+"\n";
						fil.toSentence();
						if(bPrintDetails)
							System.out.println(fil.getSentence()+"\n");
						SQLToExport = SQLToExport + fil.getSentence()+"\n";
						break;
					case "Sorter" : 
						Sorter sort = new Sorter(t,transSources,transTargets,(ArrayList<CONNECTOR>) m.getCONNECTOR());
						System.out.println("SORTER" + t.getNAME());
						SQLToExport = SQLToExport + "SORTER" + t.getNAME()+"\n";
						sort.toSentence();
						if(bPrintDetails)
							System.out.println(sort.getSentence()+"\n");
						SQLToExport = SQLToExport + sort.getSentence()+"\n";
						break;
					case "Lookup Procedure" : 
						Lookup lkp = new Lookup(t,transSources,transTargets,(ArrayList<CONNECTOR>) m.getCONNECTOR());
						System.out.println("LOOKUP " + t.getNAME());
						SQLToExport = SQLToExport + "LOOKUP " + t.getNAME()+"\n";
						lkp.toSentence();
						if(bPrintDetails)
							System.out.println(lkp.getSentence()+"\n");
						SQLToExport = SQLToExport + lkp.getSentence()+"\n";
						break;
					case "Joiner" : 
						Joiner jnr = new Joiner(t,transSources,transTargets,(ArrayList<CONNECTOR>) m.getCONNECTOR());
						System.out.println("JOINER " + t.getNAME());
						SQLToExport = SQLToExport + "JOINER " + t.getNAME()+"\n";
						jnr.toSentence();
						if(bPrintDetails)
							System.out.println(jnr.getSentence()+"\n");
						SQLToExport = SQLToExport + jnr.getSentence()+"\n";
						break;

					}

				}else if(t.getTYPE().equals("Source Qualifier")){
					for(CONNECTOR c : m.getCONNECTOR()){
						if(c.getTOINSTANCE().equals(t.getNAME()))
							for(SOURCE s : f.getSOURCE())
								if(s.getNAME().equals(c.getFROMINSTANCE()) && !transSources.contains(s))
									transSources.add(s);
						if(c.getFROMINSTANCE().equals(t.getNAME()))
							for(TARGET tgt : f.getTARGET())
								if(tgt.getNAME().equals(c.getTOINSTANCE()) && !transTargets.contains(tgt))
									transTargets.add(tgt);
					}
					if(!transSources.isEmpty() && ! transTargets.isEmpty()){
					SourceQualifier sq = new SourceQualifier(t,transSources,transTargets,(ArrayList<CONNECTOR>) m.getCONNECTOR());
					System.out.println("SOURCE QUALIFIER" + t.getNAME());
					SQLToExport = SQLToExport + "SOURCE QUALIFIER" + t.getNAME()+"\n";
					sq.toSentence();
					if(bPrintDetails)
						System.out.println(sq.getSentence()+"\n");
					SQLToExport = SQLToExport + sq.getSentence()+"\n";
					}
				}
			}

		}
		if(bDdl){
			for(TARGET t : f.getTARGET())
				generateDDL(t);
			for(SOURCE s : f.getSOURCE())
				generateDDL(s);

		}
		if(bFlatfile){
			for(TARGET t : f.getTARGET())
				generateFile(t);
			for(SOURCE s : f.getSOURCE())
				generateFile(s);
		}

	}

	/**
	 * 	This function will generate the DDL to create the table for sources or targets.
	 * 
	 * 	@param	o	The object which we want to output to SQL. This can be a source or a target.
	 */

	public static void  generateDDL(Object o){
		String ddl = "";
		if(o != null){
			generateFile(o);
			try{
				if(o instanceof SOURCE){
					SOURCE s = new SOURCE();
					s = ((SOURCE) o);
					ddl = "CREATE TABLE " + s.getNAME() +"( \n";
					for(SOURCEFIELD sf : s.getSOURCEFIELD())
						ddl = ddl + sf.getNAME() + " " + sf.getDATATYPE() + "(" + sf.getPRECISION() + "),\n" ;

					ddl = ddl.substring(0, ddl.length()-2) + "\n);";

					try(  PrintWriter out = new PrintWriter( outputPath+"/DDL/DDL_"+ s.getNAME()+".sql" )  ){
						out.println( ddl );
					}catch (Exception e) {
						Main.writeError(e);
					}

				}else if(o instanceof TARGET){
					TARGET t = new TARGET();
					t = ((TARGET) o);
					ddl = "CREATE TABLE " + t.getNAME() +"( \n";
					for(TARGETFIELD tf : t.getTARGETFIELD())
						ddl = ddl + tf.getNAME() + " " + tf.getDATATYPE() + "(" + tf.getPRECISION() + "),\n" ;

					ddl = ddl.substring(0, ddl.length()-2) + "\n);";

					try(  PrintWriter out = new PrintWriter( outputPath+"/DDL/DDL_"+ t.getNAME()+".sql" )  ){
						out.println( ddl );
					}catch (Exception e) {
						Main.writeError(e);
					}
				}	
			}catch(Exception e){
				Main.writeError(e);
			}
		}

	}

	/**
	 * 	This function will generate a file instead of a DDL to create a table.
	 * 
	 * 	@param	o	An object containing the source or the target.
	 */

	public static void generateFile(Object o){
		String ddl = "";
		if(o != null){
			try{
				if(o instanceof SOURCE){
					SOURCE s = new SOURCE();
					s = ((SOURCE) o);

					for(SOURCEFIELD sf : s.getSOURCEFIELD())
						ddl = ddl + sf.getNAME() + ";" ;

					ddl = ddl.substring(0,ddl.lastIndexOf(";"));
					try(  PrintWriter out = new PrintWriter( outputPath+"/File/"+ s.getNAME()+".asc" )  ){
						out.println( ddl );
					}catch (Exception e) {
						Main.writeError(e);
					}

				}else if(o instanceof TARGET){
					TARGET t = new TARGET();
					t = ((TARGET) o);
					for(TARGETFIELD tf : t.getTARGETFIELD())
						ddl = ddl + tf.getNAME() + ";";
					if(0<ddl.length())
						ddl = ddl.substring(0, ddl.lastIndexOf(";"));

					try(  PrintWriter out = new PrintWriter( outputPath+"/File/"+ t.getNAME()+".asc" )  ){
						out.println( ddl );
					}catch (Exception e) {
						Main.writeError(e);
					}
				}	
			}catch(Exception e){
				Main.writeError(e);
			}
		}
	}

	/**
	 * 	This function returns the language variable to calls from other classes.
	 * 	
	 * 	@return		The language variable, which will be SQL or Español.
	 */

	public static String getLanguage() {
		return language;
	}

	private static TARGETFIELD transfieldToTgtField(TRANSFORMFIELD tf){
		TARGETFIELD tgtf = new TARGETFIELD(tf.getNAME(),tf.getDATATYPE(),"NOT A KEY",tf.getPRECISION(),tf.getSCALE(),"NULL",tf.getFIELDNUMBER());

		switch (tgtf.getDATATYPE()){
		case "string" : tgtf.setDATATYPE("varchar");
		break;
		case "number" : tgtf.setDATATYPE("integer");

		break;
		case "number(p,s)" : tgtf.setDATATYPE("integer");

		break;
		case "decimal" :			tgtf.setDATATYPE("decimal");
		break;
		case "date/time" : 	tgtf.setDATATYPE("date");
		break;
		case "bigint" : 
			tgtf.setDATATYPE("bigint");
			break;
		case "double" : 
			tgtf.setDATATYPE("decimal");
			break;
		case "binary" : tgtf.setDATATYPE("integer");

		break;
		case "integer" :tgtf.setDATATYPE("integer");

		break;
		case "nstring" :tgtf.setDATATYPE("varchar");
		break;
		case "real" :tgtf.setDATATYPE("integer");
		break;
		case "small integer" :tgtf.setDATATYPE("varchar");
		break;
		case "text" :tgtf.setDATATYPE("varchar");
		break;
		default: tgtf.setDATATYPE(tgtf.getDATATYPE());
		break;
		}
		return tgtf;

	}
	private static SOURCEFIELD transfieldToSrcField(TRANSFORMFIELD tf){
		/*
		 * We create an integer that keeps the physicaloffset between the fields, 
		 * and one that keeps count of the fieldnumber.
		 */
		Integer physicaloffset = 0;
		Integer fieldNumber = 1;
		SOURCE s = new SOURCE();


		/*
		 * SOURCEFIELDS: the transformationfield is an inputport, so we create a new sourcefield, 
		 * we update the physicaloffset and fieldnumber.
		 */
		SOURCEFIELD sf = new SOURCEFIELD(tf.getNAME(),"","",tf.getDATATYPE(),"NOT A KEY",tf.getPRECISION(),"0","NULL","","0","ELEMITEM","",
				"0",tf.getPRECISION(),Integer.toString(physicaloffset),tf.getPRECISION(),Integer.toString(fieldNumber),"0","NO");
		physicaloffset = physicaloffset +Integer.parseInt(tf.getPRECISION());
		fieldNumber ++;
		/*
		 * We convert the datatype if necessary from pwc to DB notation.
		 */
		switch (tf.getDATATYPE()){
		case "string" : sf.setDATATYPE("varchar");
		break;
		case "number" : sf.setDATATYPE("integer");
		sf.setLENGTH("11");
		break;
		case "decimal" : sf.setLENGTH("17");
		sf.setDATATYPE("decimal");
		break;
		case "date/time" : 	sf.setDATATYPE("date");
		sf.setLENGTH("29");
		break;
		case "bigint" : sf.setLENGTH("19");
		sf.setDATATYPE("bigint");
		break;
		case "double" : sf.setLENGTH("15");
		sf.setDATATYPE("decimal");
		break;
		case "binary" : sf.setDATATYPE("integer");
		sf.setLENGTH("19");
		break;
		case "integer" :sf.setDATATYPE("integer");
		sf.setLENGTH("10");
		break;
		case "nstring" :sf.setDATATYPE("varchar");
		break;
		case "real" :sf.setDATATYPE("integer");
		break;
		case "small integer" :sf.setDATATYPE("varchar");
		break;
		case "text" :sf.setDATATYPE("varchar");
		break;
		default: sf.setDATATYPE(tf.getDATATYPE());
		break;
		}

		return sf;
	}
}




