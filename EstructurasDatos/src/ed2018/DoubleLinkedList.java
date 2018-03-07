package ed2018;

public class DoubleLinkedList<E> extends List<E> {

	class Node<T> {
		T element;
		Node<T> nextNode;
		Node<T> lastNode;
		public Node(T element, Node<T> lastNode,  Node<T> nextNode) {
			super();
			this.element = element;
			this.nextNode = nextNode;
			this.lastNode = lastNode;
		}
	}
	
	Node<E> head;
	Node<E> tail;
	
	@Override
	public void makeEmpty() {
		this.head=this.tail=null;
		this.setSize(0);
	}

	@Override
	public boolean insert(int index, E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		if (index>this.size||index<0) return null; 				// If the given index < 0 or index > size, do not insert.
		if(index<=this.size+1) return this.getLeft(index).element;
		else return this.getRight(index).element;
	}
	
	private Node<E> getLeft(int index) {
		Node<E> node= this.tail;
		for (int i=0; i<index;i++) {
			node=node.nextNode;
		}
		return node;
	}
	
	private Node<E> getRight(int index) {
		Node<E> node= this.tail;
		for (int i=this.size-1; i>index;i--) {
			node=node.lastNode;
		}
		return node;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E replace(int index, E newElement) {
		if (index>this.size||index<0) return null; 				// If the given index < 0 or index > size, do not insert.
		Node<E> node;
		if(index<=this.size+1) node= this.replaceLeft(index, newElement);
		else node = this.replaceRight(index, newElement);
		E oldNode=node.element;
		node.element=newElement;
		return oldNode;
	}
	
	private Node<E> replaceLeft(int index, E newElement) {
		Node<E> node= this.tail;
		for (int i=0; i<index;i++) {
			node=node.nextNode;
		}
		return node;
	}
	
	private Node<E> replaceRight(int index, E newElement) {
		Node<E> node= this.tail;
		for (int i=this.size-1; i>index;i--) {
			node=node.lastNode;
		}
		return node;
	}

	@Override
	public int firstIndexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

}
