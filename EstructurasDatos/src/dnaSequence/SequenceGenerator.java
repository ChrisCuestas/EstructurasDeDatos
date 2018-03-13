package dnaSequence;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SequenceGenerator {
	
	public static String chromosome() {
		Random rd = new Random();
		return "chr" + (rd.nextInt(23)+1);
	}
	
	public static String nucleotide() {
		Random rd = new Random();
		switch(rd.nextInt(4)) {
			case 0: return "A"; 
			case 1: return "C"; 
			case 2: return "G";
			case 3: return "T";
			default: return "";
		}
	}
	
	public static String sequence(int length) {
		if (length==1) 
			return nucleotide();
		else
			return nucleotide() + sequence(length-1);
	}
	
	public static void saveSequences() {
		Random rd = new Random();
		
		try {
			
		    FileWriter file=new FileWriter("DNA_sequences.txt");

		    BufferedWriter bw = new BufferedWriter(file);
		   
		    int length, start;
		    int dataSize= 1000000;
		    String experimentalRead;
		    
		    for(int i=0; i <dataSize; i++) {
		    	length = rd.nextInt(50)+1;
		    	start = rd.nextInt(1000);
		    	experimentalRead = sequence(length) 
						+ "," + chromosome() 
						+ "," + start 
						+ "," + (start+length-1);
		    	bw.write(experimentalRead + "\n");
		    }
		    
		    bw.flush();
		    
		    bw.close();
		    
		} catch(IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		saveSequences();
	}
}