package arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BooleanParser {

	public static void main(String[] args) {
		String eq = "(a&b)";
		String eq1 = "(!a | (a & a))";
		
		BinaryTree tree = getTestBinaryTree();
		System.out.println(tree.isTautology());
	}
	
	private static BinaryTree parse(String eq){
		Stack<Character> operatorStack = new Stack<Character>();
		Queue<Node> operandQueue = new LinkedList<BooleanParser.Node>();
		
		char lastOperator;
		
		for(int i=0; i<eq.length(); i++){
			char ch = eq.charAt(i);
			if(ch == '&' || ch == '|'){
				operatorStack.push(ch);
				lastOperator = ch;
			}
			else if(ch == '!'){
				if(eq.charAt(i+1)=='('){
					operatorStack.push('~');
				}
				else{
					
				}
					
			}
			
		}
		
		return null;
	}
	
	
	
	private static BinaryTree getTestBinaryTree1(){
		return null;
	}
	
	private static BinaryTree getTestBinaryTree(){
		Node root = new Node('|');
		
		root.left = new Node('&');
		root.right = new Node('&');
		
		root.left.left = new Node('a');
		root.left.right = new Node('|');
		root.left.right.left = new Node('!');
		root.left.right.left.left = new Node('b');
		root.left.right.right = new Node('b');
		
		root.right.left = new Node('!');
		root.right.left.left = new Node('a');
		root.right.right = new Node('|');
		root.right.right.left = new Node('!');
		root.right.right.left.left = new Node('b');
		root.right.right.right = new Node('b');
		
		return new BinaryTree(root);
	}
	
	private static enum Operator{
		AND,
		OR,
		NOT
	}
	
	private static class Node{
		boolean isOperator;
		char value;
		Operator op;
		Node left;
		Node right;
		
		public Node(char ch){
			if(isCharOperator(ch)){
				this.isOperator = true;
				this.op = this.getOperatorType(ch);
				this.value = ' ';
			}
			else{
				this.isOperator = false;
				this.op = null;
				this.value = ch;
			}
			this.left = null;
			this.right = null;
		}
		
		private boolean isCharOperator(char ch){
			if(ch=='&' || ch=='|' || ch=='!'){
				return true;
			}
			else
				return false;
		}
		
		private Operator getOperatorType(char ch){
			Operator result = null;
			switch (ch) {
			case '&':
				result = Operator.AND;
				break;
			case '|':
				result = Operator.OR;
				break;
			case '!':
				result = Operator.NOT;
				break;
			}
			return result;
		}
	}
	
	private static class BinaryTree{
		Node root;
		
		public BinaryTree(){
			root = null;
		}
		
		public BinaryTree(Node root){
			this.root = root;
		}
		
		public boolean isTautology(){
			Node newRoot = this.reduce(this.root);
			if(!newRoot.isOperator && newRoot.value == 'T')
				return true;
			else
				return false;
		}
		
		private Node reduce(Node root){
			if(root == null)
				return null;
			if(!root.isOperator){
				return root;
			}
			root.left = reduce(root.left);
			root.right = reduce(root.right);
			
			if(root.isOperator){
				if(root.op == Operator.NOT){
					root = reduceNotNode(root);
				}
				else if(root.op == Operator.AND){
					root = reduceAndNode(root);
				}
				else if(root.op == Operator.OR){
					root = reduceOrNode(root);
				}
			}
			
			return root;
		}
		
		private Node reduceOrNode(Node root){
			
			if( (root.left!=null && root.left.value=='T') || (root.right!=null && root.right.value == 'T') )
				return new Node('T');
			else if(root.left!=null && root.left.value=='F')
				return root.right;
			else if(root.right!=null && root.right.value == 'F')
				return root.left;
			else if(areBothChildrenOperands(root)){
				if(root.left.value == root.right.value)
					return new Node(root.left.value);
				else
					return root;
			}
			else if(isOneoftheChildrenAndOr(root))
				return root;
			else if(isSpecialCondition(root))
				return new Node('T');
			
			return root;
		}
		
		private Node reduceAndNode(Node root){
			if( (root.left!=null && root.left.value=='F') || (root.right!=null && root.right.value == 'F') )
					return new Node('F');
			else if(root.left!=null && root.left.value=='T')
				return root.right;
			else if(root.right!=null && root.right.value == 'T')
				return root.left;
			else if(areBothChildrenOperands(root)){
				if(root.left.value == root.right.value)
					return new Node(root.left.value);
				else
					return root;
			}
			else if(isOneoftheChildrenAndOr(root))
				return root;
			else if(isSpecialCondition(root))
				return new Node('F');
			
			return root;
		}
		
		
		
		private boolean isSpecialCondition(Node root){
			if(!root.left.isOperator){
				Node rightNotChild = this.getNotChild(root.right);
				if(rightNotChild.isOperator)
					return false;
				else if(rightNotChild.value == root.left.value)
					return true;
				else
					return false;
			}
			else if(!root.right.isOperator){
				Node leftNotChild = this.getNotChild(root.left);
				if(leftNotChild.isOperator)
					return false;
				else if(leftNotChild.value == root.right.value)
					return true;
				else
					return false;
			}
			return false;
		}
		
		private boolean areBothChildrenOperands(Node root){
			return root.left.isOperator && root.right.isOperator;
		}
		
		private boolean isOneoftheChildrenAndOr(Node root){
			if(root.left.isOperator && (root.left.op==Operator.AND || root.left.op == Operator.OR))
				return true;
			else if(root.right.isOperator && (root.left.op==Operator.AND || root.right.op == Operator.OR))
				return true;
			else
				return false;
		}
		
		
		
		private Node reduceNotNode(Node root){
			if(root.left!=null && root.left.value=='T')
				return new Node('F');
			else if(root.left!=null && root.left.value=='F')
				return new Node('T');
			else if(root.right!=null && root.right.value == 'T')
				return new Node('F');
			else if(root.right!=null && root.right.value == 'F')
				return new Node('T');
			else
				return root;
		}
		
		private Node getNotChild(Node root){
			if(root.left!=null)
				return root.left;
			else
				return root.right;
		}
	}
	
	
	
	
	
	

}
