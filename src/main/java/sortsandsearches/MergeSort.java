package sortsandsearches;

public class MergeSort {

	private static int countInversions = 0;
	public static void main(String[] args) {
		int[] arr = {4,2,3,1};
		arr = new int[]{12, 3, 5, 7, 19,4,8,31,22,17,9,1,6,11,10,13,15,2};
		sort(arr);
		for(int val : arr)
			System.out.print(val+" ");
		System.out.println();
		System.out.println("No. Of Inversions is "+countInversions);
		
	}
	
	
	private static void sort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}
	
	
	
	private static void mergeSort(int[] arr, int start, int end){
		if(start == end)
			return;
		int mid = start+((end-start)/2);
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		merge(arr, start, end, mid);
	}
	
	private static void merge(int[] arr, int start, int end, int mid){
		int size = end-start+1;
		int[] temp = new int[size];
		int tempIndex = 0;
		
		
		int i=start;int j=mid+1;
		while(i<=mid && j<=end){
			if(arr[i] < arr[j]){
				temp[tempIndex++] = arr[i++]; 
			}
			else{
				temp[tempIndex++] = arr[j++];
				countInversions+=mid-i+1;
			}
		}
		
		while(i<=mid){
			temp[tempIndex++] = arr[i++];
		}
		while(j<=end){
			temp[tempIndex++] = arr[j++];
		}
		
		for(int k=start,m=0; k<=end && m<=size-1; k++,m++){
			arr[k] = temp[m];
		}
	}

}
