package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://www.hackerrank.com/challenges/candies/problem
 * 
 * @author nagendra <br>
 *         Alice is a kindergarten teacher. She wants to give some candies to
 *         the children in her class. All the children sit in a line and each of
 *         them has a rating score according to his or her performance in the
 *         class. Alice wants to give at least 1 candy to each child. If two
 *         children sit next to each other, then the one with the higher rating
 *         must get more candies. Alice wants to minimize the total number of
 *         candies she must buy.
 * 
 *         For example, assume her students' ratings are [4, 6, 4, 5, 6, 2]. She
 *         gives the students candy in the following minimal amounts: [1, 2, 1,
 *         2, 3, 1]. She must buy a minimum of 10 candies.
 * 
 *         Function Description
 * 
 *         Complete the candies function in the editor below. It must return the
 *         minimum number of candies Alice must buy.
 * 
 *         candies has the following parameter(s):
 * 
 *         n: an integer, the number of children in the class arr: an array of
 *         integers representing the ratings of each student Input Format
 * 
 *         The first line contains an integer, , the size of . Each of the next
 *         lines contains an integer indicating the rating of the student at
 *         position .
 * 
 *         Output Format Output a single line containing the minimum number of
 *         candies Alice must buy.
 *
 */
public class MinimumCandies {

	public static void main(String[] args) {
		int a[] = { 9, 10, 9, 8, 7, 8, 9 };
		int b[] = { 5, 5, 4 };
		int c[] = { 5, 5, 5, 4, 3 };
		int d[] = { 5, 4, 5, 3, 5, 5 };
		int e[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		getMinimumCandies(a);
		getMinimumCandies(b);
		getMinimumCandies(c);
		getMinimumCandies(d);
		getMinimumCandies(e);

		getMinimumCandies2(a);
		getMinimumCandies2(b);
		getMinimumCandies2(c);
		getMinimumCandies2(d);
		getMinimumCandies2(e);

	}

	/**
	 * This is optimal solution in just O(n)
	 * 
	 * @param a
	 */
	private static void getMinimumCandies2(int[] a) {
		int b[] = new int[a.length];
		// step 1: Give 1 candie to everybody
		Arrays.fill(b, 1);

		// step 2: start from left and increase the candy based on ratings in array
		for (int i = 0; i < a.length - 1; i++) {
			// if current greater than next, then give 1 more candie to current
			if (a[i] > a[i + 1]) {
				b[i] = b[i + 1] + 1;
			} // if current lesser than next, then give 1 more candie to next, if it's having
				// less
			else if (a[i] < a[i + 1] && b[i + 1] <= b[i]) {
				b[i + 1] = b[i] + 1;
			}
		}

		// step 3: start from right end and increase the candy based on ratings
		for (int i = a.length - 1; i > 0; i--) {
			// if current(It's from end) greater than next(backward next), then give 1 more
			// candie to current
			if (a[i] > a[i - 1] && b[i] <= b[i - 1]) {
				b[i] = b[i - 1] + 1;
			} else if (a[i] < a[i - 1] && b[i - 1] <= b[i]) {
				b[i - 1] = b[i] + 1;
			}
		}

		System.out.println("Input: " + Arrays.toString(a));
		System.out.println("Candies: " + Arrays.toString(b));
		System.out.println();
	}

	/**
	 * This solution can be used, but not so great.
	 * 
	 * @param a
	 */
	private static void getMinimumCandies(int[] a) {
		int values[] = new int[a.length];
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				List<Integer> list = map.get(a[i]);
				list.add(i);
				map.put(a[i], list);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(a[i], list);
			}
		}

		Set<Integer> keySet = map.keySet();
		for (int x : keySet) {
			List<Integer> list = map.get(x);
			for (int index : list) {
				process(a, values, index);
			}
		}
		System.out.println("Input: " + Arrays.toString(a));
		System.out.println("Candies: " + Arrays.toString(values));
		System.out.println();
	}

	private static void process(int[] a, int[] values, int index) {
		int current = a[index];
		int currentV = values[index];

		int previous = 0;// index==0 ? 0 : a[index-1];
		int previousV = 0;
		if (index > 0) {
			previous = a[index - 1];
			previousV = values[index - 1];
		}
		int next = 0; // for last element
		int nextV = 0; // // for last element
		if (index < a.length - 1) {
			next = a[index + 1];
			nextV = values[index + 1];
		}

		if (current == next && current == previous) {
			values[index] = Math.max(1, Math.min(currentV, Math.max(previousV, nextV)));
		} else {
			values[index] = Math.max(currentV, Math.max(previousV, nextV)) + 1;
		}
		// handle special last and first case!
		if (a[a.length - 1] == a[a.length - 2]) {
			values[a.length - 1] = 1;
		}

		if (a[0] == a[1]) {
			values[0] = 1;
		}

	}

}
