package arrays;

public class Combinations {

	public static void main(String[] args) {
		int[] arr = {1,2};
		int r = 1;
		printCombinations(arr, 0, new int[arr.length], 0, r);
	}
	
	
	private static void printCombinations(int[] arr, int start, int[] temp, int index, int r){
		
		if(r==index){
			for(int j=0; j<r; j++){
				System.out.print(temp[j] +" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<arr.length; i++){
			temp[index] = arr[i];
			printCombinations(arr, i+1, temp, index+1, r);
		}
	}

}
