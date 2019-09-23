/**
 * 
 */
package set;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nagendra
 *
 */
public class ValidAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		assert isAnagram("anagram", "nagaram") : true;

		System.out.println(isAnagram("aa", "bb"));
		assert isAnagram("aa", "bb") : false;

		System.out.println(isAnagram("aba", "aab"));
		assert isAnagram("aba", "aab") : true;

		System.out.println(isAnagram("aba", "ab"));
		assert isAnagram("aba", "ab") : false;
	}

	public static boolean isAnagram(String s, String t) {
		Map<Character, Integer> map1 = new HashMap<>();
		for (char c : s.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}

		for (char c : t.toCharArray()) {
			if (!map1.containsKey(c)) {
				return false;
			}
			map1.put(c, map1.get(c) - 1);
			if (map1.get(c) == 0) {
				map1.remove(c);
			}
		}

		return map1.size() == 0;
	}
}
