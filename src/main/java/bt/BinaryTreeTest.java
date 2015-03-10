package bt;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;





public class BinaryTreeTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		BinaryTree tree = new BinaryTree(arr);
		System.out.println();
		BinaryTree bstTree = tree.getBST();
		bstTree.printInorder();
		
		System.out.println();
		System.out.println();
		System.out.println("Check if tree contains given element");
		System.out.println("Is 8 present?: "+ bstTree.contains(8));
		if(bstTree.contains(3)){
			System.out.println("Level of node 3 is "+bstTree.getLevel(3));
		}
		System.out.println("Tree is Complete?: "+bstTree.isCompleteBinaryTree());
		System.out.println();
		
		
		System.out.println();
		System.out.println();
		System.out.println("LinkedList Creation and Traversal");
 		Node listHead = bstTree.getLinkedList();
		Node temp =listHead;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.right;
		}
		System.out.println();
		
		
		System.out.println();
		System.out.println("Left Leaves Sum is "+tree.leftLeavesSum());
		
		System.out.println();
		System.out.println();
		System.out.println("Prune Tree");
 		BinaryTree pruneTree = getPruneTree();
		pruneTree = pruneTree.pruneLeavesonLeangth(4);
		pruneTree.printInorder();
		System.out.println();
		
		
	}
	
	private static BinaryTree getPruneTree(){
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.right = new Node(6);
		
		root.left.left.left = new Node(7);
		root.right.right.left = new Node(8);
		
		return new BinaryTree(root);
	}
	
	private static class Node{
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

		public static Comparator<Node> nodeComparator = new Comparator<BinaryTreeTest.Node>() {
			
			public int compare(Node o1, Node o2) {
				return o1.data - o2.data; 
				
			}
		};
	}
	
	private static class BinaryTree{
		private Node root;
		private Queue<Integer> queue;
		private Node listHead;
		private Node prev;
		
		public BinaryTree(){
			this.root = null;
			this.listHead = null;
			this.prev =null;
			
		}
		
		public BinaryTree(Node root){
			this.root = deepCopyUtil(root);
			this.prev =null;
			this.listHead = null;
		}
		
		public BinaryTree(int[] arr){
			this.root = consturctFullBinaryTreeFromArray(arr);
			this.prev =null;
			this.listHead = null;
			printInorderUtil(root);
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
		 * Converts the tree into a Linked List with the ListHead pointer pointing to the First node of the List
		 */
		public Node getLinkedList(){
			BinaryTree cloneTree = this.clone();
			getLinkedListUtil(cloneTree.root);
			return listHead;
		}
		
		public void getLinkedListUtil(Node root){
			if(root==null)
				return;
			getLinkedListUtil(root.left);
			if(prev==null){
				this.listHead= root;
			}
			else{
				prev.right = root;
				root.left = prev;
			}
			prev = root;
			getLinkedListUtil(root.right);
		}
		
		
		/***
		 * 
		 * Returns a boolean value which determines if the binary tree is complete or not
		 */
		public boolean isCompleteBinaryTree(){
			return isCompleteBinaryTree(this.root);
		}
		
		private boolean isCompleteBinaryTree(Node root){
			if(root==null)
				return true;
			if(root.left==null && root.right==null)
				return true;
			if(root.left!=null && root.right!=null){
				return (isCompleteBinaryTree(root.left) && isCompleteBinaryTree(root.right));
			}
			return false;
		}
		
		/***
		 * Remove nodes on root to leaf paths of length < K 
		 * 
		 * 
		 */
		public BinaryTree pruneLeavesonLeangth(int k){
			BinaryTree clone = this.clone();
			Node newRoot = pruneleavesonLength(this.root, k, 1);
			
			return newRoot!=null ? new BinaryTree(newRoot):null;
		}
		
		/***
		 * Remove nodes on root to leaf paths of length < K Util Method
		 */
		
		private Node pruneleavesonLength(Node root, int k, int currentLevel){
			if(root == null)
				return null;
			
			root.left = pruneleavesonLength(root.left, k, currentLevel+1);
			root.right = pruneleavesonLength(root.right, k, currentLevel+1);
			
			if(root.left==null && root.right==null && k>currentLevel){
				return null;
			}
			return root;
		}
		
		public int leftLeavesSum(){
			return this.leftLeavesSum(root, false, 0);
		}
		
		private int leftLeavesSum(Node root, boolean isLeft, int sum){
			if(root==null)
				return 0;
			if(root.left==null && root.right==null){
				if(isLeft){
					sum+=root.data;
					return sum;
				}
				else
					return 0;
			}
			return sum+leftLeavesSum(root.left, true, sum) + leftLeavesSum(root.right, false, sum);
		}
		
		/***
		 * 
		 * Converts the Binary Tree into Binary Search Tree of the same Structure
		 */
		
		public BinaryTree getBST(){
			
			this.queue = new PriorityQueue<Integer>();
			BinaryTree cloneTree = clone();
			populateQueueInorder(cloneTree.root);
			Node bstRoot = populateNodes(cloneTree.root);
			BinaryTree tree = new BinaryTree(bstRoot);
			return tree;
		}
		
		private void populateQueueInorder(Node root){
			if(root==null)
				return;
			populateQueueInorder(root.left);
			this.queue.add(root.data);
			populateQueueInorder(root.right);
			
		}
		
		private Node populateNodes(Node root){
			if(root==null)
				return null;
			root.left=populateNodes(root.left);
			root.data = queue.poll();
			root.right=populateNodes(root.right);
			return root;
			
		}
		
		/***
		 * 
		 * @param data which is the search value to be found out in the Binary Tree
		 * Returns the level number of the Node if the node is found in the tree
		 */
		
		public int getLevel(int data){
			Stack<Node> stack = findNode(data);
			if(stack!=null){
				return stack.size();
			}
			else{
				System.out.println("Node "+data+" not present");
				return -1;
			}
		}
		
		public boolean contains(int data){
			Stack<Node> stack = findNode(data);
			if(stack!=null)
				return !stack.isEmpty();
			else
				return false;
		}
		
		private Stack<Node> findNode(int data){
			Stack<Node> stack = new Stack<BinaryTreeTest.Node>();
			findNodeUtil(root, data, stack);
			if(stack.isEmpty())
				return null;
			return stack;
		}
		
		public boolean findNodeUtil(Node root, int data, Stack<Node> stack){
			if(root == null)
				return false;
			stack.push(root);
			if(root.data == data || findNodeUtil(root.left, data, stack) || findNodeUtil(root.right, data, stack)){
				return true;
			}
			stack.pop();
			return false;
		}
		
		
		
		
		private Node consturctFullBinaryTreeFromArray(int[] arr){
			Queue<Node> queue = new LinkedList<Node>();
			int counter =0;
			if(arr.length == 0)
				return null;
			
			Node root = new Node(arr[0]);
			Node current = null;
			queue.add(root);
			for(int i=1; i<arr.length; i++){
				if((counter==2 && !queue.isEmpty()) || current == null){
					current = queue.poll();
					counter =0;
				}
				Node temp = new Node(arr[i]);
				if(counter == 0)
					current.left = temp;
				else if(counter ==1)
					current.right = temp;
				queue.add(temp);
				counter++;
					
			}
			return root;
		}
		
		public BinaryTree clone(){
			return new BinaryTree(deepCopyUtil(this.root));
		}
		private Node deepCopyUtil(Node root){
			if(root == null)
				return null;
			Node leftTree = deepCopyUtil(root.left);
			Node rightTree = deepCopyUtil(root.right);
			
			Node tempRoot = new Node(root);
			tempRoot.left = leftTree;
			tempRoot.right = rightTree;
			return tempRoot;
			
		}
		
		
		public void delete(){
			deleteUtil(root);
		}
		
		private void deleteUtil(Node root){
			if(root == null)
				return;
			deleteUtil(root.left);
			deleteUtil(root.right);
			
			root.left = null;
			root.right = null;
			
			root = null;
			return;
				
		}
		
	}

}
