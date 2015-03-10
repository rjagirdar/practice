package DP;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println("lis is "+longestIncreasingSubsequence(arr));
	}
	
	private static int longestIncreasingSubsequence(int[] arr){
		int[] lis = new int[arr.length];
		int[] seq = new int[arr.length];
		
		if(arr.length == 0)
			return -1;
		for(int i=0; i<arr.length; i++){
			lis[i] =1;
			seq[i] = -1;
		}
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] && lis[i]<lis[j]+1){
					lis[i] = lis[j]+1;
					seq[i] = j;
				}
			}
		}
		
		int i = arr.length-1;
		System.out.print(arr[i]+" ");
		while(seq[i]!=-1){
			System.out.print(arr[seq[i]]+" ");
			i=seq[i];
		}
		System.out.println();
		return lis[arr.length-1];
	}

}
