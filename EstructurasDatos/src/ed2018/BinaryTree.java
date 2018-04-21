package ed2018;

public class BinaryTree<E> implements BinTree<E>{

	E root;
	BinaryTree<E> left;
	BinaryTree<E> right;
	
	public BinaryTree(E element) {
		this.root = element;
		this.left = null;
		this.right = null;
	}

	@Override
	public E getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(E data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(E data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeTree(E root, E left, E right) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BinTree<E> removeLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinTree<E> removeRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] inOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
