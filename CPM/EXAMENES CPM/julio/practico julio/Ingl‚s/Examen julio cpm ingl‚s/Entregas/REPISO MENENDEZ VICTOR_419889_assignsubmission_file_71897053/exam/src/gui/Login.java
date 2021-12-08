package gui;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel userlb;
	private JLabel passwordlb;
	private JTextField usertx;
	private JPasswordField passwordField;
	private JButton acceptbt;
	
	private logic.Login loggin = new logic.Login();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getUserlb());
			panel.add(getUsertx());
			panel.add(getPasswordlb());
			panel.add(getPasswordField());
			panel.add(getAcceptbt());
		}
		return panel;
	}
	private JLabel getUserlb() {
		if (userlb == null) {
			userlb = new JLabel("User");
			userlb.setBounds(30, 33, 46, 14);
		}
		return userlb;
	}
	private JLabel getPasswordlb() {
		if (passwordlb == null) {
			passwordlb = new JLabel("password");
			passwordlb.setBounds(30, 58, 46, 14);
		}
		return passwordlb;
	}
	private JTextField getUsertx() {
		if (usertx == null) {
			usertx = new JTextField();
			usertx.setBounds(81, 30, 147, 20);
			usertx.setColumns(10);
		}
		return usertx;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(81, 55, 147, 20);
			passwordField.setText("");
		}
		return passwordField;
	}
	private JButton getAcceptbt() {
		if (acceptbt == null) {
			acceptbt = new JButton("loggin");
			acceptbt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (loggin.validateUser(getUsertx().getText(), getPasswordField().getText())) {
						Application app = new Application(loggin.getName(getUsertx().getText(), getPasswordField().getText()));
						app.setVisible(true);
					}
					else {
						Error err = new Error();
						err.setVisible(true);
					}
				}
			});
			acceptbt.setBounds(345, 123, 89, 23);
		}
		return acceptbt;
	}
}
