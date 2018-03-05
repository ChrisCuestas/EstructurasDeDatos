package dnaSequence;

public class Main {

	public static void main(String[] args) {

		Sequence seq1 = new Sequence("AGC", "chr1", 100, 102);
		Sequence seq2 = new Sequence("TGC", "chr2", 10, 12);
		
		seq1.next = seq2;
		Sequence temp= seq1;
		
		while(temp != null) {
			System.out.println(temp.toString());
			temp=temp.next;
		}

	}

}
