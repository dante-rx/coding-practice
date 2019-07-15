package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string A consisting of n characters and a string B consisting of m
 * characters, write a function that will return the number of times A must be
 * stated such that B is a substring of the repeated A. If B can never be a
 * substring, return -1.
 * 
 * Example: A = ‘abcd’ B = ‘cdabcdab’ The function should return 3 because after
 * stating A 3 times, getting ‘abcdabcdabcd’, B is now a substring of A.
 * 
 * You can assume that n and m are integers in the range [1, 1000].
 * 
 * https://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 * 
 * https://www.careercup.com/question?id=5661817599164416
 * 
 * @author nagendra
 *
 */
public class SubStringARepeatB {

	public static void main(String[] args) {
		String A = "abcd";
		String B = "cdabcdab";
		
		System.out.println(formSubString(A, B));
		System.out.println(formSubString("test", "testtes"));
		System.out.println(formSubString("test", "testtesk"));

	}

	private static int formSubString(String A, String B) {
		Set<Character> set1 = new HashSet<>();
		for (char x: A.toCharArray()){
			set1.add(x);
		}
		
		Set<Character> set2 = new HashSet<>();
		for (char x: B.toCharArray()){
			set2.add(x);
		}
		
		if (!set1.containsAll(set2)){
			return -1;
		}
		int counter = 1;
		
		// maxCounter would be more than 1 of B.length/A.length if possible
		int maxCounter = B.length()/A.length()+1;
		String newA  = A;
		while(counter<= maxCounter){
			newA = newA+A;
			counter++;
			if (newA.contains(B)){
				return counter;
			}
		}
		return -1;
	}

}
