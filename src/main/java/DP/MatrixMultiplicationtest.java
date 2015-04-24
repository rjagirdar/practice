package DP;

public class MatrixMultiplicationtest {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4};
		arr = new int[]{10, 20, 30};
		matrixmultiplication(arr);
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
	
	private static void matrixmultiplication(int[] arr){
		int[][] temp = new int[arr.length][arr.length];
		for(int i=1; i<arr.length; i++)
			temp[i][i] = 0;
		int n = arr.length;
		for(int gap=2; gap<=n; gap++){
			for(int i=1; i<n-gap+1; i++){
				int j=i+gap-1;
				int result = Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					result = Math.min(result, temp[i][k]+temp[k+1][j]+arr[i-1]*arr[k]*arr[j]);
				}
				temp[i][j] = result;
			}
		}
		printTable(temp);
		System.out.println("Min number of operations is "+temp[1][arr.length-1]);
	}

}
