package graph;






import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


class Part{
	private String name;
	private String[] operations;
	private HashMap<String, ArrayList<String>> adjList = null;
	private HashSet<String> vertices = new HashSet<String>();
	private int V=0;
	
	private static enum Color{
		WHITE,
		GRAY,
		BLACK
	};
	
	public Part(String name, String[] operations){
		this.name = name;
		this.operations = operations;
		this.adjList = new HashMap<String, ArrayList<String>>();
		if(this.operations.length>0){
			this.parseOperations();
		}
		//System.out.println(this.adjList.size());
	}
	
	private void parseOperations(){
		if(this.operations == null || this.operations.length<=0){
			System.out.println("Invalid Operations");
		}
		for(String op: this.operations){
			String[] stringParts = op.split(",");
			if(!this.adjList.containsKey(stringParts[0])){
				this.adjList.put(stringParts[0].toLowerCase(), new ArrayList<String>());
			}
			this.vertices.add(stringParts[0].toLowerCase());
			
			for(int i=1; i<stringParts.length; i++){
				if(!this.adjList.containsKey(stringParts[i])){
					this.adjList.put(stringParts[i].toLowerCase(), new ArrayList<String>());
				}
				ArrayList<String> neighbourVertexList = this.adjList.get(stringParts[i]);
				this.vertices.add(stringParts[i].toLowerCase());
				neighbourVertexList.add(stringParts[0].toLowerCase());
			}	
		}
		//this.printAdjList();
	}
	
	private void printAdjList(){
		System.out.println("Number of Vertices is :"+this.V );
		for(String vertex : this.vertices){
			System.out.print(vertex+":");
			
		}
		System.out.println();
		for(Map.Entry<String, ArrayList<String>> entry : this.adjList.entrySet()){
			System.out.print(entry.getKey()+":");
			for(String vertex : entry.getValue()){
				System.out.print(vertex+",");
			}
			System.out.println();
		}
	}
	
	public void process(){
		if(this.operations == null || this.operations.length<=0){
			System.out.println("Invalid Operations");
		}
		if(this.hasCycle()){
			System.out.println("Invalid Order of Operations as it contains a cycle");
		}
		else{
			List<String> order = this.topologicalOrder();
			
			for(String op : order){
				System.out.println("Operation "+op+" on part "+this.name);
			}
		}
			
		
	}
	
	public boolean hasCycle(){
		
		HashMap<String, Color> color = new HashMap<String, Part.Color>();
		for(String vertex : this.vertices){
			color.put(vertex, Color.WHITE);
		}
		for(String vertex : this.vertices){
			if(color.get(vertex) == Color.WHITE){
				if(hasCycle(vertex, color)){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean hasCycle(String vertex, HashMap<String, Color> color){
		color.put(vertex, Color.GRAY);
		for(String adjVertex : this.adjList.get(vertex)){
			if(color.get(adjVertex) == Color.GRAY)
				return true;
			else if(color.get(adjVertex)==Color.WHITE && hasCycle(adjVertex, color))
				return true;
		}
		color.put(vertex, Color.BLACK);
		return false;
	}
	
	public List<String> topologicalOrder(){
		HashMap<String, Color> color = new HashMap<String, Part.Color>();
		for(String vertex : this.vertices){
			color.put(vertex, Color.WHITE);
		}
		Queue<String> finished = new LinkedList<String>();
		for(String vertex : this.vertices){
			if(color.get(vertex) == Color.WHITE){
				topologicalOrderUtil(vertex, color, finished);
			}
		}
		
		return this.reverseQueue(finished);
	}
	
	
	
	private void topologicalOrderUtil(String vertex, HashMap<String, Color> color, Queue<String> finishedOrder){
		color.put(vertex, Color.GRAY);
		for(String adjVertex : this.adjList.get(vertex)){
			if(color.get(adjVertex) == Color.WHITE){
				topologicalOrderUtil(adjVertex, color, finishedOrder);
			}
		}
		finishedOrder.add(vertex);
	}
	
	public static <T> List<T> reverseQueue(Queue<T> queue){
		Deque<T> dequeue = new LinkedList<T>(queue);
		List<T> reverseQueue = new LinkedList<T>();
		while(!dequeue.isEmpty()){
			reverseQueue.add(dequeue.pollLast());
		}
		return reverseQueue;	
	}

}

public class Solution {

	public static void main(String[] args) {
		Part x = Solution.getSamplePart1();
		x.process();
	}
	
	private static Part getPart(){
		String[] lines = null;
		try{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Number of Lines:");
			int n = sc.nextInt();
			if(n<0){
				System.out.println("Invalid Number of Lines.");
			}
			lines = new String[n];
			for(int i=1; i<n+1; i++){
				System.out.print("Enter line "+i+":");
				lines[i-1] = sc.nextLine();
			}
			Part p = new Part("X", lines);
			return p;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	private static Part getSamplePart(){
		String[] lines = new String[4];
		lines[0] = "one";
		lines[1] = "two,one,three";
		lines[2] = "three,one,four";
		lines[3] = "four,five";
		Part p = new Part("X", lines);
		return p;
	}
	
	private static Part getSamplePart1(){
		String[] lines = new String[3];
		lines[0] = "one";
		lines[1] = "two,one";
		lines[2] = "final,two";
		Part p = new Part("X", lines);
		return p;
	}
	
}
