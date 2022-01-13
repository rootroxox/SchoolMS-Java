package Helper;

import java.util.Random;

import Item.Course;

public class CourseNode {
	private Course course;
	private double passCredit;
	private String passGrade;
	private static final Random random = new Random();
	private static final double[] points = {4.0,3.5,3.0,2.5,2.0};
	private static final String[] grades = {"AA","BA","BB","CB","CC"};
	
	public CourseNode(Course course) {
		int randomIndex = random.nextInt(5);
		this.course = course;
		this.passCredit = points[randomIndex];
		this.passGrade = grades[randomIndex];
	}

	public CourseNode(Course course, boolean isNull) {
		this.course = course;
		this.passCredit = 0.0;
		this.passGrade = null;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public double getPassCredit() {
		return passCredit;
	}
	
	public void setPassCredit(double passCredit) {
		this.passCredit = passCredit;
	}

	public String getPassGrade() {
		return passGrade;
	}

	public void setPassGrade(String passGrade) {
		this.passGrade = passGrade;
	}
}
