package dynamicprogramming;

/**
 * 
 * @author nagendra
 * 
 *         There are n stairs, a person standing at the bottom wants to reach
 *         the top. The person can climb either 1 stair or 2 stairs at a time.
 *         Count the number of ways, the person can reach the top.
 * 
 *         Input: n = 1 Output: 1 There is only one way to climb 1 stair
 * 
 *         Input: n = 2 Output: 2 There are two ways: (1, 1) and (2)
 * 
 *         Input: n = 4 Output: 5 (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1),
 *         (2, 2)
 */

/**
 * Approach Dynamic Programming
 * @author nagendra
 *
 */
public class CountStairs {

	public static void main(String[] args) {

		System.out.println(countStepsDynamic(3));
		System.out.println(countStepsDynamic(1));
		System.out.println(countStepsDynamic(15));
	}

	/*
	 * Dynamic programming solution
	 */
	public static int countStepsDynamic(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		int[] solution = new int[n];
		solution[0] = 1;
		solution[1] = 2;
		for (int i = 2; i < n; i++) {
			solution[i] = solution[i - 1] + solution[i - 2];
		}

		return solution[n - 1];
	}

	/**
	 * Recursive solution
	 * 
	 * @param n
	 * @return
	 */
	public static int countSteps(int n) {
		if (n <= 0) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		return countSteps(n - 1) + countSteps(n - 2);
	}
}
