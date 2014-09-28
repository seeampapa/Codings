package amp.util.excel;

import java.awt.Label;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Cell;
import jxl.write.WritableCell;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelPersist extends ExcelMetaHelper {
	
	public ExcelPersist(String filName, int sheetNo) {
		super(filName, sheetNo);
		setColumnDetails();
	}

	public ArrayList<ArrayList<String>> selectRow(String[] expCol){
		int[] selColIndex = getColumnIndex(expCol);
		int rows = currSht.getRows();
		int row = 1;
		
		ArrayList<ArrayList<String>> multipleRows = new ArrayList<ArrayList<String>>();
		
		while(row<rows){
			ArrayList<String> currRow = new ArrayList<String>();
			
			for(int colIndex : selColIndex){
				currRow.add(currSht.getCell(colIndex, row).getContents());
			}
			
			multipleRows.add(currRow);
			row++;
			currRow = null;
			System.gc();
		}
		return multipleRows;
	}
	
	public HashMap<String, ArrayList<String>> selectRow(String[] expCol, String keyColn){
		return null;
	}
	
	public ArrayList<ArrayList<String>> selectRow(String[] expCol, String[] expRow){
		//ArrayList<ArrayList<String>> allRows = new ArrayList<ArrayList<String>>();
		//allRows = selectRow(expCol);
		ArrayList<ArrayList<String>> allRows = selectRow(expCol);
		int[] selColIndex = getColumnIndex(expCol);
		
		int rows = currSht.getRows();
		int row = 1;
		
		for(int i=0;i<expRow.length;i++){
			String var = expRow[i].split("=")[0];
			String val = expRow[i].split("=")[1];
			
			ArrayList<ArrayList<String>> multipleRows = new ArrayList<ArrayList<String>>();
			
			while(row<rows){
				ArrayList<String> currRow = new ArrayList<String>();
				
				for(int colIndex : selColIndex){
					currRow.add(currSht.getCell(colIndex, row).getContents());
					if(var.equals(columnNameMap.get(colIndex))){
						Label label = new Label(val);
						try {
							WritableCell wc = currSht.getWritableCell(row, colIndex);
							currSht.addCell(wc);
						} catch (RowsExceededException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (WriteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
						
				}
				
				multipleRows.add(currRow);
				row++;
				currRow = null;
				System.gc();
			}
		}
		
		return allRows;
	}
	
	public void makeDuplicate(){
		closeFiles();
	}
}
