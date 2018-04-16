package ed2018;

public class DoubleLinkedList<E> extends List<E> {

	class Node<T> {
		T element;
		int value;
		Node<T> nextNode;
		Node<T> lastNode;
		public Node(T element, Node<T> lastNode,  Node<T> nextNode, int value) {
			super();
			this.element = element;
			this.nextNode = nextNode;
			this.lastNode = lastNode;
			this.value = value;
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
		if (index<this.size/2) {
			Node<E> node = this.head;
			for(int i=0; i<index-1;i++)
				node = node.nextNode;
			Node<E> newNode = new Node<E>(element, node, node.nextNode, -1);
			node.nextNode.lastNode=newNode;
			node.nextNode=newNode;
		}else {
			Node<E> node = this.tail;
			for(int i=this.size; i>index+1;i--)
				node = node.lastNode;
			Node<E> newNode = new Node<E>(element, node.lastNode, node, -1);
			node.lastNode.nextNode=newNode;
			node.lastNode=newNode;
		}
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
	
	public Node<E> binarySearch(int value) {
		int index= (super.getSize()-1)/2;
		Node<E> node= this.head;
		for(int i=0; i<index; i++) {
			node=node.nextNode;
		}
		return binarySearch(value, 0, this.getSize()-1, node );
	}

	private Node<E> binarySearch(int x, int lb,int ub, Node<E> node) {
		if(node!=null) {
			if(node.value==x) return node;
			else {
				int middleIndex = (lb+ub)/2;
				if(node.value>x) {
					for(int i=middleIndex; i<(middleIndex+ub)/2; i++) {
						node=node.nextNode;
					}
					return binarySearch(x,middleIndex+1,ub, node);
				}
				else {
					for(int i=middleIndex; i>(middleIndex+lb)/2; i++) {
						node=node.lastNode;
					}
					return binarySearch(x,lb,middleIndex-1, node);
				}
			}
			
		} else return null;
	}
}
