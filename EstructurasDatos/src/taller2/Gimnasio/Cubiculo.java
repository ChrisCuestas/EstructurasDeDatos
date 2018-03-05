package taller2.Gimnasio;

import structures.*;

public class Cubiculo extends LinkedList<Casillero>{
	private int id;
	private int numCasilleros;
	
	public Cubiculo(int numCasilleros) {
		super();
		this.numCasilleros= numCasilleros;
	}


	public int getId() {
		return id;
	}
	
	public int getNumCasilleros() {
		return numCasilleros;
	}


	public int getCasillerosOcupados() {
		return super.getSize();
	}

	public double getCarga() {
		return this.getCasillerosOcupados()/this.getNumCasilleros();
	}
	
	public Casillero buscarCasillero(int id) {
		return this.find(id);
	}
	
	public Estudiante buscarEstudiante(int cedula) {
		return this.find(id).getEstudiante();
	}
	
	public boolean isFull() {
		return this.getCarga()==1.0;
	}
	
	public int[] asignarCasillero(Estudiante estudiante) {
		if(!isFull()) {
			System.out.println("No está lleno");
			int[] i= new int[2];
			i[0]=this.getId();
			i[1]=this.getSize();
			Casillero c = new Casillero(i, estudiante);
			super.insertLast(c);
			estudiante.setUbicacion(i);
			return i;
		}else return null;
	}
	
	public String liberarCasillero(int id) {
		return super.remove(id).getEstudiante().getNombre();
	}
}
