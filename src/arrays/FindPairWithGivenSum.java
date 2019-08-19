package arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * @author nagendra
 *
 */
public class FindPairWithGivenSum {
	
	public static void main(String args[]) {
		int a[]= {3,5,6,7,8,9,67, 10};
		int sum =15;
		
		findPairs(a, sum);
		findPairs2(a, sum);
		
	}

	private static void findPairs2(int[] a, int sum) {
		Arrays.sort(a);
		int left =0,right=a.length-1;
		int count =0;
		while (left<right) {
			if (a[left]+a[right] > sum) {
				right --;
			}else if( a[left]+a[right] < sum){
				left++;
			}else{
				System.out.println("first "+ a[left]+" second "+a[right]);
				count++;
				left++;
			}
		}
		System.out.println(count);
		
	}

	private static void findPairs(int[] a, int sum) {
		Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
		int count =0 ;
		for(int x:a) {
			if(set.contains(sum-x)) {
				System.out.println(x+", "+ (sum-x)+ " is pair");
				count++;
			}
		}
		System.out.println("Total number of pairing : "+count/2);
	}

}
