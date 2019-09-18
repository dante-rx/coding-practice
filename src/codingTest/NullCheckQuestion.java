package codingTest;

import java.util.Arrays;

/**
 * 
 * @author nagendra
 *
 */
public class NullCheckQuestion {

	public static void main(String[] args) {
		Integer [][]a = { {4,2,4,2}, {4, null, 4, 2}, {2, null, 8, 2}, {16, null, 4, null}};
		//Integer [][]a = { {2,null,2,null}, {2,null,2,null}, {null, null, null, null}, {null, null, null, null}};
		int N = 4;
		for (int x =0; x<N; x++ ) {
			for (int y =0; y<N; y++ ) {
				if (x+1 < N && a[x+1][y] != null) {
					if (a[x+1][y] == a[x][y]) {
						 a[x][y] =  a[x][y]*2;
						 a[x+1][y] = null;
					}
					if (a[x][y] == null) {
						 a[x][y] =  a[x+1][y];
						 a[x+1][y] = null;
					}
					
				}
			}
		}
		for (Integer[]x : a) {
			System.out.println(Arrays.toString(x));
		}

	}

}
