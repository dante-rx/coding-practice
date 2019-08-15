package set;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SnakeAndLadder {

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
		// solution 4
		
		
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
		
		int y= shortestSnakesAndLadders(boardSize, snakes, ladders);
		System.out.println(y);

	}

	static int shortestSnakesAndLadders(int boardSize, int[][] snakes, int[][] ladders) {
		int source = 1;
		HashMap<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
        HashMap<Integer, Integer> dist = new HashMap<>();
        for (int i = 0; i <= boardSize+6; i++) {
        	graph.put(i, new LinkedList<Integer>());
            dist.put(i, Integer.MAX_VALUE);
        }
        for (int i = 0; i <= boardSize; i++) {
            for (int j = i + 1; j <= i + 6; j++) {
            	graph.get(i).add(j);
            }
        }
        HashMap<Integer, Integer> banned = new HashMap<Integer, Integer>();
        for (int i = 0; i < ladders.length; i++) {
        	graph.get( ladders[i][0] ).add(ladders[i][1]);
        }
        for (int i = 0; i < snakes.length; i++) {
        	 banned.put(snakes[i][0], snakes[i][1]);
        }
        
        

        dist.remove(source);
        dist.put(source, 1);

        PriorityQueue<Integer> vertexQueue = new PriorityQueue<Integer>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            int u = vertexQueue.poll();
            if (u > 100 || banned.containsKey(u)) {
                continue;
            }
            // Visit each edge exiting u
            for (int e : graph.get(u)) {
                System.out.println("For u="+u+" edge is:"+e);
                int v = e;
                int dtu = dist.get(u) + 1;
                if (dtu < dist.get(v)) {
                    vertexQueue.remove(v);
                    dist.remove(v);
                    dist.put(v, dtu);
                    vertexQueue.add(v);
                }
            }
        }
        return (dist.get(boardSize));
	}

}

