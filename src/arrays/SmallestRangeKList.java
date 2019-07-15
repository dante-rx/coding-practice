/**
 * 
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Reference :- https://www.careercup.com/question?id=16759664
 * 
 * You have k lists of sorted integers. Find the smallest range that includes at
 * least one number from each of the k lists.
 * 
 * For example, List 1: [4, 10, 15, 24, 26]
 * 
 * List 2: [0, 9, 12, 20]
 * 
 * List 3: [5, 18, 22, 30]
 * 
 * The smallest range here would be [20, 24] as it contains 24 from list 1, 20
 * from list 2, and 22 from list 3.
 * 
 * 
 * @author nagendra
 *
 */
public class SmallestRangeKList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] list1 = { 4, 10, 15, 24, 26 };
		int list2[] = { 0, 9, 12, 20 };
		int list3[] = { 5, 18, 22, 30 };

		List<List<Integer>> listOfList = new ArrayList<>();
		listOfList.add(Arrays.stream(list1).boxed().collect(Collectors.toList()));
		listOfList.add(Arrays.stream(list2).boxed().collect(Collectors.toList()));
		listOfList.add(Arrays.stream(list3).boxed().collect(Collectors.toList()));

		PriorityQueue<Node> pq = new PriorityQueue<>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < listOfList.size(); i++) {
			List<Integer> list = listOfList.get(i);
			int element = list.get(0);
			Node node = new Node(i, 0, element);
			pq.add(node);
			max = Math.max(max, element);
		}

		// Now let's do till one of list is empty
		while (true) {
			// Check if the peek of PQ is last element of list or not. If yes,
			// time to break;
			Node node = pq.peek();
			int listNumber = node.listNumber;
			int index = node.index;
			List<Integer> currentList = listOfList.get(node.listNumber);
			if (currentList.size() == index + 1) {
				break; // break the loop as no elements left in array to process
			}

			// now popping from PriorityQueue
			pq.poll();

			// Add next element from the same list from which element is
			// removed.
			Node newNode = new Node(listNumber, index + 1, listOfList.get(listNumber).get(index + 1));
			pq.add(newNode);

			// update the max Range value
			max = Math.max(max, listOfList.get(listNumber).get(index + 1));
		}

		System.out.println("Range is : (" + pq.peek().value + " , " + max + ")");
	}

}

class Node implements Comparable<Node> {

	int listNumber;
	int index;
	Integer value;

	Node(int listNumber, int index, Integer value) {
		this.listNumber = listNumber;
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}

}
