/*
 * This Java Class would be helpful in finding the datatype of any inputs.
 * 		Inputs can be from 
 * 			- console (runtime Input from Keys)
 * 			- a file (through file input stream)
 * 			- a DB (resultset of a query)
 * 
 * This is basically differentiated by the ASCII value of the keys entered or
 * the characters read. SOME OF THE ASCII VALUES ARE DISPLAYED BELOW:
 * 
 * *************************************
 *   .			|	46			> isDot
 * 	 0-9		|	48-57		> isNum
 * 	 spl chr	|	33-47		> isSpl
 * 	 spl chr	|	58-64		> isSpl
 * 	 A-Z		|	65-90		> isUpp
 * 	 spl chr	|	91-96		> isSpl
 * 	 a-z		|	97-122		> isLow
 * 	 spl		|	123-126		> isSpl
 * 	 DEL		|	127			> 
 * 	 ESC		|	27			> 
 * 	 SPACE		|	32			> isSpc
 * 	 new Lin	|	10			>
 * 	 SPL KEYs	|	0-32		>
 * ************************************
 * 
 * Basics of JAVA DataTypes:
 * ------------------------
 * Data Type	Default Value	Max Value
 * ---------	-------------	---------
 * byte			0
 * short		0
 * int			0				2147483647
 * long			0L				9223372036854775807L
 * float		0.0f			saves memory(32bit)
 * double		0.0d			(64bit)
 * char			'\u0000'
 * String   	null
 * boolean		false
 * 
 * 
 */
package com.datatype;

//import java.util.Scanner;

public class FindDataType {
	private String inp;
	
	//Process Flags
	private boolean isDot = false;
	private boolean isNum = false;
	private boolean isSpl = false;
	private boolean isUpp = false;
	private boolean isLow = false;
	private boolean isSpc = false;
	
	//Output Strings
	private static final String INTEGER = "INT";
	private static final String LONG = "LNG";
	private static final String STRING = "STR";
	private static final String CHAR = "CHR";
	private static final String FLOAT = "FLT";
	private static final String BOOLEAN = "BLN";
//	private static final String DATE = "DAT";
//	private static final String DATEFORM = "DATFOR";
	
	private String out = STRING; // By Default
	
	public FindDataType(String inp){
		this.inp = inp;
		findDataType();
	}
	
	public String getOut() {
		return out;
	}
	
	private void findDataType(){
		int NoofDot = 0;
		
		for(int i=0;i<inp.length();i++){
			int ASCII = (int)inp.charAt(i);
			if(ASCII == 46){
				isDot = true;
				++NoofDot;
			}
			if(ASCII >= 48 && ASCII <= 57)
				isNum = true;
			if((ASCII >= 33 && ASCII <= 45) || (ASCII == 47) || (ASCII >= 58 && ASCII <= 64) 
					|| (ASCII >= 91 && ASCII <= 96) || (ASCII >= 123 && ASCII <= 126))
				isSpl = true;
			if(ASCII >= 65 && ASCII <= 90)
				isUpp = true;
			if(ASCII >= 97 && ASCII <= 122)
				isLow = true;
			if(ASCII == 32)
				isSpc = true;
		}
		
		//Check for boolean
		if(inp.equals("true") || inp.equals("false"))
			out = BOOLEAN;

		//Check for CHAR
		if(inp.length() == 1 && !isNum)
			out = CHAR;
		
		//Check for INT or LONG
		if(isNum && !isDot && !isLow && !isUpp && !isSpc && !isSpl){
			boolean isInt = true;
			boolean isLong = true;
			try{
				Integer.parseInt(inp);
			}catch(NumberFormatException e){
				System.err.println("INT grt than 2147483647, so Checking for LONG");
				isInt = false;
			}
			try{
				Long.parseLong(inp);
			}catch(NumberFormatException e){
				System.err.println("LONG grt than 9223372036854775807, so declared as String");
				isLong = false;
			}
			
			if(isInt && isLong){
				out = INTEGER;
			}
			
			if(!isInt && isLong)
				out = LONG;
		}
			
		
		//Check for DOUBLE
		if(isNum && isDot && NoofDot==1 && !isLow && !isUpp && !isSpc && !isSpl)
			out = FLOAT;
	}

//	public static void main(String a[]){
//		while(true){
//			System.out.println("Enter any input: "); 
//			Scanner s = new Scanner(System.in);
//			String id = s.next();
//			
//			FindDataType dt = new FindDataType(id);
//			System.out.println(dt.out);
//		}
//		/*String j = "2147483647";
//		String i = "9223372036854775809";
//		int Ji = Integer.parseInt(j);
//		long Ij = Long.parseLong(i);*/
//	}
}