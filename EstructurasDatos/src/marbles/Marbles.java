package marbles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.ArraybasedList;
import ed2018.Stack;

public class Marbles {

	private ArraybasedList<Integer> marbles;
	
	public Marbles() {
		this.marbles= new ArraybasedList<Integer>();
	}
	
	public void addMarble(int n) {
		if(!this.marbles.isEmpty()) {
			if(n<this.marbles.getLast()) {
				Stack<Integer> stack = new Stack<Integer>();
				while (n<this.marbles.getLast()) stack.push(this.marbles.removeLast());
				this.marbles.insert(n);
				while (!stack.isEmpty()) this.marbles.insert(stack.pop());
			}else this.marbles.insert(n);
		}else this.marbles.insert(n);
	}
	
	public int findMarble(int n) {
		return this.marbles.firstIndexOf(n);
	}

	public static void main(String[] args) {
		
		Marbles m = new Marbles();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] caseLine = br.readLine().split(" ");
			int caseNum = 1;
			while(!caseLine[0].equals("0")&&!caseLine[1].equals("0")) {
				bw.write("CASE# " + caseNum);
				for(int i=0;i<Integer.parseInt(caseLine[0]);i++) m.addMarble(Integer.parseInt(br.readLine()));
				for(int i=0; i<Integer.parseInt(caseLine[1]);i++) {
					bw.write(m.findMarble(Integer.parseInt(br.readLine())));
					bw.flush();
				}
				caseNum++;
				caseLine = br.readLine().split(" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
