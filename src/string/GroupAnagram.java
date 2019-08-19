/**
 * 
 */
package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nagendra
 * 
 * Reference :- https://leetcode.com/problems/group-anagrams/
 * 
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 *
 */
public class GroupAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String array[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> groupAnagrams = groupAnagrams(array);
		for(List<String> x: groupAnagrams) {
			System.out.println(x);
		}

	}

	
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> listOfList = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s: strs) {
			
		}
		
		
		
		return listOfList;
        
    }
}
