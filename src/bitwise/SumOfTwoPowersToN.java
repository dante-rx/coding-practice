/**
 * 
 */
package bitwise;

/**
 * @author nagendra
 *
 */
public class SumOfTwoPowersToN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 5;
		System.out.println(sumOfTwoPowersToN(N));

	}

	/**
	 * 2+4+8+16+32.... = GP = a(1-r topower n)/(1- r) <br>
	 * = 2(2 to power n) <br>
	 * = 2 to power n+1 -2<br>
	 * Basically 2 is left shift of 1 once, 4 is left soft of 1 twice etc.
	 */
	private static int sumOfTwoPowersToN(int n) {
		return (1 << (n + 1)) - 2;

	}

}
