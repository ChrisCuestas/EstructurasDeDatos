package taller2.Gimnasio;

public class Casillero {

	private int[] id;
	private Estudiante estudiante;
	
	public Casillero(int[] i,Estudiante estudiante) {
		super();
		this.id=i;
		this.estudiante = estudiante;
	}

	
	public int[] getId() {
		return id;
	}


	public void setId(int cubiculo, int casillero) {
		this.id[0] = cubiculo;
		this.id[1] = casillero;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public boolean isEmpty() {
		return (getEstudiante()==null);
	}
}
