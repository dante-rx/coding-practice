package arrays;

import java.util.Arrays;

public class FlightsInMovie {

	public static void main(String[] args) {
		int []a = {90, 85, 75, 60, 120, 150, 125};
		findMovie(a, 250);

	}

	private static void findMovie(int[] a, int d) {
		int actualD = d-30;
		Arrays.parallelSort(a);
		
		int j = a.length-1;
		int currentMax = Integer.MIN_VALUE;
		int first=a[0], second =a[1];
		for (int k=0 ; k< a.length-2; k++) {
			int i =k;
			while (i < j) {
				int currentSum = a[i]+a[j];
				if (currentSum > actualD) {
					j--;
				}
				
				else if (currentSum <= actualD) {
					if (currentSum > currentMax) {
						currentMax = currentSum;
						first = a[i];
						second = a[j];
					}
					i++;
				}
			   
			}
		}
		
		
		System.out.println(first+" ,"+second);
	}

}
