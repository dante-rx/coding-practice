package arrays;

/**
 * 
 * Find largest word in dictionary by deleting some characters of given string
 * Giving a dictionary and a string ‘str’, find the longest string in dictionary
 * which can be formed by deleting some characters of the given ‘str’.
 * 
 * Examples:
 * 
 * Input : dict = {"ale", "apple", "monkey", "plea"}
 * 
 * str = "abpcplea" Output :apple
 * 
 * Input : dict = {"pintu", "geeksfor", "geeksgeeks", " forgeek"}
 * 
 * str = "geeksforgeeks" Output : geeksgeeks
 * 
 * https://www.geeksforgeeks.org/find-largest-word-dictionary-deleting-characters-given-string/
 * 
 * @author nagendra
 *
 */
public class LargestMatchingWordInDict {
	public static void main(String a[]) {
		String[] dict = { "ale", "apple", "monkey", "plea" };
		String str = "abpcplea";

		String[] dict2 = { "pintu", "geeksfor", "geeksgeeks", " forgeek" };
		String str2 = "geeksforgeeks";
		findLargestWords(dict, str);
		findLargestWords(dict2, str2);
	}

	/**
	 * There are two approaches to acheive this.<br>
	 * 1. Check that dict[i] is a subsequence of str. If yes, then this word is
	 * valid. (This is better approach)
	 * 
	 * 2. Start moving from str and delete chars which are not matching if
	 * dict[i] is acheived then dict[i] can be considered. Here I have used this approach only
	 * 
	 * @param dict
	 * @param str
	 */
	private static void findLargestWords(String[] dict, String str) {
		String largestStringFound = "";
		for (String s : dict) {
			if (largestStringFound.length() > s.length()) {
				continue; // no need to check
			}
			if (isSubSequence(s, str)) {
				if (s.length() > largestStringFound.length()) {
					largestStringFound = s;
				}
			}

		}

		if (largestStringFound.length() > 0) {
			System.out.println("Largest Matching String is: " + largestStringFound);
		} else {
			System.out.println("Not found");
		}

	}

	/**
	 * This is good solution but not so efficient
	 * @param s
	 * @param str
	 * @return
	 */
	private static boolean findMatch(String s, String str) {
		StringBuffer sb = new StringBuffer(str);
		boolean found = true;
		for (char c : s.toCharArray()) {
			int index = sb.indexOf(Character.toString(c));
			if (index >= 0) {
				// delete characters from 0th to index
				sb = sb.delete(0, index + 1);
			} else {
				found = false;
				break;
			}
		}
		return found;
	}
	
	// check if a is subsequence of b
	static boolean isSubSequence(String a, String b) {
		int m = 0;
		if (a.length() > b.length()) {
			return false;
		} else {
			for (int i = 0; i < b.length() && m<a.length(); i++) {
				if (b.charAt(i) == a.charAt(m)) {
					m++;
				}
			}
		}

		if (m == a.length()) {
			return true;
		}
		return false;

	}


}
