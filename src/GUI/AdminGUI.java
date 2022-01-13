package GUI;

import Actors.Instructor;
import Actors.Student;
import Helper.CourseNode;
import Helper.Helper;
import Item.Course;
import Item.Transcript;
import Operations.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminGUI extends JFrame {

	private final JTable table_1;
	private final JTextField txt_delStudent;
	private final JTextField txtName;
	private final JTextField txtSurname;
	private final JTextField txtId;
	private final JTextField txtClass;
	private final JTextField txtFaculty;
	private final JTextField txtDepartment;
	private final JTextField txtAdvisorId;
	private final JTextField fld_IName;
	private final JTextField fld_ISurname;
	private final JTextField fld_IID;
	private final JTextField fld_IFaculty;
	private final JTextField fld_IDepartment;
	private final JTextField fld_IDeleteID;
	private JTable table_2;
	private final JTextField fld_CCode;
	private final JTextField fld_CName;
	private final JTextField fld_CCredit;
	private final JTextField fld_CSemester;
	private final JTextField fld_delCCode;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				AdminGUI frame = new AdminGUI(args[0]);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminGUI(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 936, 563);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_title = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lbl_title.setBounds(10, 10, 906, 32);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		lbl_title.setBackground(Color.WHITE);
		panel.add(lbl_title);

		JLabel lbl_title_1 = new JLabel("Admin Panel");
		lbl_title_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_title_1.setBackground(Color.WHITE);
		lbl_title_1.setBounds(281, 34, 365, 32);
		panel.add(lbl_title_1);

		JLabel lbl_title_1_1_2 = new JLabel("Welcome,");
		lbl_title_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_title_1_1_2.setBackground(Color.WHITE);
		lbl_title_1_1_2.setBounds(10, 52, 91, 32);
		panel.add(lbl_title_1_1_2);

		JLabel lbl_title_1_1_2_1 = new JLabel(name);
		lbl_title_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title_1_1_2_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lbl_title_1_1_2_1.setBackground(Color.WHITE);
		lbl_title_1_1_2_1.setBounds(106, 52, 91, 32);
		panel.add(lbl_title_1_1_2_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 94, 916, 459);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Student Management", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 728, 412);
		panel_1.add(scrollPane);

		String[] columns = new String[] { "Name", "Surname", "ID", "Class", "Faculty", "Department", "Advisor (ID)" };

		Object[][] students = new Object[Main.studentList.values().size()][7];
		calculateStudents(students);
		table_1 = new JTable(students, columns);

		TableColumnModel columnModel = table_1.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(5);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(6).setPreferredWidth(10);

		table_1.setBackground(Color.WHITE);
		scrollPane.setViewportView(table_1);

		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setColumns(10);
		txtName.setBounds(748, 21, 143, 19);
		panel_1.add(txtName);

		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(748, 62, 143, 19);
		panel_1.add(txtSurname);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(748, 102, 143, 19);
		panel_1.add(txtId);

		txtClass = new JTextField();
		txtClass.setColumns(10);
		txtClass.setBounds(748, 144, 143, 19);
		panel_1.add(txtClass);

		txtFaculty = new JTextField();
		txtFaculty.setColumns(10);
		txtFaculty.setBounds(748, 185, 143, 19);
		panel_1.add(txtFaculty);

		txtDepartment = new JTextField();
		txtDepartment.setColumns(10);
		txtDepartment.setBounds(748, 225, 143, 19);
		panel_1.add(txtDepartment);

		txtAdvisorId = new JTextField();
		txtAdvisorId.setColumns(10);
		txtAdvisorId.setBounds(748, 266, 143, 19);
		panel_1.add(txtAdvisorId);

		JButton btnNewButton = new JButton("Add New Student");
		btnNewButton.addActionListener(e -> {
			// TO DO ADD STUDENT
			if (txtName.getText().length() != 0 && txtSurname.getText().length() != 0
					&& txtId.getText().length() != 0 && txtClass.getText().length() != 0
					&& txtFaculty.getText().length() != 0 && txtDepartment.getText().length() != 0
					&& txtAdvisorId.getText().length() != 0) {

				Student student = new Student(txtName.getText(), txtSurname.getText(), txtId.getText(),
						Integer.parseInt(txtClass.getText()), txtFaculty.getText(), txtDepartment.getText(),
						Main.instructorList.get(txtAdvisorId.getText()));
				student.setCurriculum(Main.curriculumList.get(student.getDepartment()));
				HashMap<String, Student> newAdvisedStudentList = Main.instructorList
						.get(student.getAdvisor().getID()).getAdvisedStudentList();
				newAdvisedStudentList.put(student.getID(), student);
				Main.instructorList.get(student.getAdvisor().getID()).setAdvisedStudentList(newAdvisedStudentList);

				for (int i = 0; i < Main.curriculumList.get(student.getDepartment()).size(); i++) {
					if (Main.curriculumList.get(student.getDepartment()).get(i)
							.getSemester() < student.getClassLevel() * 2) {
						ArrayList<CourseNode> studentsCompletedCourses = student.getTranscript()
								.getCompletedCourses();
						studentsCompletedCourses
								.add(new CourseNode(Main.curriculumList.get(student.getDepartment()).get(i)));

						Transcript studentTranscript = student.getTranscript();
						studentTranscript.setCompletedCourses(studentsCompletedCourses);
						studentTranscript.updateGPA();
						student.setTranscript(studentTranscript);
					}

					if (Main.curriculumList.get(student.getDepartment()).get(i)
							.getSemester() == student.getClassLevel() * 2) {
						ArrayList<CourseNode> studentTakenCourses = student.getTakenCourses();
						studentTakenCourses
								.add(new CourseNode(Main.curriculumList.get(student.getDepartment()).get(i), true));
						student.setTakenCourses(studentTakenCourses);
					}
				}

				Main.studentList.put(student.getID(), student);
				Helper.showMessage("success");
				txtName.setText("");
				txtSurname.setText("");
				txtId.setText("");
				txtClass.setText("");
				txtFaculty.setText("");
				txtDepartment.setText("");
				txtAdvisorId.setText("");
			} else {
				Helper.showMessage("fill");
			}
			updateStudentTable();
		});
		btnNewButton.setBounds(748, 295, 143, 21);
		panel_1.add(btnNewButton);

		txt_delStudent = new JTextField();
		txt_delStudent.setBounds(748, 372, 143, 19);
		panel_1.add(txt_delStudent);
		txt_delStudent.setColumns(10);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(e -> {
			if (txt_delStudent.getText().length() != 0) {
				if (Main.studentList.get(txt_delStudent.getText()) != null) {
					if (Helper.confirm("sure")) {
						Main.studentList.remove(txt_delStudent.getText(),
								Main.studentList.get(txt_delStudent.getText()));
						updateStudentTable();
						Helper.showMessage("success");
						txt_delStudent.setText("");
					}
				} else {
					Helper.showMessage("error");
				}
			} else {
				Helper.showMessage("fill");
			}

		});
		btnDeleteStudent.setBounds(748, 401, 143, 21);
		panel_1.add(btnDeleteStudent);

		JLabel lbl_Name = new JLabel("Name");
		lbl_Name.setBounds(748, 10, 45, 13);
		panel_1.add(lbl_Name);

		JLabel lbl_Surname = new JLabel("Surname");
		lbl_Surname.setBounds(748, 50, 62, 13);
		panel_1.add(lbl_Surname);

		JLabel lbl_ID = new JLabel("ID");
		lbl_ID.setBounds(748, 90, 45, 13);
		panel_1.add(lbl_ID);

		JLabel lblNewLabel = new JLabel("Class");
		lblNewLabel.setBounds(748, 131, 45, 13);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Faculty");
		lblNewLabel_1.setBounds(748, 172, 45, 13);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Department");
		lblNewLabel_2.setBounds(748, 213, 77, 13);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Advisor ID");
		lblNewLabel_3.setBounds(748, 254, 77, 13);
		panel_1.add(lblNewLabel_3);

		JLabel lbl_ID_1 = new JLabel("ID");
		lbl_ID_1.setBounds(748, 359, 45, 13);
		panel_1.add(lbl_ID_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Instructor Management", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(0, 0, 911, 432);
		panel_2.add(panel_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 728, 412);
		panel_1_1.add(scrollPane_1);

		table_2 = new JTable();

		String[] columnsInstructor = new String[] { "Name", "Surname", "ID", "Faculty", "Department", "Is Advisor" };
		Object[][] instructors = new Object[Main.instructorList.values().size()][6];
		calculateInstructors(instructors);
		table_2 = new JTable(instructors, columnsInstructor);

		TableColumnModel columnModelInstructor = table_2.getColumnModel();
		columnModelInstructor.getColumn(0).setPreferredWidth(20);
		columnModelInstructor.getColumn(1).setPreferredWidth(20);
		columnModelInstructor.getColumn(2).setPreferredWidth(10);

		table_2.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(table_2);

		fld_IName = new JTextField();
		fld_IName.setToolTipText("");
		fld_IName.setColumns(10);
		fld_IName.setBounds(748, 21, 143, 19);
		panel_1_1.add(fld_IName);

		fld_ISurname = new JTextField();
		fld_ISurname.setColumns(10);
		fld_ISurname.setBounds(748, 62, 143, 19);
		panel_1_1.add(fld_ISurname);

		fld_IID = new JTextField();
		fld_IID.setColumns(10);
		fld_IID.setBounds(748, 102, 143, 19);
		panel_1_1.add(fld_IID);

		fld_IFaculty = new JTextField();
		fld_IFaculty.setColumns(10);
		fld_IFaculty.setBounds(748, 144, 143, 19);
		panel_1_1.add(fld_IFaculty);

		fld_IDepartment = new JTextField();
		fld_IDepartment.setColumns(10);
		fld_IDepartment.setBounds(748, 185, 143, 19);
		panel_1_1.add(fld_IDepartment);

		JRadioButton rdBtn_True = new JRadioButton("True");
		rdBtn_True.setBackground(Color.WHITE);
		rdBtn_True.setBounds(744, 227, 62, 21);
		panel_1_1.add(rdBtn_True);

		JRadioButton rdBtn_False = new JRadioButton("False");
		rdBtn_False.setBackground(Color.WHITE);
		rdBtn_False.setBounds(808, 227, 62, 21);
		panel_1_1.add(rdBtn_False);

		rdBtn_False.setActionCommand("False");
		rdBtn_True.setActionCommand("True");

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdBtn_False);
		bgroup.add(rdBtn_True);

		JButton btn_AddInstructor = new JButton("Add New Instructor");
		btn_AddInstructor.addActionListener(e -> {
			if (fld_IName.getText().length() != 0 && fld_ISurname.getText().length() != 0
					&& fld_IID.getText().length() != 0 && fld_IFaculty.getText().length() != 0
					&& fld_IDepartment.getText().length() != 0 && bgroup.getSelection() != null) {

				if (bgroup.getSelection().getActionCommand().equals("True")) {
					Instructor instructor = new Instructor(fld_IName.getText(), fld_ISurname.getText(),
							fld_IID.getText(), fld_IFaculty.getText(), fld_IDepartment.getText(), true);

					Main.instructorList.put(instructor.getID(), instructor);
					Main.setInstructorsTaughtCourses();
					Helper.showMessage("success");
				} else if (bgroup.getSelection().getActionCommand().equals("False")) {
					Instructor instructor = new Instructor(fld_IName.getText(), fld_ISurname.getText(),
							fld_IID.getText(), fld_IFaculty.getText(), fld_IDepartment.getText(), false);

					Main.instructorList.put(instructor.getID(), instructor);
					Main.setInstructorsTaughtCourses();
					Helper.showMessage("success");

				} else {
					Helper.showMessage("fill");
				}
			} else {
				Helper.showMessage("fill");
			}
			fld_IName.setText("");
			fld_ISurname.setText("");
			fld_IID.setText("");
			fld_IFaculty.setText("");
			fld_IDepartment.setText("");
			bgroup.clearSelection();
			updateInstructorTable();
		});
		btn_AddInstructor.setBounds(748, 254, 143, 21);
		panel_1_1.add(btn_AddInstructor);

		fld_IDeleteID = new JTextField();
		fld_IDeleteID.setColumns(10);
		fld_IDeleteID.setBounds(748, 372, 143, 19);
		panel_1_1.add(fld_IDeleteID);

		JButton btn_IDelete = new JButton("Delete Instructor");
		btn_IDelete.addActionListener(e -> {
			if (fld_IDeleteID.getText().length() != 0) {
				if (Main.instructorList.get(fld_IDeleteID.getText()) != null) {
					if (Helper.confirm("sure")) {
						Main.instructorList.remove(fld_IDeleteID.getText(),
								Main.instructorList.get(fld_IDeleteID.getText()));
						updateInstructorTable();
						Helper.showMessage("success");
						fld_IDeleteID.setText("");
					}
				} else {
					Helper.showMessage("error");
				}
			} else {
				Helper.showMessage("fill");
			}
		});
		btn_IDelete.setBounds(748, 401, 143, 21);
		panel_1_1.add(btn_IDelete);

		JLabel lbl_Name_1 = new JLabel("Name");
		lbl_Name_1.setBounds(748, 10, 45, 13);
		panel_1_1.add(lbl_Name_1);

		JLabel lbl_Surname_1 = new JLabel("Surname");
		lbl_Surname_1.setBounds(748, 50, 62, 13);
		panel_1_1.add(lbl_Surname_1);

		JLabel lbl_ID_2 = new JLabel("ID");
		lbl_ID_2.setBounds(748, 90, 45, 13);
		panel_1_1.add(lbl_ID_2);

		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(748, 131, 45, 13);
		panel_1_1.add(lblFaculty);

		JLabel lblNewLabel_1_1 = new JLabel("Department");
		lblNewLabel_1_1.setBounds(748, 172, 77, 13);
		panel_1_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("isAdvisor");
		lblNewLabel_2_1.setBounds(748, 213, 77, 13);
		panel_1_1.add(lblNewLabel_2_1);

		JLabel lbl_ID_1_1 = new JLabel("ID");
		lbl_ID_1_1.setBounds(748, 359, 45, 13);
		panel_1_1.add(lbl_ID_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Course Management", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(0, 0, 911, 432);
		panel_3.add(panel_1_1_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 10, 728, 412);
		panel_1_1_1.add(scrollPane_1_1);
		
		table_3 = new JTable();
		
		String[] columnsCourse = new String[] { "Course Code", "Course Name", "Credit", "Semester"};
		Object[][] courses = new Object[Main.courseList.values().size()][4];
		calculateCourses(courses);
		table_3 = new JTable(courses, columnsCourse);

		TableColumnModel columnModelInstructor3 = table_3.getColumnModel();
		columnModelInstructor3.getColumn(0).setPreferredWidth(20);
		columnModelInstructor3.getColumn(1).setPreferredWidth(20);
		columnModelInstructor3.getColumn(2).setPreferredWidth(10);
		
		scrollPane_1_1.setViewportView(table_3);
		
		fld_CCode = new JTextField();
		fld_CCode.setToolTipText("");
		fld_CCode.setColumns(10);
		fld_CCode.setBounds(748, 22, 143, 19);
		panel_1_1_1.add(fld_CCode);
		
		fld_CName = new JTextField();
		fld_CName.setColumns(10);
		fld_CName.setBounds(748, 62, 143, 19);
		panel_1_1_1.add(fld_CName);
		
		fld_CCredit = new JTextField();
		fld_CCredit.setColumns(10);
		fld_CCredit.setBounds(748, 102, 143, 19);
		panel_1_1_1.add(fld_CCredit);
		
		fld_CSemester = new JTextField();
		fld_CSemester.setColumns(10);
		fld_CSemester.setBounds(748, 144, 143, 19);
		panel_1_1_1.add(fld_CSemester);
		
		JButton btn_AddCourse = new JButton("Add Course");
		btn_AddCourse.addActionListener(e -> {
			if (fld_CCode.getText().length() != 0
					&& fld_CName.getText().length() != 0
					&& fld_CCredit.getText().length() != 0
					&& fld_CSemester.getText().length() != 0) {

				Course course = new Course(fld_CCode.getText(),fld_CName.getText(),Integer.parseInt(fld_CCredit.getText()),Integer.parseInt(fld_CSemester.getText()));
				Main.courseList.put(course.getCourseCode(), course);
				Helper.showMessage("success");

			} else {
				Helper.showMessage("fill");
			}
			fld_IName.setText("");
			fld_ISurname.setText("");
			fld_IID.setText("");
			fld_IFaculty.setText("");
			fld_IDepartment.setText("");
			bgroup.clearSelection();
			updateCourseTable();

		});
		btn_AddCourse.setBounds(748, 173, 143, 21);
		panel_1_1_1.add(btn_AddCourse);
		
		fld_delCCode = new JTextField();
		fld_delCCode.setColumns(10);
		fld_delCCode.setBounds(748, 372, 143, 19);
		panel_1_1_1.add(fld_delCCode);
		
		JButton btn_delCourse = new JButton("Delete Course");
		btn_delCourse.addActionListener(e -> {
			if (fld_delCCode.getText().length() != 0) {
				if (Main.courseList.get(fld_delCCode.getText()) != null) {
					if (Helper.confirm("sure")) {
						Main.courseList.remove(fld_delCCode.getText(),
								Main.courseList.get(fld_delCCode.getText()));
						updateCourseTable();
						Helper.showMessage("success");
						fld_delCCode.setText("");
					}
				} else {
					Helper.showMessage("error");
				}
			} else {
				Helper.showMessage("fill");
			}
		});
		btn_delCourse.setBounds(748, 401, 143, 21);
		panel_1_1_1.add(btn_delCourse);
		
		JLabel lbl_Name_1_1 = new JLabel("Course Code");
		lbl_Name_1_1.setBounds(748, 10, 143, 13);
		panel_1_1_1.add(lbl_Name_1_1);
		
		JLabel lbl_Surname_1_1 = new JLabel("Course Name");
		lbl_Surname_1_1.setBounds(748, 50, 143, 13);
		panel_1_1_1.add(lbl_Surname_1_1);
		
		JLabel lbl_ID_2_1 = new JLabel("Credit");
		lbl_ID_2_1.setBounds(748, 90, 143, 13);
		panel_1_1_1.add(lbl_ID_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Semester");
		lblNewLabel_1_1_1.setBounds(748, 131, 143, 13);
		panel_1_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lbl_ID_1_1_1 = new JLabel("Course Code");
		lbl_ID_1_1_1.setBounds(748, 359, 143, 13);
		panel_1_1_1.add(lbl_ID_1_1_1);
	}

	private void calculateCourses(Object[][] courses) {
		int i = 0;
		for (Course course : Main.courseList.values()) {
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
			i++;
		}
	}

	private void calculateStudents(Object[][] students) {
		int i = 0;
		for (Student student : Main.studentList.values()) {
			students[i][0] = student.getName();
			students[i][1] = student.getSurname();
			students[i][2] = student.getID();
			students[i][3] = student.getClassLevel();
			students[i][4] = student.getFaculty();
			students[i][5] = student.getDepartment();
			students[i][6] = student.getAdvisor().getID();
			i++;
		}
	}

	private void calculateInstructors(Object[][] instructors) {
		int i = 0;
		for (Instructor instructor : Main.instructorList.values()) {
			instructors[i][0] = instructor.getName();
			instructors[i][1] = instructor.getSurname();
			instructors[i][2] = instructor.getID();
			instructors[i][3] = instructor.getFaculty();
			instructors[i][4] = instructor.getDepartment();
			instructors[i][5] = instructor.isAdvisor();
			i++;
		}
	}

	private void updateInstructorTable() {
		Object[][] instructors = new Object[Main.instructorList.values().size()][6];
		String[] columnsInstructor = new String[] { "Name", "Surname", "ID", "Faculty", "Department", "Is Advisor" };
		calculateInstructors(instructors);
		JTable table = new JTable(instructors, columnsInstructor);
		TableModel tableModel2 = table.getModel();
		table_2.setModel(tableModel2);
		TableColumnModel columnModelInstructor = table_2.getColumnModel();
		columnModelInstructor.getColumn(0).setPreferredWidth(20);
		columnModelInstructor.getColumn(1).setPreferredWidth(20);
		columnModelInstructor.getColumn(2).setPreferredWidth(10);
	}
	
	private void updateStudentTable() {
		Object[][] students = new Object[Main.studentList.values().size()][7];
		String[] columns = new String[] { "Name", "Surname", "ID", "Class", "Faculty", "Department", "Advisor (ID)" };
		calculateStudents(students);
		JTable table = new JTable(students, columns);
		TableModel tableModel = table.getModel();
		table_1.setModel(tableModel);
		
		TableColumnModel columnModel = table_1.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(5);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(6).setPreferredWidth(10);
	}
	

	private void updateCourseTable() {

		Object[][] courses = new Object[Main.courseList.values().size()][4];
		String[] columnsCourse = new String[] { "Course Code", "Course Name", "Credit", "Semester"};
		calculateCourses(courses);
		JTable table = new JTable(courses, columnsCourse);
		TableModel tableModel = table.getModel();
		table_3.setModel(tableModel);		
	}
}
