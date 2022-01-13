package Helper;

import javax.swing.*;

public class Helper {
	public static void showMessage(String str) {
		String msg;

		switch (str) {
		case "fill" -> msg = "Please fill all empty fields!";
		case "success" -> msg = "Operation completed successfully!";
		case "girisok" -> msg = "Logged In Successfully!";
		case "wrong" -> msg = "Username or Password is Wrong!";
		case "error" -> msg = "An Error Occurred!";
		default -> msg = str;
		}
		JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean confirm(String str) {
		String msg;
		if ("sure".equals(str)) {
			msg = "Do you want to perform this operation?";
		} else {
			msg = str;
		}

		int res = JOptionPane.showConfirmDialog(null, msg, "Attention!", JOptionPane.YES_NO_OPTION);
		return res == 0;
	}
}
