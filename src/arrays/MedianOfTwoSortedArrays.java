package arrays;

/**
 * Complexity = O(log (min (m,n))
 * 
 * @author nagendra
 *
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int a[] = { 3, 4, 6, 8, 11, 15 };
		int b[] = { 6, 8, 34 };

		System.out.println(findMedian(a, b));

		int c[] = { 56 };
		int d[] = { 6, 9, 34 };
		System.out.println(findMedian(c, d));

	}

	private static double findMedian(int[] a, int[] b) {
		// Let's make sure a has smaller length for our partition.
		// O(log (min (m,n))
		if (a.length > b.length) {
			return findMedian(b, a);
		}
		int start = 0, end = a.length;
		while (start <= end) {
			int partA = (start + end) / 2;
			int partB = (a.length + b.length + 1) / 2 - partA;

			/**
			 * to consider the corner cases let's make sure it's covered.
			 */
			int maxLeftA = partA == 0 ? Integer.MIN_VALUE : a[partA - 1];
			int minRightA = partA == a.length ? Integer.MAX_VALUE : a[partA];

			int maxLeftB = partB == 0 ? Integer.MIN_VALUE : b[partB - 1];
			int minRightB = partB == b.length ? Integer.MAX_VALUE : b[partB];

			// if this condition is working, then we got our solution
			if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
				if ((a.length + b.length) % 2 == 0) { // even number of elements
														// then return average.
					return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
				} else { //// odd number of elements then return middle.
					return Math.max(maxLeftA, maxLeftB);
				}
			} else if (maxLeftA > minRightB) {
				// let's go left side
				end = end - 1;
			} else {
				start = start + 1; // let's go right side
			}

		}

		return -1;
	}

}
