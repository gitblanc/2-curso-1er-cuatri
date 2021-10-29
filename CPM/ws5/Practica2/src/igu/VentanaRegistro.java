package igu;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VentanaRegistro extends JDialog {

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
	private VentanaPrincipal ventanaPrincipal;

	/**
	 * Constructor para VentanaRegistro que crea el frame
	 * 
	 * @param ventanaPrincipal
	 */
	public VentanaRegistro(VentanaPrincipal vp) {
		this.ventanaPrincipal = vp;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/logo.png")));
		setTitle("McDonald's: Datos de Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// solo se cierra la ventana
		setBounds(100, 100, 617, 467);
		setLocationRelativeTo(null);// para centrar en la pantalla
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

	/*
	 * Getter para el JButton siguiente con la acci�n de validar el formulario
	 */
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setMnemonic('S');
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

	/*
	 * Getter para el JPanel del pedido
	 */
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

	/*
	 * Getter para el JRadioButton rdbtnLocal
	 */
	public JRadioButton getRdbtnLocal() {
		if (rdbtnLocal == null) {
			rdbtnLocal = new JRadioButton("Local");
			rdbtnLocal.setMnemonic('L');
			buttonGroup.add(rdbtnLocal);
			rdbtnLocal.setSelected(true);
			rdbtnLocal.setBackground(new Color(255, 255, 255));
			rdbtnLocal.setBounds(6, 42, 76, 23);
		}
		return rdbtnLocal;
	}

	/*
	 * Getter para el JRadioButton rdbtnLlevar
	 */
	public JRadioButton getRdbtnLLevar() {
		if (rdbtnLLevar == null) {
			rdbtnLLevar = new JRadioButton("Llevar");
			rdbtnLLevar.setMnemonic('v');
			buttonGroup.add(rdbtnLLevar);
			rdbtnLLevar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnLLevar.isSelected()) {
						ventanaPrincipal.getPedido().setParaLlevarONo(true);
					} else {
						ventanaPrincipal.getPedido().setParaLlevarONo(false);
					}

				}
			});
			rdbtnLLevar.setBackground(new Color(255, 255, 255));
			rdbtnLLevar.setBounds(109, 42, 70, 23);

		}
		return rdbtnLLevar;
	}

	/*
	 * Getter para el JButton cancelar con la acci�n de mantener abierta la
	 * ventanaRegistro
	 */
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setBackground(new Color(165, 42, 42));
			btnCancelar.setBounds(431, 394, 89, 23);
		}
		return btnCancelar;
	}

	/*
	 * Getter para el JPanel datos del cliente
	 */
	private JPanel getPnDatosCliente() {
		if (pnDatosCliente == null) {
			pnDatosCliente = new JPanel();
			pnDatosCliente.setBackground(new Color(255, 255, 255));
			pnDatosCliente.setBorder(
					new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

	/*
	 * Getter para el JLabel nombre y apellidos
	 */
	private JLabel getLblNombreApellidos() {
		if (lblNombreApellidos == null) {
			lblNombreApellidos = new JLabel("Nombre y Apellidos: ");
			lblNombreApellidos.setLabelFor(getTextNombreApellidos());
			lblNombreApellidos.setDisplayedMnemonic('N');
			lblNombreApellidos.setBounds(10, 46, 179, 27);
		}
		return lblNombreApellidos;
	}

	/*
	 * Getter para el JLabel a�o
	 */
	private JLabel getLblYear() {
		if (lblYear == null) {
			lblYear = new JLabel("A\u00F1o de Nacimiento: ");
			lblYear.setLabelFor(getComboBox());
			lblYear.setDisplayedMnemonic('A');
			lblYear.setBounds(10, 107, 179, 27);
		}
		return lblYear;
	}

	/*
	 * Getter para el JLabel contrase�a
	 */
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password: ");
			lblPassword.setLabelFor(getPasswordField());
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setBounds(10, 169, 179, 27);
		}
		return lblPassword;
	}

	/*
	 * Getter para el JLabel reintroduzca contrase�a
	 */
	private JLabel getLblReintroduzcaPassword() {
		if (lblReintroduzcaPassword == null) {
			lblReintroduzcaPassword = new JLabel("Reintroduzca password: ");
			lblReintroduzcaPassword.setLabelFor(getPasswordField_1());
			lblReintroduzcaPassword.setDisplayedMnemonic('t');
			lblReintroduzcaPassword.setBounds(10, 228, 179, 27);
		}
		return lblReintroduzcaPassword;
	}

	/*
	 * Getter para el JTextField nombre y apellidos
	 */
	private JTextField getTextNombreApellidos() {
		if (textNombreApellidos == null) {
			textNombreApellidos = new JTextField();
			textNombreApellidos.setBounds(172, 39, 330, 34);
			textNombreApellidos.setColumns(10);
		}
		return textNombreApellidos;
	}

	/*
	 * Getter para el JPasswordField contrase�a
	 */
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(172, 162, 330, 34);
		}
		return passwordField;
	}

	/*
	 * Getter para el combobox de los a�os
	 */
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			String[] a�os = new String[90];
			for (int i = 0; i < 90; i++) {
				a�os[i] = "" + ((90 - i) + 1920);
			}
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(a�os));
			comboBox.setBounds(172, 107, 179, 24);
		}
		return comboBox;
	}

	/*
	 * Getter para el JPasswordField repita la contrase�a
	 */
	private JPasswordField getPasswordField_1() {
		if (passwordField_1 == null) {
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(172, 221, 330, 34);
		}
		return passwordField_1;
	}

	/*
	 * M�todo que valida el formulario
	 */
	private void validarFormulario() {
		String contrase�a = String.valueOf(getPasswordField().getPassword());
		String contrase�aRepetida = String.valueOf(getPasswordField_1().getPassword());
		if (getTextNombreApellidos().getText() == null || getTextNombreApellidos().getText().isBlank()) { // con el get
																											// no se
																											// generar�
																											// el
																											// nullPointerException
																											// si no
																											// existe
			JOptionPane.showMessageDialog(null, "El nombre introducido no es v�lido.");
		} else if (contrase�a.isBlank()) {
			JOptionPane.showMessageDialog(null, "Introduzca la contrase�a :)");
		} else if (!contrase�a.equals(contrase�aRepetida)) {
			JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden");
		} else {
			mostrarVentanaConfirmaci�n();
		}
	}

	/*
	 * M�todo que muestra la ventana confirmaci�n
	 */
	private void mostrarVentanaConfirmaci�n() {
		VentanaConfirmacion vc = new VentanaConfirmacion(this);
		vc.setLocationRelativeTo(this);
		vc.setModal(true);
		vc.setVisible(true);
	}

	/*
	 * Getter para ventanaPrincipal
	 */
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
}
