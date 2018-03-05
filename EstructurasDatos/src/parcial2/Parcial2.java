package parcial2;

import java.util.*;
	
class ColaPrioridad<T extends Comparable<? super T>>{

    T[] Heap;
    int size;

    @SuppressWarnings("unchecked")
	public ColaPrioridad(int CapacidadInicial){
        if(CapacidadInicial < 1)throw new IllegalArgumentException("La capacidad inicial debe ser mayor o igual a 1");
        Heap = ( T[] ) new Comparable[ CapacidadInicial + 1];
        size = 0;
    }

    public ColaPrioridad(){
        this(10);
    }

    public boolean vacio(){
        return size == 0;
    }

    public int tamano(){
        return size;
    }

    public T obtenerMin(){
        return (size == 0) ? null : Heap[1];
    }

    public void updatePriority(T objeto) {
    	int index=1;
    	T menor;
		int izqDer=Heap[index*2].compareTo(Heap[index*2+1]);
		if(izqDer<0) menor= Heap[index*2];
		else menor= Heap[index*2+1];
    	if(objeto.compareTo(menor) >= 0) {
	    	while(index*2 < size){
				izqDer=Heap[index*2].compareTo(Heap[index*2+1]);
				if(izqDer<0) menor= Heap[index*2];
				else menor= Heap[index*2+1];
				if(objeto.compareTo(menor) >= 0) {
					Heap[index] = menor;
					if(izqDer<=0) index=index*2;
					else index= index*2+1;
				}
	        }
			if(index*2==size && objeto.compareTo(Heap[index*2]) >= 0) {
				Heap[index] = Heap[index*2];
				index=index*2;
			}
    	}
		Heap [index] = objeto;
    }
    @SuppressWarnings("unchecked")
	public void insertar(T Objeto ){
    	//System.out.println("inserto");
        if(size == Heap.length - 1){ // El arreglo está lleno
            T[] old = Heap;
            Heap = (T[]) new Comparable[2 * Heap.length];
			for(int i = 0; i <= size; i++){
				Heap[i] = old[i];
			}
        }
        int Nodo = ++size;
        while(Nodo != 1 && Heap[Nodo / 2].compareTo(Objeto) > 0){
            Heap[Nodo] = Heap[Nodo / 2];
            Nodo /=2;
        }
        Heap [Nodo] = Objeto;
        //toStringHeap();
    }
	
	public T borrarMin(){
		//System.out.println("elimino");
		T lastNode = Heap[size];
		Heap[size]=null;
		T minimo = obtenerMin();
		size= size-1;
		int index = 1;
		while(index*2 < size){
			T menor;
			int izqDer=Heap[index*2].compareTo(Heap[index*2+1]);
			if(izqDer<0) menor= Heap[index*2];
			else menor= Heap[index*2+1];
			if(lastNode.compareTo(menor) >= 0) {
				Heap[index] = menor;
				if(izqDer<=0) index=index*2;
				else index= index*2+1;
			}
        }
		if(index*2==size && lastNode.compareTo(Heap[index*2]) >= 0) {
			Heap[index] = Heap[index*2];
			index=index*2;
		}
		Heap [index] = lastNode;
		//toStringHeap();
		return minimo;
	}
	
	public void toStringHeap() {
		System.out.println();
		for(int i=1; i<size+1; i++) {
			System.out.print(Heap[i].toString()+" ");
		}
		System.out.println();
	}
}

class Curso implements Comparable<Curso>{
	
	int id;
	Object[] estudiantes;
	int size;
	double c;
	
	public Curso(int id) {
		this.estudiantes= new Object[10];
		this.size=0;
		this.id=id;
		updateC();
		//System.out.println("El curso "+id+" tiene "+c);
	}
	
	public Curso(Object[] estudiantes, int size, int id) {
		
		this.estudiantes=estudiantes;
		this.size=size;
		this.id= id;
		updateC();
		//System.out.println("El curso "+id+" tiene "+c);
	}
	
	public void addStudent(double est) {
		if(this.size==this.estudiantes.length) {
			Object[] arr=  new Object[this.estudiantes.length*2+1];
			for(int i=0; i<size;i++) {
				arr[i]=this.estudiantes[i];
			}
			this.estudiantes = arr;
		}
		this.estudiantes[size]=est;
		this.size=this.size+1;
		updateC();
		//System.out.println("El curso "+id+" tiene "+c);
	}
	
	public void updateC() {
		if(this.size==0) this.c=0.4;
		else if(this.size==1) this.c=(double) this.estudiantes[size-1];
		else{
			int sum=0;
			for(int i=0; i<size; i++) {
				sum += (double) estudiantes[i];
			}
			this.c=this.size*sum;
		}	
	}

	@Override
	public int compareTo(Curso curso) {
		if(this.c<curso.c) return -1;
		else if(this.c>curso.c) return 1;
		else return 0;
	}
	
	public String toString() {
		return "[" + this.id+","+this.c+"]";
	}
}

/*class Estudiante {

	int id;
	double s;
	
	public Estudiante(int id, double s) {
		super();
		this.id=id;
		this.s=s;
	}
	
}*/

public class Parcial2 {
  
  public static void main(String args[]) {
	// FUNCION MAIN
		  //try {
			  Scanner s = new Scanner(System.in);
		      int N = Integer.parseInt(s.next());
		      int A = Integer.parseInt(s.next());
		      int P = Integer.parseInt(s.next());
		      
		      ColaPrioridad<Curso> cursos = new ColaPrioridad<>(N);
		      Curso[] lCursos = new Curso[N];
		      
		      for(int i = 0; i < N; i++) {
		          lCursos[i]=new Curso(i+1);
		      }
		      
		      for(int i=0; i<P; i++) {
	              lCursos[i].addStudent(Double.parseDouble(s.next()));
		      }
		      
		      for(Curso c: lCursos) {
		    	  cursos.insertar(c);
		      }

		      for (int i = 0; i <A; i++) {
		          Curso curso = cursos.obtenerMin();
		          //System.out.println("saca el minimo: "+ curso.id);
		    	  curso.addStudent(Double.parseDouble(s.next()));
		    	  System.out.print(curso.id+" ");
		          cursos.updatePriority(curso);
		      }
		      s.close();
		/*} catch (Exception e) {
			
		}*/
      
  }
}