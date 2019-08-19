package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author nagendra
 *
 */
public class GraphTravelledPoints {
	Map<Character, List<Point>> map = new HashMap<>();
	

	public static void main(String[] args) {
		GraphTravelledPoints obj = new GraphTravelledPoints();
		
		List<Point> list = new ArrayList<Point>();
		list.add(new Point('A', 'B', 5));
		list.add(new Point('A', 'C', 2));
		list.add(new Point('B', 'D', 5));
		list.add(new Point('A', 'E', 9));
		list.add(new Point('C', 'F', 3));
		obj.createMap(list);
		obj.getNear('A');
		
		List<Character> possiblePointsCovered = obj.possiblePointsCovered('A', 8);
		System.out.println(possiblePointsCovered);
		
	}
	
	private List<Character> possiblePointsCovered(char c, int distance) {
		Queue<RemainingDistancePoint> queue = new ArrayDeque<>();
		List<Character> solution = new ArrayList<>();
		
		
		queue.add(new RemainingDistancePoint(c, distance));
		while (!queue.isEmpty()) {
			RemainingDistancePoint remPoint = queue.remove();
			List<Point> list = map.get(remPoint.dest);
			
			if (list != null)
			for (Point p:list) {
				if (remPoint.remaining >= p.distance) {
					if (p.dest != c) {
						solution.add(p.dest);
					}
					queue.add(new RemainingDistancePoint(p.dest, remPoint.remaining - p.distance));
				}
			}
			
		}
		return solution;
		
		
		
	}

	private void getNear(char c) {
		List<Point> list = map.get(c);
		for (Point p: list)
			System.out.println(p.dest);
		
	}

	public void createMap(List<Point> list) {
		for (Point p:list) {
			char src = p.source;
			List<Point> list2= new ArrayList<Point>();
			if (map.containsKey(src)) {
				list2 = map.get(src);
			}
			list2.add(p);
			map.put(src, list2);
		}
		
	}

}

class Point{
	char source;
	char dest;
	int distance;
	
	Point(char s, char d, int dist){
		source =s;
		dest =d;
		distance = dist;
	}
}

class RemainingDistancePoint {
	int remaining;
	char dest;
	RemainingDistancePoint(char c, int rem){
		dest =c;
		remaining = rem;
	}
}
