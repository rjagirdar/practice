package arrays;

import java.util.Stack;

public class MaxHistogramArea {

	public static void main(String[] args) {
		int[] bars = {6,2,5,4,5,1,6};
		System.out.println(getMaxHistogramArea(bars));
	}
	
	private static int getMaxHistogramArea(int[] bars){
		
		Stack<Integer> stack = new Stack<Integer>();
		int max_area = 0;
		int tp;
		int area_with_top;
		
		int i=0;
		int n = bars.length;
		while(i<n){
			
			if(stack.isEmpty() || bars[stack.peek()]<=bars[i]){
				stack.push(i++);
			}
			else{
				tp = stack.pop();
				area_with_top = bars[tp] * (stack.empty() ? i : i - stack.peek() - 1);
				
				if (max_area < area_with_top)
	                max_area = area_with_top;
			}
		}
		
		while (stack.empty() == false)
	    {
	        tp = stack.peek();
	        stack.pop();
	        area_with_top = bars[tp] * (stack.empty() ? i : i - stack.peek() - 1);
	 
	        if (max_area < area_with_top)
	            max_area = area_with_top;
	    }
	 
	    return max_area;
	}

}
