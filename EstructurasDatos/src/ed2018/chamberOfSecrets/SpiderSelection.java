package ed2018.chamberOfSecrets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.Queue;

public class SpiderSelection {

	private Queue<Spider> spiders;
	
	public SpiderSelection() {
		this.spiders= new Queue<Spider>();
	}

	public static void main(String[] args) {
		SpiderSelection s = new SpiderSelection();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int x = Integer.parseInt(line[1]);
			
			line = br.readLine().split(" ");
			for(int i=0; i<n; i++) 
				s.spiders.enqueue(new Spider(Integer.parseInt(line[i]), i+1),-1);
			
			Queue<Spider> tempList =  new Queue<Spider>();
			Spider greater;
			for(int i=0; i<x; i++) {
				greater = null;
				int j=0;
				while(!s.spiders.isEmpty()&&j<x) {
					Spider sp = s.spiders.dequeue();
					if(greater==null) greater = sp;
					else {
						if (greater.power<sp.power) {
							tempList.enqueue(greater, -1);
							greater = sp;
						} else tempList.enqueue(sp, -1);
					}
					j++;
				}
				bw.write(greater.position + " ");
				while(!tempList.isEmpty()) {
					Spider tempSpider = tempList.dequeue();
					tempSpider.power--;
					s.spiders.enqueue(tempSpider, -1);
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
