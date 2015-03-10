package DP;

public class RodCutting {
	
	public static void main(String[] args){
		int[] values = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = 8;
		System.out.println("Max Price to cut rod of length "+n+" is "+numOfWays(n, values));
				
	}
	
	public static int numOfWays(int n, int[] values){
		int[] table = new int[n+1];
		table[0] = 0;
		for(int i=1; i<=n; i++){
			int max_val = Integer.MIN_VALUE;
			for(int j=0; j<i; j++){
				max_val = Math.max(max_val, table[j]+values[i-j-1]);
			}
			table[i] = max_val;
		}
		return table[n];
	}
}
