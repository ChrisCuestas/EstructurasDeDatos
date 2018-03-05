package structures;

public interface GenericTree<T> {
	
	public void insert(T data);
	public void remove(T data);
	public T findMin();
	public T findMax();
	public boolean contains(T data);
	public void makeEmpty();
	public boolean isEmpty();
	
}
