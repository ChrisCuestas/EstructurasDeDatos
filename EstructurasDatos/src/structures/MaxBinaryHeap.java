package structures;

public class MaxBinaryHeap<T extends Comparable<T>> extends BinaryHeap<T> {

	public MaxBinaryHeap() {
		super();
	}

	public MaxBinaryHeap(int capacity) {
		super(capacity);
	}

	@Override
	public void insert(T data) {
		
		if (super.isEmpty()) {
			//System.out.println("El sistema no tiene ninguna solicitud, agrega a la primera posición");
			this.getArray()[1]=data;
			this.setSize(1);
		}
		else {
			//System.out.println("El sistema tiene solicitudes, agrega la solicitud dependiendo de la prioridad");
			int s=getSize();
			T[] array = super.getArray();
			if(s==array.length) {
				@SuppressWarnings("unchecked")
				T[] newArray = (T[]) new Object[s*2+1];
				int index=0;
				for(T d: array) {
					newArray[index]=d;
					index++;
				}
				super.setArray(newArray);
			}
			super.setSize(s+1);
			s=super.getSize();
			array[s]=data;	
			this.percolateUp(s);
		}
		
		
	}

	@Override
	public void percolateUp(int index) {
		if (index==1) return;
		else {
			T data= super.find(index);
			T parent = super.find(index/2);
			if(data.compareTo(parent)==1) {
				super.replace(index/2, data);
				super.replace(index, parent);
				this.percolateUp(index/2);
			}
		}
	}

	@Override
	public void percolateDown(int index) {
		if (index*2+1>this.getSize())return; //Para nodos hojas
		else if (index*2==this.getSize()) {//Para ultimo nodo que es padre y que tiene solo un hijo
			
				
			
		} else {//Para nodos padres de dos hijos
			T data = this.find(index);
			T left = this.find(index*2);
			T right = this.find((index*2)+1);
			T mayor;
			int mayorLeftOrRight;
			if (left.compareTo(right)==-1) {
				mayor= left; 
				mayorLeftOrRight = -1;
			}
			else {
				mayor= right;
				mayorLeftOrRight= 1;
			}
			
			if(data.compareTo(mayor)>=0) return;
			else {
				this.replace(index, mayor);
				if(mayorLeftOrRight==1) {
					this.replace((index*2)+1, data);
					this.percolateDown((index*2)+1);
				}
				else {
					this.replace(index*2, data);
					this.percolateDown(index*2);
				}
				
			} 
		}
	}

	public T deleteMax() {
		if(super.isEmpty()) {
			//System.out.println("El sistema registra que está vacío");
			return null;
		}
		if(super.getSize()==1) {
			//System.out.println("El sistema registra que tiene una sola solicitud");
			return this.remove(1);
		}
		else {
			//System.out.println("El sistema registra más de una solicitud, se entrega el de mayor prioridad");
			T max= this.find(1);
			this.replace(1,this.deleteMin());
			this.percolateDown(1);
			return max;
		}
	}
	
	

	public T findMax() {
		return super.find(1);
	}

	@Override
	public T remove(int index) {
		T data = this.getArray()[index];
		this.getArray()[index]=null;
		this.setSize(this.getSize()-1);
		return data;
	}

	@Override
	public T deleteMin() {
		return this.remove(getSize());
	}

}
