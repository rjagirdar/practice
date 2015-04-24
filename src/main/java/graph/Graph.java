package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;


public abstract class Graph {
	protected int V;
	protected TreeMap<Integer, SortedList<Integer>> adjList;
	private TreeSet<Integer> verticesSet;
	
	private boolean weighted;
	
	
	public Graph(){
		this.V = -1;
		this.adjList = new TreeMap<Integer, SortedList<Integer>>();
		this.weighted = false;
		this.verticesSet = new TreeSet<Integer>();
	}
	
	public Graph(int V){
		this.V = V;
		this.weighted = false;
		this.adjList = new TreeMap<Integer, SortedList<Integer>>();
		this.verticesSet = new TreeSet<Integer>();
		for(int i=0;i<V; i++){
			this.verticesSet.add(i);
		}
	}
	
	
	
	public void addEdge(int src, int dest){
		SortedList<Integer> list = null;
		
		if(!this.verticesSet.contains(src)){
			this.verticesSet.add(src);
			this.V = this.verticesSet.size();
		}
		
		if(this.verticesSet.contains(dest)){
			this.verticesSet.add(dest);
			this.V = this.verticesSet.size();
		}
		
		if(this.adjList.containsKey(src)){
			list = this.adjList.get(src);
		}
		else{
			list = new SortedList<Integer>();
			
		}
		
		if(!this.adjList.containsKey(dest)){
			this.adjList.put(dest, new SortedList<Integer>());
		}
		list.add(dest);
		this.adjList.put(src, list);
	}
	
	/***
	 * Depth First Search for both Directed and UnDirected Graphs
	 */
	public void DFS() {
		boolean[] visited = new boolean[this.V];
		int numOfComponents = 0;
		Queue<Integer> firstVisited = new LinkedList<Integer>();
		Queue<Integer> firstFinished = new LinkedList<Integer>();
		for(int i=0; i<this.V; i++){
			if(!visited[i]){
				numOfComponents+=1;
				DFS(i,visited, firstVisited, firstFinished);
			}
		}
		DFSPrintUtil(numOfComponents,firstVisited, firstFinished);
	}
	
	private void DFSPrintUtil(int numOfComponents,Queue<Integer> firstVisited, Queue<Integer> firstFinished){
		System.out.println();
		System.out.println("No. Of Components : "+numOfComponents);
		System.out.println("===========================");
		System.out.println("Vertices were visited in this order");
		for(int vertex : firstVisited)
			System.out.print(vertex+" ");
		System.out.println();
		System.out.println("Vertices were finished in this order");
		for(int vertex : firstFinished)
			System.out.print(vertex+" ");
	}
	
	private void DFS(int vertex, boolean[] visited, Queue<Integer> firstVisited, Queue<Integer> firstFinished){
		firstVisited.add(vertex);
		visited[vertex] = true;
		for(int adjVertex : this.adjList.get(vertex)){
			if(!visited[adjVertex]){
				DFS(adjVertex,visited, firstVisited, firstFinished);
			}
		}
		firstFinished.add(vertex);
	}
	
	public void BFS(){
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int i=0; i<V; i++){
			if(!visited.contains(i))
				BFS(i, visited);
		}
	}
	private void BFS(int src, HashSet<Integer> visited){
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(src);
		visited.add(src);
		
		while(!queue.isEmpty()){
			int currentVertex = queue.poll();
			System.out.print(currentVertex+" ");
			for(int adjVertex : this.adjList.get(currentVertex)){
				if(!visited.contains(adjVertex)){
					queue.add(adjVertex);
					visited.add(adjVertex);
				}
			}
		}
		
		
	}
	
	public abstract boolean isCyclic();
	public abstract boolean hasPath(int src, int dest);
	
	
}
