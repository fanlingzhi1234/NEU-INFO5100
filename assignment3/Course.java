package assignment3;

import java.util.ArrayList;


public class Course {
	public String title;
	public int cid;
	public int numberOfStudent = 0;
	private int MAXStudent = 10;

	ArrayList<Student> registeredStudent = new ArrayList<Student>();
	
	
	public Course(String title) {
		this.title = title;
	}
	
	public ArrayList<Student> getStudents() {
		
		return registeredStudent;
	}
	
	public void registerStudent(Student student) {
		
		
		for(int i = 0; i<numberOfStudent; i++) {
			
			if(registeredStudent.get(i) == student)
				throw new RuntimeException("you have registered this course before");
				break;
		}
		boolean full = this.isFull();
		
		if(numberOfStudent < MAXStudent && full == false) {
			registeredStudent.add(student);
			numberOfStudent ++;
		}
		
	}
	
	public boolean isFull() {
		if(numberOfStudent < MAXStudent) {
			return false;
		}
		else
			return true;
	}
	
}
