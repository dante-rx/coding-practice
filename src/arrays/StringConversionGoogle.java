/**
 * 
 */
package arrays;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author nagendra
 *
 */
public class StringConversionGoogle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "Google Mail";
		System.out.println(convert(text));

	}

	private static String convert(String text) {
		Set<Character> set = initializeSet();
		System.out.println(set);

		TreeMap<Character, Integer> treeMap = createMap(text, set);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (set.contains(c)) {
				Entry<Character, Integer> firstEntry = treeMap.firstEntry();
				Character key = firstEntry.getKey();
				int count = firstEntry.getValue()-1;
				treeMap.put(key, count);
				if (count == 0) {
					treeMap.remove(key);
				}
				sb.append(key);

			} else {
				sb.append(c);
			}

		}

		return sb.toString();
	}

	private static Set<Character> initializeSet() {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < 26; i++) {
			set.add((char) ('a' + i));
		}
		return set;
	}

	private static TreeMap<Character, Integer> createMap(String text, Set<Character> set) {
		TreeMap<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (set.contains(c)) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}

		}

		return map;
	}

}
