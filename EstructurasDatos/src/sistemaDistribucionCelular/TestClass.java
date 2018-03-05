package sistemaDistribucionCelular;

import structures.*;

import java.util.Scanner;



public class TestClass {

	static Queue<Integer> listaPropagacion = new Queue<Integer>();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numCasos =  s.nextInt();
		
		for (int n=0; n<numCasos; n++) {
			int cantAntenas = s.nextInt();
			Stack<Integer> antenas = new Stack<Integer>();
			Stack<Integer> aux = new Stack<Integer>();
			
			int altura = s.nextInt();
			int maxAbs=altura;
			int propMaxAbs=1;
			listaPropagacion.enqueueBack(propMaxAbs);
			
			
			
			for(int c=1; c<cantAntenas; c++) {
				altura = s.nextInt();
				if(altura >= maxAbs) {
					maxAbs = altura;
					propMaxAbs += antenas.getSize()+1;
					antenas.makeEmpty();
					listaPropagacion.enqueueBack(propMaxAbs);
				} else {
					aux.push(altura);
					while(!antenas.isEmpty()) {
						int ultimo = antenas.peek();
						if (altura < ultimo) break;
						if (altura >= ultimo) aux.push(antenas.pop());
					}
					listaPropagacion.enqueueBack(aux.getSize());
					while(!aux.isEmpty()) antenas.push(aux.pop());
				}
			}
			
			
			imprimirRangos();
		}
		s.close();
		
	}
	
	public static void imprimirRangos() {
		while(!listaPropagacion.isEmpty()) {
			System.out.print( listaPropagacion.dequeueFront()+" ");
		}
		System.out.println("\n");
	}

}
