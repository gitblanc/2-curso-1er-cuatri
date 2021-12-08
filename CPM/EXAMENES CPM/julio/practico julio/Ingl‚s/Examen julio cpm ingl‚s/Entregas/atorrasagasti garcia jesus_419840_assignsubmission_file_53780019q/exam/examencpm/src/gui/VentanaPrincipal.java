package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Cliente;
import logica.Libro;

import javax.swing.JLabel;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.io.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;


import javax.help.*;
import java.net.*;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;
	private JLabel lblWelcome;
	private JPanel pnCenter;
	private JPanel pnInfoBooks;
	private JSplitPane splitPane;
	// book arrays
	private ArrayList<Libro> librosDisponibles = new ArrayList<Libro>();
	private ArrayList<Libro> librosComprados = new ArrayList<Libro>();
	// list models
	private DefaultListModel<String> modelDisponibles = new DefaultListModel<String>();
	private DefaultListModel<String> modelComprados = new DefaultListModel<String>();

	private JList listDisponibles;
	private JList listComprados;
	private JLabel lblPrecioTotal;
	private JPanel pnInfoPedido;
	private JTextField textFieldTotalPrice;
	private JLabel lblIsbn;
	private JTextArea textAreaISBN;
	private JLabel lblAuthor;
	private JTextArea textAreaAuthor;
	private JLabel lblEditor;
	private JTextArea textAreaEditor;
	private JLabel lblType;
	private JTextArea textAreaType;
	private JPanel panelResult;
	private JPanel panelAddRemove;
	private JButton btnAdd;
	private JSpinner spinner;
	private JButton btnRemove;
	private JPanel pnFilters;
	private JCheckBox checkBox15;
	private JCheckBox checkBoxMed;
	private JCheckBox checkBox40;
	private FiltraLibros filtro;
	private JLabel lblPrice;
	private JTextArea textAreaPrice;
	private JPanel pnAboutBooks;
	private JPanel pnResume;
	private JTextArea textAreaResume;
	private JPanel panelActions;
	private JPanel pnResetBuy;
	private JButton btnReset;
	private JButton btnBuy;
	
	private float precioTotal = 0;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JMenuItem mntmRestart;
	private JMenu mnOptions;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JMenu mnAbout;
	private JMenuItem mntmHelp;
	private JMenuItem mntmAbout;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Cliente cl) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		setTitle("University of Oviedo Book Shop");
		leerFicheroLibros();
		cargaAyuda();
		
		this.cliente = cl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 470);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLblWelcome(), BorderLayout.NORTH);
		contentPane.add(getPnCenter(), BorderLayout.CENTER);
		contentPane.add(getPnAboutBooks(), BorderLayout.SOUTH);
		
	}
	
	protected void initialize() {
		librosComprados.clear();
		librosDisponibles.clear();
		modelComprados.clear();
		modelDisponibles.clear();
		
		DialogoLogin newDialogo = new DialogoLogin();
		newDialogo.setVisible(true);
		
	}

	// AUXILIARY CODE------------------------------

	/*
	 * This class is made here to make use of the checkboxes / list models used
	 * in VentanaPrincipal i think it can be made externally but it asks me to
	 * make fields static and i get some kind of problems
	 */
	public class FiltraLibros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			modelDisponibles.clear();

			if (checkBox15.isSelected() || checkBox40.isSelected()
					|| checkBoxMed.isSelected()) {
				if (checkBox15.isSelected()) {
					for (Libro lib : librosDisponibles) {
						if (lib.getPrice() < 15.0)
							modelDisponibles.addElement(lib.getTitle());
					}

				}  if (checkBox40.isSelected()) {
					for (Libro lib : librosDisponibles) {
						if (lib.getPrice() > 40.0)
							modelDisponibles.addElement(lib.getTitle());
					}

				} if (checkBoxMed.isSelected()) {
					for (Libro lib : librosDisponibles) {
						if (lib.getPrice() >= 15.0 && lib.getPrice() <= 40.0)
							modelDisponibles.addElement(lib.getTitle());
					}
				}

			}
		}
	}
	//Read books and get them into the list from here.
	void leerFicheroLibros() {
		String nombreFichero = "files/libros.dat";
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			// Mientras quede información
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				librosDisponibles.add(new Libro(trozos[0], trozos[1],
						trozos[2], trozos[3], trozos[4], trozos[5], Float
								.valueOf(trozos[6])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
	
	//Create file from here.
	public void grabarFichero() {
	    String nombreFichero = "receipts/" + cliente.getDNI()+".dat";
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		fichero.write("UNIVERSITY OF OVIEDO BOOK SHOP RECEIPT");
		fichero.newLine(); //Si se quiere añadir un salto de línea
		fichero.write("Order for : " + cliente.getNombre() +" " + cliente.getApellido() + " / DNI: " + cliente.getDNI());
		fichero.newLine();
		fichero.write("You have ordered: ");
		fichero.newLine();
		for (Libro libro : librosComprados){
			fichero.write(libro.getTitle() + " ISBN: " + libro.getISBN() + " Price: " + libro.getPrice());
			fichero.newLine();
		}
		fichero.write("Final price(including tax): " + precioTotal);
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }
	
	//Loading the help set

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
	
	   hb.enableHelpKey(getRootPane(),"html_inicio", hs);
	   //hb.enableHelpOnButton(btnBuy, "html_inicio", hs);
	   
	 }

	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome, " + cliente.getNombre());
			lblWelcome.setFont(new Font("Poor Richard",
					Font.BOLD | Font.ITALIC, 28));
		}
		return lblWelcome;
	}

	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setLayout(new BorderLayout(0, 0));
			pnCenter.add(getSplitPane(), BorderLayout.CENTER);
			pnCenter.add(getPnInfoPedido(), BorderLayout.EAST);
			pnCenter.add(getPnFilters(), BorderLayout.SOUTH);
		}
		return pnCenter;
	}

	private JPanel getPnInfoBooks() {
		if (pnInfoBooks == null) {
			pnInfoBooks = new JPanel();
			pnInfoBooks.setLayout(new BoxLayout(pnInfoBooks, BoxLayout.X_AXIS));
			pnInfoBooks.add(getLblIsbn());
			pnInfoBooks.add(getTextAreaISBN());
			pnInfoBooks.add(getLblAuthor());
			pnInfoBooks.add(getTextAreaAuthor());
			pnInfoBooks.add(getLblEditor());
			pnInfoBooks.add(getTextAreaEditor());
			pnInfoBooks.add(getLblType());
			pnInfoBooks.add(getTextAreaType());
			pnInfoBooks.add(getLblPrice());
			pnInfoBooks.add(getTextAreaPrice());
		}
		return pnInfoBooks;
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setLeftComponent(getListDisponibles());
			splitPane.setRightComponent(getListComprados());
		}
		return splitPane;
	}

	private JList getListDisponibles() {
		if (listDisponibles == null) {
			for (Libro lib : librosDisponibles) {
				modelDisponibles.addElement(lib.getTitle());
			}
			listDisponibles = new JList(modelDisponibles);
			listDisponibles.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					for (Libro lib : librosDisponibles) {
						if(lib.getTitle().equals(listDisponibles.getSelectedValue())){
							textAreaAuthor.setText(lib.getAuthor());
							textAreaEditor.setText(lib.getEditor());
							textAreaISBN.setText(lib.getISBN());
							textAreaType.setText(lib.getType());
							textAreaPrice.setText(String.valueOf(lib.getPrice()));
							textAreaResume.setText(lib.getSummary());
						}
					}
				}
			});
		}
		return listDisponibles;
	}

	private JList getListComprados() {
		if (listComprados == null) {
			modelComprados = new DefaultListModel<String>();
			listComprados = new JList(modelComprados);
		}
		return listComprados;
	}

	private JLabel getLblPrecioTotal() {
		if (lblPrecioTotal == null) {
			lblPrecioTotal = new JLabel("Total price(tax incl): ");
		}
		return lblPrecioTotal;
	}

	private JPanel getPnInfoPedido() {
		if (pnInfoPedido == null) {
			pnInfoPedido = new JPanel();
			pnInfoPedido.setLayout(new BorderLayout(0, 0));
			pnInfoPedido.add(getPanelActions(), BorderLayout.NORTH);
			pnInfoPedido.add(getPanelResult(), BorderLayout.SOUTH);
		}
		return pnInfoPedido;
	}

	private JTextField getTextFieldTotalPrice() {
		if (textFieldTotalPrice == null) {
			textFieldTotalPrice = new JTextField();
			textFieldTotalPrice.setEditable(false);
			textFieldTotalPrice.setColumns(10);
		}
		return textFieldTotalPrice;
	}

	private JLabel getLblIsbn() {
		if (lblIsbn == null) {
			lblIsbn = new JLabel("ISBN: ");
		}
		return lblIsbn;
	}

	private JTextArea getTextAreaISBN() {
		if (textAreaISBN == null) {
			textAreaISBN = new JTextArea();
			textAreaISBN.setColumns(10);
			textAreaISBN.setEditable(false);
		}
		return textAreaISBN;
	}

	private JLabel getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new JLabel("Author: ");
		}
		return lblAuthor;
	}

	private JTextArea getTextAreaAuthor() {
		if (textAreaAuthor == null) {
			textAreaAuthor = new JTextArea();
			textAreaAuthor.setColumns(10);
			textAreaAuthor.setEditable(false);
		}
		return textAreaAuthor;
	}

	private JLabel getLblEditor() {
		if (lblEditor == null) {
			lblEditor = new JLabel("Editor:");
		}
		return lblEditor;
	}

	private JTextArea getTextAreaEditor() {
		if (textAreaEditor == null) {
			textAreaEditor = new JTextArea();
			textAreaEditor.setEditable(false);
			textAreaEditor.setColumns(10);
		}
		return textAreaEditor;
	}

	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type: ");
		}
		return lblType;
	}

	private JTextArea getTextAreaType() {
		if (textAreaType == null) {
			textAreaType = new JTextArea();
			textAreaType.setEditable(false);
			textAreaType.setColumns(10);
		}
		return textAreaType;
	}

	private JPanel getPanelResult() {
		if (panelResult == null) {
			panelResult = new JPanel();
			panelResult.add(getLblPrecioTotal());
			panelResult.add(getTextFieldTotalPrice());
		}
		return panelResult;
	}

	private JPanel getPanelAddRemove() {
		if (panelAddRemove == null) {
			panelAddRemove = new JPanel();
			panelAddRemove.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelAddRemove.add(getSpinner());
			panelAddRemove.add(getBtnAdd());
			panelAddRemove.add(getBtnRemove());
		}
		return panelAddRemove;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setMnemonic('d');
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int cantidad = (int) spinner.getValue();
					if (!(listDisponibles.getSelectedValue() == null)){
					String titulo = listDisponibles.getSelectedValue()
							.toString();
					for (int i = 0; i < cantidad; i++) {
						modelComprados.addElement(titulo);
						addLibroComprado(titulo);
					}
					calcularPrecioTotal();	
					} else JOptionPane.showMessageDialog(null, "Select a book first!");
				}
			});
		}
		return btnAdd;
	}

	protected void calcularPrecioTotal() {
		float precioFinal = 0;
		for (Libro lib : librosComprados) {
			precioFinal += lib.getPrice();
		}
		precioTotal = precioFinal;
		textFieldTotalPrice.setText(String.valueOf(precioFinal));

	}

	protected void addLibroComprado(String titulo) {
		for (Libro lib : librosDisponibles) {
			if (titulo.equals(lib.getTitle())) {
				librosComprados.add(lib);
			}
		}

	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(1),
					new Integer(1), null, new Integer(1)));
		}
		return spinner;
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.setMnemonic('r');
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!(listComprados.getSelectedValue() == null)){
						librosComprados.remove(listComprados.getSelectedIndex());
						modelComprados.removeElementAt(listComprados.getSelectedIndex());	
						calcularPrecioTotal();
					} else JOptionPane.showMessageDialog(null, "Select a book first!");
				}
			});
		}
		return btnRemove;
	}

	private JPanel getPnFilters() {
		if (pnFilters == null) {
			pnFilters = new JPanel();
			pnFilters.setBorder(new TitledBorder(null, "Filter by price",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnFilters.add(getCheckBox15());
			pnFilters.add(getCheckBoxMed());
			pnFilters.add(getCheckBox40());
		}
		return pnFilters;
	}

	private JCheckBox getCheckBox15() {
		if (checkBox15 == null) {
			checkBox15 = new JCheckBox("< 15\u20AC");
			checkBox15.setSelected(true);
			checkBox15.addActionListener(filtro = new FiltraLibros());
		}
		return checkBox15;
	}

	private JCheckBox getCheckBoxMed() {
		if (checkBoxMed == null) {
			checkBoxMed = new JCheckBox("15-40\u20AC");
			checkBoxMed.setSelected(true);
			checkBoxMed.addActionListener(filtro = new FiltraLibros());
		}
		return checkBoxMed;
	}

	private JCheckBox getCheckBox40() {
		if (checkBox40 == null) {
			checkBox40 = new JCheckBox(">40\u20AC");
			checkBox40.setSelected(true);
			checkBox40.addActionListener(filtro = new FiltraLibros());
		}
		return checkBox40;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Price: ");
		}
		return lblPrice;
	}
	private JTextArea getTextAreaPrice() {
		if (textAreaPrice == null) {
			textAreaPrice = new JTextArea();
			textAreaPrice.setColumns(10);
			textAreaPrice.setEditable(false);
		}
		return textAreaPrice;
	}
	private JPanel getPnAboutBooks() {
		if (pnAboutBooks == null) {
			pnAboutBooks = new JPanel();
			pnAboutBooks.setLayout(new BorderLayout(0, 0));
			pnAboutBooks.add(getPnInfoBooks(), BorderLayout.NORTH);
			pnAboutBooks.add(getPnResume(), BorderLayout.SOUTH);
		}
		return pnAboutBooks;
	}
	private JPanel getPnResume() {
		if (pnResume == null) {
			pnResume = new JPanel();
			pnResume.add(getTextAreaResume());
		}
		return pnResume;
	}
	private JTextArea getTextAreaResume() {
		if (textAreaResume == null) {
			textAreaResume = new JTextArea();
			textAreaResume.setLineWrap(true);
			textAreaResume.setWrapStyleWord(true);
			textAreaResume.setColumns(40);
			textAreaResume.setRows(3);
		}
		return textAreaResume;
	}
	private JPanel getPanelActions() {
		if (panelActions == null) {
			panelActions = new JPanel();
			panelActions.setLayout(new BoxLayout(panelActions, BoxLayout.Y_AXIS));
			panelActions.add(getPanelAddRemove());
			panelActions.add(getPanel_1());
		}
		return panelActions;
	}
	private JPanel getPanel_1() {
		if (pnResetBuy == null) {
			pnResetBuy = new JPanel();
			pnResetBuy.add(getBtnReset());
			pnResetBuy.add(getBtnBuy());
		}
		return pnResetBuy;
	}
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("Reset");
			btnReset.setMnemonic('s');
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modelComprados.clear();
					librosComprados.clear();
					calcularPrecioTotal();
				}
			});
		}
		return btnReset;
	}
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Buy");
			btnBuy.setMnemonic('b');
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (librosComprados.size() == 0) JOptionPane.showMessageDialog(null, "You have to buy a book first!");
					else{
						JOptionPane.showMessageDialog(null, "Thank you for your order!");
						grabarFichero();
						initialize();
						setVisible(false);
					}
				}
			});
		}
		return btnBuy;
	}

	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnOptions());
			menuBar.add(getMnAbout());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmRestart());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmExit;
	}
	private JMenuItem getMntmRestart() {
		if (mntmRestart == null) {
			mntmRestart = new JMenuItem("Restart");
			mntmRestart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					initialize();
					setVisible(false);
				}
			});
		}
		return mntmRestart;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.add(getMenuItem1());
			mnOptions.add(getMenuItem2());
			mnOptions.add(getMenuItem3());
		}
		return mnOptions;
	}
	private JMenuItem getMenuItem1() {
		if (menuItem1 == null) {
			menuItem1 = new JMenuItem("<15\u20AC");
			menuItem1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					checkBox15.doClick();
				}
			});
			menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
		}
		return menuItem1;
	}
	private JMenuItem getMenuItem2() {
		if (menuItem2 == null) {
			menuItem2 = new JMenuItem("15-40\u20AC");
			menuItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					checkBoxMed.doClick();
				}
			});
			menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
		}
		return menuItem2;
	}
	private JMenuItem getMenuItem3() {
		if (menuItem3 == null) {
			menuItem3 = new JMenuItem(">40\u20AC");
			menuItem3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					checkBox40.doClick();
				}
			});
			menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));
		}
		return menuItem3;
	}
	private JMenu getMnAbout() {
		if (mnAbout == null) {
			mnAbout = new JMenu("About");
			mnAbout.add(getMntmHelp());
			mnAbout.add(getMntmAbout());
		}
		return mnAbout;
	}
	private JMenuItem getMntmHelp() {
		if (mntmHelp == null) {
			mntmHelp = new JMenuItem("Help");
			mntmHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "This is an exam");
				}
			});
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		}
		return mntmAbout;
	}
}
