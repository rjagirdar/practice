package bst;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import bst.BinarySearchTreeTest.BinarySearchTree.TraversalType;


public class BinarySearchTreeTest {

	public static void main(String[] args) {
		int in[] = {4,8,10,12,14,20,21,22,23};
		int pre[]= {20,8,4,12,10,14,22,21,23};
		int level[] = {20,8,22,4,12,21,23,10,14};
		int post[] = {6,4,10,14,12,8,21,23,22,20};
		
		
		System.out.println();
		System.out.println("==========Creation of Tree and Level Order Traversal===========");
		System.out.println();
		//BinarySearchTree tree = new BinarySearchTree(in, TraversalType.INORDER, level, TraversalType.LEVELORDER);
		//BinarySearchTree tree = new BinarySearchTree(post, TraversalType.POSTORDER);
		BinarySearchTree tree = new BinarySearchTree();
		for(int item : in){
			tree.insert(item);
		}
		Iterator<Node> it = tree.getIterator(TraversalType.LEVELORDER);
		while(it.hasNext()){
			System.out.print(it.next().data+" ") ;
		}
		System.out.println();
		
		System.out.println();
		System.out.println("==========Size of the tree is===========");
		System.out.println();
		System.out.println(tree.size());
		System.out.println();
		
		
		System.out.println();
		System.out.println("==========Linked List Test print Inorder===========");
		System.out.println();
		Node head = tree.getLinkedList();
		Node temp = head;
		
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.right;
		}
		System.out.println();
		
		System.out.println();
		System.out.println("==========Find Nodes for a Particular Sum===========");
		System.out.println();
		tree.isSumPresent(30);
		System.out.println();
		
		System.out.println();
		System.out.println("==========Reverse Level Order of the Tree===========");
		System.out.println();
		List<Integer> list = tree.getReverseLevelOrder();
		for(int i : list){
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		System.out.println();
		System.out.println("==========Cropping the tree===========");
		System.out.println();
		BinarySearchTree croppedTree = tree.cropTree(3, 15);
		it = croppedTree.getIterator(TraversalType.REVERSELEVELORDER);
		while(it.hasNext()){
			System.out.print(it.next().data+" ") ;
		}
		System.out.println();
		
		BinarySearchTree sumTree = getSumTreeExample();
		sumTree.convertToGreaterSumTree();
		
		
		
	}
	
	private static BinarySearchTree getSumTreeExample(){
		Node root = new Node(11);
		root.left = new Node(2);
	    root.right = new Node(29);
	    root.left.left = new Node(1);
	    root.left.right = new Node(7);
	    root.right.left = new Node(15);
	    root.right.right = new Node(40);
	    root.right.right.left = new Node(35);
	    return new BinarySearchTree(root);
	}
	
	public static class Node{
		public int data;
		public Node left;
		public Node right;
		public int height;
		
		public Node(int data){
			this.data= data;
			this.left = null;
			this.right = null;
			this.height =1;
		}
		
		public Node(Node temp){
			this.data = temp.data;
			this.left = null;
			this.right = null;
			this.height =1;
		}
	}
	
	public static class BinarySearchTree{
		
		private Node root;
		private int preOrderIndex;
		private Node prev;
		private Node listhead;
		private Node predecessor;
		private boolean isThreadedBinary;
		private int sum =0;
		
		public BinarySearchTree(){
			root = null;
			this.preOrderIndex=0;
			this.prev = null;
			this.listhead = null;
			this.predecessor = null;
			this.isThreadedBinary = false;
		}
		
		public BinarySearchTree(Node root){
			this.root = root;
			this.preOrderIndex=0;
			this.prev = null;
			this.listhead = null;
			this.predecessor = null;
			this.isThreadedBinary = false;
		}
		
		public BinarySearchTree(Node root, boolean isThreadedBinary){
			this.root = root;
			this.preOrderIndex=0;
			this.prev = null;
			this.listhead = null;
			this.predecessor = null;
			this.isThreadedBinary = isThreadedBinary;
		}
		
		public BinarySearchTree(int[] arr1, TraversalType arr1Type, int[] arr2, TraversalType arr2Type){
			this.preOrderIndex=0;
			this.prev = null;
			this.listhead = null;
			this.predecessor = null;
			this.isThreadedBinary = false;
			if(arr1Type== TraversalType.INORDER && arr2Type == TraversalType.PREORDER){
				this.root = buildINPRE(arr1, arr2, 0, arr1.length-1);
			}
			else if(arr1Type == TraversalType.INORDER && arr2Type == TraversalType.LEVELORDER){
				this.root = buildINLevel(arr1, arr2, 0, arr1.length-1);
			}
			
		}
		
		public BinarySearchTree(int[] array, TraversalType arrayType){
			this.preOrderIndex=0;
			this.prev = null;
			this.listhead = null;
			this.predecessor = null;
			this.isThreadedBinary = false;
			if(TraversalType.POSTORDER == arrayType){
				this.root = this.buildINPOST(array);
			}
		}
		
		public void printInorder(){
			printInorderUtil(root);
		}
		private void printInorderUtil(Node root){
			if(root == null)
				return;
			printInorderUtil(root.left);
			System.out.print(root.data+" ");
			printInorderUtil(root.right);
		}
		
		/***
		 * convert to greater sum tree
		 * 
		 */
		public void convertToGreaterSumTree(){
			convertToGreaterSumTree(root,0, false);
			System.out.println();
			System.out.println("Convert to Greater Sum Tree");
			printInorder();
			System.out.println();
		}
		
		private int convertToGreaterSumTree(Node root, int sum, boolean isLeft){
			if(root==null)
				return 0;
			int rightSum = convertToGreaterSumTree(root.right, sum, false);
			int temp = root.data;
			int current_sum = rightSum+sum;
			root.data = rightSum+sum;
			
			int leftSum = convertToGreaterSumTree(root.left, current_sum+temp, true);
			if(isLeft){
				return temp+leftSum;
			}
			return current_sum+leftSum+temp;
		}
		
		
		
		public int size(){
			return sizeUtil(root);
		}
		
		private int sizeUtil(Node root){
			if(root == null)
				return 0;
			return sizeUtil(root.left)+sizeUtil(root.right)+1;
		}
		
		
		
		public int floor(int key){
			
			return floorUtil(this.root, key);
		}
		
		public int ceil(int key){
			return ceilutil(this.root, key);
		}
		
		private int floorUtil(Node root, int key){
			
			if(root==null)
				return -1;
			
			if(key<=root.data){
				return floorUtil(root.left, key);
			}
			else{
				int floorRight = floorUtil(root.right, key);
				if(floorRight>root.data)
					return floorRight;
				else
					return root.data;
			}
			
			
		}
		
		private int ceilutil(Node root, int key){
			if(root==null)
				return -1;
			if(key>=root.data)
				return ceilutil(root.right, key);
			int ceilLeft = ceilutil(root.left, key);
			
			if(ceilLeft>root.data)
				return ceilLeft;
			else
				return root.data;
		}
		
		
		
		
		private int[] toIntArray(List<Integer> list){
			int[] ret = new int[list.size()];
			for(int i = 0;i < ret.length;i++)
				ret[i] = list.get(i);
			return ret;
		}
		
		private int findIndex(int[] in, int start, int end, int key){
			for(int i=start; i<=end; i++){
				if(in[i]==key)
					return i;
			}
			return -1;
		}
		
		
		private int[] extractValues(int[] in, int[] dest, int start, int end){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int val : dest){
				if(findIndex(in, start, end, val)!=-1){
					list.add(val);
				}
			}
			return toIntArray(list);
		}
		
		private int[] extractValues(int[] post, int start, int end, int key, boolean isLeft){
			List<Integer> list = Lists.newArrayList();
			for(int i=start; i<=end; i++){
				if(isLeft){
					if(post[i]<key)
						list.add(post[i]);
				}
				else{
					if(post[i]>key)
						list.add(post[i]);
				}
			}
			return this.toIntArray(list);
		}
		
		
		
		private Node buildINPRE(int[] in, int[] pre, int start, int end){
			Node root = new Node(pre[this.preOrderIndex++]);
			if(start==end)
				return root;
			int index = findIndex(in, start, end, root.data);
			if(index!=-1){
				root.left = buildINPRE(in, pre, start, index-1);
				root.right= buildINPRE(in, pre, index+1, end);
			}
			
			return root;
		}
		
		private Node buildINPOST(int[] post){
			if(post.length==0)
				return null;
			Node root = new Node(post[post.length-1]);
			if(post.length==1)
				return root;
			int[] leftArray = this.extractValues(post, 0, post.length-2, root.data,true);
			int[] rightArray= this.extractValues(post, 0, post.length-2, root.data,false);
			
			root.left = buildINPOST(leftArray);
			root.right = buildINPOST(rightArray);
			
			return root;
		}
		
		private Node buildINLevel(int[] in, int[] level, int start, int end){
			Node root = new Node(level[0]);
			if(start==end){
				return root;
			}
			
			int index = findIndex(in, start, end, root.data);
			int[] leftTreeVals = extractValues(in, level, start, index-1);
			int[] rightTreeVals = extractValues(in, level, index+1, end);
			root.left = buildINLevel(in, leftTreeVals, start, index-1);
			root.right = buildINLevel(in, rightTreeVals, index+1, end);
			return root;
		}
		
		public BinarySearchTree clone(){
			Node newRoot = cloneUtil(this.root);
			return new BinarySearchTree(newRoot);
		}
		
		private Node cloneUtil(Node current){
			if(current == null)
				return null;
			Node newCurrent = new Node(current);
			newCurrent.left = cloneUtil(current.left);
			newCurrent.right = cloneUtil(current.right);
			
			return newCurrent;
		}
		
		public Node getLinkedList(){
			Node cloneRoot = cloneUtil(this.root);
			getLinkedListUtil(cloneRoot);
			return this.listhead;
		}
		
		private void getLinkedListUtil(Node root){
			if(root==null)
				return;
			getLinkedListUtil(root.left);
			if(prev==null){
				this.listhead = root;
			}
			else if(prev!=null){
				root.left=prev;
				prev.right=root;
			}
			prev=root;
			getLinkedListUtil(root.right);
			
		}
		
		public BinarySearchTree getThreadedBinaryTree(){
			Node cloneRoot = cloneUtil(this.root);
			getThreadedBinaryTreeUtil(cloneRoot);
			BinarySearchTree tree = new BinarySearchTree(cloneRoot, true);
			return tree;
		}
		
		private void getThreadedBinaryTreeUtil(Node current){
			if(current == null)
				return;
			getThreadedBinaryTreeUtil(current.left);
			if(this.predecessor!=null){
				if(this.predecessor.right== null)
					this.predecessor.right = current;
			}
			this.predecessor = current;
			getThreadedBinaryTreeUtil(current.right);
		}
		
		
		public boolean isSumPresent(int sum){
			boolean left=true, right = true;
			Node node1=null, node2=null;
			boolean retVal = false;
			Iterator<Node> init = this.getIterator(TraversalType.INORDER);
			Iterator<Node> reinit = this.getIterator(TraversalType.REVERSEINORDER);
			
			while(init.hasNext() && reinit.hasNext()){
				if(left)
					node1 = init.next();
				if(right)
					node2 = reinit.next();
				int calculatedSum = node1.data + node2.data;
				if(node1 == node2)
					continue;
				else if(node1.data > node2.data)
					break;
				else{
					if(sum == calculatedSum ){
						System.out.println("Sum "+sum +" found with nodes "+ node1.data +" and "+node2.data);
						retVal = true;
						
					}
					else if(sum > calculatedSum){
						left = true;
						right = false;
					}
					else if(sum < calculatedSum){
						right = true;
						left = false;
					}
				}
			}
			
			return retVal;
		}
		
		public BinarySearchTree cropTree(int min, int max){
			return new BinarySearchTree(cropTreeUtil(this.root, min, max));
		}
		
		public Node cropTreeUtil(Node root, int min, int max){
			if(root==null)
				return null;
			root.left = cropTreeUtil(root.left, min, max);
			root.right = cropTreeUtil(root.right, min, max);
			
			if(root.data>max){
				Node temp = root.left;
				root.left = null;
				return temp;
			}
			else if(root.data<min){
				Node temp = root.right;
				root.right = null;
				return temp;
			}
			return root;
		}
		
		public List<Integer> getReverseLevelOrder(){
			
			Iterator<Node> releit = this.getIterator(TraversalType.REVERSELEVELORDER);
			List<Node> list = Lists.newArrayList(releit);
			return func.apply(list);
		}
		
		private static Function<List<Node>, List<Integer>> func = new Function<List<Node>, List<Integer>>() {
			
			public List<Integer> apply(List<Node> list) {
				List<Integer> newList = Lists.newArrayList();
				for(Node current : list){
					newList.add(current.data);
				}
				return newList;
			}
		};
				

		public Iterator<Node> getIterator(TraversalType type){
			Iterator<Node> it=null;
			switch(type){
			case INORDER:  it= new InorderIterator();
							break;
			case PREORDER: it=  new PreOrderIterator();
							break;
			case POSTORDER: it= new PostOrderIterator();
							break;
			case REVERSEINORDER : it = new ReverseInorderIterator();
							break;
			case REVERSELEVELORDER: it = new ReverseLevelOrderIterator();
							break;
			case LEVELORDER : it = new LevelOrderIterator();
							break;
				
			}
			return it;
		}
		
		public class LevelOrderIterator implements Iterator<Node>{
			private Queue<Node> queue = null;
			
			public LevelOrderIterator(){
				this.queue = new LinkedList<BinarySearchTreeTest.Node>();
				queue.add(root);
			}
			public boolean hasNext() {
				return !queue.isEmpty();
			}

			public Node next() {
				Node current =null;
				if(!queue.isEmpty()){
					current = queue.poll();
					if(current.left!=null)
						queue.add(current.left);
					if(current.right!=null)
						queue.add(current.right);
				}
				return current;
			}

			public void remove() {
				
			}
			
		}
		
		public class ReverseLevelOrderIterator implements Iterator<Node>{
			
			private Stack<Node> stack;
			private Queue<Node> queue;
			
			public ReverseLevelOrderIterator(){
				stack = new Stack<BinarySearchTreeTest.Node>();
				queue = new LinkedList<BinarySearchTreeTest.Node>();
				prepStep();
			}
			
			private void prepStep(){
				queue.add(root);
				while(!queue.isEmpty()){
					Node current = queue.poll();
					if(current.right!=null)
						queue.add(current.right);
					if(current.left!=null)
						queue.add(current.left);
					stack.push(current);
				}
			}

			public boolean hasNext() {
				return !stack.isEmpty();
			}

			public Node next() {
				return stack.pop();
			}

			public void remove() {
				
			}
			
		}
		
		public class ReverseInorderIterator implements Iterator<Node>{
			
			private Stack<Node> stack;
			private Node current;
			
			public ReverseInorderIterator(){
				this.stack = new Stack<BinarySearchTreeTest.Node>();
				this.current = root;
			}
			
			public boolean hasNext() {
				if(stack.isEmpty() && current == null)
					return false;
				else
					return true;
			}

			public Node next() {
				Node next;
				while(current!=null){
					stack.push(current);
					current = current.right;
				}
				if(current == null && !stack.isEmpty())
					current = stack.pop();
				next = current;
				current = current.left;
				return next;
			}

			public void remove() {
				
			}
			
		}
		
		
		public class InorderIterator implements Iterator<Node>{

			private Stack<Node> stack;
			private Node current;
			
			public InorderIterator(){
				stack = new Stack<BinarySearchTreeTest.Node>();
				this.current = root;
			}
			
			public boolean hasNext() {
				if(stack.isEmpty() && current == null)
					return false;
				else
					return true;
			}

			public Node next() {
				Node next = null;
				
				while(current!=null){
					stack.push(current);
					current=current.left;
				}
				if(current== null && !stack.isEmpty()){
					current = stack.pop();
				}
				next = current;
				current = current.right;
				return next;
			}

			public void remove() {
			}
			
		}
		
		public class PreOrderIterator implements Iterator<Node>{

			private Stack<Node> stack;
			private Node current;
			
			public PreOrderIterator(){
				stack = new Stack<BinarySearchTreeTest.Node>();
				this.stack.push(root);
				this.current = root;
			}
			
			public boolean hasNext() {
				return !stack.isEmpty();
			}

			public Node next() {
				Node next = stack.pop();
				if(next.right!=null)
					stack.push(next.right);
				if(next.left!=null)
					stack.push(next.left);
				return next;
					
			}

			public void remove() {
				
			}	
		}
		
		public class PostOrderIterator implements Iterator<Node>{
			
			private Stack<Node> firstStack;
			private Stack<Node> tempStack;
			
			public PostOrderIterator(){
				firstStack = new Stack<BinarySearchTreeTest.Node>();
				tempStack = new Stack<BinarySearchTreeTest.Node>();
				prepStep();
			}
			
			private void prepStep(){
				tempStack.push(root);
				Node next;
				while(!tempStack.isEmpty()){
					next = tempStack.pop();
					firstStack.push(next);
					if(next.left!=null)
						tempStack.push(next.left);
					if(next.right!=null)
						tempStack.push(next.right);
				}
				
			}

			public boolean hasNext() {
				return !firstStack.isEmpty();
			}

			public Node next() {
				return firstStack.pop();
			}

			public void remove() {
				
			}
			
		}
		
		public void insert(int data){
			this.root = this.insertUtil(this.root, data);
			
		}
		
		private void adjustHeight(Node root){
			root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;
		}
		
		private int getHeight(Node root){
			if(root==null)
				return 0;
			else
				return root.height;
		}
		
		private int getHeightDifference(Node root){
			return getHeight(root.left) - getHeight(root.right);
		}
		
		private Node leftRotate(Node root){
			Node rightNode = root.right;
			Node temp = rightNode.left;
			root.right = temp;
			rightNode.left = root;
			adjustHeight(root);
			adjustHeight(rightNode);
			
			return rightNode;
		}
		
		private Node rightRotate(Node root){
			Node leftNode = root.left;
			Node temp = leftNode.right;
			
			root.left = temp;
			leftNode.right = root;
			
			adjustHeight(root);
			adjustHeight(leftNode);
			
			return leftNode;
					
		}
		
		
		private Node insertUtil(Node root, int data){
			if(root==null){
				Node current = new Node(data);
				return current;
			}
			else if(root.data<data){
				root.right = insertUtil(root.right, data);
			}
			else if(root.data>data){
				root.left = insertUtil(root.left, data);
			}
			adjustHeight(root);
			int heightDifference = getHeightDifference(root);
			
			if(heightDifference<-1 && data>root.right.data){
				return leftRotate(root);
			}
			
			if(heightDifference>1 && data<root.left.data){
				return rightRotate(root);
			}
			
			if(heightDifference<-1 && data<root.right.data){
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
			if(heightDifference>1 && data >root.left.data){
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
			
			return root;
		}
		
		
		
		
		
		public enum TraversalType{
			INORDER,
			PREORDER,
			LEVELORDER,
			POSTORDER,
			REVERSEINORDER,
			REVERSELEVELORDER;
			
		}
		
		
		
	}

}
