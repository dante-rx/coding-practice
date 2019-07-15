/**
 * 
 */
package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author nagendra
 *
 */
public class MedianOfStreamOfIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 5, 15, 1, 3, 4, 7, 8, 10, 12 };
		System.out.println("Median after elements");
		double[] medians = new MedianOfStreamOfIntegers().findMedianStream(a);
		System.out.println(Arrays.toString(medians));

	}

	/**
	 * Simple and optimized approach
	 * 
	 * @param a
	 * @return
	 */
	private double[] findMedianStream(int[] a) {
		int length = a.length;
		double median[] = new double[length];
		// of all Bigger numbers and so minimum is always at n/2.
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		// All smaller numbers go here and so root is always at n/2

		for (int i = 0; i < length; i++) {
			addNumberInTheHeaps(minHeap, maxHeap, a[i]);
			balance(minHeap, maxHeap);
			median[i] = calculateMedian(minHeap, maxHeap);
		}
		return median;
	}

	private void addNumberInTheHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int x) {
		// simple - If element is greater than peek of pqMin add in pqMin.
		// for first element add in pqMin.
		if (minHeap.size() == 0 || x > minHeap.peek()) {
			minHeap.offer(x);
		} else {
			maxHeap.offer(x);
		}
	}

	/**
	 * This is not so optimized.
	 * 
	 * @param a
	 * @return
	 */
	private double[] findMedianStream2(int[] a) {
		int length = a.length;
		double median[] = new double[length];

		PriorityQueue<Integer> pqMin = new PriorityQueue<>();
		PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

		// Now in pqMin - First element is maximum of a[0] and a[1]
		// in pqMax = first element is minimum of a[0] and a[1]

		if (length >= 1) {
			median[0] = a[0];
		}

		if (length >= 2) {
			median[1] = getAvg(a[0], a[1]);
		}

		if (length > 2) {
			if (a[0] > a[1]) {
				pqMin.add(a[0]);
				pqMax.add(a[1]);
			} else {
				pqMin.add(a[1]);
				pqMax.add(a[0]);
			}

			for (int i = 2; i < length; i++) {
				if (a[i] > pqMax.peek()) {
					/*
					 * if item is smaller than maxHeap peek then add it to
					 * minHeap. Basically Item in minheap, all bigger elements
					 * are added and so root will be always around n/2th
					 * element.
					 * 
					 * And n/2 smaller elements go to maxheap and so maxheap
					 * will also have same thing. root will be largest element.
					 */
					pqMin.offer(a[i]);
				} else {
					pqMax.offer(a[i]);

				}
				balance(pqMin, pqMax);
				median[i] = calculateMedian(pqMin, pqMax);
			}
		}

		return median;
	}

	private void balance(PriorityQueue<Integer> pqMin, PriorityQueue<Integer> pqMax) {
		// balance items pqMax size should be less than equal to
		// pqMin+1;
		if (pqMax.size() > pqMin.size() + 1) {
			pqMin.offer(pqMax.poll());
		}

		// balance items pqMin size should be less than equal to
		// pqMax+1;
		if (pqMin.size() > pqMax.size() + 1) {
			pqMax.offer(pqMin.poll());
		}
	}

	private double calculateMedian(PriorityQueue<Integer> pqMin, PriorityQueue<Integer> pqMax) {
		// Now let's calculate median
		if (pqMax.size() == pqMin.size()) {
			return getAvg(pqMax.peek(), pqMin.peek());
		} else if (pqMax.size() > pqMin.size()) {
			return pqMax.peek();
		} else {
			return pqMin.peek();
		}
	}

	private double getAvg(int x, int y) {
		return (double) (x + y) / 2;
	}

}
