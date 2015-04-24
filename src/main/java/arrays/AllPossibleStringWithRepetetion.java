package arrays;

public class AllPossibleStringWithRepetetion {

	public static void main(String[] args) {
		char[] arr = {'a','b','c'};
		int k=2;
		printAllPossibleStrings(arr, k, new char[k], 0);
		System.out.println("================");
		printWithoutRepetetion(arr, new char[arr.length], 0, 0, k);
	}
	
	private static void printAllPossibleStrings(char[] arr, int k, char[] temp, int index){
		if(index == k){
			for(int i=0; i<k; i++){
				System.out.print(temp[i]+" ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i=0; i<arr.length; i++){
			temp[index] = arr[i];
			printAllPossibleStrings(arr, k, temp, index+1);
		}
	}
	
	private static void printWithoutRepetetion(char[] arr, char[] temp, int index, int start, int k){
		if(index == k){
			for(int i=0; i<k; i++){
				System.out.print(temp[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<arr.length; i++){
			swap(arr,i,start);
			temp[index] = arr[start];
			printWithoutRepetetion(arr, temp, index+1, start+1, k);
			swap(arr, i, start);
		}
	}
	
	private static void swap(char[] arr, int i, int j){
		char ch = arr[i];
		arr[i] = arr[j];
		arr[j] = ch;
	}

}
