package ed2018;

public class BinaryTreeNode<E> {

	E element;
	BinaryTreeNode<E> left;
	BinaryTreeNode<E> right;
	
	public BinaryTreeNode(E element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTreeNode(E element, BinaryTreeNode<E> leftTree, BinaryTreeNode<E> rightTree) {
		this.element = element;
		this.left = leftTree;
		this.right = rightTree;
	}
	
	public String toString () {
		return this.element.toString();
	}
}
