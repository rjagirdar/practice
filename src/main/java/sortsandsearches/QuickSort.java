package sortsandsearches;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {3,5,6,1,2,4};
		arr = new int[]{12, 3, 5, 7, 19,4,8,31,22,17,9,1,6,11,10,13,15,2};
		sort(arr);
		for(int val : arr)
			System.out.print(val+" ");
	}
	
	private static void sort(int[] arr){
		quickSort(arr, 0, arr.length-1);
	}
	
	private static int partition(int[] arr, int left, int right){
		if(left>=right)
			return -1;
		int pivot = arr[left];
		int j=left+1;
		for(int i=left+1; i<=right; i++){
			if(arr[i] < pivot){
				swap(arr,i,j);
				j++;
			}
		}
		
		swap(arr,left,j-1);
		return j-1;
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void quickSort(int[] arr, int left, int right){
		if(left<right){
			int index = partition(arr, left, right);
			quickSort(arr, left, index-1);
			quickSort(arr, index+1, right);
		}
	}

}
