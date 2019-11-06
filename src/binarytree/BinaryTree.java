package binarytree;

/**
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
public class BinaryTree {
	private BinaryTreeNode root;

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

	/**
	 * root is also accounted in height. So basically binary tree is having one node
	 * has height of 1.
	 * 
	 * @param node
	 * @return
	 */
	public int getHeight(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
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
