package ed2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This  is an object that wraps a simple-linked list based on nodes.
 * LinkedList works with generic objects as data.
 * This structure extends an abstract List class, and implements all the
 * List' abstract methods.
 * The positions of the list are taken from 0 to size-1.
 * 
 * @author Christian Camilo Cuestas Ibanez
 *
 * @param <E>:	This is a generic class with which the list will work.
 */

public class LinkedList<E> {

	protected int size;
	ListNode<E> head;

	public LinkedList() {
		super();
		this.head = null;
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

	public ListNode<E> getHead() {
		return head;
	}

	public void setHead(ListNode<E> head) {
		this.head = head;
	}

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
	public boolean insert(int index, E element, int value) {
		if (index>this.size||index<0) return false; 				// If the given index < 0 or index > size, do not insert.
		ListNode<E> newNode = new ListNode<E>(element, null, null, value);			// Else create a new node that wraps the element.
		if (this.isEmpty()||index==0) {								// Special Case: When the list is empty or the element goes to the first position.
			newNode.nextNode=this.head;									// The new node is linked with the actual head.
			this.setHead(newNode);										// Updates the head, that is needed to point to the new node.
		}else {														//Otherwise:
			ListNode<E> node = this.head;									// Set a node variable that initially points to the first node.
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
	public ListNode<E> get(int index) {
		if (index>this.size-1||index<0) return null; 				// If the given index < 0 or index > size-1, do nothing.
		ListNode<E> node = this.getHead();
		for(int i=0; i<index; i++)
			node=node.nextNode;
		return node;
	}

	/**
	 * 
	 * 
	 * @param
	 * @return
	 * @return
	 */
	public E remove(int index) {
		if (index>this.size-1||index<0) return null; 				// If the given index < 0 or index > size-1, do nothing.
		E oldElement;
		if (index==0) {
			oldElement = this.getHead().element;
			this.setHead(this.getHead().nextNode);
		} else {
			ListNode<E> node = this.getHead();
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
	public E replace(int index, E newElement) {
		if (index>this.size-1||index<0) return null; 				// If the given index < 0 or index > size-1, do nothing.
		ListNode<E> node = this.getHead();
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
	public int firstIndexOf(E element) {
		ListNode<E> node= this.getHead();
		for(int i=0; i<this.size;i++) {
			if(node.element.equals(element)) return i;
			node= node.nextNode;
		}	
		return -1;
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
					node =  this.head;
					for(int i=0; i>(middleIndex+lb)/2; i++) {
						node=node.nextNode;
					}
					return binarySearch(x,lb,middleIndex-1, node);
				}
			}
			
		} else return null;
	}
	
	public void quickSort() {
		if(this.size>1) {
				quickSort(0, this.size-1);		
		}
	}
	
	private void quickSort(int start, int end) {
		int pivot=start;
		for(int i=pivot; i<end; i++) 
			if(this.get(i).value<=this.get(i+1).value) 
				pivot++;
			else break;
		if(pivot<end) {
			int storeIndex = pivot+1;
			for(int i=pivot+1; i<end+1; i++) {
				if(this.get(i).value<this.get(pivot).value) {
					swap(i,storeIndex);
					storeIndex++;
				}
			}
			swap(pivot,storeIndex-1);
			quickSort(start,storeIndex-1);
			quickSort(storeIndex,end);
		}
	}
	
	private void swap(int a, int b) {
		if(a!=b) {
			ListNode<E> nodeA = this.get(a);
			ListNode<E> nodeB = this.get(b);
			
			E elementA = nodeA.element;
			int valueA = nodeA.value;
			E elementB = nodeB.element;
			int valueB = nodeB.value;
			
			nodeA.element=elementB;
			nodeA.value=valueB;
			nodeB.element=elementA;
			nodeB.value=valueA;
		}
	}

	public void printList() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ListNode<E> temp = this.head;
		
		try {
			bw.write("Elements:\n");
			while (temp!=null){
				bw.write(temp.toString());
				temp = temp.nextNode;
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reverse() {
		LinkedStack<E> tempStack= new LinkedStack<E>();
		ListNode<E> temp = this.head;
		
		while(temp!=null) {
			ListNode<E> clone=temp.clone();
			tempStack.push(clone.element,clone.value);
			temp=temp.nextNode;
		}
		this.head=tempStack.getHead();
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> qs;
		
		try {
			String[] newString = br.readLine().split(","); 
			br.close();
			
			int newSize= newString.length;
			qs = new LinkedList<Integer>();
			for(int i=0; i<newSize; i++) {
				int value=Integer.parseInt(newString[i]);
				qs.insert(value,value);
			}
			
			qs.quickSort();
			
			qs.printList();
			bw.flush();
			
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

