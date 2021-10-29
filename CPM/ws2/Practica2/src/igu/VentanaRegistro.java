package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSiguiente;
	private JPanel pnPedido;
	private JRadioButton rdbtnLocal;
	private JRadioButton rdbtnLLevar;
	private JButton btnCancelar;
	private JPanel pnDatosCliente;
	private JLabel lblNombreApellidos;
	private JLabel lblYear;
	private JLabel lblPassword;
	private JLabel lblReintroduzcaPassword;
	private JTextField textNombreApellidos;
	private JPasswordField passwordField;
	private JComboBox<String> comboBox;
	private JPasswordField passwordField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//se crea un nuevo hilo
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setTitle("Datos de Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//al cerrar la ventana se finaliza completamente la aplicación
		setBounds(100, 100, 617, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		contentPane.add(getPnPedido());
		contentPane.add(getPnDatosCliente());
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarFormulario();
				}
			});
			btnSiguiente.setBackground(new Color(0, 128, 0));
			btnSiguiente.setForeground(Color.WHITE);
			btnSiguiente.setBounds(312, 394, 89, 23);
		}
		return btnSiguiente;
	}
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPedido.setBackground(new Color(255, 255, 255));
			pnPedido.setBounds(39, 338, 185, 79);
			pnPedido.setLayout(null);
			pnPedido.add(getRdbtnLocal());
			pnPedido.add(getRdbtnLLevar());
		}
		return pnPedido;
	}
	private JRadioButton getRdbtnLocal() {
		if (rdbtnLocal == null) {
			rdbtnLocal = new JRadioButton("Local");
			buttonGroup.add(rdbtnLocal);
			rdbtnLocal.setSelected(true);
			rdbtnLocal.setBackground(new Color(255, 255, 255));
			rdbtnLocal.setBounds(6, 42, 76, 23);
		}
		return rdbtnLocal;
	}
	private JRadioButton getRdbtnLLevar() {
		if (rdbtnLLevar == null) {
			rdbtnLLevar = new JRadioButton("Llevar");
			buttonGroup.add(rdbtnLLevar);
			rdbtnLLevar.setBackground(new Color(255, 255, 255));
			rdbtnLLevar.setBounds(109, 42, 70, 23);
		}
		return rdbtnLLevar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setBackground(Color.RED);
			btnCancelar.setBounds(431, 394, 89, 23);
		}
		return btnCancelar;
	}
	private JPanel getPnDatosCliente() {
		if (pnDatosCliente == null) {
			pnDatosCliente = new JPanel();
			pnDatosCliente.setBackground(new Color(255, 255, 255));
			pnDatosCliente.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosCliente.setBounds(31, 28, 543, 282);
			pnDatosCliente.setLayout(null);
			pnDatosCliente.add(getLblNombreApellidos());
			pnDatosCliente.add(getLblYear());
			pnDatosCliente.add(getLblPassword());
			pnDatosCliente.add(getLblReintroduzcaPassword());
			pnDatosCliente.add(getTextNombreApellidos());
			pnDatosCliente.add(getPasswordField());
			pnDatosCliente.add(getComboBox());
			pnDatosCliente.add(getPasswordField_1());
		}
		return pnDatosCliente;
	}
	private JLabel getLblNombreApellidos() {
		if (lblNombreApellidos == null) {
			lblNombreApellidos = new JLabel("Nombre y Apellidos: ");
			lblNombreApellidos.setBounds(10, 46, 179, 27);
		}
		return lblNombreApellidos;
	}
	private JLabel getLblYear() {
		if (lblYear == null) {
			lblYear = new JLabel("A\u00F1o de Nacimiento: ");
			lblYear.setBounds(10, 107, 179, 27);
		}
		return lblYear;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password: ");
			lblPassword.setBounds(10, 169, 179, 27);
		}
		return lblPassword;
	}
	private JLabel getLblReintroduzcaPassword() {
		if (lblReintroduzcaPassword == null) {
			lblReintroduzcaPassword = new JLabel("Reintroduzca password: ");
			lblReintroduzcaPassword.setBounds(10, 228, 179, 27);
		}
		return lblReintroduzcaPassword;
	}
	private JTextField getTextNombreApellidos() {
		if (textNombreApellidos == null) {
			textNombreApellidos = new JTextField();
			textNombreApellidos.setBounds(172, 49, 330, 20);
			textNombreApellidos.setColumns(10);
		}
		return textNombreApellidos;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(172, 172, 330, 20);
		}
		return passwordField;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			String[] años = new String[90];
			for (int i = 0; i < 90; i++) {
				años[i] = "" + ((90-i)+1920);
			}
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(años));
			comboBox.setBounds(172, 109, 179, 22);
		}
		return comboBox;
	}
	private JPasswordField getPasswordField_1() {
		if (passwordField_1 == null) {
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(172, 231, 330, 20);
		}
		return passwordField_1;
	}

	private void validarFormulario() {
		String contraseña = String.valueOf(getPasswordField().getPassword());
		String contraseñaRepetida = String.valueOf(getPasswordField_1().getPassword());	
		if(getTextNombreApellidos().getText() == null || getTextNombreApellidos().getText().isBlank()) { // con el get no se generará el nullPointerException si no existe
			JOptionPane.showMessageDialog(null, "El nombre introducido no es válido.");
		}
		else if(contraseña.isBlank()) {
			JOptionPane.showMessageDialog(null, "Introduzca la contraseña :)");
		}
		else if(!contraseña.equals(contraseñaRepetida)) {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
		}
		else {
			JOptionPane.showMessageDialog(null, "Todo correcto.");
			System.exit(0);
		}
	}
}
