package ed2018.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SelectionSort {
	int[] array;
	
	public SelectionSort(int[] array) {
		this.array = array;
	}

	public String printSortedArray() {
		String line = "";
		for(int i: this.array) {
			line += i+ ", ";
		}
		return line;
	}
	
	public void sort()
	{
		int indexSmallest, tempSwap;
		
		for(int i = 0; i < array.length - 1; i++)
		{
			indexSmallest = i;
			
			for(int j = i + 1; j < array.length; j++)
				if(array[j] < array[indexSmallest])
					indexSmallest = j;
			
			tempSwap = array[i];
			array[i] = array[indexSmallest];
			array[indexSmallest] = tempSwap;
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		SelectionSort ss;
		
		try {
			
			String[] newString = br.readLine().split(","); 
			br.close();
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			ss = new SelectionSort(newArray);
			ss.sort();
			
			bw.write(ss.printSortedArray()+"\n");
			bw.flush();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
