package binarytree;

public class LargestCompleteBTInBT {

	public static void main(String[] args) {
		System.out.println("hello world");
		/**
		 * (1, (2, None, (4, None, None)), (3, (5, (7, None, None), (8, None, None)),
		 * (6, (9, None, None), (10, (11, None, None), None))))
		 */
		Tree t1 = new Tree(1);
		t1.l= new Tree(2);
		t1.l.r= new Tree(4);
		t1.r= new Tree(3);
		t1.r.l= new Tree(5);
		t1.r.l.l= new Tree(7);
		t1.r.l.r= new Tree(8);
		
		t1.r.r= new Tree(6);
		t1.r.r.l= new Tree(9);
		t1.r.r.r= new Tree(10);
		t1.r.r.r.l= new Tree(11);
		
		
		
		Tree t2 = new Tree(1);
		t2.l= new Tree(2);
		t2.l.r= new Tree(4);
		t2.r= new Tree(3);
		
		System.out.println(solution(t1));
		System.out.println(solution(t2));
		
	}

	public static int solution(Tree T) {
		int sol[] = new int[1];
		findLargestCompleteTree(T, sol);
		return sol[0];
	}
	
	public static int findLargestCompleteTree(Tree node, int[]  sol) {
		if (node == null) {
			return 0;
		}
		if (node.l == null || node.r == null) {
			return 1;
		}
		int left = findLargestCompleteTree(node.l, sol);
		int right = findLargestCompleteTree(node.r, sol);
        int size = 0;
		if ( left == right) {
			// case 1: left and right complete tree.
			size = left * 2 + 1;
		} else {
			// case 2: left and right are not same. Let's use minimum of left or right.
			size = Math.min(left, right) * 2 + 1;
		}

		sol[0] = Math.max(sol[0], size);
		return size;
	}

}

class Tree {
	public int x;
	public Tree l;
	public Tree r;
	Tree(int x){
		this.x =x;
	}
}
