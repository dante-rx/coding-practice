/**
 * 
 */
package codingTest;

import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * @author nagendra
 *
 */

/**
A non-empty zero-indexed array A consisting of N integers is given. 
A pair of indices (P, Q), where 0 ≤ P < Q < N, is said to have adjacent values if no value 
in the array lies strictly between values A[P] and A[Q].
For example, in array A such that:
A[0] = 0 A[1] = 3 A[2] = 3
A[3] = 7 A[4] = 5 A[5] = 3
A[6] = 11 A[7] = 1
the following pairs of indices have adjacent values:
(0, 7), (1, 2), (1, 4),
(1, 5), (1, 7), (2, 4),
(2, 5), (2, 7), (3, 4),
(3, 6), (4, 5), (5, 7).
For example, indices 4 and 5 have adjacent values because there is no value in array A that lies 
strictly between A[4] = 5 and A[5] = 3; the only such value could be the number 4, 
and it is not present in the array.
Write a function that returns maximum number of adjacent values


A little similar question here-
https://github.com/htoma/codility/blob/master/codility/Code/AdjacentPairs.cs
 */

public class ArrayMaxIndexDifferenceBasedOnCondition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[5];
		int A[] = { 1, 4, 7, 3, 3, 5 };
		System.out.println(solution(A));
		assert solution(A) == 4;
		System.out.println(solution(new int[] { 1, 1, 1 }));
		assert solution(new int[] { 1, 1, 1 }) == -1;
		System.out.println(solution(new int[] { 0, 3, 3, 7, 5, 3, 11, 1 }));
		assert solution(new int[] { 0, 3, 3, 7, 5, 3, 11, 1 }) == 11;
		solution(a);
	}

	private static int solution(int[] a) {

		int n = a.length;
		if (n == 0 || n == 1) {
			return -1;
		}
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(a[i], i);
		}
		int sol = -1;
		Entry<Integer, Integer> last = null;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (last == null) {
				last = entry;
				continue;
			}
			sol = Math.max(sol, Math.abs(last.getValue() - entry.getValue()));
			last = entry;
		}

		return sol == 0 ? -1 : sol;
	}

}
