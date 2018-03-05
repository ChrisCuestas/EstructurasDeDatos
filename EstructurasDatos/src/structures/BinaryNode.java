package structures;

public class BinaryNode<T extends Comparable<T>> implements Comparable<BinaryNode<T>>{
	
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

	@Override
	public int compareTo(BinaryNode<T> o) {
		return this.data.compareTo(o.getData());
	}
	

}
