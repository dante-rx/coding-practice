/**
 * 
 */
package string;

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
		anagram(str, "");
		
		customAnagram("0ab", "");
		// This should print 0ab, 0aB, 0Ab, 0AB

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
