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
		assert isAnagram("anagram", "nagaram"): true;
		
		System.out.println(isAnagram("aa", "bb"));
		assert isAnagram("aa", "bb") : false;
		
		System.out.println(isAnagram("aba", "aab"));
		assert isAnagram("aba", "aab"): true;
		
		System.out.println(isAnagram("aba", "ab"));
		assert isAnagram("aba", "ab"): true;
	}

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c: s.toCharArray()){
            map1.put( c, map1.getOrDefault(c, 0)+1 );
        }
        
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c: t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }
        
        return map1.equals(map2);
    }
}
