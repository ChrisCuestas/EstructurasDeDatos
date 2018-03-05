package taller2.Gimnasio;

import structures.LinkedList;
import structures.Node;

public class AdministradorCasilleros extends LinkedList<Cubiculo> {


	public AdministradorCasilleros() {
		super();
	}

	@SuppressWarnings("rawtypes")
	public Estudiante buscarEstudiante(int cedula) {
		Estudiante estudiante;
		Node nodo= super.getHead();
		for(int i=0; i<this.getSize(); i++) {
			estudiante= ((Cubiculo) nodo.getElement()).buscarEstudiante(cedula);
			if (estudiante!=null)return estudiante;
			nodo=nodo.getNextNode();
		}
		return null;
	}
	
	public int[] asignar(int cedula, String nombre, String apellido) {
		Cubiculo c = cubiculoMenosLleno();
		if(c!=null) {
			Estudiante e = new Estudiante(cedula,nombre,apellido);
			return c.asignarCasillero(e);
		}else return null;	
	}

	public Cubiculo cubiculoMenosLleno() {
		
		Node<Cubiculo> n = super.getHead();
		Cubiculo cubCargaMenor= n.getElement();
		for(int i=0; i<this.getSize()-1; i++) {
			System.out.println("size: "+ this.getSize());
			System.out.println("it: "+ i);
			Cubiculo siguiente=n.getNextNode().getElement();
			if(siguiente!= null) {
				System.out.println("No es nulo");
				if (cubCargaMenor.getCarga()>siguiente.getCarga()) {
					cubCargaMenor=siguiente;
				}
				n=n.getNextNode();
			}else return null;
		}
		return null;
	}
	
	public String liberar(int cedula) {
		Estudiante e= buscarEstudiante(cedula);
		return super.find(e.getUbicacion()[0]).liberarCasillero(e.getUbicacion()[1]);
	}
}
