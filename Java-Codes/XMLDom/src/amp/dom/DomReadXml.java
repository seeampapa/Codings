package amp.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * using JAXP's DOM APIs
 *
 */

public class DomReadXml {
	
	private static Logger logger = Logger.getLogger(DomReadXml.class);
	
	private Document doc;
	
	public DomReadXml() {
		// TODO Auto-generated constructor stub
		init();
		if(doc!=null){
			doc.getDocumentElement().normalize();
			String rootElem = doc.getDocumentElement().getNodeName();
			
			NodeList nList = doc.getElementsByTagName(rootElem);
			parseXML(nList);
		}
	}
	
	private void init(){
		DocumentBuilderFactory docBFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docBFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File xmlFile = new File("staff.xml");
		if(docBuilder!=null){
			try {
				doc = docBuilder.parse(xmlFile);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void parseXML(NodeList nList){
		for(int i=0; i<nList.getLength(); i++){
			Node nNode = nList.item(i);
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				Element elem = (Element) nNode;
				System.out.print("New Element: " + elem.getNodeName() + " ==> ");
				if(elem.getChildNodes().getLength()==1){
					System.out.print(elem.getChildNodes().item(0).getNodeValue());
				}else{
					System.out.println();
				}
				if(elem.hasAttributes()){
					NamedNodeMap attrsMap = nNode.getAttributes();
					for(int j=0; j<attrsMap.getLength(); j++){
						System.out.print("Attr ("+j+"):");
						System.out.print(attrsMap.item(j).getNodeName() + " ==> "); 
						System.out.print(attrsMap.item(j).getNodeValue());
					}
				}
				System.out.println();
				parseXML(elem.getChildNodes());
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.info("In Main");
		DomReadXml domXml = new DomReadXml();
	}

}
