package sistemaSobrecuposUnal;

import structures.MaxPriorityQueue;

public class SistemaSobrecupos {

	private MaxPriorityQueue<SolicitudSobrecupo> solicitudes;

	public SistemaSobrecupos() {
		super();
		this.solicitudes= new MaxPriorityQueue<SolicitudSobrecupo>();
	}

	public MaxPriorityQueue<SolicitudSobrecupo> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(MaxPriorityQueue<SolicitudSobrecupo> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public void ingresarSolicitud(SolicitudSobrecupo solicitud) {
		solicitudes.insert(solicitud);
	}
	
	public String atenderSolicitud() {
		if (solicitudes.isEmpty()) return "Todos tienen cupo";
		else {
			SolicitudSobrecupo solicitud = solicitudes.deleteMax();
			return solicitud.toString();
		}
	}
}
