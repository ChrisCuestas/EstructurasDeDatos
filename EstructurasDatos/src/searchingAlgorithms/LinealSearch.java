package sorting_searchingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LinealSearch {

	private int[] array;
	
	public LinealSearch(int[] array) {
		this.array = array;
	}
	
	private int find(int num) {
		int index = -1;
		for(int i=0; i<array.length; i++) {
			if(array[i]==num) {
				index=i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinealSearch ls;
		
		try {
			
			String[] newString = br.readLine().split(","); 
			
			int newSize= newString.length;
			int[] newArray = new int[newSize];
			for(int i=0; i<newSize; i++) {
				newArray[i]=Integer.parseInt(newString[i]);
			}
			
			ls = new LinealSearch(newArray);
			
			bw.write(ls.find(Integer.parseInt(br.readLine()))+"\n");
			bw.flush();
			bw.close();
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
