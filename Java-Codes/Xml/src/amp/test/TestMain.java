package amp.test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.xml.sax.SAXException;

import com.sun.xml.xsom.XSAttributeDecl;
import com.sun.xml.xsom.XSAttributeUse;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSDeclaration;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.parser.XSOMParser;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("shiporder.xsd");
		XSOMParser parser = new XSOMParser();
		XSSchema xsd = null;
		try {
			parser.parse(file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			xsd = parser.getResult().getSchema(1);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<? extends XSAttributeUse> coll = xsd.getComplexType("shiptotype").getAttributeUses();
		Iterator<? extends XSAttributeUse> iter = coll.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().getDecl().getName());
		}
	}
}