package ed2018;

public class ListNode<T> {
	T element;
	int value;
	ListNode<T> nextNode;
	ListNode<T> lastNode;
	
	public ListNode(T element) {
		super();
		this.element = element;
		this.nextNode = null;
		this.lastNode = null;
		this.value = -1;
	}
	public ListNode(T element, ListNode<T> lastNode,  ListNode<T> nextNode, int value) {
		super();
		this.element = element;
		this.nextNode = nextNode;
		this.lastNode = lastNode;
		this.value = value;
	}
	public T getElement() {
		return element;
	}
	public int getValue() {
		return value;
	}
	public ListNode<T> getNextNode() {
		return nextNode;
	}
	public ListNode<T> getLastNode() {
		return lastNode;
	}
	@Override
	public String toString(){
		return "["+ element.toString() +"]" + "\n";
	}
	
	public ListNode<T> clone(){
		return new ListNode<T>(this.element, this.lastNode.clone(), this.nextNode.clone(),this.value);
	}
}
