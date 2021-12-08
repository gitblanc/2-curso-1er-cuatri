package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.BookStore;
import logica.Client;

public class VentanaDialogo extends JFrame {

	private JPanel contentPane;
	private JPanel panelButtons;
	private JButton btnLogIn;
	private JButton btnCancel;
	private JPanel panel;
	private JLabel label;
	private JPanel panel_1;
	private JLabel lblUserId;
	private JTextField textField;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	
	private BookStore bS;
	private VentanaPrincipal vP;
	private VentanaDialogo vD;
	private VentanaPrincipal parent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDialogo frame = new VentanaDialogo();
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
	public VentanaDialogo() {
		vD = this;
		bS = new BookStore();
		
		setTitle("Book Store EII Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDialogo.class.getResource("/img/libreria.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 413);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelButtons(), BorderLayout.SOUTH);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
	}
	
	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelButtons.add(getBtnLogIn());
			panelButtons.add(getBtnCancel());
		}
		return panelButtons;
	}
	private JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log In");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean isClient = false;
					Client cli = new Client("", "", "", "");
					
					for(Client c: bS.getClients()){
						if(c.getDni().equals(textField.getText()) && 
								c.getPassword().equals(String.valueOf(passwordField.getPassword()))){
							isClient = true;
							cli = c;
						}
					}
					
					if(isClient){
						vP = new VentanaPrincipal(vD, bS, cli.getName(), cli.getDni());
					}
					else{
						JOptionPane.showMessageDialog(null, "Wrong identification");
					}
				}
			});
		}
		return btnLogIn;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setToolTipText("This button will clear the fields, to close the aplication click on the red cross upwards righ");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textField.setText("");
					passwordField.setText("");
				}
			});
		}
		return btnCancel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLabel());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(VentanaDialogo.class.getResource("/img/libreria.jpg")));
		}
		return label;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Please Log In", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel_1.setLayout(null);
			panel_1.add(getLblUserId());
			panel_1.add(getTextField());
			panel_1.add(getLblPassword());
			panel_1.add(getPasswordField());
		}
		return panel_1;
	}
	private JLabel getLblUserId() {
		if (lblUserId == null) {
			lblUserId = new JLabel("User ID: ");
			lblUserId.setDisplayedMnemonic('u');
			lblUserId.setBounds(23, 47, 64, 23);
		}
		return lblUserId;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(97, 48, 317, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password: ");
			lblPassword.setDisplayedMnemonic('p');
			lblPassword.setBounds(23, 108, 64, 23);
		}
		return lblPassword;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(97, 109, 317, 20);
		}
		return passwordField;
	}
}
