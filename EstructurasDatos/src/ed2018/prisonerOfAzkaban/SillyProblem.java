package ed2018.prisonerOfAzkaban;

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
	
	public int largestLessThan(int index) {
		for(int j=index-1; j>=0; j--) 
			if(this.num.get(j).getElement()>this.num.get(index).getElement()) 
				return j+1;
		return -1;
	}
	
	public int smallestGreaterThan(int index) {
		for(int j=index+1; j<this.num.getSize(); j++) 
			if(this.num.get(j).getElement()>this.num.get(index).getElement()) 
				return j+1;
		return -1;
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
			
			for(int i=0; i<n; i++) 
				sum.enqueue(s.largestLessThan(i)+s.smallestGreaterThan(i), -1);
			
			while(!sum.isEmpty()) 
				bw.write(sum.dequeue()+" ");
			
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
