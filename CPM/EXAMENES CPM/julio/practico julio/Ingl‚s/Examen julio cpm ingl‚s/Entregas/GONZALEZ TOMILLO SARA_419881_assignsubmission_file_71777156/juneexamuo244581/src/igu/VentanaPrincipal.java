package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.*;

import javax.help.*;
import java.net.*;

import java.io.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaPrincipal extends JFrame {

	private ArrayList<Libro> libros;
	private ArrayList<Cliente> clientes;
	private Cliente cliente;
	private ArrayList<Compra> pedido = new ArrayList<Compra>();
	
	private DefaultListModel modeloListaLibros;
	private DefaultListModel modeloListaPedido;
	private FiltraLibros filtraLibros = new FiltraLibros();
	private ShowInfo showInfo = new ShowInfo();
	
	private JPanel contentPane;
	private JLabel lblCliente;
	private JPanel pnSur;
	private JScrollPane sPTextArea;
	private JTextArea textArea;
	private JPanel pnBotones;
	private JButton btnCancel;
	private JButton btnCheckout;
	private JMenuBar menuBar;
	private JMenu mnLibreria;
	private JMenuItem mntmCancel;
	private JSeparator separator;
	private JMenuItem mntmExit;
	private JMenu mnOptions;
	private JMenu mnFilters;
	private JCheckBoxMenuItem checkBoxMenuItem15;
	private JCheckBoxMenuItem checkBoxMenuItem1540;
	private JCheckBoxMenuItem checkBoxMenuItem40;
	private JSeparator separator_1;
	private JCheckBoxMenuItem chckbxmntmShowAll;
	private JCheckBoxMenuItem chckbxmntmTooltips;
	private JSeparator separator_2;
	private JMenu mnHelp;
	private JMenuItem mntmHelp;
	private JMenuItem mntmAbout;
	private JSeparator separator_3;
	private JSplitPane splitPane;
	private JPanel pnIzq;
	private JPanel pnDcha;
	private JPanel pnFiltros;
	private JCheckBox checkBox15;
	private JCheckBox checkBox1540;
	private JCheckBox checkBox40;
	private JScrollPane scrollPane;
	private JList listaLibros;
	private JPanel pnAdd;
	private JLabel lblUnits;
	private JSpinner spinner;
	private JButton btnAdd;
	private JLabel lblOrder;
	private JScrollPane scrollPane_1;
	private JList listaPedido;
	private JPanel pnTotal;
	private JLabel lblTotal;
	private JTextField textField;
	private JMenuItem mntmLogOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setLocationRelativeTo(null);
					//frame.setVisible(true);
					DialogoLogIn dialogo = new DialogoLogIn(frame);
					dialogo.setLocationRelativeTo(null);
					dialogo.setModal(true);
					dialogo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		setTitle("Libreria EII Oviedo");
		leerFicheroLibros();
		leerFicheroClientes();
		cargaAyuda();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 547);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLblCliente(), BorderLayout.NORTH);
		contentPane.add(getPnSur(), BorderLayout.SOUTH);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}
	
	// AUXILIAR METHODS ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	void leerFicheroLibros() {
	    String nombreFichero = "files/libros.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      libros = new ArrayList<Libro>();
	      
	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        
	        Libro libro = new Libro(Long.parseLong(trozos[0]), trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], Double.parseDouble(trozos[6]));
	        libros.add(libro);
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	 }
	
	void leerFicheroClientes() {
	    String nombreFichero = "files/clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      clientes = new ArrayList<Cliente>();
	      
	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        
	        Cliente cliente = new Cliente(trozos[0], trozos[1], trozos[2], trozos[3]);
	        clientes.add(cliente);
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	 }
	
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
	public void setCliente(Cliente c){
		this.cliente = c;
		lblCliente.setText("Welcome to the book store, " + cliente.getNombre());
	}

	public void grabarFicheroPedido() {
	    String nombreFichero = "files/" + cliente.getDNI() + ".dat";
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		
		for(Compra compra : pedido){
			linea = compra.getISBN() + ":" + compra.getTitulo() + ":" + compra.getUnits();
			fichero.write(linea);
			fichero.newLine(); //Si se quiere añadir un salto de línea
		}
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }
	
	public void reset(){
		chckbxmntmShowAll.setSelected(true);
		chckbxmntmTooltips.setSelected(true);
		checkBox15.setSelected(true);
		checkBox1540.setSelected(true);
		checkBox40.setSelected(true);
		textArea.setText("");
		btnAdd.setEnabled(false);
		listaLibros.setSelectedIndex(-1);
		modeloListaLibros.clear();
		for(Libro l : libros)
			modeloListaLibros.addElement(l);
		spinner.setValue(1);
		pedido = new ArrayList<Compra>();
		modeloListaPedido.clear();
		btnCheckout.setEnabled(false);
		textField.setText("0.0€");
		
	}
	
	public void logOut(){
		reset();
		this.cliente = null;
		DialogoLogIn dialogo = new DialogoLogIn(this);
		this.setVisible(false);
		dialogo.setLocationRelativeTo(null);
		dialogo.setModal(true);
		dialogo.setVisible(true);
		
	}
	
	void cargaAyuda(){

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
		   hb.enableHelpOnButton(getMntmHelp(), "init", hs);
		   
		 }

	
	// AUXILIAR CLASSES ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	class FiltraLibros implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			modeloListaLibros.clear();
			
			boolean cheap = checkBox15.isSelected();
			boolean normal = checkBox1540.isSelected();
			boolean expensive = checkBox40.isSelected();
			
			for(Libro l : libros){
				if(cheap && l.getPrice() < 15)
					modeloListaLibros.addElement(l);
				if(normal && l.getPrice() >= 15 && l.getPrice() <= 40)
					modeloListaLibros.addElement(l);
				if(expensive && l.getPrice() > 40)
					modeloListaLibros.addElement(l);
			}
			
		}
		
	}
	
	class ShowInfo extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e){
			int selected = listaLibros.getSelectedIndex();
			
			if(selected != -1){
				textArea.setText(((Libro) modeloListaLibros.get(selected)).showInfo());
				btnAdd.setEnabled(true);
				spinner.setValue(1);
			}
		}
	}
	
	// SWING ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private JLabel getLblCliente() {
		if (lblCliente == null) {
			lblCliente = new JLabel("");
			lblCliente.setHorizontalAlignment(SwingConstants.TRAILING);
			if(cliente != null)
				lblCliente.setText("Welcome to the book store, " + cliente.getNombre());
		}
		return lblCliente;
	}
	private JPanel getPnSur() {
		if (pnSur == null) {
			pnSur = new JPanel();
			GridBagLayout gbl_pnSur = new GridBagLayout();
			gbl_pnSur.columnWidths = new int[]{550, 250, 0};
			gbl_pnSur.rowHeights = new int[]{96, 0};
			gbl_pnSur.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_pnSur.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pnSur.setLayout(gbl_pnSur);
			GridBagConstraints gbc_sPTextArea = new GridBagConstraints();
			gbc_sPTextArea.fill = GridBagConstraints.BOTH;
			gbc_sPTextArea.insets = new Insets(0, 0, 0, 5);
			gbc_sPTextArea.gridx = 0;
			gbc_sPTextArea.gridy = 0;
			pnSur.add(getSPTextArea(), gbc_sPTextArea);
			GridBagConstraints gbc_pnBotones = new GridBagConstraints();
			gbc_pnBotones.fill = GridBagConstraints.BOTH;
			gbc_pnBotones.gridx = 1;
			gbc_pnBotones.gridy = 0;
			pnSur.add(getPnBotones(), gbc_pnBotones);
		}
		return pnSur;
	}
	private JScrollPane getSPTextArea() {
		if (sPTextArea == null) {
			sPTextArea = new JScrollPane();
			sPTextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sPTextArea.setViewportView(getTextArea());
		}
		return sPTextArea;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.setRows(5);
			textArea.setColumns(40);
			textArea.setEditable(false);
		}
		return textArea;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			GridBagLayout gbl_pnBotones = new GridBagLayout();
			gbl_pnBotones.columnWidths = new int[]{91, 65, 79, 0};
			gbl_pnBotones.rowHeights = new int[]{23, 0, 0};
			gbl_pnBotones.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnBotones.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnBotones.setLayout(gbl_pnBotones);
			GridBagConstraints gbc_btnCancel = new GridBagConstraints();
			gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
			gbc_btnCancel.gridx = 0;
			gbc_btnCancel.gridy = 1;
			pnBotones.add(getBtnCancel(), gbc_btnCancel);
			GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
			gbc_btnCheckout.insets = new Insets(0, 0, 0, 5);
			gbc_btnCheckout.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnCheckout.gridx = 1;
			gbc_btnCheckout.gridy = 1;
			pnBotones.add(getBtnCheckout(), gbc_btnCheckout);
		}
		return pnBotones;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reset();
				}
			});
			btnCancel.setToolTipText("Cancel the whole order");
		}
		return btnCancel;
	}
	private JButton getBtnCheckout() {
		if (btnCheckout == null) {
			btnCheckout = new JButton("CheckOut");
			btnCheckout.setEnabled(false);
			btnCheckout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					grabarFicheroPedido();
					logOut();
				}
			});
			btnCheckout.setToolTipText("Place order");
		}
		return btnCheckout;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnLibreria());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnLibreria() {
		if (mnLibreria == null) {
			mnLibreria = new JMenu("Libreria");
			mnLibreria.add(getMntmCancel());
			mnLibreria.add(getMntmLogOut());
			mnLibreria.add(getSeparator());
			mnLibreria.add(getMntmExit());
		}
		return mnLibreria;
	}
	private JMenuItem getMntmCancel() {
		if (mntmCancel == null) {
			mntmCancel = new JMenuItem("Cancel");
			mntmCancel.setMnemonic('c');
			mntmCancel.setMnemonic(KeyEvent.VK_C);
			mntmCancel.setToolTipText("Cancel the order");
			mntmCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reset();
				}
			});
		}
		return mntmCancel;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setMnemonic('X');
			mntmExit.setMnemonic(KeyEvent.VK_ESCAPE);
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmExit;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.add(getMnFilters());
			mnOptions.add(getSeparator_2());
			mnOptions.add(getChckbxmntmTooltips());
		}
		return mnOptions;
	}
	private JMenu getMnFilters() {
		if (mnFilters == null) {
			mnFilters = new JMenu("Filters");
			mnFilters.add(getCheckBoxMenuItem15());
			mnFilters.add(getCheckBoxMenuItem1540());
			mnFilters.add(getCheckBoxMenuItem40());
			mnFilters.add(getSeparator_1());
			mnFilters.add(getChckbxmntmShowAll());
		}
		return mnFilters;
	}
	private JCheckBoxMenuItem getCheckBoxMenuItem15() {
		if (checkBoxMenuItem15 == null) {
			checkBoxMenuItem15 = new JCheckBoxMenuItem("< 15\u20AC");
			checkBoxMenuItem15.setMnemonic(KeyEvent.VK_F1);
			checkBoxMenuItem15.setSelected(true);
			checkBoxMenuItem15.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					checkBox15.setSelected(checkBoxMenuItem15.isSelected());
				}
			});
			checkBoxMenuItem15.addActionListener(filtraLibros);
		}
		return checkBoxMenuItem15;
	}
	private JCheckBoxMenuItem getCheckBoxMenuItem1540() {
		if (checkBoxMenuItem1540 == null) {
			checkBoxMenuItem1540 = new JCheckBoxMenuItem("15\u20AC - 40\u20AC");
			checkBoxMenuItem1540.setMnemonic(KeyEvent.VK_F2);
			checkBoxMenuItem1540.setSelected(true);
			checkBoxMenuItem1540.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					checkBox1540.setSelected(checkBoxMenuItem1540.isSelected());
				}
			});
			checkBoxMenuItem1540.addActionListener(filtraLibros);
		}
		return checkBoxMenuItem1540;
	}
	private JCheckBoxMenuItem getCheckBoxMenuItem40() {
		if (checkBoxMenuItem40 == null) {
			checkBoxMenuItem40 = new JCheckBoxMenuItem("> 40\u20AC");
			checkBoxMenuItem40.setMnemonic(KeyEvent.VK_F3);
			checkBoxMenuItem40.setSelected(true);
			checkBoxMenuItem40.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					checkBox40.setSelected(checkBoxMenuItem40.isSelected());
				}
			});
			checkBoxMenuItem40.addActionListener(filtraLibros);
		}
		return checkBoxMenuItem40;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JCheckBoxMenuItem getChckbxmntmShowAll() {
		if (chckbxmntmShowAll == null) {
			chckbxmntmShowAll = new JCheckBoxMenuItem("Show All");
			chckbxmntmShowAll.setMnemonic(KeyEvent.VK_F4);
			chckbxmntmShowAll.setSelected(true);
			chckbxmntmShowAll.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					checkBoxMenuItem15.setSelected(chckbxmntmShowAll.isSelected());
					checkBoxMenuItem1540.setSelected(chckbxmntmShowAll.isSelected());
					checkBoxMenuItem40.setSelected(chckbxmntmShowAll.isSelected());
				}
			});
			chckbxmntmShowAll.addActionListener(filtraLibros);
		}
		return chckbxmntmShowAll;
	}
	private JCheckBoxMenuItem getChckbxmntmTooltips() {
		if (chckbxmntmTooltips == null) {
			chckbxmntmTooltips = new JCheckBoxMenuItem("ToolTips");
			chckbxmntmTooltips.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(chckbxmntmTooltips.isSelected()){
						checkBox15.setToolTipText("Show books with a price smaller than 15\u20AC");
						checkBox1540.setToolTipText("Show books between 15\u20AC and 40\u20AC");
						checkBox40.setToolTipText("Show books that cost more than 40\u20AC");
						spinner.setToolTipText("Select units of the book to order");
						btnCancel.setToolTipText("Cancel the whole order");
						btnAdd.setToolTipText("Add to the order");
						btnCheckout.setToolTipText("Place order");
					} else {
						checkBox15.setToolTipText(null);
						checkBox1540.setToolTipText(null);
						checkBox40.setToolTipText(null);
						spinner.setToolTipText(null);
						btnAdd.setToolTipText(null);
						btnCancel.setToolTipText(null);
						btnCheckout.setToolTipText(null);
					}
				}
			});
			chckbxmntmTooltips.setMnemonic(KeyEvent.VK_T);
			chckbxmntmTooltips.setSelected(true);
		}
		return chckbxmntmTooltips;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
		}
		return separator_2;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmHelp());
			mnHelp.add(getSeparator_3());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmHelp() {
		if (mntmHelp == null) {
			mntmHelp = new JMenuItem("Help");
			mntmHelp.setMnemonic(KeyEvent.VK_F11);
		}
		return mntmHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "This application has been made by Sara González Tomillo for the June 2016 exam of CPM", "About", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAbout.setMnemonic(KeyEvent.VK_F12);
		}
		return mntmAbout;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
		}
		return separator_3;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(2);
			splitPane.setLeftComponent(getPnIzq());
			splitPane.setRightComponent(getPnDcha());
			splitPane.setDividerLocation(320);
		}
		return splitPane;
	}
	private JPanel getPnIzq() {
		if (pnIzq == null) {
			pnIzq = new JPanel();
			pnIzq.setLayout(new BorderLayout(0, 0));
			pnIzq.add(getPnFiltros(), BorderLayout.NORTH);
			pnIzq.add(getScrollPane(), BorderLayout.CENTER);
			pnIzq.add(getPnAdd(), BorderLayout.SOUTH);
		}
		return pnIzq;
	}
	private JPanel getPnDcha() {
		if (pnDcha == null) {
			pnDcha = new JPanel();
			pnDcha.setLayout(new BorderLayout(0, 0));
			pnDcha.add(getLblOrder(), BorderLayout.NORTH);
			pnDcha.add(getScrollPane_1(), BorderLayout.CENTER);
			pnDcha.add(getPnTotal(), BorderLayout.SOUTH);
		}
		return pnDcha;
	}
	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.add(getCheckBox15());
			pnFiltros.add(getCheckBox1540());
			pnFiltros.add(getCheckBox40());
		}
		return pnFiltros;
	}
	private JCheckBox getCheckBox15() {
		if (checkBox15 == null) {
			checkBox15 = new JCheckBox("< 15\u20AC");
			checkBox15.setToolTipText("Show books with a price smaller than 15\u20AC");
			checkBox15.setSelected(true);
			checkBox15.addActionListener(filtraLibros);
		}
		return checkBox15;
	}
	private JCheckBox getCheckBox1540() {
		if (checkBox1540 == null) {
			checkBox1540 = new JCheckBox("15\u20AC - 40\u20AC");
			checkBox1540.setToolTipText("Show books between 15\u20AC and 40\u20AC");
			checkBox1540.setSelected(true);
			checkBox1540.addActionListener(filtraLibros);
		}
		return checkBox1540;
	}
	private JCheckBox getCheckBox40() {
		if (checkBox40 == null) {
			checkBox40 = new JCheckBox("> 40\u20AC");
			checkBox40.setToolTipText("Show books that cost more than 40\u20AC");
			checkBox40.setSelected(true);
			checkBox40.addActionListener(filtraLibros);
		}
		return checkBox40;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getListaLibros());
		}
		return scrollPane;
	}
	private JList getListaLibros() {
		if (listaLibros == null) {
			listaLibros = new JList();
			listaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			modeloListaLibros = new DefaultListModel();
			
			for(Libro libro : libros)
				modeloListaLibros.addElement(libro);
			
			listaLibros.setModel(modeloListaLibros);
			listaLibros.addMouseListener(showInfo);
		}
		return listaLibros;
	}
	private JPanel getPnAdd() {
		if (pnAdd == null) {
			pnAdd = new JPanel();
			pnAdd.add(getLblUnits());
			pnAdd.add(getSpinner());
			pnAdd.add(getBtnAdd());
		}
		return pnAdd;
	}
	private JLabel getLblUnits() {
		if (lblUnits == null) {
			lblUnits = new JLabel("Units:");
			lblUnits.setLabelFor(getSpinner());
			lblUnits.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblUnits;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setToolTipText("Select units of the book to order");
			spinner.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
			
		}
		return spinner;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setEnabled(false);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int selected = listaLibros.getSelectedIndex();
					modeloListaPedido.clear();
					if(selected != -1){
						Libro libro = (Libro) modeloListaLibros.elementAt(selected);
						int units = (int) spinner.getValue();
						
						boolean isInPedido = false;
						int index = 0;
						for(int i = 0; i < pedido.size(); i++){
							if(pedido.get(i).getISBN() == libro.getISBN()){
								isInPedido = true;
								index = i;
							}
						}
						
						if(isInPedido){
							pedido.get(index).setUnits(pedido.get(index).getUnits() + units);
						} else {
							Compra c = new Compra(libro.getISBN(), libro.getTitulo(), units, libro.getPrice());
							pedido.add(c);
						}
					}
					
					double total = 0;
					for(Compra c : pedido){
						modeloListaPedido.addElement(c);
						total += c.getUnits() * c.getPrice();
					}
					
					textField.setText(String.valueOf(total) + "€");
					btnCheckout.setEnabled(true);
				}
			});
			btnAdd.setToolTipText("Add to the order");
		}
		return btnAdd;
	}
	private JLabel getLblOrder() {
		if (lblOrder == null) {
			lblOrder = new JLabel("Order:");
			lblOrder.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblOrder;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getListaPedido());
		}
		return scrollPane_1;
	}
	private JList getListaPedido() {
		if (listaPedido == null) {
			listaPedido = new JList();
			modeloListaPedido = new DefaultListModel();
			listaPedido.setModel(modeloListaPedido);
		}
		return listaPedido;
	}
	private JPanel getPnTotal() {
		if (pnTotal == null) {
			pnTotal = new JPanel();
			pnTotal.add(getLblTotal());
			pnTotal.add(getTextField());
		}
		return pnTotal;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total:");
			lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lblTotal;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("0.0\u20AC");
			textField.setEditable(false);
			textField.setColumns(10);
		}
		return textField;
	}
	private JMenuItem getMntmLogOut() {
		if (mntmLogOut == null) {
			mntmLogOut = new JMenuItem("Log out");
			mntmLogOut.setMnemonic(KeyEvent.VK_X);
			mntmLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					logOut();
				}
			});
		}
		return mntmLogOut;
	}
}
