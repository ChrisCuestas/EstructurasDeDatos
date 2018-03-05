package taller2.Gimnasio;

public class Estudiante {

	private int cedula;
	private String nombre;
	private String apellido;
	private int[] ubicacion;
	
	public Estudiante(int cedula, String nombre, String apellido) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ubicacion[0]=-1;
		this.ubicacion[1]=-1;
	}

	public int getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int[] getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(int[] u) {
		this.ubicacion=u;
	}
	
}
