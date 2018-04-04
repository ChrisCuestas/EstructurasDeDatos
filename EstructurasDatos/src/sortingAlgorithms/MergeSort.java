package sortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeSort {

	private int[] array;
	
	public MergeSort(int[] array) {
		this.array = array;
	}
	
	public void sort() {
		this.array= sort(this.array);
	}
	
	private int[] sort(int[] array) {
		if(array.length==1) return array;
		else {
			int[] leftPart = new int[this.array.length/2];
			int[] rightPart= new int[this.array.length-(this.array.length/2)];
			for(int i=0; i<leftPart.length; i++) {
				leftPart[i]=this.array[i];
			}
			for(int i=leftPart.length; i<this.array.length; i++) {
				rightPart[i]=this.array[i];
			}
			int[] sortedL = sort(leftPart);
			int[] sortedR = sort(rightPart);
			return merge(sortedL,sortedR);
		}
	}
	
	private int[] merge(int[] a, int[] b) {
		int length = a.length + b.length;
		int[] c = new int[length];
		int sizeA=a.length, sizeB=b.length;
		int indexA=0, indexB=0, indexC =0;
		while(sizeA>0 && sizeB>0) {
			if (a[indexA]<b[indexB]) {
				c[indexC]=a[indexA];
				indexA++;
				indexC++;
				sizeA--;
			}else {
				c[indexC]=b[indexB];
				indexB++;
				indexC++;
				sizeB--;
			}
		}
		while(sizeA>0) {
			c[indexC]=a[indexA];
			indexA++;
			indexC++;
			sizeA--;
		}
		while(sizeB>0) {
			c[indexC]=b[indexB];
			indexB++;
			indexC++;
			sizeB--;
		}
		return c;
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
		MergeSort ms;
		
		try {
			String[] newString = br.readLine().split(","); 
			br.close();
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			ms = new MergeSort(newArray);
			ms.sort();
			
			bw.write(ms.printSortedArray()+"\n");
			bw.flush();
			
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
