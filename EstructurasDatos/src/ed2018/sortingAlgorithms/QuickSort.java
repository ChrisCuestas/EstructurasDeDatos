package ed2018.sortingAlgorithms;

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
		sort(0,this.array.length-1);
	}
	
	public void sort(int start, int end) {
		int pivot=start;
		for(int i=pivot; i<end; i++) 
			if(array[i]<=array[i+1]) 
				pivot++;
			else break;
		if(pivot<end) {
			int storeIndex = pivot+1;
			for(int i=pivot+1; i<end+1; i++) {
				if(array[i]<array[pivot]) {
					swap(i,storeIndex);
					storeIndex++;
				}
			}
			swap(pivot,storeIndex-1);
			sort(start,storeIndex-1);
			sort(storeIndex,end);
		}
	}
	
	private void swap(int a, int b) {
		if(a!=b) {
			int temp= array[a];
			array[a]= array[b];
			array[b]=temp;
		}
	}

	public String printSortedArray() {
		String line = "";
		for(int i: this.array) 
			line += i+ ", ";
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
			for(int i=0; i<newSize; i++)
				newArray[i]=Integer.parseInt(newString[i]);
			
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
