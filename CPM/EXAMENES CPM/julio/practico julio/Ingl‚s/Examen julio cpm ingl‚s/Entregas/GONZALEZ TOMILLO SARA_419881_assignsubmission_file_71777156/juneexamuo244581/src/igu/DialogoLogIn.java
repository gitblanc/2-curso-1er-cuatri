package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.*;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoLogIn extends JDialog {

	private VentanaPrincipal vP;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblDni;
	private JTextField textField;
	private JLabel lblPassword;
	private JPasswordField passwordField;

	/**
	 * Create the dialog.
	 */
	public DialogoLogIn(VentanaPrincipal vP) {
		setResizable(false);
		setModal(true);
		setTitle("Libreria EII Oviedo - Log in");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoLogIn.class.getResource("/img/libreria.jpg")));
		this.vP = vP;
		
		setBounds(100, 100, 342, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblDni());
		contentPanel.add(getTextField());
		contentPanel.add(getLblPassword());
		contentPanel.add(getPasswordField());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(checkCredentials()){
							vP.setVisible(true);
							vP.setLocationRelativeTo(null);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect credentials", "ERROR", JOptionPane.ERROR_MESSAGE);
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
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setIcon(new ImageIcon(DialogoLogIn.class.getResource("/img/libreria.jpg")));
			getContentPane().add(lblLogo, BorderLayout.NORTH);
		}
	}

	
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI:");
			lblDni.setLabelFor(getTextField());
			lblDni.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			lblDni.setBounds(30, 40, 74, 14);
		}
		return lblDni;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setToolTipText("Introduce your dni");
			textField.setBounds(116, 37, 188, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setLabelFor(getPasswordField());
			lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			lblPassword.setBounds(30, 98, 74, 14);
		}
		return lblPassword;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setToolTipText("Introduce your password");
			passwordField.setBounds(116, 95, 188, 20);
		}
		return passwordField;
	}
	

	private boolean checkCredentials(){
		boolean isCorrect = false;
		String dni = textField.getText();
		char[] password = passwordField.getPassword();
	
		if(dni.length() == 0)
			JOptionPane.showMessageDialog(null, "Please introduce a dni", "ERROR", JOptionPane.ERROR_MESSAGE);
		else if(password.length == 0)
			JOptionPane.showMessageDialog(null, "Please introduce a dni", "ERROR", JOptionPane.ERROR_MESSAGE);
		else{
			for(Cliente c : vP.getClientes()){
				if(c.getDNI().equals(dni) && password.length == c.getPassword().length()){
					isCorrect = true;
					for(int i = 0; i < password.length; i++){
						if(password[i] != c.getPassword().toCharArray()[i])
							isCorrect = false;
					}
					if(isCorrect)
						vP.setCliente(c);
					break;
				}
			}
		}
		
		return isCorrect;
	}
}
