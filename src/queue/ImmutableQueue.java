/**
 * 
 */
package queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nagendra
 *
 */
public class ImmutableQueue<T> implements MyQueue<T>{
	
	private final Deque<T> queue;
	public ImmutableQueue() {
		queue = new LinkedList<>();
	}
	
	private ImmutableQueue(Deque<T>  q) {
		this.queue =q;
	}
	


	@Override
	public ImmutableQueue<T> remove() {
		Deque<T> temp = new LinkedList<>(this.queue);
		temp.removeFirst();
		return new ImmutableQueue<T>(temp);
	}

	@Override
	public ImmutableQueue<T> add(T x) {
		Deque<T> temp = new LinkedList<>(this.queue);
		temp.add(x);
		return new ImmutableQueue<T>(temp);
		
	}

	@Override
	public T head() {
		return queue.peek();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	@Override
	public int size() {
		return queue.size();
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> queue = new ImmutableQueue<>();
		queue.add(5);
		
		MyQueue<Integer>  queue2= queue.add(7);
		queue2= queue2.add(6);
		
		System.out.println(queue.size());
		System.out.println(queue2.size());
		queue2 = queue2.remove();
		System.out.println(queue2.size());
		
		
		
		

	}

}
