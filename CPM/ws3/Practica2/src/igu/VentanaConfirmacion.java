package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaConfirmacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFinalizarPedido;
	private JLabel lblCodigoRecogida;
	private JTextField textCodigoPedido;
	private JButton btnFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfirmacion dialog = new VentanaConfirmacion();
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
	public VentanaConfirmacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.png")));
		setBackground(Color.WHITE);
		setTitle("McDonald's: Confirmaci\u00F3n del pedido");
		setBounds(100, 100, 683, 350);
		getContentPane().setLayout(null);
		getContentPane().add(getLblFinalizarPedido());
		getContentPane().add(getLblCodigoRecogida());
		getContentPane().add(getTextField_1());
		getContentPane().add(getBtnFinalizar());

	}
	private JLabel getLblFinalizarPedido() {
		if (lblFinalizarPedido == null) {
			lblFinalizarPedido = new JLabel("   Pulse Finalizar para confirmar su pedido");
			lblFinalizarPedido.setBounds(0, 86, 667, 50);
			lblFinalizarPedido.setBackground(Color.WHITE);
			lblFinalizarPedido.setVerticalAlignment(SwingConstants.TOP);
			lblFinalizarPedido.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblFinalizarPedido.setFont(new Font("Arial Black", Font.PLAIN, 25));
		}
		return lblFinalizarPedido;
	}
	private JLabel getLblCodigoRecogida() {
		if (lblCodigoRecogida == null) {
			lblCodigoRecogida = new JLabel("El c\u00F3digo de recogida es: ");
			lblCodigoRecogida.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCodigoRecogida.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCodigoRecogida.setBounds(62, 182, 248, 33);
		}
		return lblCodigoRecogida;
	}
	private JTextField getTextField_1() {
		if (textCodigoPedido == null) {
			textCodigoPedido = new JTextField();
			textCodigoPedido.setBackground(Color.LIGHT_GRAY);
			textCodigoPedido.setEditable(false);
			textCodigoPedido.setBounds(320, 184, 134, 34);
			textCodigoPedido.setColumns(10);
		}
		return textCodigoPedido;
	}
	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.setEnabled(false);
			btnFinalizar.setForeground(Color.WHITE);
			btnFinalizar.setBackground(Color.GREEN);
			btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnFinalizar.setBounds(504, 265, 89, 23);
		}
		return btnFinalizar;
	}
}
