package queue;

public interface MyQueue<T> {

	public MyQueue<T> remove();

	public MyQueue<T> add(T x);

	public T head();

	public boolean isEmpty();
}
