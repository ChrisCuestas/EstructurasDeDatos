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
	
	public String toString() {
		return "Value: " + this.value + "\n";
	}

	public boolean insert(E element, int value) {
		return insert(this, element, value);
	}

	private boolean insert(BinaryTree<E> node, E element, int value) {
		if(value==node.value) return false;
		if(node.value==-1) {
			node.root=element;
			node.value=value;
			return true;
		}
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
		BinaryTree<E> leftSon = node.left;						//Get the left son of the given node
		if(leftSon==null) return null;							//If there is not left node do nothing
 		if(leftSon.left==null&&leftSon.right==null) 			//but if the left son is a leaf
			node.left= null;										//just set the left son as null
		else {													//but other wise, we must handle the sons of leftSon
			if(leftSon.left==null)									//while there is no left son of the leftSon 
				node.left = leftSon.right;								//just set the right son of leftSon as the left son of the given node
			else if(leftSon.right==null)							//but the right son of leftSon is null
				node.left = leftSon.left;								//set the left son of the leftSon as the left son of the given node
			else {													//other wise, we must handle both sons of leftSon
				BinaryTree<E> next = removeNext(leftSon);						//get and remove the next node of the leftSon, that is a leaf
				next.left = leftSon.left;										//set the sons of leftSon as the sons of next
				next.right = leftSon.right;
				node.left=next;													//set next as the new left son of the given node
			}
		}
 		leftSon.right=leftSon.right=null;
 		return leftSon;
	}
	
	public BinaryTree<E> removeNext(BinaryTree<E> node) {
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

	public void preOrder(BinaryTree<E> node) {
		if(node != null) {
			System.out.println(node.toString());
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void inOrder(BinaryTree<E> node) {
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.toString());
			inOrder(node.right);
		}
	}

	public void postOrder(BinaryTree<E> node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.toString());
		}
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
		arbol.inOrder(arbol);
		System.out.println("PreOrder:");
		arbol.preOrder(arbol);
		System.out.println("PostOrder:");
		arbol.postOrder(arbol);
		arbol.remove(81);
		
	}

	private void remove(int value) {
		this.getValue(this.get);
	}
}
