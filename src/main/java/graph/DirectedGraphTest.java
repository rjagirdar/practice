package graph;

public class DirectedGraphTest {

	public static void main(String[] args) {
		Graph g = new DirectedGraph(5);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(4, 4);
		
		g.DFS();
		System.out.println();
		
		Graph g1 = new DirectedGraph(5);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2,3);
		g1.addEdge(3, 4);
		
		Graph g2 = new DirectedGraph(5);
		g2.addEdge(0, 1);
		g2.addEdge(0, 3);
		g2.addEdge(1, 2);
		g2.addEdge(3, 1);
		g2.addEdge(3, 2);
		g2.addEdge(3, 4);
		g2.addEdge(4, 0);
		
		
		g2.DFS();
		System.out.println();
		System.out.println("Is G cyclic: "+g2.isCyclic());
	}

}
