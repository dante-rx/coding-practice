package binarytree;

/**
 * 
 * @author nagendra
 *
 */
public class BinaryTreeNodeExists {

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeUtil.createBinaryTree();
		BinaryTreeNodeExists binaryTree = new BinaryTreeNodeExists();
		
		System.out.println("Checking node exitannce");
		System.out.println(binaryTree.nodeExists(root, 5));
		System.out.println(binaryTree.nodeExists(root, 11));
	}
	
	/**
	 * Check if value exists in given binary tree or not
	 * 
	 * @param node
	 * @param x
	 * @return
	 */
	public boolean nodeExists(BinaryTreeNode node, int x) {
		if (node == null) {
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

}
