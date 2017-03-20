package notinuse;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import corp.everis.pwc.moam.Aggregator;
import corp.everis.pwc.moam.Expression;
import corp.everis.pwc.moam.Filter;
import corp.everis.pwc.moam.Joiner;
import corp.everis.pwc.moam.Lookup;
import corp.everis.pwc.moam.Main;
import corp.everis.pwc.moam.Sorter;
import corp.everis.pwc.raw.ASSOCIATEDSOURCEINSTANCE;
import corp.everis.pwc.raw.CONNECTIONREFERENCE;
import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.ERPINFO;
import corp.everis.pwc.raw.FOLDER;
import corp.everis.pwc.raw.GROUP;
import corp.everis.pwc.raw.INSTANCE;
import corp.everis.pwc.raw.MAPPING;
import corp.everis.pwc.raw.PARTITION;
import corp.everis.pwc.raw.POWERMART;
import corp.everis.pwc.raw.REPOSITORY;
import corp.everis.pwc.raw.SCHEDULEINFO;
import corp.everis.pwc.raw.SCHEDULER;
import corp.everis.pwc.raw.SESSION;
import corp.everis.pwc.raw.SESSIONCOMPONENT;
import corp.everis.pwc.raw.SESSIONEXTENSION;
import corp.everis.pwc.raw.SESSTRANSFORMATIONINST;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.SOURCEFIELD;
import corp.everis.pwc.raw.TABLEATTRIBUTE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TARGETLOADORDER;
import corp.everis.pwc.raw.TASK;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;
import corp.everis.pwc.raw.WORKFLOW;

/*
 * 	This is the class that will parse a powermartXMLfile and create
 * 	for each transformation in each mapping a separate workflow and
 * 	in case it's selected, translate it to SQL or Spanish.
 * 
 * 	@author		Yves Delvaulx
 * 	@version	0.1
 */

public class XMLParser {
	//	private static boolean bPrintExp = false;
	//	private static boolean bPrintFil = false;
	//	private static boolean bPrintJnr = false;
	//	private static boolean bPrintLkp = false;
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
	private static String sourceFile = "demofiles/m_CSS55_DATE_UPDATE.XML";
	private static String outputPath = "./demofiles/";
	private static ArrayList<TRANSFORMATION> alTrns;
	@SuppressWarnings("unused")
	private static boolean firstrun = true;
	private static boolean bformat = true;
	public static String language = "SQL";


	public static void main(String[] args){
		ArrayList<POWERMART> pwms = new ArrayList<POWERMART>();
		try {
			// FICHERO DE ENTRADA
			File fInputFile = new File(sourceFile);
			// LEEMOS EL FICHERO DE ENTRADA CON JAXB, buscando el node que corresponde a la clase POWERMART y poniendolo en un objeto.
			POWERMART pwM = (POWERMART) JAXB.unmarshal(fInputFile,  POWERMART.class);



			if (pwM instanceof POWERMART){
				// SI EL OBJECTO EXISTE, VAMOS A DISSECTARLO, MAPPING POR MAPPING.
				for(int i = 0; i<pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().size();i++){
					//pwNEW = dissectWF(pwM,i);
					POWERMART pwNEW = new POWERMART();
					pwNEW.setCREATIONDATE(pwM.getCREATIONDATE());
					pwNEW.setREPOSITORYVERSION(pwM.getREPOSITORYVERSION());
					pwNEW.getREPOSITORY().addAll(dissectWF(pwM,i).getREPOSITORY());
					pwms.add(pwNEW);
				}
			}else{
				// ALERT USER OF PARSING ERROR
				System.out.println("Error parsing the file.");
			}





		} catch (Exception e) {
			Main.writeError(e);
		}

	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//TODO: COMMENT
	
	
	private static POWERMART dissectWF2(POWERMART pwM,int wfI){
		FOLDER folder = pwM.getREPOSITORY().get(0).getFOLDER().get(0);
		MAPPING mapping = pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(wfI);
		ArrayList<TRANSFORMATION> transformations = new ArrayList<TRANSFORMATION>();
		
		for(TARGET target : folder.getTARGET()){
			for(CONNECTOR connector : mapping.getCONNECTOR()){
				if(connector.getTOINSTANCE().equals(target.getNAME())){
					for(TRANSFORMATION transformation : mapping.getTRANSFORMATION()){
						if(connector.getFROMINSTANCE().equals(transformation.getNAME()) && !transformations.contains(transformation)){
							transformations.add(transformation);
						}
					}
				}
			}
			/*
			 * We have the transformations that input into the selected target. 
			 * Now we have to generate the xml and look for it's precessor.
			 */
			for(TRANSFORMATION transformation : transformations){
				nextTransformation(transformation, mapping);
			}
		}
		

		
		
		
		
		
		
		
		
		
		return pwM;
	}

	
	/*
	 * In this function we need to generate/call to generate the XML and look if there's a 
	 * precessor. If there is we call the function again with the precessor's name.
	 */
	private static void nextTransformation(TRANSFORMATION transformation,MAPPING mapping){
		ArrayList<TRANSFORMATION> prevTransformations = new ArrayList<TRANSFORMATION>(); 
		/*
		 * We check what kind of transformation the sourcetransformation is. In case it's 
		 * an Union or Router, we need to convert these to expressions or filters.
		 */
		//TODO: CALL CREATE XML
		
		
		/*
		 * By looping over the connectors we can find out what the previous transformation(s) is/are.
		 */
		for(CONNECTOR connector : mapping.getCONNECTOR()){
			if(connector.getTOINSTANCE().equals(transformation.getNAME())){
				for(TRANSFORMATION prevTransformation : mapping.getTRANSFORMATION()){
					if(connector.getFROMINSTANCE().equals(prevTransformation.getNAME()) && !prevTransformations.contains(prevTransformation)){
						prevTransformations.add(prevTransformation);
					}
				}
			}
		}
		for(TRANSFORMATION prevTransformation : prevTransformations){
			nextTransformation(prevTransformation, mapping);
		}
	}
	
	
	private static void xmlCreator(TRANSFORMATION transformation, MAPPING mapping, TRANSFORMATION tgtTrans){
		/*
		 * We create a source with the same fields as the transformation. The target will be the source
		 * of the previous transformation, passed along in a parameter.
		 */
		
		/*
		 * Source
		 */
		
		/*
		 * Target
		 */
		
		/*
		 * Transformation
		 */
		
		/*
		 * Connectors
		 */
	}
	
	
	private static ArrayList<SOURCE> createSources(TRANSFORMATION trns, MAPPING m){
		ArrayList<SOURCE> sources = new ArrayList<SOURCE>();
		ArrayList<TRANSFORMATION> srcTrans = new ArrayList<TRANSFORMATION>();
		ArrayList<CONNECTOR> usedConns = new ArrayList<CONNECTOR>();
		
		for(CONNECTOR c : m.getCONNECTOR()){
			if(c.getTOINSTANCE().equals(trns.getNAME())){
				for(TRANSFORMATION t : m.getTRANSFORMATION()){
					if(c.getFROMINSTANCE().equals(t.getNAME()) && !srcTrans.contains(t)){
						srcTrans.add(t);
						usedConns.add(c);
					}
				}
			}
		}
		for(TRANSFORMATION t : srcTrans){
			
		}
		
		
		
		
		return sources;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 	This function dissects the workflow. For each transformation it encounters
	 * 	it will call to generate a new workflow with just that object, and
	 * 	translate it to a query or spanish, depending on what's selected.
	 * 
	 * 	@param	pwM	This is the POWERMART-object containing the workflows
	 * 	@param	wfI	This is the specific workflow in this case.
	 * 	@return		This function returns a POWERMART-object with the gneerated workflow.
	 */

	private static POWERMART dissectWF(POWERMART pwM,int wfI){
		POWERMART pm = new POWERMART();
		POWERMART pmTEMP = new POWERMART();
		REPOSITORY rNew = new REPOSITORY();
		FOLDER fNew = new FOLDER();

		ArrayList<String> transNames = new ArrayList<String>();
		alTrns = new ArrayList<TRANSFORMATION>();

		FOLDER f = (FOLDER) pwM.getREPOSITORY().get(0).getFOLDER().get(0);
		MAPPING m = (MAPPING) pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(wfI);

		fNew.setDESCRIPTION(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getDESCRIPTION());
		fNew.setNAME("GENERATED FOLDER");
		fNew.setOWNER(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getOWNER());
		fNew.setPERMISSIONS(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getPERMISSIONS());
		fNew.setSHARED(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getSHARED());
		fNew.setUUID(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getUUID());
		rNew.setCODEPAGE(pwM.getREPOSITORY().get(0).getCODEPAGE());
		rNew.setDATABASETYPE(pwM.getREPOSITORY().get(0).getDATABASETYPE());
		rNew.setNAME(pwM.getREPOSITORY().get(0).getNAME());
		rNew.setVERSION(pwM.getREPOSITORY().get(0).getVERSION());


		rNew.getFOLDER().add(fNew);
		pm.getREPOSITORY().add(rNew);

		//VAMOS A ORDENAR LAS CONNEXIONES DEL MAPPING.
		m = orderConnections(m);

		for(CONNECTOR c : m.getCONNECTOR())
			for(TRANSFORMATION trns : m.getTRANSFORMATION())
				if(c.getFROMINSTANCE().equals(trns.getNAME()) && !trns.getTYPE().equals("Source Qualifier") && !transNames.contains(trns.getNAME())){
					alTrns.add(trns);
					transNames.add(trns.getNAME());
				}



		// VAMOS A CREAR LOS XMLS DE LOS WORKFLOWS NUEVOS
		for(TRANSFORMATION trns : alTrns){
			if("Union Transformation".equals(trns.getTEMPLATENAME())){
				ArrayList<String> alGroupNames = new ArrayList<String>();
				ArrayList<TRANSFORMFIELD> tfs = new ArrayList<TRANSFORMFIELD>();
				String source = "";

				for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD())
					if(!tf.getGROUP().equals("OUTPUT") && !alGroupNames.contains(tf.getGROUP()))
						alGroupNames.add(tf.getGROUP());

				for(String group : alGroupNames){
					TRANSFORMATION newTrans = new TRANSFORMATION();
					for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD()){
						TRANSFORMFIELD tfNew = new TRANSFORMFIELD(tf);
						if(tfNew.getGROUP().equals(group)){
							tfNew.setPORTTYPE("INPUT/OUTPUT");
							tfNew.setGROUP(null);
							tfs.add(tfNew);
							for(CONNECTOR c : m.getCONNECTOR()){
								if(c.getTOINSTANCE().equals(trns.getNAME()) && c.getTOFIELD().equals(tfNew.getNAME()))
									source = c.getFROMINSTANCE();
							}
						}else if(tfNew.getGROUP().equals("OUTPUT")){
							tfNew.setPORTTYPE("OUTPUT");
							tfNew.setGROUP(null);
							tfs.add(tfNew);
						}

					}

					newTrans.getTRANSFORMFIELD().addAll(tfs);
					newTrans.setNAME("EXP_UNGROUP_" +group);
					newTrans.setCOMPONENTVERSION(trns.getCOMPONENTVERSION());
					newTrans.setCRCVALUE(trns.getCRCVALUE());
					newTrans.setDESCRIPTION("New expression transformation based of union-group "+group+", with "+source+" as inputsource.");
					newTrans.setOBJECTVERSION(trns.getOBJECTVERSION());
					newTrans.setREUSABLE(trns.getREUSABLE());
					newTrans.setTYPE("Expression");
					newTrans.setVERSIONNUMBER(trns.getVERSIONNUMBER());

					pmTEMP = new POWERMART();
					pmTEMP = createXML(newTrans, m, f, pwM);

					pm.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE());
					pm.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET());
					pm.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING());
					pm.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW());	
				}
			}else if(trns.getTYPE().equals("Router")){
				// si la transformación es un router queremos crear una exression simple para cada grupo del router.
				// vamos a ver primero cuantos grupos hay, y por cada de estos vamos a crear una transformación.
				ArrayList<String> alGroupNames = new ArrayList<String>();
				for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD()){
					if(!alGroupNames.contains(tf.getGROUP())){
						alGroupNames.add(tf.getGROUP());
					}
				}

				// por cada grupo vamos a crear una transformación/expression.
				for(String s : alGroupNames){
					if(!s.equals("INPUT")){


						TRANSFORMATION tNew = new TRANSFORMATION(); // la nueva transformation.
						TABLEATTRIBUTE taFC = new TABLEATTRIBUTE(); // la condición del filtro.
						TABLEATTRIBUTE taTL	= new TABLEATTRIBUTE(); // el tracing level del filtro.
						// Vamos a guardar cada campo de transformacion de este grupo del router en un arraylist,
						// para que podemos ponerlos en nuestra transformación nueva después.
						ArrayList<TRANSFORMFIELD> alTf = new ArrayList<TRANSFORMFIELD>(); 
						for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD()){
							if(s.equals(tf.getGROUP())){
								tf.setGROUP(null);	// No necesitamos mas el grupo, y no es un attributo en los campos de una expression-transformation.
								tf.setPORTTYPE("INPUT/OUTPUT");
								alTf.add(tf);
							}
						}
						// Ponemos los campos del grupo en la transformación nueva.
						tNew.getTRANSFORMFIELD().addAll(alTf);

						// Rellenamos los otros datos de nuestra transformación nueva con los que tenemos del router.
						tNew.setCOMPONENTVERSION(trns.getCOMPONENTVERSION());
						tNew.setCRCVALUE(trns.getCRCVALUE());
						tNew.setDESCRIPTION("New filter transformation based of router-group "+s+".");
						tNew.setNAME("FIL_"+trns.getNAME()+"_"+s);
						tNew.setOBJECTVERSION(trns.getOBJECTVERSION());
						tNew.setREUSABLE(trns.getREUSABLE());
						tNew.setTYPE("Filter");
						tNew.setVERSIONNUMBER(trns.getVERSIONNUMBER());
						taFC.setNAME("Filter Condition");
						for(GROUP g : trns.getGROUP()){
							if(s.equals(g.getNAME()) && g.getEXPRESSION()!=null){
								taFC.setVALUE(g.getEXPRESSION());
								break;
							}else if(taFC.getVALUE() != null && !g.getNAME().equals("INPUT") && !s.equals(g.getNAME())){
								taFC.setVALUE(taFC.getVALUE()+" AND NOT("+g.getEXPRESSION()+")");
							}else if(!g.getNAME().equals("INPUT") && !s.equals(g.getNAME())){
								taFC.setVALUE("NOT("+g.getEXPRESSION()+")");
							}
						}
						taTL.setNAME("Tracing Level");
						taTL.setVALUE("Normal");
						tNew.getTABLEATTRIBUTE().add(taTL);
						tNew.getTABLEATTRIBUTE().add(taFC);
						// Pasamos nuestra transformación nueva a nuestra function que crea el XML.
						pmTEMP = new POWERMART();
						pmTEMP = createXML(tNew, m, f, pwM);
						pm.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE());
						pm.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET());
						pm.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING());
						pm.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW());
					}
				}
			}else{
				pmTEMP = new POWERMART();
				pmTEMP = createXML(trns,m,f,pwM);
				pm.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE());
				pm.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET());
				pm.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING());
				pm.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().addAll(pmTEMP.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW());
			}
		}
		return pm;
	}


	/*
	 * 	This function will take all the connections from given mapping and 
	 * 	order them from source to target.
	 * 
	 * 	@param	m	The mapping whose connectors we want to sort.
	 * 	@return		The mapping with it's connectors ordered.
	 */

	private static MAPPING orderConnections(MAPPING m){
		Boolean b = true;
		ArrayList<CONNECTOR> alCons = new ArrayList<CONNECTOR>(); 
		ArrayList<CONNECTOR> alConsOld = new ArrayList<CONNECTOR>(); 

		alConsOld.addAll(m.getCONNECTOR());

		//VAMOS A BUSCAR LOS CONNECTORES SIN TARGET, LOS AÑADIMOS A UN ARRAY NUEVO, Y LO BORRAMOS DEL ORIGINAL.
		while( 0 != m.getCONNECTOR().size()){ 
			for(int i = 0; i < m.getCONNECTOR().size();i++){
				b = true;
				for(int j=0; j < m.getCONNECTOR().size();j++){
					if(m.getCONNECTOR().get(i).getTOINSTANCE().equals(m.getCONNECTOR().get(j).getFROMINSTANCE())){
						// EL CONNECTOR TIENE UN TARGET, SALIMOS DE LA BUCLE.
						b = false;
						break;
					}
				}
				// CUANDO LLEGAMOS AQUI ES QUE NO HEMOS ENCONTRADO UN TARGET.
				if(b){
					alCons.add(m.getCONNECTOR().get(i));
					m.getCONNECTOR().remove(i);
					break;
				}
			}
		}
		alCons = reverseOrder(alCons);
		m.getCONNECTOR().clear();
		m.getCONNECTOR().addAll(alCons);

		return m;

	}


	/*
	 * 	This function will reverse the order of the given connectors, 
	 * 	so that they are ordered from target to source.
	 * 
	 * 	@param	conns	An arraylist of the connectors we want to reverse it's order from.
	 * 	@return			The arraylist with it's order reversed.
	 */

	private static ArrayList<CONNECTOR> reverseOrder(ArrayList<CONNECTOR> conns){
		if(conns.size() > 1){
			CONNECTOR cTemp = conns.remove(0);
			reverseOrder(conns);
			conns.add(cTemp);
		}
		return conns;
	}


	/*
	 * 	This function will create the XML that will be the actual mapping/powermart.
	 * 	
	 * 	@param	trns	The transformation we want to generate a mapping from.
	 * 	@param	m		The parent mapping of that transformation.
	 * 	@param 	f		The parent folder of that transformation.
	 * 	@param	pwM		The parent powermartobject of that transformation.
	 * 	@return			A powermart object with the generated mapping.
	 */

	private static POWERMART createXML(TRANSFORMATION trns, MAPPING m, FOLDER f,POWERMART pwM){

		ArrayList<TRANSFORMATION> alSQ = new ArrayList<TRANSFORMATION>();
		ArrayList<TARGET> alTgt = new ArrayList<TARGET>();
		ArrayList<SOURCE> alSrc = new ArrayList<SOURCE>();
		ArrayList<CONNECTOR> alConsNuevo = new ArrayList<CONNECTOR>();
		ArrayList<String> sourceNames = new ArrayList<String>();
		ArrayList<String> tgtNames = new ArrayList<String>();
		@SuppressWarnings("unused")
		ArrayList<TRANSFORMATION> sourceTrans = new ArrayList<TRANSFORMATION>();
		ArrayList<TRANSFORMATION> tgtTrans = new ArrayList<TRANSFORMATION>();
		String temp = "";

		MAPPING newMap  = new MAPPING();
		TARGETLOADORDER tglo = new TARGETLOADORDER();

		for(CONNECTOR c : m.getCONNECTOR())
			if(c.getTOINSTANCE().equals(trns.getNAME()) && !sourceNames.contains(c.getFROMINSTANCE()))
				sourceNames.add(c.getFROMINSTANCE());


		if(sourceNames.isEmpty()){
			if(trns.getDESCRIPTION().length()>18){
				temp = trns.getDESCRIPTION().substring(0,trns.getDESCRIPTION().length()-16);
				temp = temp.substring(temp.lastIndexOf(" ")+1,temp.length());
			}
			sourceNames.add(temp);
		}

		for(String s : sourceNames)
			for(CONNECTOR c : m.getCONNECTOR())
				if(c.getFROMINSTANCE().equals(s) && !tgtNames.contains(c.getTOINSTANCE()))
					tgtNames.add(c.getTOINSTANCE());

		for(String s : tgtNames)
			for(TRANSFORMATION t : m.getTRANSFORMATION())
				if(s.equals(t.getNAME()))
					tgtTrans.add(t);

		if(tgtTrans.isEmpty()){
			alSrc = getSources(trns,m);
		}else{
			alSrc = getSources(tgtTrans.get(0),m);
		}
		alTgt = getTargets(trns,m);
		if(alSrc.size()<1){

			firstrun = true;
			alSrc = getSources(trns,m);
		}
		alSQ = getSQualifiers(alSrc, m);
		alConsNuevo = getConnectors(alSrc, alTgt, alSQ, trns,m);

		for(TARGET t : alTgt){
			tglo = new TARGETLOADORDER();
			tglo.setORDER("1");
			tglo.setTARGETINSTANCE(t.getNAME());
			newMap.getTARGETLOADORDER().add(tglo);
		}


		INSTANCE inNew;
		newMap.setDESCRIPTION("MAPPING GENERATED WITH SCRIPT.");
		newMap.setISVALID("YES");
		newMap.setNAME("m_"+trns.getNAME());
		newMap.setOBJECTVERSION("1");
		newMap.setVERSIONNUMBER("1");
		newMap.getCONNECTOR().addAll(alConsNuevo);
		if(!newMap.getTRANSFORMATION().contains(trns)){
			newMap.getTRANSFORMATION().add(trns);
		}
		if(!newMap.getTRANSFORMATION().contains(alSQ)){
			newMap.getTRANSFORMATION().addAll(alSQ);
		}
		//alSQ = new ArrayList<TRANSFORMATION>();
		//newMap.getMAPDEPENDENCY().add(null);
		ERPINFO erp = new ERPINFO();
		newMap.getERPINFO().add(erp);

		//powermart pw = new powermart();
		POWERMART pmNew = new POWERMART();
		REPOSITORY rNew = new REPOSITORY();
		FOLDER fNew = new FOLDER();
		WORKFLOW wfNew = new WORKFLOW();
		SCHEDULER schNew = new SCHEDULER();
		SCHEDULEINFO siNew = new SCHEDULEINFO();
		TASK tNew = new TASK();
		SESSION sNew = new SESSION();
		SESSTRANSFORMATIONINST stfNew;
		PARTITION pNew;
		//ATTRIBUTE aNew;
		SESSIONEXTENSION seNew;
		CONNECTIONREFERENCE crefNew;

		siNew.setSCHEDULETYPE("ONDEMAND");

		schNew.setDESCRIPTION("");
		schNew.setNAME("Scheduler");
		schNew.setREUSABLE("NO");
		schNew.setVERSIONNUMBER("1");
		schNew.setSCHEDULEINFO(siNew);

		tNew.setDESCRIPTION("");
		tNew.setNAME("Start");
		tNew.setREUSABLE("NO");
		tNew.setTYPE("Start");
		tNew.setVERSIONNUMBER("1");

		int iSessTrnsCounter = 0;
		for(int j = 0; j < alSrc.size();j++){
			stfNew = new SESSTRANSFORMATIONINST();
			stfNew.setISREPARTITIONPOINT("NO");
			stfNew.setPIPELINE("0");
			stfNew.setSINSTANCENAME(alSrc.get(j).getNAME());
			stfNew.setSTAGE(Integer.toString(iSessTrnsCounter));
			stfNew.setTRANSFORMATIONNAME(alSrc.get(j).getNAME());
			stfNew.setTRANSFORMATIONTYPE("Source Definition");
			if(!sNew.getSESSTRANSFORMATIONINST().contains(stfNew)){
				sNew.getSESSTRANSFORMATIONINST().add(stfNew);
			}
			inNew = new INSTANCE();
			inNew.setDBDNAME(alSrc.get(j).getDBDNAME());
			inNew.setDESCRIPTION("");
			inNew.setNAME(alSrc.get(j).getNAME());
			inNew.setTRANSFORMATIONNAME(alSrc.get(j).getNAME());
			inNew.setTRANSFORMATIONTYPE("Source Definition");
			inNew.setTYPE("SOURCE");
			if(!newMap.getINSTANCE().contains(inNew)){
				newMap.getINSTANCE().add(inNew);
				iSessTrnsCounter++;
			}


		}
		for(int j = 0; j < alSQ.size();j++){
			stfNew = new SESSTRANSFORMATIONINST();
			stfNew.setISREPARTITIONPOINT("YES");
			stfNew.setPARTITIONTYPE("PASS THROUGH");;
			stfNew.setPIPELINE("0");
			stfNew.setSINSTANCENAME(alSQ.get(j).getNAME());
			stfNew.setSTAGE(Integer.toString(iSessTrnsCounter));
			stfNew.setTRANSFORMATIONNAME(alSQ.get(j).getNAME());
			stfNew.setTRANSFORMATIONTYPE("Source Qualifier");
			if(!sNew.getSESSTRANSFORMATIONINST().contains(stfNew)){
				sNew.getSESSTRANSFORMATIONINST().add(stfNew);
				iSessTrnsCounter++;
			}

			seNew = new SESSIONEXTENSION();
			seNew.setDSQINSTNAME(alSQ.get(j).getNAME());
			seNew.setDSQINSTTYPE("Source Qualifier");
			seNew.setNAME("Relational Reader");
			seNew.setSINSTANCENAME(alSQ.get(j).getNAME().replace("SQ_", ""));
			seNew.setSUBTYPE("Relational Reader");
			seNew.setTRANSFORMATIONTYPE("Source Definition");
			seNew.setTYPE("READER");
			if(!sNew.getSESSIONEXTENSION().contains(seNew)){
				sNew.getSESSIONEXTENSION().add(seNew);
				iSessTrnsCounter++;
			}
			seNew = new SESSIONEXTENSION();
			seNew.setNAME("Relational Reader");
			seNew.setSINSTANCENAME(alSQ.get(j).getNAME());
			seNew.setSUBTYPE("Relational Reader");
			seNew.setTRANSFORMATIONTYPE("Source Qualifier");
			seNew.setTYPE("READER");

			crefNew = new CONNECTIONREFERENCE();
			crefNew.setCNXREFNAME("DB Connection");
			crefNew.setCONNECTIONNAME("");
			crefNew.setCONNECTIONNUMBER("1");
			crefNew.setCONNECTIONSUBTYPE("");
			crefNew.setCONNECTIONTYPE("Relational");
			crefNew.setVARIABLE("$DBConnectionCSS");

			seNew.getCONNECTIONREFERENCE().add(crefNew);

			if(!sNew.getSESSIONEXTENSION().contains(seNew)){
				sNew.getSESSIONEXTENSION().add(seNew);
				iSessTrnsCounter++;
			}



			inNew = new INSTANCE();
			inNew.setDESCRIPTION("");
			inNew.setNAME(alSQ.get(j).getNAME());
			inNew.setTRANSFORMATIONNAME(alSQ.get(j).getNAME());
			inNew.setTRANSFORMATIONTYPE("Source Qualifier");
			inNew.setTYPE("TRANSFORMATION");
			ASSOCIATEDSOURCEINSTANCE asiNew = new ASSOCIATEDSOURCEINSTANCE();
			asiNew.setNAME(alSQ.get(j).getNAME());

			if(!inNew.getASSOCIATEDSOURCEINSTANCE().contains(asiNew)){
				inNew.getASSOCIATEDSOURCEINSTANCE().add(asiNew);
			}
			if(!newMap.getINSTANCE().contains(inNew)){
				newMap.getINSTANCE().add(inNew);
			}

		}
		for(int j = 0; j < alTgt.size();j++){
			stfNew = new SESSTRANSFORMATIONINST();
			stfNew.setISREPARTITIONPOINT("NO");
			stfNew.setPARTITIONTYPE("PASS THROUGH");;
			stfNew.setPIPELINE("0");
			stfNew.setSINSTANCENAME(alTgt.get(j).getNAME());
			stfNew.setSTAGE(Integer.toString(iSessTrnsCounter));
			stfNew.setTRANSFORMATIONNAME(alTgt.get(j).getNAME());
			stfNew.setTRANSFORMATIONTYPE("Target Definition");

			if(!sNew.getSESSTRANSFORMATIONINST().contains(stfNew)){
				sNew.getSESSTRANSFORMATIONINST().add(stfNew);
			}

			inNew = new INSTANCE();
			inNew.setDESCRIPTION("");
			inNew.setNAME(alTgt.get(j).getNAME());
			inNew.setTRANSFORMATIONNAME(alTgt.get(j).getNAME());
			inNew.setTRANSFORMATIONTYPE("Target Definition");
			inNew.setTYPE("TARGET");
			if(!newMap.getINSTANCE().contains(inNew)){
				newMap.getINSTANCE().add(inNew);
				iSessTrnsCounter++;
			}
		}

		inNew = new INSTANCE();
		inNew.setDESCRIPTION("");
		inNew.setNAME(trns.getNAME());
		inNew.setREUSABLE("NO");
		inNew.setTRANSFORMATIONNAME(trns.getNAME());
		inNew.setTRANSFORMATIONTYPE(trns.getTYPE());
		inNew.setTYPE("TRANSFORMATION");
		if(!newMap.getINSTANCE().contains(inNew)){
			newMap.getINSTANCE().add(inNew);
		}

		pNew = new PARTITION();

		pNew.setDESCRIPTION("");
		pNew.setNAME("Partition #1");

		stfNew = new SESSTRANSFORMATIONINST();
		stfNew.setISREPARTITIONPOINT("NO");
		stfNew.setPIPELINE("0");
		stfNew.setSINSTANCENAME(trns.getNAME());
		stfNew.setSTAGE(Integer.toString(iSessTrnsCounter));
		iSessTrnsCounter = 0;
		stfNew.setTRANSFORMATIONNAME(trns.getNAME());
		stfNew.setTRANSFORMATIONTYPE(trns.getTYPE());
		stfNew.getPARTITION().add(pNew);

		if(!sNew.getSESSTRANSFORMATIONINST().contains(stfNew)){
			sNew.getSESSTRANSFORMATIONINST().add(stfNew);
		}


		sNew.getATTRIBUTE().addAll(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().get(0).getSESSION().get(0).getATTRIBUTE());
		sNew.setDESCRIPTION("");
		sNew.setISVALID("YES");
		sNew.setMAPPINGNAME(newMap.getNAME());
		sNew.setNAME("s_" + newMap.getNAME());
		sNew.setREUSABLE("NO");
		sNew.setSORTORDER("Binary");
		sNew.setVERSIONNUMBER("1");
		sNew.setCONFIGREFERENCE(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().get(0).getSESSION().get(0).getCONFIGREFERENCE());
		for(SESSIONCOMPONENT sc : pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().get(0).getSESSION().get(0).getSESSIONCOMPONENT()){
			if(!sNew.getSESSIONCOMPONENT().contains(sc)){
				sNew.getSESSIONCOMPONENT().add(sc);
			}
		}


		wfNew.setDESCRIPTION("This workflow has been generated from....");
		wfNew.setISENABLED("YES");
		wfNew.setISRUNNABLESERVICE("NO");
		wfNew.setISSERVICE("NO");
		wfNew.setISVALID("YES");
		wfNew.setNAME("wf_"+ trns.getNAME());
		wfNew.setREUSABLESCHEDULER("NO");
		wfNew.setSCHEDULERNAME("Scheduler");
		wfNew.setSERVERNAME(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().get(0).getSERVERNAME());
		wfNew.setSERVERDOMAINNAME(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().get(0).getSERVERDOMAINNAME());
		wfNew.setSUSPENDONERROR("NO");
		wfNew.setTASKSMUSTRUNONSERVER("NO");
		wfNew.setVERSIONNUMBER("1");
		wfNew.setSCHEDULER(schNew);
		wfNew.getTASK().add(tNew);
		wfNew.getSESSION().add(sNew);
		wfNew.getTASKINSTANCE().addAll(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().get(0).getTASKINSTANCE());
		wfNew.getWORKFLOWVARIABLE().addAll(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().get(0).getWORKFLOWVARIABLE());
		wfNew.getATTRIBUTE().addAll(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW().get(0).getATTRIBUTE());

		fNew.setDESCRIPTION(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getDESCRIPTION());
		fNew.setNAME(trns.getNAME());
		fNew.setOWNER(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getOWNER());
		fNew.setPERMISSIONS(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getPERMISSIONS());
		fNew.setSHARED(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getSHARED());
		fNew.setUUID(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getUUID());
		fNew.getTARGET().addAll(alTgt);
		fNew.getSOURCE().addAll(alSrc);
		fNew.getMAPPING().add(newMap);

		fNew.getWORKFLOW().add(wfNew);

		rNew.setCODEPAGE(pwM.getREPOSITORY().get(0).getCODEPAGE());
		rNew.setDATABASETYPE(pwM.getREPOSITORY().get(0).getDATABASETYPE());
		rNew.setNAME(pwM.getREPOSITORY().get(0).getNAME());
		rNew.setVERSION(pwM.getREPOSITORY().get(0).getVERSION());
		rNew.getFOLDER().add(fNew); 



		pmNew.setCREATIONDATE(pwM.getCREATIONDATE());
		pmNew.setREPOSITORYVERSION(pwM.getREPOSITORYVERSION());
		pmNew.getREPOSITORY().add(rNew);

		//System.out.println(pmNew.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE().get(0).getNAME()+" ----> "+pmNew.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(0).getTRANSFORMATION().get(0).getNAME()+" -----> "+pmNew.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0).getNAME());
		desc(pmNew.getREPOSITORY().get(0).getFOLDER().get(0));
		writeToXML(pmNew);
		return pmNew;
	}

	/*
	 * 	This function will return the target(s) for the transformation.
	 * 
	 * 	@param	trns	The transformation whose target(s) we want to generate.
	 * 	@param	m		The parentmapping, which contains all the transformations.
	 * 	@return			An arraylist with all the targetobjects.
	 */

	private static ArrayList<TARGET> getTargets(TRANSFORMATION trns,MAPPING m){
		ArrayList<TARGET> tl = new ArrayList<TARGET>();
		TARGET t = new TARGET();
		for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD()){
			if(tf.getPORTTYPE().contains("OUTPUT")){
				TARGETFIELD tgf = new TARGETFIELD();

				tgf.setBUSINESSNAME("");
				switch (tf.getDATATYPE()){
				case "string" : tgf.setDATATYPE("varchar");
				break;
				case "number" : tgf.setDATATYPE("integer");
				break;
				default: tgf.setDATATYPE(tf.getDATATYPE());
				}
				tgf.setDESCRIPTION("");
				tgf.setFIELDNUMBER("1");
				tgf.setKEYTYPE("NOT A KEY");
				tgf.setNAME(tf.getNAME());
				tgf.setNULLABLE("NULL");
				tgf.setPICTURETEXT("");
				tgf.setPRECISION(tf.getPRECISION());
				tgf.setSCALE(tf.getSCALE());
				t.getTARGETFIELD().add(tgf);
			}
		}
		t.setBUSINESSNAME("");
		t.setCONSTRAINT("");
		t.setDATABASETYPE("DB2");
		t.setDESCRIPTION("GENERATED TARGET FOR " + trns.getNAME() + "-TRANSFORMATION.");
		t.setNAME("TGT_"+trns.getNAME());
		t.setOBJECTVERSION("1");
		t.setTABLEOPTIONS("");
		t.setVERSIONNUMBER("1");

		tl.add(t);

		return tl;
	}

	/*
	 * 	This function will return the source(s) for the transformation.
	 * 
	 * 	@param	trns	The transformation whose source(s) we want to generate.
	 * 	@param	m		The parentmapping, which contains all the transformations.
	 * 	@return			An arraylist with all the sourceobjects.
	 */

	private static ArrayList<SOURCE> getSources(TRANSFORMATION trns,MAPPING m){
		ArrayList<SOURCE> sl = new ArrayList<SOURCE>();
		ArrayList<CONNECTOR> conns = new ArrayList<CONNECTOR>();
		ArrayList<String> sourceInstances = new ArrayList<String>();

		int i = 0;
		boolean masterFlag = false;
		boolean newName = false;

		for(CONNECTOR c : m.getCONNECTOR())
			if(c.getTOINSTANCE().equals(trns.getNAME()))
				conns.add(c);

		for(CONNECTOR c :  conns){
			if(sourceInstances.isEmpty())
				sourceInstances.add(c.getFROMINSTANCE());
			else if(!sourceInstances.contains(c.getFROMINSTANCE())){
				sourceInstances.add(c.getFROMINSTANCE());
			}
		}

		for(int j = 0;j<sourceInstances.size();j++){
			if(sourceInstances.get(j).substring(0,3).equals("SQ_")){
				for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD())
					if(tf.getPORTTYPE().contains("MASTER"))
						masterFlag = true;

				if(!masterFlag){
					SOURCE sNew = new SOURCE();
					for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD()){
						if(tf.getPORTTYPE().contains("INPUT")){
							SOURCEFIELD sf = new SOURCEFIELD();
							sf.setBUSINESSNAME("");
							switch (tf.getDATATYPE()){
							case "string" : sf.setDATATYPE("varchar");
							break;
							case "number" : sf.setDATATYPE("integer");
							sf.setLENGTH("11");
							break;
							case "decimal" : sf.setLENGTH("17");
							sf.setDATATYPE("decimal");
							break;
							case "date/time" : 	sf.setDATATYPE("datetime");
							sf.setLENGTH("29");
							break;
							case "bigint" : sf.setLENGTH("19");
							sf.setDATATYPE("bigint");
							break;
							case "double" : sf.setLENGTH("15");
							sf.setDATATYPE("double");
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

							sf.setDESCRIPTION("");
							sf.setFIELDNUMBER("1");
							sf.setFIELDPROPERTY("0");
							sf.setFIELDTYPE("ELEMITEM");
							sf.setHIDDEN("NO");
							sf.setKEYTYPE("NOT A KEY");
							sf.setLEVEL("0");
							sf.setNAME(tf.getNAME());
							sf.setNULLABLE(null);
							sf.setOCCURS("0");
							sf.setOFFSET("0");
							sf.setPHYSICALLENGTH(tf.getPRECISION());
							sf.setPHYSICALOFFSET("0");
							sf.setPICTURETEXT(tf.getPICTURETEXT());
							sf.setPRECISION(tf.getPRECISION());
							sf.setSCALE(tf.getSCALE());
							sf.setUSAGEFLAGS("");

							sNew.getSOURCEFIELD().add(sf);
						}
					}
					sNew.setBUSINESSNAME("");
					sNew.setDATABASETYPE("ODBC");
					sNew.setDBDNAME("ODBC");
					sNew.setDESCRIPTION("GENERATED SOURCE FOR " + trns.getNAME() + "-TRANSFORMATION.");
					newName = false;
					for(SOURCE s : sl)
						if(s.getNAME().equals("SRC_"+trns.getNAME()))
							newName = true;
					if(!newName){
						i++;
						sNew.setNAME("SRC_"+i+"_"+trns.getNAME());
					}
					sNew.setOBJECTVERSION("1");
					sNew.setOWNERNAME("XDCSS");
					sNew.setVERSIONNUMBER("1");		
					sl.add(sNew);
				}else{
					SOURCE sNew = new SOURCE();
					SOURCE sNewMaster = new SOURCE();
					for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD()){
						if(tf.getPORTTYPE().contains("INPUT")){
							SOURCEFIELD sf = new SOURCEFIELD();
							sf.setBUSINESSNAME("");
							switch (tf.getDATATYPE()){
							case "string" : sf.setDATATYPE("varchar");
							break;
							case "number" : sf.setDATATYPE("integer");
							sf.setLENGTH("11");
							break;
							case "decimal" : sf.setLENGTH("17");
							sf.setDATATYPE("decimal");
							break;
							case "date/time" : 	sf.setDATATYPE("datetime");
							sf.setLENGTH("29");
							break;
							case "bigint" : sf.setLENGTH("19");
							sf.setDATATYPE("bigint");
							break;
							case "double" : sf.setLENGTH("15");
							sf.setDATATYPE("double");
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
							sf.setDESCRIPTION("");
							sf.setFIELDNUMBER("1");
							sf.setFIELDPROPERTY("0");
							sf.setFIELDTYPE("ELEMITEM");
							sf.setHIDDEN("NO");
							sf.setKEYTYPE("NOT A KEY");
							sf.setLEVEL("0");
							sf.setNAME(tf.getNAME());
							sf.setNULLABLE(null);
							sf.setOCCURS("0");
							sf.setOFFSET("0");
							sf.setPHYSICALLENGTH(tf.getPRECISION());
							sf.setPHYSICALOFFSET("0");
							sf.setPICTURETEXT(tf.getPICTURETEXT());
							sf.setPRECISION(tf.getPRECISION());
							sf.setSCALE(tf.getSCALE());
							sf.setUSAGEFLAGS("");
							if(tf.getPORTTYPE().contains("MASTER"))
								sNewMaster.getSOURCEFIELD().add(sf);
							else
								sNew.getSOURCEFIELD().add(sf);
						}
					}
					sNew.setBUSINESSNAME("");
					sNew.setDATABASETYPE("ODBC");
					sNew.setDBDNAME("ODBC");
					sNew.setDESCRIPTION("GENERATED SOURCE FOR " + trns.getNAME() + "-TRANSFORMATION.");
					sNew.setNAME("SRC_"+trns.getNAME());
					sNew.setOBJECTVERSION("1");
					sNew.setOWNERNAME("XDCSS");
					sNew.setVERSIONNUMBER("1");		
					sl.add(sNew);

					sNewMaster.setBUSINESSNAME("");
					sNewMaster.setDATABASETYPE("ODBC");
					sNewMaster.setDBDNAME("ODBC");
					sNewMaster.setDESCRIPTION("GENERATED MASTERSOURCE FOR " + trns.getNAME() + "-TRANSFORMATION.");
					sNewMaster.setNAME("SRC_MASTER_"+trns.getNAME());
					sNewMaster.setOBJECTVERSION("1");
					sNewMaster.setOWNERNAME("XDCSS");
					sNewMaster.setVERSIONNUMBER("1");		
					sl.add(sNewMaster);
				}
			}else{
				for(TRANSFORMATION t : alTrns){
					if(t.getNAME().equals(sourceInstances.get(j))){
						SOURCE sNew = new SOURCE();
						for(TRANSFORMFIELD tf : t.getTRANSFORMFIELD()){
							SOURCEFIELD sf = new SOURCEFIELD();
							sf.setBUSINESSNAME("");
							switch (tf.getDATATYPE()){
							case "string" : sf.setDATATYPE("varchar");
							break;
							case "number" : sf.setDATATYPE("integer");
							sf.setLENGTH("11");
							break;
							case "decimal" : sf.setLENGTH("17");
							sf.setDATATYPE("decimal");
							break;
							case "date/time" : 	sf.setDATATYPE("datetime");
							sf.setLENGTH("29");
							break;
							case "bigint" : sf.setLENGTH("19");
							sf.setDATATYPE("bigint");
							break;
							case "double" : sf.setLENGTH("15");
							sf.setDATATYPE("double");
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
							sf.setDESCRIPTION("");
							sf.setFIELDNUMBER("1");
							sf.setFIELDPROPERTY("0");
							sf.setFIELDTYPE("ELEMITEM");
							sf.setHIDDEN("NO");
							sf.setKEYTYPE("NOT A KEY");
							sf.setLEVEL("0");
							sf.setNAME(tf.getNAME());
							sf.setNULLABLE(null);
							sf.setOCCURS("0");
							sf.setOFFSET("0");
							sf.setPHYSICALLENGTH(tf.getPRECISION());
							sf.setPHYSICALOFFSET("0");
							sf.setPICTURETEXT(tf.getPICTURETEXT());
							sf.setPRECISION(tf.getPRECISION());
							sf.setSCALE(tf.getSCALE());
							sf.setUSAGEFLAGS("");
							sNew.getSOURCEFIELD().add(sf);
						}
						sNew.setBUSINESSNAME("");
						sNew.setDATABASETYPE("ODBC");
						sNew.setDBDNAME("ODBC");
						sNew.setDESCRIPTION("GENERATED SOURCE FOR " + t.getNAME() + "-TRANSFORMATION.");
						sNew.setNAME("SRC_"+t.getNAME());
						sNew.setOBJECTVERSION("1");
						sNew.setOWNERNAME("XDCSS");
						sNew.setVERSIONNUMBER("1");		
						sl.add(sNew);
					}
				}
			}
		}
		return sl;

	}

	/*
	 * 	This function will return the sourcequalifier(s) for the transformation.
	 * 
	 * 	@param	trns	The transformation whose sourcequalifier(s) we want to generate.
	 * 	@param	m		The parentmapping, which contains all the transformations.
	 * 	@return			An arraylist with all the transformationobjects.
	 */

	private static ArrayList<TRANSFORMATION> getSQualifiers(ArrayList<SOURCE> srcs,MAPPING m){
		ArrayList<TRANSFORMATION> sl = new ArrayList<TRANSFORMATION>();
		TABLEATTRIBUTE ta = new TABLEATTRIBUTE();

		for(SOURCE s : srcs){
			TRANSFORMATION sq = new TRANSFORMATION();
			ArrayList<TRANSFORMFIELD> tfl = new ArrayList<TRANSFORMFIELD>();

			sq.setCOMPONENTVERSION("1");
			sq.setDESCRIPTION("Source qualifier for "+s.getNAME().substring(4));
			sq.setNAME("SQ_"+s.getNAME().substring(4));
			sq.setOBJECTVERSION("1");
			sq.setREUSABLE("NO");
			sq.setTYPE("Source Qualifier");
			sq.setVERSIONNUMBER("1");

			for(SOURCEFIELD sf : s.getSOURCEFIELD()){
				TRANSFORMFIELD tf = new TRANSFORMFIELD();


				switch (sf.getDATATYPE()){
				case "varchar" : tf.setDATATYPE("string");
				break;
				default: tf.setDATATYPE(sf.getDATATYPE());
				break;
				}
				tf.setDEFAULTVALUE("");
				tf.setDESCRIPTION("");
				tf.setNAME(sf.getNAME());
				tf.setPICTURETEXT(sf.getPICTURETEXT());
				tf.setPORTTYPE("INPUT/OUTPUT");
				tf.setPRECISION(sf.getPRECISION());
				tf.setSCALE(sf.getSCALE());

				tfl.add(tf);
			}

			sq.getTRANSFORMFIELD().addAll(tfl);

			ta = new TABLEATTRIBUTE();
			ta.setNAME("SQL Query");
			ta.setVALUE("");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("User Defined Join");
			ta.setVALUE("");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Source Filter");
			ta.setVALUE("");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Number Of Sorted Ports");
			ta.setVALUE("0");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Tracing Level");
			ta.setVALUE("Normal");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Select Distinct");
			ta.setVALUE("NO");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Is Partitionable");
			ta.setVALUE("NO");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Pre SQL");
			ta.setVALUE("");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Post SQL");
			ta.setVALUE("");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Output is deterministic");
			ta.setVALUE("NO");
			sq.getTABLEATTRIBUTE().add(ta);
			ta = new TABLEATTRIBUTE();
			ta.setNAME("Output is repeatable");
			ta.setVALUE("NEVER");
			sq.getTABLEATTRIBUTE().add(ta);

			sl.add(sq);
		}
		return sl;
	}

	/*
	 * 	This function will return the connectors of the given transformation.
	 * 
	 * 	@param	srcs	The sources from which we want to generate the connectors from.
	 * 	@param	tgts	The targets from which we want to generate the connectors from.
	 * 	@param	sqs		The sourcequalifiers from which we want to generate the connectors from.
	 * 	@param	trns	The transformation from which we want to generate the connectors from.
	 * 	@param	m		The original mapping, to check the connectors.
	 * 	@return			An ArrayList with all the connectors.
	 */

	private static ArrayList<CONNECTOR> getConnectors(ArrayList<SOURCE> srcs,ArrayList<TARGET> tgts,ArrayList<TRANSFORMATION> sqs,TRANSFORMATION trns, MAPPING m){
		ArrayList<CONNECTOR> cl = new ArrayList<CONNECTOR>();

		for(SOURCE s : srcs){
			for(SOURCEFIELD sf : s.getSOURCEFIELD()){
				CONNECTOR c = new CONNECTOR();
				c.setFROMFIELD(sf.getNAME());
				c.setFROMINSTANCE(s.getNAME());
				c.setFROMINSTANCETYPE("Source Definition");
				c.setTOFIELD(sf.getNAME());
				c.setTOINSTANCE("SQ_"+s.getNAME().substring(4));
				c.setTOINSTANCETYPE("Source Qualifier");
				cl.add(c);
				c = new CONNECTOR();
				c.setFROMFIELD(sf.getNAME());
				c.setFROMINSTANCE("SQ_"+s.getNAME().substring(4));
				c.setFROMINSTANCETYPE("Source Qualifier");
				c.setTOFIELD(sf.getNAME());
				c.setTOINSTANCE(trns.getNAME());
				c.setTOINSTANCETYPE(trns.getTYPE());
				cl.add(c);
			}

		}
		for(TARGET t : tgts){
			for(TARGETFIELD tf : t.getTARGETFIELD()){
				CONNECTOR c = new CONNECTOR();
				c.setFROMFIELD(tf.getNAME());
				c.setFROMINSTANCE(trns.getNAME());
				c.setFROMINSTANCETYPE(trns.getTYPE());
				c.setTOFIELD(tf.getNAME());
				c.setTOINSTANCE(t.getNAME());
				c.setTOINSTANCETYPE("Target Definition");
				cl.add(c);	
			}
		}

		return cl;
		/*ArrayList<CONNECTOR> cl = new ArrayList<CONNECTOR>();
		ArrayList<CONNECTOR> clNEW = new ArrayList<CONNECTOR>();

		for(CONNECTOR c : m.getCONNECTOR())
			for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD())
				if(c.getTOINSTANCE().equals(trns.getNAME()) ||c.getTOFIELD().equals(tf.getNAME()))
					cl.add(c);
				else if( c.getFROMINSTANCE().equals(trns.getNAME())||c.getFROMFIELD().equals(tf.getNAME()))
					cl.add(c);
						
		

		for(SOURCE s : srcs){
			for(CONNECTOR c2 : cl){
				if(("SQ_"+s.getNAME()).equals(c2.getFROMINSTANCE())){
					SOURCEFIELD sf = new SOURCEFIELD();
					CONNECTOR c = new CONNECTOR();
					c.setFROMFIELD(sf.getNAME());
					c.setFROMINSTANCE(s.getNAME());
					c.setFROMINSTANCETYPE("Source Definition");
					c.setTOFIELD(sf.getNAME());
					c.setTOINSTANCE("SQ_"+s.getNAME().substring(4));
					c.setTOINSTANCETYPE("Source Qualifier");
					clNEW.add(c);
				}


			}

		}
		for(TARGET t : tgts){
			for(CONNECTOR c2 : cl){
				if(t.getNAME().equals(c2.getTOINSTANCE())){
					TARGETFIELD tf = new TARGETFIELD();
					CONNECTOR c = new CONNECTOR();
					c.setFROMFIELD(tf.getNAME());
					c.setFROMINSTANCE(trns.getNAME());
					c.setFROMINSTANCETYPE(trns.getTYPE());
					c.setTOFIELD(tf.getNAME());
					c.setTOINSTANCE(t.getNAME());
					c.setTOINSTANCETYPE("Target Definition");
					clNEW.add(c);	
				}
			}
		}

		return clNEW;*/
	}

	/*
	 * 	This function will describe the mapping in the given folder in 
	 * 	a SQL query or in Spanish, depending on what's selected on top.
	 * 
	 *  @param	f	The folder which contains the mapping.
	 */

	public static void desc(FOLDER f){
		ArrayList<TRANSFORMATION> alTf = new ArrayList<TRANSFORMATION>();
		ArrayList<String> alTn = new ArrayList<String>();
		ArrayList<CONNECTOR> alCons = new ArrayList<CONNECTOR>();
		ArrayList<TRANSFORMATION> prevTrns = new ArrayList<TRANSFORMATION>();
		ArrayList<String> sourceNames = new ArrayList<String>();
		ArrayList<String> tgtNames = new ArrayList<String>();
		ArrayList<TRANSFORMATION> tgtTrans = new ArrayList<TRANSFORMATION>();



		for(MAPPING m : f.getMAPPING()){
			// VAMOS A SACAR LAS INSTANCIAS DE CADA CONNECTOR, PARA OBTENER UN LISTADO DE TODAS
			// LAS TRANSFORMACIONES DEL FIN HASTA EL PRINCIPIO.


			for(CONNECTOR c : m.getCONNECTOR()){
				for(TRANSFORMATION t : m.getTRANSFORMATION()){
					if(t.getNAME().equals(c.getTOINSTANCE())){
						if(!alTn.contains(t.getNAME())){
							alTn.add(t.getNAME());
							alTf.add(t);
						}
					}
				}
				alCons.add(c);
			}
		}

		alTn.removeAll(alTn);

		for(SOURCE s : f.getSOURCE()){
			generateDDL((Object) s);
			//System.out.println("SOURCE:    " + s.getNAME());
			//for(SOURCEFIELD sf : s.getSOURCEFIELD())
			//System.out.println("SOURCEFIELD:                       " + sf.getNAME());	
		}
		for(TARGET tgt : f.getTARGET()){
			generateDDL((Object) tgt);
			//System.out.println("TARGET:    " + tgt.getNAME());
			//for(TARGETFIELD tf : tgt.getTARGETFIELD())
			//System.out.println("TARGETFIELD:                       " + tf.getNAME());
		}

		for(TRANSFORMATION t : alTf){


			t = writeOrNot(t);
			boolean alreadyExists = false;

			switch(t.getTYPE()){
			case "Expression":
				prevTrns.clear();
				sourceNames.clear();
				tgtNames.clear();
				tgtTrans.clear();
				Expression exp = new Expression();
				exp.getTRANSFORMFIELD().addAll(t.getTRANSFORMFIELD());
				alTn.removeAll(alTn);
				
				for(CONNECTOR c : alCons)
					if(c.getTOINSTANCE().equals(t.getNAME()) && !sourceNames.contains(c.getFROMINSTANCE()))
						sourceNames.add(c.getFROMINSTANCE());


				for(String s : sourceNames)
					for(CONNECTOR c : alCons)
						if(c.getFROMINSTANCE().equals(s))
							tgtNames.add(c.getTOINSTANCE());


				for(String s : tgtNames)
					for(TRANSFORMATION tr : alTf)
						if(s.equals(tr.getNAME()))
							tgtTrans.add(tr);

				if(tgtTrans.isEmpty()){
					for(SOURCE s : f.getSOURCE())
						if(s.getNAME().contains(t.getNAME())){
							for(String srcname : alTn)
								if(srcname.equals(s.getNAME()))
									alreadyExists = true;
							if(!alreadyExists){
								alTn.add(s.getNAME());
								exp.addSource(s);
							}
						}
				}else{
					for(SOURCE s : f.getSOURCE()){
						for(String srcname : alTn)
							if(srcname.equals(s.getNAME()))
								alreadyExists = true;
						if(!alreadyExists){
							alTn.add(s.getNAME());
							exp.addSource(s);
						}
					}
				}
				alTn.removeAll(alTn);
				for(TARGET tg : f.getTARGET())
					if(tg.getNAME().equals("TGT_"+ t.getNAME()) && !alTn.contains(tg.getNAME())){
						exp.addTarget(tg);
						alTn.add(tg.getNAME());
					}

				exp.setConnnectors(alCons);
				exp.getTABLEATTRIBUTE().addAll(t.getTABLEATTRIBUTE());
				System.out.println("EXPRESSION " + t.getNAME());
				exp.toSentence();
				if(bPrintDetails)
					System.out.println(exp.getSentence()+"\n");
				break;
			case "Aggregator":
				prevTrns.clear();
				Aggregator agg = new Aggregator();
				agg.getTRANSFORMFIELD().addAll(t.getTRANSFORMFIELD());
				alTn.removeAll(alTn);
				for(CONNECTOR c : alCons)
					if(c.getTOINSTANCE().equals(t.getNAME()) && !sourceNames.contains(c.getFROMINSTANCE()))
						sourceNames.add(c.getFROMINSTANCE());

				for(String s : sourceNames)
					for(CONNECTOR c : alCons)
						if(c.getFROMINSTANCE().equals(s))
							tgtNames.add(c.getTOINSTANCE());

				for(String s : tgtNames)
					for(TRANSFORMATION tr : alTf)
						if(s.equals(tr.getNAME()))
							tgtTrans.add(tr);

				if(tgtTrans.isEmpty()){
					for(SOURCE s : f.getSOURCE()){
						for(String srcname : alTn)
							if(srcname.equals(s.getNAME()))
								alreadyExists = true;
						if(!alreadyExists){
							alTn.add(s.getNAME());
							agg.addSource(s);
						}
					}
				}else{
					for(SOURCE s : f.getSOURCE()){
						for(String srcname : alTn)
							if(srcname.equals(s.getNAME()))
								alreadyExists = true;
						if(!alreadyExists){
							alTn.add(s.getNAME());
							agg.addSource(s);
						}
					}
				}

				alTn.removeAll(alTn);
				for(TARGET tg : f.getTARGET())
					if(tg.getNAME().equals("TGT_"+ t.getNAME()) && !alTn.contains(tg.getNAME())){
						agg.addTarget(tg);
						alTn.add(tg.getNAME());
					}
				agg.setConnnectors(alCons);
				agg.getTABLEATTRIBUTE().addAll(t.getTABLEATTRIBUTE());
				System.out.println("AGGREGATOR " + t.getNAME());
				agg.toSentence();
				if(bPrintDetails)
					System.out.println(agg.getSentence()+"\n");
				break;
			case "Joiner":
				prevTrns.clear();
				Joiner join = new Joiner();
				join.getTRANSFORMFIELD().addAll(t.getTRANSFORMFIELD());
				alTn.removeAll(alTn);
				for(CONNECTOR c : alCons)
					if(c.getTOINSTANCE().equals(t.getNAME()) && !sourceNames.contains(c.getFROMINSTANCE()))
						sourceNames.add(c.getFROMINSTANCE());

				for(String s : sourceNames)
					for(CONNECTOR c : alCons)
						if(c.getFROMINSTANCE().equals(s))
							tgtNames.add(c.getTOINSTANCE());

				for(String s : tgtNames)
					for(TRANSFORMATION tr : alTf)
						if(s.equals(tr.getNAME()))
							tgtTrans.add(tr);

				if(tgtTrans.isEmpty()){
					for(SOURCE s : f.getSOURCE()){
						for(String srcname : alTn)
							if(srcname.equals(s.getNAME()))
								alreadyExists = true;
						if(!alreadyExists){
							alTn.add(s.getNAME());
							join.addSource(s);
						}
					}
				}else{
					for(SOURCE s : f.getSOURCE())
						if(s.getNAME().contains(tgtTrans.get(0).getNAME())){
							for(String srcname : alTn)
								if(srcname.equals(s.getNAME()))
									alreadyExists = true;
							if(!alreadyExists){
								alTn.add(s.getNAME());
								join.addSource(s);
							}
						}
				}

				alTn.removeAll(alTn);
				for(TARGET tg : f.getTARGET())
					if(tg.getNAME().equals("TGT_"+ t.getNAME()) && !alTn.contains(tg.getNAME())){
						join.addTarget(tg);
						alTn.add(tg.getNAME());
					}
				join.setConnnectors(alCons);
				join.getTABLEATTRIBUTE().addAll(t.getTABLEATTRIBUTE());
				System.out.println("JOINER " + t.getNAME());
				join.toSentence();
				if(bPrintDetails)
					System.out.println(join.getSentence()+"\n");
				break;
			case "Sorter":
				prevTrns.clear();
				Sorter sort = new Sorter();
				sort.getTRANSFORMFIELD().addAll(t.getTRANSFORMFIELD());
				alTn.removeAll(alTn);
				for(CONNECTOR c : alCons)
					if(c.getTOINSTANCE().equals(t.getNAME()) && !sourceNames.contains(c.getFROMINSTANCE()))
						sourceNames.add(c.getFROMINSTANCE());

				for(String s : sourceNames)
					for(CONNECTOR c : alCons)
						if(c.getFROMINSTANCE().equals(s))
							tgtNames.add(c.getTOINSTANCE());

				for(String s : tgtNames)
					for(TRANSFORMATION tr : alTf)
						if(s.equals(tr.getNAME()))
							tgtTrans.add(tr);

				if(tgtTrans.isEmpty()){
					for(SOURCE s : f.getSOURCE())
						if(s.getNAME().contains(t.getNAME())){
							for(String srcname : alTn)
								if(srcname.equals(s.getNAME()))
									alreadyExists = true;
							if(!alreadyExists){
								alTn.add(s.getNAME());
								sort.addSource(s);
							}
						}
				}else{
					for(SOURCE s : f.getSOURCE()){
						for(String srcname : alTn)
							if(srcname.equals(s.getNAME()))
								alreadyExists = true;
						if(!alreadyExists){
							alTn.add(s.getNAME());
							sort.addSource(s);
						}
					}
				}



				alTn.removeAll(alTn);
				for(TARGET tg : f.getTARGET())
					if(tg.getNAME().equals("TGT_"+ t.getNAME()) && !alTn.contains(tg.getNAME())){
						sort.addTarget(tg);
						alTn.add(tg.getNAME());
					}
				sort.setConnnectors(alCons);
				sort.getTABLEATTRIBUTE().addAll(t.getTABLEATTRIBUTE());
				System.out.println("SORTER " + t.getNAME());
				sort.toSentence();
				if(bPrintDetails)
					System.out.println(sort.getSentence()+"\n");
				break;
			case "Lookup Procedure":
				prevTrns.clear();
				Lookup lkp = new Lookup();
				lkp.getTRANSFORMFIELD().addAll(t.getTRANSFORMFIELD());
				alTn.removeAll(alTn);
				for(CONNECTOR c : alCons)
					if(c.getTOINSTANCE().equals(t.getNAME()) && !sourceNames.contains(c.getFROMINSTANCE()))
						sourceNames.add(c.getFROMINSTANCE());

				for(String s : sourceNames)
					for(CONNECTOR c : alCons)
						if(c.getFROMINSTANCE().equals(s))
							tgtNames.add(c.getTOINSTANCE());

				for(String s : tgtNames)
					for(TRANSFORMATION tr : alTf)
						if(s.equals(tr.getNAME()))
							tgtTrans.add(tr);

				if(tgtTrans.isEmpty()){
					for(SOURCE s : f.getSOURCE())
						if(s.getNAME().contains(t.getNAME())){
							for(String srcname : alTn)
								if(srcname.equals(s.getNAME()))
									alreadyExists = true;
							if(!alreadyExists){
								alTn.add(s.getNAME());
								lkp.addSource(s);
							}
						}
				}else{
					for(SOURCE s : f.getSOURCE()){
						for(String srcname : alTn)
							if(srcname.equals(s.getNAME()))
								alreadyExists = true;
						if(!alreadyExists){
							alTn.add(s.getNAME());
							lkp.addSource(s);
						}
					}
				}


				alTn.removeAll(alTn);
				for(TARGET tg : f.getTARGET())
					if(tg.getNAME().equals("TGT_"+ t.getNAME()) && !alTn.contains(tg.getNAME())){
						lkp.addTarget(tg);
						alTn.add(tg.getNAME());
					}
				lkp.setConnnectors(alCons);
				lkp.getTABLEATTRIBUTE().addAll(t.getTABLEATTRIBUTE());
				System.out.println("LOOKUP " + t.getNAME());
				lkp.toSentence();
				if(bPrintDetails)
					System.out.println(lkp.getSentence()+"\n");
				break;
			case "Filter":
				prevTrns.clear();
				Filter fil = new Filter();
				alTn.removeAll(alTn);
				for(CONNECTOR c : alCons)
					if(c.getTOINSTANCE().equals(t.getNAME()) && !sourceNames.contains(c.getFROMINSTANCE()))
						sourceNames.add(c.getFROMINSTANCE());

				for(String s : sourceNames)
					for(CONNECTOR c : alCons)
						if(c.getFROMINSTANCE().equals(s))
							tgtNames.add(c.getTOINSTANCE());

				for(String s : tgtNames)
					for(TRANSFORMATION tr : alTf)
						if(s.equals(tr.getNAME()))
							tgtTrans.add(tr);

				if(tgtTrans.isEmpty()){
					for(SOURCE s : f.getSOURCE())
						if(s.getNAME().contains(t.getNAME())){
							for(String srcname : alTn)
								if(srcname.equals(s.getNAME()))
									alreadyExists = true;
							if(!alreadyExists){
								alTn.add(s.getNAME());
								fil.addSource(s);
							}
						}
				}else{
					for(SOURCE s : f.getSOURCE()){
						for(String srcname : alTn)
							if(srcname.equals(s.getNAME()))
								alreadyExists = true;
						if(!alreadyExists){
							alTn.add(s.getNAME());
							fil.addSource(s);
						}
					}
				}


				alTn.removeAll(alTn);
				for(TARGET tg : f.getTARGET())
					if(tg.getNAME().equals("TGT_"+ t.getNAME()) && !alTn.contains(tg.getNAME())){
						fil.addTarget(tg);
						alTn.add(tg.getNAME());
					}
				fil.getTRANSFORMFIELD().addAll(t.getTRANSFORMFIELD());
				fil.setConnnectors(alCons);
				fil.getTABLEATTRIBUTE().addAll(t.getTABLEATTRIBUTE());
				System.out.println("FILTER " + t.getNAME());
				fil.toSentence();
				if(bPrintDetails)
					System.out.println(fil.getSentence()+"\n");
				break;
			default:
				break;
			}
		}


	}


	/*
	 * 	This function converts the POWERMART-object to XML using the JAXB-library
	 * 
	 * 	@param	pwM	The object we want to convert to XML.
	 */

	public static void writeToXML(POWERMART pwM){
		try{
			File file = new File(outputPath+"/xml/"+ pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(0).getNAME() +".XML");
			JAXBContext jaxbContext = JAXBContext.newInstance(POWERMART.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING,"ISO-8859-1");
			jaxbMarshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<!DOCTYPE POWERMART SYSTEM \"powrmart.dtd\">\n");
			if(bformat){jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);}
			jaxbMarshaller.marshal(pwM,file);
			//jaxbMarshaller.marshal(pwM,System.out);

		}catch(JAXBException e){
			Main.writeError(e);
		}

	}

	/*
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

	/*
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
					if(s.getNAME().substring(0,4).equals("SRC_")){
						ddl = "CREATE TABLE " + s.getNAME() +"( \n";
						for(SOURCEFIELD sf : s.getSOURCEFIELD())
							ddl = ddl + sf.getNAME() + " " + sf.getDATATYPE() + "(" + sf.getPRECISION() + "),\n" ;

						ddl = ddl.substring(0, ddl.length()-2) + "\n);";

						try(  PrintWriter out = new PrintWriter( outputPath+"/DDL/DDL_"+ s.getNAME()+".sql" )  ){
							out.println( ddl );
						}catch (Exception e) {
							Main.writeError(e);
						}
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

	/*
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
					if(s.getNAME().substring(0,4).equals("SRC_")){
						for(SOURCEFIELD sf : s.getSOURCEFIELD())
							ddl = ddl + sf.getNAME() + ";" ;

						ddl = ddl.substring(0,ddl.lastIndexOf(";"));
						try(  PrintWriter out = new PrintWriter( outputPath+"/File/"+ s.getNAME()+".asc" )  ){
							out.println( ddl );
						}catch (Exception e) {
							Main.writeError(e);
						}
					}
				}else if(o instanceof TARGET){
					TARGET t = new TARGET();
					t = ((TARGET) o);
					for(TARGETFIELD tf : t.getTARGETFIELD())
						ddl = ddl + tf.getNAME() + ";";

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

	/*
	 * 	This function returns the language variable to calls from other classes.
	 * 	
	 * 	@return		The language variable, which will be SQL or Español.
	 */

	public static String getLanguage() {
		return language;
	}
}







