package ed2018;

/**
 * The LinkedStack is an LinkedList. 
 * 
 * @author Christian Camilo Cuestas Ibáñez
 *
 * @param <E>
 */
public class LinkedStack<E> extends LinkedList<E> {

	public LinkedStack() {
		super();
	}

	public void push(E element, int value) {
		this.insert(this.size, element, value);
	}
	
	public E pop() {
		return this.remove(this.size-1);
	}
	
	public ListNode<E> peek() {
		return this.get(this.size-1);
	}
	
	public String printStack() {
		String printedStack="";
		ArrayStack<E> temp = new ArrayStack<E>();
		while(!this.isEmpty()) {
			temp.push(this.pop());
		}
		E element=null;
		while(!temp.isEmpty()) {
			element=temp.pop();
			printedStack+=element.toString()+"\n";
		}
		return printedStack;
	}
}
