package DP;

import java.util.Arrays;

public class MaximumIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5, 99,6};
		mis(arr);
	}
	
	private static void mis(int[] arr){
		int[] temp = Arrays.copyOf(arr, arr.length);
		int[] seq = new int[arr.length];
		Arrays.fill(seq, -1);
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i]>arr[j] && temp[i]<temp[j]+arr[i]){
					temp[i] = temp[j]+arr[i];
					seq[i] = j;
				}
			}
		}
		
		
		int max = temp[0];
		int max_index = 0;
		for(int i=1; i<arr.length; i++){
			if(temp[i]>max){
				max = temp[i];
				max_index = i;
			}
		}
		System.out.println("Came Here");
		System.out.println(arr[max_index]);
		for(int i = max_index; seq[i]!=-1; i=seq[i]){
			System.out.println(arr[seq[i]]);
		}
		
	}

}
