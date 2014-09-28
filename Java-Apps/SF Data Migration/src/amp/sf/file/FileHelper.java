package amp.sf.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileHelper {
	
	public static ArrayList<String> readFile(String filePath, String fileName){
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filePath+fileName)));
			String line;
			while((line = br.readLine())!=null){
				lines.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static Map<Integer, List<String>> readCSV(String filePath, String fileName){
		List<String> fields = null;
		Map<Integer, List<String>> records = new HashMap<Integer, List<String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filePath+fileName)));
			String line;
			int i = 0;
			while((line = br.readLine()) != null){
				fields = new ArrayList<String>();
				for(String field : line.split(",")){
					fields.add(field);
					System.out.print(field + " ");
				}
				records.put(++i, fields);
				System.out.println();
			}
			System.out.println();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}
	
	public static List<List<String>> readCSVFile(String filePath, String fileName){
		List<String> fields = null;
		List<List<String>> records = new LinkedList<List<String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filePath+fileName)));
			String line;
			while((line = br.readLine()) != null){
				fields = new ArrayList<String>();
				for(String field : line.split(",")){
					fields.add(field);
					System.out.print(field + " ");
				}
				records.add(fields);
				System.out.println();
			}
			System.out.println();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}
	
	public static void main(String args[]){
		Map<Integer, List<String>> records = readCSV("D:/WrkSpaces/SFDC WorkSpc/storeapp/data to import/", "cust.csv");
		
		System.out.println(records);
		Iterator<Integer> keys = records.keySet().iterator();
		while(keys.hasNext()){
			for(String field : records.get(keys.next())){
				System.out.print(field + ' ');
			}
			System.out.println();
		}
		
		// REGEX
		/*String s = "C-001";
		s.matches(regex)*/
		
	}
}
