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
		System.out.println(isAnagram("aa", "bb"));
		System.out.println(isAnagram("aba", "aab"));
		System.out.println(isAnagram("aba", "ab"));
	}

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c: s.toCharArray()){
            map1.put( c, map1.get(c) == null ? 1: map1.get(c)+1 );
        }
        
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c: t.toCharArray()){
            map2.put(c, map2.get(c) ==null  ? 1: map2.get(c)+1);
        }
        
        return map1.equals(map2);
    }
}
