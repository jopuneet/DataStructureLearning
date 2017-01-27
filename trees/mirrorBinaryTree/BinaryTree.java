package mirrorBinaryTree;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	public BinaryTree() {
			root = null;
		}
	
	void mirror(){
		root = mirror(root);
	}
	
	Node mirror(Node node){
		if (node == null)
			return node;
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		
		node.left = right;
		node.right = left;
		
		return node;
	}
	
	void inOrder(){
		inOrder(root);
	}
	
	void inOrder(Node root){
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");
 
        tree.mirror();
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();
 
	}
}
