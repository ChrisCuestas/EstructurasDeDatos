package structures;

public class DoubleQueue<T> extends Queue<T> {

	public DoubleQueue() {
		super();
	}
	
	public void enqueueFront(T element) {
		super.insertBeginning(element);
	}
	
	public T dequeueBack() {
		return super.remove(this.getSize()-1);
	}
	
	public T peekBack() {
		return super.find(this.getSize()-1);
	}
	
	public String toString() {
		return null;
	}
}
