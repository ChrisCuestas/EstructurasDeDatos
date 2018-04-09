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
	
	public int search(int x) {
		int lowerBound = 0;
		int upperBound = this.array.length-1;
		int index = -1;
		while (lowerBound<upperBound) {
			int middlePoint = (lowerBound+upperBound)/2;
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
		BinarySearch bs;
		
		try {
			
			String[] newString = br.readLine().split(","); 
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			bs = new BinarySearch(newArray);
			
			bw.write(bs.search(Integer.parseInt(br.readLine()))+"\n");
			bw.flush();
			bw.close();
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
}
	}

}
