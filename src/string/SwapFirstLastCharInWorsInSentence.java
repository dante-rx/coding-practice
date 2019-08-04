/**
 * 
 */
package string;

/**
 * @author nagendra
 * swap first and last characters of words in a sentence
 */
public class SwapFirstLastCharInWorsInSentence {

	private int test(int x, int y) {
		return x+y;
	}
	
	private double test(double x, int y) {
		return x+y;
	}
	
	
	private double test(double x, double y) {
		return x+y;
	}
	
	private double test(double x, double y, double z) {
		return x+y+z;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s= "geeks for geeks";
		SwapFirstLastCharInWorsInSentences(s);
		SwapFirstLastCharInWorsInSentences2(s);
	}

	private static void SwapFirstLastCharInWorsInSentences2(String s) {
		char[] array = s.toCharArray();
		int start = 0;
		for (int i=0; i <array.length;i++) {
			start = i ;
			
			while( i< array.length && array[i] != ' ') {
				i++;
			}
			//swap start and i
			char temp = array[i-1];
			array[i-1] = array[start];
			array[start] = temp;
		}
		
		System.out.println(new String(array));
		
	}

	private static void SwapFirstLastCharInWorsInSentences(String s) {
		
		
		String [] array = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String x: array) {
			StringBuilder sb2 = new StringBuilder(x);
			char c1= sb2.charAt(0);
			char c2 = sb2.charAt(sb2.length()-1);
			sb2.deleteCharAt(0);
			sb2.deleteCharAt(sb2.length()-1);
			
			sb2.append(c1);
			sb2.insert(0, c2);
			
			sb.append(sb2);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

}
