package gui;

import java.io.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Cliente;
import java.awt.Toolkit;

public class DialogoLogin extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JPanel pnDataLogin;
	private JPanel pnButtonsLogin;
	private JLabel lblDni;
	private JTextField textFieldDNI;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JButton btnExit;
	private ArrayList<Cliente> clientes = null;
	private boolean correctLogin = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogoLogin frame = new DialogoLogin();
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
	public DialogoLogin() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoLogin.class.getResource("/img/libreria.jpg")));
		clientes = new ArrayList<Cliente>();
		leerFichero();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLabel(), BorderLayout.NORTH);
		contentPane.add(getPnDataLogin(), BorderLayout.CENTER);
		contentPane.add(getPnButtonsLogin(), BorderLayout.SOUTH);
	}

	void leerFichero() {
		String nombreFichero = "files/clientes.dat";
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			// Mientras quede información
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				clientes.add(new Cliente(trozos[0], trozos[1], trozos[2],
						trozos[3]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setIcon(new ImageIcon(DialogoLogin.class
					.getResource("/img/libreria.jpg")));
		}
		return label;
	}

	private JPanel getPnDataLogin() {
		if (pnDataLogin == null) {
			pnDataLogin = new JPanel();
			pnDataLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
					null, null, null));
			pnDataLogin.add(getLblDni());
			pnDataLogin.add(getTextFieldDNI());
			pnDataLogin.add(getLblPassword());
			pnDataLogin.add(getPasswordField());
		}
		return pnDataLogin;
	}

	private JPanel getPnButtonsLogin() {
		if (pnButtonsLogin == null) {
			pnButtonsLogin = new JPanel();
			pnButtonsLogin.add(getBtnExit());
			pnButtonsLogin.add(getBtnLogIn());
		}
		return pnButtonsLogin;
	}

	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI: ");
			lblDni.setDisplayedMnemonic('D');
			lblDni.setLabelFor(getTextFieldDNI());
		}
		return lblDni;
	}

	private JTextField getTextFieldDNI() {
		if (textFieldDNI == null) {
			textFieldDNI = new JTextField();
			textFieldDNI.setColumns(10);
		}
		return textFieldDNI;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setLabelFor(getPasswordField());
		}
		return lblPassword;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setEchoChar('*');
			passwordField.setColumns(10);
		}
		return passwordField;
	}

	private JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log in");
			btnLogIn.setMnemonic('l');
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for (Cliente cl : clientes) {
						if (textFieldDNI.getText().equals(cl.getDNI()) && String.valueOf(passwordField.getPassword()).equals(cl.getContraseña())) {
							correctLogin = true;
							VentanaPrincipal ventana = new VentanaPrincipal(cl);
							ventana.setLocationRelativeTo(null);
							ventana.setVisible(true);
							dispose();
						}
						

					}
					if (!correctLogin) JOptionPane.showMessageDialog(null, "Incorrect data");
				}
			});
		}
		return btnLogIn;
	}

	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setMnemonic('x');
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return btnExit;
	}
}
