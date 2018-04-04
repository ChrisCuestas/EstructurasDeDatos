package sortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QuickSort {

	private int[] array;
	
	public QuickSort(int[] array) {
		this.array = array;
	}
	
	public void sort() {
		this.array= sort(this.array);
	}
	
	public int[] sort(int[] array) {
		boolean isSorted=true;
		for(int j=0;j<array.length-1;j++) {
			if(!(array[j]>array[j+1])) {
				 isSorted=false;
			} 
		}
		if(isSorted)return array;
		else {
			int pivot = array[0];
			for(int i=0; i<array.length; i++) {
				//Complete
			}
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
		QuickSort qs;
		
		try {
			String[] newString = br.readLine().split(","); 
			br.close();
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			qs = new QuickSort(newArray);
			qs.sort();
			
			bw.write(qs.printSortedArray()+"\n");
			bw.flush();
			
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
