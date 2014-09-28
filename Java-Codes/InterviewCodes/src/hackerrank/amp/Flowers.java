package hackerrank.amp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Flowers {
	
	private static String readConsole(){
		try{
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    return br.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k = 10; // no of friends
		int n = 13; // no of flowers at store
		int c[] = {12,34,23,54,23,12,42,23,56,84,35,23,11};
		Arrays.sort(c);
		System.out.println(c);
		
		/*int c[] = new int[n];
		for(int i=0; i<n; i++){
			c[i] = Integer.parseInt(readConsole());
		}*/
		
		if(k>n){
			System.err.println("Invalid Input.");
			System.exit(1);
		}
		
		int t=0;
		for(int i=1; i<=n; i++){
			if(i>k)
				
			t+=i;
		}
		
		
		

	}

}
