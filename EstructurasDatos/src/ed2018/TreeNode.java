package ed2018;

public class TreeNode<E> {

	E element;
	int value;
	TreeNode<E> left;
	TreeNode<E> right;
	
	public TreeNode() {
		this.value = -1;
		this.element = null;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(E element) {
		this.value = -1;
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(E element, int value) {
		this.value = value;
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(E element, int value, TreeNode<E> left, TreeNode<E> right) {
		this.value = value;
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	public boolean isLeaf(){
		return (this.left == null && this.right == null) ? true : false;
	}
	
	public TreeNode<E> clone(){
		return new TreeNode<E>(this.element, this.value);
	}
	
	public String toString() {
		return "Value: " + this.value + ", Element: " + this.element.toString() + "\n";
	}
}
