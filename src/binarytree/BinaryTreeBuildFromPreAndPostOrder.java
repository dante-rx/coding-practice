package binarytree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeBuildFromPreAndPostOrder {

	public static void main(String[] args) {
		BinaryTreeBuildFromPreAndPostOrder instance = new BinaryTreeBuildFromPreAndPostOrder();
		
		int inOrder[] = {4,2,5,1,6,3};//D B E A F C
		int preOrder[] = {1,2,4,5,3,6};//A B D E C F
		int postOrder[] = {4,5,2,6,3,1};
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i< postOrder.length;i++) {
			map.put(postOrder[i], i);
		}
		System.out.println("\nBuilding Complete tree from preOrder and postOrder");

		BinaryTreeNode node = instance.buildTreeFromPreAndPostOrder(preOrder, postOrder, 0, 5, map);
		
		BTreeInPrePostOrder bTreeInPrePostOrder = new BTreeInPrePostOrder();
		bTreeInPrePostOrder.printAllOrder(node);

	}

	int preCounter2 = 0;

	public BinaryTreeNode buildTreeFromPreAndPostOrder(int[] preOrder, int[] postOrder, int start, int end,
			Map<Integer, Integer> map) {
		BinaryTreeNode node = null;
		if (start <= end && preCounter2 < preOrder.length) {

			node = new BinaryTreeNode(preOrder[preCounter2]);
			preCounter2++;

			if (start == end) {
				return node;
			}
			// Now left tree element is start+1 in preOrder, let's find in postOrder from
			// the map
			if (preCounter2 < preOrder.length && map.containsKey(preOrder[preCounter2])) {
				int index = map.get(preOrder[preCounter2]);
				if (start < index) {
					node.left = buildTreeFromPreAndPostOrder(preOrder, postOrder, start, index, map);
				}
				if (index < end) {
					node.right = buildTreeFromPreAndPostOrder(preOrder, postOrder, index + 1, end, map);

				}
			}
		}

		return node;
	}

}
