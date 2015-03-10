package arrays;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = {4,2,5,1,6,3,25};
		nextGreaterElement(arr);
		System.out.println();
		nextSmallerElement(arr);
		
	}
	
	private static void nextSmallerElement(int[] arr){
		if(arr.length==0)
			return;
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] temp = new int[arr.length];
		stack.push(arr.length-1);
		
		for(int i=arr.length-2; i>=0; i--){
			int current = arr[i];
			
			while(!stack.isEmpty() && current < arr[stack.peek()]){
				int updateIndex = stack.pop();
				temp[updateIndex] = current;
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			temp[stack.pop()] = -1;
		}
		
		for(int val : arr)
			System.out.print(val+" ");
		System.out.println();
		System.out.println("=======================");
		for(int val : temp)
			System.out.print(val+" ");
	
	}
	
	private static void nextGreaterElement(int[] arr){
		if(arr.length==0)
			return;
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] temp = new int[arr.length];
		stack.push(0);
		
		for(int i=1; i<arr.length; i++){
			int current = arr[i];
			
			while(!stack.isEmpty() && current > arr[stack.peek()]){
				int updateIndex = stack.pop();
				temp[updateIndex] = current;
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			temp[stack.pop()] = -1;
		}
		
		for(int val : arr)
			System.out.print(val+" ");
		System.out.println();
		System.out.println("=======================");
		for(int val : temp)
			System.out.print(val+" ");
	}

}
