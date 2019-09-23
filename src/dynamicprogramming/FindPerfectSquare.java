/**
 * 
 */
package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nagendra
 *
 *
 *         Given number N, Find the least number of perfect square number sum
 *         needed to get N.
 * 
 *         Example : n=5 (4+1) i.e. 2 n=7 (4+1+1+1) i.e. 4 n=12 (4+4+4) i.e 3
 *         n=20 (16+4) i.e. 2
 * 
 *         Solution- Use Dynamic Programming like the coin denomination problem
 */
public class FindPerfectSquare {

	public static void main(String[] args) {
		System.out.println(4 + " : " + findSolution(4));// 4
		System.out.println(5 + " : " + findSolution(5));// 1
		System.out.println(7 + " : " + findSolution(7));// 4+1+1+1
		System.out.println(12 + " : " + findSolution(12));// 4+4+4
		System.out.println(71 + " : " + findSolution(71)); // 36+25+9+1
		System.out.println(49 + " : " + findSolution(49));// 49
		System.out.println(99 + " : " + findSolution(99));//
		System.out.println(61 + " : " + findSolution(61));// 36+25
		
		System.out.println(12 + " : " + findRecursive(12, buildPerfectSquareArray(12)));// 4+4+4
		System.out.println(49 + " : " + findRecursive(49, buildPerfectSquareArray(49)));// 49
		System.out.println(61+ " : " + findRecursive(61, buildPerfectSquareArray(61)));// 36+25// Slow approach

	}

	private static int findSolution(int n) {
		int perfectSquares[] = buildPerfectSquareArray(n);
		return findIterative(n, perfectSquares);
	}

	private static int findIterative(int n, int[] perfectSquares) {

		// build the solution set
		int[] solution = new int[n + 1];
		solution[0] = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		map.put(0, new ArrayList<>());

		// start finding the solution
		for (int i = 1; i <= n; i++) {
			// Start with max_int
			solution[i] = Integer.MAX_VALUE;
			map.put(i, new ArrayList<>());

			// Now check for all possible squares for each i
			for (int j = 0; j < perfectSquares.length; j++) {
				if (i - perfectSquares[j] >= 0) {
					// Let's check the result
					int result = solution[i - perfectSquares[j]];
					if (result + 1 < solution[i]) {
						solution[i] = result + 1;

						/**
						 * This is used to store the solution, incase user would like to see the perfect
						 * squares which are used.
						 */
						List<Integer> list = new ArrayList<>(map.get(i - perfectSquares[j]));
						list.add(perfectSquares[j]);
						map.put(i, list);
					}
				}
			}
		}
		System.out.println(n + " - numbers used: " + map.get(n));
		return solution[n];
	}

	/**
	 * Simple recursive algo
	 * 
	 * @param n
	 * @param perfectSquares
	 * @return
	 */
	private static int findRecursive(int n, int[] perfectSquares) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (n < 0) {
			return 0;
		}
		int currentSolution = Integer.MAX_VALUE;

		for (int i = 0; i < perfectSquares.length; i++) {
			if (n - perfectSquares[i] >= 0) {
				int count = 1 + findRecursive(n - perfectSquares[i], perfectSquares);
				currentSolution = Math.min(count, currentSolution);
			}
		}
		return currentSolution;
	}

	private static int[] buildPerfectSquareArray(int n) {
		int sqrt = (int) Math.sqrt(n);
		int perfectSquares[] = new int[sqrt];
		for (int i = 0; i < sqrt; i++) {
			perfectSquares[i] = (i + 1) * (i + 1);
		}
		return perfectSquares;
	}

}
