package graph;

public class UndirectedGraphTest {

	public static void main(String[] args) {
		Graph g = new UndirectedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(4, 4);
		
		g.BFS();
		System.out.println();
		System.out.println("Is Graph Cyclic :"+g.isCyclic());
		
		System.out.println("ACyclicGraph");
		g = getAcyclicGraph();
		g.DFS();
		System.out.println();
		System.out.println("Is Graph Cyclic :"+g.isCyclic());
		
		System.out.println("Cyclic Graph");
		g=getCyclicGraph();
		g.DFS();
		System.out.println();
		System.out.println("Is Graph Cyclic: "+g.isCyclic());
		
		System.out.println("Find Path Graph");
		g=hasPathTestGraph();
		g.DFS();
		System.out.println();
		g.hasPath(0,3);
		System.out.println("Is Graph Cyclic: "+g.isCyclic());
		
	}
	
	
	private static Graph getAcyclicGraph(){
		Graph g = new UndirectedGraph(3);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		return g;
	}
	
	private static Graph getCyclicGraph(){
		Graph g = new UndirectedGraph();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		return g;
		
	}
	
	private static Graph hasPathTestGraph(){
		Graph g = new UndirectedGraph(6);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 5);
		g.addEdge(2, 4);
		//g.addEdge(6, 6);
		return g;
	
	}

}
