package ed2018;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class StackTest {

	public void printStack(ArrayStack<Grade> s) {
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			while(!s.isEmpty()) {
				bw.write(s.pop().toString()+ "\n");
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {
		
		ArrayStack<Grade> grades = new  ArrayStack<Grade>();
		Grade g1= new Grade("task1", 3.5);
		Grade g2= new Grade("quiz1", 1.5);
		Grade g3= new Grade("test1", 0.5);
		Grade g4= new Grade("test2", 2.5);
		
		grades.push(g1);
		grades.push(g2);
		grades.push(g3);
		System.out.println("The top is: "+ grades.peek().toString());
		grades.push(g4);
		grades.printStack();

	}

}
