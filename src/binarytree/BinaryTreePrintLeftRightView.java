package binarytree;

/**
 * /** https://www.techiedelight.com/print-left-view-of-binary-tree/
 * 
 * @author nagendra
 *
 */
public class BinaryTreePrintLeftRightView {

	public static void main(String[] args) {
		BinaryTreePrintLeftRightView instance = new BinaryTreePrintLeftRightView();
		BinaryTreeNode node = BinaryTreeUtil.createBinaryTree();

		System.out.println("\nPrinting Left view of the Binary Tree");
		instance.printLeftView(node);
		System.out.println("\nPrinting Right view of the Binary Tree");
		instance.printRightView(node);
		System.out.println();
	}

	static int leftViewLevel = 0;

	public void printLeftView(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		printLeftViewHelper(node, 1);

	}

	private void printLeftViewHelper(BinaryTreeNode node, int level) {
		if (node == null) {
			return;
		}
		// Print the first element at this level and increase the leftViewLevel value
		// and
		// so it can be used to print 2nd left element and so on.
		if (level == leftViewLevel + 1) {
			leftViewLevel++;
			System.out.println(node.data);
		}
		printLeftViewHelper(node.left, level + 1);
		printLeftViewHelper(node.right, level + 1);

	}

	static int rightViewLevel = 0;

	public void printRightView(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		printRightViewHelper(node, 1);

	}

	private void printRightViewHelper(BinaryTreeNode node, int level) {
		if (node == null) {
			return;
		}
		if (level == rightViewLevel + 1) {
			rightViewLevel++;
			System.out.println(node.data);
		}
		printRightViewHelper(node.right, level + 1);
		printRightViewHelper(node.left, level + 1);
	}

}
