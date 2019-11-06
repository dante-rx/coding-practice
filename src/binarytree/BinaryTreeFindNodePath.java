package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Finding the node path of Binary Tree
 * @author nagendra
 *
 */
public class BinaryTreeFindNodePath {

	public static void main(String[] args) {
		
		BinaryTreeNode root = BinaryTreeUtil.createBinaryTree();
		BinaryTreeFindNodePath instance = new BinaryTreeFindNodePath();
		
		
		System.out.println("Checking node path");
		List<Integer> list = new ArrayList<>();
		System.out.println(instance.findPath(root, 5,list));
		System.out.println(list);
		
		List<Integer> list2 = new ArrayList<>();
		System.out.println(instance.findPath(root, 11, list2));
		System.out.println(list2);
		
		List<Integer> list3 = new ArrayList<>();
		System.out.println(instance.findPath(root, 8, list3));
		System.out.println(list3);
	}
	
	/**
	 * Find the path from the root node to found node if exist
	 * 
	 * @param node
	 * @param x
	 * @param list
	 * @return
	 */
	public boolean findPath(BinaryTreeNode node, int x, List<Integer> list) {
		if (node == null) {
			return false;
		}

		if (node != null && node.data == x) {
			list.add(node.data);
			return true;
		}
		if (node != null) {
			list.add(node.data);
		}

		if (node.left != null || node.right != null) {
			return findPath(node.left, x, list) || findPath(node.right, x, list);

		}
		list.remove(list.size() - 1);
		return false;
	}

}
