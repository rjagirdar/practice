package graph;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
		
		DirectedGraph g2 = new DirectedGraph(5);
		g2.addEdge(0, 1);
		g2.addEdge(0, 3);
		g2.addEdge(1, 2);
		g2.addEdge(3, 1);
		g2.addEdge(3, 2);
		g2.addEdge(3, 4);
		g2.addEdge(4, 0);
		
		
		g2.DFS();
		System.out.println();
		System.out.println("Is G cyclic: "+g2.hasCycle());
		g2.hasPath(2, 0);
		
		
		DirectedGraph topologicalSortTest = new DirectedGraph(6);
		topologicalSortTest.addEdge(0, 1);
		topologicalSortTest.addEdge(0, 4);
		topologicalSortTest.addEdge(0, 3);
		topologicalSortTest.addEdge(1, 2);
		topologicalSortTest.addEdge(4, 3);
		topologicalSortTest.addEdge(4, 1);
		topologicalSortTest.addEdge(5, 2);
		topologicalSortTest.addEdge(5, 4);
		topologicalSortTest.DFS();
		System.out.println("TPG has Cycle : "+topologicalSortTest.hasCycle());
		List<Integer> tporder = topologicalSortTest.topologicalOrder();
		for(int vertex : tporder)
			System.out.print(vertex+" ");
		System.out.println();
		
		
	}
}
