package trees;

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
	
	void printPostOrder(Node node){
		if(node == null)
			return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.key + " ");
	}
	
	void printInOrder(Node node){
		if(node == null)
			return;
		printPostOrder(node.left);
		System.out.print(node.key + " ");
		printPostOrder(node.right);
	}
	
	void printPreOrder(Node node){
		if(node == null)
			return;
		System.out.print(node.key + " ");
		printPostOrder(node.left);
		printPostOrder(node.right);
	}
	
	void printPostOrder(){
		printPostOrder(root);
	}
	void printInOrder(){
		printInOrder(root);
	}
	void printPreOrder(){
		printPreOrder(root);
	}
	
	public static void main(String [] args){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		System.out.println("Postorder of the Tree is: ");
		tree.printPostOrder();
		System.out.println("\nInorder of the Tree is: ");
		tree.printInOrder();
		System.out.println("\nPreorder of the Tree is: ");
		tree.printPreOrder();
	}
}
