package ed2018.dnaSequence;

import java.io.BufferedReader;
import java.io.FileReader;

import ed2018.LinkedList;

public class Main {

	private static LinkedList<Sequence> sequences = new LinkedList<Sequence>();
	
	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("DNA_sequences.txt");
			BufferedReader br = new BufferedReader(fr);
			String input = br.readLine();
			while(input!=null) {
				String[] data= input.split(",");
				sequences.insert(new Sequence(data[0], data[1], Integer.parseInt(data[2]),Integer.parseInt(data[3])),-1);
				input=br.readLine();
			}
			sequences.printList();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		
		
		
		/*Sequence seq1 = new Sequence("AGC", "chr1", 100, 102);
		Sequence seq2 = new Sequence("TGC", "chr2", 10, 12);
		
		seq1. = seq2;
		Sequence temp= seq1;
		
		while(temp != null) {
			System.out.println(temp.toString());
			temp=temp.next;
		}*/

	}

}
