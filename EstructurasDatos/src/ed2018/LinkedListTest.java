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

public class LinkedListTest {
	
	public static void main(String[] args) {
		
		LinkedList<Grade> grades = new  LinkedList<Grade>();
		Grade g1= new Grade("task1", 3.5);
		Grade g2= new Grade("quiz1", 1.5);
		Grade g3= new Grade("test1", 0.5);
		Grade g4= new Grade("test2", 2.5);
		
		grades.insertFirst(g1);
		grades.printList();
		grades.insertFirst(g2);
		grades.printList();
		grades.insert(g3);
		grades.printList();
		grades.insert(1, g4);
		grades.printList();
		grades.remove(2);
		grades.printList();
		grades.removeFirst();
		grades.printList();
		grades.removeLast();
		grades.printList();
	}

}
