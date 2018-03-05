package structures;

public class Queue<T> extends LinkedList<T> {

	public Queue() {
		super();
	}
	
	public void enqueueBack(T element) {
		super.insertLast(element);
	}
	
	public T dequeueFront() {
		return super.remove(0);
	}
	
	public T peekFront() {
		return super.find(0);
	}
	
	public String toString() {
		return null;
	}
}
