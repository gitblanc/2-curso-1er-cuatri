package igu;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblImage;
	private JLabel lblProvide;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JPasswordField pwPassword;
	private JTextField txtUser;
	private JButton btnCancel;
	private JButton btnNext;
	
	private User userObject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblImage());
		contentPane.add(getLblProvide());
		contentPane.add(getLblUser());
		contentPane.add(getLblPassword());
		contentPane.add(getPwPassword());
		contentPane.add(getTxtUser());
		contentPane.add(getBtnCancel());
		contentPane.add(getBtnNext());
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getTxtUser(), getPwPassword(), getBtnNext(), getBtnCancel(), contentPane, getLblProvide(), getLblUser(), getLblImage(), getLblPassword()}));
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(Login.class.getResource("/img/libreria.jpg")));
			lblImage.setBounds(57, 11, 318, 155);
		}
		return lblImage;
	}
	private JLabel getLblProvide() {
		if (lblProvide == null) {
			lblProvide = new JLabel("Please, provide your login information below");
			lblProvide.setBounds(96, 189, 302, 14);
		}
		return lblProvide;
	}
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User:");
			lblUser.setBounds(106, 214, 46, 14);
		}
		return lblUser;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(106, 239, 95, 14);
		}
		return lblPassword;
	}
	private JPasswordField getPwPassword() {
		if (pwPassword == null) {
			pwPassword = new JPasswordField();
			pwPassword.setBounds(174, 236, 150, 20);
		}
		return pwPassword;
	}
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setBounds(174, 214, 150, 20);
			txtUser.setColumns(10);
		}
		return txtUser;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancel.setBounds(345, 276, 89, 23);
		}
		return btnCancel;
	}
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String user, password;
					user = txtUser.getText();
					password = pwPassword.getText(); //DEPRECATED: USE getPassword char[] and then convert into String
					if (readUsers(user, password)){
						MainWindow dialogo = new MainWindow(getUser());
						//dialogo.createUser(this.userObject  );
						dialogo.setLocationRelativeTo(null);
						//dialogo.setModal(true);
						dialogo.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(rootPane, "Invalid username/password combination, please try again.");
				}
			});
			btnNext.setBounds(252, 276, 89, 23);
		}
		return btnNext;
	}
	
	boolean readUsers(String user, String password) {
	    String nombreFichero = "clientes.dat";
	    String linea="";
	    boolean wasFound = false;
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        if(trozos[0].equals(user) && trozos[3].equals(password)){
	        	wasFound = true;
	        	this.userObject = new User(trozos[0], trozos[1], trozos[2], trozos[3]);
	        }
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	    return wasFound;
	 }
	
	public User getUser(){
		return this.userObject;
	}
	
}
