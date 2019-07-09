package bstree;

/**
 * 
 * @author nagendra
 *
 *         Question 1:-Count BST nodes that lie in a given range Given a Binary
 *         Search Tree (BST) and a range, count number of nodes that lie in the
 *         given range. Examples:
 * 
 * 
 *         Input: <br>
 *         10 <br>
 *         / \ <br>
 *         5 50 <br>
 *         / / \ <br>
 *         1 40 100 <br>
 *         Range: [5, 45 ]<br>
 * 
 *         Output: 3 There are three nodes in range, 5, 10 and 40 Consider
 *         values as inclusive
 */
public class CountBSTNodesWithInRange {

	public static int countNodesWithInRange(TreeNode root, int x, int y) {
		return nodesWithInRange(root, x, y);
	}

	public static int nodesWithInRange(TreeNode node, int x, int y) {
		if (node == null) {
			return 0;
		} else if (node.data == x && node.data == y) {
			return 1;
		} else if (node.data >= x && node.data <= y) {
			return 1 + nodesWithInRange(node.left, x, y) + nodesWithInRange(node.right, x, y);
		} else if (node.data > x && node.data > y) {
			return nodesWithInRange(node.left, x, y);
		} else {
			return nodesWithInRange(node.right, x, y);
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

		System.out.println("Counting within range");
		System.out.println(countNodesWithInRange(bsTree.root, 12, 40));
		System.out.println(countNodesWithInRange(bsTree.root, 0, 11));
		System.out.println(countNodesWithInRange(bsTree.root, 0, 5));
		System.out.println(countNodesWithInRange(bsTree.root, 20, 99));
		System.out.println("Finished Binary Search Tree");

	}

}
