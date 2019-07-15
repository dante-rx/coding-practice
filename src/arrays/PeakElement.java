/**
 * 
 */
package arrays;

/**
 * @author nagendra
 * 
 *         https://stackoverflow.com/questions/27347747/peak-element-in-an-array
 *
 */
public class PeakElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 10, 20, 15, 2, 23, 90, 67 };
		int arr[] = { 1, 3, 20, 4, 1, 0 };
		int x = findPeak(a);
		System.out.println(x);
		System.out.println(findPeakBinarySearch(arr, 0, arr.length - 1));

	}

	/**
	 * this is O(n)
	 * 
	 * @param a
	 * @return
	 */
	private static int findPeak(int[] a) {
		int current = a[0], next, previous = a[0];
		for (int i = 0; i < a.length - 1; i++) {
			next = (i == a.length - 1 ? a[a.length - 1] : a[i + 1]);
			previous = i == 0 ? a[0] : a[i - 1];
			current = a[i];
			if (current >= previous && current >= next) {
				return current;
			}
		}
		return -1;
	}

	/**
	 * this is log(n) See the explanation here
	 * https://stackoverflow.com/questions/27347747/peak-element-in-an-array
	 */
	private static int findPeakBinarySearch(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		if ((mid == a.length - 1 || a[mid] >= a[mid + 1]) && (mid == 0 || a[mid] >= a[mid - 1])) {
			return mid;
		}

		else if (mid > 0 && a[mid - 1] > a[mid]) {
			return findPeakBinarySearch(a, low, mid - 1);
		}

		else
			return findPeakBinarySearch(a, mid + 1, high);

	}

}
