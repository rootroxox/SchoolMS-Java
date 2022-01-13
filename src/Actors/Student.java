package Actors;

import java.util.ArrayList;

import Helper.CourseNode;
import Item.Course;
import Item.Transcript;

public class Student extends User {
	private double GPA;
	private int classLevel;
	private String faculty;
	private String department;
	private Instructor advisor;
	private int rank;
	private Transcript transcript;
	private ArrayList<Course> curriculum;
	private ArrayList<CourseNode> takenCourses;

	public Student(String name, String surname, String iD, int classLevel, String faculty, String department,
			Instructor advisor) {
		super(name, surname, iD);
		this.classLevel = classLevel;
		this.faculty = faculty;
		this.department = department;
		this.advisor = advisor;
		this.takenCourses = new ArrayList<>();
		this.transcript = new Transcript();
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.setGPA(this.transcript.getGPA());
		this.transcript = transcript;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public int getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Instructor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Instructor advisor) {
		this.advisor = advisor;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public ArrayList<CourseNode> getTakenCourses() {
		return takenCourses;
	}

	public void setTakenCourses(ArrayList<CourseNode> takenCourses) {
		this.takenCourses = takenCourses;
	}

	public ArrayList<Course> getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(ArrayList<Course> curriculum) {
		this.curriculum = curriculum;
	}
}
