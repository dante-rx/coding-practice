package binarytree;

/**
 * Print Binary Tree in Pre, Post and InOrder
 * 
 * @author nagendra
 *
 */
/**
 * Depth First Traversals: <br>
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3 <br>
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3 <br>
 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1<br>
 * <br>
 * 1 <br>
 * 2 3 <br>
 * 4 5 6 7<br>
 * 
 * PreOrder (Root, Left, Right)- 1,2,4,5,3,6,7 <br>
 * Inorder ( Left, Root, right)-4,2,5,1,6,3,7 <br>
 * Post Order (left, right, root)- 4,5,2,6,7,3,1<br>
 */
public class BTreeInPrePostOrder {

	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeUtil.createBinaryTree();
		BTreeInPrePostOrder binaryTree = new BTreeInPrePostOrder();
		binaryTree.printAllOrder(root);
	}

	// root, left and right
	public void preOrder(BinaryTreeNode node) {
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
	public void inOrder(BinaryTreeNode node) {

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

	public void inOrderRecursive(BinaryTreeNode node) {
	}

	// left, right and parent
	public void postOrder(BinaryTreeNode node) {

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

	public void printAllOrder(BinaryTreeNode node) {
		System.out.println("Pre Order:- ");
		this.preOrder(node);
		System.out.println();
		System.out.println("In Order:- ");
		this.inOrder(node);
		System.out.println();
		System.out.println("Post Order:- ");
		this.postOrder(node);
		System.out.println();
	}

}
