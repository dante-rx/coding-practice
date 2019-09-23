package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Get the diameter of a graph( Largest distance between two nodes)
 * 
 * @author nagendra
 *
 */
public class DiameterOfGraph {

	static int farthestNode;
	static int maxD = 0;

	public static void main(String[] args) {
		Map<Integer, Set<Integer>> adj = new HashMap<>();
		List<Integer> vertices = new ArrayList<>();
		vertices.addAll(Arrays.asList(1, 2, 3, 4, 5));
		addAdj(adj, 1, 2);
		addAdj(adj, 2, 1);
		addAdj(adj, 1, 3);
		addAdj(adj, 3, 1);
		addAdj(adj, 2, 4);
		addAdj(adj, 4, 2);
		addAdj(adj, 2, 5);
		addAdj(adj, 5, 2);
		System.out.println(findDaimeter(adj, vertices));
	}

	private static int findDaimeter(Map<Integer, Set<Integer>> adj, List<Integer> vertices) {
		maxD = Integer.MIN_VALUE;
		/*
		 * Let's find the farthest node from any node.
		 */
		dfs(adj, vertices, 1);
		/*
		 * Now Let's find farthest node from this node.
		 */
		dfs(adj, vertices, farthestNode);
		return maxD;
	}

	private static void dfs(Map<Integer, Set<Integer>> adj, List<Integer> vertices, int x) {
		Set<Integer> set = new HashSet<>();
		dfsUtil(adj, set, vertices, x, 0);
	}

	private static void dfsUtil(Map<Integer, Set<Integer>> adj, Set<Integer> set, List<Integer> vertices, int x,
			int count) {
		set.add(x);
		if (adj.containsKey(x)) {
			for (int y : adj.get(x)) {
				if (!set.contains(y)) {
					count++;
					if (maxD <= count) {
						farthestNode = y;
						maxD = count;
					}
					dfsUtil(adj, set, vertices, y, count);
				}
			}
		}
	}

	private static void addAdj(Map<Integer, Set<Integer>> adj, int x, int y) {
		if (!adj.containsKey(x)) {
			adj.put(x, new HashSet<>());
		}
		adj.get(x).add(y);
	}

}
