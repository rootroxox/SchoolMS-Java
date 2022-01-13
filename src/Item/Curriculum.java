package Item;

import java.util.HashMap;

public class Curriculum {
	private String department;
	private HashMap<String, HashMap<String, Course>> courseMap;
	
	public Curriculum(String department, HashMap<String, HashMap<String, Course>> courseMap) {
		this.department = department;
		this.courseMap = courseMap;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public HashMap<String, HashMap<String, Course>> getCourseMap() {
		return courseMap;
	}
	public void setCourseMap(HashMap<String, HashMap<String, Course>> courseMap) {
		this.courseMap = courseMap;
	}
}
