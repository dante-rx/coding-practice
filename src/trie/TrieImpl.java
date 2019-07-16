package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A Sample implementation of Tries data structure
 * 
 * @author nagendra
 *
 */
class TrieNode {
	boolean leafNode;
	Map<Character, TrieNode> childrens = new HashMap<>();

}

class Trie {

	public Trie() {

	}

	/**
	 * Simply insert an string in trie
	 * 
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
		current.leafNode = true;
	}

	/**
	 * Adding an array of elements in trie
	 * 
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

}

public class TrieImpl {

	public static void main(String[] args) {
		Trie trie = new Trie();

	}

}
