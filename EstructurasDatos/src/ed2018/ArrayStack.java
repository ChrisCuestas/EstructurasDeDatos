package ed2018;

/**
 * The ArrayStack is an ArraybasedList. 
 * 
 * @author Christian Camilo Cuestas Ibáñez
 *
 * @param <E>
 */
public class ArrayStack<E> extends ArraybasedList<E> {

	public ArrayStack() {
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
