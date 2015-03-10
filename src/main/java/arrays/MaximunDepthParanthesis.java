package arrays;

import java.util.Stack;

public class MaximunDepthParanthesis {

	public static void main(String[] args) {
		String str = "( ((X)) (((Y))) )";
		str = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
		//str = "( p((q)) ((s)t) )";
		//str="b) (c) ()";
		//str = "(b) ((c) ()";
		System.out.println(maxDepth(str));
	}
	
	private static int maxDepth(String str){
		if(str.length()==0)
			return -1;
		int localDepth =0;
		int maxDepth = Integer.MIN_VALUE;
		Stack<Character> stack = new Stack<Character>();
		for(char ch : str.toCharArray()){
			
			if(ch=='('){
				stack.push(ch);
				localDepth+=1;
				maxDepth = Math.max(maxDepth, localDepth);
				continue;
			}
			if(ch==')'){
				if(!stack.isEmpty() && stack.peek()=='('){
					localDepth-=1;
					stack.pop();
					
				}
				else
					return -1;
			}
		}
		
		if(stack.isEmpty())
			return maxDepth;
		else
			return -1;
	}

}
