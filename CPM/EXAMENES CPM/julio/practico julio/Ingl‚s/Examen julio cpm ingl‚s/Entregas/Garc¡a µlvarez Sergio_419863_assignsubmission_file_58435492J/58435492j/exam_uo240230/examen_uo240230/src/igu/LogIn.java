package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.FileManager;




import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import logica.Client;

public class LogIn extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JLabel lblUser;
	private JTextField txUser;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private ArrayList<Client> clients;
	
	private FileManager file;
	private LogIn log = this;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LogIn dialog = new LogIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LogIn() {
		
		// Cargar Clientes
		file = new FileManager();
		clients = file.clients;
		
		setTitle("Libreria Oviedo");
		setBounds(100, 100, 591, 344);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLabel());
		contentPanel.add(getLblUser());
		contentPanel.add(getTxUser());
		contentPanel.add(getLblPassword());
		contentPanel.add(getPasswordField());
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Log In");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(checkLog() == false){
							JOptionPane.showMessageDialog(null, "Wrong Field");
						}else{
							Client c = findClient();
							dispose();
							MainWindow mw = new MainWindow(log, c.getName(), c.getDni());
							mw.setLocationRelativeTo(log);
							mw.setVisible(true);
							
						}
					}

				});
				okButton.setMnemonic('L');
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private boolean checkLog() {
		boolean ok = false;
		if(getTxUser().getText().length() > 0 && getPasswordField().getPassword().length > 0){
			
			Client client = findClient();
			if(client != null){
				char[] pass = getPasswordField().getPassword();
				char[] cpass = client.getPassword().toCharArray();
				
				if(pass.length == cpass.length){
					for(int i = 0; i < cpass.length; i++){
						if(pass[i] != cpass[i]){
							ok = false;
							break;
						}
						ok = true;
					}
				}
			}
		}
		return ok;
	}
	
	
	
	private Client findClient() {
		for(Client cli : clients){
			if(cli.getDni().equals(txUser.getText()))
					return cli;
		}
		return null;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(LogIn.class.getResource("/img/libreria.jpg")));
			label.setBounds(134, 13, 318, 155);
		}
		return label;
	}
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User:");
			lblUser.setDisplayedMnemonic('U');
			lblUser.setLabelFor(getTxUser());
			lblUser.setBounds(134, 191, 56, 16);
		}
		return lblUser;
	}
	private JTextField getTxUser() {
		if (txUser == null) {
			txUser = new JTextField();
			txUser.setBounds(202, 188, 250, 22);
			txUser.setColumns(10);
		}
		return txUser;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setLabelFor(getPasswordField());
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setBounds(134, 234, 71, 16);
		}
		return lblPassword;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(202, 231, 250, 22);
		}
		return passwordField;
	}
}
