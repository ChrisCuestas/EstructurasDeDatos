package structures;

public interface List<E> {
	public int getSize();
	public boolean setSize(int size) ;
	public void makeEmpty();
	public boolean isEmpty();
	public boolean insert(int k, E element);
	public boolean insertAfter(int k, E element);
	public void insertBeginning(E element);
	public void insertLast(E element);
	public boolean replace(int k, E element);
	public E remove(int k);
	public boolean remove(E element);
	public int indexOf(E element);	
	public E find(int k);

}

