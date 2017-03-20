package corp.everis.pwc.moam;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.omg.CORBA.MARSHAL;
import org.w3c.dom.Document;

import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.FOLDER;
import corp.everis.pwc.raw.INSTANCE;
import corp.everis.pwc.raw.MAPPING;
import corp.everis.pwc.raw.POWERMART;
import corp.everis.pwc.raw.REPOSITORY;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.SOURCEFIELD;
import corp.everis.pwc.raw.TABLEATTRIBUTE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TARGETLOADORDER;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;

public class XMLParser {



	public static void main(String[] args){
		try {
			File fInputFile = new File("src/file/reengineering.XML");
			POWERMART pwM = (POWERMART) JAXB.unmarshal(fInputFile,  POWERMART.class);

			if (pwM instanceof POWERMART){
				for(int i = 0; i<pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().size();i++){
					dissectWF(pwM,i);
				}
			}else{
				// ALERT USER OF PARSING ERROR
			}





		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static POWERMART parseXML(String sPath){


		return null;
	}
	private static void dissectWF(POWERMART pwM,int wfI){
		
		String sTgtInstance;
		String sSrcInstance;
		
		ArrayList<CONNECTOR> alCons = new ArrayList<CONNECTOR>();
		ArrayList<TRANSFORMATION> alTrns = new ArrayList<TRANSFORMATION>();
		
		FOLDER f = (FOLDER) pwM.getREPOSITORY().get(0).getFOLDER().get(0);
		MAPPING m = (MAPPING) pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(wfI);
		
		m = orderConnections(m);
		
		for(int i = 0; i < m.getCONNECTOR().size();i++){
			if(m.getCONNECTOR().get(i) != null){
				sTgtInstance = m.getCONNECTOR().get(i).getTOINSTANCE();
				for (CONNECTOR c : m.getCONNECTOR()){
					if(c.getTOINSTANCE().equals(sTgtInstance) && !alCons.contains(c)){
						alCons.add(c);
					}
				}
			}
		}
		for(CONNECTOR c : alCons){
			for(TRANSFORMATION trns : m.getTRANSFORMATION()){
				if(c.getFROMINSTANCE().equals(trns.getNAME()) && !trns.getTYPE().equals("Source Qualifier")){
					if(!alTrns.contains(trns)){
						alTrns.add(trns);
					}
				}
			}
		}
		createXML(alTrns,m,f,pwM);
	}

	private static MAPPING orderConnections(MAPPING m){
		Boolean b = true;
		ArrayList<CONNECTOR> alCons = new ArrayList<CONNECTOR>(); 
		ArrayList<CONNECTOR> alConsOld = new ArrayList<CONNECTOR>(); 

		alConsOld.addAll(m.getCONNECTOR());

		while( 0 != m.getCONNECTOR().size()){ 
			for(int i = 0; i < m.getCONNECTOR().size();i++){
				b = true;
				for(int j=0; j < m.getCONNECTOR().size();j++){
					if(m.getCONNECTOR().get(i).getTOINSTANCE().equals(m.getCONNECTOR().get(j).getFROMINSTANCE())){
						b = false;
						break;
					}
				}
				if(b){
					alCons.add(m.getCONNECTOR().get(i));
					m.getCONNECTOR().remove(i);
					break;
				}
			}
		}
		m.getCONNECTOR().clear();
		m.getCONNECTOR().addAll(alCons);
		return m;
	}

	private static void createXML(ArrayList<TRANSFORMATION> alTrns, MAPPING m, FOLDER f,POWERMART pwM){
		ArrayList<TRANSFORMATION> alSQ = new ArrayList<TRANSFORMATION>();

		ArrayList<TARGET> alTgt = new ArrayList<TARGET>();
		ArrayList<SOURCE> alSrc = new ArrayList<SOURCE>();
		ArrayList<CONNECTOR> alConsNuevo = new ArrayList<CONNECTOR>();
		alConsNuevo.clear();

		MAPPING newMap = new MAPPING();
		TRANSFORMATION inst = new TRANSFORMATION();

		for(TRANSFORMATION trns : alTrns ){
			SOURCE src = new SOURCE();
			TARGET tgt = new TARGET();
			TRANSFORMATION tSQ = new TRANSFORMATION();
			TABLEATTRIBUTE ta = new TABLEATTRIBUTE();
			TARGETLOADORDER tglo = new TARGETLOADORDER();
			
			int i = 1;

			for(TRANSFORMFIELD tf : trns.getTRANSFORMFIELD()){

				if(tf.getPORTTYPE().equals("INPUT")){
					SOURCEFIELD sf = new SOURCEFIELD();
					CONNECTOR cTemp = new CONNECTOR();

					sf.setBUSINESSNAME("");
					sf.setDATATYPE(tf.getDATATYPE());
					sf.setDESCRIPTION(tf.getDESCRIPTION());
					sf.setFIELDNUMBER(Integer.toString(i));
					sf.setFIELDPROPERTY("0");
					sf.setFIELDTYPE("ELEMITEM");
					sf.setGROUP("");
					sf.setHIDDEN("NO");
					sf.setKEYTYPE("NOT A KEY");
					sf.setLENGTH(tf.getPRECISION());
					sf.setLEVEL("0");
					sf.setNAME(tf.getNAME());
					sf.setNULLABLE("NULL");
					sf.setOCCURS("0");
					//UNKNOWN
					sf.setOFFSET("");
					sf.setPHYSICALLENGTH(tf.getPRECISION());
					//UNKNOWN
					sf.setPHYSICALOFFSET("");
					sf.setPICTURETEXT("");
					sf.setPRECISION(tf.getPRECISION());
					//UNKNOWN
					sf.setREDEFINES("");
					//UNKNOWN
					sf.setREFERENCEDDBD("");
					sf.setREFERENCEDFIELD("");
					sf.setREFERENCEDTABLE("");
					sf.setSCALE(tf.getSCALE());
					//UNKNOWN
					sf.setSHIFTSTATE("");
					sf.setUSAGE("");
					sf.setUSAGEFLAGS("");

					src.getSOURCEFIELD().add(sf);

					tf.setPORTTYPE("INPUT/OUTPUT");
					tSQ.getTRANSFORMFIELD().add(tf);

					cTemp = new CONNECTOR();
					cTemp.setFROMFIELD(sf.getNAME());
					cTemp.setFROMINSTANCE(trns.getNAME()+"_SRC");
					cTemp.setFROMINSTANCETYPE("Source Definition");
					cTemp.setTOFIELD(sf.getNAME());
					cTemp.setTOINSTANCE("SQ_"+trns.getNAME());
					cTemp.setTOINSTANCETYPE("Source Qualifier");

					alConsNuevo.add(cTemp);

					cTemp = new CONNECTOR();
					cTemp.setFROMFIELD(sf.getNAME());
					cTemp.setFROMINSTANCE("SQ_"+trns.getNAME());
					cTemp.setFROMINSTANCETYPE("Source Qualifier");
					cTemp.setTOFIELD(sf.getNAME());
					cTemp.setTOINSTANCE(trns.getNAME());
					cTemp.setTOINSTANCETYPE(trns.getTYPE());

					if(!alConsNuevo.contains(cTemp)){
						alConsNuevo.add(cTemp);
					}

					i++;
				}else if(tf.getPORTTYPE().equals("OUTPUT")){
					TARGETFIELD tgtf = new TARGETFIELD();
					CONNECTOR cTemp = new CONNECTOR();

					tgtf.setBUSINESSNAME("");
					tgtf.setDATATYPE(tf.getDATATYPE());
					tgtf.setDESCRIPTION(tf.getDESCRIPTION());
					tgtf.setFIELDNUMBER(Integer.toString(i));
					tgtf.setGROUP("");
					tgtf.setISFILENAMEFIELD("");
					tgtf.setKEYTYPE("NOT A KEY");
					tgtf.setNAME(tf.getNAME()	);
					tgtf.setNULLABLE("NULL");
					tgtf.setPICTURETEXT("");
					tgtf.setPRECISION(tf.getPRECISION());
					tgtf.setREFERENCEDFIELD("");
					tgtf.setREFERENCEDTABLE("");
					tgtf.setSCALE(tf.getSCALE());

					tgt.getTARGETFIELD().add(tgtf);

					cTemp = new CONNECTOR();
					cTemp.setFROMFIELD(tf.getNAME());
					cTemp.setFROMINSTANCE(trns.getNAME());
					cTemp.setFROMINSTANCETYPE("Source Definition");
					cTemp.setTOFIELD(tgtf.getNAME());
					cTemp.setTOINSTANCE(trns.getNAME()+"_TGT");
					cTemp.setTOINSTANCETYPE("Target Definition");

					if(!alConsNuevo.contains(cTemp)){
						alConsNuevo.add(cTemp);
					}

					i++;
				}else if(tf.getPORTTYPE().equals("INPUT/OUTPUT")){
					SOURCEFIELD sf = new SOURCEFIELD();
					TARGETFIELD tgtf = new TARGETFIELD();
					CONNECTOR cTemp = new CONNECTOR();

					sf.setBUSINESSNAME("");
					sf.setDATATYPE(tf.getDATATYPE());
					sf.setDESCRIPTION(tf.getDESCRIPTION());
					sf.setFIELDNUMBER(Integer.toString(i));
					sf.setFIELDPROPERTY("0");
					sf.setFIELDTYPE("ELEMITEM");
					sf.setGROUP("");
					sf.setHIDDEN("NO");
					sf.setKEYTYPE("NOT A KEY");
					sf.setLENGTH(tf.getPRECISION());
					sf.setLEVEL("0");
					sf.setNAME(tf.getNAME());
					sf.setNULLABLE("NULL");
					sf.setOCCURS("0");
					//UNKNOWN
					sf.setOFFSET("");
					sf.setPHYSICALLENGTH(tf.getPRECISION());
					//UNKNOWN
					sf.setPHYSICALOFFSET("");
					sf.setPICTURETEXT("");
					sf.setPRECISION(tf.getPRECISION());
					//UNKNOWN
					sf.setREDEFINES("");
					//UNKNOWN
					sf.setREFERENCEDDBD("");
					sf.setREFERENCEDFIELD("");
					sf.setREFERENCEDTABLE("");
					sf.setSCALE(tf.getSCALE());
					//UNKNOWN
					sf.setSHIFTSTATE("");
					sf.setUSAGE("");
					sf.setUSAGEFLAGS("");

					src.getSOURCEFIELD().add(sf);

					tgtf.setBUSINESSNAME("");
					tgtf.setDATATYPE(tf.getDATATYPE());
					tgtf.setDESCRIPTION(tf.getDESCRIPTION());
					tgtf.setFIELDNUMBER(Integer.toString(i));
					tgtf.setGROUP("");
					tgtf.setISFILENAMEFIELD("");
					tgtf.setKEYTYPE("NOT A KEY");
					tgtf.setNAME(tf.getNAME());
					tgtf.setNULLABLE("NULL");
					tgtf.setPICTURETEXT("");
					tgtf.setPRECISION(tf.getPRECISION());
					tgtf.setREFERENCEDFIELD("");
					tgtf.setREFERENCEDTABLE("");
					tgtf.setSCALE(tf.getSCALE());

					tgt.getTARGETFIELD().add(tgtf);
					tf.setPORTTYPE("INPUT/OUTPUT");
					tSQ.getTRANSFORMFIELD().add(tf);

					cTemp = new CONNECTOR();
					cTemp.setFROMFIELD(sf.getNAME());
					cTemp.setFROMINSTANCE(trns.getNAME()+"_SRC");
					cTemp.setFROMINSTANCETYPE("Source Definition");
					cTemp.setTOFIELD(sf.getNAME());
					cTemp.setTOINSTANCE("SQ_"+trns.getNAME());
					cTemp.setTOINSTANCETYPE("Source Qualifier");

					if(!alConsNuevo.contains(cTemp)){
						alConsNuevo.add(cTemp);
					}
					
					cTemp = new CONNECTOR();
					cTemp.setFROMFIELD(sf.getNAME());
					cTemp.setFROMINSTANCE("SQ_"+trns.getNAME());
					cTemp.setFROMINSTANCETYPE("Source Qualifier");
					cTemp.setTOFIELD(sf.getNAME());
					cTemp.setTOINSTANCE(trns.getNAME());
					cTemp.setTOINSTANCETYPE(trns.getTYPE());
					
					if(!alConsNuevo.contains(cTemp)){
						alConsNuevo.add(cTemp);
					}

					cTemp = new CONNECTOR();
					cTemp.setFROMFIELD(tf.getNAME());
					cTemp.setFROMINSTANCE(trns.getNAME());
					cTemp.setFROMINSTANCETYPE("Source Definition");
					cTemp.setTOFIELD(tgtf.getNAME());
					cTemp.setTOINSTANCE(trns.getNAME()+"_TGT");
					cTemp.setTOINSTANCETYPE("Target Definition");
					
					if(!alConsNuevo.contains(cTemp)){
						alConsNuevo.add(cTemp);
					}
					i++;
				}
				src.setBUSINESSNAME("");
				src.setCOMPONENTVERSION("");
				src.setCRCVALUE("");
				src.setDATABASESUBTYPE("");
				src.setDATABASETYPE("DB2");
				src.setDBDNAME("DB2");
				src.setDESCRIPTION("GENERATED SOURCE FOR " + trns.getDESCRIPTION() + "-TRANSFORMATION.");
				//src.setERPSRCINFO(value);
				//src.setFLATFILE("");
				//src.setIBMCOMP("");
				src.setNAME(trns.getNAME()+"_SRC");
				src.setOBJECTVERSION("1");
				src.setOWNERNAME("XDCSS");
				src.setVERSIONNUMBER("1");

				if(!alSrc.contains(src)){
					alSrc.add(src);
				}
				

				tSQ.setCOMPONENTVERSION("1");
				tSQ.setDESCRIPTION("Source qualifier for " +trns.getNAME()+"_SRC");
				tSQ.setNAME("SQ_"+tSQ.getNAME());
				tSQ.setOBJECTVERSION("1");
				tSQ.setREUSABLE("NO");
				tSQ.setTYPE("Source Qualifier");
				tSQ.setVERSIONNUMBER("1");

				ta.setNAME("SQL Query");
				ta.setVALUE("");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("User Defined Join");
				ta.setVALUE("");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Source Filter");
				ta.setVALUE("");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Number Of Sorted Ports");
				ta.setVALUE("0");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Tracing Level");
				ta.setVALUE("Normal");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Select Distinct");
				ta.setVALUE("NO");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Is Partitionable");
				ta.setVALUE("NO");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Pre SQL");
				ta.setVALUE("");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Post SQL");
				ta.setVALUE("");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Output is deterministic");
				ta.setVALUE("NO");
				tSQ.getTABLEATTRIBUTE().add(ta);
				ta.setNAME("Output is repeatable");
				ta.setVALUE("NEVER");
				tSQ.getTABLEATTRIBUTE().add(ta);
				
				if(!alSQ.contains(tSQ)){
					alSQ.add(tSQ);
				}
				
				
				tgt.setBUSINESSNAME("");
				tgt.setCOMPONENTVERSION("");
				tgt.setCONSTRAINT("");
				tgt.setCRCVALUE("");
				tgt.setDATABASETYPE("DB2");
				tgt.setDESCRIPTION("GENERATED TARGET FOR " + trns.getDESCRIPTION() + "-TRANSFORMATION.");
				tgt.setNAME(trns.getNAME()+"_TGT");
				tgt.setOBJECTVERSION("1");
				tgt.setTABLEOPTIONS("");
				tgt.setTABLETYPE("DB2");
				tgt.setVERSIONNUMBER("1");
				//tgt.setXMLINFO("");


				tglo.setORDER("1");
				tglo.setTARGETINSTANCE(tgt.getNAME());
				if(!alTgt.contains(tgt)){
					alTgt.add(tgt);
				}

			}
			newMap.setDESCRIPTION("MAPPING GENERATED WITH SCRIPT.");
			newMap.setISVALID("YES");
			newMap.setNAME("m_"+trns.getNAME());
			newMap.setOBJECTVERSION("1");
			newMap.setVERSIONNUMBER("1");
			
			newMap.getCONNECTOR().addAll(alConsNuevo);
			newMap.getTRANSFORMATION().add(trns);
			//newMap.getMAPDEPENDENCY().add(null);
			
			
			//powermart pw = new powermart();
			POWERMART pmNew = new POWERMART();
			REPOSITORY rNew = new REPOSITORY();
			FOLDER fNew = new FOLDER();
			
			
			//folder
			//fol
			//config copy from original
			//desc copy
			//mapping
			//name xdw991593
			//owner w991593
			//permissions rwsx---r--
			//shared notshared
			//source
			//target
			//uuid copy
			// workflow arraylist
			fNew.setDESCRIPTION(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getDESCRIPTION());
			fNew.setNAME(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getNAME());
			fNew.setOWNER(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getOWNER());
			fNew.setPERMISSIONS(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getPERMISSIONS());
			fNew.setSHARED(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getSHARED());
			fNew.setUUID(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getUUID());
			fNew.getTARGET().addAll(alTgt);
			fNew.getSOURCE().addAll(alSrc);
			fNew.getMAPPING().add(newMap);
			fNew.getWORKFLOW().addAll(pwM.getREPOSITORY().get(0).getFOLDER().get(0).getWORKFLOW());
			
			//repository
			//rep
			//codepage Latin1
			//databasetype db2
			//name xdipcrs
			//version 184
			rNew.setCODEPAGE(pwM.getREPOSITORY().get(0).getCODEPAGE());
			rNew.setDATABASETYPE(pwM.getREPOSITORY().get(0).getDATABASETYPE());
			rNew.setNAME(pwM.getREPOSITORY().get(0).getNAME());
			rNew.setVERSION(pwM.getREPOSITORY().get(0).getVERSION());
			rNew.getFOLDER().add(fNew); 
			
			//??rNew.setPARENTREPOSITORY(value);
			
			
			pmNew.setCREATIONDATE(pwM.getCREATIONDATE());
			pmNew.setREPOSITORYVERSION(pwM.getREPOSITORYVERSION());
			pmNew.getREPOSITORY().add(rNew);
			

			writeXML(pmNew);	
					
			
			for(CONNECTOR c : alConsNuevo){
				System.out.println(c.getFROMINSTANCE()+"."+ c.getFROMFIELD() +" --> "+c.getTOINSTANCE()+"."+c.getTOFIELD());
			}
			System.out.println("END-----------------------------------");
			
		}

	}
	
	private static void writeXML(POWERMART pwM){
		try{
			File file = new File("src/file/test.XML");
			JAXBContext jaxbContext = JAXBContext.newInstance(POWERMART.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(pwM,file);
			jaxbMarshaller.marshal(pwM,System.out);
			
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}
}


