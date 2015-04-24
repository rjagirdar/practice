package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph extends Graph {
	
	public DirectedGraph(){
		super();
	}
	
	public DirectedGraph(int V){
		super(V);
	}
	
	@Override
	public void addEdge(int src, int dest) {
		super.addEdge(src, dest);
	}
	
	
	

	@Override
	public boolean isCyclic() {
		boolean[] visited = new boolean[this.V];
		boolean[] recStack = new boolean[this.V];
		
		for(int i=0; i<this.V; i++){
			
			/*Call the recursive method only when the visited[i] is false, to cover any uncovered vertex */
			if(!visited[i]){
				if(isCyclic(i, visited, recStack)){
					return true;
				}
			}
			
		}
		return false;
	}
	
	private boolean isCyclic(int vertex, boolean[] visited, boolean[] recStack){
		
		if(visited[vertex] == false){
			
			visited[vertex] = true;
			recStack[vertex] = true;
			
			for(int adjVertex : adjList.get(vertex)){
				
				if(recStack[adjVertex] == true)
					return true;
				else if(visited[adjVertex] == false && isCyclic(adjVertex, visited, recStack)){
					return true;
				}
			}
			recStack[vertex] = false;
		}
		
		return false;
	}
	
	public boolean hasCycle(){
		Color[] color = new Color[this.V];
		Arrays.fill(color, Color.WHITE);
		for(int i=0; i<this.V; i++){
			if(color[i] == Color.WHITE){
				if(hasCycle(i, color)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean hasCycle(int vertex, Color[] color){
		color[vertex] = Color.GRAY;
		for(int adjVertex : this.adjList.get(vertex)){
			if(color[adjVertex] == Color.GRAY)
				return true;
			else if(color[adjVertex]==Color.WHITE && hasCycle(adjVertex, color))
				return true;
		}
		color[vertex] = Color.BLACK;
		return false;
	}

	@Override
	public boolean hasPath(int src, int dest) {
		boolean[] visited = new boolean[this.V];
		Stack<Integer> path = new Stack<Integer>();
		if(hasPath(src, dest, visited, path)){
			System.out.println("The Directed Graph has the path from "+src+" to "+dest+" and the path is below:");
			System.out.print(dest+" ");
			while(!path.isEmpty()){
				System.out.print(path.pop()+" ");
			}
			return true;
		}
		else{
			System.out.println("The Graph has no path between "+src+" and "+dest);
		}
		return false;
	}
	
	
	private boolean hasPath(int vertex, int dest, boolean[] visited, Stack<Integer> path){
		
		if(visited[vertex] == false){
			
			visited[vertex] = true;
			path.add(vertex);
			for(int adjVertex : adjList.get(vertex)){
				
				if(adjVertex == dest){
					return true;
				}
				else if(visited[adjVertex] == false && hasPath(adjVertex, dest, visited, path)){
					return true;
				}	
			}
			path.pop();
			
		}
		return false;
	}
	
	
	public List<Integer> topologicalOrder(){
		Color[] color = new Color[this.V];
		Arrays.fill(color, Color.WHITE);
		Queue<Integer> finished = new LinkedList<Integer>();
		for(int i=0; i<this.V; i++){
			if(color[i] == Color.WHITE){
				topologicalOrderUtil(i, color, finished);
			}
		}
		
		return Util.reverseQueue(finished);
	}
	
	
	
	private void topologicalOrderUtil(int vertex, Color[] color, Queue<Integer> finishedOrder){
		color[vertex] = Color.GRAY;
		for(int adjVertex : this.adjList.get(vertex)){
			if(color[adjVertex] == Color.WHITE){
				topologicalOrderUtil(adjVertex, color, finishedOrder);
			}
		}
		finishedOrder.add(vertex);
	}

	
	
	private static enum Color{
		WHITE,
		GRAY,
		BLACK
	}
	
}
