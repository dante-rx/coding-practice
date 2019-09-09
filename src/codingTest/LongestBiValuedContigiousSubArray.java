package codingTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Find largest size of contagious sub array having maximum of two distinct elements.
 * 
 * @author nagendra
 *
 */
public class LongestBiValuedContigiousSubArray {

	public static void main(String[] args) {
		int a[] = { 0, 5, 4, 4, 5, 12 }; // 4
		System.out.println(solution(a));
		System.out.println(solution(new int[] { 1, 2, 3, 2 })); // 3
		System.out.println(solution(new int[] { 4, 2, 2, 4, 2 })); // 5
		System.out.println(solution(new int[] { 0, 5, 4, 4, 5, 12, 12, 1, 1, 1, 1 })); // 6
		System.out.println(solution(new int[] { 1, 1, 2, 2, 2, 2 })); // 6
	}

	/**
	 * Approach
	 * 1. Use sliding window, find the array having maximum of two elements
	 * @param a
	 * @return
	 */
	public static int solution(int[] a) {
		int n = a.length;
		if (n == 0 | n == 1) {
			return n;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int startIndex = 0;
		int sol = 0;
		int temp = 0;
		for (int i = 0; i < n;) {
			if (count < 2 || map.containsKey(a[i])) {
				if (!map.containsKey(a[i])) {
					count++;
					map.put(a[i], 1);
				} else {
					map.put(a[i], map.get(a[i]) + 1);
				}
				sol = Math.max(sol, i - startIndex);
				i++;
			} else {
				while (count == 2) {
					temp = map.get(a[startIndex]);
					if (temp == 1) {
						count--;
						map.remove(a[startIndex]);
						startIndex++;
					} else {
						map.put(a[startIndex], map.get(a[startIndex]) - 1);
						startIndex++;
					}
				}
			}
		}

		return sol + 1;
	}

}
