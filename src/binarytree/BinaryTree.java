package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author nagendra
 *
 */

/*
 * Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

				1
			2		  3
		4	   5	6	7
		
PreOrder (Root, Left, Right)- 1,2,4,5,3,6,7
Inorder ( Left, Root, right)-  4,2,5,1,6,3,7
Post Order (left, right, root)- 4,5,2,6,7,3,1
 */
public class BinaryTree {
	private static BinaryTreeNode root;
	
	void add(BinaryTreeNode cNode, int data) {
		if(cNode == null) {
			cNode = new BinaryTreeNode(data);
			return;
		}else {
			BinaryTreeNode node = new BinaryTreeNode(data);
			if (root == null) {
				root = node;
			} else {
				if (root.left == null) {
					root.left = node;
				}else if (root.right == null) {
					node.right = node;
				}
				else {
					//
				}
			}
		}

	}
	public static void main(String []a) {
		root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		
		
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
	}

	// root, left and right
	public static void preOrder(BinaryTreeNode node) {
		if(node == null)
			return;
		System.out.print(node.data+" \t");
		if( node.left != null) {
			preOrder(node.left);
		}
		if( node.right != null) {
			preOrder(node.right);
		}
		
	}
	
	// left, root and right
	public static void inOrder(BinaryTreeNode node) {

		if( node != null && node.left != null) {
			inOrder(node.left);
		}
		if(node == null)
			return;
		System.out.print(node.data+" \t");
		
		if( node != null && node.right != null) {
			inOrder(node.right);
		}
		
	}
	
	
	// left, right and parent
	public static void postOrder(BinaryTreeNode node) {

		if( node != null && node.left != null) {
			postOrder(node.left);
		}
		
		if( node != null && node.right != null) {
			postOrder(node.right);
		}
		
		if(node == null)
			return;
		System.out.print(node.data+" \t");
		
	}
	
	//Level Order 
	public static void levelOrder(BinaryTreeNode node) {
		Queue<Integer> queue = new LinkedList<>();
		if (node != null) {
			queue.add(node.data);
			//queue.add(-1)
		}
		
	}
}

class BinaryTreeNode {
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode() {

	}

	BinaryTreeNode(int data) {
		this.data = data;
	}

	BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.left = left;
		this.right = right;
	}

}
