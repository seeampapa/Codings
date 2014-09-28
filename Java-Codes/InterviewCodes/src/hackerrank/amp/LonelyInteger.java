/*
 * Class: LonelyInteger.java
 * Method: main() [PSVM]
 * ***********************************************************************
 * Description: This program accepts the set of integers from user 
 * and identifies all integers that do not have a pair/its duplication 
 * within the same set of integers
 * ***********************************************************************
 * Sample output 1
 * ---------------
 * Enter an odd number between 1 and 100
 * 3
 * Enter 3 Integers to find the Lonely one within it
 * 1 2 3
 * Lonely Integer: 1
 * Lonely Integer: 2
 * Lonely Integer: 3
 * ***********************************************************************
 * Sample output 2
 * ---------------
 * Enter an odd number between 1 and 100
 * 11
 * Enter 11 Integers to find the Lonely one within it
 * 12 13 44 12 98 10 10 12 13 44 12
 * Lonely Integer: 98
 * ***********************************************************************
 * Author: Pradeep A M
 * Email: ampradeep@outlook.com
 * ***********************************************************************
 */

package hackerrank.amp;

import java.util.ArrayList;
import java.util.Scanner;

public class LonelyInteger {
	public static void main(String[] args) {
		/*
		 * To Obtain & Validate User Inputs 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an odd number between 1 and 100");
		int N = sc.nextInt();	// User Input - N - Total Number of Integers
		
		if(N<1 || N>100 || N%2!=1){
			System.err.println("Invalid Total number of Integers.");
			System.exit(1);
		}
		System.out.println("Enter " + N + " Integers to find the Lonely one within it");
		ArrayList All = new ArrayList();
		for(int i=0;i<N;i++){
			int Ai = sc.nextInt();
			if(Ai>=0 && Ai<=100){
				All.add(Ai);
			}else{
				System.err.println("Invalid Number entered for comparison");
				System.exit(1);
			}
		}
		
		/*
		 * To find the Lonely integer
		 */
		int i=0;
		while(All.size() > 0){
			int compareWithOthers = (Integer) All.get(0);
			boolean foundPair = false;
			for(int j=0;j<All.size();j++){
				if(i==j){
					continue;
				}else{
					if(compareWithOthers == (Integer) All.get(j)){
						// this is a pair - removing both from list
						All.remove(j);
						All.remove(0);
						foundPair = true;
						break;
					}
				}
			}
			if(!foundPair){
				System.out.println("Lonely Integer: " + All.get(0));
				All.remove(0);
			}	
		}
	}
}
