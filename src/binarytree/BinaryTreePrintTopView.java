package binarytree;

import java.util.Set;
import java.util.TreeSet;

/**
 * Print Top View of Binary Tree
 * 
 * @author nagendra
 *
 */
public class BinaryTreePrintTopView {

	public static void main(String[] args) {
		BinaryTreePrintTopView instance = new BinaryTreePrintTopView();
		BinaryTreeNode node = BinaryTreeUtil.createBinaryTree();
		Set<TreeNodeWithXCoordinate> set = new TreeSet<>();
		instance.printTopView(node, 0, 0, set);
		System.out.println(set);
		
		Set<TreeNodeWithXCoordinate> set2 = new TreeSet<>();
		instance.printBottomView(node, 0, 0, set2);
		System.out.println(set2);
	}

	private void printTopView(BinaryTreeNode node, int x, int y, Set<TreeNodeWithXCoordinate> set) {
		if (node == null) {
			return;
		}

		TreeNodeWithXCoordinate nodex = new TreeNodeWithXCoordinate(x, node.data);
		if (!set.contains(nodex)) {
			set.add(nodex);
		}
		printTopView(node.left, x - 1, y - 1, set);
		printTopView(node.right, x + 1, y - 1, set);
	}
	
	private void printBottomView(BinaryTreeNode node, int x, int y, Set<TreeNodeWithXCoordinate> set) {
		if (node == null) {
			return;
		}

		TreeNodeWithXCoordinate nodex = new TreeNodeWithXCoordinate(x, node.data);
		/**
		 * Replace this node with latest node
		 */
		if (set.contains(nodex)) {
			set.remove(nodex);
		}
		set.add(nodex);
		printBottomView(node.left, x - 1, y - 1, set);
		printBottomView(node.right, x + 1, y - 1, set);
	}


}

class TreeNodeWithXCoordinate implements Comparable<TreeNodeWithXCoordinate> {
	int x;
	int data;

	public TreeNodeWithXCoordinate(int x, int data) {
		this.x = x;
		this.data = data;
	}

	@Override
	public int compareTo(TreeNodeWithXCoordinate o1) {
		return x - o1.x;
	}

	@Override
	public String toString() {
		return Integer.toString(this.data);
	}
	
}
