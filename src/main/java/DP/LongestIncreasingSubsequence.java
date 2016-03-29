package DP;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println("lis is "+longestIncreasingSubsequence(arr));
		System.out.println();
		lis(arr);
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
	
	private static int ceil(int[] arr, int[] tailIndices, int l, int r, int key){
		/*if(arr[l]>key)
			return l;
		if(arr[r]<key)
			return -1;*/
		
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(arr[tailIndices[mid]]>=key)
				r=mid;
			else
				l=mid;
		}
		if(arr[tailIndices[l]]>key)
			return l;
		else
			return r;
	}
	
	private static void lis(int[] arr){
		int[] tailIndices = new int[arr.length];
		int[] prevIndices = new int[arr.length];
		int len =1;
		tailIndices[0] = 0;
		prevIndices[0] = -1;
		
		for(int i=1; i<arr.length; i++){
			if(arr[i]<arr[tailIndices[0]]){
				prevIndices[i] = -1;
				tailIndices[0] = i;
			}
			else if(arr[i] > arr[tailIndices[len-1]]){
				prevIndices[i] = tailIndices[len-1];
				tailIndices[len++] = i;
			}
			else{
				int pos = ceil(arr,tailIndices,0,len-1,arr[i]);
				if(pos!=-1){
					prevIndices[i] = tailIndices[pos-1];
					tailIndices[pos] = i;
				}
			}
		}
		
		for (int i=0; i<arr.length; i++){
			System.out.print(tailIndices[i]+"  ");
		}
		System.out.println();
		for (int i=0; i<arr.length; i++){
			System.out.print(prevIndices[i]+"  ");
		}
		System.out.println();
		System.out.println("=========================================");
		
		for(int i=tailIndices[len-1]; i>=0; i=prevIndices[i]){
			System.out.print(arr[i]+" ");
		}
		
	}

}
