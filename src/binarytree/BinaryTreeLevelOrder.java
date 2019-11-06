package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Printing the Binary Tree in Level Order
 * 
 * @author nagendra
 *
 */
public class BinaryTreeLevelOrder {

	public static void main(String[] args) {

		BinaryTreeNode root = BinaryTreeUtil.createBinaryTree();
		BinaryTreeLevelOrder binaryTree = new BinaryTreeLevelOrder();
		System.out.println("Level Order- ");

		binaryTree.printLevelOrder(root);

	}

	/**
	 * Print the Binary Tree in Level Order<br>
	 * Start with level 0<br>
	 * Use Queue to track out numbers<br>
	 * add null to indicate a new level is starting root element is considered to be
	 * in level 0.
	 * 
	 * @param node
	 */
	public void printLevelOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		String str = "Level: 0\t";
		int level = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.remove();
			if (node != null) {
				str += node.data + "\t";
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			} else if (node == null && !queue.isEmpty()) {
				queue.add(null);
				level++;
				str += "\nLevel: " + level + "\t";
			}

		}
		System.out.println(str);

	}

}
