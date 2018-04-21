package ed2018;

public class TreeNode<E> {

	E element;
	TreeNode<E> left;
	TreeNode<E> right;
	
	public TreeNode(E element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(E element, TreeNode<E> leftTree, TreeNode<E> rightTree) {
		this.element = element;
		this.left = leftTree;
		this.right = rightTree;
	}
	
	public String toString () {
		return this.element.toString();
	}
}
