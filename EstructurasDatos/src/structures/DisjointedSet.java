package structures;

public class DisjointedSet<T extends Comparable<T>> {

	private int size;
	private DisjointedNode<T> head;
	private DisjointedNode<T> tail;

	
	public DisjointedSet() {
		super();
		this.size = 0;
		this.head = this.tail = null;
		
	}
	public int getSize() {
		return size;
	}
	public boolean setSize(int size) {
		this.size = size;
		return true;
	}

	public DisjointedNode<T> getHead() {
		return head;
	}

	public void setHead(DisjointedNode<T> head) {
		this.head = head;
	}

	public DisjointedNode<T> getTail() {
		return tail;
	}

	public void setTail(DisjointedNode<T> tail) {
		this.tail = tail;
	}
	
	public void makeEmpty() {
		this.setHead(null);
		this.setTail(null);
		this.setSize(0);
	}
	public boolean isEmpty() {
		return this.getSize()==0;
	}
	public T find(int k) {
		if (this.getSize()!=0) {
			DisjointedNode<T> node=this.getHead();
			if(k<this.getSize()) {
				for(int i=0;i<k;i++) {
					node=(DisjointedNode<T>) node.nextNode;
				}
				return node.element;
			}
			return null;
		}else {
			return null;
		}
	}
	
	private boolean insert(int k, T element) {
		if(k==0) {
			DisjointedNode<T> newNode= new DisjointedNode<T>(element,this.getHead(),null);
			this.setHead(newNode);
			newNode.rep=newNode;
			this.setSize(1);
			return true;
		}else if(k>0 && k<this.getSize()) {
			DisjointedNode<T> lastNode=this.getHead();
			for(int i=0;i<k-1;i++) {
				lastNode=(DisjointedNode<T>) lastNode.nextNode;
			}
			DisjointedNode<T> newNode= new DisjointedNode<T>(element,lastNode.nextNode, this.getHead());
			lastNode.nextNode=newNode;
			this.setSize(this.getSize()+1);
			return true;
		}else if(k==this.getSize()){
			DisjointedNode<T> newNode= new DisjointedNode<T>(element,null,this.getHead());
			this.getTail().nextNode= newNode;
			//costoInsert=costoInsert+k;
			this.setTail(newNode);
			this.setSize(this.getSize()+1);
			return true;
		}else return false;
	}
	
	public boolean insert(T element) {
		return insert(this.getSize(),element);
	}
	
	public int indexOf(T element) {
		if (this.getSize()!=0) {
			Node<T> node=this.getHead();
			for(int i=0;i<getSize();i++) {
				if(node.element.equals(element))return i;
				node=node.nextNode;
			}
			return -1;
		}else {
			return -1;
		}
	}
}
