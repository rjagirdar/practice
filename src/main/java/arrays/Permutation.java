package arrays;

public class Permutation {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int r=2;
		printPermutations(arr, 0, new int[arr.length], 0, r);
	}
	
	private static void printPermutations(int[] arr, int start, int[] temp, int index, int r){
		
		if(r==index){
			for(int j=0; j<r; j++)
				System.out.print(temp[j]+" ");
			System.out.println();
			return;
		}
		
		for(int i=start; i<arr.length; i++){
			swap(arr,i,start);
			temp[index] = arr[start];
			printPermutations(arr, start+1, temp, index+1, r);
			swap(arr,i,start);
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
