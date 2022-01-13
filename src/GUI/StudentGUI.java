package GUI;

import Item.Course;
import Operations.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class StudentGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				StudentGUI frame = new StudentGUI(args[0]);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	static double totalCredit = 0.0;

	public StudentGUI(String ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lbl_title = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lbl_title.setBounds(10, 10, 906, 32);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		lbl_title.setBackground(Color.WHITE);
		panel.add(lbl_title);

		JLabel lbl_title_1 = new JLabel("Student Panel");
		lbl_title_1.setBounds(281, 34, 365, 32);
		lbl_title_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_title_1.setBackground(Color.WHITE);
		panel.add(lbl_title_1);

		JLabel lbl_title_1_1_2 = new JLabel("Welcome,");
		lbl_title_1_1_2.setBounds(10, 52, 91, 32);
		lbl_title_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_title_1_1_2.setBackground(Color.WHITE);
		panel.add(lbl_title_1_1_2);

		JLabel lbl_title_1_1_2_1 = new JLabel(Main.studentList.get(ID).getName());
		lbl_title_1_1_2_1.setBounds(106, 52, 165, 32);
		lbl_title_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title_1_1_2_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lbl_title_1_1_2_1.setBackground(Color.WHITE);
		panel.add(lbl_title_1_1_2_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 94, 906, 449);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Information", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon("studentInfoLogo.png"));
		lblNewLabel.setBounds(27, 10, 434, 412);
		panel_1.add(lblNewLabel);

		JLabel lbl_SName = new JLabel("Name");
		lbl_SName.setBounds(518, 10, 80, 27);
		lbl_SName.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		panel_1.add(lbl_SName);

		JLabel lbl_SSurname = new JLabel("Surname");
		lbl_SSurname.setBounds(518, 61, 97, 27);
		lbl_SSurname.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		panel_1.add(lbl_SSurname);

		JLabel lbl_SID = new JLabel("ID");
		lbl_SID.setBounds(518, 117, 80, 27);
		lbl_SID.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		panel_1.add(lbl_SID);

		JLabel fld_SName = new JLabel(Main.studentList.get(ID).getName());
		fld_SName.setBounds(518, 33, 373, 27);
		fld_SName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panel_1.add(fld_SName);

		JLabel fld_SSurname = new JLabel(Main.studentList.get(ID).getSurname());
		fld_SSurname.setBounds(518, 86, 373, 27);
		fld_SSurname.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panel_1.add(fld_SSurname);

		JLabel fld_SID = new JLabel(Main.studentList.get(ID).getID());
		fld_SID.setBounds(518, 142, 373, 27);
		fld_SID.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panel_1.add(fld_SID);

		JLabel lbl_SDepartment = new JLabel("Department");
		lbl_SDepartment.setBounds(518, 226, 114, 27);
		lbl_SDepartment.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		panel_1.add(lbl_SDepartment);

		JLabel fld_SDepartment = new JLabel(Main.studentList.get(ID).getDepartment());
		fld_SDepartment.setBounds(518, 253, 373, 27);
		fld_SDepartment.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panel_1.add(fld_SDepartment);

		JLabel lbl_IFaculty_1 = new JLabel("Class");
		lbl_IFaculty_1.setBounds(518, 170, 80, 27);
		lbl_IFaculty_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		panel_1.add(lbl_IFaculty_1);

		JLabel fld_SClass = new JLabel(String.valueOf(Main.studentList.get(ID).getClassLevel()));
		fld_SClass.setBounds(518, 196, 373, 27);
		fld_SClass.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panel_1.add(fld_SClass);

		JLabel lbl_SFaculty = new JLabel("Faculty");
		lbl_SFaculty.setBounds(518, 285, 80, 27);
		lbl_SFaculty.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		panel_1.add(lbl_SFaculty);

		JLabel fld_SFaculty = new JLabel(Main.studentList.get(ID).getFaculty());
		fld_SFaculty.setBounds(518, 312, 373, 27);
		fld_SFaculty.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panel_1.add(fld_SFaculty);

		JLabel lbl_SGPA = new JLabel("GPA");
		lbl_SGPA.setBounds(518, 350, 80, 27);
		lbl_SGPA.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		panel_1.add(lbl_SGPA);

		JLabel fld_SGPA = new JLabel(String.valueOf(Main.studentList.get(ID).getGPA()));
		fld_SGPA.setBounds(518, 378, 373, 27);
		fld_SGPA.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		panel_1.add(fld_SGPA);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("Taken Courses", null, panel_2, null);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(0, 0, 901, 421);
		panel_2.add(panel_1_1_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(0, 0, 901, 422);
		panel_1_1_1.add(scrollPane_1_1);

		String[] columnsCourse = new String[] { "Course Code", "Course Name", "Credit", "Semester" };
		Object[][] courses = new Object[Main.studentList.get(ID).getTakenCourses().size()][4];
		calculateTakenCourses(courses, ID);

		JTable table = new JTable(courses, columnsCourse);

		TableColumnModel colModelStudent = table.getColumnModel();
		colModelStudent.getColumn(0).setPreferredWidth(20);
		colModelStudent.getColumn(1).setPreferredWidth(20);
		colModelStudent.getColumn(2).setPreferredWidth(10);

		scrollPane_1_1.setViewportView(table);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Transcript", null, panel_3, null);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 670, 421);
		panel_3.add(scrollPane);

		columnsCourse = new String[] { "Course Code", "Course Name", "Credit", "Semester", "Pass Credit", "Pass Grade"};
		courses = new Object[Main.studentList.get(ID).getTranscript().getCompletedCourses().size()][6];

		calculateTranscriptCourses(courses, ID);

		JTable table_1 = new JTable(courses, columnsCourse);

		TableColumnModel colModelStudent1 = table_1.getColumnModel();
		colModelStudent1.getColumn(0).setPreferredWidth(30);
		colModelStudent1.getColumn(1).setPreferredWidth(90);
		colModelStudent1.getColumn(2).setPreferredWidth(3);
		colModelStudent1.getColumn(3).setPreferredWidth(5);
		colModelStudent1.getColumn(4).setPreferredWidth(5);
		colModelStudent1.getColumn(5).setPreferredWidth(5);

		scrollPane.setViewportView(table_1);
		
		JLabel lbl_GPA = new JLabel("GPA");
		lbl_GPA.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_GPA.setBounds(682, 11, 80, 27);
		panel_3.add(lbl_GPA);
		
		JLabel fld_GPA = new JLabel(String.valueOf(Main.studentList.get(ID).getGPA()));
		fld_GPA.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_GPA.setBounds(682, 34, 209, 27);
		panel_3.add(fld_GPA);
		
		JLabel lbl_STotalCredits = new JLabel("Total Credits Earned");
		lbl_STotalCredits.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_STotalCredits.setBounds(682, 88, 165, 27);
		panel_3.add(lbl_STotalCredits);
		
		JLabel fld_STotalCredits = new JLabel(String.valueOf(totalCredit));
		fld_STotalCredits.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_STotalCredits.setBounds(682, 113, 209, 27);
		panel_3.add(fld_STotalCredits);
		
		JLabel lbl_SRank = new JLabel("Rank in Department");
		lbl_SRank.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_SRank.setBounds(682, 167, 165, 27);
		panel_3.add(lbl_SRank);
		
		JLabel fld_SRank = new JLabel(String.valueOf(Main.studentList.get(ID).getRank()));
		fld_SRank.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_SRank.setBounds(682, 192, 209, 27);
		panel_3.add(fld_SRank);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Curriculum", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBounds(0, 0, 901, 422);
		panel_4.add(scrollPane_1_1_1);
		
		columnsCourse = new String[] { "Course Code", "Course Name", "Credit", "Semester"};
		courses = new Object[Main.studentList.get(ID).getCurriculum().size()][4];
		calculateCurriculumCourses(courses, ID);

		JTable table_2 = new JTable(courses, columnsCourse);
		
		TableColumnModel colModelStudent2 = table_2.getColumnModel();
		colModelStudent2.getColumn(0).setPreferredWidth(30);
		colModelStudent2.getColumn(1).setPreferredWidth(90);
		colModelStudent2.getColumn(2).setPreferredWidth(3);
		colModelStudent2.getColumn(3).setPreferredWidth(5);
		
		scrollPane_1_1_1.setViewportView(table_2);
	}

	private void calculateCurriculumCourses(Object[][] courses, String ID) {
		for (int i = 0; i < Main.studentList.get(ID).getCurriculum().size(); i++) {
			Course course = Main.studentList.get(ID).getCurriculum().get(i);
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
		}
	}

	private void calculateTakenCourses(Object[][] courses, String ID) {

		for (int i = 0; i < Main.studentList.get(ID).getTakenCourses().size(); i++) {
			Course course = Main.studentList.get(ID).getTakenCourses().get(i).getCourse();
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
		}
	}
	
	private void calculateTranscriptCourses(Object[][] courses, String ID) {
		totalCredit = 0.0;
		for (int i = 0; i < Main.studentList.get(ID).getTranscript().getCompletedCourses().size();i++) {
			Course course = Main.studentList.get(ID).getTranscript().getCompletedCourses().get(i).getCourse();
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
			courses[i][4] = Main.studentList.get(ID).getTranscript().getCompletedCourses().get(i).getPassCredit();
			courses[i][5] = Main.studentList.get(ID).getTranscript().getCompletedCourses().get(i).getPassGrade();
			totalCredit += course.getCredit();
		}
	}
}
