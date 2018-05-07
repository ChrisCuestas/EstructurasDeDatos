package ed2018;

public class TreeNode<E> {

	E element;
	int value;
	TreeNode<E> left;
	TreeNode<E> right;
	
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
		this.right = left;
	}

	/*public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}

	public TreeNode<E> getRight() {
		return right;
	}

	public void setRight(TreeNode<E> right) {
		this.right = right;
	}*/
	
	public TreeNode<E> clone(){
		return new TreeNode<E>(this.element, this.value);
	}
	
	public String toString() {
		return "Value: " + this.value + ", Element: " + this.element.toString() + "\n";
	}
}
