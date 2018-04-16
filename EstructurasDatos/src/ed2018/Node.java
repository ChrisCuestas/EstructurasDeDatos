package ed2018;

public class Node<T> {
	T element;
	int value;
	Node<T> nextNode;
	public Node(T element, Node<T> nextNode, int value) {
		super();
		this.element = element;
		this.nextNode = nextNode;
		this.value = value;
	}
	@Override
	public String toString(){
		return "["+ element.toString() +"]" + "\n";
	}
	
	public Node<T> clone(){
		return new Node<T>(this.element, this.nextNode.clone(),this.value);
	}
}
