/**
 * 
 */
package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nagendra
 *
 */
public class TotalCountSubArrayWithFixedSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
		int a2[] ={10, 2, -2, -20, 10};
		int sum = 8;
		//countSubArrayWithFixedSum(a, sum);
		countSubArrayWithFixedSum(a2, -10);

	}

	private static void countSubArrayWithFixedSum(int[] arr, int sum) {
		int count =0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		
		int csum =0;
		for(int x: arr) {
			csum+=x;
			if (map.containsKey(csum-sum)) {
				count+=map.get(csum-sum);
			}
			map.put(csum, map.getOrDefault(csum, 0)+1);
			
		}
		System.out.println(count);

		
		
	}

}
