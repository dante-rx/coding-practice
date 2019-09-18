package linkedlist;


/**
 * 
 * @author nagendra
 * 
 * head<->first<->second<->Tail
 *
 */
public class DoubleLinkList {

	public static void main(String[] args) {
		DLinkedList list = new DLinkedList();
		for (int i=1; i<=10; i++) {
			list.addHead(i);
		}
		list.print();
		list.removeTail();
		list.removeTail();
		list.removeTail();
		list.print();
		
		list.deleteNode(list.head);
		list.print();
	}
}

class DLinkedList {

	DLinkedNode head;
	DLinkedNode tail;

	public void addHead(int data) {
		DLinkedNode node = new DLinkedNode(data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.right= head;
			head.left = node;
			head = node;

		}
	}

	public void removeTail() {
		if (tail != null) {
			DLinkedNode temp = tail.left;
			if (temp != null)
				temp.right = null;
			tail = temp;
		}
	}

	public void print() {
		DLinkedNode node = head;
		while (node != null) {
			System.out.print(node.data + "\t");
			node = node.right;
		}
		System.out.println();
	}
	
	public void deleteNode(DLinkedNode node) {
		
		if (node == head) {
			head = head.right;
			return ;
		}
		
		if (node == tail) {
			tail = tail.left;
			return ;
		}
		
		DLinkedNode left = node.left;
		DLinkedNode right = node.right;
		if (left != null) {
			left.right = right;
		}
		
		if (right != null) {
			right.left = left;
		}
		
	}
}

class DLinkedNode {
	int data;
	DLinkedNode left;
	DLinkedNode right;

	public DLinkedNode(int data) {
		this.data = data;
	}
}
