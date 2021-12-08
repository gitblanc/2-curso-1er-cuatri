package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logic.LogedUser;
import logic.User;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUser;
	private JLabel lbUser;
	private JLabel lbPassword;
	private JLabel lbLoginTitle;
	private JPasswordField passUser;
	private static ArrayList<User> users;
	private JTextField textError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog(users);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param users 
	 */
	public LoginDialog(ArrayList<User> users) {
		this.users = users;
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginDialog.class.getResource("/img/libreria.jpg")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTxtUser());
		contentPanel.add(getLbUser());
		contentPanel.add(getLbPassword());
		contentPanel.add(getLbLoginTitle());
		contentPanel.add(getPassUser());
		contentPanel.add(getTextError());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						if(comprobarUserPass(txtUser.getText(), passUser.getText()))
						{
							try {
								LogedUser.logedUser=getUserPass(txtUser.getText());
								dispose();
							} catch (Throwable e) {
								e.printStackTrace();
							}
						}
						
						else
						{
							textError.setText("Usuario/Contraseña no vialido");
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public boolean comprobarUserPass(String user_id, String pass)
	{
		for(User u : users)
		{
			if(u.getDni().equals(user_id) && u.getPass().equals(pass))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public User getUserPass(String user_id)
	{
		for(User u : users)
		{
			if(u.getDni().equals(user_id))
			{
				return u;
			}
		}
		
		return null;
	}
	
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtUser.setBounds(125, 106, 257, 20);
			txtUser.setColumns(10);
		}
		return txtUser;
	}
	private JLabel getLbUser() {
		if (lbUser == null) {
			lbUser = new JLabel("User");
			lbUser.setLabelFor(getTxtUser());
			lbUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbUser.setBounds(35, 109, 80, 14);
		}
		return lbUser;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Password");
			lbPassword.setLabelFor(getPassUser());
			lbPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbPassword.setBounds(35, 155, 80, 14);
		}
		return lbPassword;
	}
	private JLabel getLbLoginTitle() {
		if (lbLoginTitle == null) {
			lbLoginTitle = new JLabel("Please enter your user & password");
			lbLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbLoginTitle.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
			lbLoginTitle.setBounds(67, 25, 301, 26);
		}
		return lbLoginTitle;
	}
	private JPasswordField getPassUser() {
		if (passUser == null) {
			passUser = new JPasswordField();
			passUser.setBounds(125, 153, 257, 20);
		}
		return passUser;
	}
	private JTextField getTextError() {
		if (textError == null) {
			textError = new JTextField();
			textError.setEnabled(false);
			textError.setEditable(false);
			textError.setBounds(35, 198, 368, 20);
			textError.setColumns(10);
		}
		return textError;
	}
}
