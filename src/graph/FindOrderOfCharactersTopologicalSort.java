package graph;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;


public class FindOrderOfCharactersTopologicalSort {

	public static void main(String[] args) {
		String[] words = { "caa", "aaa", "aab" };
		Graph<Character> graph = createGraph(words);
		
		Stack<Character> stack = TopologicalSort.topologicalSort(graph);
		
		// Now this has to be printed in reverse order of LIFO
		// a->b->c
		// first c is popped from stack. But we have to print a here first.
		// So let's print in reverse order. No need to do pop, just simply print in First in Order
		// We don't want to print c first
		for(int i=0; i< stack.size();i++){
			System.out.print(stack.get(i) + "\t");
		}
		System.out.println();
		
		
		String words2[] = {"baa", "abcd", "abca", "cab", "cad"};
		Graph<Character> graph2 = createGraph(words2);
		
		Stack<Character> stack2 = TopologicalSort.topologicalSort(graph2);
		for(int i=0; i< stack2.size();i++){
			System.out.print(stack2.get(i) + "\t");
		}
		System.out.println();

	}

	private static Graph<Character> createGraph(String[] words) {
		Set<Character> allChars = new LinkedHashSet<>();
		for (String s : words) {
			char[] charArray = s.toCharArray();
			for (char x : charArray) {
				allChars.add(x);
			}
		}

		Graph<Character> graph = new Graph<Character>();
		for (Character s : allChars) {
			graph.vertices.add(new Vertex<Character>(s));
		}
		
		// Now lets' add Edges
		String first = words[0], second;
		for (int i= 1; i< words.length;i++){
			first =  words[i-1];
			second = words[i];
			
			// find non-matching chars
			findFirstNonMatchingChar(graph, first, second);
			
		}
		return graph;
		

	}

	private static void findFirstNonMatchingChar(Graph<Character> graph, String s1, String s2) {

		String bigger = s1;
		String smaller = s2;
		if (s1.length() < s2.length()) {
			bigger = s2;
			smaller = s1;
		}
		char src, dest;

		for (int i = 0; i < smaller.length(); i++) {
			if (bigger.charAt(i) != smaller.charAt(i)) {
				src= s1.charAt(i);
				dest= s2.charAt(i);
				graph.addEdge(src, dest);
				return;
			}
		}

		
	}

}
