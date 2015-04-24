package bst;

public class SplayTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Node {
		public int data;
		public Node left;
		public Node right;
		
		public Node(int data){
			this.data= data;
			this.left = null;
			this.right = null;
		}
		
		public Node(Node temp){
			this.data = temp.data;
			this.left = null;
			this.right = null;
		}
	}
	
	private static class SplayTree{
		private Node root;
		
		public SplayTree(){
			this.root = null;
		}
		
		public SplayTree(Node root){
			this.root = root;
		}
		
		
		public int search(int key){
			
			return -1;
		}
		
		private Node leftRotate(Node root){
			Node temp = root.right;
			root.right = temp.left;
			temp.left = root;
			return temp;
		}
		
		private Node rightRotate(Node root){
			Node temp = root.left;
			root.left = temp.right;
			temp.right = root;
			return temp;
		}
		
		private Node splay(Node root, int key){
			
			if(root == null || root.data == key)
				return root;
			
			if(root.data > key){
				
				if(root.left == null){
					return root;
				}
				
				
				
			}
			else{
				
			}
			
			
			return null;
		}
		
		public void preorder(){
			printPreOrder(this.root);
		}
		
		private void printPreOrder(Node root){
			if(root == null)
				return;
			System.out.print(root.data+" ");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
		
		
	}

}
