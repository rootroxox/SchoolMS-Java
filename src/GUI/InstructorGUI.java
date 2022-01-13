package GUI;

import Item.Course;
import Operations.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class InstructorGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				InstructorGUI frame = new InstructorGUI(args[0]);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InstructorGUI(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lbl_title = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		lbl_title.setBackground(Color.WHITE);
		lbl_title.setBounds(10, 10, 906, 32);
		panel.add(lbl_title);

		JLabel lbl_title_1 = new JLabel("Instructor Panel");
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

		JLabel lbl_title_1_1_2_1 = new JLabel(Main.instructorList.get(name).getName());
		lbl_title_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title_1_1_2_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lbl_title_1_1_2_1.setBackground(Color.WHITE);
		lbl_title_1_1_2_1.setBounds(106, 52, 165, 32);
		panel.add(lbl_title_1_1_2_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 94, 906, 449);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Information", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon("instructorInfoLogo.png"));
		lblNewLabel.setBounds(27, 10, 434, 412);
		panel_1.add(lblNewLabel);

		JLabel lbl_IName = new JLabel("Name");
		lbl_IName.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_IName.setBounds(518, 24, 80, 27);
		panel_1.add(lbl_IName);

		JLabel lbl_ISurname = new JLabel("Surname");
		lbl_ISurname.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_ISurname.setBounds(518, 85, 97, 27);
		panel_1.add(lbl_ISurname);

		JLabel lbl_IID = new JLabel("ID");
		lbl_IID.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_IID.setBounds(518, 146, 80, 27);
		panel_1.add(lbl_IID);

		JLabel fld_IName = new JLabel(Main.instructorList.get(name).getName());
		fld_IName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_IName.setBounds(518, 48, 373, 27);
		panel_1.add(fld_IName);

		JLabel fld_ISurname = new JLabel(Main.instructorList.get(name).getSurname());
		fld_ISurname.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_ISurname.setBounds(518, 109, 373, 27);
		panel_1.add(fld_ISurname);

		JLabel fld_IID = new JLabel(Main.instructorList.get(name).getID());
		fld_IID.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_IID.setBounds(518, 170, 373, 27);
		panel_1.add(fld_IID);

		JLabel lbl_IFaculty = new JLabel("Faculty");
		lbl_IFaculty.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_IFaculty.setBounds(518, 207, 80, 27);
		panel_1.add(lbl_IFaculty);

		JLabel fld_IFaculty = new JLabel(Main.instructorList.get(name).getFaculty());
		fld_IFaculty.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_IFaculty.setBounds(518, 232, 373, 27);
		panel_1.add(fld_IFaculty);

		JLabel lbl_IDepartment = new JLabel("Department");
		lbl_IDepartment.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_IDepartment.setBounds(518, 269, 114, 27);
		panel_1.add(lbl_IDepartment);

		JLabel fld_IDepartment = new JLabel(Main.instructorList.get(name).getDepartment());
		fld_IDepartment.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_IDepartment.setBounds(518, 298, 373, 27);
		panel_1.add(fld_IDepartment);

		JLabel lbl_IAdvisor = new JLabel("Is Advisor");
		lbl_IAdvisor.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_IAdvisor.setBounds(518, 335, 97, 27);
		panel_1.add(lbl_IAdvisor);

		JLabel fld_IAdvisor = new JLabel();
		fld_IAdvisor.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_IAdvisor.setBounds(518, 359, 373, 27);
		fld_IAdvisor.setText("False");
		if (Main.instructorList.get(name).isAdvisor())
			fld_IAdvisor.setText("True");

		panel_1.add(fld_IAdvisor);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Taught Courses", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(0, 0, 911, 432);
		panel_2.add(panel_1_1_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(0, 0, 901, 422);
		panel_1_1_1.add(scrollPane_1_1);

		String[] columnsCourse = new String[] { "Course Code", "Course Name", "Credit", "Semester" };
		Object[][] courses = new Object[Main.instructorList.get(name).getTaughtCourses().size()][4];
		calculateCourses(courses, name);

		JTable table = new JTable(courses, columnsCourse);

		TableColumnModel columnModelInstructor3 = table.getColumnModel();
		columnModelInstructor3.getColumn(0).setPreferredWidth(20);
		columnModelInstructor3.getColumn(1).setPreferredWidth(20);
		columnModelInstructor3.getColumn(2).setPreferredWidth(10);

		scrollPane_1_1.setViewportView(table);
	}

	private void calculateCourses(Object[][] courses, String ID) {
		int i = 0;
		for (Course course : Main.instructorList.get(ID).getTaughtCourses().values()) {
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
			i++;
		}
	}
}
