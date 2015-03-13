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
	}

}
