package dnaSequence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sequence{
	
	private String sequence;
	private String chromosome;
	private int start;
	private int end;
	
	public Sequence next= null;		//Sequence treated as a node of a list of sequences
	
	public Sequence() {
		
	}
	
	public Sequence(String sequence, String chromosome, int start, int end) {
		this.sequence = sequence;
		this.chromosome = chromosome;
		this.start = start;
		this.end = end;
	}
	
	public static void main(String[] args) {
		
		/*
		
		String filename = "newfile.txt"; 
		
		// reading text file into array 
		try { FileReader textFileReader = new FileReader(filename); 
			BufferedReader bufReader = new BufferedReader(textFileReader); 
			char[] buffer = new char[8096]; 
			int numberOfCharsRead = bufReader.read(buffer); // read will be from memory 
			while (numberOfCharsRead != -1) { 
				System.out.println(String.valueOf(buffer, 0, numberOfCharsRead));
				numberOfCharsRead = textFileReader.read(buffer); 
			} 
			bufReader.close(); 
		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} */
		
		/*
		
		// reading file line by line using BufferedReader 
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) { 
			String line = br.readLine(); 
			while (line != null) { 
				System.out.println(line); line = br.readLine(); 
			} 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
		}*/
	}
}