/**
 * 
 */
package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author nagendra
 *
 */
public class MergeInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int b[][] = merge(a);
		//print(b);
		
		int c[][]= {{1,4}, {0,0}};
		//print(merge(c));
		
		int d[][]= {{2,3},{4,5},{6,7},{8,9},{1,10} };
		//print(merge(d));
		
		int e[][]= {  {2,3},{2,2},{3,3},{1,3},{ 5,7},{2,2},{4,6} };
		print(merge(e));
	}

	public static void print(int a[][]) {
		for (int[] x : a)
			System.out.println(Arrays.toString(x));
	}

	public static int[][] merge(int[][] intervals) {

		if (intervals.length == 0) {
			return intervals;
		}
		List<Interval> list = new ArrayList<>();
		for (int[] a : intervals) {
			list.add(new Interval(a[0], a[1]));
		}

		Collections.sort(list);

		Interval current = list.get(0);
		List<Interval> newList = new ArrayList<>();
		newList.add(current);
		for (int i = 1; i < list.size(); i++) {
			Interval next = list.get(i);
			if (next.first > current.second) {
				// no overlaps
				newList.add(next);
				current = next;
			} else {
				current.first = Math.min(current.first, next.first);
				current.second = Math.max(current.second, next.second);
			}
		}
		int b[][] = new int[newList.size()][2];
		for (int i = 0; i < newList.size(); i++) {
			b[i][0] = newList.get(i).first;
			b[i][1] = newList.get(i).second;

		}
		return b;

	}

}

class Interval implements Comparable<Interval> {
	int first;
	int second;

	public Interval(int f, int s) {
		first = f;
		second = s;
	}

	@Override
	public int compareTo(Interval a) {

		return this.first - a.first;
	}

}
