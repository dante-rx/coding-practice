package arrays;

import java.util.Arrays;

/**
 * http://www.techiedelight.com/sort-binary-array-linear-time/
 * @author nagendra
 *
 */
public class SortBinaryArray {

	public static void main(String[] args) {
		int a1[] = { 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 };
		int a2[] = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 };
		sortBinaryArraySolution1(a1);
		System.out.println(Arrays.toString(a1));
		sortBinaryArraySolution2(a2);
		System.out.println(Arrays.toString(a2));

	}

	/**
	 * good solution but 2nd is better
	 * @param a
	 */
	protected static void sortBinaryArraySolution1(int[] a) {
		int count0=0, count1=0;
		for(int x:a) {
			if (x == 0) {
				count0++;
			}else {
				count1++;
			}
		}
		
		for(int i=0; i< count0;i++) {
			a[i]=0;
		}
		
		for(int i=0; i< count1;i++) {
			a[count0+i]=1;
		}
		
	}
	
	/**
	 * Simply in one O(n)
	 * @param a
	 */
	protected static void sortBinaryArraySolution2(int[] a) {
		int start =0, end = a.length-1;
		while(start<end) {
			if(a[start]== 0) {
				start++;
				continue;
			} else {
				if(a[end] == 0) {
					swap(a, start, end);
					start++; 
					end--;
				}
			}
			
			if(a[end] == 1 ) {
				end--;
				continue;
			}
		}
		
		
		
	}
	
	protected  static void swap(int a[], int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i]= temp;
		
	}

}
