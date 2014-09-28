package amp.test;

public class Elements {
	
	// mandatory
	private String nameAttr;
	
	// mandatory
	private String typeAttr;
	
	private int minOccursAttr;
	
	private int maxOccursAttr;
	
	private String defaultAttr;
	
	private String fixedAttr;

	public String getNameAttr() {
		return nameAttr;
	}

	public void setNameAttr(String nameAttr) {
		this.nameAttr = nameAttr;
	}

	public String getTypeAttr() {
		return typeAttr;
	}

	public void setTypeAttr(String typeAttr) {
		this.typeAttr = typeAttr;
	}
	
	public boolean isXmlType(){
		if(StaticVariables.XMLElements.get(getTypeAttr().split(":")[1])!=null)
			return true;
		else
			return false;
	}

	public int getMinOccursAttr() {
		return minOccursAttr;
	}

	public void setMinOccursAttr(int minOccursAttr) {
		this.minOccursAttr = minOccursAttr;
	}

	public int getMaxOccursAttr() {
		return maxOccursAttr;
	}

	public void setMaxOccursAttr(int maxOccursAttr) {
		this.maxOccursAttr = maxOccursAttr;
	}

	public String getDefaultAttr() {
		return defaultAttr;
	}

	public void setDefaultAttr(String defaultAttr) {
		this.defaultAttr = defaultAttr;
	}

	public String getFixedAttr() {
		return fixedAttr;
	}

	public void setFixedAttr(String fixedAttr) {
		this.fixedAttr = fixedAttr;
	}

}
