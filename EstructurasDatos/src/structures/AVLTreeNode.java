package structures;

public class AVLTreeNode<T> {
	/*
	 * AVL Tree Node
	 */
	private T data;
	private AVLTreeNode<T> left;
	private AVLTreeNode<T> right;
	private int height;
	
	public AVLTreeNode( AVLTreeNode<T> left, AVLTreeNode<T> right) {
		super();
		this.left = left;
		this.right = right;
		this.setHeight();
	}
	
	
	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public AVLTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(AVLTreeNode<T> left) {
		this.left = left;
	}

	public AVLTreeNode<T> getRight() {
		return right;
	}

	public void setRight(AVLTreeNode<T> right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight() {
		this.height = getRight().getHeight() - getLeft().getHeight();
	}	
}
