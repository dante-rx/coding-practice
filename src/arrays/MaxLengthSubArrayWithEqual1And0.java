package arrays;

/**
 * 
 * @author nagendra
 *         https://www.techiedelight.com/find-maximum-length-sub-array-equal-number-0s-1s/
 * 
 *         replace o to -1 and then you have to found max subarray with 0 sum
 * 
 * 
 */
public class MaxLengthSubArrayWithEqual1And0 {

	public static void main(String[] args) {
		int a[] = { 0, 0, 1, 0, 1, 0, 0 };

		solution(a);

	}

	private static void solution(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] == 0){
				a[i] =-1;
			}
		}

		MaxLengthSubArrayWithFixedSum.solution2(a, a.length, 0);
	}

}
