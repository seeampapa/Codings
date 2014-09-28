package amp.main;

import java.util.ArrayList;

import amp.util.excel.ExcelPersist;

public class AmpMain {

	public static void main(String[] args) {
		ExcelPersist meta = new ExcelPersist("DUP.xls", 0);
		
		String[] colsTBR = {"Car", "OnRoad"};
		String[] rowsTBR = {"Car=XUV"};
		
		for(ArrayList<String> a : meta.selectRow(colsTBR, rowsTBR)){
			for(String s : a){
				System.out.print(s + "  ");
			}
			System.out.println();
		}
		meta.makeDuplicate();
	}
}
