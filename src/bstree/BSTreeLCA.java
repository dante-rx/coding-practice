package bstree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Find lowest common ancestor of Binary Search Tree<br>
 * 2. Find lowest common ancestor for Binary Tree nodes<br>
 * 3. Find lowest common ancestor for Binary Tree nodes nodes are not
 * guranteed <br>
 * 
 * @author nagendra
 *
 */

public class BSTreeLCA {

	/**
	 * Let's find the path from the root node to the xnode and ynode<br>
	 * then parse the path array and display the last common elements in array
	 * 
	 * @param node
	 * @param x
	 * @param y
	 * @return
	 */
	public static int findLCAUsingPath(TreeNode node, int x, int y) {
		// find path of x

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> xPath = findPathFromRoot(node, x, list1);
		List<Integer> yPath = findPathFromRoot(node, y, list2);

		// Now find the common element of x and y
		int counter = 1;

		int lca = xPath.get(0);

		while (counter < xPath.size() && counter < yPath.size()) {

			if (xPath.get(counter) == yPath.get(counter)) {
				lca = xPath.get(counter);
				counter++;
				continue;
			} else {
				break;
			}

		}

		return lca;
	}

	/**
	 * Efficient way of finding LCA in BSTree Time Complexity O(h) -> h height of
	 * binary tree<br>
	 * It also considers that both node is available in BS tree
	 * 
	 * @param node
	 * @param x
	 * @param y
	 * @return
	 */
	public static TreeNode findLCAEfficientAndRecursive(TreeNode node, int x, int y) {
		if (node == null) {
			return null;
		}

		if (x > node.data && y > node.data) {
			return findLCAEfficientAndRecursive(node.right, x, y);
		} else if (x < node.data && y < node.data) {
			return findLCAEfficientAndRecursive(node.left, x, y);

		}
		/**
		 * No no need for this case as it's already covered now <br>
		 * if ((x >= node.data && y <= node.data) || (x <= node.data && y >=
		 * node.data)){ return node; }
		 */

		return node;

	}

	/**
	 * Iterative way of doing things
	 * 
	 * @param node
	 * @param x
	 * @param y
	 * @return
	 */
	public static TreeNode findLCAIterative(TreeNode node, int x, int y) {
		while (node != null) {
			if (x < node.data && y < node.data) {
				// Check left side
				node = node.left;
			} else if (x > node.data && y > node.data) {
				// Check right side
				node = node.right;
			} else {
				break;
			}
		}
		return node;
	}

	private static List<Integer> findPathFromRoot(TreeNode node, int x, List<Integer> list) {
		list.add(node.data);
		if (x == node.data) {
			// don't do anything
		} else if (x > node.data) {
			// check in right side
			findPathFromRoot(node.right, x, list);
		} else {
			// check in left side
			findPathFromRoot(node.left, x, list);
		}

		return list;
	}

	/**
	 * Let's find the lowest common ancestor for Binary Tree
	 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/<br>
	 * Time complexity = O(n) <br>
	 * 
	 * This takes into assumption that nodes are definitely available in Binary
	 * tree.
	 * 
	 * @param node
	 * @param x
	 * @param y
	 * @return
	 */
	public static TreeNode findLCABinaryTree(TreeNode node, int x, int y) {
		if (node == null) {
			return null;
		}

		// if any value is equal is current node, then that's current LCA
		if (node.data == x || node.data == y) {
			return node;
		}

		// let's find in left sub tree
		TreeNode left = findLCABinaryTree(node.left, x, y);

		// let's do in right sub tree
		TreeNode right = findLCABinaryTree(node.right, x, y);

		// if Left and right they both return not-null value then ofcourse node itself
		// is LCA
		if (left != null && right != null) {
			return node;
		}

		// Finally return based on return value of left and right.
		// if left is null, then return right and vica versa
		return left != null ? left : right;

	}

	/**
	 * This is helper function<br>
	 * Let's find the lowest common ancestor for Binary Tree
	 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/<br>
	 * Time complexity = O(n) <br>
	 * 
	 * This takes into assumption that nodes are might be or might not be available
	 * in Binary tree.
	 * 
	 * @param node
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean xPresent = false;
	private static boolean yPresent = false;

	private static TreeNode findLCABinaryTreeNodeNotGuarantee(TreeNode node, int x, int y) {
		if (node == null) {
			return null;
		}

		TreeNode temp = null;
		// if any value is equal is current node, then that's current LCA
		if (node.data == x) {
			xPresent = true;
			temp = node;
		}

		if (node.data == y) {
			yPresent = true;
			temp = node;
		}

		// let's find in left sub tree
		TreeNode left = findLCABinaryTreeNodeNotGuarantee(node.left, x, y);

		// let's do in right sub tree
		TreeNode right = findLCABinaryTreeNodeNotGuarantee(node.right, x, y);

		if (temp != null) {
			return temp;
		}

		// if Left and right they both return not-null value then ofcourse node itself
		// is LCA
		if (left != null && right != null) {
			return node;
		}

		// Finally return based on return value of left and right.
		// if left is null, then return right and vica versa
		return left != null ? left : right;

	}

	/**
	 * We can extend this method to handle all cases by passing two boolean
	 * variables xPresent and yPresent. xPresent is set as true when n1 is present
	 * in tree and yPresent is set as true if n2 is present in tree.
	 * 
	 * @param node
	 * @param x
	 * @param y
	 * @return
	 */
	public static TreeNode findLCABTreeNotGuarantee(TreeNode node, int x, int y) {
		xPresent = false;
		yPresent = false;
		TreeNode lca = findLCABinaryTreeNodeNotGuarantee(node, x, y);

		if (xPresent && yPresent) {
			return lca;
		} else {
			System.out.print("Node not avilable ");
			TreeNode nodeNotAvailable = new TreeNode(-1);
			return nodeNotAvailable;
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bsTree = new BinarySearchTree();
		System.out.println("Inserting elements into Binary Search Tree");
		bsTree.insert(12);
		bsTree.insert(23);
		bsTree.insert(9);
		bsTree.insert(14);
		bsTree.insert(95);

		System.out.println("Now finding LCA Using Path");

		System.out.println(findLCAUsingPath(bsTree.root, 14, 95));
		System.out.println(findLCAUsingPath(bsTree.root, 9, 95));
		System.out.println(findLCAUsingPath(bsTree.root, 14, 12));
		System.out.println(findLCAUsingPath(bsTree.root, 9, 23));

		System.out.println("Now finding LCA Recusrive");
		System.out.println(findLCAEfficientAndRecursive(bsTree.root, 14, 95).data);
		System.out.println(findLCAEfficientAndRecursive(bsTree.root, 9, 95).data);
		System.out.println(findLCAEfficientAndRecursive(bsTree.root, 14, 12).data);
		System.out.println(findLCAEfficientAndRecursive(bsTree.root, 9, 23).data);

		System.out.println("Now finding LCA Iterative");
		System.out.println(findLCAIterative(bsTree.root, 14, 95).data);
		System.out.println(findLCAIterative(bsTree.root, 9, 95).data);
		System.out.println(findLCAIterative(bsTree.root, 14, 12).data);
		System.out.println(findLCAIterative(bsTree.root, 9, 23).data);

		// Now let's consider they are not binary search tree. Just Binary Tree.
		System.out.println("Now finding LCA for Binary Tree: Nodes are guranteed");
		System.out.println(findLCABinaryTree(bsTree.root, 14, 95).data);
		System.out.println(findLCABinaryTree(bsTree.root, 9, 95).data);
		System.out.println(findLCABinaryTree(bsTree.root, 14, 12).data);
		System.out.println(findLCABinaryTree(bsTree.root, 9, 23).data);

		System.out.println("Now finding LCA for Binary Tree: Nodes are not guranteed");
		System.out.println(findLCABTreeNotGuarantee(bsTree.root, 14, 95).data);
		System.out.println(findLCABTreeNotGuarantee(bsTree.root, 9, 95).data);
		System.out.println(findLCABTreeNotGuarantee(bsTree.root, 14, 12).data);
		System.out.println(findLCABTreeNotGuarantee(bsTree.root, 9, 23).data);
		System.out.println(findLCABTreeNotGuarantee(bsTree.root, 911, 23).data);

	}

}
