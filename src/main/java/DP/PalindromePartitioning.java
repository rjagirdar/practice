package DP;

public class PalindromePartitioning {

	public static void main(String[] args) {
		String str = "bhavana";
		System.out.println(minCutsNeeded(str));
	}
	
	private static void printTable(int[][] table){
		for (int i = 0; i < table.length; i++) {
		    for (int j = 0; j < table[0].length; j++) {
		    	if(table[i][j] < 10)
		    		System.out.print(table[i][j] + "   ");
		    	else
		    		System.out.print(table[i][j] + "  ");
		    }
		    
		    System.out.print("\n");
		    //System.out.println("------------------------------------------------");
		}
		System.out.println("====================================================");
	}
	
	private static void printTable(boolean[][] table){
		for (int i = 0; i < table.length; i++) {
		    for (int j = 0; j < table[0].length; j++) {
		    	if(table[i][j])
		    		System.out.print(table[i][j] + "     ");
		    	else
		    		System.out.print(table[i][j] + "    ");
		    }
		    System.out.print("\n");
		}
		System.out.println("====================================================");
	}
	
	private static int minCutsNeeded(String str){
		
		boolean[][] palindrome = new boolean[str.length()][str.length()];
		int[][] cuts = new int[str.length()][str.length()];
		
		for(int i=0; i<str.length(); i++){
			palindrome[i][i] = true;
			cuts[i][i] = 0;
		}
		
		for(int i=0; i<str.length()-1; i++){
			palindrome[i][i+1] = str.charAt(i)==str.charAt(i+1);
			if(palindrome[i][i+1])
				cuts[i][i+1]=0;
			else
				cuts[i][i+1] = 1;
		}
		
		for(int gap=3; gap<=str.length();gap++){
			for(int i=0; i<str.length()-gap+1; i++){
				int j = i+gap-1;
				
				if(str.charAt(i) == str.charAt(j) && palindrome[i+1][j-1])
					palindrome[i][j] = true;
				else
					palindrome[i][j] = false;
				
				if(palindrome[i][j])
					cuts[i][j] = 0;
				else{
					cuts[i][j] = Integer.MAX_VALUE;
					for(int k=i; k<j; k++){
						cuts[i][j] = Math.min(cuts[i][k]+cuts[k+1][j]+1, cuts[i][j]);
					}
				}
			}
		}
		
		
		printTable(palindrome);
		printTable(cuts);
		return cuts[0][str.length()-1];
	}

}
