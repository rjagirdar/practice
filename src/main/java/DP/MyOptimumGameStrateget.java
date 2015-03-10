package DP;

public class MyOptimumGameStrateget {

	public static void main(String[] args) {
		int arr[] = {8,15,3,7};
		System.out.println(maxScore(arr));
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
		}
		System.out.println("====================================================");
	}
	
	private static int maxScore(int[] arr){
		int[][] table = new int[arr.length][arr.length];
		
		for(int i=0; i<arr.length; i++){
			table[i][i] = arr[i];
		}
		for(int i=0; i<arr.length-1; i++){
			table[i][i+1] = Math.max(arr[i], arr[i+1]);
		}
		
		for(int k=3; k<=arr.length; k++){
			for(int i=0; i<arr.length-k+1; i++){
				int j= i+k-1;
				
				/*Choosing i*/
				int a = arr[i]+Math.min(table[i+1][j-1], table[i+2][j]);
				
				/*Choosing j*/
				int b = arr[j]+Math.min(table[i+1][j-1], table[i][j-2]);
				
				table[i][j] = Math.max(a, b);
			}
		}
		
		printTable(table);
		return table[0][arr.length-1];
	}
	
	

}
