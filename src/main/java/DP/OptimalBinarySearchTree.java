package DP;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		int[] arr = {10,12,20};
		int[] freq = {34,8,50};
		
		System.out.println(getMinCost(arr, freq));
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
	
	private static int getMinCost(int[] arr, int[] freq){
		int[][] table = new int[arr.length][arr.length];
		
		
		for(int i=0; i<arr.length; i++)
			table[i][i] = freq[i];
		
		for(int gap =2; gap<=arr.length; gap++){
			for(int i=0; i<arr.length-gap+1; i++){
				int j = i+gap-1;
				table[i][j] = Integer.MAX_VALUE;
				for(int r=i;r<=j; r++){
					int a,b;
					if(r==i)
						a=0;
					else
						a=table[i][r-1];
					if(r==j)
						b=0;
					else
						b=table[r+1][j];
					int c = a+b+getSum(freq,i,j);
					table[i][j] = Math.min(table[i][j], c);
						
				}
				
			}
		}
		printTable(table);
		return table[0][arr.length-1];
	}
	
	private static int getSum(int[] freq, int i, int j){
		int sum =0;
		for(int k = i; k<=j; k++){
			sum+=freq[k];
		}
		return sum;
	}

}
