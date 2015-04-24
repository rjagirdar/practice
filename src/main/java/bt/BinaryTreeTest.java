package bt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;





public class BinaryTreeTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		BinaryTree tree = new BinaryTree(arr);
		System.out.println();
		BinaryTree bstTree = tree.getBST();
		bstTree.printInorder();
		
		System.out.println();
		System.out.println("Check if tree contains given element");
		System.out.println("Is 8 present?: "+ bstTree.contains(8));
		if(bstTree.contains(3)){
			System.out.println("Level of node 3 is "+bstTree.getLevel(3));
		}
		System.out.println("Tree is Complete?: "+bstTree.isfullBinaryTree());
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
		System.out.println("Prune Tree");
 		BinaryTree pruneTree = getPruneTree();
		pruneTree = pruneTree.pruneLeavesonLeangth(4);
		pruneTree.printInorder();
		System.out.println();
		
		
		System.out.println();
		System.out.println("Closest Leaf");
 		BinaryTree closestLeafTree = getClosestLeafTree();
 		char closestLeaf = (char)closestLeafTree.closestLeaf('H');
		System.out.println("Closest Leaf of H is "+closestLeaf);
		System.out.println();
		
		
		System.out.println();
		System.out.println("Diagonal Sum");
 		Collection<Integer> coll = tree.diagonalSum();
 		for(Integer val : coll){
 			System.out.print(val+" ");
 		}
		System.out.println();
		
		tree.topView();
		tree.bottomViewRecur();
		
		System.out.println();
		tree.inorderPredecessorandSuccessor(7);
		System.out.println();
		
		System.out.println();
		System.out.println("Remove Half Nodes");
		BinaryTree newTree = getRemoveNodesBinaryTree();
		newTree.removeHalfNodes();
		bstTree = newTree.getBST();
		System.out.println();
		bstTree.printInorder();
		System.out.println();
		/*Node reverseList = bstTree.reverseLinkedList();
		temp =reverseList;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.left;
		}
		System.out.println();*/
		
		System.out.println();
		System.out.println("Vertex Cover");
		BinaryTree vcTree = getVertexCoverTree();
		System.out.println(vcTree.getVertexCover());
		System.out.println(bstTree.getVertexCover());
		
		
		System.out.println();
		System.out.println("Serialized Form and Deserialization");
		System.out.println(bstTree.serialize());
		String serializedForm = bstTree.serialize();
		bstTree = bstTree.deserialize(serializedForm);
		System.out.println();
		
		System.out.println(tree.areCousins(4, 6));
		
		System.out.println();
		System.out.println("Max Sum path between 2 leaves");
		BinaryTree mspTree = getMaxSumBetweenTwoLeavesTree();
		System.out.println(mspTree.getMaxPathSumBetweenLeaves());
		
		System.out.println();
		System.out.println("Diameter of the tree is "+mspTree.getDiameter());
		System.out.println();
		
		System.out.println();
		System.out.println("Max Sum Path");
		mspTree = getMaxSumPathTree();
		System.out.println(mspTree.getMaxSumPath());
		System.out.println();
		
		
		
	}
	
	private static BinaryTree getMaxSumPathTree(){
		Node root = new Node(10);
		 root.left = new Node(-2);
		 root.right = new Node(7);
		 root.left.left = new Node(8);
		 root.left.right = new Node(-4);
		 return new BinaryTree(root);
	}
	
	
	private static BinaryTree getMaxSumBetweenTwoLeavesTree(){
		Node root = new Node(-15);
		root.left = new Node(5);
	    root.right = new Node(6);
	    root.left.left = new Node(-8);
	    root.left.right = new Node(1);
	    root.left.left.left = new Node(2);
	    root.left.left.right = new Node(6);
	    root.right.left = new Node(3);
	    root.right.right = new Node(9);
	    root.right.right.right= new Node(0);
	    root.right.right.right.left= new Node(4);
	    root.right.right.right.right= new Node(-1);
	    root.right.right.right.right.left= new Node(10);
		return new BinaryTree(root);
	}
	
	private static BinaryTree getVertexCoverTree(){
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.left.right.left = new Node(70);
		root.left.right.right = new Node(80);
		root.right.right = new Node(60);
		return new BinaryTree(root);
	}
	
	private static BinaryTree getRemoveNodesBinaryTree(){
		 	
	    Node root = new Node(2);
	    root.left        = new Node(7);
	    root.right       = new Node(5);
	    root.left.right = new Node(6);
	    root.left.right.left=new Node(1);
	    root.left.right.right=new Node(11);
	    root.right.right=new Node(9);
	    root.right.right.left=new Node(4);
	    return new BinaryTree(root);
		 
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
	
	private static BinaryTree getClosestLeafTree(){
		Node root = new Node('A');
		
		root.left = new Node('B');
		root.right = new Node('C');
		
		root.right.left = new Node('E');
		root.right.right = new Node('F');
		
		root.right.left.left = new Node('G');
		root.right.left.left.left = new Node('I');
		root.right.left.left.right = new Node('J');
		
		root.right.right.right = new Node('H');
		root.right.right.right.left = new Node('K');
		
		return new BinaryTree(root);
	}
	
	private static class Node{
		public int data;
		public Node left;
		public Node right;
		public int height;
		public int vd;
		public int hd;
		public int vcCount;
		public boolean isThreaded;
		
		public Node(){
			this.data= -1;
			this.left = null;
			this.right = null;
			this.height =1;
			this.vd=-1;
			this.hd=-1;
			this.vcCount =-1;
			this.isThreaded = false;
		}
		
		public Node(int data){
			this.data= data;
			this.left = null;
			this.right = null;
			this.height =1;
			this.vd=-1;
			this.hd=-1;
			this.vcCount = -1;
			this.isThreaded = false;
		}
		
		public Node(char ch){
			this.data= ch;
			this.left = null;
			this.right = null;
			this.height =1;
			this.vd=-1;
			this.hd=-1;
			this.vcCount = -1;
			this.isThreaded = false;
		}
		
		public Node(Node temp){
			this.data = temp.data;
			this.left = null;
			this.right = null;
			this.height =1;
			this.vd=-1;
			this.hd=-1;
			this.vcCount = -1;
			this.isThreaded = false;
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
		private Node reverseListHead;
		private Node prev;
		private Node next;
		private String serializedForm = new String();
		private int serializedIndex = 0;
		private int result=0;
		private int diameter = 0;
		
		private Node closestLeaf;
		private int closestLeafDepth;
		
		public BinaryTree(){
			this.root = null;
			this.listHead = null;
			this.prev =null;
			this.reverseListHead = null;
			this.closestLeaf = null;
			this.closestLeafDepth = Integer.MAX_VALUE;
			
		}
		
		public BinaryTree(Node root){
			this.root = deepCopyUtil(root);
			this.prev =null;
			this.listHead = null;
			this.reverseListHead = null;
			this.closestLeaf = null;
			this.closestLeafDepth = Integer.MAX_VALUE;
		}
		
		public BinaryTree(int[] arr){
			this.root = consturctFullBinaryTreeFromArray(arr);
			this.prev =null;
			this.listHead = null;
			this.reverseListHead = null;
			this.closestLeaf = null;
			this.closestLeafDepth = Integer.MAX_VALUE;
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
		 * Max Sum to Leaf from Root
		 */
		
		public int getMaxSumPath(){
			return getMaxPathSumBetweenLeaves(root);
		}
		
		private int getMaxSumPath(Node root){
			if(root == null)
				return 0;
			int leftSum = getMaxPathSumBetweenLeaves(root.left);
			int rightSum = getMaxPathSumBetweenLeaves(root.right);
			
			return root.data+Math.max(leftSum, rightSum);
		}
		
		/***
		 * Reverse Odd Levels of a Binary Tree
		 */
		
		/***
		 * Diameter of the Binary Tree
		 */
		public int getDiameter(){
			return getDiameter(root);
			
		}
		
		private int height(Node current){
			if(current==null)
				return 0;
			return 1+Math.max(height(current.left), height(current.right));
		}
		
		private int getDiameter(Node root){
			if(root == null)
				return 0;
			
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			
			int leftMaxPathLength = getDiameter(root.left);
			int rightMaxPathLength = getDiameter(root.right);
			
			return Math.max((leftHeight+rightHeight+1), Math.max(leftMaxPathLength,rightMaxPathLength));
		}
		
		
		/***
		 * Maximum Path Sum between two leaves
		 */
		public int getMaxPathSumBetweenLeaves(){
			
			getMaxPathSumBetweenLeaves(root);
			return result;
		}
		
		public int getMaxPathSumBetweenLeaves(Node root){
			if(root==null)
				return 0;
			int leftSum = getMaxPathSumBetweenLeaves(root.left);
			int rightSum = getMaxPathSumBetweenLeaves(root.right);
			
			int curr_sum = Math.max((leftSum+rightSum+root.data), Math.max(leftSum,rightSum));
			
			if(curr_sum>result)
				result = curr_sum;
			
			return Math.max(leftSum,rightSum)+root.data;
		}
		
		
		
		/***
		 * Vertex Cover of the Binary Tree
		 */
		public int getVertexCover(){
			getVertexCover(root);
			return root.vcCount;
		}
		
		private int getVcCount(Node root){
			if(root==null)
				return 0;
			else
				return root.vcCount;
		}
		
		private boolean getVertexCover(Node root){
			if(root == null)
				return false;
			root.vcCount = 1;
			boolean leftPresent = getVertexCover(root.left);
			boolean rightPresent = getVertexCover(root.right);
			
			if(leftPresent && rightPresent){
				root.vcCount = getVcCount(root.left) + getVcCount(root.right);
				return false;
			}
			else{
				if(root.left!=null || root.right!=null){
					if(leftPresent){
						root.vcCount+=getVcCount(root.left);
					}
					if(rightPresent){
						root.vcCount+=getVcCount(root.right);
					}
					return true;
				}
				else
					return false;
				
			}	
		}
		
		/***
		 * Check if two nodes are cousins
		 */
		
		public boolean areCousins(int val1, int val2){
			boolean found = false;
			Stack<Node> path1 = new Stack<BinaryTreeTest.Node>();
			Stack<Node> path2 = new Stack<BinaryTreeTest.Node>();
			found = findNodeUtil(root, val1, path1);
			if(!found)
				return false;
			found = findNodeUtil(root, val2, path2);
			if(!found)
				return false;
			
			if(path1.size() == path2.size()){
				path1.pop();path2.pop();
				if(path1.peek().data != path2.peek().data)
					return true;
			}
			
			return false;
				
			
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
		 * Converts the tree into a Reverse Linked List with the ListHead pointer pointing to the Last node of the List
		 */
		
		public Node reverseLinkedList(){
			reverseLinkedList(root);
			return this.reverseListHead;
		}
		
		private void reverseLinkedList(Node current){
			if(current == null)
				return;
			reverseLinkedList(current.right);
			if(next==null){
				this.reverseListHead = current;
			}
			else{
				next.left = current;
				current.right = next;
			}
			next = current;
			reverseLinkedList(current.left);
		}
		
		
		/***
		 * Get Threaded Binary Tree
		 */
		public BinaryTree getThreadedBinaryTree(){
			this.prev = null;
			BinaryTree clone = this.clone();
			convertToThreadedBinary(clone.root);
			return clone;
		}
		
		private void convertToThreadedBinary(Node current){
			if(current == null)
				return;
			convertToThreadedBinary(current.left);
			if(prev == null){
				prev = current;
			}
			else{
				if(prev.right == null){
					prev.right = current;
					prev.isThreaded = true;
				}
			}
			prev = current;
			convertToThreadedBinary(current.right);
		}
		
		
		/***
		 * Serialize a Binary Tree
		 */
		public String serialize(){
			this.serializedForm = new String();
			StringBuilder builder = new StringBuilder(this.serializedForm);
			serialize(root,builder);
			this.serializedForm = builder.toString();
			return this.serializedForm;
			
		}
		
		private void serialize(Node current, StringBuilder builder){
			if(current==null){
				builder.append(-1+",");
				return;
			}
			builder.append(current.data+",");
			serialize(current.left, builder);
			serialize(current.right, builder);
		}
		
		/***
		 * Deserialize Binary Tree
		 */
		public BinaryTree deserialize(String serializedForm){
			String[] parts = serializedForm.split(",");
			Node newRoot = deserialize(parts);
			BinaryTree newTree = new BinaryTree(newRoot);
			newTree.printInorder();
			return newTree;
			
		}
		
		private Node deserialize(String[] serializedForm){
			if(Integer.parseInt(serializedForm[serializedIndex]) == -1){
				serializedIndex++;
				return null;
			}
			Node root = new Node(Integer.parseInt(serializedForm[serializedIndex++]));
			root.left = deserialize(serializedForm);
			root.right= deserialize(serializedForm);
			
			return root;
		}
		
		
		
		/***
		 * Remove Nodes with a Single Child
		 */
		
		public void removeHalfNodes(){
			this.root = removehalfNodesUtil(this.root);
			printInorder();
		}
		
		private Node removehalfNodesUtil(Node root){
			if(root==null)
				return null;
			root.left = removehalfNodesUtil(root.left);
			root.right = removehalfNodesUtil(root.right);
			if(root.left==null && root.right==null){
				return root;
			}
			else if(root.left!=null && root.right!=null){
				return root;
			}
			else{
				if(root.left!=null)
					return root.left;
				else
					return root.right;
			}
		}
		
		
		/***
		 * Diagonal Sum
		 */
		
		public Collection<Integer> diagonalSum(){
			
			Queue<Node> queue = new LinkedList<BinaryTreeTest.Node>();
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			
			queue.add(root);
			root.vd = 0;
			
			while(!queue.isEmpty()){
				
				Node current = queue.poll();
				
				int vd = current.vd;
				
				while(current!=null){
					
					int previous_sum = map.get(vd) == null ? 0 : map.get(vd);
					map.put(vd, previous_sum+current.data);
					
					if(current.left!=null){
						current.left.vd=vd+1;
						queue.add(current.left);
					}
					current = current.right;
				}
			}
			
			return map.values();
		}
		
		
		/***
		 * Top View of the Binary Tree
		 */
		public void topView(){
			Queue<Node> queue = new LinkedList<BinaryTreeTest.Node>();
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			topView(root, map, 0);
			Collection<Integer> topViewColl = map.values();
			System.out.println();
			System.out.println("Top View of the Binary Tree");
			for(int val:topViewColl){
				System.out.print(val+" ");
			}
		}
		
		private void topView(Node root, Map<Integer, Integer> map, int hd){
			
			if(root==null)
				return;
			if(!map.containsKey(hd)){
				map.put(new Integer(hd), root.data);
			}
			topView(root.left, map, hd-1);
			topView(root.right, map, hd+1);
		}
		
		
		/***
		 * Bottom View
		 */
		public void bottomView()
	    {
	        if (root == null)
	            return;
	        int hd = 0;
	        Map<Integer, Integer> map = new TreeMap<>();
	        Queue<Node> queue = new LinkedList<Node>();
	        root.hd = hd;
	        queue.add(root);
	        while (!queue.isEmpty())
	        {
	        	Node temp = queue.remove();
	            hd = temp.hd;
	            //if(!map.containsKey(hd))
	            	map.put(hd, temp.data);
	            
	            
	            if (temp.left != null)
	            {
	                temp.left.hd = hd-1;
	                queue.add(temp.left);
	            }
	            if (temp.right != null)
	            {
	                temp.right.hd = hd+1;
	                queue.add(temp.right);
	            }
	        }
	 
	        
	        Set<Entry<Integer, Integer>> set = map.entrySet();
	 
	        
	        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
	 
	        
	        System.out.println();
	        System.out.println("Bottom View");
	        while (iterator.hasNext())
	        {
	            Map.Entry<Integer, Integer> me = iterator.next();
	            System.out.print(me.getValue()+" ");
	        }
	    }
		
		public void bottomViewRecur(){
			Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
			bottomViewRecur(root, map, 0);
			Collection<Integer> topViewColl = map.values();
			System.out.println();
			System.out.println("Bottom View of the Binary Tree");
			for(int val:topViewColl){
				System.out.print(val+" ");
			}
			
		}
		
		private void bottomViewRecur(Node root,Map<Integer, Integer> map, int hd){
			if(root==null)
				return;
			root.hd = hd;
			map.put(hd, root.data);
			bottomViewRecur(root.left, map, hd-1);
			bottomViewRecur(root.right, map, hd+1);	
		}
		
		/***
		 * Inorder Predecessor and Successor
		 */
		
		public Node[] inorderPredecessorandSuccessor(int key){
			
			Node prev = new Node();
			Node succ = new Node();
			Node localPrev = new Node();
			
			Stack<Node> stack = new Stack<BinaryTreeTest.Node>();
			boolean found = findNodeUtil(root, key, stack);
			if(found){
				Node[] nodes = inorderPredecessorandSuccessor(stack.peek());
				if(nodes[0]!=null)
					System.out.println("Inorder Predecessor is "+nodes[0].data);
				if(nodes[1]!=null)
					System.out.println("Inorder Successor is "+nodes[1].data);
				
			}
			
			found = inorderPredecessorandSuccessor(root, prev, succ, key, localPrev);
			if(found){
				System.out.println();
				System.out.println("Inorder Predecessor is "+prev.data);
				System.out.println("Inorder Successor is "+succ.data);
			}
			else
				System.out.println("Given Key not present");
			
			return null;
		}
		
		private Node[] inorderPredecessorandSuccessor(Node root){
			Node prev = null;
			Node succ = null;
			if(root.left!=null){
				prev = root.left;
				while(prev.right!=null)
					prev=prev.right;
			}
			
			if(root.right!=null){
				succ = root.right;
				while(succ.left!=null)
					succ = succ.left;
			}
			
			return new Node[]{prev,succ};
			
			
		}
		
		private boolean inorderPredecessorandSuccessor(Node root, Node prev, Node succ, int key, Node localPrev){
			if(root == null)
				return false;
			boolean retVal = false;
			boolean leftFound = inorderPredecessorandSuccessor(root.left, prev, succ, key,localPrev);
			if(localPrev.data!=-1 && localPrev.data==key){
				succ.data = root.data;
			}
			if(root.data == key){
				prev.data = localPrev.data;
				retVal = true;
			}
			localPrev.data = root.data;
			boolean rightFound = inorderPredecessorandSuccessor(root.right, prev, succ, key, localPrev);
					
					
			if(leftFound || rightFound){
				retVal =true;
			}
			
			return retVal;
		}
		
		
		/***
		 * 
		 * Returns a boolean value which determines if the binary tree is complete or not
		 */
		public boolean isfullBinaryTree(){
			return isfullBinaryTree(this.root);
		}
		
		private boolean isfullBinaryTree(Node root){
			if(root==null)
				return true;
			if(root.left==null && root.right==null)
				return true;
			if(root.left!=null && root.right!=null){
				return (isfullBinaryTree(root.left) && isfullBinaryTree(root.right));
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
		
		
		
		/*
		 * Left Leaves Sum
		 */
		
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
		 * Closest Leaf
		 */
		public int closestLeaf(char key){
			Stack<Node> path = new Stack<BinaryTreeTest.Node>();
			boolean found = findNodeUtil(root, key, path);
			Node finalClosestLeaf = null;
			int finalClosestDepth = Integer.MAX_VALUE;
			int i=0;
			if(found){
				while(!path.isEmpty()){
					closestLeaf(path.pop(), 0);
					if(this.closestLeafDepth+i < finalClosestDepth){
						finalClosestDepth = this.closestLeafDepth;
						finalClosestLeaf = this.closestLeaf;
					}
					i++;
				}
				
			}
			
			return finalClosestLeaf.data;
		}
		
		private void closestLeaf(Node root, int depth){
			if(root==null)
				return;
			
			if(root.left == null && root.right == null){
				if(this.closestLeafDepth==Integer.MAX_VALUE || depth<this.closestLeafDepth){
					this.closestLeafDepth = depth;
					this.closestLeaf = root;
					return;
				}
			}
			closestLeaf(root.left, depth+1);
			closestLeaf(root.right, depth+1);
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
