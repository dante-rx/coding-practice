package arrays;

/**
 * 
 * @author nagendra
 *
 */
public class LargestContagiousSum {

	public static void main(String[] args) {

		int a1[]= {3,-5,6,7,8,9,-2, 7};
		int a2[]= {4,-1,-2,7,8,9,-2, 1};
		System.out.println(findSum(a1));
		System.out.println(findSum(a2));
	}
	
	private static int findSum(int a[]) {
		int currentSum = a[0],
				maxSum =a[0];
		for(int i=1; i<a.length;i++) {
			currentSum = Math.max(a[i]+currentSum, a[i]);
			maxSum= Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

	private static int[] findArray(int a[]) {
		return null;
	}
}
