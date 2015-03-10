package DP;

public class MinCostPath {

	public static void main(String[] args) {
		int[][] costs = {{1, 2, 3},{4, 8, 2},{1, 5, 3}};
		System.out.println(minCost(costs));
	}
	
	private static int minCost(int[][] cost){
		int[][] table = new int[cost.length][cost[0].length];
		
		table[0][0] = cost[0][0];
		
		for(int j=1; j<table[0].length;j++)
			table[0][j] = table[0][j-1] + cost[0][j];
		
		for(int i=1; i<table.length; i++){
			table[i][0] = table[i-1][0] + cost[i][0];
		}
		
		for(int i=1; i<table.length; i++){
			for(int j=1; j<table[0].length; j++){
				table[i][j] = cost[i][j] + Math.min(Math.min(table[i][j-1], table[i-1][j]), table[i-1][j-1]);
			}
		}
		return table[table.length-1][table[0].length-1];
	}

}
