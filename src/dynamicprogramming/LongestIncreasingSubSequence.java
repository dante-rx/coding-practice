/**
 * 
 */
package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * 
 * @author nagendra
 *
 */
public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		//int arr[] = { 50, 3, 10, 7, 40, 80 };
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
		int arr2[] = { 3, 10, 2, 1, 20 };
		List<Integer> list = new ArrayList<>();

		list = getLongestSubSequenceWithList(arr, 0, Integer.MIN_VALUE, list);
		System.out.println(list);

		List<Integer> list2 = new ArrayList<>();
		list2 = getLongestSubSequenceWithList(arr2, 0, Integer.MIN_VALUE, list2);
		System.out.println(list2);
		
		
		List<Integer> list4 = getLongestSubSequenceDP(arr);
		System.out.println(list4);

		List<Integer> list5 = getLongestSubSequenceDP(arr2);
		System.out.println(list5);

	}
	private static List<Integer> getLongestSubSequenceDP(int[] a) {
		Map<Integer, List<Integer>> solution = new HashMap<>();
		List<Integer> max = new ArrayList<>();
		for(int i=0; i<a.length; i++){
			solution.put(i, new ArrayList<>());
		}
		List<Integer> list0 = solution.get(0);
		list0.add(a[0]);
		solution.put(0,list0);
		
		for(int i=1; i<a.length;i++){
			List<Integer> ithSolution = solution.get(i);
			for (int j=0; j<i; j++){
				List<Integer> jthSolution = solution.get(j);
				
				if(a[i] > a[j] && ithSolution.size() < jthSolution.size()+1){
					ithSolution = new ArrayList<>(jthSolution);
					ithSolution.add(a[i]);
				}
			}
			solution.put(i,ithSolution);
		}
		
		
		// Now let's find the max array
		
		for (int i=0; i<a.length; i++){
			if (max.size() < solution.get(i).size()){
				max = solution.get(i);
			}
		}
		
		
		return max;
	}

	/**
	 * Recursive algo to print longest count of subsequence
	 * 
	 * @param a
	 * @param current
	 * @param previousValue
	 * @return
	 */
	private static int getLongestSubSequence(int[] a, int current, int previousValue) {

		if (current == a.length) {
			return 0;
		}

		// get next bigger from a[current]
		int index = current;
		int incl = 0;
		for (int i = current; i < a.length; i++) {
			if (a[i] > previousValue) {
				index = i;
				incl = 1 + getLongestSubSequence(a, index, a[index]);
				break;
			}
		}

		return Math.max(incl, getLongestSubSequence(a, current + 1, previousValue));
	}

	/**
	 * Recursive algo to get longest array of subsequence
	 * 
	 * @param a
	 * @param current
	 * @param previousValue
	 * @param list
	 * @return
	 */
	private static List<Integer> getLongestSubSequenceWithList(int[] a, int current, int previousValue,
			List<Integer> list) {

		if (current == a.length) {
			return list;
		}

		// get next bigger from a[current]
		List<Integer> incl = new ArrayList<>();
		for (int i = current; i < a.length; i++) {
			if (a[i] > previousValue) {
				List<Integer> list2 = new ArrayList<>(list);
				list2.add(a[i]);
				incl = getLongestSubSequenceWithList(a, i, a[i], list2);
				break;
			}
		}
		List<Integer> excl = getLongestSubSequenceWithList(a, current + 1, previousValue, list);
		return incl.size() > excl.size() ? incl : excl;
	}

}
