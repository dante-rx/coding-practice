package arrays;

/**
 * The famous Kth Largest element in array <br>
 * Time complexity O(n)<br>
 * Worst complexity O(nlogn)
 * 
 * @author nagendra
 *
 */
public class KthLargestElementInArray {

	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 7, 1, 99, 45, 11, 23 };
		int k = 3;
		int kthlargest = findKthLargest(a, 0, a.length - 1, k);

	}

	private static int findKthLargest(int a[], int low, int high, int k) {
		if (k <= high - low + 1) {
			int pivotIndex = partition(a, low, high, k);
			if (pivotIndex - low == k - 1) {
				return a[pivotIndex];
			} else if (pivotIndex - 1 > k - 1) {
				return findKthLargest(a, low, pivotIndex - 1, k);

			} else {
				return findKthLargest(a, pivotIndex + 1, high, k);
			}

		}
		return -1;
	}

	private static int partition(int a[], int low, int high, int k) {
		if (low < high) {

		}
		return -1;
	}
}
