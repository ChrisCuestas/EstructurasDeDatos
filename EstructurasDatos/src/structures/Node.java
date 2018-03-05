package structures;

public class Node<T> {
	T element;
	Node<T> nextNode;
	public Node(T element, Node<T> nextNode) {
		super();
		this.element = element;
		this.nextNode = nextNode;
	}
	public T getElement() {
		return element;
	}
	public Node<T> getNextNode() {
		return nextNode;
	}
}