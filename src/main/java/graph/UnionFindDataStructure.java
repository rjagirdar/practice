package graph;

import java.util.Set;
import java.util.TreeMap;


public class UnionFindDataStructure<T> {
	
	private int[] parent_array;
	private T[] vertices ;
	private TreeMap<T, Integer> map_to_index = new TreeMap<T, Integer>();
	
	
	@SuppressWarnings("unchecked")
	private UnionFindDataStructure(Set<T> verticesList){
		parent_array = new int[verticesList.size()];
		vertices = (T[]) new Object[parent_array.length];
		
		this.vertices = verticesList.toArray(vertices);
		
		for(int i=0; i<parent_array.length; i++){
			parent_array[i] = -1;
			map_to_index.put(this.vertices[i], i);
		}
		
	}
	
	public static <T> UnionFindDataStructure<T> instance(Set<T> vertices){
		UnionFindDataStructure<T> ds = new UnionFindDataStructure<T>(vertices);
		return ds;
	}
	
	public void print(){
		for(T t : this.vertices)
			System.out.print(t.toString()+" ");
	}
	
	public T parent(T child){
		
		int childIndex = this.map_to_index.get(child);
		int parentIndex = this.parent_array[childIndex];
		if(parentIndex!=-1){
			return this.vertices[parentIndex];
		}
		else{
			return null;
		}
	}
	
	public int find(T ele){
		int eleIndex = this.map_to_index.get(ele);
		if(this.parent_array[eleIndex] == -1)
			return eleIndex;
		return find(this.vertices[this.parent_array[eleIndex]]);
	}
	
	public void union(T x, T y){
		int xSet = find(x);
		int ySet = find(y);
		
		this.parent_array[xSet] = ySet;
	}
}
