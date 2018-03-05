package structures;

public class ArrayBasedList<E> implements List<E> {
	
	private E[] array;
	private int size;

	/*//Costos
	private int costoGetSize;
	private int costoSetSize;
	private int costoMakeEmpty;
	private int costoIsEmpty;
	private int costoFind;
	private int costoInsert;
	private int costoInsertAfter;
	private int costoInsertBeginning;
	private int costoInsertLast;
	private int costoReplace;
	private int costoRemoveWithIndex;
	private int costoRemoveElement;
	private int costoIndexOf;*/
	
	@SuppressWarnings("unchecked")	
	public ArrayBasedList(int size) {
		super();
		this.array = (E[] ) new Object[size];
		this.size = size;
		/*this.costoGetSize = 0;
		this.costoSetSize = 0;
		this.costoMakeEmpty = 0;
		this.costoIsEmpty = 0;
		this.costoFind = 0;
		this.costoInsert = 0;
		this.costoInsertAfter = 0;
		this.costoInsertBeginning = 0;
		this.costoInsertLast = 0;
		this.costoReplace = 0;
		this.costoRemoveWithIndex = 0;
		this.costoRemoveElement = 0;
		this.costoIndexOf = 0;*/
	}

	public void setArray(E[] array) {
		this.array = array;
	}

	@Override
	public int getSize() {
		return size;
	}


	public boolean setSize(int newSize) {
		if(newSize>this.getSize()) {
			@SuppressWarnings("unchecked")
			E[] newArray = (E[] ) new Object[newSize];
			int index=0;
			for(E d: array) {
				newArray[index]=d;
				index++;
			}
			this.setArray(newArray);
			this.size=newSize;
			return true;
		} else return false;
	}

	/*public int getCostoGetSize() {
		return costoGetSize;
	}

	public int getCostoSetSize() {
		return costoSetSize;
	}

	public int getCostoMakeEmpty() {
		return costoMakeEmpty;
	}

	public int getCostoIsEmpty() {
		return costoIsEmpty;
	}

	public int getCostoFind() {
		return costoFind;
	}

	public int getCostoInsert() {
		return costoInsert;
	}

	public int getCostoInsertAfter() {
		return costoInsertAfter;
	}

	public int getCostoInsertBeginning() {
		return costoInsertBeginning;
	}

	public int getCostoInsertLast() {
		return costoInsertLast;
	}

	public int getCostoReplace() {
		return costoReplace;
	}

	public int getCostoRemoveWithIndex() {
		return costoRemoveWithIndex;
	}

	public int getCostoRemoveElement() {
		return costoRemoveElement;
	}

	public int getCostoIndexOf() {
		return costoIndexOf;
	}*/

	@Override
	public boolean isEmpty() {
		//costoIsEmpty=0;
		boolean a = (getSize()==0);
		//costoIsEmpty=costoGetSize+1;
		return a;
	}

	@Override
	public E find(int k) {
		//costoFind=0;
		int s=getSize();
		if(k<0 || k>s-1) {
			return null;
		}else {
			return array[k];
		}
	}
	
	@Override
	public void makeEmpty() {
		//costoIsEmpty=1;
		setSize(0);
		for(int i=0; i<size; i++) {
			//costoIsEmpty++;
			array[i]=null;
		}
	}

	@Override
	public boolean insert(int k, E element) {
		//costoInsert=0;
	    @SuppressWarnings("unchecked")
		E[] newArray = (E[] ) new Object[size+1];
	    int s=getSize();
		if(s==0 && k==0) {
			newArray[0]=element;
			array=newArray;
			setSize(1);
			return true;
		}else if(s==0 && k!=0) {
			return false;
		}else if(k>-1 && k<s) {
			for(int i=0;i<k;i++) {
				//costoInsert++;
				newArray[i]=array[i];
			}
			newArray[k]=element;
			for(int i=k+1; i<s+1;i++) {
				//costoInsert++;
				newArray[i]=array[i-1];
			}
			array=newArray;
			setSize(s+1);
			return true;
		}else if(k==s) {
			for(int i=0;i<k;i++) {
				newArray[i]=array[i];
			}
			newArray[k]=element;
			array=newArray;
			setSize(s+1);
			return true;
		}else return false;
	}

	@Override
	public boolean insertAfter(int k, E element) {
		boolean a=insert(k,element);
		//costoInsertAfter=costoInsert;
		return a;
	}

	@Override
	public void insertBeginning(E element) {
		insert(0,element);
		//costoInsertBeginning=costoInsert;
	}

	@Override
	public void insertLast(E element) {
		insert(getSize(),element);
		//costoInsertLast=costoInsert;
	}

	@Override
	public boolean replace(int k, E element) {
		int s= getSize();
		//costoReplace=costoGetSize;
		if(k>0 && k<s) {
			array[k]=element;
			//costoReplace++;
			return true;
		} else return false;
	}

	@Override
	public E remove(int k) {
	    //costoRemoveWithIndex=0;
		int s = getSize();
		@SuppressWarnings("unchecked")
		E[] newArray = (E[] ) new Object[s-1];
		if(s==0) return null;
		if(k<0 || k>s-1) {
			return null;
		}else {
			for(int i=0;i<k;i++) {
				//costoRemoveWithIndex++;
				newArray[i]=array[i];
			}
			E element=array[k];
			for(int i=k+1; i<s;i++) {
				//costoRemoveWithIndex++;
				newArray[i-1]=array[i];
			}
			array=newArray;
			setSize(s-1);
			return element;
		}
	}

	@Override
	public boolean remove(E element) {
		//costoRemoveElement=0;
		int index= indexOf(element);
		//costoRemoveElement=costoIndexOf;
		if(index<0) {
			//costoRemoveElement++;
			return false;
		}
		else {
			if (remove(index)!=null) {
				//costoRemoveElement++;
				return true;
			}
			else return false;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public int indexOf(E element) {
		//costoIndexOf=0;
		for(int i=0; i<getSize();i++) {
			//costoIndexOf++;
			if(element.equals(array[i])) return i;
		}
		return -1;
	}
}
