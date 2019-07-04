package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author nagendra
 *
 */

/*
 * Depth First Traversals: (a) Inorder (Left, Root, Right) : 4 2 5 1 3 (b)
 * Preorder (Root, Left, Right) : 1 2 4 5 3 (c) Postorder (Left, Right, Root) :
 * 4 5 2 3 1
 * 
 * 1 <br>
 * 2 3 <br>
 * 4 5 6 7<br>
 * 
 * PreOrder (Root, Left, Right)- 1,2,4,5,3,6,7 
 * Inorder ( Left, Root, right)-4,2,5,1,6,3,7 
 * Post Order (left, right, root)- 4,5,2,6,7,3,1
 */
public class BinaryTree {
	private static BinaryTreeNode root;

	void add(BinaryTreeNode cNode, int data) {
		if (cNode == null) {
			cNode = new BinaryTreeNode(data);
			return;
		} else {
			BinaryTreeNode node = new BinaryTreeNode(data);
			if (root == null) {
				root = node;
			} else {
				if (root.left == null) {
					root.left = node;
				} else if (root.right == null) {
					node.right = node;
				} else {
					//
				}
			}
		}

	}

	public static void main(String[] a) {
		root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);

		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		root.right.right.right = new BinaryTreeNode(8);
		System.out.println("Pre Order:- ");
		preOrder(root);
		System.out.println();
		System.out.println("In Order:- ");
		inOrder(root);
		System.out.println();
		System.out.println("Post Order:- ");
		postOrder(root);
		System.out.println();
		System.out.println("Level Order:- ");
		levelOrder(root);

		System.out.println("Checking things for height");
		System.out.println("Height: " + getHeight(root));
		
		System.out.println("Checking node exitannce");
		System.out.println(nodeExists(root, 5));
		System.out.println(nodeExists(root, 11));
		
		System.out.println("Checking node path");
		List<Integer> list = new ArrayList<>();
		System.out.println(findPath(root, 5,list));
		System.out.println(list);
		
		List<Integer> list2 = new ArrayList<>();
		System.out.println(findPath(root, 11, list2));
		System.out.println(list2);
		
		List<Integer> list3 = new ArrayList<>();
		System.out.println(findPath(root, 8, list3));
		System.out.println(list3);
		
		System.out.println("Building tree from inorder and preorder");
		int inOrder[] = {4,2,5,1,6,3};//D B E A F C
		int preOrder[] = {1,2,4,5,3,6};//A B D E C F
		BinaryTreeNode node = buildTreeFromPreAndInOrder(preOrder, inOrder, 0, 5);
		postOrder(node);
		
		
		
	}

	// root, left and right
	public static void preOrder(BinaryTreeNode node) {
		if (node == null)
			return;
		System.out.print(node.data + " \t");
		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}

	}

	// left, root and right
	public static void inOrder(BinaryTreeNode node) {

		if (node != null && node.left != null) {
			inOrder(node.left);
		}
		if (node == null)
			return;
		System.out.print(node.data + " \t");

		if (node != null && node.right != null) {
			inOrder(node.right);
		}

	}

	// left, right and parent
	public static void postOrder(BinaryTreeNode node) {

		if (node != null && node.left != null) {
			postOrder(node.left);
		}

		if (node != null && node.right != null) {
			postOrder(node.right);
		}

		if (node == null)
			return;
		System.out.print(node.data + " \t");

	}

	/**
	 * root is also accounted in height. So basically binary tree is having one
	 * node has height of 1.
	 * 
	 * @param node
	 * @return
	 */
	public static int getHeight(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	/**
	 * Print the Binary Tree in Level Order<br>
	 *  Start with level 0<br>
	 * Use Queue to track out numbers<br>
	 * add \n to indicate a new level is starting 
	 * root element is considered to be in level 0
	 * 
	 * @param node
	 */
	public static void levelOrder(BinaryTreeNode node) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		String str = "Level: 0\t";
		int level = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			if (temp != null) {
				str += temp.data + "\t";
			} else {
				if (!queue.isEmpty()) {
					level++;
					str += "\n" + "Level: " + level + "\t";
				}

			}

			if (temp == null && !queue.isEmpty()) {
				queue.add(null); // adding the level
			}

			if (temp != null) {
				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
			}

		}
		System.out.println(str);

	}

	/**
	 * Check if value exists in given binary tree or not
	 * @param node
	 * @param x
	 * @return
	 */
	public static boolean nodeExists(BinaryTreeNode node, int x) {
		if (node == null){
			return false;
		}
		
		if (node != null && node.data == x) {
			return true;
		}

		if (node.left != null || node.right != null) {
			return nodeExists(node.left, x) || nodeExists(node.right, x);

		}
		
		return false;
	}
	
	/**
	 * Find the path from the root node to found node if exist
	 * @param node
	 * @param x
	 * @param list
	 * @return
	 */
	public static boolean findPath(BinaryTreeNode node, int x, List<Integer> list) {
		if (node == null){
			return false;
		}
		
		if (node != null && node.data == x) {
			list.add(node.data);
			return true;
		}
		if(node != null){
			list.add(node.data);
		}
		
		if (node.left != null || node.right != null) {
			return findPath(node.left, x, list) || findPath(node.right, x,list);

		}
		list.remove(list.size()-1);
		return false;
	}
	
	/**
	 * Create a binary tree from pre and inorder traversal
	 * @param preOrder
	 * @param inOrder
	 * @param inStart
	 * @param inEnd
	 * @return
	 */
	static int preCounter = 0;

	public static BinaryTreeNode buildTreeFromPreAndInOrder(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
		// preorder - root, left, right and so preOrder[0] is the root node.
		// inorder - left, root, right
		// find the position of preOrder[0] character in inorder and that's the parent
		// node.
		// element after it wll be right child and element before left child.
		// construct tree recursively

		BinaryTreeNode node = null;
		if (preOrder.length > preCounter) {
			node = new BinaryTreeNode(preOrder[preCounter]);
			preCounter++;
			if (inStart == inEnd) {
				return node;
			}

			int indexInOrder = getIndexInOrder(inOrder, inStart, inEnd, node.data);

			if (indexInOrder >= 0) {
				node.left = buildTreeFromPreAndInOrder(preOrder, inOrder, inStart, indexInOrder - 1);

			}
			if (indexInOrder >= 0) {
				node.right = buildTreeFromPreAndInOrder(preOrder, inOrder, indexInOrder + 1, inEnd);
			}
		}

		return node;
	}
	
	private static int getIndexInOrder(int[] inOrder, int start, int end, int x) {
		for (int i = start; i <= end; i++) {
			if (inOrder[i] == x) {
				return i;
			}
		}
		return -1;
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
