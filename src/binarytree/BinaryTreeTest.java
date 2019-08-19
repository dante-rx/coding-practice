/**
 * 
 */
package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);

		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		root.right.right.right = new BinaryTreeNode(8);
		System.out.println("Pre Order:- ");
		binaryTree.preOrder(root);
		System.out.println();
		System.out.println("In Order:- ");
		binaryTree.inOrder(root);
		System.out.println();
		System.out.println("Post Order:- ");
		binaryTree.postOrder(root);
		System.out.println();
		System.out.println("Level Order:- ");
		binaryTree.levelOrder(root);

		System.out.println("Checking things for height");
		System.out.println("Height: " + binaryTree.getHeight(root));
		
		System.out.println("Checking node exitannce");
		System.out.println(binaryTree.nodeExists(root, 5));
		System.out.println(binaryTree.nodeExists(root, 11));
		
		System.out.println("Checking node path");
		List<Integer> list = new ArrayList<>();
		System.out.println(binaryTree.findPath(root, 5,list));
		System.out.println(list);
		
		List<Integer> list2 = new ArrayList<>();
		System.out.println(binaryTree.findPath(root, 11, list2));
		System.out.println(list2);
		
		List<Integer> list3 = new ArrayList<>();
		System.out.println(binaryTree.findPath(root, 8, list3));
		System.out.println(list3);
		
		System.out.println("Building tree from inorder and preorder");
		int inOrder[] = {4,2,5,1,6,3};//D B E A F C
		int preOrder[] = {1,2,4,5,3,6};//A B D E C F
		BinaryTreeNode node = binaryTree.buildTreeFromPreAndInOrder(preOrder, inOrder, 0, 5);
		
		binaryTree.postOrder(node);
		System.out.println();
		binaryTree.inOrder(node);
		System.out.println();
		
		int postOrder[] = {4,5,2,6,3,1};
		System.out.println("\nBuilding Complete tree from preOrder and postOrder");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i< postOrder.length;i++) {
			map.put(postOrder[i], i);
		}
		BinaryTreeNode node2 = binaryTree.buildTreeFromPreAndPostOrder(preOrder, postOrder, 0, 5, map);
		binaryTree.inOrder(node2);
		
		
		
		
		
		
	}

}
