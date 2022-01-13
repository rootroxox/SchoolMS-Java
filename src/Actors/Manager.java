package Actors;

import java.util.HashMap;

import Item.Course;

public class Manager extends User{
	HashMap<String,Instructor> instructorList;
	HashMap<String,Course> courseList;
	HashMap<String,Student> studentList;
	
	public Manager(String name, String surname, String iD, 
			HashMap<String,Instructor> instructorList,
			HashMap<String,Course> courseList, 
			HashMap<String,Student> studentList) {
		super(name, surname, iD);
		this.instructorList = instructorList;
		this.courseList = courseList;
		this.studentList = studentList;
	}
}
