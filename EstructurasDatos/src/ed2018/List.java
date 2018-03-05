package ed2018;

/**
 * This is an generic and abstract list, that implements attributes and methods 
 * that are invariable regarded to a particular implementation. Also, it has the basic
 * abstract methods that each implementation must implement.
 * 
 * @author Christian Camilo Cuestas Ibáñez
 *
 * @param <E> the type of object to store in the list.
 */

public abstract class List<E> {

	protected int size;
	
	public List() {
		this.size=0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	protected void setSize(int size) {
		this.size=size;
	}
	
	public void incrementSize(int increment) {
		this.setSize(this.getSize()+increment);
	}
	
	public void decrementSize(int decrement) {
		this.setSize(this.getSize()-decrement);
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public abstract void makeEmpty();
	
	public abstract boolean insert(int index, E element);
	
	public void insertFirst(E element) {
		this.insert(0, element);
	};
	
	public void insert(E element) {
		this.insert(this.getSize(), element);
	}
	
	public abstract E get(int index);
	
	public E getFirst() {
		return this.get(0);
	}
	
	public E getLast() {
		return this.get(this.getSize()-1);
	}
	
	public abstract E remove(int index);
	
	public E removeFirst() {
		return this.remove(0);
	}
	
	public E removeLast() {
		return this.remove(this.getSize()-1);
	}
	
	public abstract E replace(int index, E newElement);
	
	public abstract int firstIndexOf(E element);
}
