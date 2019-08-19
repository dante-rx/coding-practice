/**
 * 
 */
package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author nagendra
 *
 */
public class PrintAllPossibleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str ="abc";
//		anagram(str, "");
//		anagramIterative(str);
//		
//		customAnagram("0ab", "");
		// This should print 0ab, 0aB, 0Ab, 0AB
		
		String inpString = "abcd";
		anagramIterative("abcd");
//        Set<String> combs = getAllCombs(inpString);
//
//        for(String comb : combs)
//        {
//            System.out.println(comb);
//        }

	}

	private static void anagram(String a, String b) {
		if (a.length() == 0) {
			System.out.println(b);
			return;
		}
		
		for (int i=0; i< a.length(); i++) {
			String x = a.substring(0,i ) + a.substring(i+1, a.length());
			anagram(x, b+a.charAt(i));
		}
		
	}
	
	
	private static void anagramIterative(String a) {
		List<String> allStr = new ArrayList<>();
		char [] allChars = a.toCharArray();
		String start = ""+allChars[0];
		allStr.add(start);
		
		for (int i =1; i< allChars.length;i++) {
			char currentChar = allChars[i];
			int allStrSize = allStr.size();
			
			for (int j=allStrSize-1 ; j>=0; j--) {
				String temp = allStr.remove(j);
				
				for (int k=0; k<= temp.length();k++) {
					allStr.add(temp.substring(0,k)+currentChar+temp.substring(k));
				}
			}
			
		}
		for (String s: allStr) {
			System.out.println(s);
		}
	}
	
	/**
	 * Custom Anagram
	 * @param a
	 * @param b
	 */
	private static void customAnagram(String a, String b) {
		if (a.length() == 0) {
			System.out.println(b);
			return;
		}
		
		//ignore digits
		int i =0;
		char c = a.charAt(i++);
		while (!Character.isLetter(c)) {
			b+=c;
			c = a.charAt(i++);
		}
		customAnagram(a.substring(i), b+ Character.toLowerCase(c));
		customAnagram(a.substring(i), b+ Character.toUpperCase(c));


		
	}

}
