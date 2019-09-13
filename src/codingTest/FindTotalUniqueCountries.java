package codingTest;

import java.util.Stack;

/**
 * @author nagendra
 *
 */
/**
 * Find Total unique countries in two dimensional Array(Matrix) Countries having
 * same code the same number. You can check only up, down, left and right
 * 
 * @author nagendra
 *
 */
public class FindTotalUniqueCountries {

	/**
	 * @param args
	 */
	boolean[][] visited;
	int[][] matrix;
	int m;
	int n;

	public static void main(String[] args) {
		int a1[][] = new int[][] { { 5, 4, 4 }, { 4, 3, 4 }, { 3, 2, 4 }, { 2, 2, 2 }, { 3, 3, 4 }, { 1, 4, 4 },
				{ 4, 1, 1 } };
		int b1[][] = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 },
				{ 1, 1, 1 } };
		FindTotalUniqueCountries ftu = new FindTotalUniqueCountries();
		System.out.println(ftu.solution(a1)); // 11

		System.out.println(ftu.solution(b1));// 1
		System.out.println(ftu.solution(new int[][] { { 1, 2 } }));// 2
		
		System.out.println(ftu.iterativeSolution(a1)); // 11

		System.out.println(ftu.iterativeSolution(b1));// 1
		System.out.println(ftu.iterativeSolution(new int[][] { { 1, 2 } }));// 2

	}

	/**
	 * Recursive algo to solve the problem
	 * @param temp
	 * @return
	 */
	public int solution(int[][] temp) {
		matrix = temp;
		m = matrix.length;
		n = matrix[0].length;
		visited = new boolean[m][n];
		int solCount = 0;

		Stack<Location> stack = new Stack<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					visitNearByCountry(new Location(i, j, matrix[i][j]), stack);
					solCount++;
				}
			}
		}
		return solCount;
	}

	private void visitNearByCountry(Location location, Stack<Location> stack) {
		stack.add(location);
		while (!stack.isEmpty()) {
			Location loc = stack.pop();
			visited[loc.x][loc.y] = true;
			if (loc.isLeftSame(matrix, visited)) {
				visitNearByCountry(new Location(loc.x, loc.y - 1, matrix[loc.x][loc.y - 1]), stack);
			}

			if (loc.isRightSame(n, matrix, visited)) {
				visitNearByCountry(new Location(loc.x, loc.y + 1, matrix[loc.x][loc.y + 1]), stack);
			}
			if (loc.isUpSame(matrix, visited)) {
				visitNearByCountry(new Location(loc.x - 1, loc.y, matrix[loc.x - 1][loc.y]), stack);
			}

			if (loc.isDownSame(m, matrix, visited)) {
				visitNearByCountry(new Location(loc.x + 1, loc.y, matrix[loc.x + 1][loc.y]), stack);
			}

		}

	}

	/**
	 * Create another stack and solve it in iterative fashion
	 * @param a
	 * @return
	 */
	public int iterativeSolution(int[][] a) {
		int n = a.length;
		int m = a[0].length;
		int[][] visit = new int[n][m];
		int sol = 0;
		sol++;
		Stack<Integer> st = new Stack<Integer>();
		fillvisit(0, 0, a[0][0], visit, a, n, m, st);
		int x;
		int y;
		while (!st.empty()) {
			x = st.pop();
			y = st.pop();

			if (x > 0 && visit[x - 1][y] == 0) {
				fillvisit(x - 1, y, a[x - 1][y], visit, a, n, m, st);
				sol++;
			}
			if (y > 0 && visit[x][y - 1] == 0) {
				fillvisit(x, y - 1, a[x][y - 1], visit, a, n, m, st);
				sol++;
			}
			if (y < m - 1 && visit[x][y + 1] == 0) {
				fillvisit(x, y + 1, a[x][y + 1], visit, a, n, m, st);
				sol++;
			}
			if (x < n - 1 && visit[x + 1][y] == 0) {
				fillvisit(x + 1, y, a[x + 1][y], visit, a, n, m, st);

				sol++;
			}
		}

		return sol;

	}

	private void fillvisit(int x, int y, int k, int[][] visit, int[][] a, int n, int m, Stack<Integer> st2) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(y);
		st.push(x);
		visit[x][y] = 1;
		st2.push(y);
		st2.push(x);
		int px;
		int py;
		while (!st.isEmpty()) {
			px = st.pop();
			py = st.pop();
			if (px > 0 && visit[px - 1][py] == 0 && a[px - 1][py] == k) {
				visit[px - 1][py] = 1;
				st.push(py);
				st.push(px - 1);
				st2.push(py);
				st2.push(px - 1);

			}
			if (py > 0 && visit[px][py - 1] == 0 && a[px][py - 1] == k) {
				visit[px][py - 1] = 1;
				st.push(py - 1);
				st.push(px);
				st2.push(py - 1);
				st2.push(px);
			}
			if (py < m - 1 && visit[px][py + 1] == 0 && a[px][py + 1] == k) {
				visit[px][py + 1] = 1;
				st.push(py + 1);
				st.push(px);
				st2.push(py + 1);
				st2.push(px);
			}
			if (px < n - 1 && visit[px + 1][py] == 0 && a[px + 1][py] == k) {
				visit[px + 1][py] = 1;
				st.push(py);
				st.push(px + 1);
				st2.push(py);
				st2.push(px + 1);
			}
		}

	}
}

class Location {
	int x;
	int y;
	int value;

	public Location(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public boolean isLeftSame(int[][] map, boolean[][] visited) {
		return this.y - 1 >= 0 && map[x][y - 1] == value && visited[x][y - 1] == false;
	}

	public boolean isRightSame(int size, int[][] map, boolean[][] visited) {
		return this.y + 1 < size && map[x][y + 1] == value && visited[x][y + 1] == false;
	}

	public boolean isUpSame(int[][] map, boolean[][] visited) {
		return this.x - 1 >= 0 && map[x - 1][y] == value && visited[x - 1][y] == false;
	}

	public boolean isDownSame(int size, int[][] map, boolean[][] visited) {
		return this.x + 1 < size && map[x + 1][y] == value && visited[x + 1][y] == false;
	}

}