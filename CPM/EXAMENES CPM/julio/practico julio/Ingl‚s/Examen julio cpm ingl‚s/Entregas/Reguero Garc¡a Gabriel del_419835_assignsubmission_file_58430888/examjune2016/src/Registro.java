import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.User;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Principal prin;
	public User usuario;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblId;
	private JLabel lblPassword;
	private JLabel lblRegistration;

	/*/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			Registro dialog = new Registro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @param principal 
	 */
	public Registro(Principal principal) 
	{
		setTitle("Registration Window");
		prin= principal;
		setBounds(100, 100, 380, 246);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTextField());
		contentPanel.add(getPasswordField());
		contentPanel.add(getLblId());
		contentPanel.add(getLblPassword());
		contentPanel.add(getLblRegistration());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						
						if(comprobacion())
						{
							prin.cerrarRegistro();
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
					public void actionPerformed(ActionEvent arg0) 
					{
						prin.exit();
						System.exit(0);
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private boolean comprobacion() 
	{
		User aux;
		for(int i=0;i<prin.users.size();i++)
		{
			
			aux=prin.users.get(i);
			
			if(textField.getText().equals(aux.id))
			{
				
				if(passwordField.getText().equals(aux.password))
			{
				
				usuario=aux;
				return true;
			}
			}
		}
		return false;
	}
	
	public User getUser() 
	{
		return usuario;
		
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(150, 72, 127, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(150, 122, 127, 20);
		}
		return passwordField;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID:");
			lblId.setBounds(94, 75, 46, 14);
		}
		return lblId;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(64, 125, 76, 14);
		}
		return lblPassword;
	}
	private JLabel getLblRegistration() {
		if (lblRegistration == null) {
			lblRegistration = new JLabel("Registration");
			lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRegistration.setBounds(117, 33, 122, 28);
		}
		return lblRegistration;
	}
}
