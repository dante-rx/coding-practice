package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author nagendra
 *
 *Merge K Sorted array of differnt sizes. (Array can contain duplicates)
 *
 *
 */
public class MergeKSortedArrays {
	
	public static void main(String args[]) {
		int a[] = {1,3,4,5,6,7};
		int b[]= {5,6,7,7,9,10};
		int c[]= {15,17,19};
		
		int d[][] = new int[3][6];
		d[0]= a;
		d[1]=b;
		d[2]=c;
		
		int e[]= mergeSortedArrays(d);
		System.out.println(Arrays.toString(e));
	}

	private static int[] mergeSortedArrays(int[][] a) {
		List<Integer> list = new ArrayList<>();
		// Create a MinHeap and add first element from each array.
		PriorityQueue<HeapItem> pq = new PriorityQueue<>();
		for (int i=0 ; i< a.length; i++) {
			pq.add(new HeapItem(a[i][0], i, 0));
		}
		
		// Delete the element from MinHeap
		HeapItem poll = pq.poll();
		while (poll.value != Integer.MAX_VALUE) {
			list.add(poll.value);
			//If there are no elements in corresponding array add int_max_value and so it will not be root unless all elemnts are over
			if (a[poll.arrayIndex].length == poll.itemIndex+1) {
				pq.add(new HeapItem(Integer.MAX_VALUE, poll.arrayIndex, poll.itemIndex+1));
			}else {
				// Add the next element from corresponding Array poll.itemIndex+1 is next element index
				// poll.arrayIndex is corresponding array index
				pq.add(new HeapItem(a[poll.arrayIndex][poll.itemIndex+1], poll.arrayIndex, poll.itemIndex+1));
			}
			poll = pq.poll();
		}
		return list.stream().mapToInt(i->i).toArray();
	}

}

class HeapItem implements Comparable<HeapItem>{
	int arrayIndex;
	int itemIndex;
	int value;
	
	public HeapItem( int value, int arrayIndex, int itemIndex) {
		this.arrayIndex = arrayIndex;
		this.itemIndex = itemIndex;
		this.value = value;
	}

	@Override
	public int compareTo(HeapItem a) {
		return this.value-a.value ==0 ? 1 : this.value-a.value;
	}
	
	
}