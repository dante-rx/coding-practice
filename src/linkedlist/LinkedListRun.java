package linkedlist;

public class LinkedListRun{
	public static void main(String a[]){
		System.out.println("Starting Linked List operation");
		LinkedList ls = new LinkedList();
		for (int i =1; i<10; i++){
			ls.append(i);
		}
		ls.print();
		System.out.println("Removing element from Linked List");
		ls.remove(3);
		ls.print();
		ls.remove(2);
		ls.print();
		ls.remove(1);
		ls.print();
		ls.remove(11);
		ls.print();
		System.out.println("Reversing Linked List");
		ls.reverse();
		ls.print();
		System.out.println("Removing Head");
		ls.removeFirst();
		ls.print();

		//merge two sorted Link list
		LinkedList ls1 = new LinkedList();
		LinkedList ls2 = new LinkedList();

		for (int i=1; i<=5; i++){
			ls1.append(2*i-1);
			ls2.append(2*i);
		}
		ls1.append(11);
		ls1.append(12);
		
		ls2.append(13);
		ls2.append(13);

		ls1.print();
		ls2.print();
		System.out.println("Merging two linked list");
		LinkedList ls3= LinkedList.mergeSortedLinkedList(ls1, ls2);
		ls3.print();



	}
}

