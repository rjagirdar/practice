package sortsandsearches;

public class IterativeMergeSort {

	public static void main(String[] args) {
		int[] arr= {11,15,6,8,9};
		sort(arr);
		for(int val : arr)
			System.out.print(val+" ");
	}
	
	private static void sort(int[] arr){
		iterativeMergeSort(arr);
	}
	
	private static void iterativeMergeSort(int[] arr){
		int curr_size = 1;
		int n = arr.length;
		int left = 0;
		for(curr_size = 1; curr_size<=n-1; curr_size=curr_size*2){
			
			for(left=0; left<n-1; left=left+2*curr_size){
				int mid = left+curr_size-1;
				int right = Math.min(left+2*curr_size-1, n-1);
				merge(arr, left, mid, right);
			}
			
		}
		
	}
	
	private static void merge(int[] arr, int l, int m, int r){
		int[] temp = new int[r-l+1];
		int i=l;
		int j = m+1;
		int k=0;
		while(i<=m && j<=r){
			if(arr[i]<arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		
		if(i<=m){
			while(i<=m)
				temp[k++] = arr[i++];
		}
		if(j<=r){
			while(j<=r)
				temp[k++] = arr[j++];
		}
		
		for(int index = 0; index<k; index++){
			arr[index+l] = temp[index];
		}	
	}

}
