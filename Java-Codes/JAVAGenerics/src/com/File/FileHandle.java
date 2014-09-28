package com.File;

import java.io.*;

import com.excep.*;

public class FileHandle {
	/*private File f1;
	private File f2;
	
	FileHandle(){
		
	}
	
	FileHandle(String fileName){
		if(!fileName.contains("/")){
			fileName = "./" + fileName;
		}
		f1 = new File(fileName);
	}
	
	FileHandle(String fileName, String destFileName){
		if(!fileName.contains("/")){
			fileName = "./" + fileName;
		}
		if(!destFileName.contains("/")){
			destFileName = "./" + destFileName;
		}
		f1 = new File(fileName);
		f2 = new File(destFileName);
	}
	*/
	
	public void app2File(String f1, String msg){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(f1),true));
			bw.write(msg);
			bw.newLine();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeNewFile(String f1, String msg){
		try {
			File f = new File(f1);
			if(f.exists() && f.length()>0){
				f.delete();
				f.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(msg);
			bw.newLine();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copyAppFile(String f1, String f2){
		String s = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(f1)));
			while((s = br.readLine())!=null){
				app2File(f2, s);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] readFile(String f1){
		String s = null;
		String[] st = new String[100];
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(f1)));
			while((s = br.readLine())!=null){
				System.out.println(s);
				st[i] = s;
				i++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public String[] crlfReadFile(String f1){
		String[] st = new String[100];
		int srt = 0; int end = 80;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(f1)));
			String s = br.readLine();
			// System.out.println(s);
			int j = 0;
			for(int i = 0; i<s.length()/80; i++){
				System.out.println(srt+"::"+end+"::"+s.substring(srt, end));
				st[i] = s.substring(srt, end);
				srt = srt + 80;
				end = end + 80;
				j = i;
			}
			
			if((s.length()%80)!=0){
				System.out.println(s.length()%80);
				st[j] = s.substring(srt, s.length());
			}
				
			// last element for st array is missing rite now
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public boolean isWritable(String f1) throws Terminate{
		String excep = null;
		File f = new File(f1);
		if(!f.exists()){
			try{
				f.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
			
		if(!(new File(f1).canWrite())){
			excep = "Error:: Unable to open " + f1 + " for Writing.";
			throw new Terminate(excep);
		}else
			return true;
	}
	
	public boolean isReadable(String f1) throws Terminate{
		String excep = null;
		File f = new File(f1);
		if(!f.exists()){
			try{
				f.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		if(!(new File(f1).canRead())){
			excep = "Error:: Unable to open " + f1 + " for Reading.";
			throw new Terminate(excep);
		}else
			return true;
	}
}
