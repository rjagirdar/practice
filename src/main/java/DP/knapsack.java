package DP;

public class knapsack {

	public static void main(String[] args) {
		int[] weights = {1,2,3};
		int[] values = {6,10,12};
		System.out.println(getOptimumValue(weights, values, 5));
		
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
	
	private static int getOptimumValue(int[] weights, int[] values, int W){
		int[][] table = new int[W+1][weights.length+1];
		
		for(int j=0; j<=weights.length; j++)
			table[0][j] =0;
		for(int i=0; i<=W; i++)
			table[i][0] = 0;
		
		for(int i=1; i<=W; i++){
			for(int j=1; j<=weights.length; j++){
				if(i>=weights[j-1]){
					table[i][j] = Math.max(table[i][j-1], values[j-1]+table[i-weights[j-1]][j-1]);
				}
				else
					table[i][j] = table[i][j-1];
			}
		}
		printTable(table);
		return table[W][weights.length];
	}

}
