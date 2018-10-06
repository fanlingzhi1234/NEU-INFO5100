package assignment3;

import java.util.ArrayList;

public class Classtest {
	
	public void main(String args[]) {
		Student bob = new Student("Bob",111);
		Student amy = new Student("Amy", 222);
		Student clien = new Student("clien", 333);	
		Student ddd = new Student("ddd", 444);
		Student fff = new Student("fff", 555);
		Student eee = new Student("eee", 666);
		Student ggg = new Student("ggg", 777);
		Student iii = new Student("iii", 888);
		Student qqq = new Student("qqq", 999);
		Student www = new Student("www", 1110);
				
		Course java = new Course("java");
		Course algorithm = new Course("algorithm");
		
		
		java.registerStudent(bob);
		System.out.println(bob.name + " Register successfully the course " +java.title);
		//java.registerStudent(bob);
		java.registerStudent(www);
		System.out.println(www.name + " Register successfully the course " +java.title);
		java.registerStudent(qqq);
		System.out.println(qqq.name + " Register successfully the course " +java.title);
		algorithm.registerStudent(iii);
		System.out.println(iii.name + " Register successfully the course " +algorithm.title);
		algorithm.registerStudent(amy);
		System.out.println(amy.name + " Register successfully the course " +algorithm.title);
		
		//isFull()
		if(!java.isFull())
			java.registerStudent(eee);
		else
			System.out.println("course is full");
		
		System.out.println("java course has " + java.getStudents());
		
		
	}
}
