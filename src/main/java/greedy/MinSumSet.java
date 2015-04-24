package greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

public class MinSumSet {

	public static void main(String[] args) {
		int[] arr1 = {1,2,4,6,8};
		int[] arr2 = {1,3,4,5,7};
		minSumSet(arr1, arr2);
	}
	
	private static void minSumSet(int[] arr1, int[] arr2){
		PriorityQueue<HeapNode> pq = new PriorityQueue<MinSumSet.HeapNode>(10, HeapNode.comp);
		List<String> resultList = Lists.newArrayList();
		Table<Integer, Integer, HeapNode> table = HashBasedTable.create();
		HeapNode seedNode = new HeapNode(arr1[0], arr2[0], 0, 0);
		table.put(0, 0, seedNode);
		pq.add(seedNode);
		int index = 0;
		while(!pq.isEmpty() && index<=arr1.length){
			HeapNode top = pq.poll();
			resultList.add(top.pair);
			int i1 = top.i1;
			int i2 = top.i2;
			if(!table.contains(i1, i2+1)){
				HeapNode ch1 = new HeapNode(arr1[i1], arr2[i2+1], i1, i2+1);
				pq.add(ch1);
				table.put(arr1[i1], arr2[i2+1], ch1);
			}
			if(!table.contains(i1+1, i2)){
				HeapNode ch2 = new HeapNode(arr1[i1+1], arr2[i2], i1+1, i2);
				pq.add(ch2);
				table.put(arr1[i1+1], arr2[i2], ch2);
			}
			index++;
		}
		
		for(String pair : resultList)
			System.out.println(pair);
		
		
	}
	
	private static class HeapNode{
		public int sum;
		public String pair;
		public int i1;
		public int i2;
		
		public HeapNode(int a1, int a2, int i1, int i2){
			this.sum = a1 + a2;
			this.pair = "{"+a1+","+a2+"}";
			this.i1 = i1;
			this.i2 = i2;
		}
		
		public static Comparator<HeapNode> comp = new Comparator<MinSumSet.HeapNode>() {
			
			@Override
			public int compare(HeapNode o1, HeapNode o2) {
				return o1.sum-o2.sum;
			}
		};
		
	}

}
