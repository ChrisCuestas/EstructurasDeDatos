package ed2018;

class AVLNode<E> {

	E element;
	int balanceFactor;
	int value;
	AVLNode<E> left;
	AVLNode<E> right;
	
	public AVLNode() {
		this.value = -1;
		this.element = null;
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
	}
	
	public AVLNode(E element) {
		this.value = -1;
		this.element = element;
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
	}
	
	public AVLNode(E element, int value) {
		this.value = value;
		this.element = element;
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
	}
	
	public AVLNode(E element, int value, AVLNode<E> left, AVLNode<E> right) {
		this.value = value;
		this.element = element;
		this.left = left;
		this.right = left;
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
	
	public AVLNode<E> clone(){
		return new AVLNode<E>(this.element, this.value);
	}
	
	public String toString() {
		return "Value: " + this.value + ", Element: " + this.element.toString() + "\n";
	}
}

public class AVLTree<E>  {
	
	private AVLNode<E> root;
	
	public AVLTree() {
		this.root=null;
	}
	
	public AVLTree(E element, int value) {
		this.root = new AVLNode<E>(element,value);
	}
	
	public AVLTree(E element, int value, AVLNode<E> left, AVLNode<E> right) {
		this.root = new AVLNode<E>(element,value,left,right);
	}
	
	public AVLNode<E> getRoot() {
		return this.root;
	}
	
	public void setRoot(E element, int value) {
		this.root.element=element;
		this.root.value=value;
	}
	
	public void setRoot(AVLNode<E> root) {
		this.root = root;
	}

	public boolean insert(E element, int value) {
		if(this.root==null) {
			this.root = new AVLNode<E>(element, value);
			return true;
		} else return insert(this.root, element, value);
	}

	private boolean insert(AVLNode<E> node, E element, int value) {
		if(value==node.value) return false;
		if(node.value==-1) {
			node.element=element;
			node.value=value;
			return true;
		}
		if(value<node.value) {
			if(node.left==null) {
				node.left=new AVLNode<E>(element, value);
				return true;
			}
			else return insert(node.left, element, value);
		}else {
			if(node.right==null) {
				node.right=new AVLNode<E>(element, value);
				return true;
			}
			else return insert(node.right, element, value);
		}
	}

	public AVLNode<E> removeNode(int value) {
		AVLNode<E> node = this.getNode(value);
		if (node==null) return null;
		AVLNode<E> parent = parentOf(node.value);
		AVLNode<E> nodeClone= node.clone();
 		if(node.left==null && node.right==null) {
 			if(parent.value<node.value) 
 				parent.right=null;
 			else parent.left=null;
 		}
		else {
			if(node.left==null)
				if(parent.value<node.value) 
	 				parent.right=node.right;
	 			else parent.left=node.right;
			else if(node.right==null)
				if(parent.value<node.value) 
	 				parent.right=node.left;
	 			else parent.left=node.left;
			else {
				AVLNode<E> next = getNext(node.value);
				next.left=node.left;
				next.right=node.right;
				if(parent.value<node.value) 
	 				parent.right=next;
	 			else if(parent.value<node.value) 
	 				parent.left=next;
				this.removeNode(next.value);
			}
		}
 		return nodeClone;
	}
	
	public AVLNode<E> parentOf(int value) {
		AVLNode<E> node= this.getRoot();
		if(node.value==value) return node;
		else return parentOf(value,node);
	}
	
	private AVLNode<E> parentOf(int value, AVLNode<E> node) {
		if (node == null)
			throw new IllegalArgumentException("This node is null");
		if(node.left==null&&node.right==null) return null;
		if(node.left==null) {
			if (node.right.value==value)
				return node; 
			if(node.value<value) return parentOf(value, node.right);
			else return null;
		}
		if(node.right==null) {
			if (node.left.value==value)
				return node;
			if(node.value>value) return parentOf(value, node.left);
			else return null;
		}
		if(node.left.value==value||node.right.value==value) return node;
		if(node.value<value) return parentOf(value, node.right);
		else return parentOf(value,node.left);
	}

	public AVLNode<E> getNext(int value) {
		AVLNode<E> node = this.getNode(value).right;
		while(node.left!=null) {
			node=node.left;
		}
		return node.clone();
	}

	public AVLNode<E> getNode(int value) {
		return getNode(value, this.getRoot());
	}

	private AVLNode<E> getNode(int value, AVLNode<E> node) {
		if (node == null)
			return null;
		if(node.value==value) return node;
		if(value<node.value) return getNode(value, node.left);
		else return getNode(value,node.right);
	}
	

	public AVLNode<E> removeLeftSubtree(AVLNode<E> node) {
		if (root == null)
			throw new IllegalArgumentException("This tree is empty");
		AVLNode<E> removedNode= node.left;
		node.left=null;
		return removedNode;
	}

	public AVLNode<E> removeRightSubtree(AVLNode<E> node) {
		if (root == null)
			throw new IllegalArgumentException("This tree is empty");
		AVLNode<E> removedNode= node.right;
		node.right=null;
		return removedNode;
	}

	public AVLNode<E> findMin() {
		AVLNode<E> node = this.getRoot();
		while(node.left!=null) {
			node = node.left;
		}
		return node;
	}

	public AVLNode<E> findMax() {
		AVLNode<E> node = this.getRoot();
		while(node.right!=null) {
			node = node.right;
		}
		return node;
	}

	public void preOrder() {
		preOrder(this.getRoot());
	}
	
	public void preOrder(AVLNode<E> node) {
		if(node != null) {
			System.out.println(node.toString());
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void inOrder() {
		inOrder(this.getRoot());
	}
	
	public void inOrder(AVLNode<E> node) {
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.toString());
			inOrder(node.right);
		}
	}

	public void postOrder() {
		postOrder(this.getRoot());
	}
	
	public void postOrder(AVLNode<E> node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.toString());
		}
	}

	public void levelOrder() {
		levelOrder(this.getRoot());
	}

	private void levelOrder(AVLNode<E> node) {
		// TODO Auto-generated method stub
	}

	public boolean contains(E element) {
		AVLNode<E> node = this.getRoot();
		if(this.getRoot()!=null) {
			return contains(element, node);
		}
		return false;
	}

	private boolean contains(E element, AVLNode<E> node) {
		if (element.equals(node.element)) return false;
		else return contains(element, node.left)||contains(element, node.right);
	}

	public void makeEmpty() {
		this.setRoot(null);
	}

	public boolean isEmpty() {
		return this.getRoot()==null;
	}
	
	public void rotateLeft() {
		
	}
	
	public void rotateRight() {
		
	}
	
	public void balance() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
