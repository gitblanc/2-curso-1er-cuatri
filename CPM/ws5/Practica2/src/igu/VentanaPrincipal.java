package igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.border.EmptyBorder;

import logica.Articulo;
import logica.Carta;
import logica.Pedido;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMcDonalds;
	private JSpinner spinnerUnidades;
	private JTextField textPrecioTotal;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JLabel lblArticulos;
	private JLabel lblUnidades;
	private JButton btnAañadir;
	private JLabel lblPrecioPedido;
	private JComboBox<Articulo> comboBoxArticulos;
	private Carta carta;
	private Pedido pedido;
	private JLabel lblImagenDescuento;
	private JLabel lblDescuento;
	private JButton btnEliminar;
	private JScrollPane scrollPanePedido;
	private JTextArea textAreaPedido;
	private JButton btnPedido;
	private JLabel lblIconosComida;
	private JMenuBar menuBar;
	private JMenu mnPedido;
	private JMenu mnAyuda;
	private JMenuItem miNuevo;
	private JMenuItem miSalir;
	private JSeparator separator;
	private JMenuItem miContenidos;
	private JMenuItem miAcercaDe;
	private JSeparator separator_1;
	private JPanel panelFiltro;
	private JButton btnHamburguesas;
	private JButton btnBebidas;
	private JButton btnComplementos;
	private JButton btnPostres;

	/**
	 * Constructor que crea el frame
	 * 
	 * @param pedido
	 * @param carta
	 */
	public VentanaPrincipal(Carta carta, Pedido pedido) {
		this.carta = carta;
		this.pedido = pedido;
		setResizable(false);
		setTitle("McDonald's Espa\u00F1a");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 584);
		setLocationRelativeTo(null);// para centrar en la pantalla
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblMcDonalds());
		contentPane.add(getSpinnerUnidades());
		contentPane.add(getTextPrecioTotal());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		contentPane.add(getLblArticulos());
		contentPane.add(getLblUnidades());
		contentPane.add(getBtnAañadir());
		contentPane.add(getLblPrecioPedido());
		contentPane.add(getComboBoxArticulos());
		contentPane.add(getLblImagenDescuento());
		contentPane.add(getLblDescuento());
		contentPane.add(getBtnEliminar());
		contentPane.add(getScrollPanePedido());
		contentPane.add(getBtnPedido());
		contentPane.add(getLblIconosComida());
		contentPane.add(getPanelFiltro());
	}

	/*
	 * Getter para el JLabel del texto McDonald's
	 */
	private JLabel getLblMcDonalds() {
		if (lblMcDonalds == null) {
			lblMcDonalds = new JLabel("  McDonald's");
			lblMcDonalds.setHorizontalAlignment(SwingConstants.LEFT);
			lblMcDonalds.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lblMcDonalds.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lblMcDonalds.setBounds(243, 11, 468, 133);
		}
		return lblMcDonalds;
	}

	/*
	 * Getter para el JSpinner de las unidades
	 */
	private JSpinner getSpinnerUnidades() {
		if (spinnerUnidades == null) {
			spinnerUnidades = new JSpinner();
			spinnerUnidades.setModel(new SpinnerNumberModel(1, 1, null, 1));
			spinnerUnidades.setBounds(585, 300, 64, 31);
		}
		return spinnerUnidades;
	}

	/*
	 * Getter para el JTextField del precio total
	 */
	private JTextField getTextPrecioTotal() {
		if (textPrecioTotal == null) {
			textPrecioTotal = new JTextField();
			textPrecioTotal.setEditable(false);
			textPrecioTotal.setBounds(585, 383, 96, 33);
			textPrecioTotal.setColumns(10);
		}
		return textPrecioTotal;
	}

	/*
	 * Getter para el JButton siguiente con la acci�n de pasar a la ventana de
	 * registro
	 */
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setMnemonic('S');
			btnSiguiente.setBackground(new Color(0, 128, 0));
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaRegistro();
				}
			});
			btnSiguiente.setEnabled(false);
			btnSiguiente.setBounds(693, 467, 116, 41);
		}
		return btnSiguiente;
	}

	/*
	 * M�todo que aplica el descuento
	 */
	private void descuento() {
		if (pedido.getDescuentoAplicado()) {
			float total = pedido.getTotal();
			lblDescuento.setText("Se te ha aplicado un descuento del 10%");
			textPrecioTotal.setText(String.format("%.2f", total));
		} else {
			lblDescuento.setText("");
		}
	}

	/*
	 * M�todo que muestra la ventana registro sin cerrar la ventana principal
	 */
	protected void mostrarVentanaRegistro() {
		VentanaRegistro vr = new VentanaRegistro(this);
		vr.setLocationRelativeTo(this);
		vr.setModal(true);
		vr.setVisible(true);

	}

	/*
	 * Getter para el JButton cancelar con la acci�n de cerrar la aplicaci�n
	 */
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setBackground(new Color(165, 42, 42));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			btnCancelar.setBounds(819, 467, 116, 41);
		}
		return btnCancelar;
	}

	/*
	 * Getter para el JLabel art�culos
	 */
	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Art\u00EDculos:");
			lblArticulos.setLabelFor(getComboBoxArticulos());
			lblArticulos.setDisplayedMnemonic('r');
			lblArticulos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblArticulos.setBounds(243, 155, 74, 28);
		}
		return lblArticulos;
	}

	/*
	 * Getter para el JLabel unidades
	 */
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setLabelFor(getSpinnerUnidades());
			lblUnidades.setDisplayedMnemonic('u');
			lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUnidades.setBounds(585, 262, 74, 20);
		}
		return lblUnidades;
	}

	/*
	 * Getter para el JButton aañadir con las acciones de aañadir pedido, mostrar las
	 * unidades del art�culo y aplicar el descuento
	 */
	private JButton getBtnAañadir() {
		if (btnAañadir == null) {
			btnAañadir = new JButton("A\u00F1adir");
			btnAañadir.setMnemonic('A');
			btnAañadir.setBackground(new Color(0, 128, 0));
			btnAañadir.setForeground(Color.WHITE);
			btnAañadir.setBounds(693, 295, 116, 41);
			btnAañadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aañadirAPedido();
					descuento();
					if (getUnidadesPedido((Articulo) comboBoxArticulos.getSelectedItem()) > 0) {
						getBtnEliminar().setEnabled(true);
					}
				}
			});
		}
		return btnAañadir;
	}

	/*
	 * Getter para el JButton eliminar con las acciones de eliminar del pedido
	 */
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarDePedido();
					descuento();
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.setMnemonic('E');
			btnEliminar.setBackground(new Color(165, 42, 42));
			btnEliminar.setForeground(Color.WHITE);
			btnEliminar.setBounds(819, 295, 116, 41);
		}
		return btnEliminar;
	}

	protected void eliminarDePedido() {
		Articulo articuloSeleccionado = (Articulo) getComboBoxArticulos().getSelectedItem();
		int unidadesAEliminar = (int) getSpinnerUnidades().getValue();
		pedido.remove(articuloSeleccionado, unidadesAEliminar);
		String precio = String.format("%.2f", pedido.getTotal());
		getTextPrecioTotal().setText(precio + "\u20AC");
		if (pedido.getTotal() == 0) {
			getBtnSiguiente().setEnabled(false);
			getBtnEliminar().setEnabled(false);
		} else if (getUnidadesPedido((Articulo) comboBoxArticulos.getSelectedItem()) == 0) {
			getBtnEliminar().setEnabled(false);
		}

	}

	/*
	 * M�todo que a�ade un pedido
	 */
	private void aañadirAPedido() {
		Articulo articuloSeleccionado = (Articulo) getComboBoxArticulos().getSelectedItem();
		int unidadesSolicitadas = (Integer) getSpinnerUnidades().getValue();
		pedido.add(articuloSeleccionado, unidadesSolicitadas);
		String precio = String.format("%.2f", pedido.getTotal());
		getTextPrecioTotal().setText(precio + " \u20AC");
		if (!getBtnSiguiente().isEnabled()) {
			getBtnSiguiente().setEnabled(true);
			getBtnEliminar().setEnabled(true);
		}
	}

	/*
	 * Getter para el JLabel precio del pedido
	 */
	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido:");
			lblPrecioPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrecioPedido.setBounds(584, 342, 127, 20);
		}
		return lblPrecioPedido;
	}

	/*
	 * Getter para el JComboBox de art�culos
	 */
	private JComboBox<Articulo> getComboBoxArticulos() {
		if (comboBoxArticulos == null) {
			comboBoxArticulos = new JComboBox<Articulo>();
			comboBoxArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getSpinnerUnidades().setValue(1);
					getSpinnerUnidades().setValue(1);
					Articulo art = (Articulo) comboBoxArticulos.getSelectedItem();
					if (getUnidadesPedido(art) == 0) {
						getBtnEliminar().setEnabled(false);
					} else {
						getBtnEliminar().setEnabled(true);
					}

					mostrarImagenProducto(art.getCodigo());
				}
			});
			comboBoxArticulos.setModel(new DefaultComboBoxModel<Articulo>(carta.getArticulos()));
			comboBoxArticulos.setBounds(243, 194, 316, 32);
		}
		return comboBoxArticulos;
	}

	private void mostrarImagenProducto(String codigo) {
		lblIconosComida
				.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/img productos/" + codigo + ".png")));
	}

	/*
	 * Getter del pedido
	 */
	public Pedido getPedido() {
		return this.pedido;
	}

	/*
	 * M�todo que devuelve el n�mero de unidades de un art�culo
	 */
	private int getUnidadesPedido(Articulo articulo) {
		return pedido.buscarUnidadesArticulo(articulo);
	}

	/*
	 * Getter para el JLabel imagen del descuento
	 */
	private JLabel getLblImagenDescuento() {
		if (lblImagenDescuento == null) {
			lblImagenDescuento = new JLabel("");
			lblImagenDescuento.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ofertaHappy.png")));
			lblImagenDescuento.setBounds(243, 367, 216, 153);
		}
		return lblImagenDescuento;
	}

	/*
	 * Getter para el JLabel del descuento
	 */
	private JLabel getLblDescuento() {
		if (lblDescuento == null) {
			lblDescuento = new JLabel();
			lblDescuento.setForeground(Color.RED);
			lblDescuento.setFont(new Font("Arial", Font.BOLD, 14));
			lblDescuento.setBounds(585, 427, 300, 41);
		}
		return lblDescuento;
	}

	/*
	 * M�todo que limpia la ventana principal
	 */
	public void inicializar() {
		pedido.inicializar();
		getComboBoxArticulos().setSelectedIndex(0);
		getSpinnerUnidades().setValue(1);
		getLblPrecioPedido().setText("Precio pedido:");
		getLblDescuento().setText("");
		getTextPrecioTotal().setText("");
		getLblUnidades().setText("");
		getBtnSiguiente().setEnabled(false);
	}

	private JScrollPane getScrollPanePedido() {
		if (scrollPanePedido == null) {
			scrollPanePedido = new JScrollPane();
			scrollPanePedido.setVisible(false);
			scrollPanePedido.setBounds(721, 78, 220, 162);
			scrollPanePedido.setViewportView(getTextAreaPedido());
		}
		return scrollPanePedido;
	}

	private JTextArea getTextAreaPedido() {
		if (textAreaPedido == null) {
			textAreaPedido = new JTextArea();
			textAreaPedido.setEditable(false);
			textAreaPedido.setWrapStyleWord(true);
			textAreaPedido.setLineWrap(true);
		}
		return textAreaPedido;
	}

	private JButton getBtnPedido() {
		if (btnPedido == null) {
			btnPedido = new JButton("");
			btnPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					scrollPanePedido.setVisible(true);
					clearTextArea();
					aañadirPedidoATextArea();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					scrollPanePedido.setVisible(false);
					clearTextArea();
				}
			});
			btnPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			btnPedido.setBounds(808, 26, 133, 41);
		}
		return btnPedido;
	}

	protected void clearTextArea() {
		textAreaPedido.setText("");

	}

	protected void aañadirPedidoATextArea() {
		textAreaPedido.append(pedido.toString());

	}

	private JLabel getLblIconosComida() {
		if (lblIconosComida == null) {
			lblIconosComida = new JLabel("");
			lblIconosComida.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/img productos/HA01.png")));
			lblIconosComida.setBounds(243, 237, 192, 144);
		}
		return lblIconosComida;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnPedido());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}

	private JMenu getMnPedido() {
		if (mnPedido == null) {
			mnPedido = new JMenu("Pedido");
			mnPedido.setMnemonic('P');
			mnPedido.add(getMiNuevo());
			mnPedido.add(getSeparator());
			mnPedido.add(getMiSalir());
		}
		return mnPedido;
	}

	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('Y');
			mnAyuda.add(getMiContenidos());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMiAcercaDe());
		}
		return mnAyuda;
	}

	private JMenuItem getMiNuevo() {
		if (miNuevo == null) {
			miNuevo = new JMenuItem("Nuevo");
			miNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			miNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			miNuevo.setMnemonic('N');
		}
		return miNuevo;
	}

	private JMenuItem getMiSalir() {
		if (miSalir == null) {
			miSalir = new JMenuItem("Salir");
			miSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			miSalir.setMnemonic('S');
		}
		return miSalir;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.RED);
		}
		return separator;
	}

	private JMenuItem getMiContenidos() {
		if (miContenidos == null) {
			miContenidos = new JMenuItem("Contenidos");
			miContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			miContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Ayuda no disponible", "Contenidos de la ayuda",
							JOptionPane.WARNING_MESSAGE);
				}
			});
		}
		return miContenidos;
	}

	private JMenuItem getMiAcercaDe() {
		if (miAcercaDe == null) {
			miAcercaDe = new JMenuItem("Acerca de");
			miAcercaDe.setMnemonic('r');
			miAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane
							.showMessageDialog(null,
									"Aplicaci�n para TPV de comida r�pida \nRealizada por Eduardo Blanco Bielsa\n"
											+ "Pr�cticas CPM 21-22 \nEII Oviedo",
									"Acerca de", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return miAcercaDe;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JPanel getPanelFiltro() {
		if (panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.setBounds(0, 0, 171, 522);
			panelFiltro.setLayout(new GridLayout(4, 1, 0, 0));
			panelFiltro.add(getBtnHamburguesas());
			panelFiltro.add(getBtnBebidas());
			panelFiltro.add(getBtnComplementos());
			panelFiltro.add(getBtnPostres());
		}
		return panelFiltro;
	}

	private JButton getBtnHamburguesas() {
		if (btnHamburguesas == null) {
			btnHamburguesas = new JButton("Hamburguesas");
			btnHamburguesas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTipoEnCombobox("Hamburguesa");
				}
			});
			btnHamburguesas.setMnemonic('H');
			btnHamburguesas
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/img filtros/Hamburguesa.png")));
			btnHamburguesas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnHamburguesas.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnHamburguesas;
	}

	protected void mostrarTipoEnCombobox(String tipo) {
		Articulo[] articulos = carta.getArticulosMismoTipo(tipo);
		comboBoxArticulos.setModel(new DefaultComboBoxModel<Articulo>(articulos));
		mostrarImagenProducto(articulos[0].getCodigo());

	}

	private JButton getBtnBebidas() {
		if (btnBebidas == null) {
			btnBebidas = new JButton("Bebidas");
			btnBebidas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTipoEnCombobox("Bebida");
				}
			});
			btnBebidas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/img filtros/Bebida.png")));
			btnBebidas.setMnemonic('B');
			btnBebidas.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBebidas.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnBebidas;
	}

	private JButton getBtnComplementos() {
		if (btnComplementos == null) {
			btnComplementos = new JButton("Complementos");
			btnComplementos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTipoEnCombobox("Complemento");
				}
			});
			btnComplementos.setMnemonic('m');
			btnComplementos
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/img filtros/Complemento.png")));
			btnComplementos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnComplementos.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnComplementos;
	}

	private JButton getBtnPostres() {
		if (btnPostres == null) {
			btnPostres = new JButton("Postre");
			btnPostres.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarTipoEnCombobox("Postre");
				}
			});
			btnPostres.setMnemonic('T');
			btnPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/img filtros/Postre.png")));
			btnPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnPostres.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnPostres;
	}
}