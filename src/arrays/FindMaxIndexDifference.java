package arrays;

/**
 * 
 * @author nagendra
 * 
 *         find the max difference between j and i indices such that j > i and
 *         a[j] > a[i] in O(n)
 * 
 *         To solve this problem, we need to get two optimum indexes of arr[]:
 *         left index i and right index j. For an element arr[i], we do not need
 *         to consider arr[i] for left index if there is an element smaller than
 *         arr[i] on left side of arr[i].
 * 
 * 
 *         Similarly, if there is a greater element on right side of arr[j] then
 *         we do not need to consider this j for right index. So we construct
 *         two auxiliary arrays LMin[] and RMax[] such that LMin[i] holds the
 *         smallest element on left side of arr[i] including arr[i], and RMax[j]
 *         holds the greatest element on right side of arr[j] including arr[j].
 * 
 * 
 *         After constructing these two auxiliary arrays, we traverse both of
 *         these arrays from left to right. While traversing LMin[] and RMa[] if
 *         we see that LMin[i] is greater than RMax[j], then we must move ahead
 *         in LMin[] (or do i++) because all elements on left of LMin[i] are
 *         greater than or equal to LMin[i]. Otherwise we must move ahead in
 *         RMax[j] to look for a greater j – i value.
 * 
 *         https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */
public class FindMaxIndexDifference {

	public static void main(String[] args) {
		int a[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		int a1[] = { 34, 23, 26, 22, 1 };

		System.out.println(findMaxIndexDifferenceOptimal(a));
		System.out.println(findMaxIndexDifferenceOptimal(a1));

	}

	/**
	 * This is not going to work for a1 sceanrio
	 * 
	 * @param a
	 * @return
	 */
	private static int findMaxIndexDifference(int[] a) {
		int counter = 0;
		for (int start = 0, end = a.length - 1; start < end;) {
			if (a[start] <= a[end]) {
				return end - start;
			} else {
				if (counter % 2 == 0)
					start++;
				else
					end--;
				counter++;
			}
		}

		return -1;
	}

	/**
	 * This is a great solution
	 * 
	 * @param a
	 * @return
	 */
	private static int findMaxIndexDifferenceOptimal(int[] a) {
		
		// Step1 :- Create A array(MinArray) with size a.length and fill the
		// elements with minumum of A[i] and A[i-1]
		int n = a.length;
		// array containing minimums - [34, 8, 8, 3, 2, 2, 2, 2, 1]
		int A[] = new int[n];
		A[0] = a[0];
		for (int i = 1; i < n; i++) {
			A[i] = Math.min(a[i], A[i - 1]);
		}

		// array containing maximums
		// Step2 :- Create B array(max Array) with size a.length and fill the
		// elements backwards with maximum of B[j] and B[j-1]
		// This is [80, 80, 80, 80, 80, 80, 33, 33, 1]
		int B[] = new int[n];
		B[n - 1] = a[n - 1];
		for (int j = n - 2; j >= 0; j--) {
			B[j] = Math.max(a[j], B[j + 1]);
		}

		int i = 0, maxDiff = -1;
		int j = 0;
		//Step3 : Compare with i & j and check the diff. store maxdiff as temp variable to hold the difference.
		while (i < n && j < n) {
			if (B[j] > A[i]) {
				maxDiff = Math.max(j - i, maxDiff);
				j++;
			} else {
				i++;
			}

		}

		return maxDiff;
	}

}
