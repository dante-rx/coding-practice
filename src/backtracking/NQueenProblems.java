package backtracking;

/**
 * The Famous nQueens problem Solution - Use Backtracking
 * 
 * @author nagendra
 *
 */
public class NQueenProblems {

	private static final char CHAR_Q = 'Q';
	private static final char CHAR_ = '-';
	private static final int N = 4;

	public static void main(String[] args) {
		char[][] a = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = CHAR_;
			}
		}
		nQueens(a, 0);

	}

	private static boolean isSafe(char[][] a, int row, int col) {
		
		// column wise safe or not
		for (int i = 0; i < row; i++) {
			if (a[i][col] == CHAR_Q) {
				return false;
			}
		}
		
		//diagonal check-1 \
		/**
		 * 		\
		 *       \
		 *        \
		 */
		for(int i=row, j=col; i>= 0 && j>=0; i--, j--){
			if (a[i][j] == CHAR_Q) {
				return false;
			}
		}
		
		//diagonal check-2 /
		/**
		 *    /
		 *  /
		 */
		for(int i=row, j=col; i>= 0 && j<N; i--, j++){
			if (a[i][j] == CHAR_Q) {
				return false;
			}
		}

		return true;
	}

	private static void nQueens(char[][] a, int row) {

		if (N == row) {
			System.out.println("Here is a solution");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(a[i][j]);
				}
				System.out.println();
			}
			// If found a solution then print and exit.
			System.exit(0);
		}

		for (int i = 0; i < N; i++) {

			// Is queen safe to put in a[row][i] -> ith column
			if (isSafe(a, row, i)) {
				// Let's put the Queen in ith column
				a[row][i] = CHAR_Q;

				// Try for the next row
				nQueens(a, row + 1);

				// remove the queen from current position- Backtracking
				a[row][i] = CHAR_;
			}
		}

	}

}
