/**
 * 
 */
package dynamicprogramming;

/**
 * @author nagendra
 *
 */
public class StairCaseProblems {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i=1; i<= 10; i++) {
			System.out.println(findSolutionForStairs(i));

		}

	}

	private static int findSolutionForStairs(int n) {
		if (n == 1) {
			return 1;
		}else if (n ==2) {
			return 2;
		}
		return findSolutionForStairs(n-1)+findSolutionForStairs(n-2);
		
	}

}
