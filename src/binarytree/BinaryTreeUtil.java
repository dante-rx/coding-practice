package binarytree;

/**
 * An utility class to create/operate on the Binary Tree
 * 
 * @author nagendra
 *
 */
public class BinaryTreeUtil {

	/**
	 * Create a Binary Tree
	 * @return
	 */
	public static BinaryTreeNode createBinaryTree() {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);

		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		root.right.right.right = new BinaryTreeNode(8);
		return root;
	}

}
