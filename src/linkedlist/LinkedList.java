package linkedlist;

/**
 * Sample linkedlist implementation and few of the many functions implementation
 * 
 * @author nagendra
 *
 */
public class LinkedList {
	Node start;

	public LinkedList() {
		start = null;
	}

	public Node append(int data) {
		Node node = new Node(data);
		if (start == null) {
			start = node;
		} else {
			Node current = start;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
		return start;
	}

	/**
	 * remove element xth (x starts with 1,2,3,4)
	 */

	public Node removeFirst() {
		if (start == null) {
			return null;
		}
		Node temp = start;
		start = start.next;
		temp.next = null;
		return temp;
	}

	public Node remove(int x) {
		Node current = start;
		if (start == null) {
			return null;
		}
		if (x == 1) {
			Node temp = start;
			start = start.next;
			System.out.println("Deleted Element: " + temp.data);
			return temp;
		}

		// Basically x element has to be deleted
		// Let's traverse till x-1,
		// as first element already traversed
		for (int i = 2; i <= x - 1; i++) {
			if (current != null)
				current = current.next;
		}
		if (current == null) {
			System.out.println("No Element found at " + x + "th");
			return null;
		}
		Node temp = current.next;
		current.next = temp.next;
		System.out.println("Deleted Element: " + temp.data);
		return temp;
	}

	public void print() {
		Node current = start;
		while (current != null) {
			System.out.print(current.data + " \t");
			current = current.next;
		}
		System.out.println("");
	}

	public void reverse() {
		Node current, previous, next;
		current = start;
		previous = null;
		next = null;
		int counter = 0;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;

			counter++;
			int p1 = previous != null ? previous.data : -1;
			int c1 = current != null ? current.data : -1;
			int n1 = next != null ? next.data : -1;
			System.out.println("Reverse step " + counter);
			System.out.print("Previous: " + p1 + "\t ");
			System.out.print("Current: " + c1 + "\t ");
			System.out.print("Next: " + n1 + "\t ");
			System.out.println();

		}
		start = previous;

	}

	/**
	 * Easy way of doing merge of two link list
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static LinkedList mergeSortedLinkedList(LinkedList list1, LinkedList list2) {

		if (list1 == null || list1.start == null) {
			return list2;
		}
		if (list2 == null || list2.start == null) {
			return list1;
		}
		LinkedList ls = new LinkedList();
		Node node3 = new Node(Integer.MAX_VALUE);
		ls.start = node3;
		Node node1 = list1.start;
		Node node2 = list2.start;
		while (node1 != null && node2 != null) {
			if (node1.data <= node2.data) {
				node3.next = node1;
				node1 = node1.next;
			} else {
				node3.next = node2;
				node2 = node2.next;
			}
			node3 = node3.next;
		}

		if (node1 != null) {
			node3.next = node1;
		}

		if (node2 != null) {
			node3.next = node2;
		}

		ls.removeFirst();
		return ls;
	}

	public void removeDuplicates() {
		Node current = start;
		Node next = current.next;

		while (current != null && next != null) {
			if (current.data == next.data) {

				// Let's remove next node
				current.next = next.next;

				// moving reference.
				next = next.next;

			} else {
				current = current.next;
				next = next.next;
			}
		}

	}

	/**
	 * Let's sort the linkedlist in O(n) time
	 */
	public LinkedList sort(LinkedList ls) {
		LinkedList mid = getMid(ls);
		Node midD = mid.start.next;
		LinkedList midLinkedList = new LinkedList();
		midLinkedList.start = midD;

		mid.start.next = null;
		LinkedList left = sort(ls);
		LinkedList right = sort(midLinkedList);

		return mergeSortedLinkedList(left, right);

	}

	public LinkedList getMid(LinkedList ls) {
		Node node = ls.start;
		if (node == null || node.next == null) {
			return ls;
		}
		Node node1 = node.next;
		Node node2 = node.next.next;
		while (node2 != null) {
			node1 = node1.next;
			node2 = node2.next;
			if (node2 == null) {
				node2 = node2.next;
			}
		}
		LinkedList lss = new LinkedList();

		lss.start = node1;
		return lss;

	}

}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}