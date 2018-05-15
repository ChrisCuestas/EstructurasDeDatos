package ed2018.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BubbleSort {
	
	private int[] array;

	public BubbleSort(int[] array) {
		this.array = array;
	}

	public void sort() { 
		for(int i=0; i<this.array.length-1; i++) {
			boolean swapped =  false;
			for(int j=0; j<this.array.length-1; j++) {
				if(this.array[j]>this.array[j+1]) {
					int temp = this.array[j];
					this.array[j]=this.array[j+1];
					this.array[j+1]=temp;
					swapped= true;
				}
			}
			if (!swapped) break;
		}
	}
	
	public String printSortedArray() {
		String line = "";
		for(int i: this.array) {
			line += i+ ", ";
		}
		return line;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BubbleSort bs;
		
		try {
			
			String[] newString = br.readLine().split(","); 
			br.close();
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			bs = new BubbleSort(newArray);
			bs.sort();
			
			bw.write(bs.printSortedArray()+"\n");
			bw.flush();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
