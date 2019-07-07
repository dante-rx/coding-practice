package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Topological sort implementation
 * @author nagendra
 *
 */
public class TopologicalSort {

	public static void main(String a[]) {
		Graph<Character> graph = new Graph<Character>();
		Vertex<Character> A = new Vertex<Character>('A');
		Vertex<Character> B = new Vertex<Character>('B');
		Vertex<Character> C = new Vertex<Character>('C');
		Vertex<Character> D = new Vertex<Character>('D');
		Vertex<Character> E = new Vertex<Character>('E');
		Vertex<Character> F = new Vertex<Character>('F');
		Vertex<Character> G = new Vertex<Character>('G');
		Vertex<Character> H = new Vertex<Character>('H');

		A.edges.add(new Edge<Character>(C));
		B.edges.add(new Edge<Character>(C));

		B.edges.add(new Edge<Character>(D));

		C.edges.add(new Edge<Character>(E));

		E.edges.add(new Edge<Character>(H));
		E.edges.add(new Edge<Character>(F));
		F.edges.add(new Edge<Character>(G));

		graph.add(A).add(B).add(C).add(D).add(E).add(F).add(G).add(H);

		Stack<Character> stack = topologicalSort(graph);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
		System.out.println();

	}

	public static Stack<Character> topologicalSort(Graph<Character> graph) {
		Set<Character> set = new HashSet<>();
		Stack<Character> stack = new Stack<>();
		for (Vertex<Character> v : graph.vertices) {
			if (!set.contains(v.name)) {
				topologicalSortUtil(v, set, stack);
			}
		}
		return stack;

	}

	private static void topologicalSortUtil(Vertex<Character> v, Set<Character> set, Stack<Character> stack) {
		if(set.contains(v.name)){
			return ;
		}
		set.add(v.name);
		for (Edge<Character> e : v.edges) {
			if (set.contains(e.dest.name)) {
				continue;
			}
			topologicalSortUtil(v, set, stack);
		}

		stack.push(v.name);
	}

}

class Graph<T> {
	List<Vertex<T>> vertices = new ArrayList<>();

	public Graph<T> add(Vertex<T> v) {
		vertices.add(v);
		return this;
	}
	
	public void addEdge(T src, T dest){
		Vertex<T> s =null, d= null;
		for(Vertex<T> v :vertices){
			if (v.name == src){
				s = v;
			}else if(v.name == dest){
				d = v;
			}
		}
		
		s.edges.add(new Edge<T>(d));
		
	}

}

class Vertex<T> {
	T name;
	List<Edge<T>> edges = new ArrayList<>();

	Vertex(T name) {
		this.name = name;
	}
}

class Edge<T> {
	Vertex<T> dest;

	Edge(Vertex<T> destination) {
		this.dest = destination;
	}
}
