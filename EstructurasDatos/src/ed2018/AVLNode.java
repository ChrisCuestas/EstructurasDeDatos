package ed2018;

public class AVLNode<E> extends TreeNode<E> {

	int balanceFactor;
	AVLNode<E> left;
	AVLNode<E> right;
	
	public AVLNode() {
		super(null, -1, null, null);
		this.balanceFactor = 0;
	}
	
	public AVLNode(E element) {
		super(element, -1, null, null);
		this.balanceFactor = 0;
	}
	
	public AVLNode(E element, int value) {
		super(element, value, null, null);
		this.balanceFactor = 0;
	}
	
	public AVLNode(E element, int value, AVLNode<E> left, AVLNode<E> right) {
		super(element, value, left, right);
		if(this.left==null) {
			if(this.right==null)
				this.balanceFactor = 0;
			else this.balanceFactor = 1 + this.right.balanceFactor;
		} else if(this.right==null) {
			if(this.left==null)
				this.balanceFactor = 0;
			else this.balanceFactor = 1;
		} else {
			this.balanceFactor = this.left.balanceFactor + this.right.balanceFactor;
		}
	}

	@Override
	public AVLNode<E> clone(){
		return new AVLNode<E>(this.element, this.value);
	}
	
	@Override
	public String toString() {
		return "Value: " + this.value + ", Element: " + this.element.toString() + "\n";
	}

	public void refreshBalanceFactor() {
		if(this.left==null) {
			if(this.right==null)
				this.balanceFactor = 0;
			else this.balanceFactor = 1 + this.right.balanceFactor;
		} else if(this.right==null) {
			if(this.left==null)
				this.balanceFactor = 0;
			else this.balanceFactor = 1;
		} else {
			this.balanceFactor = this.left.balanceFactor + this.right.balanceFactor;
		}
	}
}