package DP;

import com.google.common.base.Strings;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GTXAYB";
		System.out.println(lcSubString(a, b));
	}
	
	private static void printTable(int[][] table){
		for (int i = 0; i < table.length; i++) {
		    for (int j = 0; j < table[0].length; j++) {
		        System.out.print(table[i][j] + "   ");
		    }
		    System.out.print("\n");
		}
		System.out.println("====================================================");
	}
	
	private static int lcSubsequence(String a, String b){
		int[][] table = new int[a.length()+1][b.length()+1];
		
		if(Strings.isNullOrEmpty(a) || Strings.isNullOrEmpty(b))
			return 0;
		
		for(int j=0; j<=b.length(); j++){
			table[0][j] = 0;
		}
		
		for(int i=0; i<=a.length(); i++){
			table[i][0] = 0;
		}
		
		for(int i=1; i<=a.length(); i++){
			for(int j=1; j<=b.length(); j++){
				
				if(a.charAt(i-1) == b.charAt(j-1)){
					table[i][j] = 1+table[i-1][j-1];
				}
				else{
					table[i][j] = Math.max(table[i][j-1], table[i-1][j]);
				}
			}
		}
		
		System.out.println("Length of Longest Common String is "+table[a.length()][b.length()]);
		StringBuilder builder = new StringBuilder();
		int i=a.length(); int j = b.length();
		while(i>0 && j>0){
			if(a.charAt(i-1) == b.charAt(j-1)){
				builder.append(a.charAt(i-1));
				i--;j--;
			}
			else if(table[i-1][j]>table[i][j-1])
				i--;
			else
				j--;
		}
		
		System.out.println("And the sequence is "+builder.reverse().toString());
		
		
		printTable(table);
		return table[a.length()][b.length()];
	}
	
	
	private static int lcSubString(String a, String b){
		int[][] table = new int[a.length()+1][b.length()+1];
		int result = Integer.MIN_VALUE;
		int x=-1, y=-1;
		
		if(Strings.isNullOrEmpty(a) || Strings.isNullOrEmpty(b))
			return 0;
		
		for(int j=0; j<=b.length(); j++){
			table[0][j] = 0;
		}
		
		for(int i=0; i<=a.length(); i++){
			table[i][0] = 0;
		}
		
		for(int i=1; i<=a.length(); i++){
			for(int j=1; j<=b.length(); j++){
				
				if(a.charAt(i-1) == b.charAt(j-1)){
					table[i][j] = 1+table[i-1][j-1];
					if(table[i][j] > result){
						result = table[i][j];
						x =i;
						y= j;
					}
				}
				else{
					table[i][j] = 0;
				}
			}
		}
		
		System.out.println("Length of Longest Common String is "+result);
		StringBuilder builder = new StringBuilder();
		int tempResult = result;
		while(tempResult>0){
			builder.append(a.charAt(x-1));
			x--;y--;
			tempResult--;
		}
		
		System.out.println("And the sequence is "+builder.reverse().toString());
		
		
		printTable(table);
		return result;
	}
	
	

}
