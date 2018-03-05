package obrasDeArte;

import structures.*;

public class Galery {
	
	private DisjointedSet<BinarySearchTree<Integer>>[] salones;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Galery() {
		super();
		this.salones = (DisjointedSet<BinarySearchTree<Integer>>[]) new Object[10];
		this.size = 0;
	}
	
	public DisjointedSet<BinarySearchTree<Integer>>[] getSalones() {
		return salones;
	}

	public void setSalones(DisjointedSet<BinarySearchTree<Integer>>[] salones) {
		this.salones = salones;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@SuppressWarnings("unchecked")
	public void add(BinarySearchTree<Integer> element) {
		for(DisjointedSet<BinarySearchTree<Integer>> s: salones) {
			if(this.compareNodes(s.getHead().getElement().getRoot(), element.getRoot())) {
				s.insert(element);
				return;
			}
		}
		if(this.salones.length==size) {
			DisjointedSet<BinarySearchTree<Integer>>[] sls =(DisjointedSet<BinarySearchTree<Integer>>[]) new Object[size*2+1];
			int c=0;
			for(DisjointedSet<BinarySearchTree<Integer>> s: salones) {
				sls[c]=s;
				c++;
			}
			salones= sls;
		}
		DisjointedSet<BinarySearchTree<Integer>> newSalon = new DisjointedSet<BinarySearchTree<Integer>>();
		newSalon.insert(element);
		salones[size]= newSalon;
		size++;
	}

	private boolean compareNodes(BinaryNode<Integer> root1, BinaryNode<Integer> root2) {
		if(root1==null) {
			if(root2==null) {
				return true;
			}else return false;
		}
		
		if(root2==null) {
			if(root1!=null) {
				return false;
			}
		}
		return compareNodes(root1.getLeft(),root2.getLeft())&&compareNodes(root1.getRight(),root2.getRight());
	}
}
