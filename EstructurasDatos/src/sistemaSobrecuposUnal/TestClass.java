package sistemaSobrecuposUnal;

import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String operaciones;
		SistemaSobrecupos sistema =  new SistemaSobrecupos();
		try {
			while(s.hasNextLine()){
				operaciones = s.nextLine().trim();
	        	if(operaciones.equals("solicitud")) {
	        		long id = Long.parseLong(s.nextLine().trim());
	        		int cod = Integer.parseInt(s.nextLine().trim());
	        		String j= s.nextLine();
	        		Double nota = Double.parseDouble(s.nextLine().trim());
	        		int creditos = Integer.parseInt(s.nextLine().trim());
	        		sistema.ingresarSolicitud(new SolicitudSobrecupo(id, j, cod, creditos, nota ));
	        	}
	        	else if(operaciones.equals("atender")) {
	        		System.out.println(sistema.atenderSolicitud());
	        	}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		s.close();
	}
}
