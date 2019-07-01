package arrays;

import java.util.Stack;

/**
 * The Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1. <br>
 * https://algorithmsandme.com/next-greater-element-in-array/ <br>
 * Solution :- Use the stack to store the element check for next element, <br>
 * If element is greater than TOS then this is element for TOS. Pop out from
 * stack and print NGE. Perform the same operation for next integer.
 * 
 * @author nagendra
 *
 */
public class NextGreaterElementArray {

	public static void main(String[] args) {

		int arr[] = { 11, 13, 21, 3 };
		printNGE(arr);

		System.out.println();
		int arr2[] = { 11, 13, 21, 3, 5, 6, 7, 11, 9 };
		printNGE(arr2);

		System.out.println();
		int arr3[] = { 4, 5, 2, 25 };
		printNGE(arr3);
	}

	/**
	 * Use the stack to store the element check for next element, If element is
	 * greater than TOS then this is element for TOS. Pop out from stack and
	 * print NGE. Perform the same operation for next integer.
	 * 
	 * @param a
	 */
	private static void printNGE(int[] a) {
		Stack<Integer> stack = new Stack<>();
		stack.push(a[0]);
		for (int i = 1; i < a.length; i++) {
			while (!stack.isEmpty() && a[i] > stack.peek()) {
				System.out.println("NGE of " + stack.pop() + " -> " + a[i]);
			}
			stack.push(a[i]);
		}

		while (!stack.isEmpty()) {
			System.out.println("NGE of " + stack.pop() + "->  -1");
		}
	}

}
