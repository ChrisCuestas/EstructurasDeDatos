package sortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InsertionSort {

	private int[] array;
	
	public InsertionSort(int[] array) {
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
		int val;
		int index;
		for(int i=0;i<this.array.length;i++) {
			val=this.array[i];
			index=i;
			while(index>0&&this.array[index-1]>val) {
				this.array[index]=this.array[index-1];
				index--;
			}
			this.array[index]=val;
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		InsertionSort is;
		
		try {
			
			String[] newString = br.readLine().split(","); 
			br.close();
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			is = new InsertionSort(newArray);
			is.sort();
			
			bw.write(is.printSortedArray()+"\n");
			bw.flush();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
