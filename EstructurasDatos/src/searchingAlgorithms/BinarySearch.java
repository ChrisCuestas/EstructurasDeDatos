package searchingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinarySearch {

	private int[] array;

	public BinarySearch(int[] array) {
		this.array = array;
	}
	
	public int search1(int x) {
		int lowerBound = 0;
		int upperBound = this.array.length-1;
		int index = -1;
		while (lowerBound<upperBound) {
			int middlePoint = (lowerBound+upperBound)/2;
			if (x==this.array[middlePoint]) {
				index = middlePoint;
				break;
			} else if(x<this.array[middlePoint])
				upperBound=middlePoint-1;
			else lowerBound=middlePoint+1;
		}
		if(lowerBound==upperBound&&this.array[lowerBound]==x) 
			index=lowerBound;
		return index;
	}
	
	public int search2(int x) {
		int lowerBound = 0;
		int upperBound = this.array.length-1;
		return search2(x, lowerBound, upperBound);
	}
	
	private int search2(int x, int lB, int uB) {
		int middlePoint = (lB+uB)/2;
		if(lB==uB) {
			if (x==this.array[middlePoint]) 
				return middlePoint;
			else return -1; 
		} else if(x==this.array[middlePoint])
				return middlePoint;
			else if(x<this.array[middlePoint])
					return search2(x,lB,middlePoint);
				else return search2(x,middlePoint+1,uB);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BinarySearch bs;
		
		try {
			
			String[] newString = br.readLine().split(","); 
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			bs = new BinarySearch(newArray);
			
			bw.write(bs.search2(Integer.parseInt(br.readLine()))+"\n");
			bw.flush();
			bw.close();
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
}
	}

}
