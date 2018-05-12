package prisonerOfAzkaban;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.Queue;

public class SillyProblem {

	Queue<Integer> num =  new Queue<Integer>();
	
	public SillyProblem() {
		super();
	}
	
	public static void main(String[] args) {
		SillyProblem s = new SillyProblem();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			for(int i=0; i<n; i++) 
				s.num.enqueue(Integer.parseInt(line[i]),-1);
			
			Queue<Integer> sum = new Queue<Integer> ();
			
			for(int i=0; i<n; i++) {
				int x=-1;
				int y=-1;
				
				for(int j=i; j>0; j--) {
					if(s.num.get(i).getElement()<s.num.get(j-1).getElement()) {
						x=i;
						break;
					} else x=-1;
				}
				for(int j=i+1; j<n; j++) {
					if(s.num.get(i).getElement()<s.num.get(j).getElement()) {
						y=i+2;
						break;
					} else y=-1;
				}
				sum.enqueue(x+y, -1);
			}
			
			while(!sum.isEmpty()) {
				bw.write(sum.dequeue()+" ");
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
