package igu;

import io.FileManagerClient;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logica.Client;

import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.help.*;

import java.io.File;
import java.net.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class LoginWindow extends JDialog {
	private JPanel pnPrincipal;
	private JLabel lblLogo;
	private JPanel pnSouth;
	private JPanel pnButtons;
	private JButton btnLogin;
	private JButton btnCancel;
	private JPanel pnCenter;
	private JLabel lblDni;
	private JTextField txDni;
	private JLabel lblPassword;
	private JPasswordField pswPassword;
	private FileManagerClient fR;
	private ArrayList<Client> clients;
	private Client client;
	private JButton btnHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow dialog = new LoginWindow();
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
	public LoginWindow() {
		setTitle("BookShop Login Dialog");
		client = null;
		fR = new FileManagerClient("clientes.dat");
		clients = fR.getDataBaseClients();
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				LoginWindow.class.getResource("/img/libreria.jpg")));
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().add(getPnPrincipal(), BorderLayout.CENTER);
		getRootPane().setDefaultButton(getBtnLogin());
		cargaAyuda();

	}

	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(new BorderLayout(0, 0));
			pnPrincipal.add(getLblLogo(), BorderLayout.NORTH);
			pnPrincipal.add(getPnSouth(), BorderLayout.SOUTH);
			pnPrincipal.add(getPnCenter(), BorderLayout.CENTER);
		}
		return pnPrincipal;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setIcon(new ImageIcon(LoginWindow.class
					.getResource("/img/libreria.jpg")));
		}
		return lblLogo;
	}

	private JPanel getPnSouth() {
		if (pnSouth == null) {
			pnSouth = new JPanel();
			pnSouth.setLayout(new GridLayout(2, 0, 0, 0));
			pnSouth.add(getPnButtons());
		}
		return pnSouth;
	}

	private JPanel getPnButtons() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.add(getBtnLogin());
			pnButtons.add(getBtnCancel());
		}
		return pnButtons;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (check() == true) {
						createMainWindow();
					} else {
						getPswPassword().setText(null);
						JOptionPane.showMessageDialog(rootPane,
								"DNI or password is wrong!", getTitle(),
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnLogin;
	}

	private void createMainWindow() {
		MainWindow mW = new MainWindow(this, client);
		mW.setVisible(true);
		this.setVisible(false);
		resetLogin();
	}

	private void resetLogin() {
		getTxDni().grabFocus();
		getTxDni().setText(null);
		getPswPassword().setText(null);
	}

	private boolean check() {
		if (getTxDni().getText().length() > 0
				&& getPswPassword().getPassword().length > 0) {
			Client c = searchClient();
			if (c != null) {
				char[] cPass = c.getPass().toCharArray();
				char[] pass = getPswPassword().getPassword();

				for (int i = 0; i < pass.length; i++) {

					if (pass[i] != cPass[i]) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	private Client searchClient() {
		for (Client c : clients) {
			if (c.getDNI().toLowerCase()
					.equals(getTxDni().getText().toLowerCase())) {
				client = c;
				return c;
			}
		}
		return null;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setMnemonic('c');
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetLogin();
				}
			});
		}
		return btnCancel;
	}

	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setLayout(null);
			pnCenter.add(getLblDni());
			pnCenter.add(getTxDni());
			pnCenter.add(getLblPassword());
			pnCenter.add(getPswPassword());
			pnCenter.add(getBtnHelp());
		}
		return pnCenter;
	}

	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI");
			lblDni.setLabelFor(getTxDni());
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDni.setBounds(115, 41, 46, 14);
		}
		return lblDni;
	}

	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txDni.setBounds(190, 38, 236, 20);
			txDni.setColumns(10);
		}
		return txDni;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setLabelFor(getPswPassword());
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPassword.setBounds(115, 81, 58, 14);
		}
		return lblPassword;
	}

	private JPasswordField getPswPassword() {
		if (pswPassword == null) {
			pswPassword = new JPasswordField();
			pswPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			pswPassword.setBounds(190, 78, 236, 20);
		}
		return pswPassword;
	}

	void cargaAyuda(){

	   URL hsURL;
	   HelpSet hs;

	    try {
		    	File fichero = new File("help/ayuda.hs");
		    	hsURL = fichero.toURI().toURL();
		        hs = new HelpSet(null, hsURL);
		 }

	    catch(Exception e){
	      		System.out.println("Ayuda no encontrada");
	      		return;
	        }

	   HelpBroker hb = hs.createHelpBroker();

	   hb.enableHelpKey(getRootPane(),"init", hs);
	   hb.enableHelpOnButton(getBtnHelp(), "init", hs);
	   
	 }
	private JButton getBtnHelp() {
		if (btnHelp == null) {
			btnHelp = new JButton("Help?");
			btnHelp.setBounds(360, 105, 66, 20);
		}
		return btnHelp;
	}
}
