/**
 * 
 */
package random;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author nagendra
 *
 */
public class MedianOfStreams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a []= {1,2,5,4,3,8,7,6};
		double b[]=findMedianOfStreams(a);
		System.out.println(Arrays.toString(b));

	}

	private static double[] findMedianOfStreams(int[] a) {
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		double b[]= new double[a.length];
		for (int i=0; i< a.length; i++) {
			addElementInQueue(maxQ, minQ, a[i]);
			balanceOutQueue(maxQ, minQ);
			b[i] = calculateMedian(maxQ, minQ);
		}
		
		
		return b;
	}

	private static double calculateMedian(PriorityQueue<Integer> maxQ, PriorityQueue<Integer> minQ) {
		if (minQ.size() == maxQ.size()) {
			return (double)(minQ.peek()+maxQ.peek())/2;
		}else if (minQ.size() >  maxQ.size()) {
			return minQ.peek();
		}
		return maxQ.peek();
	}

	private static void balanceOutQueue(PriorityQueue<Integer> maxQ, PriorityQueue<Integer> minQ) {
		if (minQ.size() > maxQ.size()+1) {
			maxQ.offer(minQ.poll());
		}else if  (maxQ.size() > minQ.size()+1) {
			minQ.offer(maxQ.poll());
		}
		
	}

	private static void addElementInQueue(PriorityQueue<Integer> maxQ, PriorityQueue<Integer> minQ, int x) {
		if (maxQ.isEmpty() || minQ.isEmpty()) {
			minQ.offer(x);
			return;
		}
		if (x >= maxQ.peek()) {
			minQ.add(x);
		}else {
			maxQ.add(x);
		}
		
	}

}
