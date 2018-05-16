package ed2018.gobletOnFire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.Queue;

public class TeamSelection {

	Queue<Student> students;
	
	public TeamSelection() {
		this.students = new Queue<Student>();
	}

	public static void main(String[] args) {
		TeamSelection ts = new TeamSelection();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				String[] line = br.readLine().split(" ");
				if(line[0].equals("E")) {
					boolean inserted = false;
					Student newStudent = new Student(Integer.parseInt(line[1]),Integer.parseInt(line[2]));
					for(int j=ts.students.getSize()-1; j>-1; j--) {
						if(ts.students.get(j).getElement().school== newStudent.school) {
							ts.students.insert(j+1, newStudent, -1);
							inserted=true;
						}
					}
					if(!inserted) ts.students.enqueue(newStudent, -1);
				} else if(line[0].equals("D")) {
					if(!ts.students.isEmpty()) bw.write(ts.students.dequeue().toString()+"\n");
				}
			}
			
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
