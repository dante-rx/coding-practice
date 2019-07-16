package arrays;

/**
 * Meta Strings (Check if two strings can become same after a swap in one
 * character)
 * 
 * @author nagendra
 *
 */
public class MetaStringCheck {

	public static void main(String[] args) {
		String s1 = "tesla";
		String s2 = "tlsea";

		System.out.println(checkMetaString(s1, s2));
		System.out.println(checkMetaString("rsting", "string"));
		System.out.println(checkMetaString2(s1, s2));
		System.out.println(checkMetaString2("rsting", "string"));
		System.out.println(checkMetaString3(s1, s2));
		System.out.println(checkMetaString3("rsting", "string"));

	}

	/**
	 * Start with 4 pointers, 2 for s1 and 2 for s2.
	 * 
	 * Let's find the unmatching character in s1 and s2
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean checkMetaString(String s1, String s2) {
		int start1 = 0, start2 = 0, end1 = s1.length() - 1, end2 = s2.length() - 1;
		if (s1.length() != s2.length()) {
			return false;
		}
		while (start1 <= end1 && start2 <= end2) {
			if (s1.charAt(start1) == s2.charAt(start2)) {
				start1++;
				start2++;
				continue;
			}
			break;

		}

		while (end1 >= start1 && end2 >= start2) {
			if (s1.charAt(end1) == s2.charAt(end2)) {
				end1--;
				end2--;
				continue;
			}
			break;
		}

		if (start1 == end1 && start2 == end2) {
			return true;
		}

		// Now just check one char from end2-> to start1 and start2-> to end1 checking
		// again

		if (s1.charAt(start1) == s2.charAt(end2) && s1.charAt(end1) == s2.charAt(start2)) {
			start1++;
			start2++;
			end1--;
			end2--;

			while (start1 <= end1 && start2 <= end2) {
				if (s1.charAt(start1) == s2.charAt(start2)) {
					start1++;
					start2++;
					continue;
				}
				return false;

			}
		} else {
			return false;
		}

		return true;
	}

	/**
	 * Easy approach, Just count number of unmatched chars.
	 * 
	 * If it's more than 2 then return false; else check the char chars from both
	 * string if it's same. then return true
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean checkMetaString2(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}

		int counter = 0;
		char s1a1 = '0', s1a2 = '0', s2a1 = '0', s2a2 = '0';
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				counter++;
				if (counter > 2) {
					return false;
				}

				// save the char

				if (counter == 1) {
					s1a1 = s1.charAt(i);
					s2a1 = s2.charAt(i);
				}

				if (counter == 2) {
					s1a2 = s1.charAt(i);
					s2a2 = s2.charAt(i);
				}
			}

		}

		if (counter == 0) {
			return true;
		}
		return counter == 2 && s1a1 == s2a2 && s1a2 == s2a1;
	}

	/**
	 * Easy approach, Just count number of unmatched chars.
	 * 
	 * If it's more than 2 then return false; else check the char chars from both
	 * string if it's same. then return true Make sure to save the unmatched index.
	 * This can be easily done by two temp variables as first and second. Second has
	 * the 2nd unmatched string and so first has 1st unmatched string
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean checkMetaString3(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}

		int counter = 0;
		int first = -1, second = -1;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				counter++;
				if (counter > 2) {
					return false;
				}
				// save the char index
				first = second;
				second = i;
			}

		}

		if (counter == 0) {
			return true;
		}
		return counter == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
	}

}
