package arrays;

public class MaxElementFirstIncreasingandDecreasingArray {

	public static void main(String[] args) {
		int[] arr = {1, 3, 50, 10, 9, 7, 6};
		arr = new int[]{10, 20, 30, 40, 50};
		arr = new int[]{120, 100, 80, 20, 0};
		arr = new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		System.out.println(maxElement(arr, 0, arr.length-1));
	}
	
	private static int maxElement(int[] arr, int l, int r){
		
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(arr[mid]<arr[mid+1])
				l=mid;
			else
				r = mid;
		}
		
		if(arr[l]>arr[r])
			return arr[l];
		else
			return arr[r];
	}

}
