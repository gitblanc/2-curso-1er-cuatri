package gui;

import java.io.*;
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

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logic.Client;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private MainWindow mw;
	private LoginDialog ref = this;
	private ArrayList<Client> clients = new ArrayList<Client>();
	private JTextField textID;
	private JLabel lblID;
	private JPasswordField passwordField;
	private JLabel lblPass;

	
	private boolean checkLogin()
	{
		for(Client each : clients)
		{
			if(each.getDNI().equals(textID.getText()) && each.getPassword().equals(String.valueOf(passwordField.getPassword())))
			{
				mw.setCl(each);
				mw.getLblWelc().setText("Welcome to the store " + each.getName());
				return true;	
			}
		}
		JOptionPane.showMessageDialog(null, "Invalid ID or password");
		return false;
	}
	
	void leerFichero() {
	    String nombreFichero = "files/clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        clients.add(new Client(trozos[0],trozos[1],trozos[2],trozos[3]));
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	 }
	
	/**
	 * Create the dialog.
	 */
	public LoginDialog(MainWindow mw) {
		leerFichero();
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginDialog.class.getResource("/img/libreria.jpg")));
		this.mw=mw;
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnLogoTitle = new JPanel();
			contentPanel.add(pnLogoTitle, BorderLayout.NORTH);
			{
				JLabel lblLogo = new JLabel("");
				lblLogo.setIcon(new ImageIcon(LoginDialog.class.getResource("/img/libreria.jpg")));
				pnLogoTitle.add(lblLogo);
			}
			{
				JLabel lblTitle = new JLabel("EII Library Oviedo");
				lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
				pnLogoTitle.add(lblTitle);
			}
		}
		{
			JPanel pnLogin = new JPanel();
			contentPanel.add(pnLogin, BorderLayout.CENTER);
			GridBagLayout gbl_pnLogin = new GridBagLayout();
			pnLogin.setLayout(gbl_pnLogin);
			{
				lblID = new JLabel("ID :");
				GridBagConstraints gbc_lblID = new GridBagConstraints();
				gbc_lblID.insets = new Insets(0, 0, 5, 5);
				gbc_lblID.gridx = 2;
				gbc_lblID.gridy = 3;
				pnLogin.add(lblID, gbc_lblID);
			}
			{
				textID = new JTextField();
				lblID.setLabelFor(textID);
				GridBagConstraints gbc_textID = new GridBagConstraints();
				gbc_textID.insets = new Insets(0, 0, 5, 0);
				gbc_textID.fill = GridBagConstraints.HORIZONTAL;
				gbc_textID.gridx = 7;
				gbc_textID.gridy = 3;
				pnLogin.add(textID, gbc_textID);
				textID.setColumns(10);
			}
			{
				lblPass = new JLabel("Password :");
				GridBagConstraints gbc_lblPass = new GridBagConstraints();
				gbc_lblPass.insets = new Insets(0, 0, 0, 5);
				gbc_lblPass.gridx = 2;
				gbc_lblPass.gridy = 7;
				pnLogin.add(lblPass, gbc_lblPass);
			}
			{
				passwordField = new JPasswordField();
				lblPass.setLabelFor(passwordField);
				GridBagConstraints gbc_passwordField = new GridBagConstraints();
				gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
				gbc_passwordField.gridx = 7;
				gbc_passwordField.gridy = 7;
				pnLogin.add(passwordField, gbc_passwordField);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnLogin = new JButton("Log in");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(textID.getText().equals("") || String.valueOf(passwordField.getPassword()).equals(""))
						{
							JOptionPane.showMessageDialog(null, "Please insert id and password");
						}
								
						else if(checkLogin())
						{
							mw.setVisible(true);
							ref.dispose();
						}
					}
				});
				btnLogin.setActionCommand("OK");
				buttonPane.add(btnLogin);
				getRootPane().setDefaultButton(btnLogin);
			}
		}
	}

}
