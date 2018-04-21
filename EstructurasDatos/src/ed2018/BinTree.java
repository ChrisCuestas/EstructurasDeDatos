package ed2018;

public interface BinTree<T> {
	
	public T getRoot();
	public void insert(T data);
	public void remove(T data);
	public void makeTree(T root, T left, T right);
	public BinTree<T> removeLeft();
	public BinTree<T> removeRight();
	public T findMin();
	public T findMax();
	public Object[] preOrder();
	public Object[] inOrder();
	public Object[] postOrder();
	public Object[] levelOrder();
	public boolean contains(T data);
	public void makeEmpty();
	public boolean isEmpty();
	
}
