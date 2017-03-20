package corp.everis.pwc.moam;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
	public static void main(String[] args){
		try {
			File fInputFile = new File("src/file/NewFile.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse(fInputFile);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("FOLDER").item(0).getChildNodes();
			
			for (int temp = 0; temp < nList.getLength(); temp ++ ){
				Node nNode = nList.item(temp);
				System.out.println("CurrentNode: "+ nNode.getNodeName());
			}
			
		} catch (Exception e) {
			writeError(e);
		}
		

	}
	public static void writeError(Exception e){
		System.out.println("Error in method " + e.getStackTrace()[1].getMethodName() +"\n in class \n "+ e.getStackTrace()[1].getClassName()+"\n StackTrace: \n"+e.getMessage());
	}
	public static void print(String s){
		System.out.println(s);
	}
}
