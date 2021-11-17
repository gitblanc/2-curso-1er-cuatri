/**
 * 
 */
package igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import src.Articulo;
import src.Pedido;
import src.Ruleta;

/**
 * @author blanc
 *
 */
public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblRuleta;
	private JLabel lblPuntos;
	private JTextField txtPuntos;
	private JButton btnGirarRuleta;
	private JComboBox<Articulo> comboBoxRegalos;
	private JLabel lblRegalos;
	private Ruleta ruleta;
	private Pedido pedido;
	private JLabel lblSeleccionaPremios;
	private JLabel lblIconosPremios;
	private JSpinner spinnerUnidades;
	private JButton btnAñadir;
	private JScrollPane scrollPanePremios;
	private JTextArea textAreaPremios;
	private JLabel lblPuntosInsuficientes;
	private JPanel panel;
	private JButton btnElectronica;
	private JButton btnInfantil;
	private JButton btnOcio;
	private JMenuBar menuBar;
	private JMenu menuNuevo;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmAcercaDe;
	private JSeparator separator;
	private JSeparator separator_1;
	private JMenuItem mntmSalir;

	public VentanaPrincipal(Ruleta r1, Pedido pedido) {
		setResizable(false);
		this.pedido = pedido;
		this.ruleta = r1;
		setBounds(new Rectangle(0, 0, 870, 470));
		getContentPane().setBackground(Color.WHITE);
		getLblIconosPremios().setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/EL01.png")));
		setTitle("Ruleta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/ruleta.png")));
		setBounds(100, 100, 1092, 491);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblRuleta());
		getContentPane().add(getLblPuntos());
		getContentPane().add(getTxtPuntos());
		getContentPane().add(getBtnGirarRuleta());
		getContentPane().add(getComboBoxRegalos());
		getContentPane().add(getLblRegalos());
		getContentPane().add(getLblSeleccionaPremios());
		getContentPane().add(getLblIconosPremios());
		getContentPane().add(getSpinnerUnidades());
		getContentPane().add(getBtnAñadir());
		getContentPane().add(getScrollPanePremios());
		getContentPane().add(getLblPuntosInsuficientes());
		getContentPane().add(getPanel());
		setJMenuBar(getMenuBar_1());
	}

	private JLabel getLblRuleta() {
		if (lblRuleta == null) {
			lblRuleta = new JLabel("");
			lblRuleta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ruleta.png")));
			lblRuleta.setBounds(10, 115, 223, 224);
		}
		return lblRuleta;
	}

	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("Puntos:");
			lblPuntos.setLabelFor(getTxtPuntos());
			lblPuntos.setDisplayedMnemonic('P');
			lblPuntos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPuntos.setBounds(249, 15, 115, 58);
		}
		return lblPuntos;
	}

	private JTextField getTxtPuntos() {
		if (txtPuntos == null) {
			txtPuntos = new JTextField();
			txtPuntos.setEditable(false);
			txtPuntos.setBounds(323, 23, 127, 46);
			txtPuntos.setColumns(10);
		}
		return txtPuntos;
	}

	private JButton getBtnGirarRuleta() {
		if (btnGirarRuleta == null) {
			btnGirarRuleta = new JButton("\u00A1SPIN!");
			btnGirarRuleta.setMnemonic('S');
			btnGirarRuleta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					girarRuleta();
					btnGirarRuleta.setEnabled(false);
					btnAñadir.setEnabled(true);
				}
			});
			btnGirarRuleta.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnGirarRuleta.setBackground(new Color(255, 228, 181));
			btnGirarRuleta.setBounds(40, 350, 152, 46);
		}
		return btnGirarRuleta;
	}

	private void girarRuleta() {
		int num = getRuleta().lanzar();
		switch (num) {
		case 100:
			getTxtPuntos().setText("100");
			break;
		case 200:
			getTxtPuntos().setText("200");
			break;
		case 300:
			getTxtPuntos().setText("300");
			break;
		case 400:
			getTxtPuntos().setText("400");
			break;
		default:
			getTxtPuntos().setText("500");
			break;
		}
		textoSeleccionaPremios();
	}

	private void textoSeleccionaPremios() {
		float puntos = Float.parseFloat(getTxtPuntos().getText());
		if (puntos <= 100 && puntos >= 75) {
			getLblSeleccionaPremios().setText("Selecciona tu premio");
		} else if (puntos < 75) {
			getLblSeleccionaPremios().setText("No tienes suficientes puntos para seleccionar premio");
		} else {
			getLblSeleccionaPremios().setText("Selecciona tus premios");
		}
		getLblSeleccionaPremios().setVisible(true);
	}

	private JComboBox<Articulo> getComboBoxRegalos() {
		if (comboBoxRegalos == null) {
			comboBoxRegalos = new JComboBox<Articulo>();
			comboBoxRegalos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Articulo art = (Articulo) comboBoxRegalos.getSelectedItem();
					mostrarImagenProducto(art.getCodigo());
				}
			});
			comboBoxRegalos.setModel(new DefaultComboBoxModel<Articulo>(this.ruleta.getArticulos()));
			comboBoxRegalos.setBounds(243, 151, 292, 46);
		}
		return comboBoxRegalos;
	}

	private void mostrarImagenProducto(String codigo) {
		lblIconosPremios.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/" + codigo + ".png")));

	}

	private JLabel getLblRegalos() {
		if (lblRegalos == null) {
			lblRegalos = new JLabel("Regalos:");
			lblRegalos.setLabelFor(getComboBoxRegalos());
			lblRegalos.setDisplayedMnemonic('r');
			lblRegalos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegalos.setBounds(249, 115, 64, 25);
		}
		return lblRegalos;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Ruleta getRuleta() {
		return ruleta;
	}

	private JLabel getLblSeleccionaPremios() {
		if (lblSeleccionaPremios == null) {
			lblSeleccionaPremios = new JLabel("");
			lblSeleccionaPremios.setVisible(false);
			lblSeleccionaPremios.setForeground(new Color(205, 92, 92));
			lblSeleccionaPremios.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblSeleccionaPremios.setBounds(297, 90, 216, 25);
		}
		return lblSeleccionaPremios;
	}

	private JLabel getLblIconosPremios() {
		if (lblIconosPremios == null) {
			lblIconosPremios = new JLabel("");
			lblIconosPremios.setBounds(297, 241, 147, 125);
		}
		return lblIconosPremios;
	}

	private JSpinner getSpinnerUnidades() {
		if (spinnerUnidades == null) {
			spinnerUnidades = new JSpinner();
			spinnerUnidades.setModel(new SpinnerNumberModel(1, 1, null, 1));
			spinnerUnidades.setBounds(579, 155, 30, 20);
		}
		return spinnerUnidades;
	}

	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("A\u00F1adir");
			btnAñadir.setMnemonic('A');
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AñadirAPedido();
				}
			});
			btnAñadir.setEnabled(false);
			btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAñadir.setBackground(new Color(143, 188, 143));
			btnAñadir.setBounds(579, 186, 89, 23);
		}
		return btnAñadir;
	}

	private void AñadirAPedido() {
		Articulo art = (Articulo) getComboBoxRegalos().getSelectedItem();
		int unidadesSolicitadas = (int) getSpinnerUnidades().getValue();
		float total = art.getPrecio() * unidadesSolicitadas;
		if (total <= Float.parseFloat(txtPuntos.getText())) {
			pedido.add(art, unidadesSolicitadas);
			getTxtPuntos().setText(String.format("%.0f", ruleta.getPuntosTirada() - pedido.getTotal()));
			getTextAreaPremios().setText(pedido.toString());
			validate();
			repaint();
		} else {
			getLblPuntosInsuficientes().setVisible(true);
		}

	}

	private JScrollPane getScrollPanePremios() {
		if (scrollPanePremios == null) {
			scrollPanePremios = new JScrollPane();
			scrollPanePremios.setBounds(579, 26, 242, 125);
			scrollPanePremios.setViewportView(getTextAreaPremios());
		}
		return scrollPanePremios;
	}

	private JTextArea getTextAreaPremios() {
		if (textAreaPremios == null) {
			textAreaPremios = new JTextArea();
			textAreaPremios.setEditable(false);
		}
		return textAreaPremios;
	}

	private JLabel getLblPuntosInsuficientes() {
		if (lblPuntosInsuficientes == null) {
			lblPuntosInsuficientes = new JLabel("No tienes puntos suficientes");
			lblPuntosInsuficientes.setVisible(false);
			lblPuntosInsuficientes.setForeground(new Color(255, 0, 0));
			lblPuntosInsuficientes.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblPuntosInsuficientes.setBounds(579, 220, 242, 30);
		}
		return lblPuntosInsuficientes;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(902, 26, 164, 395);
			panel.setLayout(new GridLayout(3, 0, 0, 0));
			panel.add(getBtnElectronica());
			panel.add(getBtnInfantil());
			panel.add(getBtnOcio());
		}
		return panel;
	}

	private JButton getBtnElectronica() {
		if (btnElectronica == null) {
			btnElectronica = new JButton("Electr\u00F3nica");
			btnElectronica.setMnemonic('E');
			btnElectronica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTipoEnComboBox("Electronica");
				}
			});
			btnElectronica.setHorizontalTextPosition(SwingConstants.CENTER);
			btnElectronica.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnElectronica.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoElectronica.png")));
		}
		return btnElectronica;
	}

	private void mostrarTipoEnComboBox(String string) {
		ArrayList<Articulo> artsMismoTipo = ruleta.getPremiosMismoTipo(string);
		Articulo[] arts = new Articulo[artsMismoTipo.size()];
		int i = 0;
		for (Articulo art : artsMismoTipo) {
			arts[i] = art;
			i++;
		}
		getComboBoxRegalos().setModel(new DefaultComboBoxModel<Articulo>(arts));
		mostrarImagenProducto(arts[0].getCodigo());

	}

	private JButton getBtnInfantil() {
		if (btnInfantil == null) {
			btnInfantil = new JButton("Infantil");
			btnInfantil.setMnemonic('I');
			btnInfantil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTipoEnComboBox("Infantil");
				}
			});
			btnInfantil.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnInfantil.setHorizontalTextPosition(SwingConstants.CENTER);
			btnInfantil.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoInfantil.png")));
		}
		return btnInfantil;
	}

	private JButton getBtnOcio() {
		if (btnOcio == null) {
			btnOcio = new JButton("Ocio");
			btnOcio.setMnemonic('O');
			btnOcio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTipoEnComboBox("Ocio");
				}
			});
			btnOcio.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnOcio.setHorizontalTextPosition(SwingConstants.CENTER);
			btnOcio.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconoOcio.png")));
		}
		return btnOcio;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuNuevo());
		}
		return menuBar;
	}

	private JMenu getMenuNuevo() {
		if (menuNuevo == null) {
			menuNuevo = new JMenu("Men\u00FA");
			menuNuevo.setMnemonic('M');
			menuNuevo.add(getMenuItem_1());
			menuNuevo.add(getSeparator_1());
			menuNuevo.add(getMenuItem_2());
			menuNuevo.add(getSeparator());
			menuNuevo.add(getMenuItem_3());
		}
		return menuNuevo;
	}

	private JMenuItem getMenuItem_1() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("Nuevo");
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmNuevo;
	}

	protected void inicializar() {
		pedido.inicializar();
		getComboBoxRegalos().setSelectedIndex(0);
		getSpinnerUnidades().setValue(1);
		getTxtPuntos().setText("");
		getBtnGirarRuleta().setEnabled(true);
		getLblSeleccionaPremios().setVisible(false);
		getLblPuntosInsuficientes().setVisible(false);
		getTextAreaPremios().setText("");
	}

	private JMenuItem getMenuItem_2() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca De");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Examen tipo Eduardo Blanco Bielsa 41012833S","Acerca De",
							JOptionPane.INFORMATION_MESSAGE);
					
					
				}
			});
			mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmAcercaDe;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JMenuItem getMenuItem_3() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmSalir;
	}
}
