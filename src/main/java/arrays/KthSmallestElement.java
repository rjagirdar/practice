package arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

	public static void main(String[] args) {
		int[] arr = {10,14,12,11,4,1,6,2,3,5,9,7,8,13};
		for(int k=1; k<=10; k++){
			for(int i=1;i<=14; i++)
				System.out.println(i+":"+kthSmallest1(arr, i));
			System.out.println("===========================");
		}
	}
	
	private static int kthSmallest(int[] arr, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		if(k>arr.length || arr.length==0)
			return -1;
		for(int i=0; i<k; i++){
			queue.add(arr[i]);
		}
		for(int i=k; i<arr.length; i++){
			if(arr[i]<queue.peek()){
				queue.poll();
				queue.add(arr[i]);
			}
		}
		
		
		return queue.peek();
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static int kthSmallest1(int[] arr, int k){
		
		return specializedQuickSort(arr, 0, arr.length-1, k);
	}
	
	private static int partition(int[] arr, int left, int right){
		
		int j=left+1;
		int pivot = arr[left];
		
		for(int i=left+1;i<=right; i++){
			if(arr[i]<pivot){
				swap(arr, i, j);
				j+=1;
			}
		}
		
		swap(arr,j-1,left);
		
		return j-1;
	}
	
	private static int specializedQuickSort(int[] arr, int left, int right, int k){
		if(left<right){
			int index = partition(arr, left, right);
			
			if(index!=-1){
				if(index==k-1)
					return arr[k-1];
				else if(index>k-1)
					return specializedQuickSort(arr, left, index-1, k);
				else if(index<k-1)
					return specializedQuickSort(arr, index+1, right, k);
				
			}
		}
		return -1;
	}

}
