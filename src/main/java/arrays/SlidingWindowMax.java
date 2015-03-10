package arrays;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,4,5,2,3,6};
		int k=3;
	}
	
	private static void slidingWindow(int[] arr, int k){
		Deque<Integer> queue = new LinkedList<Integer>();
		int i=0;
		for(i=0; i<k; i++){
			while(!queue.isEmpty() && arr[i] >=arr[queue.peekLast()])
				queue.pollLast();
			
			queue.addLast(i);
		}
		
		for(;i<arr.length; i++){
			System.out.println();
		}
		
	}

}
