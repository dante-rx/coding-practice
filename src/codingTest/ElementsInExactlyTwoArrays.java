/**
 * 
 */
package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nagendra
 * 
 *         Given any number of arrays containing numbers, write a function which
 *         finds the numbers that appear in exactly two arrays.
 * 
 *         arrays = [ [6, 2, 2, 0, 4], [5, 0, 2, 6, 7, 1], [6, 7, 9, 9], ]
 * 
 *         find_in_two(arrays) should return [2, 0, 7]
 */
public class ElementsInExactlyTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Set<Integer>> list = new ArrayList<>();
		list.add(new LinkedHashSet<>(Arrays.asList(6, 2, 2, 0, 4)));
		list.add(new LinkedHashSet<>(Arrays.asList(5, 0, 2, 6, 7, 1)));
		list.add(new LinkedHashSet<>(Arrays.asList(6, 7, 9, 9)));

		List<Integer> myList = elementsInExactlyTwoArrays(list);
		System.out.println(myList);
	}

	private static List<Integer> elementsInExactlyTwoArrays(List<Set<Integer>> list) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (Set<Integer> set : list) {
			for (int x : set) {
				map.put(x, map.getOrDefault(x, 0) + 1);
			}
		}

		List<Integer> myList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 2) {
				myList.add(entry.getKey());
			}
		}
		return myList;
	}

}
