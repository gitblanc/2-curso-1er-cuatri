package examen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Cliente;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDialog extends JFrame {

	private JPanel contentPane;
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private JTextField txtDNI;
	private JPasswordField pass;
	VentanaDialog ref = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDialog frame = new VentanaDialog();
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
	public VentanaDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDialog.class.getResource("/img/libreria.jpg")));
		setTitle("Enter your data");
		setResizable(false);
		leerFichero();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnSuperior = new JPanel();
		contentPane.add(pnSuperior, BorderLayout.NORTH);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(VentanaDialog.class.getResource("/img/libreria.jpg")));
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		pnSuperior.add(lblImg);
		
		JPanel pnInferior = new JPanel();
		contentPane.add(pnInferior, BorderLayout.CENTER);
		GridBagLayout gbl_pnInferior = new GridBagLayout();
		gbl_pnInferior.columnWidths = new int[]{0, 50, 0, 0, 0, 142, 105, 20, 0, 0, 0};
		gbl_pnInferior.rowHeights = new int[]{49, 28, 23, 20, 53, 0, 0};
		gbl_pnInferior.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnInferior.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnInferior.setLayout(gbl_pnInferior);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setToolTipText("Enter your DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 2;
		gbc_lblDni.gridy = 1;
		pnInferior.add(lblDni, gbc_lblDni);
		
		txtDNI = new JTextField();
		lblDni.setLabelFor(txtDNI);
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.gridwidth = 4;
		gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNI.gridx = 4;
		gbc_txtDNI.gridy = 1;
		pnInferior.add(txtDNI, gbc_txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setToolTipText("Enter your password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 3;
		pnInferior.add(lblPassword, gbc_lblPassword);
		
		pass = new JPasswordField();
		lblPassword.setLabelFor(pass);
		GridBagConstraints gbc_pass = new GridBagConstraints();
		gbc_pass.gridwidth = 4;
		gbc_pass.insets = new Insets(0, 0, 5, 5);
		gbc_pass.fill = GridBagConstraints.HORIZONTAL;
		gbc_pass.gridx = 4;
		gbc_pass.gridy = 3;
		pnInferior.add(pass, gbc_pass);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setToolTipText("Continue with your order");
		btnLogIn.setMnemonic('l');
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String auxd= txtDNI.getText();
				String auxp= String.valueOf(pass.getPassword());
				for (Cliente c : clientes) {
					if (c.getDni().equals(auxd) && c.getPass().equals(auxp)){
						VentanaPrin dialogo = new VentanaPrin(c.getDni(),c.getName(),ref);
						dialogo.setLocationRelativeTo(null);
						//dialogo.setModal(true);
						dialogo.setVisible(true);
						dispose();
						break;
					} else if (clientes.indexOf(c)== clientes.size()-1){
						JOptionPane.showMessageDialog(null,"You have included incorrect data");
					}
				}
			}
		});
		GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
		gbc_btnLogIn.anchor = GridBagConstraints.EAST;
		gbc_btnLogIn.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogIn.gridx = 6;
		gbc_btnLogIn.gridy = 5;
		pnInferior.add(btnLogIn, gbc_btnLogIn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setToolTipText("Reset fields");
		btnCancel.setMnemonic('k');
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtDNI.setText("");
				pass.setText("");
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 8;
		gbc_btnCancel.gridy = 5;
		pnInferior.add(btnCancel, gbc_btnCancel);
	}
	
	void leerFichero() {
	    String nombreFichero = "files/clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
	      clientes = new ArrayList<Cliente>();

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        Cliente aux = new Cliente(trozos[0],trozos[1],trozos[2],trozos[3]);
	        clientes.add(aux);
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
