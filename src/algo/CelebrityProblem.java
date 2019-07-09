package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * The famous Celebrity problem
 * 
 * You are in a party of N people, where only one person is known to everyone.
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone
 * in the party. Your task is to find the stranger (celebrity) in party. You
 * will be given a square matrix M[][] where if an element of row i and column j
 * is set to 1 it means ith person knows jth person. You need to complete the
 * function getId() which finds the id of the celebrity if present else return
 * -1. The function getId() takes two arguments, the square matrix M and its
 * size N.
 * 
 * Note: Expected time complexity is O(N) with constant extra space.
 * 
 * Input: The first line of input contains an element T denoting the number of
 * test cases. Then T test cases follow. Each test case consist of 2 lines. The
 * first line of each test case contains a number denoting the size of the
 * matrix M. Then in the next line are space separated values of the matrix M.
 * 
 * Output: For each test case output will be the id of the celebrity if present
 * (0 based index). Else -1 will be printed.
 * 
 * User Task: The task is to complete the function getId() which returns the Id
 * of celebrity if present, else -1.
 * 
 * Constraints: 1 <= T <= 50 2 <= N <= 501 0 <= M[][] <= 1
 * 
 * Example: Input (To be used only for expected output) : 2 3 0 1 0 0 0 0 0 1 0
 * 2 0 1 1 0
 * 
 * Output : 1 -1
 * 
 * Explanation : For the above test case the matrix will look like 0 1 0 0 0 0 0
 * 1 0 Here, the celebrity is the person with index 1 ie id 1
 * 
 * @author nagendra
 *
 */
public class CelebrityProblem {

	public static void main(String[] args) {
		int N = 3;
		int M[][] = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		List<Integer> rows = new ArrayList<>();
		for(int i =0 ; i< N; i++) {
			rows.add(i);
		}
		
		celebrityProblemIndex(M, rows);

	}

	private static void celebrityProblemIndex(int[][] M, List<Integer> rows) {
		
		if (rows.size() == 0) {
			System.out.println("No celebrity found");
			return;
		}
		if (rows.size() == 1) {
			System.out.println("Celebrity found:  "+rows.get(0));
			return;
		}
		
		List<Integer> newRows = new ArrayList<>();
		for (int i= 0, j= rows.size()-1; i<= j; i++, j--) {
			if( M[i][j] == 1) {
				//then i is not celebrity , j might be celebrity 
				// ignore i from solution workspace 
				newRows.add(j);
				
			} else {
				// j is not celebrity , but i might be.
				// remove j from solution workspace
				newRows.add(i);
			}
		}
		
		celebrityProblemIndex(M, newRows);
		
	}

}
