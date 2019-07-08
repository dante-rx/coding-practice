package greedy;

import java.util.Arrays;

/**
 * 
 * There are N Mice and N holes are placed in a straight line. Each hole can
 * accomodate only 1 mouse. A mouse can stay at his position, move one step
 * right from x to x + 1, or move one step left from x to x − 1. Any of these
 * moves consumes 1 minute. Assign mice to holes so that the time when the last
 * mouse gets inside a hole is minimized.
 * 
 * Example:
 * 
 * positions of mice are: 4 -4 2 positions of holes are: 4 0 5
 * 
 * Assign mouse at position x=4 to hole at position x=4 : Time taken is 0
 * minutes Assign mouse at position x=-4 to hole at position x=0 : Time taken is
 * 4 minutes Assign mouse at position x=2 to hole at position x=5 : Time taken
 * is 3 minutes After 4 minutes all of the mice are in the holes.
 * 
 * Since, there is no combination possible where the last mouse's time is less
 * than 4, answer = 4.
 * 
 * @author nagendra
 *
 */
public class MiceAndHomeProblem {

	public static void main(String[] args) {
		int []miceLocation = {-1,5,6,-8,9,6,7};
		int [] holes= {1,2,3,4,5,6,7};
		
		
		int []miceLocation2 = {-10, -79, -79, 67, 93, -85, -28, -94};
		int [] holes2= {-2, 9, 69, 25, -31, 23, 50, 78 };
		findMinimumTime(miceLocation, holes);
		findMinimumTime(miceLocation2, holes2);
		
		
		

	}

	private static void findMinimumTime(int[] miceLocation, int[] holes) {
		Arrays.sort(miceLocation);
		Arrays.sort(holes);
		int maxTime = 0;
		for(int i=0; i< miceLocation.length; i++) {
			int time = Math.abs(miceLocation[i]-holes[i]);
			if(time > maxTime) {
				maxTime = time;
			}
		}
		System.out.println("Max time taken is "+maxTime);
		
		
	}

}
