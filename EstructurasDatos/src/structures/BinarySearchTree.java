package structures;

public class BinarySearchTree<T extends Comparable<T>> implements GenericTree<T>,Comparable<BinarySearchTree<T>>{

	private BinaryNode<T> root;
	
	public BinarySearchTree() {
		super();
		this.root=null;
	}
	
	public BinaryNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}

	public void insert(T data) {
		this.root=insert(data, root);
	}
	
	private BinaryNode<T> insert(T data, BinaryNode<T> node) {
		if (node==null) return new BinaryNode<T>(data, null, null);
		int comparison =data.compareTo(node.getData());
		if (comparison>0) node.setRight(this.insert(data, node.getRight()));
		if (comparison<0) node.setLeft(this.insert(data, node.getLeft()));
		return node;
	}
	
	public void remove(T data) {
		
	}
	
	public T findMin() {
		if(!this.isEmpty()) return findMin(root).getData();
		else return null;
	}
	
	private BinaryNode<T> findMin(BinaryNode<T> node){
		if(node==null) return null;
		else if(node.getLeft()== null) return node;
		else return findMin(node.getLeft());
	}
	
	public T findMax() {
		if(!this.isEmpty()) return findMax(root).getData();
		else return null;
	}
	
	private BinaryNode<T> findMax(BinaryNode<T> node) {
		if(node==null) return null;
		else if(node.getRight()== null) return node;
		else return findMax(node.getRight());
	}

	public boolean contains(T data) {
		return contains(data, root);
	}
	
	private boolean contains(T data, BinaryNode<T> node) {
		if(node==null) return false;
		int comparison = data.compareTo(node.getData());
		if(comparison<0) return contains(data, node.getLeft());
		else if(comparison>0) return contains(data, node.getRight());
		else return true;
	}
	
	public void makeEmpty() {
		this.root=null;
	}
	
	public boolean isEmpty() {
		return this.root==null;
	}

	@Override
	public  int compareTo(BinarySearchTree<T> tree) {
		return this.getRoot().compareTo(tree.root);
	}
	
	/*public void printTree() {
		
	}*/
}
