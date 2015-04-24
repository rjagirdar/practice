package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpaceProblem {

	public static void main(String[] args) {
		String str = "ABCDE";
		printAllPossibleStrings(str);
	}
	
	private static void printQueue(Queue<String> queue){
		Queue<String> clone = new LinkedList<String>();
		clone.addAll(queue);
		for(String str : clone)
			System.out.println(str);
		System.out.println("=====================");
	}
	
	private static void printAllPossibleStrings(String str){
		Queue<String> parentQueue = new LinkedList<String>();
		Queue<String> childQueue = new LinkedList<String>();
		
		
		
		
		parentQueue.add(""+str.charAt(0));
		
		int i=1;
		while(i<str.length()){
			printQueue(parentQueue);
			char ch = str.charAt(i);			
			int current_size = parentQueue.size();
			childQueue.clear();
			while(!parentQueue.isEmpty()){
				String curr = parentQueue.poll();
				childQueue.add(curr+ch);
				childQueue.add(curr+" "+ch);
				current_size--;				
			}
			if(current_size==0)
				parentQueue.addAll(childQueue);
			i++;
		}
		printQueue(parentQueue);
	}

}
