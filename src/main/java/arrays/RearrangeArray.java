package arrays;

public class RearrangeArray {

	public static void main(String[] args) {
		int[] arr = {1,3,0,2};
		reArrangeArray(arr);
		for(int val : arr)
			System.out.println(val);
	}
	
	private static void reArrangeArray(int[] arr){
		int val = 0;
		int i = arr[0];
		while(i!=0){
			int new_i = arr[i];
			arr[i] = val;
			
			val=i;
			i=new_i;
			
		}
		arr[0] = val;
	}

}
