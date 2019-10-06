package codingTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Find numbers between 1 to n such that it's divisable by either x or y but not
 * divisable by z.
 * 
 * @author nagendra
 *
 */
public class XyZ {

	public static void main(String[] args) {
		System.out.println(multiple(3, 5, 10, 12));

	}

	public static List<Integer> multiple(int x, int y, int z, int n) {
		List<Integer> list = new ArrayList<Integer>();

		if (x == 0) {
			x = y;
		}

		if (y == 0) {
			y = x;
		}

		if (x == 0 && y == 0) {
			return list;
		}

		for (int i = 1; i <= n; i++) {
			if ((i % x == 0 || i % y == 0) && (z == 0 || i % z != 0)) {
				list.add(i);
			}
		}

		return list;

	}

}
