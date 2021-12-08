package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.User;

public class LoginDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnMain;
	private JButton btnLogin;
	private JPanel pnLogin;
	private JLabel lblUsername;
	private JTextField txtUser;
	private JLabel lblPassword;
	private JPanel pnUserName;
	private JPasswordField tbPassword;
	private JLabel lblError;
	private JPanel pnPassword;
	private JLabel lblIcon;
	private MainWindow window;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public LoginDialog(MainWindow window) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnMain(), BorderLayout.CENTER);
		this.window = window;
	}

	private JPanel getPnMain() {
		if (pnMain == null) {
			pnMain = new JPanel();
			pnMain.setLayout(new BorderLayout(0, 0));
			pnMain.add(getBtnLogin(), BorderLayout.SOUTH);
			pnMain.add(getPnLogin(), BorderLayout.CENTER);
		}
		return pnMain;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean log = User.doLogin(getTxtUser().getText(), getTbPassword().getText());
					if(log) {
						getTbPassword().setText("");
						getTxtUser().setText("");
						getLblError().setVisible(false);
						window.SetLogged(true);
						dispose();
					}
					else {
						getTbPassword().setText("");
						getTxtUser().setText("");
						getLblError().setVisible(true);
					}
				}
			});
			btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
			btnLogin.setPreferredSize(new Dimension(35, 23));
		}
		return btnLogin;
	}
	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			pnLogin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnLogin.add(getLblIcon());
			pnLogin.add(getPnUserName());
			pnLogin.add(getPnPassword());
			pnLogin.add(getLblError());
		}
		return pnLogin;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username: ");
			lblUsername.setDisplayedMnemonic('n');
			lblUsername.setLabelFor(getTxtUser());
		}
		return lblUsername;
	}
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setColumns(10);
		}
		return txtUser;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setDisplayedMnemonic('p');
			lblPassword.setLabelFor(getTbPassword());
		}
		return lblPassword;
	}
	private JPanel getPnUserName() {
		if (pnUserName == null) {
			pnUserName = new JPanel();
			pnUserName.add(getLblUsername());
			pnUserName.add(getTxtUser());
		}
		return pnUserName;
	}
	private JPasswordField getTbPassword() {
		if (tbPassword == null) {
			tbPassword = new JPasswordField();
			tbPassword.setPreferredSize(new Dimension(85, 20));
			tbPassword.setMinimumSize(new Dimension(35, 20));
		}
		return tbPassword;
	}
	private JLabel getLblError() {
		if (lblError == null) {
			lblError = new JLabel("Username or password incorrect");
			lblError.setVisible(false);
		}
		return lblError;
	}
	private JPanel getPnPassword() {
		if (pnPassword == null) {
			pnPassword = new JPanel();
			pnPassword.add(getLblPassword());
			pnPassword.add(getTbPassword());
		}
		return pnPassword;
	}
	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("");
			lblIcon.setHorizontalTextPosition(SwingConstants.LEFT);
			lblIcon.setHorizontalAlignment(SwingConstants.LEFT);
			lblIcon.setIcon(new ImageIcon(MainWindow.class.getResource("/img/libreria.jpg")));
		}
		return lblIcon;
	}
}
