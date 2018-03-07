package data;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * This is an generic and abstract list, that implements attributes and methods 
 * that are invariable regarded to a particular implementation. Also, it has the basic
 * abstract methods that each implementation must implement.
 * 
 * @author Christian Camilo Cuestas Ibáñez
 *
 * @param <E> the type of object to store in the list.
 */

abstract class List<E> {

	protected int size;
	
	public List() {
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
	
	public abstract void makeEmpty();
	
	public abstract boolean insert(int index, E element);
	
	public void insertFirst(E element) {
		this.insert(0, element);
	};
	
	public void insert(E element) {
		this.insert(this.getSize(), element);
	}
	
	public abstract E get(int index);
	
	public E getFirst() {
		return this.get(0);
	}
	
	public E getLast() {
		return this.get(this.getSize()-1);
	}
	
	public abstract E remove(int index);
	
	public E removeFirst() {
		return this.remove(0);
	}
	
	public E removeLast() {
		return this.remove(this.getSize()-1);
	}
	
	public abstract E replace(int index, E newElement);
	
	public abstract int firstIndexOf(E element);
}

/**
 * This  is an object that wraps a simple-linked list based on nodes.
 * LinkedList works with generic objects as data.
 * This structure extends an abstract List class, and implements all the
 * List' abstract methods.
 * The positions of the list are taken from 0 to size-1.
 * 
 * @author Christian Camilo Cuestas Ibáñez
 *
 * @param <E>:	This is a generic class with which the list will work.
 */

public class LinkedList<E> extends List<E> {

	class Node<T> {
		T element;
		Node<T> nextNode;
		public Node(T element, Node<T> nextNode) {
			super();
			this.element = element;
			this.nextNode = nextNode;
		}
		@Override
		public String toString(){
			return "["+ element.toString() +"]" + "\n";
		}
	}
	
	Node<E> head;

	public LinkedList() {
		super();
		this.head = null;
	}

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	@Override
	public void makeEmpty() {
		this.setHead(null);
		this.setSize(0);
	}

	/**
	 * This is the implementation of general insertion of a linked list based on nodes.
	 * @param	element:	The generic object to be inserted.
	 * @param  	index: 		The position to which the element must be inserted.
	 * @return  false, if it is impossible to reach the index.
	 * @return	true, when the new element was correctly inserted.
	 */
	@Override
	public boolean insert(int index, E element) {
		if (index>this.size||index<0) return false; 				// If the given index < 0 or index > size, do not insert.
		Node<E> newNode = new Node<E>(element, null);				// Else create a new node that wraps the element.
		if (this.isEmpty()||index==0) {								// Special Case: When the list is empty or the element goes to the first position.
			newNode.nextNode=this.head;									// The new node is linked with the actual head.
			this.setHead(newNode);										// Updates the head, that is needed to point to the new node.
		}else {														//Otherwise:
			Node<E> node = this.head;									// Set a node variable that initially points to the first node.
			for(int i=0;i<index-1;i++)									// Changes the variable to the last node before the insertion position, if necessary.
				node=node.nextNode;
			newNode.nextNode= node.nextNode;							// The new node is linked with the next node of the variable node.
			node.nextNode=newNode;										// Updates the variable node, that is needed to point to the new node.
		}
		this.incrementSize(1);										// Increment the size in all the cases of insertion. 
		return true;												// Insertion succeeded.
	}

	/**
	 * The method get returns the element at the certain index, if index exists.
	 * 
	 * @param index: the position of the object to get.
	 * @return null, if the index doesn't exist.
	 * @return E, the element wrapped in the node in the index.
	 */
	@Override
	public E get(int index) {
		if (index>this.size-1||index<0) return null; 				// If the given index < 0 or index > size-1, do nothing.
		Node<E> node = this.getHead();
		for(int i=0; i<index; i++)
			node=node.nextNode;
		return node.element;
	}

	/**
	 * 
	 * 
	 * @param
	 * @return
	 * @return
	 */
	@Override
	public E remove(int index) {
		if (index>this.size-1||index<0) return null; 				// If the given index < 0 or index > size-1, do nothing.
		E oldElement;
		if (index==0) {
			oldElement = this.getHead().element;
			this.setHead(this.getHead().nextNode);
		} else {
			Node<E> node = this.getHead();
			for(int i=0; i<index-1; i++)
				node=node.nextNode;
			oldElement= node.nextNode.element;
			node.nextNode=node.nextNode.nextNode;
		}
		this.decrementSize(1);
		return oldElement;
	}

	/**
	 * 
	 * 
	 * @param
	 * @param
	 * @return
	 * @return
	 */
	@Override
	public E replace(int index, E newElement) {
		if (index>this.size-1||index<0) return null; 				// If the given index < 0 or index > size-1, do nothing.
		Node<E> node = this.getHead();
		for(int i=0; i<index; i++)
			node=node.nextNode;
		E oldElement = node.element;
		node.element=newElement;
		return oldElement;
	}

	/**
	 * 
	 * @param
	 * @return
	 * @return
	 */
	@Override
	public int firstIndexOf(E element) {
		Node<E> node= this.getHead();
		for(int i=0; i<this.size;i++) {
			if(node.element.equals(element)) return i;
			node= node.nextNode;
		}	
		return -1;
	}	
	
	public void printList() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Node<E> temp = this.head;
		
		try {
			bw.write("Grades:\n");
			while (temp!=null){
				bw.write(temp.toString());
				temp = temp.nextNode;
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

