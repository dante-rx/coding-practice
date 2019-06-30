package arrays;

import java.util.HashMap;

/**
 * https://www.techiedelight.com/find-maximum-length-sub-array-having-given-sum/
 * 
 * @author nagendra
 *
 */
public class MaxLengthSubArrayWithFixedSum {

	public static void main(String[] args) {
		int a[] = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
		int a2[] = { 6, -1, 2, 5, 6, 9, -13 };
		int sum = 8;
		solution(a, sum);
		solution(a2, sum);

		int arr[] = { 10, 5, 2, 7, 1, 9 };
		System.out.println(solution2(arr, 6, 15));

	}

	/**
	 * Use the current sum and use it to compare the solution. Also keep a count
	 * of currentLength, if currentLength > maxLength then use it.
	 * SOlution O(n2)
	 * 
	 * @param a
	 * @param requiredSum
	 */
	private static void solution(int[] a, int requiredSum) {
		int maxLength = -1;
		int currentLength = -1;
		int startIndex = -1;

		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				currentLength = j - i + 1;
				if (sum == requiredSum && currentLength > maxLength) {
					maxLength = currentLength;
					startIndex = i;

				}
			}
		}
		System.out.println("Max length of Sub Array " + maxLength + " and elements starts from " + (startIndex + 1));

	}

	/**
	 * Solution from geeksforgeeks in O(n)
	 * a
	 * a+b
	 * a+b+c
	 * a+b+c+d-k = a  available  then b+c+d=k and so use index of b
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 * @return
	 */
	static int solution2(int[] arr, int n, int k) {
		// HashMap to store (sum, index) tuples
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0, maxLen = 0;
		int startIndex =-1;

		// traverse the given array
		for (int i = 0; i < n; i++) {

			// accumulate sum
			sum += arr[i];

			// when subarray starts from index '0'
			if (sum == k){
				maxLen = i + 1;
				//startIndex = i;
				
			}
				

			// make an entry for 'sum' if it is
			// not present in 'map'
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

			// check if 'sum-k' is present in 'map'
			// or not
			// a+b+c+d-k = a  avialable  then b+c+d=k and so use index of b
			if (map.containsKey(sum - k)) {

				// update maxLength
				if (maxLen < (i - map.get(sum - k))){
					maxLen = i - map.get(sum - k);
					startIndex = map.get(sum - k);
				}
					
			}
		}
		System.out.println("Max length of Sub Array " + maxLen + " and elements starts from " + (startIndex + 1));
		return maxLen;
	}

}
