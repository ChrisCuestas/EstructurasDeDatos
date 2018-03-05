package structures;

public class Stack<E> extends ArrayBasedList<E> {

	public Stack() {	
		super(0);
	}
	
	public void push(E element) {
		super.insertLast(element);
	}
	
	public E pop() {
		return super.remove(this.getSize()-1);
	}
	
	public E peek() {
		return super.find(this.getSize()-1);
	}
}
