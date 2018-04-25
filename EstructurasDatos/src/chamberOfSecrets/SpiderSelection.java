package chamberOfSecrets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.LinkedList;
import ed2018.Queue;

public class SpiderSelection {

	private Queue<Spider> spiders;
	
	class Spider{
		int position;
		int power;
		
		public Spider(int power, int position) {
			this.position = position;
			this.power = power;
		}
	}
	
	public SpiderSelection() {
		this.spiders= new Queue<Spider>();
	}

	public static void main(String[] args) {
		SpiderSelection s = new SpiderSelection();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int x = Integer.parseInt(br.readLine());
			
			String[] line = br.readLine().split(" ");
			for(int i=0; i<n; i++) 
				s.spiders.enqueue(new Spider(Integer.parseInt(line[i]), i+1));
			int iterations = 0;
			Queue<Spider> tempList =  new Queue<Spider>();
			Spider greater = null;
			while(!s.spiders.isEmpty()&&iterations<x) {
				Spider sp = s.spiders.dequeue();
				if(greater==null) greater = sp;
				else {
					if (greater.power<sp.power) {
						
						tempList.enqueue(greater, -1);
						greater = 
					}
				}
				tempList.enqueue(s.spiders.dequeue(), -1);
				iterations++;
			}
			
			
			bw.flush();
			br.close();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
