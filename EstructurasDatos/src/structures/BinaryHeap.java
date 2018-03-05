package structures;

public abstract class BinaryHeap<T extends Comparable<T>> {
	
	private static final int DEFAULT_CAPACITY=10;
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public BinaryHeap() {
		super();
		this.array =  (T[]) new Comparable[DEFAULT_CAPACITY+1];
		this.array[0]=null;
		this.size = 0;		
	}
	
	@SuppressWarnings("unchecked")
	public BinaryHeap(int capacity) {
		super();
		this.array = (T[] ) new Object[capacity+1];
		this.array[0]=null;
		this.size = 0;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	public int getSize() {
		return size;
	}

	public T[] getArray() {
		return array;
	}

	public static int getDefaultCapacity() {
		return DEFAULT_CAPACITY;
	}
	
	public void setSize(int newSize) {
		this.size=newSize;
	}
	
	public boolean isEmpty() {
		return this.getSize()==0;
	}
	
	public T find(int index) {
		if(index<1 || index>this.getSize()) {
			return null;
		}else {
			return array[index];
		}
	}
	
	@SuppressWarnings("unchecked")
	public void makeEmpty() {
		setSize(0);
		this.array =  (T[]) new Object[DEFAULT_CAPACITY+1];
		array[0]=null;
	}
	
	/*public boolean insert(T data) {
		int s=getSize();
		if(s==array.length) {
			@SuppressWarnings("unchecked")
			T[] newArray = (T[] ) new Object[size*2+1];
			int index=0;
			for(T d: array) {
				newArray[index]=d;
			}
			array=newArray;
		}
		if(s==0 && k==1) {
			array[k]=data;
			setSize(1);
			return true;
		}else if(s==0 && k!=1) {
			return false;
		}else if(k>0 && k<s+1) {
			for(int i=0;i<k;i++) {
				newArray[i]=array[i];
			}
			newArray[k]=data;
			for(int i=k+1; i<s+2;i++) {
				newArray[i]=array[i-1];
			}
			array=newArray;
			setSize(s+1);
			return true;
		}else if(k==s+1) {
			for(int i=0;i<k;i++) {
				newArray[i]=array[i];
			}
			newArray[k]=data;
			array=newArray;
			setSize(s+1);
			return true;
		}else return false;
	}*/
	
	public boolean replace(int index, T element) {
		if(index<1 && index>this.getSize()) return false;
		else {
			array[index]=element;
			return true;
		}
	}
	
	public abstract T remove(int index) ;
	
	public abstract void insert(T data);
	
	public abstract void percolateUp(int index) ;
	
	public abstract void percolateDown(int index);
	
	public abstract T deleteMax();
	
	public abstract T deleteMin();
	
}
