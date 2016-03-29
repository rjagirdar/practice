package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupMultipleOccurences {

	public static void main(String[] args) {
		int[] arr = {5, 3, 5, 1, 3, 3};
		groupOccurences(arr);
	}
	
	private static void groupOccurences(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else
				map.put(arr[i], 1);
		}
		
		for(int i=0;i<arr.length; i++){
			if(map.containsKey(arr[i])){
				int count = map.get(arr[i]);
				for(int k=0; k<count; k++)
					list.add(arr[i]);
				map.remove(arr[i]);
			}
		}
		
		Integer[] result = new Integer[list.size()];
		result = list.toArray(result);
		
		for(int val : result)
			System.out.print(val+" ");
		
		
	}

}
