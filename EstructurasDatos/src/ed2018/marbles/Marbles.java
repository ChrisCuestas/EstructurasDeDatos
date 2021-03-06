package ed2018.marbles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.ArraybasedList;
import ed2018.ArrayStack;

public class Marbles {

	private ArraybasedList<Integer> marbles;
	
	public Marbles() {
		this.marbles= new ArraybasedList<Integer>();
	}
	
	public void addMarble(int n) {
		if(!this.marbles.isEmpty()) {
			if(n<this.marbles.getLast()) {
				ArrayStack<Integer> stack = new ArrayStack<Integer>();
				while (n<this.marbles.getLast()) {
					stack.push(this.marbles.removeLast());
					if(this.marbles.isEmpty()) break;
				}
				this.marbles.insert(n);
				while (!stack.isEmpty()) this.marbles.insert(stack.pop());
			}else this.marbles.insert(n);
		}else this.marbles.insert(n);
	}
	
	public int findMarble(int n) {//Mejorar con Busqueda binaria
		return this.marbles.firstIndexOf(n)+1;
	}

	public static void main(String[] args) {
		
		Marbles m;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] caseLine = br.readLine().split(" ");
			int caseNum = 1;
			while(!caseLine[0].equals("0")&&!caseLine[1].equals("0")) {
				m = new Marbles();
				bw.write("CASE# " + caseNum + "\n");
				for(int i=0;i<Integer.parseInt(caseLine[0]);i++) m.addMarble(Integer.parseInt(br.readLine()));
				for(int i=0; i<Integer.parseInt(caseLine[1]);i++) {
					int Q = Integer.parseInt(br.readLine());
					int position = m.findMarble(Q);
					if(position <1) bw.write(Q + " not found" + "\n");
					else bw.write(Q + " found at " + m.findMarble(Q)+"\n");
					bw.flush();
				}
				caseNum++;
				caseLine = br.readLine().split(" ");
			}
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
