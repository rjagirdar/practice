package sortsandsearches;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		arr = new int[]{12, 3, 5, 7, 19,4,8,31,22,17,9,1,6,11,10,13,15,2};
		bubbleSort(arr);
		for(int val : arr)
			System.out.print(val+" ");
	}
	
	private static void bubbleSort(int[] arr){
		if(arr.length==0)
			return;
		
		for(int pass=1; pass<=arr.length-1; pass++){
			
			for(int i=1; i<=arr.length-pass; i++){
				if(arr[i-1]>arr[i]){
					swap(arr,i-1,i);
				}
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
