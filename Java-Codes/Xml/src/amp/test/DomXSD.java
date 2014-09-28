package amp.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomXSD {
	
	private Document dom = null;
	
	// about paths
	
	private static String ROOT = "";
	
	private static String PATH = "";
	
	private static String CURRNODE = "";
	
	
	public Document getDom() {
		return dom;
	}

	public DomXSD() {
		// Initial
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder docBuild = fact.newDocumentBuilder();
			dom = docBuild.parse("new.xsd");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DomXSD myObj = new DomXSD();
		Document doc = myObj.getDom();
		ROOT = doc.getDocumentElement().getNodeName();
		String prefix = ROOT.split(":")[0];
		//System.out.println(doc.getDocumentElement().getAttribute("xmlns:xsd"));
		System.out.println(ROOT);
		NodeList simpleList = doc.getElementsByTagName(prefix + ":simpleType");
		NodeList complexList = doc.getElementsByTagName(prefix + ":complexType");
		NodeList elemList = doc.getElementsByTagName(prefix + ":element");
		
		
		for(int i=0;i<simpleList.getLength();i++){
			System.out.println(simpleList.item(i).getNodeName());
			
		}
		
		for(int i=0;i<complexList.getLength();i++){
			System.out.println(complexList.item(i).getNodeName());
		}
		
		for(int i=0;i<elemList.getLength();i++){
			if(elemList.item(i).getParentNode().getNodeName().equals(ROOT))
			System.out.println(elemList.item(i).getNodeName());
		}
	}

}
