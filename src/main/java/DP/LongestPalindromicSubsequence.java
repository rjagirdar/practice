package DP;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String input = "RAGHUVEER";
		System.out.println(longestPalindromicSubsequence(input));
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
	
	
	private static int longestPalindromicSubsequence(String input){
		int[][] table = new int[input.length()][input.length()];
		
		int n = input.length();
		for(int i=0; i<n; i++)
			table[i][i] =1;
		for(int k=2; k<=n; k++){
			for(int i =0; i<n-k+1; i++){
				int j = i+k-1;
				
				if(input.charAt(i) == input.charAt(j)){
					
					if(j==i+1){
						table[i][j] = 2;
					}
					else
						table[i][j] = 2+ table[i+1][j-1];
				}
				else
					table[i][j] = Math.max(table[i+1][j], table[i][j-1]);
			}
		}
		
		printTable(table);
		return table[0][n-1];
	}

}
