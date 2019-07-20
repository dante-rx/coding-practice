package arrays;

import java.util.Arrays;
import java.util.Stack;

public class TestArray {

	public static void main(String[] args) {
		
		int[] a ={4,5,3,2,8,9,12, 19,17,23, 21,9};
		System.out.println(Arrays.toString(new TestArray().NGE(a)));

	}

	int[] NGE(int[] a) {
		int b[] = new int[a.length];
		Stack<Integer> stack = new Stack<>();
		int counter = 0;
		for (int x : a) {
			while (!stack.isEmpty() && x > stack.peek()) {
				b[counter++] = x;
				stack.pop();
			}
			stack.push(x);
		}

		while (!stack.isEmpty()) {
			stack.pop();
			b[counter++] = -1;
		}
		return b;
	}

}
