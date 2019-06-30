package backtracking;

/**
 * 
 * The Famous RAT in a maze problem.
 * Solution using backtracking
 * Approach
 * 1. Represent the entire maze as n*n array;
 * 2. Mark all the open path as 1 and closed path as 0 in the maze
 * { 
 * { 1, 1, 0, 0 }, 
 * { 0, 1, 0, 0 }, 
 * { 0, 1, 0, 0 }, 
 * { 0, 1, 1, 1 } 
 * }
 * 
 * ROW( up and down)
 * COL (left and right)
 * x as ROW and y as COL
 * 
 * 3. Fix the source and destination. Also make a visited n*n array to keep track of path traversal
 * 4. Find the shortest path using backtracking
 * 4 a) check the left, right, up and down as valid movement in order and check if path exists.
 *  b) if path exists then do the movement and proceed further and find the solution
 *  c) use backtracking to go back to original path if needed.
 *  
 * @author nagendra
 *
 */
public class ShortestPathInMaze {

	private static final Position start = new Position(0, 0);
	static int N = 4;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int[][] map = { { 1, 1, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 1, 1 } };
		boolean[][] visited = new boolean[N][N];
		Position dest = new Position(3, 2);
		int shortest =findShortestPathFromOrigin(map, visited, start, dest, 0, Integer.MAX_VALUE);
		System.out.println(shortest);

	}

	private static int findShortestPathFromOrigin(int[][] map, boolean[][] visited, Position source, Position dest,
			int distance, int minDistance) {
		if (source.equals(dest)) {
			minDistance = Math.min(distance, minDistance);
			System.out.println("Distance : " + minDistance);
			return minDistance;
		}
		
		visited[source.x][source.y] = true;
		
		//  check Order left, right, up, down
		
		// Check left
		if( source.isLeftValid(N, map, visited)){
			source.moveLeft();
			minDistance = findShortestPathFromOrigin(map, visited, source, dest, distance+1, minDistance);
		}
		
		// Check right
		if( source.isRightValid(N, map, visited)){
			source.moveRight();
			minDistance = findShortestPathFromOrigin(map, visited, source, dest, distance+1, minDistance);
		}
		
		// Check up
		if( source.isUpValid(N, map, visited)){
			source.moveUp();
			minDistance = findShortestPathFromOrigin(map, visited, source, dest, distance+1, minDistance);
		}
		
		// Check Down
		if( source.isDownValid(N, map, visited)){
			source.moveDown();
			minDistance =findShortestPathFromOrigin(map, visited, source, dest, distance+1, minDistance);
		}
		
		
		visited[source.x][source.y] = false;
		return minDistance;

	}

}

/**
 * 
 * @author nagendra
 *  Row and Column 
 *  left/ right, decrease/increase the column(y) value
 *  top/bottom, decrease/increase the row(Y) value
 */
class Position {
	int x;
	int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position() {
	}

	@Override
	public boolean equals(Object obj) {
		Position p = (Position)obj;
		return p.x == this.x && p.y == this.y ;
	}

	public boolean isValidPoint(int size) {
		return this.x < size && this.y < size;
	}

	public boolean isLeftValid(int size, int[][] map, boolean [][] visited) {
		return this.y - 1 >= 0 && map[x][y-1] == 1 && visited[x][y-1] == false;
	}

	public boolean isRightValid(int size, int[][] map,  boolean [][] visited) {
		return this.y + 1 < size && map[x][y+1] == 1  && visited[x][y+1] == false;
	}

	public boolean isUpValid(int size, int[][] map,  boolean [][] visited) {
		return this.x - 1 >= 0 && map[x-1][y] == 1 && visited[x-1][y] == false;
	}

	public boolean isDownValid(int size, int[][] map,  boolean [][] visited) {
		return this.x + 1 < size && map[x+1][y] == 1 &&  visited[x+1][y] == false;
	}
	
	public void moveLeft(){
		this.y = this.y-1;
	}
	
	public void moveRight(){
		this.y = this.y+1;
	}
	
	public void moveUp(){
		this.x = this.x-1;
	}
	
	public void moveDown(){
		this.x = this.x+1;
	}
}
