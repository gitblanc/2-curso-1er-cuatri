package igu;

import io.FileManagement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Cliente;
import logica.Libro;
import logica.LibroCompra;
import logica.Pedido;

import javax.help.*;

import java.net.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextArea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.KeyStroke;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Cliente cliente;
	private JDialog parent;
	private JPanel pnNorte;
	private JLabel lblLogo;
	private JPanel panelSaludos;
	private JMenuBar menuBar;
	private JLabel lblMensaje;
	private JPanel pnCentro;
	private JPanel pnIzquierda;
	private JScrollPane scrLista;
	private JList<Libro> listLibros;
	private JPanel pnFiltros;
	private JCheckBox checkBoxMenos;
	private JCheckBox chckbxEntreY;
	private JCheckBox chckbxMas;
	private JPanel pnSur;
	private JPanel pnPedido;
	private JScrollPane scrPedido;
	private JList<LibroCompra> listPedido;
	private JPanel pnSouthCenter;
	private JPanel pnPrecio;
	private JLabel lbPrecio;
	private JTextField txPrecio;
	private DefaultListModel<Libro> modeloLib;
	private FileManagement fileM;
	private ArrayList<Libro> libros;
	private JPanel pnMedio;
	private JPanel pnButtonComprar;
	private JButton btnComprar;
	private JPanel pnAdding;
	private JButton btnAdd;
	private JPanel pnDescripcion;
	private JTextArea txInfo;
	private JButton btnDelete;
	private DefaultListModel<LibroCompra> modeloPedido;
	private JLabel lblCantidad;
	private JSpinner spnCantidad;
	private Pedido pedido;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem mntmContents;
	private JSeparator separator;
	private JMenuItem mntmAbout;
	private JCheckBoxMenuItem chckbxmntmTooltips;
	private JMenuItem mntmAdd;
	private JMenuItem mntmDelete;
	private JSeparator separator_1;
	private JMenuItem mntmReset;
	private JMenuItem mntmExit;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JButton btnLogout;

	/**
	 * Create the frame.
	 * 
	 * @param cliente
	 * @param actionListener
	 */
	public VentanaPrincipal(JDialog parent, Cliente cliente) {
		setTitle("Libreria EII Oviedo");
		fileM = new FileManagement();
		libros = fileM.getLibros();
		pedido = new Pedido();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		this.parent = parent;
		this.cliente = cliente;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(parent);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnSur(), BorderLayout.SOUTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		saludar();
		cargaAyuda();
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnNorte.add(getLblLogo());
			pnNorte.add(getPanelSaludos());
		}
		return pnNorte;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setToolTipText("Libreria EII Oviedo");
			lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		}
		return lblLogo;
	}

	private JPanel getPanelSaludos() {
		if (panelSaludos == null) {
			panelSaludos = new JPanel();
			panelSaludos.setLayout(new GridLayout(2, 1, 0, 0));
			panelSaludos.add(getLblMensaje());
		}
		return panelSaludos;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JLabel getLblMensaje() {
		if (lblMensaje == null) {
			lblMensaje = new JLabel("");
			lblMensaje.setFont(new Font("Tahoma", Font.ITALIC, 25));
			lblMensaje.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblMensaje;
	}
	
	private void saludar(){
		getLblMensaje().setText("    Saludos " + cliente.getName() + " " + cliente.getSurname());
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new GridLayout(0, 3, 0, 0));
			pnCentro.add(getPnIzquierda());
			pnCentro.add(getPnMedio());
			pnCentro.add(getPnPedido());
		}
		return pnCentro;
	}

	private JPanel getPnIzquierda() {
		if (pnIzquierda == null) {
			pnIzquierda = new JPanel();
			pnIzquierda.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			pnIzquierda.setLayout(new GridLayout(0, 1, 0, 0));
			pnIzquierda.add(getScrLista());
		}
		return pnIzquierda;
	}

	private JScrollPane getScrLista() {
		if (scrLista == null) {
			scrLista = new JScrollPane();
			scrLista.setBorder(null);
			scrLista.setViewportView(getListLibros());
			scrLista.setColumnHeaderView(getPnFiltros());
		}
		return scrLista;
	}

	private JList<Libro> getListLibros() {
		if (listLibros == null) {
			listLibros = new JList<Libro>();
			listLibros.setToolTipText("Ejemplares disponibles");
			listLibros.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (listLibros.getSelectedValue() != null)
						escribirInfo(listLibros.getSelectedValue());
				}
			});
			listLibros.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					{
						if (listLibros.getSelectedValue() != null)
							escribirInfo(listLibros.getSelectedValue());
					}
				}
			});
			listLibros.setBorder(new LineBorder(new Color(0, 0, 0)));
			listLibros.setValueIsAdjusting(true);
			rellenarListaLibros();

		}
		return listLibros;
	}

	private void rellenarListaLibros() {
		modeloLib = new DefaultListModel<Libro>();
		for (Libro l : libros) {
			modeloLib.addElement(l);
		}
		listLibros.setModel(modeloLib);
		
	}

	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnFiltros.add(getCheckBoxMenos());
			pnFiltros.add(getChckbxEntreY());
			pnFiltros.add(getChckbxMas());
		}
		return pnFiltros;
	}

	private JCheckBox getCheckBoxMenos() {
		if (checkBoxMenos == null) {
			checkBoxMenos = new JCheckBox("x < 15 \u20AC");
			checkBoxMenos.setSelected(true);
			checkBoxMenos.addActionListener(new FiltraLibros(getListLibros(), modeloLib, getCheckBoxMenos(),
					getChckbxMas(), getChckbxEntreY(), libros));
		}
		return checkBoxMenos;
	}

	private JCheckBox getChckbxEntreY() {
		if (chckbxEntreY == null) {
			chckbxEntreY = new JCheckBox("15\u20AC < x < 40\u20AC");
			chckbxEntreY.setSelected(true);
			chckbxEntreY.addActionListener(new FiltraLibros(getListLibros(), modeloLib, getCheckBoxMenos(),
					getChckbxMas(), getChckbxEntreY(), libros));
		}
		return chckbxEntreY;
	}

	private JCheckBox getChckbxMas() {
		if (chckbxMas == null) {
			chckbxMas = new JCheckBox("x >  40\u20AC");
			chckbxMas.setSelected(true);
			chckbxMas.addActionListener(new FiltraLibros(getListLibros(), modeloLib, getCheckBoxMenos(),
					getChckbxMas(), getChckbxEntreY(), libros));
		}
		return chckbxMas;
	}

	private JPanel getPnSur() {
		if (pnSur == null) {
			pnSur = new JPanel();
			pnSur.setLayout(new BorderLayout(0, 0));
			pnSur.add(getPnSouthCenter(), BorderLayout.SOUTH);
			pnSur.add(getPnPrecio(), BorderLayout.NORTH);
		}
		return pnSur;
	}

	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			pnPedido.setLayout(new BorderLayout(0, 0));
			pnPedido.add(getScrPedido());
		}
		return pnPedido;
	}

	private JScrollPane getScrPedido() {
		if (scrPedido == null) {
			scrPedido = new JScrollPane();
			scrPedido.setViewportView(getListPedido());
		}
		return scrPedido;
	}

	private JList<LibroCompra> getListPedido() {
		if (listPedido == null) {
			listPedido = new JList<LibroCompra>();
			listPedido.setToolTipText("Lista de libros a comprar");
			modeloPedido = new DefaultListModel<LibroCompra>();
			listPedido.setModel(modeloPedido);

			listPedido.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return listPedido;
	}

	private JPanel getPnSouthCenter() {
		if (pnSouthCenter == null) {
			pnSouthCenter = new JPanel();
			pnSouthCenter.setLayout(new BorderLayout(0, 0));
			pnSouthCenter.add(getPnButtonComprar(), BorderLayout.EAST);
		}
		return pnSouthCenter;
	}

	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			pnPrecio.add(getLbPrecio());
			pnPrecio.add(getTxPrecio());
		}
		return pnPrecio;
	}

	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio final:");
		}
		return lbPrecio;
	}

	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setEditable(false);
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}

	private JPanel getPnMedio() {
		if (pnMedio == null) {
			pnMedio = new JPanel();
			pnMedio.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			pnMedio.setLayout(new BorderLayout(0, 0));
			pnMedio.add(getPnDescripcion(), BorderLayout.CENTER);
		}
		return pnMedio;
	}

	private JPanel getPnButtonComprar() {
		if (pnButtonComprar == null) {
			pnButtonComprar = new JPanel();
			pnButtonComprar.add(getBtnComprar());
			pnButtonComprar.add(getBtnLogout());
		}
		return pnButtonComprar;
	}

	private JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("Comprar");
			btnComprar.setToolTipText("Clic para finalizar la compra");
			btnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Su compra ha sido procesada");
					resett();
					}
				}
			);
		}
		return btnComprar;
	}

	private JPanel getPnAdding() {
		if (pnAdding == null) {
			pnAdding = new JPanel();
			pnAdding.add(getLblCantidad());
			pnAdding.add(getSpnCantidad());
			pnAdding.add(getButton_1());
			pnAdding.add(getBtnDelete());
		}
		return pnAdding;
	}

	private JButton getButton_1() {
		if (btnAdd == null) {
			btnAdd = new JButton("A\u00F1adir");
			btnAdd.setToolTipText("Para a\u00F1adir el n\u00FAmero seleccionado de libros a la lista de la derecha");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addToPedido();
				}
			});
		}
		return btnAdd;
	}

	private void addToPedido() {
		if (getListLibros().getSelectedValue() != null) {

			int pos = iterarLibros(getListLibros().getSelectedValue().getCodigo());
			if (pos < 0) {
				pedido.getPedido()
						.add(new LibroCompra(getListLibros().getSelectedValue(), (int) getSpnCantidad().getValue()));
				initModeloPedido();
			} else {
				pedido.getPedido().get(pos).suma((int) getSpnCantidad().getValue());
				initModeloPedido();

			}
			calcularPrecio();
		}
	}


	private void initModeloPedido() {
		modeloPedido.clear();
		for (LibroCompra l : pedido.getPedido()) {
			modeloPedido.addElement(l);
		}
	}

	private JPanel getPnDescripcion() {
		if (pnDescripcion == null) {
			pnDescripcion = new JPanel();
			pnDescripcion.setLayout(new BorderLayout(0, 0));
			pnDescripcion.add(getPnAdding(), BorderLayout.NORTH);
			pnDescripcion.add(getTxInfo(), BorderLayout.CENTER);
		}
		return pnDescripcion;
	}

	private JTextArea getTxInfo() {
		if (txInfo == null) {
			txInfo = new JTextArea();
			txInfo.setToolTipText("Resumen del libro");
			txInfo.setEditable(false);
			txInfo.setWrapStyleWord(true);
			txInfo.setLineWrap(true);
		}
		return txInfo;
	}

	private int iterarLibros(String code) {
		int pos = -1;
		for (int i = 0; i < pedido.getPedido().size(); i++) {
			if (pedido.getPedido().get(i).getLibro().getCodigo().equals(code)) {
				pos = i;
			}
		}
		return pos;
	}

	
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Borrar");
			btnDelete.setToolTipText("Para eliminar los libros de la lista de la derecha");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					deleteFromPedido();
				}
			});
		}
		return btnDelete;
	}

	private void deleteFromPedido() {
		if (getListPedido().getSelectedValue() != null) {
			int pos = iterarLibros(getListPedido().getSelectedValue().getLibro().getCodigo());
			if ((int) getSpnCantidad().getValue() < pedido.getPedido().get(pos).getCantidad()) {
				pedido.getPedido().get(pos).resta((int) getSpnCantidad().getValue());
				initModeloPedido();
			} else if ((int) getSpnCantidad().getValue() >= pedido.getPedido().get(pos).getCantidad()) {
				pedido.getPedido().remove(pos);
				initModeloPedido();
			}
			calcularPrecio();
		}
	}

	private void escribirInfo(Libro libro) {
		getTxInfo().setText("PRECIO: " + libro.getPrecio() + " AUTOR: " + libro.getAutor() + " EDITOR: " + libro.getEditorial() +
				" TIPO: " + libro.getGenero() + " RESUMEN: "+ libro.getResumen()  );
	}


	private void calcularPrecio() {
		double precio = 0;
		for (int i = 0; i < pedido.getPedido().size(); i++) {
			precio += pedido.getPedido().get(i).getLibro().getPrecio() 
					* pedido.getPedido().get(i).getCantidad();
		}
		precio = Math.rint(precio * 1000) / 1000; //Así evita problemas a la hora de mostrar el precio
		getTxPrecio().setText(String.valueOf(precio));
	}

	private JLabel getLblCantidad() {
		if (lblCantidad == null) {
			lblCantidad = new JLabel("Ejemplares:");
			lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblCantidad;
	}

	private JSpinner getSpnCantidad() {
		if (spnCantidad == null) {
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return spnCantidad;
	}

	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setMnemonic('O');
			mnOptions.add(getmnAdd());
			mnOptions.add(getmnDel());
			mnOptions.add(getSeparator_3());
			mnOptions.add(getChckbxmntmTooltips());
			mnOptions.add(getSeparator_1());
			mnOptions.add(getMntmReset());
			mnOptions.add(getSeparator_2());
			mnOptions.add(getMntmExit());
		}
		return mnOptions;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.add(getMntmContents());
			mnHelp.add(getSeparator());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Help");
			mntmContents.setToolTipText("Mostrar ayuda");
			mntmContents.setMnemonic('E');
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContents;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setToolTipText("Contenidos sobre la aplicaci\u00F3n");
			mntmAbout.setMnemonic('A');
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Examen Julio CPM Pablo González Balbuena");
				}
			});
		}
		return mntmAbout;
	}

	private JCheckBoxMenuItem getChckbxmntmTooltips() {
		if (chckbxmntmTooltips == null) {
			chckbxmntmTooltips = new JCheckBoxMenuItem("ToolTips activas");
			chckbxmntmTooltips.setToolTipText("Si est\u00E1 activo las tooltips estar\u00E1n activas");
			chckbxmntmTooltips.setMnemonic('T');
			chckbxmntmTooltips.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(getChckbxmntmTooltips().isSelected()==false){
						getListLibros().setToolTipText(null);
						getListPedido().setToolTipText(null);
						getTxInfo().setToolTipText(null);
						getBtnDelete().setToolTipText(null);
						getBtnComprar().setToolTipText(null);
						getBtnLogout().setToolTipText(null);
						getButton_1().setToolTipText(null);
						getLblLogo().setToolTipText(null);
						getChckbxmntmTooltips().setToolTipText(null);
						getmnAdd().setToolTipText(null);
						getmnDel().setToolTipText(null);
						getMnHelp().setToolTipText(null);
						getMnOptions().setToolTipText(null);
						getMntmContents().setToolTipText(null);
						getMntmReset().setToolTipText(null);
						getMntmAbout().setToolTipText(null);
						getMntmExit().setToolTipText(null);
					}
				}
			});
			chckbxmntmTooltips.setSelected(true);
		}
		return chckbxmntmTooltips;
	}

	private JMenuItem getmnAdd() {
		if (mntmAdd == null) {
			mntmAdd = new JMenuItem("A\u00F1adir al pedido");
			mntmAdd.setToolTipText("Para a\u00F1adir al pedido");
			mntmAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
			mntmAdd.setMnemonic('A');
			mntmAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addToPedido();
				}
			});
		}
		return mntmAdd;
	}

	private JMenuItem getmnDel() {
		if (mntmDelete == null) {
			mntmDelete = new JMenuItem("Eliminar del pedido");
			mntmDelete.setToolTipText("Para eliminar del pedido");
			mntmDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
			mntmDelete.setMnemonic('E');
			mntmDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					deleteFromPedido();
				}
			});
		}
		return mntmDelete;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JMenuItem getMntmReset() {
		if (mntmReset == null) {
			mntmReset = new JMenuItem("Resetear todo");
			mntmReset.setToolTipText("Vuelve todo al estado inicial");
			mntmReset.setMnemonic('R');
			mntmReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
			mntmReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					resett();
				}
			});
		}
		return mntmReset;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Salir");
			mntmExit.setToolTipText("Salir de la aplicaci\u00F3n");
			mntmExit.setMnemonic('S');
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return mntmExit;
	}

	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
		}
		return separator_2;
	}

	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
		}
		return separator_3;
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("Logout");
			btnLogout.setToolTipText("Clic para desloguearse");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loggingOut();
				}
			});
		}
		return btnLogout;
	}
	
	private void loggingOut(){
		parent.setVisible(true);
		this.dispose();
	}
	
	private void resett(){
		getChckbxMas().setSelected(true);
		getChckbxEntreY().setSelected(true);
		getCheckBoxMenos().setSelected(true);
		modeloPedido.clear();
		pedido.getPedido().clear();

		rellenarListaLibros();
		getTxPrecio().setText(null);
		getSpnCantidad().setValue(1);
		getTxInfo().setText(null);
		
	}

	private void cargaAyuda(){

	   URL hsURL;
	   HelpSet hs;

	    try {
		    	File fichero = new File("help/ayuda.hs");
		    	hsURL = fichero.toURI().toURL();
		        hs = new HelpSet(null, hsURL);
		 }

	    catch(Exception e){
	      		System.out.println("Ayuda no encontrada");
	      		return;
	        }

	   HelpBroker hb = hs.createHelpBroker();

	   hb.enableHelpKey(getRootPane(),"init", hs);
	   hb.enableHelpOnButton(getMntmContents(), "init", hs);
	   
	 }
	
}
