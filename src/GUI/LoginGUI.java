package GUI;

import Helper.Helper;
import Operations.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginGUI extends JFrame {

	private final JTextField fld_ID;
	private final JPasswordField fld_Pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Main.main(args);
				LoginGUI frame = new LoginGUI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p_login = new JPanel();
		p_login.setBackground(Color.WHITE);
		p_login.setBounds(0, 0, 684, 411);
		contentPane.add(p_login);
		p_login.setLayout(null);
		
		JLabel lbl_title = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lbl_title.setBackground(Color.WHITE);
		lbl_title.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(10, 11, 664, 38);
		p_login.add(lbl_title);
		
		JRadioButton rBtn_StudentLogin = new JRadioButton("Student Login");
		rBtn_StudentLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		rBtn_StudentLogin.setHorizontalAlignment(SwingConstants.LEFT);
		rBtn_StudentLogin.setBackground(Color.WHITE);
		rBtn_StudentLogin.setBounds(134, 314, 139, 25);
		p_login.add(rBtn_StudentLogin);
		
		JRadioButton rBtn_InstructorLogin = new JRadioButton("Instructor Login");
		rBtn_InstructorLogin.setHorizontalAlignment(SwingConstants.LEFT);
		rBtn_InstructorLogin.setBackground(Color.WHITE);
		rBtn_InstructorLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		rBtn_InstructorLogin.setBounds(275, 314, 150, 25);
		p_login.add(rBtn_InstructorLogin);
		
		JRadioButton rBtn_AdminLogin = new JRadioButton("Admin Login");
		rBtn_AdminLogin.setHorizontalAlignment(SwingConstants.LEFT);
		rBtn_AdminLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		rBtn_AdminLogin.setBackground(Color.WHITE);
		rBtn_AdminLogin.setBounds(427, 314, 150, 25);
		p_login.add(rBtn_AdminLogin);
		
		ButtonGroup bgroup = new ButtonGroup();
		rBtn_AdminLogin.setActionCommand("Admin");
		rBtn_InstructorLogin.setActionCommand("Instructor");
		rBtn_StudentLogin.setActionCommand("Student");
		bgroup.add(rBtn_StudentLogin);
		bgroup.add(rBtn_InstructorLogin);
		bgroup.add(rBtn_AdminLogin);
		
		fld_ID = new JTextField();
		fld_ID.setBounds(269, 256, 208, 20);
		p_login.add(fld_ID);
		fld_ID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setBounds(196, 256, 63, 14);
		p_login.add(lblNewLabel);
		
		fld_Pass = new JPasswordField();
		fld_Pass.setBounds(269, 287, 208, 20);
		p_login.add(fld_Pass);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblPassword.setBounds(191, 287, 68, 14);
		p_login.add(lblPassword);
		
		JLabel picLabel = new JLabel(new ImageIcon("loginLogo.png"));
		picLabel.setBounds(255, 65, 175, 175);
		p_login.add(picLabel);
		
		JButton btn_Login = new JButton("LOGIN");
		btn_Login.setBackground(Color.WHITE);
		btn_Login.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_Login.addActionListener(e -> {

			try {
				if(bgroup.getSelection().getActionCommand().equals("Admin")) {
					String ID = fld_ID.getText();
					String password = "a"+fld_ID.getText();

					if(Main.managerList.containsKey(ID) && password.equals(String.valueOf(fld_Pass.getPassword()))) {
						Helper.showMessage("girisok");
						LoginGUI.getFrames()[0].dispose();
						String[] array = new String[1];
						array[0] = Main.managerList.get(ID).getName();
						AdminGUI.main(array);
					}
					else {
						Helper.showMessage("wrong");
					}
				}
				else if(bgroup.getSelection().getActionCommand().equals("Instructor")){
					String ID = fld_ID.getText();
					String password = "i"+fld_ID.getText();

					if(Main.instructorList.containsKey(ID) && password.equals(String.valueOf(fld_Pass.getPassword()))) {
						Helper.showMessage("girisok");
						LoginGUI.getFrames()[0].dispose();
						String[] array = new String[1];
						array[0] = Main.instructorList.get(ID).getID();
						InstructorGUI.main(array);
					}
					else {
						Helper.showMessage("wrong");
					}
				}
				else if(bgroup.getSelection().getActionCommand().equals("Student")) {
					String ID = fld_ID.getText();
					String password = "s"+fld_ID.getText();

					if(Main.studentList.containsKey(ID) && password.equals(String.valueOf(fld_Pass.getPassword()))) {
						Helper.showMessage("girisok");
						LoginGUI.getFrames()[0].dispose();
						String[] array = new String[1];
						array[0] = Main.studentList.get(ID).getID();
						StudentGUI.main(array);
					}
					else {
						Helper.showMessage("wrong");
					}
				}
			} catch (Exception e2) {
				Helper.showMessage("fill");
			}
		});
		btn_Login.setBounds(282, 361, 120, 23);
		p_login.add(btn_Login);
		
		
		
	}
}
