/**
 * 
 */
package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nagendra
 *
 */
public class ElementsInMinimumTwoArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(6, 2, 2, 0, 4));
		list.add(Arrays.asList(5, 0, 2, 6, 7, 1));
		list.add(Arrays.asList(6, 7, 9, 9));

		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			List<Integer> s = list.get(i);
			for (int x : s) {
				if (!map.containsKey(x)) {
					map.put(x, new HashSet<>());
				}
				map.get(x).add(i);
			}
		}
		System.out.println(map);
		List<Integer> rList = new ArrayList<>();

		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() >= 2) {
				rList.add(entry.getKey());
			}
		}
		System.out.println(rList);

	}

}
