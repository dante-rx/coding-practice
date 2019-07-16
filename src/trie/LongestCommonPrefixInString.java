/**
 * 
 */
package trie;

import java.util.Map;

/**
 * @author nagendra
 * 
 *         To find the longest common prefix in array of Strings
 * 
 *
 */
public class LongestCommonPrefixInString {

	public static void main(String[] args) {
		

		String[] array = { "code", "coder", "coding", "codable", "codec", "codecs", "coded", "codeless", "codependence",
				"codependency", "codependent", "codependents", "codes", "codesign", "codesigned", "codeveloped",
				"codeveloper", "codex", "codify", "codiscovered", "codrive" };
		String[] array2 = { "ff", "f" };
		String[] array3 = { "ff", "3" };
		String[] array4 = { "ff55", "ff55" };

		System.out.println("Longest common prefix- " + findLCP(array));
		System.out.println("Longest common prefix- " + findLCP(array2));
		System.out.println("Longest common prefix- " + findLCP(array3));
		System.out.println("Longest common prefix- " + findLCP(array4));

	}
	
	public static String findLCP(String[] array) {
		Trie trie = new Trie();
		TrieNode head = trie.addFromDictionary(array);
		
		TrieNode current = head;
		StringBuffer sb = new StringBuffer();
		
		while (current != null && current.leafNode == false && current.childrens.size() ==1){
			for (Map.Entry<Character, TrieNode> entry: current.childrens.entrySet()) {
				sb =sb.append(entry.getKey());
				current= entry.getValue();
			}
		}
		
		return sb.toString();
	}

}
