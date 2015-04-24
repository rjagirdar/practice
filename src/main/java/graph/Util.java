package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Util {
	
	public static <T> List<T> reverseQueue(Queue<T> queue){
		Deque<T> dequeue = new LinkedList<T>(queue);
		List<T> reverseQueue = new LinkedList<T>();
		while(!dequeue.isEmpty()){
			reverseQueue.add(dequeue.pollLast());
		}
		return reverseQueue;
		
	}

}
