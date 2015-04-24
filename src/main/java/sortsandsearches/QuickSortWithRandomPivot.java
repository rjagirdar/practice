package sortsandsearches;

import java.util.Random;


public class QuickSortWithRandomPivot {

	static Random random = new Random();
	public static void main(String[] args) {
		int[] arr = {3,5,6,1,2,4};
		arr = new int[]{12, 3, 5, 7, 19,4,8,31,22};
		sort(arr);
		for(int val : arr)
			System.out.print(val+" ");
	}
	
	private static void sort(int[] arr){
		quicksort(arr, 0, arr.length-1);
	}
	
	private static int getRandomNumber(int low, int high){
		return random.nextInt(high-low+1);
	}
	
	private static int randomPivotPartition(int[] arr, int low, int high){
		
		int randomIndex = getRandomNumber(low, high); 
		int pivot = arr[low+randomIndex];
		
		int j=low;
		for(int i=low; i<high; i++){
			if(arr[i]<pivot){
				swap(arr,i,j);
				j++;
			}
			else if(arr[i] == pivot){
				swap(arr,high,i);
				i--;
			}
		}
		swap(arr,high,j);
		return j;
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void quicksort(int[] arr, int low, int high){
		if(low<high){
			int partition = randomPivotPartition(arr, 0, arr.length-1);
			quicksort(arr, low, partition-1);
			quicksort(arr, partition+1, high);
		}
	}

}
