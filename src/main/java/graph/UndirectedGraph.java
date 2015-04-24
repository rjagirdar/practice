package graph;

import java.util.Stack;

public class UndirectedGraph extends Graph {
	
	
	public UndirectedGraph() {
		super();
	}
	
	public UndirectedGraph(int V){
		super(V);
	}

	
	@Override
	public void addEdge(int src, int dest) {
		super.addEdge(src, dest);
		super.addEdge(dest, src);
	}

	@Override
	public boolean isCyclic() {
		boolean[] visited = new boolean[this.V];
		for(int i=0; i<this.V; i++){
			if(!visited[i]){
				if(isCyclic(i, visited,-1))
					return true;
			}
		}
		return false;
	}
	
	private boolean isCyclic(int vertex, boolean[] visited, int parent){
		
		visited[vertex] = true;
		for(int adjVertex : this.adjList.get(vertex)){
			if(visited[adjVertex] && parent!=adjVertex){
				return true;
			}
			else if(!visited[adjVertex] && isCyclic(adjVertex, visited, vertex)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasPath(int src, int dest) {
		
		if(hasDirectPath(src, dest)){
			System.out.println("The Graph has the direct path between "+src+" and "+dest);
			return true;
		}
		else{
			boolean[] visited = new boolean[this.V];
			Stack<Integer> path = new Stack<Integer>();
			if(hasPath(src, -1, dest, visited, path)){
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
			
		}
		return false;
	}
	
	private boolean hasDirectPath(int src, int dest){
		SortedList<Integer> adjVertices = adjList.get(src);
		for(int adjVertex : adjVertices){
			if(adjVertex == dest){
				return true;
			}
		}
		return false;
	}
	
	
	private boolean hasPath(int vertex, int parent, int dest, boolean[] visited, Stack<Integer> path){
		
		if(vertex == dest)
			return true;
		visited[vertex] = true;
		path.push(vertex);
		for(int adjVertex : adjList.get(vertex)){
			
			if(adjVertex!=parent && visited[adjVertex] == false && hasPath(adjVertex, vertex, dest, visited, path)){
				return true;
			}
		}
		path.pop();
		return false;
	}
	

}
