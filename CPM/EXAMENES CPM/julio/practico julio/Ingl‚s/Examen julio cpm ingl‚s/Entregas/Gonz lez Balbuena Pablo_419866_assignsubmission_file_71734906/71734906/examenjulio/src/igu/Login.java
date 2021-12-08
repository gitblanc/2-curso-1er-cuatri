package igu;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import io.FileManagement;
import logica.Cliente;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class Login extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblLogo;
	private JPanel pnLogin;
	private JPanel pnButtons;
	private JButton btnLogin;
	private JPanel pnSouth;
	private JLabel lblUser;
	private JTextField txUser;
	private JLabel lblPassword;
	private JPasswordField pswPass;
	private FileManagement fileMa;
	private ArrayList<Cliente> clientes;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login dialog = new Login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/libreria.jpg")));
		setTitle("Librer\u00EDa EII Oviedo");
		cliente = null;
		fileMa = new FileManagement();
		clientes = fileMa.getClientes();
		setResizable(false);
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getLblLogo(), BorderLayout.NORTH);
		getContentPane().add(getPnLogin(), BorderLayout.CENTER);
		getContentPane().add(getPnSouth(), BorderLayout.SOUTH);
		getRootPane().setDefaultButton(getBtLogin());

	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setToolTipText("Librer\u00EDa EII Oviedo");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setIcon(new ImageIcon(Login.class.getResource("/img/libreria.jpg")));
		}
		return lblLogo;
	}

	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			pnLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnLogin.setLayout(null);
			pnLogin.add(getLblUser());
			pnLogin.add(getTxUser());
			pnLogin.add(getLblPassword());
			pnLogin.add(getPswPass());
		}
		return pnLogin;
	}

	private JPanel getPnBotones() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnButtons.add(getBtLogin());
		}
		return pnButtons;
	}

	private JButton getBtLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setToolTipText("Pulsa para loguear");
			btnLogin.setHorizontalAlignment(SwingConstants.RIGHT);
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (checkPassWordField()==true) {
						mostrarVP();
					}
				}
			});
		}
		return btnLogin;
	}

	protected void mostrarVP() {
		VentanaPrincipal mW = new VentanaPrincipal(this, cliente);
		mW.setVisible(true);
		this.setVisible(false);
		this.resetLogin();
		
	}

	private boolean checkPassWordField() {
		boolean ok = false;
		if (getTxUser().getText().length() > 0 && getPswPass().getPassword().length > 0) {
			Cliente cliente = buscarCliente();
			if (cliente != null) {
				char[] passEscrita = getPswPass().getPassword();
				char[] passCliente = cliente.getPass().toCharArray();
				if (passEscrita.length == passCliente.length) {
					for (int i = 0; i < passCliente.length; i++) {
						if (passEscrita[i] != passCliente[i]) {
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

	private Cliente buscarCliente() {
		for (Cliente c : clientes) {
			if (c.getDni().toLowerCase().equals(getTxUser().getText().toLowerCase())) {
				cliente = c;
				return c;
			}
		}
		return null;
	}

	private JPanel getPnSouth() {
		if (pnSouth == null) {
			pnSouth = new JPanel();
			pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
			pnSouth.add(getPnBotones());
		}
		return pnSouth;
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User  ");
			lblUser.setBounds(47, 55, 35, 17);
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblUser;
	}

	private JTextField getTxUser() {
		if (txUser == null) {
			txUser = new JTextField();
			txUser.setToolTipText("Aqu\u00ED ser\u00E1 introducido el usuario");
			txUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txUser.setBounds(161, 54, 353, 20);
			txUser.setColumns(10);
		}
		return txUser;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password   ");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPassword.setBounds(47, 91, 79, 14);
		}
		return lblPassword;
	}

	private JPasswordField getPswPass() {
		if (pswPass == null) {
			pswPass = new JPasswordField();
			pswPass.setToolTipText("Aqui ser\u00E1 introducida la contrase\u00F1a");
			pswPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
			pswPass.setBounds(161, 89, 353, 20);
		}
		return pswPass;
	}
	
	private void resetLogin(){
		getTxUser().setText("");
		getPswPass().setText("");
		getTxUser().grabFocus();
	}
}
