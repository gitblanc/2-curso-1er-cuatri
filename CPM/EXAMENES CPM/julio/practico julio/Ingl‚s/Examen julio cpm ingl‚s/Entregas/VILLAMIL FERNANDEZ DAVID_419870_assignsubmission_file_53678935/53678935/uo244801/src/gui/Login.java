package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logic.Client;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblImagen;
	private JLabel lblDni;
	private JLabel lblPassword;
	private JTextField tfDni;
	private JPasswordField passwordField;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Login dialog = new Login();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Login(ArrayList<Client> clients, MainWindow reference) {
		setResizable(false);
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/libreria.jpg")));
		setBounds(100, 100, 523, 381);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblImagen());
		contentPanel.add(getLblDni());
		contentPanel.add(getLblPassword());
		contentPanel.add(getTfDni());
		contentPanel.add(getPasswordField());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(getTfDni().equals("") || String.valueOf(getPasswordField().getPassword()).equals("")){
							JOptionPane.showMessageDialog(null, "You must fill all the information", "ERROR", ERROR);
						}
						boolean result = false;
						for(Client c : clients){
							if(c.getDni().equals(getTfDni().getText()) &&
									c.getPassword().equals(String.valueOf(getPasswordField().getPassword()))){
								result = true;
								reference.setVisible(true);
								reference.lblName.setText(" " + c.getName());
							}
						}
						if(result){
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "The data is wrong", "ERROR", ERROR);
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
	}
	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel("");
			lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
			lblImagen.setIcon(new ImageIcon(Login.class.getResource("/img/libreria.jpg")));
			lblImagen.setBounds(99, 11, 318, 155);
		}
		return lblImagen;
	}
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI:");
			lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
			lblDni.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblDni.setBounds(37, 196, 65, 19);
		}
		return lblDni;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblPassword.setBounds(24, 241, 78, 19);
		}
		return lblPassword;
	}
	private JTextField getTfDni() {
		if (tfDni == null) {
			tfDni = new JTextField();
			tfDni.setBounds(129, 197, 318, 20);
			tfDni.setColumns(10);
		}
		return tfDni;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(129, 242, 318, 20);
		}
		return passwordField;
	}
}
