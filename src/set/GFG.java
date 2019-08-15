package set;


import java.util.LinkedList;
import java.util.Queue;

public class GFG {
	
	static class qentry  
    { 
        int v;// Vertex number 
        int dist;// Distance of this vertex from source 
    } 
  
	
	static int getMinDiceThrows(int move[], int n)  
    { 
        int visited[] = new int[n]; 
        Queue<qentry> q = new LinkedList<>(); 
        qentry qe = new qentry(); 
        qe.v = 0; 
        qe.dist = 0; 
  
        // Mark the node 0 as visited and enqueue it. 
        visited[0] = 1; 
        q.add(qe); 
  
        // Do a BFS starting from vertex at index 0 
        while (!q.isEmpty())  
        { 
            qe = q.remove(); 
            int v = qe.v; 
  
            // If front vertex is the destination  
            // vertex, we are done 
            if (v == n - 1) 
                break; 
  
            // Otherwise dequeue the front vertex and  
            // enqueue its adjacent vertices (or cell  
            // numbers reachable through a dice throw) 
            for (int j = v + 1; j <= (v + 6) && j < n; ++j)  
            { 
                // If this cell is already visited, then ignore 
                if (visited[j] == 0) 
                { 
                    // Otherwise calculate its distance and  
                    // mark it as visited 
                    qentry a = new qentry(); 
                    a.dist = (qe.dist + 1); 
                    visited[j] = 1; 
  
                    // Check if there a snake or ladder at 'j' 
                    // then tail of snake or top of ladder 
                    // become the adjacent of 'i' 
                    if (move[j] != -1) 
                        a.v = move[j]; 
                    else
                        a.v = j; 
                    q.add(a); 
                } 
            } 
        } 
  
        // We reach here when 'qe' has last vertex 
        // return the distance of vertex in 'qe' 
        return qe.dist; 
    } 
    
	public static void main (String[] args) {
		int[] moves = new int[49];

        for(int i = 0; i< 49; i++) {
            moves[i] = -1;
        }
        
        //Ladders
        moves[2] = 13;
        moves[5] = 9;
        moves[10] = 18;
        moves[17] = 26;
        moves[30] = 44;
        moves[24] = 46;
        moves[37] = 49;

        // Snakes
        moves[17] = 2;
        moves[34] = 7;
        moves[28] = 2;
        moves[31] = 19;
        
        moves[45] = 29;
        moves[48] = 35;
        
//		snakes: [[17,2], 
//        [34,7], 
//        [28,2], 
//        [31,19], 
//        [45,29], 
//        [48,35]]
//       ladders: [[2,13], 
//        [5,9], 
//        [10,18], 
//        [17,26], 
//        [30,44], 
//        [24,46], 
//        [37,49]]
        
        
		
		
        
        System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, 49));
	}
}
