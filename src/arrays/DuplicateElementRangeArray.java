package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.techiedelight.com/find-duplicate-element-limited-range-array/
 * 
 * Given a limited range array of size n where array contains elements between 1
 * to n-1 with one element repeating, find the duplicate number in it.
 * 
 * @author nagendra
 *
 */

public class DuplicateElementRangeArray {

	public static void main(String[] args) {
		int a[] = { 1,2,3,4,4};
		int a2[] = { 1,2,3,4,7,8,9,6,5,8};
		solution(a);
		solution2(a2);

		solution3(a);
	}

	/**
	 * Maths n*n+1/2
	 * @param a
	 */
	private static void solution(int[] a) {
		int actualSum =0;
		for (int x:a){
			actualSum += x;
		}
		int n = a.length;
		int toBeSum = (n-1)*n/2 ;
		int element = actualSum-toBeSum;
		
		System.out.println("Duplicate element "+ element); 
	}
	
	/** using Hashing as Set
	 * 
	 * @param a
	 */
	private static void solution2(int a[]){
		Set<Integer> set = new HashSet<>();
		
		int found= -1;
		for(int x:a){
			if (set.contains(x)){
				found= x;
				break;
			}else {
				set.add(x);
			}
		}
		System.out.println("Duplicate element "+ found); 
		
	}
	
	/** marking element negative
	 * 
	 * @param a
	 */
	private static void solution3(int a[]){

		int found =-1;
		for(int i=1; i<=a.length+1; i++){
			if (i ==a.length+1){
				found = a[a.length-1];
				break;
			}
			if (a[i-1] == -1){
				found = a[i-1];
				break;
			}else{
				a[a[i-1]-1] =-1;
			}
		}

		System.out.println("Duplicate element "+ found); 
		
	}

}
