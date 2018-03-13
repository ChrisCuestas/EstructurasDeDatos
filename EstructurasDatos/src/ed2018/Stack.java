package ed2018;

/**
 * The Stack is an ArraybasedList. 
 * 
 * @author Christian Camilo Cuestas Ibáñez
 *
 * @param <E>
 */
public class Stack<E> extends ArraybasedList<E> {

	public Stack() {
		super();
	}

	public void push(E element) {
		this.insert(this.size, element);
	}
	
	public E pop() {
		return this.remove(this.size-1);
	}
	
	public E peek() {
		return this.get(this.size-1);
	}
	
	public String printStack() {
		String printedStack="";
		Stack<E> temp = new Stack<E>();
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
