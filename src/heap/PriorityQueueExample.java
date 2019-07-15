package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * By default heap (PriorityQueue is min heap)
 * 
 * Use collections utility to change the order.
 * @author nagendra
 *
 */
public class PriorityQueueExample {

	public static void main(String a[]) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // Minimum Heap
		int [] array = new int[]{11,2,5,6,8,56,21};
		List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
		pq.addAll(list);
		
		System.out.println(pq);
		System.out.println(pq.peek());
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap
		pq2.addAll(list);
		System.out.println(pq2);
		
		
	}

}
