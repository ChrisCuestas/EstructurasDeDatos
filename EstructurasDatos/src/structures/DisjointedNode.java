package structures;

public class DisjointedNode<T extends Comparable<T>> extends Node<T> implements Comparable<DisjointedNode<T>>{

	
	DisjointedNode<T> rep;
	
	public DisjointedNode(T element, Node<T> nextNode, DisjointedNode<T> rep) {
		super(element, nextNode);
		this.rep= rep;
	}
	
	public T getRep() {
		return this.rep.element;
	}

	@Override
	public int compareTo(DisjointedNode<T> o) {
		return this.element.compareTo(o.getElement());
	}
	
}
