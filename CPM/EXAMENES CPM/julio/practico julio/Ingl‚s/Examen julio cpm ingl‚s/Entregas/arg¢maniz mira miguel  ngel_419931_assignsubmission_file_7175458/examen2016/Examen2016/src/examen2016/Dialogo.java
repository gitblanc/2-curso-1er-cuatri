package examen2016;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import logica.Fichero;
import logica.Cliente;

public class Dialogo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txUsuario;
	private JPasswordField pswContraseña;
	private JLabel lblUsuario;
	private JLabel lblNewLabel;
	private Fichero fichero;
	private List<Cliente> clientes;
	private static Dialogo dialogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialogo = new Dialogo();
			dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialogo.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialogo() {
		setResizable(false);
		setTitle("EII book shop Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Dialogo.class.getResource("/img/libreria.jpg")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		fichero = new Fichero();
		{
			JPanel pnIntro = new JPanel();
			pnIntro.setBackground(Color.WHITE);
			contentPanel.add(pnIntro, BorderLayout.NORTH);
			pnIntro.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblLogIn = new JLabel("Log In");
				lblLogIn.setBackground(Color.WHITE);
				lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 30));
				lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
				pnIntro.add(lblLogIn, BorderLayout.NORTH);
			}
		}
		{
			JPanel pnLogIn = new JPanel();
			pnLogIn.setBackground(Color.WHITE);
			contentPanel.add(pnLogIn, BorderLayout.CENTER);
			pnLogIn.setLayout(null);
			{
				lblUsuario = new JLabel("User:");
				lblUsuario.setDisplayedMnemonic('u');
				lblUsuario.setBounds(10, 77, 69, 14);
				pnLogIn.add(lblUsuario);
			}
			{
				txUsuario = new JTextField();
				lblUsuario.setLabelFor(txUsuario);
				txUsuario.setBounds(89, 74, 135, 20);
				pnLogIn.add(txUsuario);
				txUsuario.setColumns(15);
			}
			{
				lblNewLabel = new JLabel("Password:");
				lblNewLabel.setDisplayedMnemonic('c');
				lblNewLabel.setBounds(10, 108, 69, 14);
				pnLogIn.add(lblNewLabel);
			}
			{
				pswContraseña = new JPasswordField();
				lblNewLabel.setLabelFor(pswContraseña);
				pswContraseña.setBounds(89, 105, 135, 20);
				pswContraseña.setColumns(15);
				pnLogIn.add(pswContraseña);
			}

			JLabel lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLogo.setIcon(new ImageIcon(Dialogo.class
					.getResource("/img/libreria.jpg")));
			lblLogo.setBounds(234, 31, 184, 122);
			pnLogIn.add(lblLogo);
			{
				JLabel lblBienvenido = new JLabel(
						"Welcome to the EII book shop, Oviedo");
				lblBienvenido.setBounds(10, 11, 408, 14);
				pnLogIn.add(lblBienvenido);
				lblBienvenido.setBackground(Color.WHITE);
				lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						String usuario = txUsuario.getText();
						char[] contraseñaChar = pswContraseña.getPassword();
						// String contraseña = "";
						// for(int i = 0; i < contraseñaChar.length; i++){
						// contraseña += contraseñaChar[i];
						// }
						String contraseña = String.valueOf(contraseñaChar);
						clientes = fichero.leerFicheroClientes();
						boolean existeCliente = false;
						for (Cliente cliente : clientes) {
							if (cliente.getDni().equals(usuario)
									&& cliente.getContraseña().equals(
											contraseña)) {
								// Here call to the VentanaPrincipal and close
								// this one
								existeCliente = true;
								VentanaPrincipal vP = new VentanaPrincipal(
										cliente);
								vP.setVisible(true);
								dialogo.setVisible(false);
								dialogo.dispose();
								break;
							}

						}
						if (!existeCliente) {
							JOptionPane
									.showMessageDialog(dialogo,
											"The user or the password are wrong.");
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
}
