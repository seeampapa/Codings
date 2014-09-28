package amp.sf.cache;

public class Field {
	private String fieldName;
	private String controllerField;
	private int length;
	private boolean isRequired;
	private boolean isAutoNumber;
	private String dataType;
	private String lookupObj;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getControllerField() {
		return controllerField;
	}
	public void setControllerField(String controllerField) {
		this.controllerField = controllerField;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isRequired() {
		return isRequired;
	}
	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}
	public boolean isAutoNumber() {
		return isAutoNumber;
	}
	public void setAutoNumber(boolean isAutoNumber) {
		this.isAutoNumber = isAutoNumber;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getLookupObj() {
		return lookupObj;
	}
	public void setLookupObj(String lookupObj) {
		this.lookupObj = lookupObj;
	}
}
