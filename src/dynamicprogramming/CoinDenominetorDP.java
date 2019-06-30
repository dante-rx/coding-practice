package dynamicprogramming;

/**
 * The coin denominator problem
 * 
 * constrcut a bigger number with minimum number of coin denomination
 * 
 * @author nagendra
 *
 */
public class CoinDenominetorDP {

	public static void main(String[] args) {
		int denominator[] = { 1, 9, 10 };

		System.out.println(count(denominator, 12));
		System.out.println(count(denominator, 81));
		System.out.println(count(denominator, 100));
		System.out.println(count(denominator, 51));
		System.out.println(count(denominator, 102));
		System.out.println(count(denominator, 21));

	}
	
	/**
	 * Recursive approach to get a solution
	 * @param n
	 * @return
	 */
	public static int countRecursive(int n){
		if(n <=8){
			return n;
		} else if (n ==9){
			return 1;
		} else if (n == 10){
			return 1;
		}
		
		return 1+ min(countRecursive(n-1), countRecursive(n-9), countRecursive(n-10));
	}
	

	/**
	 * Optimal dynamic approach to solving the coin denominator problem
	 * @param denominator
	 * @param value
	 * @return
	 */
	public static int count(int denominator[], int value) {
		int length = denominator.length;
		int solution[] = new int[value + 1];
		solution[0] = 0;
		for (int i = 1; i < value + 1; i++) {
			solution[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < value + 1; i++) {

			for (int j = 0; j < length; j++) {

				// put one coin of each type and check
				if (i - denominator[j] >= 0) {
					int res = solution[i - denominator[j]];

					// Now check if this solution is better than previous, if
					// yes, replace it.

					// if res= Integer.MAX_VALUE then res+1 will fail and so
					// let's put a check
					if (res < Integer.MAX_VALUE && res + 1 < solution[i]) {
						solution[i] = res + 1;
					}
				}

			}

		}

		return solution[value];

	}

	public static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
