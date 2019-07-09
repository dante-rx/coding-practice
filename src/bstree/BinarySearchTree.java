package bstree;

/**
 * Binary Search Tree Implementation and usage.
 * 
 * @author nagendra
 *
 */
public class BinarySearchTree {
	TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public BinarySearchTree(int data) {
		root = new TreeNode(data);
	}

	public void printInOrderNode(TreeNode node) {
		if (node != null) {
			printInOrderNode(node.left);
			System.out.print(node.data + " \t");
			printInOrderNode(node.right);
		}
	}

	public void printInOrder() {
		printInOrderNode(root);
	}

	public void insert(int data) {
		root = insertRec(root, data);
	}

	public TreeNode insertRec(TreeNode node, int data) {
		if (node == null) {
			node = new TreeNode(data);
		} else if (node.data > data) {
			node.left = insertRec(node.left, data);
		} else {
			node.right = insertRec(node.right, data);
		}
		return node;
	}

	public boolean search(int data) {
		return searchRec(root, data);
	}

	public boolean searchRec(TreeNode node, int data) {
		if (node == null) {
			return false;
		} else {
			if (node.data == data) {
				return true;
			} else if (node.data > data) {
				return searchRec(node.left, data);
			} else {
				return searchRec(node.right, data);
			}

		}
	}

	public static void main(String a[]) {
		System.out.println("Creating Binary Search Tree");

		BinarySearchTree bsTree = new BinarySearchTree();
		System.out.println("Inserting elements into Binary Search Tree");
		bsTree.insert(12);
		bsTree.insert(23);
		bsTree.insert(9);
		bsTree.insert(14);
		bsTree.insert(95);
		System.out.println("Printing InOrder");
		bsTree.printInOrder();
		System.out.println("");
		System.out.println("Searching now");
		System.out.println(bsTree.search(12));
		System.out.println(bsTree.search(1));
		System.out.println(bsTree.search(99));



		System.out.println("Finished Binary Search Tree");
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
