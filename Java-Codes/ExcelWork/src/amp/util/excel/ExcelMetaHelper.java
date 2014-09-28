package amp.util.excel;

import java.util.Date;
import java.util.HashMap;

import jxl.Cell;
import jxl.CellType;

public class ExcelMetaHelper extends ExcelUtil {
	
	public HashMap<String, Integer> columnNameMap = new HashMap<String, Integer>();
	public HashMap<String, Object> columnTypes = new HashMap<String, Object>();
	
	public ExcelMetaHelper(String filName, int sheetNo) {
		super(filName, sheetNo);
	}
	
	protected void setColumnDetails(){
		int i = 0;
		for(Cell cell : currSht.getRow(0)){
			columnNameMap.put(cell.getContents(), i);
			columnTypes.put(cell.getContents(), getColumnTypes()[i]);
			i++;
		}
	}
	
	protected int[] getColumnIndex(String[] cols){
		int[] selColIndex = new int[cols.length];
		
		for(int i=0;i<cols.length;i++)
			selColIndex[i] = columnNameMap.get(cols[i]);
		
		return selColIndex;
	}
	
	protected Object[] getColumnTypes(){
		int row = 1;
		Object[] res = getColumnTypes(row);
		while(res == null){
			res = getColumnTypes(++row);
		}
		return res;
	}
	
	private Object[] getColumnTypes(int row){
		String[] colType = new String[currSht.getColumns()];
		Object[] dataType = new Object[currSht.getColumns()];
		
		int i = 0;
		for(Cell cell : currSht.getRow(row)){
			if(cell.getType() == CellType.LABEL){
				colType[i] = "String";
				dataType[i] = String.class;
			}
			if(cell.getType() == CellType.DATE){
				colType[i] = "Date";
				dataType[i] = Date.class;
			}
			if(cell.getType() == CellType.NUMBER){
				if(cell.getContents().length()>8){
					colType[i] = "Long";
					dataType[i] = Long.class;
				}else{
					colType[i] = "Integer";
					dataType[i] = Integer.class;
				}
				if(cell.getContents().contains(".")){
					colType[i] = "Float";
					dataType[i] = Float.class;
				}
				
			}
			if(cell.getType() == CellType.NUMBER_FORMULA || 
					cell.getType() == CellType.STRING_FORMULA){
				colType[i] = "ExcelFormula";
			}
			if(cell.getType() == CellType.EMPTY 
					|| cell.getType() == CellType.ERROR){
				//try another Row
				return null;
			}
			i++;
		}
		
		return dataType;		
	}
}
