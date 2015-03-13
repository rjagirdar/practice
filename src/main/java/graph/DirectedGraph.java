package graph;

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
			if(isCyclic(i,visited, recStack))
				return true;
				
		}
		return false;
	}
	
	private boolean isCyclic(int vertex, boolean[] visited, boolean[] recStack){
		
		if(visited[vertex] == false){
			
			visited[vertex] = true;
			recStack[vertex] = true;
			
			for(int adjVertex : adjList.get(vertex)){
				
				/*Adjacent Vertex is not visited, then call the isCyclic method on the Adjacent Vertex to check if there are any cycles from its descendents*/
				if(!visited[adjVertex] && isCyclic(adjVertex, visited, recStack))
					return true;
				/*If the Adjacent vertex is already in the recursion stack then it is a back edge and the cycle is detected*/
				else if(recStack[adjVertex])
					return true;
			}
		}
		/*Either a cross edge or there is no cycle in this path*/
		recStack[vertex] = false;
		return false;
		
		
	}
	
	
	
}
