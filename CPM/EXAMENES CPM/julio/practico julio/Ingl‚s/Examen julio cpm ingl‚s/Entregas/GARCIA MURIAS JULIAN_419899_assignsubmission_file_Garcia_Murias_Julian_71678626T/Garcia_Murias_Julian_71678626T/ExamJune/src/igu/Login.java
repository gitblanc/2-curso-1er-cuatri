package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Client;
import logic.ClientsDatabase;
import javax.swing.ImageIcon;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblPleaseEnterDninif;
	private JLabel lblYouDninifOr;
	private JTextField txDni;
	private JPasswordField passwordField;
	ClientsDatabase db = new ClientsDatabase();
	Client k;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Login() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Login");
		setBounds(100, 100, 610, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		JLabel lblDninif = new JLabel("DNI/NIF:");
		JLabel lblPassword = new JLabel("Password:");
		txDni = new JTextField();
		txDni.setColumns(10);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/libreria.jpg")));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDninif)
										.addComponent(lblPassword))
									.addGap(24)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(getPasswordField(), GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
										.addComponent(txDni, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
								.addComponent(getLblPleaseEnterDninif())))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(getLblYouDninifOr())))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 314, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label))
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addGap(43)
							.addComponent(getLblPleaseEnterDninif())
							.addGap(29)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDninif)
								.addComponent(txDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(getPasswordField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(getLblYouDninifOr())))
					.addGap(41))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for(Client c:db.getClients()){
							if(txDni.getText().equals(c.getDni())&& 
									String.valueOf(passwordField.getPassword()).equals(c.getPassword())){
								MainWindow frame = new MainWindow();
								frame.setVisible(true);
								setVisible(false);
								k=c;
							}
							else{
								lblYouDninifOr.setVisible(true);
							}
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
		db.loadClients();
		for(Client c:db.getClients()){
			System.out.println(c.getName());
		}
	}
	private JLabel getLblPleaseEnterDninif() {
		if (lblPleaseEnterDninif == null) {
			lblPleaseEnterDninif = new JLabel("Please, enter DNI/NIF and pasword:");
		}
		return lblPleaseEnterDninif;
	}
	private JLabel getLblYouDninifOr() {
		if (lblYouDninifOr == null) {
			lblYouDninifOr = new JLabel("You DNI/NIF or password are not correct.");
			lblYouDninifOr.setForeground(Color.RED);
			lblYouDninifOr.setVisible(false);
		}
		return lblYouDninifOr;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
		}
		return passwordField;
	}
	
	public Client getClient(){
		return k;
	}
}
