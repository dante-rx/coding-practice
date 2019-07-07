package arrays;

/**
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

	private static void findLargestWords(String[] dict, String str) {
		String largestStringFound = "";
		boolean found = true;
		for (String s : dict) {
			StringBuffer sb = new StringBuffer(str);

			for (char c : s.toCharArray()) {
				int index = sb.indexOf(Character.toString(c));
				if (index >= 0) {
					// delete characters from 0th to index
					sb = sb.delete(0, index+1);
				} else {
					found = false;
					break;
				}
			}
			if (found) {
				if (s.length() > largestStringFound.length()) {
					largestStringFound = s;
				}
			}

		}

		if (found) {
			System.out.println("Largest Matching String is: " + largestStringFound);
		} else {
			System.out.println("Not found");
		}

	}

}
