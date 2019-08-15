package set;

//public class SnakeAndLadder2 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class SnakeAndLadder2
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int n = 30;
		int[] moves = new int[n];
		for(int i=0;i<n;i++)
			moves[i] = -1;
		//ladder
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;
 
		//snake
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;
 
		System.out.println("the minimum throws is "+ getmindicethrow(moves,n));
	}
 
	public static int getmindicethrow(int[] moves, int n){
		boolean[] visited = new boolean[n];
		for(int i=0;i<n;i++)
			visited[i] = false;
		Queue<myqueueEntry> q = new LinkedList<myqueueEntry>();
		visited[0] = true;
		myqueueEntry s = new myqueueEntry();
		s.v = 0;
		s.dist = 0;
		q.offer(s);
		myqueueEntry qe = new myqueueEntry();
		while(!q.isEmpty()){
			qe = q.peek();
			int v = qe.v;
			if(v==n-1)
				break;
			q.poll();
			for(int j=v+1;j<=v+6 && j<n;j++){
				if(!visited[j]){
					myqueueEntry a = new myqueueEntry();
					a.dist = qe.dist+1;
					visited[j] = true;
					if(moves[j] == -1)
						a.v = j;
					else
						a.v = moves[j];
					q.offer(a);
				}
			}
 
		}
 
		return qe.dist;
	}
}
 
class myqueueEntry{
	int v;
	int dist;
}