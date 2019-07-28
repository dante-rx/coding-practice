package matrix;

/**
 * 
 * @author nagendra
 * 
 * <br>
Input: <br>
        1    2   3   4  <br>
        5    6   7   8 <br>
        9   10  11  12 <br>
        13  14  15  16 <br>
Output:  <br>
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10  <br>
 <br>

Input: <br>
        1   2   3   4  5   6 <br>
        7   8   9  10  11  12 <br>
        13  14  15 16  17  18 <br>
Output:  <br>
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11 <br>
 * <br>
 */
public class MatrixSpiral {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		
		int b[][] = { { 1, 2, 3, 4, 5, 6 }, 
                { 7, 8, 9, 10, 11, 12 }, 
                { 13, 14, 15, 16, 17, 18 } };

		printSpiralIterative(a);
		System.out.println();
		
		printSpiralRecursive(a, 0, a.length-1, 0, a[0].length-1);
		System.out.println();
		
		printSpiralIterative(b);
		System.out.println();
		printSpiralRecursive(b, 0, b.length-1, 0, b[0].length-1);

	}

	private static void printSpiralIterative(int[][] a) {
		int endRow = a.length - 1;
		int endCol = a[0].length - 1;
		int startRow = 0;
		int startCol = 0;
		while (startRow <= endRow || startCol <= endCol) {
			if (startRow <= endRow) {
				for (int j = startRow; j <= endCol; j++) {
					System.out.print(a[startRow][j] + "\t");
				}
				startRow++;
			}

			if (startCol <= endCol) {
				for (int i = startRow; i <= endRow; i++) {
					System.out.print(a[i][endCol] + "\t");
				}
				endCol--;
			}

			if (endRow >= startRow) {
				for (int j = endCol; j >= startCol; j--) {
					System.out.print(a[endRow][j] + "\t");
				}
				endRow--;
			}

			if (startCol <= endCol) {
				for (int i = endRow ; i >= startRow; i--) {
					System.out.print(a[i][startCol] + "\t");
				}
				startCol++;
			}

		}
	}
	
	private static void printSpiralRecursive(int[][] a, int startRow, int endRow, int startCol, int endCol) {

		
		if (startRow <= endRow) {
			for (int j = startRow; j <= endCol; j++) {
				System.out.print(a[startRow][j] + "\t");
			}
			startRow++;
		}

		if (startCol <= endCol) {
			for (int i = startRow; i <= endRow; i++) {
				System.out.print(a[i][endCol] + "\t");
			}
			endCol--;
		}

		if (endRow >= startRow) {
			for (int j = endCol; j >= startCol; j--) {
				System.out.print(a[endRow][j] + "\t");
			}
			endRow--;
		}

		if (startCol <= endCol) {
			for (int i = endRow; i >= startRow; i--) {
				System.out.print(a[i][startCol] + "\t");
			}
			startCol++;
		}
		
		if (startRow <= endRow || startCol <= endCol)
			printSpiralRecursive(a, startRow, endRow, startCol, endCol);

	}

}
