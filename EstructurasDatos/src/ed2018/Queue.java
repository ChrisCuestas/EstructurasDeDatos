package ed2018;
/**
 * This Queue is a LinkedList.
 * 
 * @author Christian Camilo Cuestas Ibáñez
 *
 * @param <E>
 */
public class Queue<E> extends LinkedList<E> {

	public Queue() {
		super();
	}
	
	public void enqueue(E element) {
		super.insert(this.size, element);
	}
	
	public E dequeue() {
		return super.remove(0);
	}
	
	public E peekFront() {
		return super.get(0);
	}
}
