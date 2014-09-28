package amp.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomMain {
	
	private Document dom = null;
	
	// about paths
	
	private static String ROOT = "";
	
	private static String PATH = "";
	
	private static String CURRNODE = "";
	
	
	public Document getDom() {
		return dom;
	}

	public DomMain() {
		// Initial
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder docBuild = fact.newDocumentBuilder();
			dom = docBuild.parse("ShipOrder.xml");
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
	
	// root/node1/par/curr
	// root - on first call (root)
	// Path - node1
	// currentNode - curr
	// parentNode - par
	
	private void findSubElements(Element elem){
		CURRNODE = elem.getNodeName() +"/";
			
		System.out.println(":>> " + ROOT + PATH);
		
		NodeList nList = elem.getChildNodes();
		if(nList != null && nList.getLength() > 1){
			for(int i=0; i<nList.getLength();i++){
				if(!nList.item(i).getNodeName().equals("#text")){
					PATH = PATH + nList.item(i).getNodeName() + "/";
					findSubElements((Element)nList.item(i));//System.out.println(nList.item(i).getParentNode().getNodeName());
				}
				if(i==nList.getLength()-1){
					if(nList.item(i).getParentNode().getNodeName().equals(ROOT.substring(0, ROOT.length()-1)))
						break;
					//System.out.println(nList.item(i).getParentNode().getNodeName());
					PATH = PATH.substring(0, PATH.indexOf(nList.item(i).getParentNode().getNodeName()));
				}
			}
		}else{
			PATH = PATH.substring(0, PATH.indexOf(CURRNODE));
		}
		
		
		
	}
	
	public static void main(String a[]){
		DomMain myObj = new DomMain();
		ROOT = myObj.getDom().getDocumentElement().getNodeName()+"/";
		myObj.findSubElements(myObj.getDom().getDocumentElement());
	}
}
