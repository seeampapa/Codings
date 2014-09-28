package amp.xml.parser;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {

	Document dom;
	Element docEle;
	HashMap<String, String> map;
	
	private void parseXmlFile(String fileToParse){
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//parse using builder to get DOM representation of the XML file
			dom = db.parse(fileToParse);
			

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private void parseDocument(String elementName){
		//get the root elememt
		docEle = dom.getDocumentElement();
		//get a nodelist of <employee> elements
		System.out.println(((Element)docEle.getElementsByTagName(elementName).item(0)).getTagName());
		NodeList nl = docEle.getElementsByTagName(elementName).item(0).getChildNodes();
		
		for(int i=0;i<nl.getLength();i++){
			Element e1 = (Element) nl.item(i);
			System.out.println(e1.getTagName());
		}
		
		/*if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				
				//get the employee element
				Element el = (Element) nl.item(i);
				NodeList n2 = el.getElementsByTagName("xs:element").item(0).getChildNodes();
				for(int j=0;j<n2.getLength();j++){
					System.out.println(((Element) n2.item(j)).getAttribute("name"));
				}
				//map.put(el.getAttribute("name"), el.getAttribute("type"));
			}
		}*/
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String element = "xs:complexType";
		DomParser dmParser = new DomParser();
		dmParser.parseXmlFile("shiporder.xsd");
		dmParser.parseDocument(element);
	}

}
