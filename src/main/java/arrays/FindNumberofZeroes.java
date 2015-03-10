package arrays;

public class FindNumberofZeroes {

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1, 1};
		System.out.println(findZeroes(arr));
	}
	
	
	private static int findFirstZero(int[] arr, int l, int r){
		
		while(r-l>1){
			int mid = l+((r-l)/2);
			if(arr[mid]>=1)
				l=mid;
			else
				r=mid;
		}
		
		if(arr[r]==0)
			return r;
		else
			return -1;
	}
	
	
	private static int findZeroes(int[] arr){
		
		int index = findFirstZero(arr, 0, arr.length-1);
		if(index==-1)
			return 0;
		else
			return arr.length-index;
	}

}
