package ed2018.gobletOnFire;

public class Student {

	int school;
	int rollNum;
	
	public Student(int school, int rollNumber) {
		this.school = school;
		this.rollNum = rollNumber;
	}

	public int getSchool() {
		return school;
	}

	public void setSchool(int school) {
		this.school = school;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String toString() {
		return this.school + " " + this.rollNum;
	}
}
