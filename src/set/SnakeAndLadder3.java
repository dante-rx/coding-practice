package set;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SnakeAndLadder3 {

	public static void main(String[] args) {
		
//		snakes: [[27,1], 
//		         [21,9], 
//		         [17,4], 
//		         [19,7]]
//		        ladders: [[11,26], 
//		         [3,22], 
//		         [5,8], 
//		         [20,29]]
		
//		snakes: [[17,2], 
//		         [34,7], 
//		         [28,2], 
//		         [31,19], 
//		         [45,29], 
//		         [48,35]]
//		        ladders: [[2,13], 
//		         [5,9], 
//		         [10,18], 
//		         [17,26], 
//		         [30,44], 
//		         [24,46], 
//		         [37,49]]
		
		
		int boardSize =49;
		int [][] snakes = new int[6][2];
		snakes[0][0]= 17;
		snakes[0][1]= 2;
		
		snakes[1][0]= 34;
		snakes[1][1]= 7;
		
		snakes[2][0]= 28;
		snakes[2][1]= 2;
		
		snakes[3][0]= 31;
		snakes[3][1]= 19;
		
		snakes[4][0]= 45;
		snakes[4][1]= 29;
		
		snakes[5][0]= 48;
		snakes[5][1]= 35;
		
		
		
		
		int [][] ladders = new int[7][2];
		
		ladders[0][0]= 2;
		ladders[0][1]= 13;
		
		ladders[1][0]= 5;
		ladders[1][1]= 9;
		
		ladders[2][0]= 10;
		ladders[2][1]= 18;
		
		ladders[3][0]= 17;
		ladders[3][1]= 26;
		
		ladders[4][0]= 30;
		ladders[4][1]= 44;
		
		ladders[5][0]= 24;
		ladders[5][1]= 26;
		
		ladders[6][0]= 37;
		ladders[6][1]= 49;
		
		        		 
//		int boardSize =30;
//		int [][] snakes = new int[4][2];
//		snakes[0][0]= 27;
//		snakes[0][1]= 1;
//		
//		snakes[1][0]= 21;
//		snakes[1][1]= 9;
//		
//		snakes[2][0]= 17;
//		snakes[2][1]= 4;
//		
//		snakes[3][0]= 19;
//		snakes[3][1]= 7;
//		
//		
//		
//		int [][] ladders = new int[4][2];
//		
//		ladders[0][0]= 11;
//		ladders[0][1]= 26;
//		
//		ladders[1][0]= 3;
//		ladders[1][1]= 22;
//		
//		ladders[2][0]= 5;
//		ladders[2][1]= 8;
//		
//		ladders[3][0]= 20;
//		ladders[3][1]= 29;
		
		
		
		int y= shortestSnakesAndLadders(boardSize, snakes, ladders);
		System.out.println(y);

	}

	static int shortestSnakesAndLadders(int boardSize, int[][] snakes, int[][] ladders) {
		int[] moves = new int[boardSize];

		for (int i = 0; i < ladders.length; i++) {
			moves[ladders[i][0]] = ladders[i][1];
		}

		for (int i = 0; i < snakes.length; i++) {
			moves[snakes[i][0]] = snakes[i][1];
		}

		boolean[] visited = new boolean[boardSize];
		Arrays.fill(visited, false);
			
		Queue<QueueEntry> q = new ArrayDeque<QueueEntry>();
		visited[0] = true;
		QueueEntry s = new QueueEntry();
		s.vertexNumber = 0;
		s.distance = 0;
		q.offer(s);
		QueueEntry temp = new QueueEntry();
		while (!q.isEmpty()) {
			temp = q.peek();
			int v = temp.vertexNumber;
			if (v == boardSize - 1)
				break;
			q.poll();
			for (int j = v + 1; j <= v + 6 && j < boardSize; j++) {
				if (!visited[j]) {
					QueueEntry a = new QueueEntry();
					a.distance = temp.distance + 1;
					visited[j] = true;
					if (moves[j] == -1)
						a.vertexNumber = j;
					else
						a.vertexNumber = moves[j];
					q.offer(a);
				}
			}

		}

		return temp.distance;
	}

}

class QueueEntry {
int vertexNumber;
int distance;
}