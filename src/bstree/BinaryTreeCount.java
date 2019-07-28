package bstree;

public class BinaryTreeCount {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		System.out.println("test");
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
	}

	public static int numTrees(int n) {
		int result = 0;
		if (n == 1 || n ==0) {
			return 1;
		}
//		if (n == 2) {
//			return 2;
//		}
//		if (n < 0) {
//			return 1;
//		}
//
//		if (n == 0) {
//			return 1;
//		}

		for (int i = 0; i < n; i++) {
			result += numTrees(i) * numTrees(n - i - 1);
		}
		return result;
	}

}