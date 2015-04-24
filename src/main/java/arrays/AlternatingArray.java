package arrays;

public class AlternatingArray {

	public static void main(String[] args) {
		int[] arr = {10, 5, 6, 3, 2, 20, 100, 80};
		alternateArray(arr);
		for(int val : arr)
			System.out.print(val+" ");
	}
	
	private static enum Form{
		INCREASING,
		DECREASING
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void alternateArray(int[] arr){
		Form currForm = null;
		
		if(arr[0]>arr[1])
			currForm = Form.DECREASING;
		else
			currForm = Form.INCREASING;
		
		
		for(int i=2; i<arr.length; i++){
			
			int current_val = arr[i];
			int prev_val = arr[i-1];
			
			if(currForm== Form.INCREASING){
				if(current_val>prev_val){
					swap(arr, i, i-1);
				}
				currForm = Form.DECREASING;
			}
			else if(currForm== Form.DECREASING){
				if(current_val<prev_val){
					swap(arr,i,i-1);
				}
				currForm = Form.INCREASING;
			}
		}
	}
	

}
