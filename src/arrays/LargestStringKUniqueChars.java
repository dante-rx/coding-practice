package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string you need to print longest possible substring that has exactly
 * M unique characters. If there are more than one substring of longest possible
 * length, then print any one of them. Examples:
 * 
 * "aabbcc", k = 1 Max substring can be any one from {"aa" , "bb" , "cc"}.
 * 
 * "aabbcc", k = 2 Max substring can be any one from {"aabb" , "bbcc"}.
 * 
 * "aabbcc", k = 3 There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" } Max is "aabbcc" with length 6.
 * 
 * "aaabbb", k = 3 There are only two unique characters, thus show error
 * message.
 * 
 * @author nagendra
 *
 */
public class LargestStringKUniqueChars {

	public static void main(String[] args) {
		String str = "aabbcc";
		int k = 2;

		findLargestStringKUniqueChars("aabbcc", 1);
		findLargestStringKUniqueChars("aabbcc", 2);
		findLargestStringKUniqueChars("aabbcc", 3);
		findLargestStringKUniqueChars("aabbcc", 4);
		findLargestStringKUniqueChars("aabacbebebe", 3);

	}

	private static void findLargestStringKUniqueChars(String str, int k) {
		List<Position> list = new ArrayList<>();
		char currentChar = str.charAt(0);
		Position p = new Position(currentChar, 0, 0);
		list.add(p);

		for (int i = 1; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (currentChar == temp) {
				// update currentChar index
				p.end = i;
			} else {
				// a new char and so create a entry.
				p = new Position(temp, i, i);
				currentChar = temp;
				list.add(p);
			}
		}

		// now start finding largestString
		int currentStartIndex = 0;
		String currentString = "";
		String maxString = "";
		Set<Character> currentSet = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			Position position = list.get(i);
			if (currentSet.size() == k) {
				if (maxString.length() < currentString.length()) {
					maxString = currentString;
				}

				if (!currentSet.contains(position.c)) {
					// Now lets' remove the first substring from currentString
					// and move forward
					while (currentSet.size() == k) {
						// remove the starting elements from the currentString accordingly
						currentString = currentString.substring(
								list.get(currentStartIndex).end - list.get(currentStartIndex).start + 1,
								currentString.length());

						// Now remove from set so set size reduces. Start from
						// 0th and so on
						// make sure item should not be there in currentString
						// else increase the currentStartIndex
						if (currentString.indexOf(list.get(currentStartIndex).c) < 0) {
							currentSet.remove(list.get(currentStartIndex).c);
						}
						currentStartIndex++;
					}
				}
			}
			currentSet.add(position.c);
			currentString += getString(position);
		}

		// final check
		if (maxString.length() < currentString.length() && currentSet.size() == k) {
			maxString = currentString;
		}

		if (maxString.length() > 0) {
			System.out.println(maxString);
		} else {
			System.out.println("Not found");
		}

	}

	private static String getString(Position p) {
		String returnS = "";
		for (int i = p.start; i <= p.end; i++) {
			returnS = returnS + p.c;
		}
		return returnS;

	}

}

class Position {
	int start;
	int end;
	char c;

	Position() {

	};

	Position(char c, int start, int end) {
		this.c = c;
		this.start = start;
		this.end = end;
	}

}