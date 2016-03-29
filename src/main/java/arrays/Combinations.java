package arrays;

import java.util.Arrays;

public class Combinations {
	
	static int count = 0;
	public static void main(String[] args) {
		int[] arr = {1,2};
		int r = 1;
		printCombinations(arr, 0, new int[arr.length], 0, r);
		System.out.println("Boolean");
		generateCombinations(2);
		
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
	
	private static void printCombinations(boolean[] arr, int start, boolean[] temp, int index, int r){
		
		if(r==index){
			for(int j=0; j<r; j++){
				System.out.print(temp[j] +" ");
			}
			System.out.println();
			count++;
			return;
		}
		
		for(int i=start; i<arr.length; i++){
			temp[index] = arr[i];
			printCombinations(arr, i+1, temp, index+1, r);
			temp[index] = !arr[i];
			printCombinations(arr, i+1, temp, index+1, r);
		}
	}
	
	private static void generateCombinations(int r){
		boolean[] arr = new boolean[r];
		Arrays.fill(arr, true);
		printCombinations(arr, 0, new boolean[r], 0, r);
		System.out.println(count);
		
	}
	
	private static boolean check(boolean... values){
		return true;
	}

}
