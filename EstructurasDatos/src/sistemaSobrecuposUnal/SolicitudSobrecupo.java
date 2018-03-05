package sistemaSobrecuposUnal;

public class SolicitudSobrecupo implements Comparable<SolicitudSobrecupo> {

	private long id;
	private String justification;
	private int codAsignatura;
	private double pappi;

	
	
	public SolicitudSobrecupo(long id, String justification, int codAsignatura, int creditosUltSemestre,
			double nota) {
		super();
		this.id = id;
		this.justification = justification;
		this.codAsignatura = codAsignatura;
		this.setPappi(creditosUltSemestre, nota);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public int getCodAsignatura() {
		return codAsignatura;
	}
	public void setCodAsignatura(int codAsignatura) {
		this.codAsignatura = codAsignatura;
	}
	
	public double getPappi() {
		return pappi;
	}
	public void setPappi(int creditosUltSemestre, double sumaPonderadaNotas) {
		this.pappi = sumaPonderadaNotas/creditosUltSemestre;
	}

	public int compareTo(SolicitudSobrecupo s) {
		if(this.pappi == s.getPappi()) {
			return 0;
		}else if(this.pappi < s.getPappi()) return -1;
		else return 1;
	}
	
	@Override
	public String toString() {
		return this.id + "," + this.justification+ "," + this.codAsignatura;
	}
}
