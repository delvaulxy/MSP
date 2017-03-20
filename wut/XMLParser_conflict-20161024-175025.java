package corp.everis.pwc.moam;

import java.io.File;

import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.FOLDER;
import corp.everis.pwc.raw.MAPPING;
import corp.everis.pwc.raw.POWERMART;
import corp.everis.pwc.raw.REPOSITORY;

public class XMLParser {
	public static void main(String[] args){
		try {
			POWERMART pPM = new POWERMART();
			REPOSITORY rRep	= new REPOSITORY();
			
			File fInputFile = new File("src/file/reengineering.XML");
			POWERMART pwM = (POWERMART) JAXB.unmarshal(fInputFile,  POWERMART.class);
			
			if (pwM instanceof POWERMART){
				for(int i = 0; i<pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().size();i++){

					FOLDER f = (FOLDER) pwM.getREPOSITORY().get(0).getFOLDER().get(0);
					MAPPING m = (MAPPING) pwM.getREPOSITORY().get(0).getFOLDER().get(0).getMAPPING().get(i);
					dissectWF(m,f);
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
	private static void dissectWF(MAPPING m, FOLDER f){
		m = orderConnections(m);
		
	}
	
	private static MAPPING orderConnections(MAPPING m){
		CONNECTOR c = new CONNECTOR();
		Boolean b = true;
		
		for(int i = 0; i < m.getCONNECTOR().size();i++){
			forLoop:
			for(int j=0; j < m.getCONNECTOR().size();j++){
				if(m.getCONNECTOR().get(i).getTOINSTANCE() == m.getCONNECTOR().get(j).getFROMINSTANCE()){
					b = false;
					break forLoop;
				}
			}
			if (b){
				System.out.println("test");
			}
		}
		
		
		return m;
	}
}
