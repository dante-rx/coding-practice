/**
 * 
 */
package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nagendra
 *
 */
public class DisjointSet {
	
	Map<Integer, Node> map = new HashMap<>();
	
	public void makeSet(int data) {
		Node node = new Node();
		node.data = data;
		node.parent= node;
		node.rank = 1;
		map.put(data, node);
	}
	
	public int findSet(int data) {
		return findSet(map.get(data)).data;
	}

	private Node findSet(Node node) {
		Node parent = node.parent;
		if (parent == node) {
			return parent;
		}
		return findSet(node.parent);
	}
	
	public void joinSet(int data1, int data2) {
		Node x = map.get(data1);
		Node y =  map.get(data2);
		
		Node parent1= findSet(x);
		Node parent2= findSet(y);
		
		if (parent1.data == parent2.data) {
			return ;
		}
		
		if (parent1.rank > parent2.rank) {
			parent2.parent = parent1;
		}else if (parent1.rank < parent2.rank){
			parent1.parent = parent2;
		}else {
			parent1.rank+=1;
			parent2.parent = parent1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

class Node{
	int rank;
	int data;
	Node parent;
	
}
