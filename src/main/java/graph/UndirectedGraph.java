package graph;

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
		// TODO Auto-generated method stub
		return false;
	}

}
