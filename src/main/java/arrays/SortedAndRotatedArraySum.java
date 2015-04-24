package arrays;

public class SortedAndRotatedArraySum {

	public static void main(String[] args) {
		int[] arr = {11, 15, 5,6, 8, 9, 10};
		int n = arr.length;
		int x = 16;
		System.out.println(arr[getMinIndex(arr, 0, n-1)]);
		int minIndex = getMinIndex(arr, 0, n-1);
		int l = (minIndex+1)%n;
		int r = (n+minIndex-1)%n;
		while(l!=r){
			if(arr[l]+arr[r] == x){
				System.out.println("Pair found : "+arr[l]+" , "+arr[r]);
				l=(l+1)%n;
				r=(n+r-1)%n;
			}
			else if(arr[l]+arr[r]>x)
				r=(n+r-1)%n;
			else
				l=(l+1)%n;
		}
	}
	
	private static int getMinIndex(int[] arr, int l, int r){
		if(arr[l]<arr[r])
			return l;
		while(l<=r){
			if(l==r)
				return l;
			int mid = l+(r-l)/2;
			if(arr[mid]>arr[r])
				l=mid+1;
			else
				r = mid;
			
		}
		return -1;
	}

}
