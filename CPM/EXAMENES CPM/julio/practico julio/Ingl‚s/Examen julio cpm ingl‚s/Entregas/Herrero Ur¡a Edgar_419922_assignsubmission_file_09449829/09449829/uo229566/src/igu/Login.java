package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.BookStore;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;

	BookStore bs = new BookStore();

	private final JPanel contentPanel = new JPanel();
	private JPanel pnLogin;
	private JPanel pnPassword;
	private JTextField txLogin;
	private JPasswordField pwPassword;
	
	public String username;
	private JLabel lblLbllogo;
	
	public BookStore getBookStore() {
		return this.bs;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean fieldsOK() {
		if (!txLogin.getText().isEmpty() && !pwPassword.getText().isEmpty())
			return true;
		return false;
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/libreria.jpg")));
		setResizable(false);
		setTitle("Welcome to BookBooking.com");
		setBounds(100, 100, 450, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel mainPanel = new JPanel();
			contentPanel.add(mainPanel, BorderLayout.CENTER);
			mainPanel.setLayout(null);
			mainPanel.add(getPnLogin());
			mainPanel.add(getPnPassword());
			mainPanel.add(getLblLbllogo());
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnProceed = new JButton("Proceed");
				btnProceed.setMnemonic('P');
				btnProceed.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (fieldsOK()) {
							if (bs.login(txLogin.getText(), pwPassword.getText()) == null)
								JOptionPane.showMessageDialog(null, "No existe ese usuario / Contraseña incorrecta.");
							else
								goToStore();
						} else
							JOptionPane
									.showMessageDialog(null,
											"Ambos campos tienen que ser debidamente rellenados.");
					}
				});
				btnProceed.setActionCommand("Cancel");
				buttonPane.add(btnProceed);
			}
		}
	}

	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			pnLogin.setBorder(new TitledBorder(null, "ID",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnLogin.setBounds(10, 179, 414, 54);
			pnLogin.setLayout(new BorderLayout(0, 0));
			pnLogin.add(getTxLogin(), BorderLayout.CENTER);
		}
		return pnLogin;
	}

	private JPanel getPnPassword() {
		if (pnPassword == null) {
			pnPassword = new JPanel();
			pnPassword.setBorder(new TitledBorder(null, "Passsword",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPassword.setBounds(10, 244, 414, 54);
			pnPassword.setLayout(new BorderLayout(0, 0));
			pnPassword.add(getPwPassword(), BorderLayout.CENTER);
		}
		return pnPassword;
	}

	private JTextField getTxLogin() {
		if (txLogin == null) {
			txLogin = new JTextField();
			txLogin.setColumns(10);
		}
		return txLogin;
	}

	private void goToStore() {
		this.username = bs.getCliente(txLogin.getText()).getName();
		StoreWindow dialogo = new StoreWindow(this);
		dialogo.setLocationRelativeTo(null);
		dialogo.setVisible(true);
		this.setVisible(false);
	}
	private JPasswordField getPwPassword() {
		if (pwPassword == null) {
			pwPassword = new JPasswordField();
		}
		return pwPassword;
	}
	private JLabel getLblLbllogo() {
		if (lblLbllogo == null) {
			lblLbllogo = new JLabel("");
			lblLbllogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLbllogo.setIcon(new ImageIcon(Login.class.getResource("/img/libreria.jpg")));
			lblLbllogo.setBounds(10, 11, 414, 157);
		}
		return lblLbllogo;
	}
}
