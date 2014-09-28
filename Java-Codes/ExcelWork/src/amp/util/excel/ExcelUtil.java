package amp.util.excel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelUtil {
	
	protected Workbook wb;
	
	protected WritableWorkbook wwb;
	
	protected WritableSheet currSht;
	
	public ExcelUtil(String filName, int sheetNo) {
		try {
			wb = Workbook.getWorkbook(new File(filName));
			wwb = Workbook.createWorkbook(new File("DUP.xls"), wb);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fetchSheet(sheetNo);
	}
	
	private void fetchSheet(int sheetNo){
		currSht = wwb.getSheet(sheetNo);
	}
	
	protected void closeFiles(){
		wb.close();
		try {
			wwb.write();
			wwb.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void writeToFile(String filName){
		try {
			wwb = Workbook.createWorkbook(new File("DUP.xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}