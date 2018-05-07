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
		this.root.element=element;
		this.root.value=value;
	}
	
	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}

	public boolean insert(E element, int value) {
		if(this.root==null) {
			this.root = new TreeNode<E>(element, value);
			return true;
		} else return insert(this.root, element, value);
	}

	private boolean insert(TreeNode<E> node, E element, int value) {
		if(value==node.value) return false;
		if(node.value==-1) {
			node.element=element;
			node.value=value;
			return true;
		}
		if(value<node.value) {
			if(node.left==null) {
				node.left=new TreeNode<E>(element, value);
				return true;
			}
			else return insert(node.left, element, value);
		}else {
			if(node.right==null) {
				node.right=new TreeNode<E>(element, value);
				return true;
			}
			else return insert(node.right, element, value);
		}
	}

	public TreeNode<E> removeNode(int value) {
		TreeNode<E> node = this.getNode(value);
		if (node==null) return null;
		TreeNode<E> parent = parentOf(node.value);
		TreeNode<E> nodeClone= node.clone();
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
				TreeNode<E> next = getNext(node.value);
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
	
	public TreeNode<E> parentOf(int value) {
		TreeNode<E> node= this.getRoot();
		if(node.value==value) return node;
		else return parentOf(value,node);
	}
	
	private TreeNode<E> parentOf(int value, TreeNode<E> node) {
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

	public TreeNode<E> getNext(int value) {
		TreeNode<E> node = this.getNode(value).right;
		while(node.left!=null) {
			node=node.left;
		}
		return node.clone();
	}

	public TreeNode<E> getNode(int value) {
		return getNode(value, this.getRoot());
	}

	private TreeNode<E> getNode(int value, TreeNode<E> node) {
		if (node == null)
			return null;
		if(node.value==value) return node;
		if(value<node.value) return getNode(value, node.left);
		else return getNode(value,node.right);
	}
	

	public TreeNode<E> removeLeftSubtree(TreeNode<E> node) {
		if (root == null)
			throw new IllegalArgumentException("This tree is empty");
		TreeNode<E> removedNode= node.left;
		node.left=null;
		return removedNode;
	}

	public TreeNode<E> removeRightSubtree(TreeNode<E> node) {
		if (root == null)
			throw new IllegalArgumentException("This tree is empty");
		TreeNode<E> removedNode= node.right;
		node.right=null;
		return removedNode;
	}

	public TreeNode<E> findMin() {
		TreeNode<E> node = this.getRoot();
		while(node.left!=null) {
			node = node.left;
		}
		return node;
	}

	public TreeNode<E> findMax() {
		TreeNode<E> node = this.getRoot();
		while(node.right!=null) {
			node = node.right;
		}
		return node;
	}

	public void preOrder() {
		preOrder(this.getRoot());
	}
	
	public void preOrder(TreeNode<E> node) {
		if(node != null) {
			System.out.println(node.toString());
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void inOrder() {
		inOrder(this.getRoot());
	}
	
	public void inOrder(TreeNode<E> node) {
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.toString());
			inOrder(node.right);
		}
	}

	public void postOrder() {
		postOrder(this.getRoot());
	}
	
	public void postOrder(TreeNode<E> node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
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
		if (element.equals(node.element)) return false;
		else return contains(element, node.left)||contains(element, node.right);
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
		/*System.out.println("PreOrder:");
		arbol.preOrder();
		System.out.println("PostOrder:");
		arbol.postOrder();*/
		arbol.removeNode(81);
		System.out.println("InOrder:");
		arbol.inOrder();
		arbol.removeNode(82);
		/*System.out.println("InOrder:");
		arbol.inOrder();
		arbol.removeNode(2);
		System.out.println("InOrder:");
		arbol.inOrder();
		System.out.println("PreOrder:");
		arbol.preOrder();
		System.out.println("PostOrder:");
		arbol.postOrder();*/
	}
}
