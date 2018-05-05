package ed2018;

public class BinaryTree<E> {

	private TreeNode<E> root;
	
	public BinaryTree() {
		this.root=null;
	}
	
	public BinaryTree(E element, int value) {
		this.root = new TreeNode<E>(element,value);
	}
	
	public BinaryTree(E element, int value, TreeNode<E> left, TreeNode<E> right) {
		this.root = new TreeNode<E>(element,value,left,right);
	}
	
	public TreeNode<E> getRoot() {
		return this.root;
	}
	
	public void setRoot(E element, int value) {
		this.root.setElement(element);
		this.root.setValue(value);
	}
	
	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}

	public boolean insert(E element, int value) {
		return insert(this.root, element, value);
	}

	private boolean insert(TreeNode<E> node, E element, int value) {
		if(value==node.getValue()) return false;
		if(node.getValue()==-1) {
			node.setElement(element);
			node.setValue(value);
			return true;
		}
		if(value<node.getValue()) {
			if(node.getLeft()==null) {
				node.setLeft(new TreeNode<E>(element, value));
				return true;
			}
			else return insert(node.getLeft(), element, value);
		}else {
			if(node.getRight()==null) {
				node.setRight(new TreeNode<E>(element, value));
				return true;
			}
			else return insert(node.getRight(), element, value);
		}
	}

	public TreeNode<E> removeNode(int value) {
		TreeNode<E> node = this.getNode(value);
		TreeNode<E> parent = parentOf(node.getValue());
		TreeNode<E> nodeClone= node.clone();
 		if(node.getLeft()==null&&node.getRight()==null) {
 			if(parent.getValue()<node.getValue()) 
 				parent.setRight(null);
 			else parent.setLeft(null);
 		}
		else {
			if(node.getLeft()==null)
				if(parent.getValue()<node.getValue()) 
	 				parent.setRight(node.getRight());
	 			else parent.setLeft(node.getRight());
			else if(node.getRight()==null)
				if(parent.getValue()<node.getValue()) 
	 				parent.setRight(node.getLeft());
	 			else parent.setLeft(node.getLeft());
			else {
				TreeNode<E> next = getNext(node.getValue());
				next.setLeft(node.getLeft());
				next.setRight(node.getRight());
				if(parent.getValue()<node.getValue()) 
	 				parent.setRight(next);
	 			else parent.setLeft(next);
				this.removeNode(next.getValue());
			}
		}
 		return nodeClone;
	}
	
	public TreeNode<E> parentOf(int value) {
		TreeNode<E> node= this.getRoot();
		if(node.getValue()==value) return null;
		else return parentOf(value,node);
	}
	
	private TreeNode<E> parentOf(int value, TreeNode<E> node) {
		if (node == null)
			throw new IllegalArgumentException("This node is null");
		if(node.getLeft().getValue()==value||node.getRight().getValue()==value) return node;
		if(node.getValue()<value) return parentOf(value, node.getRight());
		else return parentOf(value,node.getLeft());
	}

	public TreeNode<E> getNext(int value) {
		TreeNode<E> node = this.getNode(value).getRight();
		while(node.getLeft()!=null) {
			node.getLeft();
		}
		return node.clone();
	}

	public TreeNode<E> getNode(int value) {
		return getNode(value, this.getRoot());
	}

	private TreeNode<E> getNode(int value, TreeNode<E> node) {
		if (node == null)
			throw new IllegalArgumentException("This node is null");
		if(node.getValue()==value) return node;
		if(value<node.getValue()) return getNode(value, node.getLeft());
		else return getNode(value,node.getRight());
	}
	

	public TreeNode<E> removeLeftSubtree(TreeNode<E> node) {
		if (root == null)
			throw new IllegalArgumentException("This tree is empty");
		TreeNode<E> removedNode= node.getLeft();
		node.setLeft(null);
		return removedNode;
	}

	public TreeNode<E> removeRightSubtree(TreeNode<E> node) {
		if (root == null)
			throw new IllegalArgumentException("This tree is empty");
		TreeNode<E> removedNode= node.getRight();
		node.setRight(null);
		return removedNode;
	}

	public TreeNode<E> findMin() {
		TreeNode<E> node = this.getRoot();
		while(node.getLeft()!=null) {
			node.getLeft();
		}
		return node;
	}

	public TreeNode<E> findMax() {
		TreeNode<E> node = this.getRoot();
		while(node.getRight()!=null) {
			node.getRight();
		}
		return node;
	}

	public void preOrder() {
		preOrder(this.getRoot());
	}
	
	public void preOrder(TreeNode<E> node) {
		if(node != null) {
			System.out.println(node.toString());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public void inOrder() {
		inOrder(this.getRoot());
	}
	
	public void inOrder(TreeNode<E> node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.println(node.toString());
			inOrder(node.getRight());
		}
	}

	public void postOrder() {
		postOrder(this.getRoot());
	}
	
	public void postOrder(TreeNode<E> node) {
		if(node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.println(node.toString());
		}
	}

	public void levelOrder() {
		levelOrder(this.getRoot());
	}

	private void levelOrder(TreeNode<E> node) {
		// TODO Auto-generated method stub
	}

	public boolean contains(E element) {
		TreeNode<E> node = this.getRoot();
		if(this.getRoot()!=null) {
			return contains(element, node);
		}
		return false;
	}

	private boolean contains(E element, TreeNode<E> node) {
		if (element.equals(node.getElement())) return false;
		else return contains(element, node.getLeft())||contains(element, node.getRight());
	}

	public void makeEmpty() {
		this.setRoot(null);
	}

	public boolean isEmpty() {
		return this.getRoot()==null;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>();
		arbol.insert(5,82);
		arbol.insert(42,85);
		arbol.insert(20,55);
		arbol.insert(2,38);
		arbol.insert(1,70);
		arbol.insert(4,2);
		arbol.insert(4,81);
		System.out.println("InOrder:");
		arbol.inOrder();
		System.out.println("PreOrder:");
		arbol.preOrder();
		System.out.println("PostOrder:");
		arbol.postOrder();
		arbol.removeNode(81);
		
	}
}
