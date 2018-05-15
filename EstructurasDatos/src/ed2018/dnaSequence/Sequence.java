package ed2018.dnaSequence;

public class Sequence{
	
	private String sequence;
	private String chromosome;
	private int start;
	private int end;
	
	public Sequence(String sequence, String chromosome, int start, int end) {
		this.sequence = sequence;
		this.chromosome = chromosome;
		this.start = start;
		this.end = end;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getChromosome() {
		return chromosome;
	}

	public void setChromosome(String chromosome) {
		this.chromosome = chromosome;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
}
