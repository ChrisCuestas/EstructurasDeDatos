package ed2018.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CountingSort {

	private int[] array;
	
	public CountingSort(int[] array) {
		this.array = array;
	}
	
	public String printSortedArray() {
		String line = "";
		for(int i: this.array) {
			line += i+ ", ";
		}
		return line;
	}
	
	public void sort() {
		int max = Integer.MIN_VALUE;
		int[] aux;
		int index = 0;
		
		for(int i=0; i<this.array.length;i++) 
			if(this.array[i]>max) 
				max= this.array[i];
		
		aux= new int[max+1];
		
		for(int i=0; i<this.array.length;i++) 
			aux[this.array[i]]+=1;
		
		for(int i=0; i<aux.length;i++)
			for(int j=0; j<aux[i];j++) {
				this.array[index]=i;
				
			}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		CountingSort cs;
		
		try {
			
			String[] newString = br.readLine().split(","); 
			br.close();
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			cs = new CountingSort(newArray);
			cs.sort();
			
			bw.write(cs.printSortedArray()+"\n");
			bw.flush();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
