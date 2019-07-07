package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Find the two non-repeating elements in an array of repeating elements Given
 * an array in which all numbers except two are repeated once. (i.e. we have
 * 2n+2 numbers and n numbers are occurring twice and remaining two have
 * occurred once). Find those two numbers in the most efficient way.
 * 
 * 
 * @author nagendra
 *
 */
public class TwoNonRepeatedElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 3, 7, 9, 11, 2, 3, 11 };

		findTwoNonRepeatedElements(arr);

	}

	/**
	 * Simple solution using hashmap.
	 * 
	 * Time complexity O(n)
	 * 
	 * But space complexity also O(n)
	 * 
	 * @param arr
	 */
	private static void findTwoNonRepeatedElements(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int x : arr) {
			if (set.contains(x)) {
				set.remove(x);
			} else {
				set.add(x);
			}
		}
		System.out.println(set);

	}

}
