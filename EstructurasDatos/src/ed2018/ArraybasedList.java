package ed2018;

/**
 * This  is an object that wraps a simple-linked list based on arrays.
 * ArraybasedList works with generic objects as data.
 * This structure extends an abstract List class, and implements all the
 * List' abstract methods.
 * 
 * @author Christian Camilo Cuestas Ibanez
 *
 * @param <E>:	This is a generic class with which the list will work.
 */

public class ArraybasedList<E>  {

	private static final int initialCapacity = 10;
	private int capacity;
	protected int size;
	private E[] list;
	
	@SuppressWarnings("unchecked")
	public ArraybasedList() {
		super();
		this.capacity = ArraybasedList.initialCapacity;
		this.list = (E[] ) new Object[ArraybasedList.initialCapacity];
		this.size=0;
	}
	
	@SuppressWarnings("unchecked")
	public ArraybasedList(int n) {
		super();
		this.capacity = n;
		this.list = (E[] ) new Object[n];
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
	
	public void insertFirst(E element) {
		this.insert(0, element);
	};
	
	public void insert(E element) {
		this.insert(this.getSize(), element);
	}
	
	public E getFirst() {
		return this.get(0);
	}
	
	public E getLast() {
		return this.get(this.getSize()-1);
	}
	
	public E removeFirst() {
		return this.remove(0);
	}
	
	public E removeLast() {
		return this.remove(this.getSize()-1);
	}
	
	public int getCapacity() {
		return capacity;
	}

	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void incrementCapacity() {
		this.capacity= (this.capacity*2)+1;
	}
	
	public E[] getList() {
		return list;
	}

	public void setList(E[] list) {
		this.list = list;
	}

	/**
	 * makeEmpty() forgets the actual list with its inner objects and creates a new void 
	 * array with the initialCapacity. 
	 */
	@SuppressWarnings("unchecked")
	public void makeEmpty() {
		this.setList((E[] ) new Object[ArraybasedList.initialCapacity]);
		this.setSize(0);
		this.setCapacity(ArraybasedList.initialCapacity);
	}

	/**
	 * This is the implementation of general insertion of a linked list based on arrays.
	 * @param	element:	The generic object to be inserted.
	 * @param  	index: 		The array position to which the element must be inserted.
	 * @return  false, if it is impossible to reach the index.
	 * @return	true, when the new element was correctly inserted.
	 */
	@SuppressWarnings("unchecked")
	public boolean insert(int index, E element) {
		if (index>this.size||index<0) return false; 				// If the given index is out of the boundaries, do not insert did not succeed.
															// If the given index is in the boundaries...
		if (this.isEmpty()||(index == this.size && this.capacity > this.size))	// Case 1: When the the array is empty or there is enough space to insert at the end.
			this.list[index]= element;								// Put the element straight in the array.
		else {													// Case 2: There isn't enough space or the insertion isn't at the end.
			if (this.capacity == this.size)									// Check if the array is full.
					this.incrementCapacity();						// If there is no space, so to increment the capacity is needed.		
			E[] newArray = (E[] ) new Object[this.capacity];				// Create a new array with the new capacity to store the actual list plus the new element.
			for(int i=0; i<index; i++)								// Copy the data which have indexes smaller than the index to insert the new element
				newArray[i] = this.list[i];
			newArray[index]=element;								// Put the new element.
			for(int i=index; i<this.size; i++) 							// Copy the rest of existing data.
				newArray[i+1] = this.list[i];	
		}
		this.incrementSize(1);								// Increment the size. 
		return true; 										// ... Insertion succeeded. 
	}

	/**
	 * 
	 * 
	 * @param index:	
	 * @return the element in the index if possible.
	 * @return null when the index does not exist.
	 */
	public E get(int index) {
		if (index<0||index>=this.size) return null;
		return this.list[index];
	}

	/**
	 * 
	 * 
	 * @param index:
	 * @return null, if the index doesn't  exist.
	 * @return the element in the index, other wise.
	 */
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		E removedElement = null;							// Instantiate removedElement with null.
		if (index<this.size&&index>=0) {							// If the index exists:
			if (index == this.size){									// Case 1: When the element to remove is at the end
				removedElement = this.get(index);					// Store the element to remove in removedElement variable.
				this.list[index]= null;								// Set the value of the index as null.
			} else {											// Case 2: When the element to remove isn't at the end.
				E[] newArray = (E[] ) new Object[this.capacity];			// Create a new array with the new capacity to store the actual list minus the deleted element.
				for(int i=0; i<index; i++)							// Copy the data which have indexes smaller than the index of the removed element.
					newArray[i] = this.list[i];
				removedElement = this.get(index);					// Store the element to remove in removedElement variable.
				for(int i=index+1; i<this.size; i++) 					// Copy the rest of existing data, tha is before the deleted element.
					newArray[i+1] = this.list[i];
				this.list = newArray;								// Set the array without the removed element as the list.
			}
			this.decrementSize(1);								// Decrement the size in 1
		}												
		return removedElement; 								// removedElement is returned. 
	}

	/**
	 * 
	 * 
	 * @param index: The position in which is needed the change.
	 * @param newElement: The element to be put.
	 * @return null, if index does not exists.
	 * @return the replaced element, in other case.
	 */
	public E replace(int index, E newElement) {
		if (index<0||index>=this.size) return null;		// Return null if index does not exists.
		E oldElement = this.get(index);							// Other wise, get the element that is in the index position.
		this.getList()[index]=newElement;						// Change the element in the index by the new one.
		return oldElement;										// Return the replaced element.
	}

	/**
	 * 
	 * 
	 * @param element: the element to search in the list.
	 * @return -1 if the element isn't in the list
	 * @return i, the index of the first matching.
	 */
	public int firstIndexOf(E element) {
		for(int i = 0; i<this.size;i++)					// for each element of the list
			if (this.list[i].equals(element)) return i;			// if is equal to the element given as a parameter return the index of the element.
		return -1;												// if there is no matchings, returns -1.
	}
}
