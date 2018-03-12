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
	
	public void printStack() {
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			while(!this.isEmpty()) {
				bw.write(this.pop().toString()+ "\n");
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {e.printStackTrace();}
	}
}
