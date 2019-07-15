/**
 * 
 */
package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nagendra
 * 
 *         Check if a given number is Fancy A fancy number is one which when
 *         rotated 180 degrees is the same. Given a number, find whether it is
 *         fancy or not.
 * 
 *         180 degree rotations of 6, 9, 1, 0 and 8 are 9, 6, 1, 0 and 8
 *         respectively
 * 
 *         Examples:
 * 
 *         Input: num = 96 Output: Yes If we rotate given number by 180, we get
 *         same number
 * 
 *         Input: num = 916 Output: Yes If we rotate given number by 180, we get
 *         same number
 * 
 *         Input: num = 996 Output: No
 * 
 *         Input: num = 121 Output: No
 * 
 *         https://www.geeksforgeeks.org/check-if-a-given-number-is-fancy/
 *
 */
public class FancyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 96, 916, 996, 121 };
		checkFancy(a);

	}

	private static void checkFancy(int[] a) {
		for (int x : a) {
			System.out.println(checkFancyOne(x));
		}

	}

	private static boolean checkFancyOne(int x) {
		char[] charArray = Integer.toString(x).toCharArray();
		int digits[] = new int[charArray.length];

		for (int i = 0; i < digits.length; i++) {
			digits[i] = charArray[i] - '0';
		}

		Set<Integer> invalid = new HashSet<>();
		invalid.add(2);
		invalid.add(3);
		invalid.add(4);
		invalid.add(5);
		invalid.add(7);

		Set<Integer> ignore = new HashSet<>();
		ignore.add(1);
		ignore.add(0);
		ignore.add(8);

		Map<Integer, Integer> converted = new HashMap<>();
		converted.put(6, 9);
		converted.put(9, 6);

		// check for x
		List<Integer> sixAnd9s = new ArrayList<>();
		while (x > 0) {
			int y = x % 10;
			x = x / 10;
			// Number has 0 in last then it's invalid
			if (sixAnd9s.size() == 0 && y == 0) {
				return false;
			}

			if (invalid.contains(y)) {
				return false;
			}

			if (ignore.contains(y)) {
				continue;
			}

			sixAnd9s.add(y);
		}
		// Now count of 6 and 9 from the left and right should be same for
		// arraylist
		if (sixAnd9s.size() % 2 != 0) {
			return false;
		}

		for (int i = 0, j = sixAnd9s.size() - 1; i < j; i++, j--) {
			if (converted.get(sixAnd9s.get(i)) != sixAnd9s.get(j)) {
				return false;
			}
		}

		return true;

	}

}
