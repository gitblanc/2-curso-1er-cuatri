package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.Bookstore;
import logic.Client;


public class VentanaRegistro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final JPanel contentPanel = new JPanel();
	private JPanel pnHeader;
	private JLabel lblAppIcon;
	private JPanel pnData;
	private JLabel lblIntroduceData;
	private JLabel lblDni;
	private JTextField txDni;
	private JLabel lblPassword;
	private JPasswordField fiPassword;
	
	private JPanel pnSouth;
	private JButton btnOk;
	private JButton btnCancel;
	
	private Bookstore bookshop;

	private VentanaRegistro vR = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaRegistro dialog = new VentanaRegistro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaRegistro() {
		
		initialize();
	}
	
	private void initialize(){
		
		bookshop = new Bookstore();
		setResizable(false);
		setTitle("Log in to the book store of Oviedo");
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setBackground(new Color(255, 250, 205));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/libreria.jpg")));
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 205));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		contentPanel.add(getPnHeader(), BorderLayout.NORTH);
		contentPanel.add(getPnData(), BorderLayout.CENTER);	
		contentPanel.add(getPnSouth(), BorderLayout.SOUTH);
		getRootPane().setDefaultButton(getBtnOk());
		closeEscape(this);
		txDni.setText("");
		fiPassword.setText("");
		
		validate();
	}
	
	private JPanel getPnHeader(){
		if(pnHeader == null){
			pnHeader = new JPanel();
			pnHeader.setBackground(new Color(255, 250, 205));
			pnHeader.setLayout(new BorderLayout(0, 0));
			pnHeader.add(getLblAppIcon(), BorderLayout.WEST);
		}
		return pnHeader;
	}
	
	private JLabel getLblAppIcon(){
		if(lblAppIcon == null){
			lblAppIcon = new JLabel();
			lblAppIcon.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/img/libreria.jpg")));
		}
		return lblAppIcon;
	}
	
	private JPanel getPnData(){
		if(pnData == null){
			pnData = new JPanel();
			pnData.setBackground(new Color(255, 250, 205));
			pnData.setLayout(null);
			pnData.add(getLblIntroduceData());
			pnData.add(getLblDni());
			pnData.add(getTxDni());
			pnData.add(getLblPassword());
			pnData.add(getFiPassword());
		}
		return pnData;
	}
	
	private JLabel getLblIntroduceData(){
		if(lblIntroduceData == null){
			lblIntroduceData = new JLabel("Introduce your personal data:");
			lblIntroduceData.setBounds(0, 0, 640, 20);
			lblIntroduceData.setHorizontalAlignment(SwingConstants.CENTER);
			lblIntroduceData.setFont(new Font("Segoe UI", Font.BOLD, 14));
		}
		return lblIntroduceData;
	}
	
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI: ");
			lblDni.setLabelFor(getTxDni());
			lblDni.setBackground(new Color(255, 250, 205));
			lblDni.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblDni.setDisplayedMnemonic('D');
			lblDni.setBounds(131, 55, 67, 30);
		}
		return lblDni;
	}
	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setToolTipText("Introduce your dni");
			txDni.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			txDni.setBounds(234, 60, 161, 23);
			txDni.setColumns(10);
		}
		return txDni;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("PASSWORD:");
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setLabelFor(getFiPassword());
			lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblPassword.setBackground(new Color(255, 250, 205));
			lblPassword.setBounds(131, 125, 100, 30);
		}
		return lblPassword;
	}
	private JPasswordField getFiPassword() {
		if (fiPassword == null) {
			fiPassword = new JPasswordField();
			fiPassword.setToolTipText("Introduce your password");
			fiPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			fiPassword.setBounds(234, 130, 161, 23);
		}
		return fiPassword;
	}
	
	 public static void closeEscape(final JDialog dialog) {
		 ActionListener act = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 dialog.dispose();
			 }
		 };
		 dialog.getRootPane().registerKeyboardAction(act,KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
		 JComponent.WHEN_IN_FOCUSED_WINDOW);
	}
	
	private JPanel getPnSouth() {
		if (pnSouth == null) {
			pnSouth = new JPanel();
			pnSouth.setBackground(new Color(255, 250, 205));
			pnSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
			pnSouth.add(getBtnOk());
			pnSouth.add(getBtnCancel());

		}
		return pnSouth;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
										
					List<Client> clients = bookshop.getAllClients();
					
					char[] password = fiPassword.getPassword();
					String pass = new String(password);
					
					String dni = txDni.getText();
					boolean found = false;
					Client foundC = null;
					
					for(Client c : clients){
						if(dni.equals(c.getDNI()) && pass.equals(c.getPassword())){
							found = true;
							foundC = c;
							break;
						}
					}
					
					if(found == true){
						VentanaPrincipal vP = new VentanaPrincipal(vR, foundC.getName(), foundC.getDNI());
						vP.setLocationRelativeTo(null);
						vP.setVisible(true);
						vR.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Fill correctly dni and password fields.");
						vR.initialize();
					}
				}
			});
			btnOk.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnOk.setBackground(new Color(255, 255, 255));
		}
		return btnOk;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnCancel.setBackground(new Color(255, 255, 255));
		}
		return btnCancel;
	}
}
