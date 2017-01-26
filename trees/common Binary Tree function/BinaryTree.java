package trees;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int key;
	Node left, right;
	public Node(int item){
		key = item;
		left = right = null;
	}
}
public class BinaryTree {

	Node root;
	public BinaryTree() {
		root = null;
	}
	
	
//////////////////////////////////////	PostOrder Tree traversal
	void printPostOrder(Node node){
		if(node == null)
			return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.key + " ");
	}
	void printPostOrder(){
		printPostOrder(root);
	}
//////////////////////////////////////
	
/////////////////////////////////////	InOrder Tree traversal
	void printInOrder(Node node){
		if(node == null)
			return;
		printInOrder(node.left);
		System.out.print(node.key + " ");
		printInOrder(node.right);
	}
	void printInOrder(){
		printInOrder(root);
	}
/////////////////////////////////////
	
/////////////////////////////////////	PreOrder Tree Traversal
	void printPreOrder(Node node){
		if(node == null)
			return;
		System.out.print(node.key + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	void printPreOrder(){
		printPreOrder(root);
	}
/////////////////////////////////////
	
/////////////////////////////////////	LevelOrder Tree Traversal
	void printLevelOrder(){
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node tempNode = queue.poll();
			System.out.print(tempNode.key + " ");
			if(tempNode.left!=null)
				queue.add(tempNode.left);
			if(tempNode.right!=null)
				queue.add(tempNode.right);
		}
	}
/////////////////////////////////////
	
/////////////////////////////////////	InOrder Tree Traversal using MorrisMethod
	void inOrderMorrisTraversal(Node root){
		Node current, pre;
		if(root==null)
			return;
		current = root;
		while(current !=null){
			if(current.left == null){
				System.out.print(current.key + " ");
				current = current.right;
			}
			else{
				pre = current.left;
				while(pre.right != null && pre.right != current)
					pre = pre.right;
				if(pre.right == null){
					pre.right = current;
					current = current.left;
				}
				else
				{
					pre.right = null;
					System.out.print(current.key + " ");
					current = current.right;
				}
			}
		}
	}	
	void inOrderMorrisTraversal(){
		inOrderMorrisTraversal(root);
	}
/////////////////////////////////////
	
/////////////////////////////////////	Height of Tree
	int maxDepth(Node node){
		
		if(node == null)
			return 0;
		else{
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);
			
			if(lDepth>rDepth)
				return (lDepth +1);
			else
				return (rDepth +1);
		}
	}
	int maxDepth(){
		return maxDepth(root);
	}
/////////////////////////////////////
	
/////////////////////////////////////	Diameter of Tree
	int diameter(Node root){
		if(root == null)
			return 0;
		int lHeight = maxDepth(root.left);
		int rHeight = maxDepth(root.right);
		
		int lDiameter = diameter(root.left);
		int rDiameter = diameter(root.right);
		
		return Math.max(lHeight + rHeight +1, Math.max(lDiameter, rDiameter));
	}
	int diameter(){
		return diameter(root);
	}
/////////////////////////////////////
	
/////////////////////////////////////Bulding Tree from inorder and preorder
	static int preIndex = 0;
	Node buildTree(int in[], int pre[], int inStart, int inEnd){
		
		if(inStart>inEnd)
			return null;
		Node tNode = new Node(pre[preIndex++]);
		
		if(inStart == inEnd)
			return tNode;
		
		int inIndex = search(in, inStart, inEnd, tNode.key);
		
		tNode.left = buildTree(in, pre, inStart, inIndex-1);
		tNode.right = buildTree(in, pre, inIndex +1, inEnd);
		return tNode;
	}
	int search(int arr[], int strt, int end, int value){
		int i;
		for (i = strt; i < end; i++) {
			if(arr[i]==value)
				return i;
		}
		return i;
	}
/////////////////////////////////////	
	
//*********************************//Driver function	
	public static void main(String [] args){
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
		
		System.out.println("Postorder of the Tree is: ");
		tree.printPostOrder();
		System.out.println("\nInorder of the Tree is: ");
		tree.printInOrder();
		System.out.println("\nPreorder of the Tree is: ");
		tree.printPreOrder();
		System.out.println("\nLevelorder of the Tree is: ");
		tree.printLevelOrder();
		System.out.println("\nInorder of the Tree by Morris Traversal is: ");
		tree.inOrderMorrisTraversal();

		System.out.println("\nHeight of the tree is : " + tree.maxDepth());
		
		System.out.println("Diameter od the tree is : " + tree.diameter());
		
		BinaryTree tree2= new BinaryTree();
		int in[] = {4, 2, 5, 1, 3};
		int pre[] = {1, 2, 4, 5, 3};
		int len = in.length;
		Node root = tree2.buildTree(in, pre, 0, len-1);
		System.out.println("InOrder traversal of newly constructed tree is: ");
		tree2.printInOrder(root);
		
	}
}
