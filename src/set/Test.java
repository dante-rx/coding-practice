package set;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		System.out.println("hello");
		int array[] = {6,4,1,7,10};
		System.out.println(ballsRearranging(array));
//		System.out.println(ballsRearranging(new int[] {25, 23}));
//		System.out.println(ballsRearranging(new int[] {25, 24}));

	}

	static int ballsRearranging(int[] balls) {
		// Let's sort the balls if not sorted.
		Arrays.sort(balls);
		int length = balls.length;
		int i = 0, j=0;
		int max = 0;
		for (j = 0; j < length; j++) {
			int temp=balls[j];
			System.out.println("Current "+temp);
			while (balls[i] <= temp - length) {
				i++;
			}
			System.out.println("i "+i);
			max = Math.max(max, j - i + 1);
			System.out.println("Max: "+(length - max));
		}
		return length - max;
	}

}
