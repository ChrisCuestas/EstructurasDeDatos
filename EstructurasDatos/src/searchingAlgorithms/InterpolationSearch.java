package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InterpolationSearch {

	private int[] array;
	
	public InterpolationSearch(int[] array) {
		this.array = array;
	}

	
	public int search(int x) {
		int lowerBound = 0;
		int upperBound = this.array.length-1;
		int index = -1;
		while (lowerBound<upperBound) {
			int middlePoint = lowerBound +((upperBound-lowerBound)/(this.array[upperBound]-this.array[lowerBound]))*(x-this.array[lowerBound]);
			if (x==this.array[middlePoint]) {
				index = middlePoint;
				break;
			} else if(x<this.array[middlePoint]){
				upperBound=middlePoint-1;
			} else {
				lowerBound=middlePoint+1;
			}
		}
		if(lowerBound==upperBound&&this.array[lowerBound]==x) {
			index=lowerBound;
		}
		return index;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		InterpolationSearch is;
		
		try {
			
			String[] newString = br.readLine().split(","); 
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			is = new InterpolationSearch(newArray);
			
			bw.write(is.search(Integer.parseInt(br.readLine()))+"\n");
			bw.flush();
			bw.close();
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
}
	}
}
