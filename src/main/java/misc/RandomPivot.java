package misc;

public class RandomPivot {

	public static void main(String[] args) {
		int[] arr1 = {3,1,5,6,2,4,7};
		int[] arr2 = {6,3,4,5,1,7,2};
		
		
		/*for(int i=1; i<=7; i++){
			System.out.println(i+":"+partition(arr, 0, arr.length-1, i));
		}*/
		
		matchPairs(arr1, arr2, 0, arr1.length-1);
		for(int val : arr1){
			System.out.print(val+" ");
		}
		System.out.println();
		System.out.println("========================");
		for(int val : arr2){
			System.out.print(val+" ");
		}
	}
	
	
	private static int partition(int[] arr, int left, int right, int randomPivot){
		int i = left;
		int temp1, temp2;
		for(int j=left; j<right; j++){
			if(arr[j]<randomPivot){
				temp1 = arr[j];
				arr[j] = arr[i];
				arr[i] = temp1;
				i++;
			}
			else if(arr[j] == randomPivot){
				temp1 = arr[right];
				arr[right] = arr[j];
				arr[j] = temp1;
				j--;
			}
		}
		temp2 = arr[right];
		arr[right] = arr[i];
		arr[i] = temp2;
		
		
		return i;
	}
	
	private static void matchPairs(int[] arr1, int[] arr2, int left, int right){
		if(left<right){
			int index = partition(arr1, left, right, arr2[0]);
			partition(arr2, left, right, arr1[index]);
			
			matchPairs(arr1, arr2, left, index-1);
			matchPairs(arr1, arr2, index+1, right);
		}
	}
	

}
