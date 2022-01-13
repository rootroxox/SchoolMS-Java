package Item;

public class Course {
	private String courseCode;
	private String courseName;
	private int credit;
	private int semester;

	public Course(String courseCode, String courseName, int credit, int semester) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credit = credit;
		this.semester = semester;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public void printCourseInfo() {
		System.out.println("Course Code: " + courseCode + "\nCourseName: " + courseName + "\nCredit: " + credit);
	}
}
