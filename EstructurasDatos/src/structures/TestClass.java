package structures;

import java.util.*;

public class TestClass {
    @SuppressWarnings("unused")
	public static void main(String args[] ) throws Exception {
        
    	ArrayBasedList<Integer> arrayA=  new ArrayBasedList<Integer>(0);
    	LinkedList<Integer> arrayL= new LinkedList<Integer>();
    	
        Scanner s = new Scanner(System.in);
        int numTestCases = s.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int numCommands= s.nextInt();
            int caseNumber= i+1;
            //int costoTotalArrA=0;
            //int costoTotalArrL=0;
            System.out.println("Caso #"+caseNumber+":");
            for(int j = 0; j <numCommands; j++) {
            	String command = s.next().trim();
            	if(command.equals("insertar")) {//ok
            		int element=Integer.parseInt(s.next());
            		int index=Integer.parseInt(s.next());
            		arrayA.insert(index, element);
            		if (arrayL.insert(index, element)) System.out.println("insertar: posicion valida");
            		else System.out.println("insertar: posicion invalida");
            		//costoTotalArrA=costoTotalArrA+arrayA.getCostoInsert();
            		//costoTotalArrL=costoTotalArrL+arrayL.getCostoInsert();
            	}
            	if(command.equals("consultar")) {
            		int index=Integer.parseInt(s.next());
            		arrayA.find(index);
            		if (arrayL.find(index)!= null) System.out.println("consulta: "+arrayL.find(index));
            		else System.out.println("consulta: no encontrado");
            		//costoTotalArrA=costoTotalArrA+arrayA.getCostoFind();
            		//costoTotalArrL=costoTotalArrL+arrayL.getCostoFind();
            	}
            	if(command.equals("eliminar")) {
            		int index=Integer.parseInt(s.next());
            		Integer elementA=arrayA.remove(index);
            		Integer elementL=arrayL.remove(index);
            		if (elementL != null) System.out.println("eliminar: posicion valida");
            		else System.out.println("eliminar: posicion invalida");
            		//costoTotalArrA=costoTotalArrA+arrayA.getCostoRemoveWithIndex();
            		//costoTotalArrL=costoTotalArrL+arrayL.getCostoRemoveWithIndex();
            	}
            	if(command.equals("buscar")) {
            		int element=Integer.parseInt(s.next());
            		int indexA=arrayA.indexOf(element);
            		int indexL=arrayL.indexOf(element);
            		if (indexL>-1) System.out.println("buscar: "+indexL);
            		else System.out.println("no existe numero");
            		//costoTotalArrA=costoTotalArrA+arrayA.getCostoIndexOf();
            		//costoTotalArrL=costoTotalArrL+arrayL.getCostoIndexOf();
            	}
            	/*if(command.equals("costo")) {
            		System.out.println("costo: "+costoTotalArrA+" "+costoTotalArrL);
            	}
            	/*if(command.equals("out")) {
            		break;
            	}*/
            }
        }
        s.close();
    }
}