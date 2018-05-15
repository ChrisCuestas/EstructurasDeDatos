package ed2018.economicPhonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.Queue;
import ed2018.Stack;

public class Phonebook {

	private Queue<Long> phonebook;
	private int numsOmitted;
	
	public Phonebook() {
		this.phonebook = new Queue<Long>();
		this.numsOmitted = 0;
	}
	
	public void addNumber(long number) {
		if(!this.phonebook.isEmpty()) {
			if(number<this.phonebook.getLast()) {
				Stack<Long> stack = new Stack<Long>();
				while (number<this.phonebook.getLast()) {
					stack.push(this.phonebook.removeLast());
					if(this.phonebook.isEmpty()) break;
				}
				this.phonebook.insert(number,-1);
				while (!stack.isEmpty()) this.phonebook.enqueue(stack.pop(),-1);
			}else this.phonebook.enqueue(number,-1);
		}else this.phonebook.enqueue(number,-1);
	}
	
	public void countNumsOmitted() {
		if(this.phonebook.getSize()>1) {
			for(int i=1; i<this.phonebook.getSize();i++) {
				char[] exp = Long.toString(this.phonebook.dequeue()).toCharArray();
				char[] nextNum = Long.toString(this.phonebook.dequeue()).toCharArray();
				for(int j=0; j<nextNum.length;j++) {
					if(!((Character) exp[j]).equals(nextNum[j])) {
						this.numsOmitted += j;
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Phonebook pb;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String line;
			while((line=br.readLine())!=null) {
				pb= new Phonebook();
				int n = Integer.parseInt(line);
				for(int i=0; i<n; i++) {
					pb.addNumber(Long.parseLong(br.readLine()));
				}
				pb.countNumsOmitted();
				bw.write(pb.numsOmitted + "\n");
				bw.flush();
			}
			br.close();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
