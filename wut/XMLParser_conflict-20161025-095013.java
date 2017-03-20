package corp.everis.pwc.moam;

import java.io.File;
import java.util.ArrayList;

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
		ArrayList<CONNECTOR> alCons = new ArrayList<CONNECTOR>();
		
		for(int i = 0; i < m.getCONNECTOR().size();i++){
			
		}
		
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
}
