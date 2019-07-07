package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A Sample implementation of Tries data structure and example to find the
 * longest common prefix in String
 * 
 * @author nagendra
 *
 */
class TrieNode {
	boolean leadNode;
	Map<Character, TrieNode> childrens = new HashMap<>();

}

/**
 * 
 * @author nagendra
 *
 */
class Trie {

	public Trie() {

	}

	/**
	 * Simply insert an string in trie
	 * @param head
	 * @param str
	 */
	public void insert(TrieNode head, String str) {
		TrieNode current = head;
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if (current.childrens.get(x) == null) {
				current.childrens.put(x, new TrieNode());

			}
			current = current.childrens.get(x);
		}
		current.leadNode = true;
	}

	/**
	 * Removing  whole list of elements in trie
	 * @param array
	 * @return
	 */
	public TrieNode addFromDictionary(String array[]) {
		TrieNode head = new TrieNode();
		for (String x : array) {
			insert(head, x);
		}
		return head;
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	public String findLCP(String[] array) {
		TrieNode head = this.addFromDictionary(array);
		
		TrieNode current = head;
		StringBuffer sb = new StringBuffer();
		
		while (current != null && current.leadNode == false && current.childrens.size() ==1){
			Set<Character> keySet = current.childrens.keySet();
			for (Character c:keySet){
				sb.append(c);
				current = current.childrens.get(c);
			}
			/**
			 * Can be implemented also via iterator
			 */
//			Iterator<Entry<Character, TrieNode>> iterator = current.childrens.entrySet().iterator();
//			
//			if(iterator.hasNext()){
//				Entry<Character, TrieNode> entry = iterator.next();
//				sb.append(entry.getKey());
//				current = entry.getValue();
//				
//			}
		}
		
		return sb.toString();
	}
}

/**
 * Main class
 * 
 * @author nagendra
 *
 */
public class TrieImpl {

	public static void main(String[] args) {
		Trie trie = new Trie();

		String[] array = { "code", "coder", "coding", "codable", "codec", "codecs", "coded", "codeless", "codependence",
				"codependency", "codependent", "codependents", "codes", "codesign", "codesigned", "codeveloped",
				"codeveloper", "codex", "codify", "codiscovered", "codrive" };
		
		String[] array2 = { "ff", "f" };
		
		String[] array3 = { "ff", "3" };

		System.out.println("Longest common prefix- " + trie.findLCP(array));
		System.out.println("Longest common prefix- " + trie.findLCP(array2));
		System.out.println("Longest common prefix- " + trie.findLCP(array3));

	}

}
