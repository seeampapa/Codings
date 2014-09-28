package amp.test;

import java.util.HashMap;

public class StaticVariables {
	
	public static HashMap<String, Object> XMLElements;
	
	static {
		XMLElements = new HashMap<String, Object>();
		XMLElements.put("string", java.lang.String.class);
		XMLElements.put("integer", java.lang.Integer.class);
		XMLElements.put("int", java.lang.Integer.class);
		XMLElements.put("long", java.lang.Long.class);
		XMLElements.put("short", java.lang.Short.class);
		XMLElements.put("decimal", java.lang.Float.class);
		XMLElements.put("float", java.lang.Float.class);
		XMLElements.put("double", java.lang.Double.class);
		XMLElements.put("boolean", java.lang.Boolean.class);
		XMLElements.put("byte", java.lang.Byte.class);
		XMLElements.put("datetime", java.util.Date.class);
		XMLElements.put("date", java.util.Date.class);
		XMLElements.put("time", java.util.Date.class);
		XMLElements.put("anyType", java.lang.Object.class);
	}
	
}
