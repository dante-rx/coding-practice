/**
 * 
 */
package matrix;

import java.util.Arrays;

/**
 * @author nagendra
 *
 */
public class MatrixRotate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix(a);
		System.out.println(a[3][1]);
		System.out.println("Rotating anticlockwise:");
		int[][] roatatedM = rotateMatrixAntiClockwise(a, 4);
		printMatrix(roatatedM);

	}

	/**
	 * This is the trick b[N-j-1][i]=a[i][j];
	 * 
	 * @param a
	 * @param N
	 * @return
	 */
	private static int[][] rotateMatrixAntiClockwise(int[][] a, int N) {
		int b[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				b[N - j - 1][i] = a[i][j];
			}

		}
		return b;
	}
	
	/**
	 * Another solution is using
	 * reversing each rows and then taking transpose of maatrix
	 * @param a
	 */

	private static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++)
			System.out.println(Arrays.toString(a[i]));
		System.out.println();

	}

}
