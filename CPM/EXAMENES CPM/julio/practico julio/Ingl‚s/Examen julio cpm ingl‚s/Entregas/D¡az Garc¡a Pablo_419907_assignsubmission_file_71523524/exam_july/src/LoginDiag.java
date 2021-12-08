import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginDiag extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] id;
	String[] clients;
	String[] passwords;
	private JButton btnLogin;
	private JLabel lblPassword;
	private JLabel lblUser;
	private JPasswordField pwdPswdfield;
	private JTextField textField;
	private JLabel lblIcon;
	private JDialog login;
	int currentUser;
	boolean status=true;

	public LoginDiag() {
		leerClientes();
		initialize();
	}


	private void initialize() {
		login=new JDialog();
		login.setResizable(false);
		login.setUndecorated(true);
		login.setModal(true);
		login.setAlwaysOnTop(true);
		login.getContentPane().setLayout(null);
		login.getContentPane().add(getLblIcon());
		login.getContentPane().add(getTextField());
		login.getContentPane().add(getPwdPswdfield());
		login.getContentPane().add(getLblUser());
		login.getContentPane().add(getLblPassword());
		login.getContentPane().add(getBtnLogin());
	}

	
	private boolean checkLogin(String string, char[] cs) {
		for (int i = 0; i <= id.length; i++) {
			if (string == id[i])
				if (cs.toString() == passwords[i]) {
					currentUser = i;
					return true;
				}
		}
		return false;
	}

	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("");
			lblIcon.setIcon(new ImageIcon(
					"C:\\Users\\Alumno\\Desktop\\ecksam\\Exam_July\\img\\libreria.jpg"));
			lblIcon.setBounds(62, 30, 318, 155);
		}
		return lblIcon;
	}

	public Icon getLblIconIcon() {
		return getLblIcon().getIcon();
	}

	public void setLblIconIcon(Icon icon) {
		getLblIcon().setIcon(icon);
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(126, 196, 153, 30);
			textField.setColumns(10);
		}
		return textField;
	}

	private JPasswordField getPwdPswdfield() {
		if (pwdPswdfield == null) {
			pwdPswdfield = new JPasswordField();
			pwdPswdfield.setBounds(126, 237, 153, 30);
		}
		return pwdPswdfield;
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("USER");
			lblUser.setBounds(70, 204, 46, 14);
		}
		return lblUser;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("PASSWORD");
			lblPassword.setBounds(60, 245, 65, 14);
		}
		return lblPassword;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("LOGIN");
			btnLogin.addActionListener(new ActionListener() {
				private JPasswordField pwdPswdfield;

				public void actionPerformed(ActionEvent arg0) {
					status= checkLogin(textField.getText(),pwdPswdfield.getPassword());
						
				}
			});
			btnLogin.setBounds(311, 196, 89, 71);
		}
		return btnLogin;
	}
	
	void leerClientes() {
		String nombreFichero = "clientes.dat";
		String linea = "";
		id = new String[20];
		passwords = new String[20];
		clients = new String[20];
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			// Mientras quede información
			while (fichero.ready()) {
				int i = 0;
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				id[i] = trozos[0];
				clients[i] = trozos[1] + ":" + trozos[2];
				passwords[i] = trozos[3];
				i++;
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O error");
		}
	}
}
