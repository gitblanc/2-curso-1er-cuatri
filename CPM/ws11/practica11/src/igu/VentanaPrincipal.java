package igu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import logica.Articulo;
import logica.Carta;
import logica.Pedido;
import logica.Pedido.TipoPedido;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private AccionBoton aB;
	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblLblnombre;
	private Carta carta;
	private Pedido pedido;
	private JPanel pnInfo1;
	private JPanel pnlLogo;
	private JPanel pnArticulos;
	private JPanel pnBts1;
	private JPanel pnBts2;
	private JPanel pnBts3;
	private JPanel pnContenidos;
	private JPanel pn2;
	private JPanel pn3;
	private JPanel pnDatosCliente;
	private JLabel lbNombre;
	private JTextField txtNombre;
	private JLabel lbAño;
	private JComboBox<String> cbAños;
	private JLabel lbPasw1;
	private JPasswordField psw1;
	private JLabel lbPasw2;
	private JPasswordField psw2;
	private JPanel pn1;
	private JPanel pnFormulario;
	private JPanel pnDatosPedido;
	private JRadioButton rbLocal;
	private JRadioButton rbLlevar;
	private JPanel pnInfo2;
	private JPanel pnConfirmacion;
	private JPanel pnInfo3;
	private JLabel lbAviso;
	private JLabel lbOk;
	private JLabel lbCodigo;
	private JTextField txCodigo;
	private final ButtonGroup grPedido = new ButtonGroup();
	private JTabbedPane panelPedido;
	private JScrollPane scrollComida;
	private JScrollPane scrollBebida;
	private JList<Articulo> listComida;
	private JList<Articulo> listBebida;
	private DefaultListModel<Articulo> modeloListComida;
	private DefaultListModel<Articulo> modeloListBebida;
	private JTextField txPrecio;
	private JButton btAnular1;
	private JButton btSig1;
	private JButton btAnt2;
	private JButton btSig2;
	private JButton btAnt3;
	private JButton btSig3;
	private JPanel panelFiltros;
	private JButton btTodo;
	private JButton btHamburguesas;
	private JButton btBebidas;
	private JButton btComplementos;
	private JButton btPostres;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Carta carta, Pedido pedido) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				asociaImagenBotones();
			}
		});
		this.carta = carta;
		this.pedido = pedido;
		aB = new AccionBoton();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		setTitle("McDonald's España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 820);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnlLogo(), BorderLayout.NORTH);
		contentPane.add(getPnContenidos(), BorderLayout.CENTER);
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		}
		return lblLogo;
	}

	private JLabel getLblLblnombre() {
		if (lblLblnombre == null) {
			lblLblnombre = new JLabel("McDonald's");
			lblLblnombre.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lblLblnombre.setForeground(Color.BLACK);
		}
		return lblLblnombre;
	}

	protected void inicializar1() {
		pedido.inicializar();
		modeloListBebida.clear();
		modeloListComida.clear();
		getTxPrecio().setText("Precio: 0.0");
		getBtSig1().setEnabled(false);
	}

	protected void inicializar2() {
		getTxtNombre().setText("");
		getPsw1().setText("");
		getPsw2().setText("");

	}

	protected void inicializar3() {
		getTxCodigo().setText("");
	}

	private JPanel getPnInfo1() {
		if (pnInfo1 == null) {
			pnInfo1 = new JPanel();
			pnInfo1.setBackground(Color.WHITE);
			pnInfo1.setLayout(new BorderLayout(0, 0));
			pnInfo1.add(getPnBts1(), BorderLayout.SOUTH);
			pnInfo1.add(getPanelPedido(), BorderLayout.CENTER);

		}
		return pnInfo1;
	}

	private JPanel getPnlLogo() {
		if (pnlLogo == null) {
			pnlLogo = new JPanel();
			pnlLogo.setBackground(Color.WHITE);
			pnlLogo.setLayout(new GridLayout(1, 0, 0, 0));
			pnlLogo.add(getLblLogo());
			pnlLogo.add(getLblLblnombre());
		}
		return pnlLogo;
	}

	private JPanel getPnArticulos() {
		if (pnArticulos == null) {
			pnArticulos = new JPanel();
			pnArticulos.setBorder(new LineBorder(Color.ORANGE, 4));
			pnArticulos.setBackground(Color.WHITE);
			// COMPLETAR 1
			pnArticulos.setLayout(new GridLayout(0, 6, 3, 3));
			creaBotonesTablero();
		}
		return pnArticulos;
	}

	private void creaBotonesTablero() {
		pnArticulos.removeAll();
		for (int i = 0; i < carta.getListaArticulos().size(); i++) {
			pnArticulos.add(nuevoBoton(i));
		}

	}

	private void setImagenAdaptada(JButton boton, String rutaImagen) {
		Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);// scale
																													// fast->
																													// la
																													// imagen
																													// carga
																													// lo
																													// antes
																													// posible
																													// menos
																													// resolución
		ImageIcon icon = new ImageIcon(imgEscalada);
		boton.setIcon(icon);
	}

	private void asociaImagenBotones() {
		for (int i = 0; i < pnArticulos.getComponents().length; i++) {
			JButton boton = (JButton) (pnArticulos.getComponents()[i]);
			setImagenAdaptada(boton, "/img/" + carta.getListaArticulos().get(i).getCodigo() + ".png");
		}
	}

	private JButton nuevoBoton(Integer posicion) {
		JButton boton = new JButton("");
		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setToolTipText(carta.getListaArticulos().get(posicion).toString());
		boton.setActionCommand(posicion.toString());
		boton.addActionListener(aB);
		return boton;
	}

	class AccionBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			añadirAPedido(Integer.parseInt(bt.getActionCommand()));
		}
	}

	// COMPLETAR 2
	private void añadirAPedido(int posArticuloEnCarta) {
		Articulo a = carta.getListaArticulos().get(posArticuloEnCarta);
		pedido.add(a, 1);
		mostrarEnLista(a);
		getTxPrecio().setText("Precio: " + String.format("%.2f", pedido.getTotal()));
		if (!getBtSig1().isEnabled())
			getBtSig1().setEnabled(true);
	}

	// COMPLETAR 3
	private void mostrarEnLista(Articulo a) {
		if (a.getTipo().equals("Bebida")) {
			modeloListBebida.addElement(a);
		} else {
			modeloListComida.addElement(a);
		}

	}

	// COMPLETAR 4
	private void mostrarPn1() {
		// inicializar3();
		getPnBts1().add(getTxPrecio(), 0);
		inicializar1();
		((CardLayout) getPnContenidos().getLayout()).show(pnContenidos, "pn1");
		inicializar2();
	}

	private void mostrarPn2() {
		getPnInfo2().add(getPnDatosPedido());
		getPnBts2().add(getTxPrecio(), 0);
		((CardLayout) getPnContenidos().getLayout()).show(pnContenidos, "pn2");
		// ((CardLayout)getPnContenidos().getLayout()).next(pnContenidos); EQUIVALENTE
	}

	private void mostrarPn3() {
		if (comprobarCampos()) {
			getPnInfo3().add(getPnDatosPedido());
			getPnBts3().add(getTxPrecio(), 0);
			((CardLayout) getPnContenidos().getLayout()).show(pnContenidos, "pn3");
		}
	}

	private JPanel getPnBts1() {
		if (pnBts1 == null) {
			pnBts1 = new JPanel();
			pnBts1.setBackground(Color.WHITE);
			pnBts1.setLayout(new GridLayout(0, 3, 0, 0));
			pnBts1.add(getTxPrecio());
			pnBts1.add(getBtAnular1());
			pnBts1.add(getBtSig1());
		}
		return pnBts1;
	}

	private JPanel getPnBts2() {
		if (pnBts2 == null) {
			pnBts2 = new JPanel();
			pnBts2.setBackground(Color.WHITE);
			pnBts2.setLayout(new GridLayout(0, 3, 0, 0));
			pnBts2.add(getBtAnt2());
			pnBts2.add(getBtSig2());
		}
		return pnBts2;
	}

	private JPanel getPnBts3() {
		if (pnBts3 == null) {
			pnBts3 = new JPanel();
			pnBts3.setBackground(Color.WHITE);
			pnBts3.setLayout(new GridLayout(0, 3, 0, 0));
			pnBts3.add(getBtAnt3());
			pnBts3.add(getBtSig3());
		}
		return pnBts3;
	}

	private JPanel getPnContenidos() {
		if (pnContenidos == null) {
			pnContenidos = new JPanel();
			pnContenidos.setLayout(new CardLayout(0, 0));
			pnContenidos.add(getPn1(), "pn1");
			pnContenidos.add(getPn2(), "pn2");
			pnContenidos.add(getPn3(), "pn3");
		}
		return pnContenidos;
	}

	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getPnFormulario(), BorderLayout.CENTER);
			pn2.add(getPnInfo2(), BorderLayout.SOUTH);
		}
		return pn2;
	}

	private JPanel getPn3() {
		if (pn3 == null) {
			pn3 = new JPanel();
			pn3.setBackground(Color.WHITE);
			pn3.setLayout(new BorderLayout(0, 0));
			pn3.add(getPnConfirmacion());
			pn3.add(getPnInfo3(), BorderLayout.SOUTH);
		}
		return pn3;
	}

	private JComboBox<String> getCbAños() {
		if (cbAños == null) {
			String[] años = new String[90];
			for (int i = 0; i < 90; i++) {
				String año = "" + ((90 - i) + 1920);
				años[i] = año;
			}
			cbAños = new JComboBox<String>();
			cbAños.setFont(new Font("Arial", Font.PLAIN, 14));
			cbAños.setModel(new DefaultComboBoxModel<String>(años));
			cbAños.setBounds(new Rectangle(264, 84, 157, 25));
		}
		return cbAños;
	}

	private boolean isVacio() {
		return (txtNombre.getText().equals("") || (String.valueOf(psw1.getPassword()).equals(""))
				|| (String.valueOf(psw2.getPassword()).equals("")));

	}

	private boolean isIncorrecta() {
		return (!String.valueOf(psw1.getPassword()).equals(String.valueOf(psw2.getPassword())));
	}

	private JPanel getPnDatosCliente() {
		if (pnDatosCliente == null) {
			pnDatosCliente = new JPanel();
			pnDatosCliente.setBounds(104, 58, 656, 224);
			pnDatosCliente.setBorder(
					new TitledBorder(null, "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosCliente.setBackground(Color.WHITE);
			pnDatosCliente.setLayout(null);
			pnDatosCliente.add(getLbNombre());
			pnDatosCliente.add(getTxtNombre());
			pnDatosCliente.add(getLbAño());
			pnDatosCliente.add(getCbAños());
			pnDatosCliente.add(getLbPasw1());
			pnDatosCliente.add(getPsw1());
			pnDatosCliente.add(getLbPasw2());
			pnDatosCliente.add(getPsw2());
		}
		return pnDatosCliente;
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel();
			lbNombre.setText("Nombre y Apellidos:");
			lbNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setBounds(30, 31, 132, 20);
		}
		return lbNombre;
	}

	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txtNombre.setBounds(264, 31, 330, 25);
		}
		return txtNombre;
	}

	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("A\u00F1o de nacimiento:");
			lbAño.setFont(new Font("Arial", Font.PLAIN, 14));
			lbAño.setDisplayedMnemonic('A');
			lbAño.setBounds(30, 81, 151, 16);
		}
		return lbAño;
	}

	private JLabel getLbPasw1() {
		if (lbPasw1 == null) {
			lbPasw1 = new JLabel();
			lbPasw1.setText("Password:");
			lbPasw1.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPasw1.setDisplayedMnemonic('P');
			lbPasw1.setBounds(new Rectangle(13, 123, 105, 16));
			lbPasw1.setBounds(30, 129, 105, 16);
		}
		return lbPasw1;
	}

	private JPasswordField getPsw1() {
		if (psw1 == null) {
			psw1 = new JPasswordField();
			psw1.setFont(new Font("Arial", Font.PLAIN, 14));
			psw1.setBounds(new Rectangle(176, 121, 218, 25));
			psw1.setBounds(264, 129, 218, 25);
		}
		return psw1;
	}

	private JLabel getLbPasw2() {
		if (lbPasw2 == null) {
			lbPasw2 = new JLabel();
			lbPasw2.setText("Reintroduzca password:");
			lbPasw2.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPasw2.setDisplayedMnemonic('R');
			lbPasw2.setBounds(new Rectangle(13, 167, 151, 16));
			lbPasw2.setBounds(30, 181, 182, 16);
		}
		return lbPasw2;
	}

	private JPasswordField getPsw2() {
		if (psw2 == null) {
			psw2 = new JPasswordField();
			psw2.setFont(new Font("Arial", Font.PLAIN, 14));
			psw2.setBounds(new Rectangle(176, 163, 218, 25));
			psw2.setBounds(264, 179, 218, 25);
		}
		return psw2;
	}

	public boolean comprobarCampos() {
		if (isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Hay algún campo en blanco");
			return false;
		} else if (isIncorrecta()) {
			JOptionPane.showMessageDialog(null, "Error: Las passwords no coinciden");
			return false;
		}
		return true;
	}

	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getPnArticulos(), BorderLayout.CENTER);
			pn1.add(getPnInfo1(), BorderLayout.SOUTH);
			pn1.add(getPanelFiltros(), BorderLayout.WEST);
		}
		return pn1;
	}

	private JPanel getPnFormulario() {
		if (pnFormulario == null) {
			pnFormulario = new JPanel();
			pnFormulario.setBorder(new LineBorder(Color.ORANGE, 4));
			pnFormulario.setBackground(Color.WHITE);
			pnFormulario.setLayout(null);
			pnFormulario.add(getPnDatosCliente());
			pnFormulario.add(getPnDatosPedido());
		}
		return pnFormulario;
	}

	private JPanel getPnDatosPedido() {
		if (pnDatosPedido == null) {
			pnDatosPedido = new JPanel();
			pnDatosPedido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del pedido",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatosPedido.setBackground(Color.WHITE);
			pnDatosPedido.setBounds(104, 304, 248, 60);
			pnDatosPedido.add(getRbLocal());
			pnDatosPedido.add(getRbLlevar());
		}
		return pnDatosPedido;
	}

	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton();
			rbLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rbLocal.isSelected()) {
						pedido.setTipo(TipoPedido.LOCAL);
					}
				}
			});
			grPedido.add(rbLocal);
			rbLocal.setText("Local");
			rbLocal.setSelected(true);
			rbLocal.setMnemonic('L');
			rbLocal.setFont(new Font("Arial", Font.PLAIN, 14));
			rbLocal.setBounds(new Rectangle(17, 27, 94, 24));
			rbLocal.setBackground(Color.WHITE);
		}
		return rbLocal;
	}

	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton();
			rbLlevar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rbLlevar.isSelected()) {
						pedido.setTipo(TipoPedido.LLEVAR);
					}
				}
			});
			grPedido.add(rbLlevar);
			rbLlevar.setText("Llevar");
			rbLlevar.setMnemonic('r');
			rbLlevar.setFont(new Font("Arial", Font.PLAIN, 14));
			rbLlevar.setBounds(new Rectangle(115, 27, 86, 24));
			rbLlevar.setBackground(Color.WHITE);
		}
		return rbLlevar;
	}

	private JPanel getPnInfo2() {
		if (pnInfo2 == null) {
			pnInfo2 = new JPanel();
			pnInfo2.setBackground(Color.WHITE);
			pnInfo2.setLayout(new BorderLayout(0, 0));
			pnInfo2.add(getPnBts2(), BorderLayout.SOUTH);
		}
		return pnInfo2;
	}

	private JPanel getPnConfirmacion() {
		if (pnConfirmacion == null) {
			pnConfirmacion = new JPanel();
			pnConfirmacion.setBorder(new LineBorder(Color.ORANGE, 4));
			pnConfirmacion.setBackground(Color.WHITE);
			pnConfirmacion.setLayout(null);
			pnConfirmacion.add(getLbAviso());
			pnConfirmacion.add(getLbOk());
			pnConfirmacion.add(getLbCodigo());
			pnConfirmacion.add(getTxCodigo());
		}
		return pnConfirmacion;
	}

	private JPanel getPnInfo3() {
		if (pnInfo3 == null) {
			pnInfo3 = new JPanel();
			pnInfo3.setBackground(Color.WHITE);
			pnInfo3.setLayout(new BorderLayout(0, 0));
			pnInfo3.add(getPnBts3(), BorderLayout.SOUTH);
		}
		return pnInfo3;
	}

	private void finalizar() {
		pedido.grabarPedido();
		inicializar1();
		mostrarPn1();
	}

	private JLabel getLbAviso() {
		if (lbAviso == null) {
			lbAviso = new JLabel("Pulse Finalizar para confirmar su pedido");
			lbAviso.setFont(new Font("Tahoma", Font.BOLD, 28));
			lbAviso.setBounds(135, 104, 622, 35);
		}
		return lbAviso;
	}

	private JLabel getLbOk() {
		if (lbOk == null) {
			lbOk = new JLabel("");
			lbOk.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ok.png")));
			lbOk.setBounds(50, 91, 73, 52);
		}
		return lbOk;
	}

	private JLabel getLbCodigo() {
		if (lbCodigo == null) {
			lbCodigo = new JLabel("El c\u00F3digo de recogida es:");
			lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbCodigo.setBounds(138, 172, 191, 26);
		}
		return lbCodigo;
	}

	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txCodigo.setEditable(false);
			txCodigo.setText(pedido.getCodigo());
			txCodigo.setBounds(341, 161, 191, 45);
			txCodigo.setColumns(10);
		}
		return txCodigo;
	}

	private JTabbedPane getPanelPedido() {
		if (panelPedido == null) {
			panelPedido = new JTabbedPane(JTabbedPane.TOP);
			panelPedido.addTab("Comida", null, getScrollComida(), null);
			panelPedido.setMnemonicAt(0, 0);
			panelPedido.addTab("Bebida", null, getScrollBebida(), null);
			panelPedido.setMnemonicAt(1, 0);
		}
		return panelPedido;
	}

	private JScrollPane getScrollComida() {
		if (scrollComida == null) {
			scrollComida = new JScrollPane();
			scrollComida.setViewportView(getListComida());
		}
		return scrollComida;
	}

	private JScrollPane getScrollBebida() {
		if (scrollBebida == null) {
			scrollBebida = new JScrollPane();
			scrollBebida.setViewportView(getListBebida());
		}
		return scrollBebida;
	}

	private JList<Articulo> getListComida() {
		if (listComida == null) {
			modeloListComida = new DefaultListModel<Articulo>();
			listComida = new JList<Articulo>(modeloListComida);
		}
		return listComida;
	}

	private JList<Articulo> getListBebida() {
		if (listBebida == null) {
			modeloListBebida = new DefaultListModel<Articulo>();
			listBebida = new JList<Articulo>(modeloListBebida);
		}
		return listBebida;
	}

	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setText("\"Precio: 0.0\"");
			txPrecio.setBackground(Color.ORANGE);
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}

	private JButton getBtAnular1() {
		if (btAnular1 == null) {
			btAnular1 = new JButton("Anular");
			btAnular1.setBackground(new Color(165, 42, 42));
		}
		return btAnular1;
	}

	private JButton getBtSig1() {
		if (btSig1 == null) {
			btSig1 = new JButton("Siguiente");
			btSig1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPn2();
				}
			});
			btSig1.setBackground(new Color(34, 139, 34));
		}
		return btSig1;
	}

	private JButton getBtAnt2() {
		if (btAnt2 == null) {
			btAnt2 = new JButton("Anterior");
		}
		return btAnt2;
	}

	private JButton getBtSig2() {
		if (btSig2 == null) {
			btSig2 = new JButton("Siguiente");
			btSig2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPn3();
				}
			});
		}
		return btSig2;
	}

	private JButton getBtAnt3() {
		if (btAnt3 == null) {
			btAnt3 = new JButton("Anterior");
		}
		return btAnt3;
	}

	private JButton getBtSig3() {
		if (btSig3 == null) {
			btSig3 = new JButton("Siguiente");
			btSig3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();
				}
			});
		}
		return btSig3;
	}

	private JPanel getPanelFiltros() {
		if (panelFiltros == null) {
			panelFiltros = new JPanel();
			panelFiltros.setLayout(new GridLayout(5, 1, 0, 0));
			panelFiltros.add(getBtHamburguesas());
			panelFiltros.add(getBtBebidas());
			panelFiltros.add(getBtComplementos());
			panelFiltros.add(getBtPostres());
			panelFiltros.add(getBtTodo());
		}
		return panelFiltros;
	}

	private JButton getBtTodo() {
		if (btTodo == null) {
			btTodo = new JButton("Todo");
			btTodo.setHorizontalTextPosition(SwingConstants.CENTER);
			btTodo.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		return btTodo;
	}

	private JButton getBtHamburguesas() {
		if (btHamburguesas == null) {
			btHamburguesas = new JButton("Hamburguesas");
			btHamburguesas.setHorizontalTextPosition(SwingConstants.CENTER);
			btHamburguesas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btHamburguesas.setIcon(new ImageIcon("bin/img/img filtros/Hamburguesa.png"));
			btHamburguesas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deshabilitaBotonesTablero("Hamburguesa");
				}

			});

		}
		return btHamburguesas;
	}

	private void deshabilitaBotonesTablero(String string) {
		if (string != "Todo") {
			for (int i = 0; i < pnArticulos.getComponents().length; i++) {
				Articulo a = carta.getArticulos()[i];
				if (a.getTipo().equals(string)) {
					pnArticulos.getComponent(i).setEnabled(true);
				}
				pnArticulos.getComponent(i).setEnabled(false);
			}
		}
		

	}

	private JButton getBtBebidas() {
		if (btBebidas == null) {
			btBebidas = new JButton("Bebidas");
			btBebidas.setHorizontalTextPosition(SwingConstants.CENTER);
			btBebidas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btBebidas.setIcon(new ImageIcon("bin/img/img filtros/Bebida.png"));
		}
		return btBebidas;
	}

	private JButton getBtComplementos() {
		if (btComplementos == null) {
			btComplementos = new JButton("Complementos");
			btComplementos.setHorizontalTextPosition(SwingConstants.CENTER);
			btComplementos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btComplementos.setIcon(new ImageIcon("bin/img/img filtros/Complemento.png"));
		}
		return btComplementos;
	}

	private JButton getBtPostres() {
		if (btPostres == null) {
			btPostres = new JButton("Postres");
			btPostres.setHorizontalTextPosition(SwingConstants.CENTER);
			btPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
			btPostres.setIcon(new ImageIcon("bin/img/img filtros/Postre.png"));
		}
		return btPostres;
	}
}
