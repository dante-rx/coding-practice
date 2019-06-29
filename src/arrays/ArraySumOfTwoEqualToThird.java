package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * @author nagendra
 * complexity O(n*n)
 *
 */

/*
 * 1. Find all triplets in array with a+b=c (All unique elements)
 * 2.Find all triplets with zero sum
 */
public class ArraySumOfTwoEqualToThird {

	public static void main(String[] args) {
		int a[] = {1,2,3,5,6,8};
		// 1+2=3 1+5=6 2+3=5 3+5=8 2+6=8
		solution(a);
		solution2(a);
		System.out.println(solution4(a, 6));
		solution3(a);

	}

	/* Use Hashing
	 * complexity O(n*n)
	 * but extra space a[n] for hashing
	 */
	private static void solution(int[] a) {
		Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
		
		int sum ;
		int count = 0;
		for (int i =0; i< a.length;i++) {
			for (int j =i+1; j<a.length;j++) {
				sum = a[i]+a[j];
				if(set.contains(sum)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	/*
	 * Unique solution using hashmap
	 */
	private static void solution2(int[] a) {
		
		
		int sum ;
		int count = 0;
		int max = Integer.MIN_VALUE;
		for (int x:a) {
			max = Math.max(x, max);
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i< max;i++) {
			map.put(i+1, 0);
		}
		
		for(int x:a) {
			map.put(x, 1);
		}
		
		for (int i=1; i<max;i++) {
			for (int j=i+1; i+j<=max;j++) {
				count+=map.get(i)* map.get(j)* map.get(i+j);
			}
		}
		System.out.println(count);
	}
	
	/* Optimal Solution
	 * complexity O(n*n)
	 * but one extra space as one for
	 */
	private static void solution3(int[] a) {
		Arrays.sort(a);
		
		
		int count = 0;
		int low= 0, high =0;
		for (int i =a.length-1 ; i> 0;i--) {
			low =0;
			high = i-1;
			int x = a[i];

			

			while (low < high) {
				int y = a[low];
				int  z = a[high];
				
				if (z+y ==x ){
					count++;
					low++;
					high--;
					System.out.println(x+" ," +y +" ,"+z);
					
				} else if (z+y > x) {
					high--;
				} else {
					low++;
				}
			}
			
		}
		System.out.println(count);
	}
	
	static int solution4(int[] arr, int n) 
    { 
        // compute the max value in the array 
        // and create frequency array of size 
        // max_val + 1. 
        // We can also use HashMap to store 
        // frequencies. We have used an array 
        // to keep remaining code simple. 
        int max_val = 0; 
        for (int i = 0; i < n; i++) 
            max_val = Math.max(max_val, arr[i]); 
        int[] freq = new int[max_val + 1]; 
        for (int i = 0; i < n; i++) 
            freq[arr[i]]++; 
  
        int ans = 0; // stores the number of ways 
  
        // Case 1: 0, 0, 0 
        ans += freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6; 
  
        // Case 2: 0, x, x 
        for (int i = 1; i <= max_val; i++) 
            ans += freq[0] * freq[i] * (freq[i] - 1) / 2; 
  
        // Case 3: x, x, 2*x 
        for (int i = 1; 2 * i <= max_val; i++) 
            ans += freq[i] * (freq[i] - 1) / 2 * freq[2 * i]; 
  
        // Case 4: x, y, x + y 
        // iterate through all pairs (x, y) 
        for (int i = 1; i <= max_val; i++) { 
            for (int j = i + 1; i + j <= max_val; j++) 
                ans += freq[i] * freq[j] * freq[i + j]; 
        } 
  
        return ans; 
    } 

}
