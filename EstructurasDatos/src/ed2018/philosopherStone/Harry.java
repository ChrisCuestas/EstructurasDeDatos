package ed2018.philosopherStone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.ArrayStack;

public class Harry {

	private ArrayStack<Integer> monkBag;
	private int[] harryBag;
	private int value; 
	
	public Harry() {
		this.monkBag = new ArrayStack<Integer>();
		this.value=0;
	}
	
	public void addCoin(int index, int value) {
		this.harryBag[index]= value;
	}
	
	public void harry(int index) {
		this.value += this.harryBag[index];
		this.monkBag.push(this.harryBag[index]);
	}
	
	public void remove() {
		this.value += -this.harryBag[this.monkBag.pop()];
	}

	public static void main(String[] args) {
		Harry h = new Harry();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			h.harryBag=new int[n];
			int totalWorth=0;
			String[] line = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				int val = Integer.parseInt(line[i]);
				totalWorth+=val;
				h.addCoin(i,val);
			}
			line = br.readLine().split(" ");
			int q = Integer.parseInt(line[0]);
			int x = Integer.parseInt(line[1]);
			if(totalWorth<x) {
				bw.write("-1"+"\n");
			}else {
				boolean completed= false;
				int index=0;
				for(int i=0; i<q; i++) {
					String code = br.readLine();
					if(code.equals("Harry")) {
						h.harry(index);
						index++;
					}else if (code.equals("Remove")) {
						h.remove();
					}
					if (h.value==x) {
						completed = true;
						break;
					}
				}
				if (completed) {
					bw.write(h.monkBag.getSize()+"\n");
				}else {
					bw.write("-1"+"\n");
				}
			}
			bw.flush();
			br.close();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
