package DP;

import java.util.Arrays;

public class MinCostToReachDestination {

	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		int[][] costMatrix = {{0,15,80,90},{0,0,40,50},{0,0,0,70},{0,0,0,0}};
		System.out.println("Cost to Reach 3 from 0 is "+minCostToReachDestination(costMatrix));

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
	
	private static int minCostToReachDestination(int[][] costs){
		
		int[][] finalCosts = new int[costs.length][costs[0].length];
		int i=0;
		int n=costs[0].length;
		for(int[] row : costs){
			finalCosts[i++] = Arrays.copyOf(row, row.length);
		}
		
		for(int gap=3; gap<=n; gap++){
			for(i=0; i<n-gap+1; i++){
				int j=i+gap-1;
				finalCosts[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++){
					finalCosts[i][j] = Math.min(finalCosts[i][j], costs[i][k]+costs[k][j]);
				}
			}
		}
		printTable(finalCosts);
		return finalCosts[0][n-1];
	}

}
