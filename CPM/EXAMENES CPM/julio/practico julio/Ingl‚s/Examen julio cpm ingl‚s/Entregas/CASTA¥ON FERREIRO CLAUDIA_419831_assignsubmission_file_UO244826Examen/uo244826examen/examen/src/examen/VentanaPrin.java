package examen;

import java.awt.BorderLayout;
import javax.help.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;

import logica.Libro;
import logica.Pedido;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SpinnerNumberModel;

public class VentanaPrin extends JFrame {

	private JPanel contentPane;
	String name;
	String dni;
	VentanaDialog parent;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmCancel;
	private JSeparator separator;
	private JMenuItem mntmExit;
	private JMenu mnOptions;
	private JMenuItem mntmCheap;
	private JMenuItem mntmNormal;
	private JMenuItem mntmExpensive;
	private JSeparator separator_1;
	private JMenuItem mntmSelectAll;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JSeparator separator_2;
	private JMenuItem mntmIntroduction;
	private JPanel pnTexto;
	private JPanel pnCentral;
	private JPanel pnCheck;
	private JCheckBox chckbxCheap;
	private JCheckBox chckbxNormal;
	private JCheckBox chckbxExpensive;
	private JLabel lblWelcomeToOut;
	private JPanel pnLista;
	private JList catalog;
	private JList order;
	private JPanel pnInferior;
	private JLabel lblUnits;
	private JTextArea txtArea;
	private JButton btnAdd;
	private JLabel lblTotalPrice;
	private JButton btnBuy;
	private JSpinner spinner;
	private JTextField txtPrecio;
	private JButton btnCancel;

	ArrayList<Libro> libros = new ArrayList<Libro>();
	DefaultListModel model;
	DefaultListModel model2;
	FiltraLibros lib;
	ArrayList<Libro> compra = new ArrayList<Libro>();
	ArrayList<Double> pedidos = new ArrayList<Double>();
	ArrayList<Pedido> orders = new ArrayList<Pedido>();
	private JSeparator separator_3;
	private JMenuItem mntmDeactivateTooltips;
	
	/**
	 * Launch the application.
	 */

	void leerFichero() {
	    String nombreFichero = "files/libros.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));
	      libros = new ArrayList<Libro>();

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        Libro aux = new Libro(trozos[0],trozos[1],trozos[2],trozos[3],trozos[4],trozos[5],Double.valueOf(trozos[6]));
	        libros.add(aux);
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

	/**
	 * Create the frame.
	 */
	public VentanaPrin(String dni,String name,VentanaDialog ref) {
		leerFichero();
		cargaAyuda();
		lib = new FiltraLibros();
		setTitle("Oviedo Book Store");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrin.class.getResource("/img/libreria.jpg")));
		this.dni=dni;
		this.name=name;
		this.parent=ref;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 515);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnTexto(), BorderLayout.NORTH);
		contentPane.add(getPnCentral(), BorderLayout.CENTER);
		contentPane.add(getPnInferior(), BorderLayout.SOUTH);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmCancel());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmCancel() {
		if (mntmCancel == null) {
			mntmCancel = new JMenuItem("Cancel");
			mntmCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reset();
				}
			});
			mntmCancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));
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
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		}
		return mntmExit;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.add(getMntmCheap());
			mnOptions.add(getMntmNormal());
			mnOptions.add(getMntmExpensive());
			mnOptions.add(getSeparator_1());
			mnOptions.add(getMntmSelectAll());
			mnOptions.add(getSeparator_3());
			mnOptions.add(getMntmDeactivateTooltips());
		}
		return mnOptions;
	}
	private JMenuItem getMntmCheap() {
		if (mntmCheap == null) {
			mntmCheap = new JMenuItem("Cheap");
			mntmCheap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chckbxCheap.doClick();
				}
			});
			mntmCheap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		}
		return mntmCheap;
	}
	private JMenuItem getMntmNormal() {
		if (mntmNormal == null) {
			mntmNormal = new JMenuItem("Normal");
			mntmNormal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chckbxNormal.doClick();
				}
			});
			mntmNormal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		}
		return mntmNormal;
	}
	private JMenuItem getMntmExpensive() {
		if (mntmExpensive == null) {
			mntmExpensive = new JMenuItem("Expensive");
			mntmExpensive.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chckbxExpensive.doClick();
				}
			});
			mntmExpensive.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		}
		return mntmExpensive;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenuItem getMntmSelectAll() {
		if (mntmSelectAll == null) {
			mntmSelectAll = new JMenuItem("Select All");
			mntmSelectAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!chckbxCheap.isSelected()){
						chckbxCheap.doClick();
					}
					if(!chckbxNormal.isSelected()){
						chckbxNormal.doClick();
					}
					if(!chckbxExpensive.isSelected()){
						chckbxExpensive.doClick();
					}
				}
			});
			mntmSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		}
		return mntmSelectAll;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
			mnHelp.add(getSeparator_2());
			mnHelp.add(getMntmIntroduction());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Project developed by Claudia Castañon 27/7/2016");
				}
			});
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		}
		return mntmAbout;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
		}
		return separator_2;
	}
	private JMenuItem getMntmIntroduction() {
		if (mntmIntroduction == null) {
			mntmIntroduction = new JMenuItem("Introduction");
			mntmIntroduction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmIntroduction;
	}
	
	private void reset() {
		spinner.setEnabled(false);
		btnCancel.setEnabled(false);
		btnAdd.setEnabled(false);
		lblTotalPrice.setEnabled(false);
		txtPrecio.setEnabled(false);
		lblUnits.setEnabled(false);
		txtArea.setEnabled(false);
		model2.clear();
		txtArea.setText("");
		spinner.setValue(1);
		txtPrecio.setText("0€");
		pedidos.clear();
		orders.clear();
		
		
	}
	private JPanel getPnTexto() {
		if (pnTexto == null) {
			pnTexto = new JPanel();
			pnTexto.add(getLblWelcomeToOut());
		}
		return pnTexto;
	}
	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setLayout(new BorderLayout(0, 0));
			pnCentral.add(getPnCheck(), BorderLayout.NORTH);
			pnCentral.add(getPnLista(), BorderLayout.CENTER);
		}
		return pnCentral;
	}
	private JPanel getPnCheck() {
		if (pnCheck == null) {
			pnCheck = new JPanel();
			pnCheck.setLayout(new GridLayout(1, 0, 0, 0));
			pnCheck.add(getChckbxCheap());
			pnCheck.add(getChckbxNormal());
			pnCheck.add(getChckbxExpensive());
		}
		return pnCheck;
	}
	private JCheckBox getChckbxCheap() {
		if (chckbxCheap == null) {
			chckbxCheap = new JCheckBox("Cheap <15\u20AC");
			chckbxCheap.setHorizontalAlignment(SwingConstants.CENTER);
			chckbxCheap.setFont(new Font("Tahoma", Font.PLAIN, 13));
			chckbxCheap.setMnemonic('h');
			chckbxCheap.setToolTipText("Select books with price lower than 15\u20AC");
			chckbxCheap.setEnabled(true);
			chckbxCheap.setSelected(true);
			chckbxCheap.addActionListener(lib);
		}
		return chckbxCheap;
	}
	private JCheckBox getChckbxNormal() {
		if (chckbxNormal == null) {
			chckbxNormal = new JCheckBox("Normal 15-40\u20AC");
			chckbxNormal.setToolTipText("Select books with price between 15 and 40 \u20AC");
			chckbxNormal.setMnemonic('n');
			chckbxNormal.setHorizontalAlignment(SwingConstants.CENTER);
			chckbxNormal.setFont(new Font("Tahoma", Font.PLAIN, 13));
			chckbxNormal.setSelected(true);
			chckbxNormal.addActionListener(lib);
		}
		return chckbxNormal;
	}
	private JCheckBox getChckbxExpensive() {
		if (chckbxExpensive == null) {
			chckbxExpensive = new JCheckBox("Expensive >40\u20AC");
			chckbxExpensive.setFont(new Font("Tahoma", Font.PLAIN, 13));
			chckbxExpensive.setHorizontalAlignment(SwingConstants.CENTER);
			chckbxExpensive.setMnemonic('x');
			chckbxExpensive.setToolTipText("Select books with price greater than 40\u20AC");
			chckbxExpensive.setSelected(true);
			chckbxExpensive.addActionListener(lib);
		}
		return chckbxExpensive;
	}
	private JLabel getLblWelcomeToOut() {
		if (lblWelcomeToOut == null) {
			lblWelcomeToOut = new JLabel("Welcome to out bookstore " +name+ " !");
			lblWelcomeToOut.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblWelcomeToOut.setToolTipText("Please place your order");
		}
		return lblWelcomeToOut;
	}
	private JPanel getPnLista() {
		if (pnLista == null) {
			pnLista = new JPanel();
			pnLista.setLayout(new GridLayout(1, 0, 0, 0));
			pnLista.add(getCatalog());
			pnLista.add(getOrder());
		}
		return pnLista;
	}
	private JList getCatalog() {
		if (catalog == null) {
			model = new DefaultListModel();
			for(Libro l : libros){
				String aux = l.getTitle();
				model.addElement(aux);
			}
			
			catalog = new JList(model);
			catalog.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					String aux = (String) catalog.getSelectedValue();
					Libro lib= new Libro ("","","","","","",1.1);
					for(Libro l:libros){
						if(l.getTitle().equals(aux)){
							lib = l;
						}
					}
					spinner.setEnabled(true);
					btnCancel.setEnabled(true);
					btnAdd.setEnabled(true);
					lblTotalPrice.setEnabled(true);
					txtPrecio.setEnabled(true);
					lblUnits.setEnabled(true);
					txtArea.setEnabled(true);
					txtArea.setText("ISBN: "+lib.getUSBN()+ 
							"\r\nTitle: "+ lib.getTitle()+
							"\r\nEditor: "+lib.getEditor()+
							"\r\nAuthor: "+lib.getAuthor()+
							"\r\nType: "+lib.getType()+
							"\r\nSummary: "+lib.getSummary()+
							"\r\nPrice: " + lib.getPrice());
					
				}
			});
		}
		return catalog;
	}
	private JList getOrder() {
		if (order == null) {
			model2 = new DefaultListModel();
			order = new JList(model2);
		}
		return order;
	}
	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			GridBagLayout gbl_pnInferior = new GridBagLayout();
			gbl_pnInferior.columnWidths = new int[]{0, 0, 0, 0, 0, 57, 0, 75, 0, 0, 0, 0, 0};
			gbl_pnInferior.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnInferior.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnInferior.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnInferior.setLayout(gbl_pnInferior);
			GridBagConstraints gbc_txtArea = new GridBagConstraints();
			gbc_txtArea.gridwidth = 6;
			gbc_txtArea.gridheight = 8;
			gbc_txtArea.insets = new Insets(0, 0, 0, 5);
			gbc_txtArea.fill = GridBagConstraints.BOTH;
			gbc_txtArea.gridx = 0;
			gbc_txtArea.gridy = 0;
			pnInferior.add(getTxtArea(), gbc_txtArea);
			GridBagConstraints gbc_lblUnits = new GridBagConstraints();
			gbc_lblUnits.anchor = GridBagConstraints.EAST;
			gbc_lblUnits.insets = new Insets(0, 0, 5, 5);
			gbc_lblUnits.gridx = 7;
			gbc_lblUnits.gridy = 2;
			pnInferior.add(getLblUnits(), gbc_lblUnits);
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 8;
			gbc_spinner.gridy = 2;
			pnInferior.add(getSpinner(), gbc_spinner);
			GridBagConstraints gbc_btnAdd = new GridBagConstraints();
			gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
			gbc_btnAdd.gridx = 9;
			gbc_btnAdd.gridy = 2;
			pnInferior.add(getBtnAdd(), gbc_btnAdd);
			GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
			gbc_lblTotalPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblTotalPrice.gridx = 7;
			gbc_lblTotalPrice.gridy = 4;
			pnInferior.add(getLblTotalPrice(), gbc_lblTotalPrice);
			GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
			gbc_txtPrecio.gridwidth = 2;
			gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPrecio.gridx = 8;
			gbc_txtPrecio.gridy = 4;
			pnInferior.add(getTxtPrecio(), gbc_txtPrecio);
			GridBagConstraints gbc_btnCancel = new GridBagConstraints();
			gbc_btnCancel.gridwidth = 2;
			gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
			gbc_btnCancel.gridx = 7;
			gbc_btnCancel.gridy = 6;
			pnInferior.add(getBtnCancel(), gbc_btnCancel);
			GridBagConstraints gbc_btnBuy = new GridBagConstraints();
			gbc_btnBuy.insets = new Insets(0, 0, 5, 5);
			gbc_btnBuy.gridx = 9;
			gbc_btnBuy.gridy = 6;
			pnInferior.add(getBtnBuy(), gbc_btnBuy);
		}
		return pnInferior;
	}
	private JLabel getLblUnits() {
		if (lblUnits == null) {
			lblUnits = new JLabel("Units:");
			lblUnits.setEnabled(false);
			lblUnits.setLabelFor(getSpinner());
			lblUnits.setToolTipText("Select the units you want");
		}
		return lblUnits;
	}
	private JTextArea getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextArea();
			txtArea.setEnabled(false);
			txtArea.setEditable(false);
			txtArea.setWrapStyleWord(true);
			txtArea.setLineWrap(true);
		}
		return txtArea;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setEnabled(false);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					calculatePrice();
					addToList();
					btnBuy.setEnabled(true);
				}
			});
			btnAdd.setToolTipText("Add to cart your order");
		}
		return btnAdd;
	}

	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("Total price:");
			lblTotalPrice.setEnabled(false);
			lblTotalPrice.setToolTipText("Total accumulated price of your order");
			lblTotalPrice.setLabelFor(getTxtPrecio());
		}
		return lblTotalPrice;
	}
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Buy");
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					grabarArchivo();
					JOptionPane.showMessageDialog(null,"Thanks for your order! Come back soon");
					VentanaDialog dialogo = new VentanaDialog();
					dialogo.setLocationRelativeTo(null);
					//dialogo.setModal(true);
					dialogo.setVisible(true);
					dispose();
				}
			});
			btnBuy.setToolTipText("Confirm your order and print the receipt");
			btnBuy.setEnabled(false);
		}
		return btnBuy;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setEnabled(false);
			spinner.setToolTipText("");
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return spinner;
	}
	private JTextField getTxtPrecio() {
		if (txtPrecio == null) {
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setEnabled(false);
			txtPrecio.setToolTipText("");
			txtPrecio.setColumns(10);
		}
		return txtPrecio;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setToolTipText("Cancel your order. Your order will be deleted");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reset();
				}
			});
			btnCancel.setEnabled(false);
		}
		return btnCancel;
	}
	
	class FiltraLibros implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			filtra();
			
		}
		
	}

	public void filtra() {
		model.clear();
		selectCheck(chckbxCheap.isSelected(),chckbxNormal.isSelected(),chckbxExpensive.isSelected());
		
	}

	private void selectCheck(boolean c,boolean n,boolean x) {
		if(c || n || x){
			boolean add;
			for (Libro l: libros){
				add = false;
				
				if (c && l.getPrice()<15){
					add = true;
				}else if (n && l.getPrice()>=15 && l.getPrice()<=40){
					add = true;
				}else if (x && l.getPrice()>40){
					add = true;
				}
				
				if (add){
					String aux = l.getTitle();
					model.addElement(aux);
				}
				
			}
		}
		
	}
	
	protected void calculatePrice() {
		String aux = (String) catalog.getSelectedValue();
		Libro lib= new Libro ("","","","","","",1.1);
		for(Libro l:libros){
			if(l.getTitle().equals(aux)){
				lib = l;
			}
		}
		
		int sp = (int) spinner.getValue();
		double price = lib.getPrice();
		double priceBook = (sp*price);
		pedidos.add(priceBook);
		orders.add(new Pedido(lib.getTitle(),lib.getPrice(),sp,lib.getUSBN()));
		Double total = calculateTotal();
		Double total2 = (total*100)/100;
		txtPrecio.setText(String.valueOf(total2));

	}

	private Double calculateTotal() {
		double total = 0.0;
		for (Double p: pedidos){
			total+= p;
		}
		return total;
	}

	public void addToList(){
		model2.clear();
		for (Pedido p: orders){
			if (!model2.contains(p)){
				model2.addElement(p.toString());
			}else{
				int units = p.getUnits();
				int actual = (int) spinner.getValue();
				p.setUnits(units+actual);
				model2.addElement(p.toString());
			}
		}
		
	}
	
	public void grabarArchivo() {
	    String nombreFichero =  "files/"+dni+".dat";
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		fichero.write(linea);
		fichero.newLine(); //Si se quiere añadir un salto de línea
		for(Pedido p: orders){
			fichero.write("***********************************************");
			fichero.newLine();
			fichero.write("------ISBN------");
			fichero.newLine();
			fichero.write(p.getISBN());
			fichero.newLine();
			fichero.write("------Title------");
			fichero.newLine();
			fichero.write(p.getTitle());
			fichero.newLine();
			fichero.write("------Units------");
			fichero.newLine();
			String units = String.valueOf(p.getUnits());
			fichero.write(units);
			fichero.newLine();
			fichero.write("***********************************************");
			
		}
		fichero.newLine();
		fichero.write("Total: "+String.valueOf(calculateTotal())+"€");
		fichero.newLine();
		fichero.write("Thanks for your order!");
		
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }
	
	void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/Ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			 }

		    catch(Exception e){
		      		System.out.println("Ayuda no encontrada");
		      		return;
		        }

		   HelpBroker hb = hs.createHelpBroker();

		   hb.enableHelpKey(getRootPane(),"filter", hs);
		   hb.enableHelpOnButton(getMntmIntroduction(), "filter", hs);
		   hb.enableHelpKey(getBtnAdd(), "order", hs);
		   
		 }
	
	public void deactivateTooltips(){
		btnAdd.setToolTipText(null);
		lblUnits.setToolTipText(null);
		btnBuy.setToolTipText(null);
		lblTotalPrice.setToolTipText(null);
		btnCancel.setToolTipText(null);
		lblWelcomeToOut.setToolTipText(null);
		chckbxCheap.setToolTipText(null);
		chckbxNormal.setToolTipText(null);
		chckbxExpensive.setToolTipText(null);
	}
	
	
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
		}
		return separator_3;
	}
	private JMenuItem getMntmDeactivateTooltips() {
		if (mntmDeactivateTooltips == null) {
			mntmDeactivateTooltips = new JMenuItem("Deactivate tooltips");
			mntmDeactivateTooltips.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					deactivateTooltips();
				}
			});
			mntmDeactivateTooltips.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmDeactivateTooltips;
	}
}
