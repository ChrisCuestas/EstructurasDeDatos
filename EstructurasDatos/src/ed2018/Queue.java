package ed2018;
/**
 * This Queue is a LinkedList.
 * 
 * @author Christian Camilo Cuestas Ibanez
 *
 * @param <E>
 */
public class Queue<E> extends LinkedList<E> {

	public Queue() {
		super();
	}
	
	public void enqueue(E element, int value) {
		super.insert(this.size, element, value);
	}
	
	public E dequeue() {
		return super.remove(0);
	}
	
	public E peekFront() {
		return super.get(0).element;
	}
}
