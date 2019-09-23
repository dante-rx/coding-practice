package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.hackerrank.com/contests/kilobyte-uz-contest1/challenges/trains-and-platforms/problem
 * 
 * @author nagendra
 *
 */
public class TrainAndPlatformProblem {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		// Scanner sc = new Scanner(System.in);
//        int count =  Integer.parseInt(sc.nextLine());
		List<Duration> times = new ArrayList<>();
//        while (count >0 ){
//            String []t = sc.nextLine().split(" ");
//            times.add(new Duration(Integer.parseInt(t[0]), Integer.parseInt(t[1])));
//            count--;
//            
//        }
		times.add(new Duration(900, 920));
		times.add(new Duration(910, 950));
		times.add(new Duration(940, 1000));
		System.out.println(duration(times)); // 2

//        900 930
//        920 1200 
//        950 1200 
//        1000 1200
//        1230 1300
		List<Duration> times2 = new ArrayList<>();
		times2.add(new Duration(900, 930));
		times2.add(new Duration(920, 1200));
		times2.add(new Duration(950, 1200));
		times2.add(new Duration(1000, 1200));
		times2.add(new Duration(1230, 1300));
		System.out.println(duration(times2)); // 3

		List<Duration> times3 = new ArrayList<>();
		times3.add(new Duration(900, 930));
		times3.add(new Duration(920, 1200));
		times3.add(new Duration(950, 1200));
		times3.add(new Duration(1000, 1200));
		times3.add(new Duration(1230, 1300));
		System.out.println(duration(times3)); // 3
//        900 930
//        920 1200 
//        950 1200 
//        1000 1200
//        1230 1300

//        900 910
//        940 1200 
//        950 1120 
//        1100 1130
//        1500 1900
//        1800 2000

		List<Duration> times4 = new ArrayList<>();
		times4.add(new Duration(900, 910));
		times4.add(new Duration(940, 1200));
		times4.add(new Duration(950, 1120));
		times4.add(new Duration(1100, 1130));
		times4.add(new Duration(1500, 1900));
		times4.add(new Duration(1800, 2000));
		System.out.println(duration(times4)); // 3

		System.out.println(durationUsingSort(times));
		System.out.println(durationUsingSort(times2));
		System.out.println(durationUsingSort(times3));
		System.out.println(durationUsingSort(times4));
	}

	/**
	 * Let's use the HEAP to solve this problem in O(n)
	 * 
	 * @param times
	 * @return
	 */
	public static int duration(List<Duration> times) {
		PriorityQueue<Duration> pq = new PriorityQueue<>();
		if (times.size() == 0) {
			return 0;
		}
		int solution = 1;
		pq.add(times.get(0));
		for (int i = 1; i < times.size(); i++) {
			Duration d = times.get(i);
			Duration peek = pq.peek();

			// Add in the heap
			if (d.end >= peek.start || d.start >= peek.start) {
				pq.add(d);
				peek = pq.peek();
			}

			// Start deleting from the heap until it matches below criteria
			while (d.start >= peek.end) {
				pq.poll();
				peek = pq.peek();
			}
			solution = Math.max(solution, pq.size());

		}
		return solution;
	}

	/**
	 * A simple and great approach to solve the problem in O(nlogn)
	 * 
	 * @param times
	 * @return
	 */
	public static int durationUsingSort(List<Duration> times) {
		if (times.size() == 0) {
			return 0;
		}
		int maxCount = 1, count = 1;

		int[] start = new int[times.size()];
		int[] end = new int[times.size()];
		for (int i = 0; i < times.size(); i++) {
			start[i] = times.get(i).start;
			end[i] = times.get(i).end;
		}
		Arrays.sort(start);
		Arrays.sort(end);

		int i = 1, j = 0;
		// Check from 2nd item(1st index). If departure[0] > start[1] means we need a
		// new platform.
		while (i < times.size() && j < times.size()) {
			if (start[i] < end[j]) {
				count++;
				i++;
				maxCount = Math.max(maxCount, count);
			} else {
				// departure[0] <= start[1], same platform can be re-used
				count--;
				j++;
			}
		}

		return maxCount;
	}

	public static int durationNotOptimal(List<Duration> times) {
		if (times.size() == 0) {
			return 0;
		}
		int solution = 1;

		for (int i = 0; i < times.size(); i++) {
			int count = 1;
			Duration first = times.get(i);
			for (int j = i + 1; j < times.size(); j++) {
				Duration second = times.get(j);
				if (first.end >= second.start) {
					count++;
				} else {
					break;
				}
			}
			solution = Math.max(solution, count);

		}
		return solution;
	}

}

class Duration implements Comparable<Duration> {
	int start;
	int end;

	Duration(int s, int e) {
		this.start = s;
		this.end = e;
	}

	@Override
	public int compareTo(Duration o) {
		return this.end - o.end;
	}

}