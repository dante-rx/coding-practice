package arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FindPairWithGivenSum {
	
	public static void main(String args[]) {
		int a[]= {3,5,6,7,8,9,67, 10};
		int sum =15;
		
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
