/**
 * 
 */
package binarytree;

/**
 * @author nagendra
 * 
 * A sample Main class to check BinaryTree functionalities.
 *
 */
public class BinaryTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] a) {
		BinaryTree binaryTree = new BinaryTree();
		BinaryTreeNode root = BinaryTreeUtil.createBinaryTree();

		System.out.println("Checking things for height");
		System.out.println("Height: " + binaryTree.getHeight(root));
	}

}
