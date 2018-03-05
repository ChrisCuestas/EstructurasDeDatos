package structures;

public class AVLTree<T> implements GenericTree<T>{

	private AVLTreeNode<T> root;

	public AVLTree(AVLTreeNode<T> root) {
		super();
		this.root = root;
	}

	public AVLTree() {
		super();
		this.root = null;
	}

	public AVLTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(AVLTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public void insert(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T data) {
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
