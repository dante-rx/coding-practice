package arrays;

import java.util.Arrays;

/**
 * 
 * 3 way pivot partitioning just like quick sort but here chose low, mid and
 * high and do things on mid. Complexity O(n) Very fast!!!
 * 
 * http://www.techiedelight.com/sort-array-containing-0s-1s-2s-dutch-national-flag-problem/
 * 
 * @param a
 * 
 * @author nagendra
 *
 */
public class SortArray0and1and2 {

	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
		solution(a);
		System.out.println(Arrays.toString(a));

	}

	/**
	 * 3 way pivot partitioning just like quick sort but here chose low, mid and
	 * high and do things on mid. Complexity O(n) Very fast
	 * 
	 * @param a
	 */
	private static void solution(int[] a) {
		int low = 0;
		int mid = 0;
		int pivot = 1;
		int high = a.length - 1;

		while (mid <= high) {

			if (a[mid] < pivot) { // current element is 0 and low++ and mid++
				swap(a, low, mid);
				low++;
				mid++;
			} else if (a[mid] > pivot) { // current element is 2 and so high --
				swap(a, mid, high);
				high--;
			} else {
				mid++; // current element is 1 and so only mid++;
			}
		}

	}

	public static void swap(int a[], int i, int j) {
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}

}
