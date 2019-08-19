/**
 * 
 */
package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author nagendra
 *
 */
public class LengthOfLongestSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("hhhhhh"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("abcd"));

	}

	
	private static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		int j=0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				j = i;//Math.max(i,map.get(c));
				
			}
			map.put(c, i);
			max = Math.max(max, i-j+1);
			
			
		}
		
		return max;
	}


	/**
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring2(String s) {
		String max = "";
		String current="";
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				Iterator<Character> it = map.keySet().iterator();
				while (it.hasNext()) {
					char y = it.next();
					it.remove();
					if (y == c) {
						break;
					}
				}
				current=getStringFromMap(map);
			}
			current+=c;
			map.put(c, i);
			if (current.length() > max.length()) {
				max = current;
			}

		}
		return max.length();

	}
	
	private static String getStringFromMap(Map<Character, Integer> map ) {
		String str="";
		Set<Character> keys = map.keySet();
		for (char c:keys) {
			str+=c;
		}
		
		return str;
	}

}
