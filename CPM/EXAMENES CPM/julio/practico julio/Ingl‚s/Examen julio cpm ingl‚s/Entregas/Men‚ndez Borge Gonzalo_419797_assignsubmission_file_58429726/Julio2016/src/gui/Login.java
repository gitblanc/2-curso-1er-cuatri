package gui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JDialog {

	private static final long serialVersionUID = -5405432051422934025L;
	private JLabel lblUsersLogin;
	private JPanel pnEast;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JTextField txUser;
	private JPasswordField pwPassword;
	private JPanel pnWest;
	private JLabel lblImg;
	private JButton btnLogin;
	
	private MainWindow mainWindow;

	/**
	 * Create the dialog.
	 */
	public Login(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
		
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Librer\u00EDa EII Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/libreria.jpg")));
		setBounds(100, 100, 650, 300);
		getContentPane().add(getLblUsersLogin(), BorderLayout.NORTH);
		getContentPane().add(getPnEast(), BorderLayout.EAST);
		getContentPane().add(getPnWest(), BorderLayout.WEST);
		getRootPane().setDefaultButton(btnLogin);
	}

	private JLabel getLblUsersLogin() {
		if (lblUsersLogin == null) {
			lblUsersLogin = new JLabel("User's Login");
			lblUsersLogin.setForeground(SystemColor.textHighlight);
			lblUsersLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsersLogin.setFont(new Font("SansSerif", Font.BOLD, 30));
		}
		return lblUsersLogin;
	}
	private JPanel getPnEast() {
		if (pnEast == null) {
			pnEast = new JPanel();
			pnEast.setBorder(null);
			pnEast.setBackground(Color.WHITE);
			GroupLayout gl_pnEast = new GroupLayout(pnEast);
			gl_pnEast.setHorizontalGroup(
				gl_pnEast.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnEast.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
									.addComponent(getLblPassword())
									.addComponent(getLblUser()))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
									.addComponent(getTxUser(), GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addComponent(getPwPassword(), GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_pnEast.createSequentialGroup()
								.addComponent(getBtnLogin())
								.addGap(71))))
			);
			gl_pnEast.setVerticalGroup(
				gl_pnEast.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnEast.createSequentialGroup()
						.addGap(79)
						.addGroup(gl_pnEast.createParallelGroup(Alignment.TRAILING)
							.addComponent(getTxUser(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblUser()))
						.addGap(18)
						.addGroup(gl_pnEast.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblPassword())
							.addComponent(getPwPassword(), GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addComponent(getBtnLogin())
						.addContainerGap(58, Short.MAX_VALUE))
			);
			gl_pnEast.linkSize(SwingConstants.VERTICAL, new Component[] {getLblPassword(), getLblUser()});
			gl_pnEast.linkSize(SwingConstants.VERTICAL, new Component[] {getPwPassword(), getTxUser()});
			gl_pnEast.linkSize(SwingConstants.HORIZONTAL, new Component[] {getPwPassword(), getTxUser()});
			pnEast.setLayout(gl_pnEast);
		}
		return pnEast;
	}
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User (ID) :");
			lblUser.setLabelFor(getTxUser());
			lblUser.setDisplayedMnemonic('U');
			lblUser.setFont(new Font("SansSerif", Font.BOLD, 14));
		}
		return lblUser;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setLabelFor(getPwPassword());
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setFont(new Font("SansSerif", Font.BOLD, 14));
		}
		return lblPassword;
	}
	private JTextField getTxUser() {
		if (txUser == null) {
			txUser = new JTextField();
			txUser.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					txUser.selectAll();
				}
			});
			txUser.setColumns(10);
		}
		return txUser;
	}
	private JPasswordField getPwPassword() {
		if (pwPassword == null) {
			pwPassword = new JPasswordField();
			pwPassword.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					pwPassword.selectAll();
				}
			});
		}
		return pwPassword;
	}
	private JPanel getPnWest() {
		if (pnWest == null) {
			pnWest = new JPanel();
			pnWest.setBorder(null);
			pnWest.setBackground(Color.WHITE);
			GroupLayout gl_pnWest = new GroupLayout(pnWest);
			gl_pnWest.setHorizontalGroup(
				gl_pnWest.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnWest.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblImg(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_pnWest.setVerticalGroup(
				gl_pnWest.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnWest.createSequentialGroup()
						.addGap(39)
						.addComponent(getLblImg(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(38))
			);
			pnWest.setLayout(gl_pnWest);
		}
		return pnWest;
	}
	private JLabel getLblImg() {
		if (lblImg == null) {
			lblImg = new JLabel("");
			lblImg.setIcon(new ImageIcon(Login.class.getResource("/img/libreria.jpg")));
		}
		return lblImg;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setMnemonic(KeyEvent.VK_ENTER);
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(mainWindow.getApp().checkLogin(txUser.getText(), String.valueOf(pwPassword.getPassword()))) {
						mainWindow.getApp().createPedido(txUser.getText());
						mainWindow.setVisibility(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(mainWindow.getLogin(), "Incorrect user and/or password!");
						txUser.grabFocus();
					}
				}
			});
			btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return btnLogin;
	}
	
	protected void reset() {
		txUser.setText("");
		pwPassword.setText("");
		getRootPane().setDefaultButton(btnLogin);
	}
}
