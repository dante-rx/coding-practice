package binarytree;

/**
 * Create a binary Tree from Pre and Inorder
 * @author nagendra
 *
 */
public class BinaryTreeBuildFromPreAndInOrder {

	public static void main(String[] args) {
		BinaryTreeBuildFromPreAndInOrder instance = new BinaryTreeBuildFromPreAndInOrder();

		System.out.println("Building tree from inorder and preorder");
		int inOrder[] = { 4, 2, 5, 1, 6, 3 };// D B E A F C
		int preOrder[] = { 1, 2, 4, 5, 3, 6 };// A B D E C F
		BinaryTreeNode node = instance.buildTreeFromPreAndInOrder(preOrder, inOrder, 0, 5);

		BTreeInPrePostOrder bTreeInPrePostOrder = new BTreeInPrePostOrder();
		bTreeInPrePostOrder.printAllOrder(node);
	}

	static int preCounter = 0;

	/**
	 * preorder - root, left, right and so preOrder[0] is the root node.<br>
	 * inorder - left, root, right <br>
	 * find the position of preOrder[0] character in inorder and that's the parent
	 * node. element after it wll be right child and element before left child.
	 * construct tree recursively
	 */
	public BinaryTreeNode buildTreeFromPreAndInOrder(int[] preOrder, int[] inOrder, int inStart, int inEnd) {

		BinaryTreeNode node = null;
		if (preOrder.length > preCounter && inStart <= inEnd) {
			node = new BinaryTreeNode(preOrder[preCounter++]);
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

	/**
	 * This can be further optimized by using hashmap.
	 * 
	 * @param inOrder
	 * @param start
	 * @param end
	 * @param x
	 * @return
	 */
	private int getIndexInOrder(int[] inOrder, int start, int end, int x) {
		for (int i = start; i <= end; i++) {
			if (inOrder[i] == x) {
				return i;
			}
		}
		return -1;
	}
}
