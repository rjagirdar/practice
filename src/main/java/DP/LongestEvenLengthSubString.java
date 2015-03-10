package DP;

public class LongestEvenLengthSubString {

	public static void main(String[] args) {
		int[] arr = {1,5,3,8,0,2,3};
		arr = new int[]{1,2,3,1,2,3};
		System.out.println(findLength(arr));
	}
	
	private static int findLength(int[] arr){
		int[][] table = new int[arr.length][arr.length];
		int max_len = Integer.MIN_VALUE;
		int start=0,end=0;
		
		for(int i=0; i<arr.length; i++)
			table[i][i] = arr[i];
		
		for(int gap=2; gap<=arr.length; gap++){
			
			for(int i=0; i<arr.length-gap+1; i++){
				int j=i+gap-1;
				int k = gap/2;
				
				table[i][j] = table[i][j-k]+table[j-k+1][j];
				
				if(gap%2==0 && table[i][j-k] == table[j-k+1][j] && gap>max_len ){
					max_len = gap;
					start = i;
					end = j;
				}
			}
		}
		
		for(int i=start; i<=end; i++){
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
		System.out.println("================");
		return max_len;
	}

}
