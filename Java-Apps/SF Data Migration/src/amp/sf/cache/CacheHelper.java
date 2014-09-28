package amp.sf.cache;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import amp.util.excel.ExcelPersist;

public class CacheHelper {
	
	private String filePath;
	private String fileName;
	
	private Map<String, Field> fieldMap;
	
	private Map<String, PickList> pickListMap;
	
	private Map<String, List<String>> dependencyMap;
	
	public void loadFieldMap(){
		ExcelPersist sheet1 = new ExcelPersist(filePath + fileName, 0);
		String[] colsTBR = {"Field Name", "Controller Field", "Length", "Required", "AutoNumber", "Data Type", "Lookup Obj"};
		if(fieldMap == null)
			fieldMap = new Hashtable<String, Field>();
		for(ArrayList<String> a : sheet1.selectRow(colsTBR)){
			Field field = new Field();
			field.setFieldName(a.get(0));
			field.setControllerField(a.get(1));
			field.setLength(Integer.parseInt(a.get(2)));
			if(a.get(3).equals("Y"))
				field.setRequired(true);
			else
				field.setRequired(false);
			if(a.get(4).equals("Y"))
				field.setAutoNumber(true);
			else
				field.setAutoNumber(false);
			field.setDataType(a.get(5));
			field.setLookupObj(a.get(6).split(",")[0]);
			fieldMap.put(a.get(0), field);
		}
	}
	
	public void loadPickListMap(){
		ExcelPersist sheet2 = new ExcelPersist(filePath + fileName, 1);
		String[] colsTBR = {"PickList Name", "Record Type Id", "PickList Value"};
		if(pickListMap == null)
			pickListMap = new Hashtable<String, PickList>();
		PickList picklist = null;
		for(ArrayList<String> a : sheet2.selectRow(colsTBR)){
			if(pickListMap.get(a.get(0))!=null){
				picklist = pickListMap.get(a.get(0));
			}else{
				picklist = new PickList();
				picklist.setPickListName(a.get(0));
			}
			picklist.addValues(a.get(1), a.get(2));
			pickListMap.put(a.get(0), picklist);
		}
	}
	
	public void loadDependencyMap(){
		ExcelPersist sheet3 = new ExcelPersist(filePath + fileName, 1);
		String[] colsTBR = {"CF Name", "DF Name", "CF Value", "DF Value"};
		if(dependencyMap == null)
			dependencyMap = new Hashtable<String, List<String>>();
		List<String> dependencies = null;
		for(ArrayList<String> a : sheet3.selectRow(colsTBR)){
			if(dependencyMap.get(a.get(0)+":"+a.get(1)+":"+a.get(2))!=null)
				dependencies = dependencyMap.get(a.get(0)+":"+a.get(1)+":"+a.get(2));
			else{
				dependencies = new ArrayList<String>();
			}
			dependencies.add(a.get(3));
			dependencyMap.put(a.get(0)+":"+a.get(1)+":"+a.get(2), dependencies);
		}
	}
	
}