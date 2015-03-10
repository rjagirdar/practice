package arrays;

import java.util.Arrays;

public class ZeroReplacementToFormMax1s {

	public static void main(String[] args) {
		int[] arr = {1,1,0,0,1,0,1,1,1,0,1,1,1};
		replacementIndex(arr);
	}
	
	private static int replacementIndex(int[] arr){
		if(arr.length==0)
			return -1;
		int count=0;
		
		for(int i=0; i<arr.length; i++){
			count+=arr[i]==0?1:0;
		}
		System.out.println(count);	
		
		int[] next= new int[arr.length];
		int[] prev = new int[arr.length];
		
		Arrays.fill(next, Integer.MIN_VALUE);
		Arrays.fill(prev, Integer.MIN_VALUE);
		
		int previous=-1;int next_0=-1;
		
		for(int i=0;i<arr.length; i++){
			if(arr[i]==0){
				prev[i]=previous;
				previous=i;
			}
		}
		
		for(int i=arr.length-1; i>=0;i--){
			if(arr[i]==0){
				next[i] = next_0;
				next_0=i;
			}
		}
		
		
		
		
		return -1;
	}

}
