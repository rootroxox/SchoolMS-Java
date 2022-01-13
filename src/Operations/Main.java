package Operations;

import Actors.Instructor;
import Actors.Manager;
import Actors.Student;
import Helper.CourseNode;
import Helper.RankCalculator;
import Item.Course;
import Item.Transcript;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static HashMap<String,Student> studentList;
	public static HashMap<String,Instructor> instructorList;
	public static HashMap<String,Course> courseList;
	public static HashMap<String,Manager> managerList;
	public static HashMap<String, ArrayList<Course>> curriculumList;
	
	public static void main(String[] args) {
		instructorList = createInstructorMap(args[1]);
		curriculumList = new HashMap<>();
		courseList = createCourseMap(args[0]);

		setInstructorsTaughtCourses();

		studentList = createStudentMap(args[3]);
		managerList = createManagerMap(args[2]);

		RankCalculator rankCalculator = new RankCalculator();
		rankCalculator.updateRanks();
	}

	public static void setInstructorsTaughtCourses() {
		for(String department : curriculumList.keySet()){
			Instructor[] instructorsOfSameDepartment = new Instructor[2];

			int j = 0;
			for(Instructor instructor : instructorList.values()){
				if(instructor.getDepartment().equals(department)){
					instructorsOfSameDepartment[j] = instructor;
					j++;
					if(j == 2)
						break;
				}
			}

			for(int i = 0; i<curriculumList.get(department).size(); i++){
				if(i<curriculumList.get(department).size()/2){
					HashMap<String,Course> taught = instructorsOfSameDepartment[0].getTaughtCourses();
					taught.put(curriculumList.get(department).get(i).getCourseCode(),curriculumList.get(department).get(i));
					instructorsOfSameDepartment[0].setTaughtCourses(taught);
				}
				else{
					HashMap<String,Course> taught = instructorsOfSameDepartment[1].getTaughtCourses();
					taught.put(curriculumList.get(department).get(i).getCourseCode(),curriculumList.get(department).get(i));
					instructorsOfSameDepartment[1].setTaughtCourses(taught);
				}
			}

			instructorList.put(instructorsOfSameDepartment[0].getID(),instructorsOfSameDepartment[0]);
			instructorList.put(instructorsOfSameDepartment[1].getID(),instructorsOfSameDepartment[1]);
		}
	}

	private static HashMap<String,Instructor> createInstructorMap(String instructorsFile) {
		HashMap<String,Instructor> myInstructorList = new HashMap<>();
		File instructorFile = new File(instructorsFile);
		
		try {
			Scanner scanner = new Scanner(instructorFile);
			scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				String[] read = scanner.nextLine().split(";");
				
				String name = read[0];
				String surname = read[1];
				String ID = read[2];
				String faculty = read[3];
				String department = read[4];
				boolean isAdvisor = Integer.parseInt(read[5]) == 1;

				Instructor instructor = new Instructor(name, surname, ID, faculty, department, isAdvisor);
				myInstructorList.put(ID, instructor);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return myInstructorList;
	}

	private static HashMap<String,Student> createStudentMap(String studentsFile) {
		HashMap<String,Student> myStudentList = new HashMap<>();
		File studentFile = new File(studentsFile);
		
		try {
			Scanner scanner = new Scanner(studentFile);
			scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				String[] read = scanner.nextLine().split(";");
				
				String name = read[0];
				String surname = read[1];
				String ID = read[2];
				int classLevel = Integer.parseInt(read[3]);
				String faculty = read[4];
				String department = read[5];
				String advisorID = read[6];
				
				Student student = new Student(name, surname, ID, classLevel, faculty, department, instructorList.get(advisorID));
				student.setCurriculum(curriculumList.get(department));				
				HashMap<String,Student> newAdvisedStudentList = instructorList.get(advisorID).getAdvisedStudentList();
				newAdvisedStudentList.put(ID, student);
				instructorList.get(advisorID).setAdvisedStudentList(newAdvisedStudentList);
				
				for(int i = 0; i<Main.curriculumList.get(department).size(); i++) {
					if(Main.curriculumList.get(department).get(i).getSemester() < classLevel*2) {
						ArrayList<CourseNode> studentsCompletedCourses = student.getTranscript().getCompletedCourses();
						studentsCompletedCourses.add(new CourseNode(Main.curriculumList.get(department).get(i)));

						Transcript studentTranscript = student.getTranscript();
						studentTranscript.setCompletedCourses(studentsCompletedCourses);
						studentTranscript.updateGPA();
						student.setTranscript(studentTranscript);
					}

					if(Main.curriculumList.get(department).get(i).getSemester() == classLevel*2) {
						ArrayList<CourseNode> studentTakenCourses = student.getTakenCourses();
						studentTakenCourses.add(new CourseNode(Main.curriculumList.get(department).get(i),true));
						student.setTakenCourses(studentTakenCourses);
					}
				}
				myStudentList.put(ID, student);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return myStudentList;
	}
	
	private static HashMap<String,Course> createCourseMap(String coursesFile) {
		HashMap<String,Course> myCourseList = new HashMap<>();
		ArrayList<Course> myFakeCourseList = new ArrayList<>();
		File courseFile = new File(coursesFile);
		
		try {
			Scanner scanner = new Scanner(courseFile);
			scanner.nextLine();
			
			String oldDepartment = "X";
			
			while(scanner.hasNextLine()) {
				String[] read = scanner.nextLine().split(";");
				
				String department = read[0];
				String semester = read[1];
				String courseCode = read[2];
				String courseName = read[3];
				String credit = read[4];
				
				Course course = new Course(courseCode, courseName, Integer.parseInt(credit),Integer.parseInt(semester));
				myCourseList.put(courseCode, course);

				if (!department.equals(oldDepartment) && !oldDepartment.equals("X")) {
					myFakeCourseList = new ArrayList<>();
				}
				myFakeCourseList.add(course);
				curriculumList.put(department, myFakeCourseList);

				oldDepartment = department;
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return myCourseList;
	}
	
	private static HashMap<String,Manager> createManagerMap(String managersFile) {
		HashMap<String,Manager> myManagersList = new HashMap<>();
		File managerFile = new File(managersFile);
		
		try {
			Scanner scanner = new Scanner(managerFile);
			scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				String[] read = scanner.nextLine().split(";");
				
				String name = read[0];
				String surname = read[1];
				String ID = read[2];
				
				Manager manager = new Manager(name, surname, ID, instructorList, courseList, studentList);
				myManagersList.put(ID, manager);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return myManagersList;
	}
}
