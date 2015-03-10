package arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianofStreamofIntegers {
	
	 
	
	public static void main(String[] args) {
		int[] arr = {5,15,3};
		System.out.println(getMedian(arr));
	}
	
	private static int getMedian(int[] arr){
		if(arr.length==0)
			return -1;
		PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<Integer>(arr.length,Collections.reverseOrder());
		PriorityQueue<Integer> rightMinHeap = new PriorityQueue<Integer>(arr.length);
		int median =0;
		for(int ele : arr){
			int sign = leftMaxHeap.size() - rightMinHeap.size();
			switch (sign) {
			case 1:
					if(ele<median){
						rightMinHeap.add(leftMaxHeap.poll());
						leftMaxHeap.add(ele);
					}
					else
						rightMinHeap.add(ele);
					median = leftMaxHeap.peek()+rightMinHeap.peek();
					median /=2;
				break;
				
			case 0:
					if(ele<median){
						leftMaxHeap.add(ele);
						median = leftMaxHeap.peek();
					}
					else{
						rightMinHeap.add(ele);
						median = rightMinHeap.peek();
					}
						
				break;
				
			case -1:
					if(ele<median){
						leftMaxHeap.add(ele);
					}
					else{
						leftMaxHeap.add(rightMinHeap.poll());
						rightMinHeap.add(ele);
					}
					median = leftMaxHeap.peek()+rightMinHeap.peek();
					median /=2;
				break;
			}
		}
		
		
		return median;
	}
	
	

}
