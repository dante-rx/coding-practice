package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Cutting a Rod | DP-13 Given a rod of length n inches and an array of prices
 * that contains prices of all pieces of size smaller than n. Determine the
 * maximum value obtainable by cutting up the rod and selling the pieces. For
 * example, if length of the rod is 8 and the values of different pieces are
 * given as following, then the maximum obtainable value is 22 (by cutting in
 * two pieces of lengths 2 and 6)
 * <p>
 * <br>
 * length | 1 2 3 4 5 6 7 8 <br>
 * --------------------------------------------<br>
 * price | 1 5 8 9 10 17 17 20<br>
 * And if the prices are as following, then the maximum obtainable value is 24
 * (by cutting in eight pieces of length 1)<br>
 * <br>
 * length | 1 2 3 4 5 6 7 8 <br>
 * --------------------------------------------<br>
 * price | 3 5 8 9 10 17 17 20<br>
 * </p>
 * 
 * @author nagendra
 *
 */
public class RodCuttingProblem {

	public static void main(String[] args) {
		int rodLength[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int price[]= { 1, 5, 8, 9, 10, 17, 17, 20};
		int rodSize= 2;
		int profits = maximizeProfit(rodLength, price, rodSize);
		System.out.println(profits);

	}

	private static int maximizeProfit(int[] rodLength, int[] price, int rodSize) {
		Map<Integer, Integer> profits = new HashMap<>();
		for (int i =0; i<= rodSize; i++) {
			profits.put(i, 0);
		}
		// Let's start building solution till n now.
		
		profits.put(1, price[0]); 
		for (int i =2; i<= rodSize ; i++) {
			int maxProfit =0;
			for (int j =1; j<=rodLength.length; j++) {
				int currentProfit =0;
				if( (i-j) > 0) {
					currentProfit= profits.get(rodLength[j-1])+ price[i-j-1]; 
					if (currentProfit > maxProfit) {
						maxProfit = currentProfit;
					}
				}
			}
			profits.put(i, maxProfit);
			
		}
		
		return profits.get(rodSize);
	}

}
