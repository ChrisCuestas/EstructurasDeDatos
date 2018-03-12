package data;

class Grade{
	public String name;
	public double grade;
	
	public Grade(String name, double grade) {
		this.name=name;
		this.grade=grade;
	}

	@Override
	public String toString() {
		return "Grade: " + name + "\t"+ "Value: " + grade;
	}
}
public class StackTest {

	public static void main(String[] args) {
		
		Stack<Grade> grades = new  Stack<Grade>();
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
