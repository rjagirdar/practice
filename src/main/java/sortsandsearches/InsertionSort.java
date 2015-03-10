package sortsandsearches;

public class InsertionSort {

	private static int countInversions = 0;
	public static void main(String[] args) {
		int[] arr = {12, 3, 5, 7, 19,4,8,31,22,17,9,1,6,11,10,13,15,2};
		sort(arr);
		System.out.println();
		System.out.println("No. Of Inversions is "+countInversions);
	}
	
	private static void sort(int[] arr){
		insertionSort(arr);
		for(int val : arr)
			System.out.print(val+" ");
	}
	
	private static void insertionSort(int[] arr){
		if(arr.length==0)
			return;
		
		int min = arr[0];
		for(int i=1; i<arr.length; i++){
			int val = arr[i];
			for(int j=i-1; j>=0;j--){
				if(arr[j+1] < arr[j]){
					countInversions+=1;
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp; 
				}
			}
		}
	}
	
	

}
