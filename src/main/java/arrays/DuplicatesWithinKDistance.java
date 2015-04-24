package arrays;

import java.util.HashSet;

public class DuplicatesWithinKDistance {

	public static void main(String[] args) {
		int[] arr = {1,2,1,4,1,2,3,4};
		int k = 3;
		System.out.println(checkDuplicates(arr, k));
		
	}
	
	private static boolean checkDuplicates(int[] arr, int k){
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<arr.length; i++){
			
			if(set.contains(arr[i]))
				return true;
			set.add(arr[i]);
			if(i>=k)
				set.remove(arr[i-k]);
		}
		return false;
	}

}
