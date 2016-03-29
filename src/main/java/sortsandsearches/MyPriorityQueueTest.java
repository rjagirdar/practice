package sortsandsearches;

import java.util.LinkedList;
import java.util.Queue;

public class MyPriorityQueueTest {

	public static void main(String[] args) {
		int[] arr = {12, 3, 5, 7, 19,4,8,31,22,17,9,1,6,11,10,13,15,2};
		//arr = new int[]{4,2,3,1};
		MyPriorityQueue pq = new MyPriorityQueue(arr);
		pq.printArray();
		pq.printLevelOrder();
		/*while(pq.hasNext()){
			System.out.println(pq.extractMin());
			
		}*/
	}
	
	
	private static class MyPriorityQueue{
		private int[] arr;
		private int size;
		
		
		
		public MyPriorityQueue(int[] arr){
			this.arr = arr;
			this.size = arr.length;
			int i= this.size/2;
			while(i>=0){
				this.heapify(i);
				i--;
			}
		}
		
		private int left(int i){
			return 2*i+1;
		}
		
		private int right(int i){
			return 2*i+2;
		}
		
		private int parent(int i){
			return (i-1)/2;
		}
		
		public boolean hasNext(){
			return !(this.size==0);
		}
		
		public int extractMin(){
			if(this.size==0)
				return -1;
			int returnVal = arr[0];
			arr[0] = arr[this.size-1];
			this.size-=1;
			heapify(0);
			return returnVal;
		}
		
		private void heapify(int i){
			int left = left(i);
			int right = right(i);
			int smallest = i;
			
			if(left<this.size && arr[left]<arr[smallest]){
				smallest = left;
			}
			if(right<this.size && arr[right]< arr[smallest]){
				smallest = right;
			}
			if(i!=smallest){
				swap(smallest, i);
				heapify(smallest);
			}
			
		}
		
		private void swap(int i, int j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		public void printLevelOrder(){
			
			if(this.arr.length==0)
				return;
			Queue<Integer> queue = new LinkedList<Integer>();
			Queue<Integer> childQueue = new LinkedList<Integer>();
			
			queue.add(0);
			System.out.print(arr[0]);
			System.out.println();
			System.out.println("================");
			
			while(!queue.isEmpty()){
				int size = queue.size();
				int root = queue.poll();
				size--;
				int left = left(root);
				int right =right(root);
				
				if(left<this.size)
					childQueue.add(left);
				if(right<this.size)
					childQueue.add(right);
				
				if(size==0){
					while(!childQueue.isEmpty()){
						int index = childQueue.poll();
						System.out.print(arr[index]+" ");
						queue.add(index);
					}
					System.out.println();
					System.out.println("================");	
				}
				
				
			}
		}
		
		public void printArray(){
			for(int i: arr){
				System.out.print(i+"  ");
			}
			System.out.println();
		}
		
		
	}

}
