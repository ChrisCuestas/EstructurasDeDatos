package structures;

public class LinkedList<T> implements List<T>{
	
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
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
	
	public LinkedList() {
		super();
		this.size = 0;
		this.head = this.tail = null;
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
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean setSize(int size) {
		this.size = size;
		return true;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
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
	public String toString() {
		
		return null;
	}
	@Override
	public void makeEmpty() {
		this.setHead(null);
		this.setTail(null);
		this.setSize(0);
	}
	@Override
	public boolean isEmpty() {
		return this.getSize()==0;
	}
	@Override
	public T find(int k) {
		//costoFind=0;
		if (this.getSize()!=0) {
			Node<T> node=this.getHead();
			if(k<this.getSize()) {
				for(int i=0;i<k;i++) {
					//costoFind++;
					node=node.nextNode;
				}
				return node.element;
			}
			return null;
		}else {
			return null;
		}
	}
	public Node<T> findNode(int k) {
		if (this.getSize()!=0) {
			Node<T> node=this.getHead();
			if(k<this.getSize()) {
				for(int i=0;i<k-1;i++) {
					node=node.nextNode;
				}
				return node;
			}
			return null;
		}else {
			return null;
		}
	}
	@Override
	public boolean insert(int k, T element) {
		//costoInsert=0;
		if(k==0) {
			Node<T> newNode= new Node<T>(element,this.getHead());
			this.setHead(newNode);
			this.setSize(this.getSize()+1);
			return true;
		}else if(k<this.getSize()+1) {
			Node<T> lastNode=this.getHead();
				//costoInsert++;
			for(int i=0;i<k-1;i++) {
				//costoInsert++;
				lastNode=lastNode.nextNode;
			}
			Node<T> newNode= new Node<T>(element,lastNode.nextNode);
			lastNode.nextNode=newNode;
			this.setSize(this.getSize()+1);
			return true;
		}else if(k==this.getSize()+1){
			Node<T> newNode= new Node<T>(element,null);
			this.getTail().nextNode= newNode;
			//costoInsert=costoInsert+k;
			this.setTail(newNode);
			this.setSize(this.getSize()+1);
			return true;
		}else return false;
	}
	@Override
	public boolean insertAfter(int k, T element) {
		if(!isEmpty()) {
			Node<T> actualNode = this.findNode(k);
			Node<T> newNode= new Node<T>(element,actualNode.nextNode);
			if(actualNode.nextNode==null) {
				this.setTail(newNode);
			}
			actualNode.nextNode=newNode;
			this.setSize(this.getSize()+1);
			return true;
		}else return false;	
	}
	@Override
	public void insertBeginning(T element) {
		Node<T> newNode = new Node<T>(element,null);
		if(this.isEmpty()) {
			this.setTail(newNode);
		}else {
			newNode.nextNode=this.getHead();
		}
		this.setSize(this.getSize()+1);
		this.setHead(newNode);
	}
	@Override
	public void insertLast(T element) {
		Node<T> newNode = new Node<T>(element, null);
		if(isEmpty()) {
			this.setHead(newNode);
		}else {
			this.getTail().nextNode=newNode;
		}
		this.setSize(this.getSize()+1);
		this.setTail(newNode);
	}
	@Override
	public boolean replace(int k, T element) {
		if(k<this.getSize()-1) {
			Node<T> lastNode=this.getHead();
			for(int i=0;i<k;i++) {
				lastNode=lastNode.nextNode;
			}
			lastNode.element=element;
			return true;
		}else if(k==this.getSize()-1){
			this.getTail().element= element;
			return true;
		}else return false;
	}

	@Override
	public T remove(int k) {
		//costoRemoveWithIndex=0;
		if(k<this.getSize()) {
			Node<T> lastNode=this.getHead();
			if (k==0) {
				this.setHead(lastNode.nextNode);
				this.setSize(getSize()-1);
				return lastNode.element;
			}else {
				for(int i=0;i<k-1;i++) {
					//costoRemoveWithIndex++;
					lastNode=lastNode.nextNode;
				}
				T removedElement=lastNode.nextNode.element;
				lastNode.nextNode=lastNode.nextNode.nextNode;
				this.setSize(getSize()-1);
				return removedElement;
			}
		}else return null;
	}

	@Override
	public boolean remove(T element){
		int index =indexOf(element);
		if(index>=0) {
			if(remove(index)!=null) return true;
			else return false;
		}
		return false;
	}

	@Override
	public int indexOf(T element) {
		//costoIndexOf=0;
		//System.out.println(size);
		if (this.getSize()!=0) {
			//costoIndexOf++;
			Node<T> node=this.getHead();
			for(int i=0;i<getSize();i++) {
				if(node.element.equals(element))return i;
				//costoIndexOf++;
				node=node.nextNode;
			}
			//costoIndexOf--;
			return -1;
		}else {
			return -1;
		}
	}
	
}
