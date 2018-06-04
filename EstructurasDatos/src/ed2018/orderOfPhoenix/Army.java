package ed2018.orderOfPhoenix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.Queue;
import ed2018.ArrayStack;

public class Army {

	int size;
	Object[] rows;
	public Army(int size) {
		this.size = size;
		this.rows = new Object[size];
		for(int i=0; i<size; i++) rows[i]=new ArrayStack<Integer>();
	}
	
	@SuppressWarnings("unchecked")
	public void insert(int row, int height) {
		if(row>=this.size)return;
		((ArrayStack<Integer>) this.rows[row]).push(height);
	}

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int n = Integer.parseInt(br.readLine());
			Army a = new Army(n);
			for(int i=0; i<n; i++) {
				String[] line = br.readLine().split(" ");
				for(int j=1; j<line.length;j++)
					a.insert(Integer.parseInt(line[0]), Integer.parseInt(line[j]));
			}
			
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
