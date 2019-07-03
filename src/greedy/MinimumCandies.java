package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap is used to solve this problem in O(n)
 * https://www.hackerrank.com/challenges/candies/problem
 * @author nagendra
 *
 */
public class MinimumCandies {

	public static void main(String[] args) {
		int a[] = { 9, 10, 9, 8, 7, 8, 9 };
		int b[] = {5,5,4};
		int c[] = {5,5,5,4,3};
		int d [] = {5,4,5,3,5,5};
		int e [] = {9,8,7,6,5,4,3,2,1};
		getMinimumCandies(a);
		getMinimumCandies(b);
		getMinimumCandies(c);
		getMinimumCandies(d);
		getMinimumCandies(e);
		

	}

	private static void getMinimumCandies(int[] a) {
		int values[] = new int[a.length];
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				List<Integer> list = map.get(a[i]);
				list.add(i);
				map.put(a[i], list);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(a[i], list);
			}
		}
		
		Set<Integer> keySet = map.keySet();
		for(int x : keySet) {
			List<Integer> list = map.get(x);
			for(int index:list) {
				process(a, values, index);
			}
		}
		System.out.println("Input: "+Arrays.toString(a));
		System.out.println("Candies: "+Arrays.toString(values));
		System.out.println();
	}

	private static void process(int[] a, int[] values, int index) {
		int current = a[index];
		int currentV = values[index];
		
		int previous = 0;// index==0 ? 0 : a[index-1];
		int previousV = 0;
		if (index >0) {
			previous =  a[index-1];
			previousV = values[index-1];
		}
		int next = 0; // for last element
		int nextV =0; // // for last element
		if (index <a.length-1) { 
			next = a[index+1];
			nextV = values[index+1];
		}
		
		
		if( current == next && current == previous) {
			values[index] = Math.max(1,Math.min(currentV, Math.max(previousV, nextV)));
		}else {
			values[index] = Math.max(currentV, Math.max(previousV, nextV))+1;
		}
		//handle special last and first case!
		if(a[a.length-1] == a[a.length-2]) {
			values[a.length-1] = 1;
		}
		
		if(a[0] == a[1]) {
			values[0] = 1;
		}
		

	}
	
	

}
