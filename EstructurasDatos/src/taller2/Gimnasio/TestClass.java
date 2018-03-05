package taller2.Gimnasio;

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) throws Exception {
		
        Scanner s = new Scanner(System.in);
        
        int numCases = s.nextInt();

        for (int i = 0; i < numCases; i++) {
        	int numCubiculos= s.nextInt();
        	AdministradorCasilleros a= new AdministradorCasilleros();
        	for (int j=0; j<numCubiculos;j++) {
        		a.insertLast(new Cubiculo(s.nextInt()));
        	}
        	int numCommands= s.nextInt();
            int caseNumber= i+1;
            System.out.println("Caso #"+caseNumber+":");
        	
            for(int j = 0; j <numCommands; j++) {
            	String command = s.next().trim();
            	if(command.equals("ingresar")) {
            		String nombre=s.next();
            		String apellido=s.next();
            		int cedula=Integer.parseInt(s.next());
            		int[] pos = a.asignar(cedula, nombre, apellido);
            		System.out.println(pos[0]+" "+pos[1]);
            	}
            	else if(command.equals("salir")) {
            		int cedula=Integer.parseInt(s.next());
            		System.out.println(a.liberar(cedula));
            	}
            }
        }
        s.close();
	}
	
}
