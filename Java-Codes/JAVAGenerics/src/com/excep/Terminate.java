package com.excep;

@SuppressWarnings("serial")
public class Terminate extends Exception{
	String msg;
	
	public Terminate(String msg){
		this.msg = msg; 
	}
	
	public String toString(){
		return msg;
	}
}

