package ed2018.strings;

import ed2018.ListNode;

public class StringNode extends ListNode<Character>{

	/*
	 * 
	 */
	char character;
	ListNode<Character> next = null;
	
	public StringNode(char character) {
		super(character);
		this.character = character;
	}

	public void setNext(ListNode<Character> node) {
		this.next = node;
	}

	public ListNode<Character> getNext() {
		return this.next;
	}

	public ListNode<Character> clone() {
		StringNode clone = new StringNode(this.character);
		return clone;
	}

	public boolean isEqual(ListNode<Character> node){
		StringNode temp = (StringNode) node;
		return temp.character == this.character ? true : false;
	}

	public boolean isLessThan(ListNode<Character> node) {
		StringNode temp = (StringNode) node;
		return (int)this.character < (int)temp.character ? true : false;
	}
}

