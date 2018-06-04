package ed2018;

public class DoubleLinkedList<E> {
	
	private ListNode<E> head;
	private ListNode<E> tail;
	private int size;
	
	public DoubleLinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.size=0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	protected void setSize(int size) {
		this.size=size;
	}
	
	public void incrementSize(int increment) {
		this.setSize(this.getSize()+increment);
	}
	
	public void decrementSize(int decrement) {
		this.setSize(this.getSize()-decrement);
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public void insertFirst(E element, int value) {
		this.insert(0, element, value);
	};
	
	public void insert(E element, int value) {
		this.insert(this.getSize(), element, value);
	}
	
	public E getFirst() {
		return this.get(0).element;
	}
	
	public E getLast() {
		return this.get(this.getSize()-1).element;
	}
	
	public E removeFirst() {
		return this.remove(0);
	}
	
	public E removeLast() {
		return this.remove(this.getSize()-1);
	}
	
	public void makeEmpty() {
		this.head=this.tail=null;
		this.setSize(0);
	}

	public boolean insert(int index, E element, int value) {
		ListNode<E> newNode;
		if (index==0) {
			newNode= new ListNode<E>(element, null, this.head, value);
			this.head.lastNode=newNode;
			this.head=newNode;
			return true;
		}else if(index==this.size-1) {
			newNode= new ListNode<E>(element, this.tail, null, value);
			this.tail.nextNode=newNode;
			this.tail=newNode; 
			return true;
		}else if(index<this.size-1&&index>0){
			ListNode<E> node;
			if (index<this.size/2) {
				node = this.head;
				for(int i=0; i<index-1;i++)
					node = node.nextNode;
				newNode = new ListNode<E>(element, node, node.nextNode, -1);
				node.nextNode.lastNode=newNode;
				node.nextNode=newNode;
			}else {
				node = this.tail;
				for(int i=this.size; i>index+1;i--)
					node = node.lastNode;
				newNode = new ListNode<E>(element, node.lastNode, node, -1);
				node.lastNode.nextNode=newNode;
				node.lastNode=newNode;
			}
			return true;
		}
		return false;
	}

	public ListNode<E> get(int index) {
		if (index>this.size||index<0) return null; 				// If the given index < 0 or index > size, do not insert.
		if(index<=this.size+1) return this.getLeft(index);
		else return this.getRight(index);
	}
	
	private ListNode<E> getLeft(int index) {
		ListNode<E> node= this.tail;
		for (int i=0; i<index;i++) {
			node=node.nextNode;
		}
		return node;
	}
	
	private ListNode<E> getRight(int index) {
		ListNode<E> node= this.tail;
		for (int i=this.size-1; i>index;i--) {
			node=node.lastNode;
		}
		return node;
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public E replace(int index, E newElement) {
		if (index>this.size||index<0) return null; 				// If the given index < 0 or index > size, do not insert.
		ListNode<E> node;
		if(index<=this.size+1) node= this.replaceLeft(index, newElement);
		else node = this.replaceRight(index, newElement);
		E oldNode=node.element;
		node.element=newElement;
		return oldNode;
	}
	
	private ListNode<E> replaceLeft(int index, E newElement) {
		ListNode<E> node= this.tail;
		for (int i=0; i<index;i++) {
			node=node.nextNode;
		}
		return node;
	}
	
	private ListNode<E> replaceRight(int index, E newElement) {
		ListNode<E> node= this.tail;
		for (int i=this.size-1; i>index;i--) {
			node=node.lastNode;
		}
		return node;
	}

	public int firstIndexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ListNode<E> binarySearch(int value) {
		int index= (this.getSize()-1)/2;
		ListNode<E> node= this.head;
		for(int i=0; i<index; i++) {
			node=node.nextNode;
		}
		return binarySearch(value, 0, this.getSize()-1, node );
	}

	private ListNode<E> binarySearch(int x, int lb,int ub, ListNode<E> node) {
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
