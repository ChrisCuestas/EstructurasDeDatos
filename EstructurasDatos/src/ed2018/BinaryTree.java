package ed2018;

public class BinaryTree<E> {

	private E root;
	private int value;
	private BinaryTree<E> left;
	private BinaryTree<E> right;
	
	public BinaryTree() {
		this.value = -1;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTree(E element, int value) {
		this.value = value;
		this.root = element;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTree(E element, int value, BinaryTree<E> left, BinaryTree<E> right) {
		this.value = value;
		this.root = element;
		this.left = left;
		this.right = left;
	}
	
	public E getRoot() {
		return this.root;
	}
	
	public void setRoot(E root) {
		this.root = root;
	}
	
	public void setRoot(BinaryTree<E> node) {
		this.root = node.root;
		this.value = node.value;
		this.left = node.left;
		this.right = node.right;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTree<E> getLeft() {
		return left;
	}

	public void setLeft(BinaryTree<E> left) {
		this.left = left;
	}

	public BinaryTree<E> getRight() {
		return right;
	}

	public void setRight(BinaryTree<E> right) {
		this.right = right;
	}

	public boolean insert(E element, int value) {
		return insert(this, element, value);
	}

	private boolean insert(BinaryTree<E> node, E element, int value) {
		if(value==node.value) return false;
		if(value<node.value) {
			if(node.left==null) {
				node.left= new BinaryTree<E>(element, value);
				return true;
			}
			else return insert(node.left, element, value);
		}else {
			if(node.right==null) {
				node.right= new BinaryTree<E>(element, value);
				return true;
			}
			else return insert(node.right, element, value);
		}
	}

	public BinaryTree<E> removeLeftNode(BinaryTree<E> node) {
		BinaryTree<E> leftSon = node.left;
		if(leftSon==null) return null;
 		if(leftSon.left==null&&leftSon.right==null) 
			node.left= null;
		else {
			if(leftSon.left==null)
				node.left = leftSon.right;
			else if(leftSon.right==null)
				node.left = leftSon.left;
			else {
				BinaryTree<E> next = next(leftSon);
				//TODO: Complete.
			}
		}
 		leftSon.right=leftSon.right=null;
 		return leftSon;
	}
	
	public BinaryTree<E> next(BinaryTree<E> node) {
		// TODO Auto-generated method stub
		return null;
	}

	public BinaryTree<E> getNode(int value) {
		// TODO Auto-generated method stub
		return null;
	}

	public BinaryTree<E> removeLeftSubtree(BinaryTree<E> node) {
		if (root == null)
			throw new IllegalArgumentException("This tree is empty");
		BinaryTree<E> removedNode= node.left;
		node.left= null;
		return removedNode;
	}

	public BinaryTree<E> removeRightSubtree(BinaryTree<E> node) {
		if (root == null)
			throw new IllegalArgumentException("This tree is empty");
		BinaryTree<E> removedNode= node.right;
		node.right= null;
		return removedNode;
	}
	
	public void makeTree(E root, E left, E right) {
		// TODO Auto-generated method stub
		
	}

	public E findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	public E findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] inOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean contains(E data) {
		// TODO Auto-generated method stub
		return false;
	}

	public void makeEmpty() {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


}
