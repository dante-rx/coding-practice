package linkedlist;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeSortedList {
    public static void main(String[] args) {
    	MergeSortedList merge = new MergeSortedList();
        ListNode a = new ListNode(2);
        a.next = new ListNode(3);
        a.next.next = new ListNode(4);
        a.next.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(8);
        b.next.next.next = new ListNode(9);
        ListNode i = merge.mergeTwoLists(a, b);
        while (i != null) {
            System.out.print(i.val+"\t");
            i = i.next;
        }

    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        ListNode head = null;
        ListNode headTemp = null;
        if (a.val < b.val) {
            head = a;
            headTemp = head;
            a = a.next;
        } else {
            head = b;
            headTemp = head;
            b = b.next;
        }
        while (a != null && b != null) {
            if (a.val < b.val) {
                headTemp.next = a;
                headTemp = a;
                a = a.next;
            } else {
                headTemp.next = b;
                headTemp = b;
                b = b.next;
            }
        }
        if (a != null) {
            headTemp.next = a;
        }
        if (b != null) {
            headTemp.next = b;
        }

        return head;
    }
}