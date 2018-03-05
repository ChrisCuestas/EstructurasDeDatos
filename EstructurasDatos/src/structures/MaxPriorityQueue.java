package structures;

public class MaxPriorityQueue<T extends Comparable<T>> extends MaxBinaryHeap<T> {

	public MaxPriorityQueue(int capacity) {
		super(capacity);
	}

	public MaxPriorityQueue() {
		super();
	}
	
	public void insert(T data) {
		super.insert(data);
	}

	public T deleteMax() {
		return super.deleteMax();
	}
	
	public T findMax() {
		return super.findMax();
	}
}
