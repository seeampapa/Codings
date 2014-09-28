package amp.sf.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class PickList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String pickListName;
	private String recordTypeId;
	private Map<String, List<String>> pickListValues;
	
	public PickList(){
		pickListValues = new Hashtable<String, List<String>>();
	}
	
	public PickList(String name,
			String recTypeIds, 
			Map<String, List<String>> valuesMap){
		this.pickListName = name;
		this.recordTypeId = recTypeIds;
		this.pickListValues = valuesMap;
	}
	
	public void setPickListName(String pickListName) {
		this.pickListName = pickListName;
	}
	
	public String getPickListName() {
		return pickListName;
	}
	
	public String getRelatedTypeIds() {
		return recordTypeId;
	}
	
	public Map<String, List<String>> getPickListValues() {
		return pickListValues;
	}
	
	/*
	 * If picklist is mapped to no Record Type IDs, provide 'NONE' in recTypeId
	 */
	public void addValues(String recTypeId, String pickListvalue){
		ArrayList<String> pickListVal;
		recordTypeId = recTypeId;
		if(recordTypeId!=null && pickListValues!=null){
			if(pickListValues.get(recTypeId)!=null){
				pickListVal = (ArrayList<String>) pickListValues.get(recTypeId);
			}else{
				pickListVal = new ArrayList<String>();
			}
			pickListVal.add(pickListvalue);
			pickListValues.put(recTypeId, pickListVal);
		}
	}
	
	public void addValues(String relTypeId, List<String> pickListVals){
		if(recordTypeId!=null && pickListValues!=null){
			pickListValues.put(relTypeId, pickListVals);
		}
	}
}
