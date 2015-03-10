package arrays;

public class FindElementinSortedandRotatedArray {

	public static void main(String[] args) {
		int[] arr = {5,6,1,2,3,4};
		arr=new int[]{1,2,3,4};
		arr=new int[]{4,3,2,1};
		System.out.println(findElement(arr));
	}
	
	private static int findElement(int[] arr){
		
		return findElement(arr, 0, arr.length-1);
		
	}
	
	private static int findElement(int[] arr, int l, int r){
		
		while(r-l>1){
			int mid = l+(r-l)/2;
			if(arr[mid]<arr[r])
				r=mid;
			else 
				l=mid;
		}
		
		if(arr[l]<arr[r])
			return arr[l];
		else
			return arr[r];
	}

}
