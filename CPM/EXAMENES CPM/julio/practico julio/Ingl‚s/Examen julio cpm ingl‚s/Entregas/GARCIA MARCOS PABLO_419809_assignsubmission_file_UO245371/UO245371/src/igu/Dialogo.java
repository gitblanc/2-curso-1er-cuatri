package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logica.ManejadorDatos;
import logica.Persona;

public class Dialogo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField textField;
	
	private ManejadorDatos md;
	private ArrayList<Persona> clientes;
	
	private String DNI;
	private String nombre;

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialogo dialog = new Dialogo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialogo() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		
		md = new ManejadorDatos();	
		
		setTitle("Log Screen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dialogo.class.getResource("/img/libreria.jpg")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.NORTH);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JPanel panelTitle = new JPanel();
					panel_1.add(panelTitle, BorderLayout.NORTH);
					{
						JLabel lblPleaseLogInto = new JLabel("Please log into the application");
						panelTitle.add(lblPleaseLogInto);
					}
				}
				{
					JPanel panelID = new JPanel();
					panel_1.add(panelID, BorderLayout.CENTER);
					{
						JLabel lblText = new JLabel("Enter your ID:");
						panelID.add(lblText);
					}
					{
						textField = new JTextField();
						panelID.add(textField);
						textField.setColumns(10);
					}
				}
			}
			{
				JPanel panelPass = new JPanel();
				panel.add(panelPass, BorderLayout.CENTER);
				{
					JLabel lblPass = new JLabel("Enter your password:");
					panelPass.add(lblPass);
				}
				{
					passwordField = new JPasswordField();
					passwordField.setColumns(10);
					panelPass.add(passwordField);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean aux = false;
						clientes = new ArrayList<>();
						clientes = md.getPersonas();
						char[] c = passwordField.getPassword();
						String pass = new String(c);
						for (Persona cliente: clientes)
							if(cliente.getDNI().equals(textField.getText()) && cliente.getPassword().equals(pass)){
								aux = true;
								setNombre(cliente.getName());
								setDNI(cliente.getDNI());
								dispose();
							}
						if(aux == false)
							JOptionPane.showMessageDialog(Dialogo.this, "Incorrect data");
						
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
