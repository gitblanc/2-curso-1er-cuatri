package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import logica.Client;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JPanel panelIcono;
	private JLabel labelIcono;
	private JPanel panelCentral;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JPanel panelBotones;
	private JButton btnOK;
	private JButton btnCancel;
	
	ArrayList<Client> clients = new ArrayList<Client>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
		leerFichero();
		setTitle("Librer\u00EDa EII Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/img/libreria.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelIcono(), BorderLayout.NORTH);
		contentPane.add(getPanelCentral(), BorderLayout.CENTER);
		contentPane.add(getPanelBotones(), BorderLayout.SOUTH);
	}

	private JPanel getPanelIcono() {
		if (panelIcono == null) {
			panelIcono = new JPanel();
			panelIcono.add(getLabelIcono());
		}
		return panelIcono;
	}
	private JLabel getLabelIcono() {
		if (labelIcono == null) {
			labelIcono = new JLabel("");
			labelIcono.setIcon(new ImageIcon(VentanaInicio.class.getResource("/img/libreria.jpg")));
		}
		return labelIcono;
	}
	private JPanel getPanelCentral() {
		if (panelCentral == null) {
			panelCentral = new JPanel();
			GridBagLayout gbl_panelCentral = new GridBagLayout();
			gbl_panelCentral.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panelCentral.rowHeights = new int[]{0, 0, 0};
			gbl_panelCentral.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panelCentral.setLayout(gbl_panelCentral);
			GridBagConstraints gbc_lblUser = new GridBagConstraints();
			gbc_lblUser.insets = new Insets(0, 0, 5, 5);
			gbc_lblUser.gridx = 1;
			gbc_lblUser.gridy = 0;
			panelCentral.add(getLblUser(), gbc_lblUser);
			GridBagConstraints gbc_textFieldUser = new GridBagConstraints();
			gbc_textFieldUser.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldUser.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldUser.gridx = 3;
			gbc_textFieldUser.gridy = 0;
			panelCentral.add(getTextFieldUser(), gbc_textFieldUser);
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
			gbc_lblPassword.gridx = 1;
			gbc_lblPassword.gridy = 1;
			panelCentral.add(getLblPassword(), gbc_lblPassword);
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 3;
			gbc_passwordField.gridy = 1;
			panelCentral.add(getPasswordField(), gbc_passwordField);
		}
		return panelCentral;
	}
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User: ");
			lblUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblUser;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblPassword;
	}
	private JTextField getTextFieldUser() {
		if (textFieldUser == null) {
			textFieldUser = new JTextField();
			textFieldUser.setColumns(10);
		}
		return textFieldUser;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
		}
		return passwordField;
	}
	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			GridBagLayout gbl_panelBotones = new GridBagLayout();
			gbl_panelBotones.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panelBotones.rowHeights = new int[]{0, 0};
			gbl_panelBotones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelBotones.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelBotones.setLayout(gbl_panelBotones);
			GridBagConstraints gbc_btnOK = new GridBagConstraints();
			gbc_btnOK.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnOK.insets = new Insets(0, 0, 0, 5);
			gbc_btnOK.gridx = 10;
			gbc_btnOK.gridy = 0;
			panelBotones.add(getBtnOK(), gbc_btnOK);
			GridBagConstraints gbc_btnCancel = new GridBagConstraints();
			gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnCancel.gridx = 11;
			gbc_btnCancel.gridy = 0;
			panelBotones.add(getBtnCancel(), gbc_btnCancel);
		}
		return panelBotones;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for (Client c : clients){
						char[] password = passwordField.getPassword();
						String pswd = new String(password);
						if( !c.getDni().equals(textFieldUser.getText()) || !c.getPassword().equals(pswd)){
							if(clients.indexOf(c) == clients.size() -1 )
								JOptionPane.showMessageDialog(null, "The user or the password are incorrects.");
						}
						else if (c.getDni().equals(textFieldUser.getText()) && c.getPassword().equals(pswd)){
							VentanaPrincipal vp = new VentanaPrincipal(c);
							vp.setVisible(true);
							dispose();							
						}
					}					
				}
			});
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return btnCancel;
	}
	
	void leerFichero() {
	    String nombreFichero = "Files/clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        Client c = new Client(trozos[0], trozos[1], trozos[2], trozos[3]);
	        clients.add(c);
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
}
