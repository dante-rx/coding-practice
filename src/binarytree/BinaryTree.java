package binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
	
	public void inOrderRecursive(BinaryTreeNode node){
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

	/**
	 * root is also accounted in height. So basically binary tree is having one
	 * node has height of 1.
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
	
	/**
	 * Print the Binary Tree in Level Order<br>
	 * Start with level 0<br>
	 * Use Queue to track out numbers<br>
	 * add \n to indicate a new level is starting root element is considered to
	 * be in level 0.
	 * 
	 * @param node
	 */	
	public void printLevelOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		String str = "Level: 0\t";
		int level = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.remove();
			if (node != null) {
				str += node.data + "\t";
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			} else if (node == null && !queue.isEmpty()) {
				queue.add(null);
				level++;
				str += "\nLevel: " + level + "\t";
			}

		}
		System.out.println(str);

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

	/**
	 * Create a binary tree from pre and inorder traversal
	 * 
	 * @param preOrder
	 * @param inOrder
	 * @param inStart
	 * @param inEnd
	 * @return
	 */
	static int preCounter = 0;

	/**
	 * preorder - root, left, right and so preOrder[0] is the root node.<br>
	 * inorder - left, root, right <br>
	 * find the position of preOrder[0] character in inorder and that's the
	 * parent node. element after it wll be right child and element before left
	 * child. construct tree recursively
	 */
	public BinaryTreeNode buildTreeFromPreAndInOrder(int[] preOrder, int[] inOrder, int inStart, int inEnd) {

		BinaryTreeNode node = null;
		if (preOrder.length > preCounter && inStart<= inEnd) {
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
	
	int preCounter2=0;
	public BinaryTreeNode buildTreeFromPreAndPostOrder(int[] preOrder, int[] postOrder, int start, int end, Map<Integer, Integer> map) {
		BinaryTreeNode node = null;
		if (start <=end && preCounter2 < preOrder.length) {
			
			node= new BinaryTreeNode(preOrder[preCounter2]);
			preCounter2++;
			
			if (start == end) {
				return node;
			}
			// Now left tree element is start+1 in preOrder, let's find in postOrder from the map
			if (preCounter2 < preOrder.length  && map.containsKey(preOrder[preCounter2]) ) {
				int index = map.get(preOrder[preCounter2]);
				if (start < index) {
					node.left=buildTreeFromPreAndPostOrder(preOrder, postOrder, start, index, map);
				}
				if (index< end) {
					node.right=buildTreeFromPreAndPostOrder(preOrder, postOrder, index+1, end, map);

				}
			}
		}

		return node;
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
