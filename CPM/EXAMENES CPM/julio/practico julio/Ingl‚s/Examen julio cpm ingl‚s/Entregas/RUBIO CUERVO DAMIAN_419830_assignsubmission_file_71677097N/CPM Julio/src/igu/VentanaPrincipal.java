package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextArea;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import logica.Book;
import logica.Client;
import logica.Pedido;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JSeparator;

import java.awt.FlowLayout;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelSuperior;
	private JLabel lblWelcomeToThe;
	private JPanel panelCentral;
	private JPanel panelInferior;
	private JPanel panelFiltros;
	private JLabel lblPriceRange;
	private JCheckBox checkBoxCheap;
	private JCheckBox checkBoxMedium;
	private JCheckBox checkBoxExpensive;
	private JPanel panelListas;
	private JList listInventario;
	private JList listPedido;
	private JTextArea textAreaDescripcion;
	private JTextField txtISBN;
	private JTextField txtEditor;
	private JTextField txtAuthor;
	private JTextField txtPrice;
	private JLabel lblCuantity;
	private JSpinner spinner;
	private JButton btnAdd;
	private JButton btnRemove;
	private JLabel lblTotalPrice;
	private JTextField textFieldTotalPrice;
	private JButton btnFinish;
	private JButton btnCancel;
	
	Client client;
	FiltraLibros filtro;
	DefaultListModel<String> modeloListaInventario = new DefaultListModel<String>();
	DefaultListModel<String> modeloListaPedidos = new DefaultListModel<String>();
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmReset;
	private JMenuItem mntmExit;
	private JMenu mnOptions;
	private JMenuItem mntmCheap;
	private JMenuItem mntmMedium;
	private JMenuItem mntmExpensive;
	private JSeparator separator;
	private JMenuItem mntmAll;
	private JMenu mnHelp;
	private JMenuItem mntmHelp;
	private JMenuItem mntmAbout;
	private JLabel lblIsbn;
	private JLabel lblAuthor;
	private JLabel lblType;
	private JLabel lblUnitPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param c 
	 */
	public VentanaPrincipal(Client c) {
		leerFicheroLibros();
		filtro = new FiltraLibros();
		this.client = c;
		setTitle("Librer\u00EDa EII Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelSuperior(), BorderLayout.NORTH);
		contentPane.add(getPanelCentral(), BorderLayout.CENTER);
		contentPane.add(getPanelInferior(), BorderLayout.SOUTH);
		updateListaInventario();
		updateListaPedido();
		cargaAyuda();
	}

	private JPanel getPanelSuperior() {
		if (panelSuperior == null) {
			panelSuperior = new JPanel();
			panelSuperior.add(getLblWelcomeToThe());
		}
		return panelSuperior;
	}
	private JLabel getLblWelcomeToThe() {
		if (lblWelcomeToThe == null) {
			String aux = client.getName();
			lblWelcomeToThe = new JLabel("Welcome to the book store, " + aux);
			lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblWelcomeToThe;
	}
	private JPanel getPanelCentral() {
		if (panelCentral == null) {
			panelCentral = new JPanel();
			panelCentral.setLayout(new BorderLayout(0, 0));
			panelCentral.add(getPanelFiltros(), BorderLayout.NORTH);
			panelCentral.add(getPanelListas(), BorderLayout.CENTER);
		}
		return panelCentral;
	}
	private JPanel getPanelInferior() {
		if (panelInferior == null) {
			panelInferior = new JPanel();
			GridBagLayout gbl_panelInferior = new GridBagLayout();
			gbl_panelInferior.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panelInferior.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_panelInferior.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panelInferior.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelInferior.setLayout(gbl_panelInferior);
			GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
			gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
			gbc_lblIsbn.gridx = 0;
			gbc_lblIsbn.gridy = 0;
			panelInferior.add(getLblIsbn(), gbc_lblIsbn);
			GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
			gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
			gbc_lblAuthor.gridx = 2;
			gbc_lblAuthor.gridy = 0;
			panelInferior.add(getLblAuthor(), gbc_lblAuthor);
			GridBagConstraints gbc_lblType = new GridBagConstraints();
			gbc_lblType.insets = new Insets(0, 0, 5, 5);
			gbc_lblType.gridx = 4;
			gbc_lblType.gridy = 0;
			panelInferior.add(getLblType(), gbc_lblType);
			GridBagConstraints gbc_lblUnitPrice = new GridBagConstraints();
			gbc_lblUnitPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblUnitPrice.gridx = 6;
			gbc_lblUnitPrice.gridy = 0;
			panelInferior.add(getLblUnitPrice(), gbc_lblUnitPrice);
			GridBagConstraints gbc_txtISBN = new GridBagConstraints();
			gbc_txtISBN.gridwidth = 2;
			gbc_txtISBN.insets = new Insets(0, 0, 5, 5);
			gbc_txtISBN.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtISBN.gridx = 0;
			gbc_txtISBN.gridy = 1;
			panelInferior.add(getTxtISBN(), gbc_txtISBN);
			GridBagConstraints gbc_txtEditor = new GridBagConstraints();
			gbc_txtEditor.gridwidth = 2;
			gbc_txtEditor.insets = new Insets(0, 0, 5, 5);
			gbc_txtEditor.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEditor.gridx = 2;
			gbc_txtEditor.gridy = 1;
			panelInferior.add(getTxtEditor(), gbc_txtEditor);
			GridBagConstraints gbc_txtAuthor = new GridBagConstraints();
			gbc_txtAuthor.gridwidth = 2;
			gbc_txtAuthor.insets = new Insets(0, 0, 5, 5);
			gbc_txtAuthor.gridx = 4;
			gbc_txtAuthor.gridy = 1;
			panelInferior.add(getTxtAuthor(), gbc_txtAuthor);
			GridBagConstraints gbc_txtPrice = new GridBagConstraints();
			gbc_txtPrice.gridwidth = 2;
			gbc_txtPrice.insets = new Insets(0, 0, 5, 5);
			gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPrice.gridx = 6;
			gbc_txtPrice.gridy = 1;
			panelInferior.add(getTxtPrice(), gbc_txtPrice);
			GridBagConstraints gbc_textAreaDescripcion = new GridBagConstraints();
			gbc_textAreaDescripcion.gridwidth = 4;
			gbc_textAreaDescripcion.gridheight = 5;
			gbc_textAreaDescripcion.insets = new Insets(0, 0, 0, 5);
			gbc_textAreaDescripcion.fill = GridBagConstraints.BOTH;
			gbc_textAreaDescripcion.gridx = 0;
			gbc_textAreaDescripcion.gridy = 2;
			panelInferior.add(getTextAreaDescripcion(), gbc_textAreaDescripcion);
			GridBagConstraints gbc_lblCuantity = new GridBagConstraints();
			gbc_lblCuantity.insets = new Insets(0, 0, 5, 5);
			gbc_lblCuantity.gridx = 4;
			gbc_lblCuantity.gridy = 2;
			panelInferior.add(getLblCuantity(), gbc_lblCuantity);
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 5;
			gbc_spinner.gridy = 2;
			panelInferior.add(getSpinner(), gbc_spinner);
			GridBagConstraints gbc_btnAdd = new GridBagConstraints();
			gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
			gbc_btnAdd.gridx = 6;
			gbc_btnAdd.gridy = 2;
			panelInferior.add(getBtnAdd(), gbc_btnAdd);
			GridBagConstraints gbc_btnRemove = new GridBagConstraints();
			gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
			gbc_btnRemove.gridx = 7;
			gbc_btnRemove.gridy = 2;
			panelInferior.add(getBtnRemove(), gbc_btnRemove);
			GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
			gbc_lblTotalPrice.gridwidth = 2;
			gbc_lblTotalPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblTotalPrice.gridx = 4;
			gbc_lblTotalPrice.gridy = 3;
			panelInferior.add(getLblTotalPrice(), gbc_lblTotalPrice);
			GridBagConstraints gbc_textFieldTotalPrice = new GridBagConstraints();
			gbc_textFieldTotalPrice.gridwidth = 3;
			gbc_textFieldTotalPrice.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldTotalPrice.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldTotalPrice.gridx = 6;
			gbc_textFieldTotalPrice.gridy = 3;
			panelInferior.add(getTextField_1(), gbc_textFieldTotalPrice);
			GridBagConstraints gbc_btnFinish = new GridBagConstraints();
			gbc_btnFinish.insets = new Insets(0, 0, 0, 5);
			gbc_btnFinish.gridx = 6;
			gbc_btnFinish.gridy = 6;
			panelInferior.add(getBtnFinish(), gbc_btnFinish);
			GridBagConstraints gbc_btnCancel = new GridBagConstraints();
			gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
			gbc_btnCancel.gridx = 7;
			gbc_btnCancel.gridy = 6;
			panelInferior.add(getBtnCancel(), gbc_btnCancel);
		}
		return panelInferior;
	}
	private JPanel getPanelFiltros() {
		if (panelFiltros == null) {
			panelFiltros = new JPanel();
			panelFiltros.add(getLblPriceRange());
			panelFiltros.add(getCheckBoxCheap());
			panelFiltros.add(getCheckBoxMedium());
			panelFiltros.add(getCheckBoxExpensive());
		}
		return panelFiltros;
	}
	private JLabel getLblPriceRange() {
		if (lblPriceRange == null) {
			lblPriceRange = new JLabel("Price range: ");
			lblPriceRange.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblPriceRange;
	}
	private JCheckBox getCheckBoxCheap() {
		if (checkBoxCheap == null) {
			checkBoxCheap = new JCheckBox("< 15\u20AC");
			checkBoxCheap.setSelected(true);
			checkBoxCheap.addActionListener(filtro);
		}
		return checkBoxCheap;
	}
	private JCheckBox getCheckBoxMedium() {
		if (checkBoxMedium == null) {
			checkBoxMedium = new JCheckBox("15\u20AC <= Price <= 40\u20AC");
			checkBoxMedium.setSelected(true);
			checkBoxMedium.addActionListener(filtro);
		}
		return checkBoxMedium;
	}
	private JCheckBox getCheckBoxExpensive() {
		if (checkBoxExpensive == null) {
			checkBoxExpensive = new JCheckBox("> 40\u20AC");
			checkBoxExpensive.setSelected(true);
			checkBoxExpensive.addActionListener(filtro);
		}
		return checkBoxExpensive;
	}
	
	class FiltraLibros implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			updateListaInventario();
			
		}		
	}
	
	public void updateListaInventario() {
		modeloListaInventario.clear();
		fillListaInventario(checkBoxCheap.isSelected(), checkBoxMedium.isSelected(), checkBoxExpensive.isSelected());		
	}
	
	
	private void fillListaInventario(boolean cheap, boolean medium,
			boolean expensive) {
		boolean add = false;
		for(Book b : books){
			add = false;
			if(cheap && b.getPrice() < 15)
				add = true;
			else if (medium && b.getPrice() >= 15 && b.getPrice() <= 40)
				add = true;
			else if (expensive && b.getPrice() > 40)
				add = true;
			
			if(add){
				String aux = b.getTitle();
				modeloListaInventario.addElement(aux);
			}
		}
		
	}

	private JPanel getPanelListas() {
		if (panelListas == null) {
			panelListas = new JPanel();
			panelListas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelListas.add(getListInventario());
			panelListas.add(getListPedido());
		}
		return panelListas;
	}

	private JList getListInventario() {
		if (listInventario == null) {
			listInventario = new JList();
			listInventario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listInventario.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					for(Book b : books){
						if (b.getTitle().equals(listInventario.getSelectedValue())){
							textAreaDescripcion.setEnabled(true);
							textAreaDescripcion.setText(b.getSummary());
							txtISBN.setEnabled(true);
							txtISBN.setText(b.getIsbn());
							txtAuthor.setEnabled(true);
							txtAuthor.setText(b.getAuthor());
							txtEditor.setEnabled(true);
							txtEditor.setText(b.getEditor());
							txtPrice.setEnabled(true);
							txtPrice.setText(b.getPrice() + "€");
						}
					}
					lblCuantity.setEnabled(true);
					lblTotalPrice.setEnabled(true);
					spinner.setEnabled(true);
					btnAdd.setEnabled(true);
					btnRemove.setEnabled(true);
					textFieldTotalPrice.setEnabled(true);
				}
			});
			listInventario.setModel(modeloListaInventario);
		}
		return listInventario;
	}
	private JList getListPedido() {
		if (listPedido == null) {
			listPedido = new JList();
			listPedido.setModel(modeloListaPedidos);
		}
		return listPedido;
	}
	private JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setLineWrap(true);
			textAreaDescripcion.setEnabled(false);
			textAreaDescripcion.setEditable(false);
		}
		return textAreaDescripcion;
	}
	private JTextField getTxtISBN() {
		if (txtISBN == null) {
			txtISBN = new JTextField();
			txtISBN.setEnabled(false);
			txtISBN.setEditable(false);
			txtISBN.setColumns(10);
		}
		return txtISBN;
	}
	private JTextField getTxtEditor() {
		if (txtEditor == null) {
			txtEditor = new JTextField();
			txtEditor.setEnabled(false);
			txtEditor.setEditable(false);
			txtEditor.setColumns(10);
		}
		return txtEditor;
	}
	private JTextField getTxtAuthor() {
		if (txtAuthor == null) {
			txtAuthor = new JTextField();
			txtAuthor.setEnabled(false);
			txtAuthor.setEditable(false);
			txtAuthor.setColumns(10);
		}
		return txtAuthor;
	}
	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setEnabled(false);
			txtPrice.setEditable(false);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}
	private JLabel getLblCuantity() {
		if (lblCuantity == null) {
			lblCuantity = new JLabel("Cuantity:");
			lblCuantity.setEnabled(false);
			lblCuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblCuantity;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setEnabled(false);
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return spinner;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actualizarListaPedidos();
					actualizarPrecioTotal();
				}
			});
			btnAdd.setEnabled(false);
		}
		return btnAdd;
	}
	protected void actualizarPrecioTotal() {
		double total_price = 0;
		for(Pedido p: pedidos){
			total_price += p.getUnits() * p.getPrice();
		}
		textFieldTotalPrice.setText(total_price + "€");
		
	}

	protected void actualizarListaPedidos() {
		Book aux = null;
		for(Book b : books){
			if(b.getTitle().equals(listInventario.getSelectedValue())){
				aux = new Book(b.getIsbn(), b.getTitle(), b.getEditor(), b.getAuthor(), b.getType(), b.getSummary(), b.getPrice());
			}
		}
		boolean existe = false;
		for(Pedido p : pedidos){
			if(p.getTitle() == aux.getTitle()){
				p.setUnits(p.getUnits() + (int) spinner.getValue());
				existe = true;
			}
		}
		if(!existe){
			Pedido aux2 = new Pedido(aux.getIsbn(), aux.getTitle(), aux.getPrice(), (int) spinner.getValue());
			pedidos.add(aux2);
		}
		actualizarPrecioTotal();
		updateListaPedido();
	}

	private void updateListaPedido() {
		modeloListaPedidos.clear();
		for(Pedido p : pedidos){
			String aux = "-TITLE: " + p.getTitle() + " -UNITS: " + p.getUnits() +  " -UNIT PRice: " + p.getPrice();
			modeloListaPedidos.addElement(aux);
		}
		
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					removePedidos();
				}
			});
			btnRemove.setEnabled(false);
		}
		return btnRemove;
	}
	
	public void removePedidos() {
		//Creo el objeto del libro que está seleccionado
		Book b = null;
		for(Book libro : books){
			if(libro.getTitle().equals(listInventario.getSelectedValue())){
				b = new Book(libro.getIsbn(), libro.getTitle(), libro.getEditor(), libro.getAuthor(), libro.getType(), libro.getSummary(), libro.getPrice());
			}
		}
		
		//Creo el pedido conn el libro que quiere borrar
		Pedido p = new Pedido(b.getIsbn(), b.getTitle(), b.getPrice(), (int) spinner.getValue());
		int index = -1;
		boolean eliminar = false;
		
		//Compruebo si existe el pedido para modificarlo
		for(Pedido ped : pedidos){
			if(p.getTitle().equals(ped.getTitle())){
				if(p.getUnits() < ped.getUnits())
					ped.setUnits(ped.getUnits() - p.getUnits());
				else if(p.getUnits() > ped.getUnits())
					JOptionPane.showMessageDialog(null, "It´s impossible to remove such an amount of books");
				else if(p.getUnits() == ped.getUnits()){
					eliminar = true;
					index = pedidos.indexOf(ped);
				}
			}
		}
		//Si borra tantas unidades como había se ha de eliminar el pedido de la lista de pedidos
		if(eliminar){
			pedidos.remove(index);
		}
		//Actualizo todo lo relativo a los pedidos.
		actualizarPrecioTotal();
		updateListaPedido();
	}

	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("Total price:");
			lblTotalPrice.setEnabled(false);
			lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblTotalPrice;
	}
	private JTextField getTextField_1() {
		if (textFieldTotalPrice == null) {
			textFieldTotalPrice = new JTextField();
			textFieldTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
			textFieldTotalPrice.setForeground(Color.RED);
			textFieldTotalPrice.setEnabled(false);
			textFieldTotalPrice.setEditable(false);
			textFieldTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldTotalPrice.setText("0\u20AC");
			textFieldTotalPrice.setColumns(10);
		}
		return textFieldTotalPrice;
	}
	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Finish");
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					grabarFichero();
					reset();
				}
			});
		}
		return btnFinish;
	}
	protected void reset() {
		VentanaInicio vi = new VentanaInicio();
		vi.setVisible(true);
		dispose();
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VentanaInicio vi = new VentanaInicio();
					vi.setVisible(true);
					dispose();
				}
			});
		}
		return btnCancel;
	}
	
	//Leer fichero libros.
	void leerFicheroLibros() {
	    String nombreFichero = "Files/libros.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        Book b = new Book(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], Double.valueOf(trozos[6]));
	        books.add(b);
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
	
	//Graba el fichero de pedidos.
	public void grabarFichero() {
	    String nombreFichero = "Files/Pedidos";
	    String linea="";
		    try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));

		    for(Pedido p: pedidos){
		    	linea = p.getIsbn() + ":" + p.getTitle() + ":" + p.getUnits();
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
			mnFile.setMnemonic('f');
			mnFile.add(getMntmReset());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmReset() {
		if (mntmReset == null) {
			mntmReset = new JMenuItem("Reset");
			mntmReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reset();
				}
			});
			mntmReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		}
		return mntmReset;
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
			mnOptions.setMnemonic('o');
			mnOptions.add(getMntmCheap());
			mnOptions.add(getMntmMedium());
			mnOptions.add(getMntmExpensive());
			mnOptions.add(getSeparator());
			mnOptions.add(getMntmAll());
		}
		return mnOptions;
	}
	private JMenuItem getMntmCheap() {
		if (mntmCheap == null) {
			mntmCheap = new JMenuItem("Cheap");
			mntmCheap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					checkBoxCheap.doClick();
				}
			});
			mntmCheap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		}
		return mntmCheap;
	}
	private JMenuItem getMntmMedium() {
		if (mntmMedium == null) {
			mntmMedium = new JMenuItem("Medium");
			mntmMedium.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					checkBoxMedium.doClick();
				}
			});
			mntmMedium.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
		}
		return mntmMedium;
	}
	private JMenuItem getMntmExpensive() {
		if (mntmExpensive == null) {
			mntmExpensive = new JMenuItem("Expensive");
			mntmExpensive.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					checkBoxExpensive.doClick();
				}
			});
			mntmExpensive.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
		}
		return mntmExpensive;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmAll() {
		if (mntmAll == null) {
			mntmAll = new JMenuItem("All");
			mntmAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!checkBoxCheap.isSelected() || !checkBoxMedium.isSelected() || !checkBoxExpensive.isSelected()){
						checkBoxCheap.setSelected(true);
						checkBoxMedium.setSelected(true);
						checkBoxExpensive.setSelected(true);
					}
					else{
						checkBoxCheap.setSelected(false);
						checkBoxMedium.setSelected(false);
						checkBoxExpensive.setSelected(false);
						updateListaInventario();
					}
				}
			});
			mntmAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		}
		return mntmAll;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('h');
			mnHelp.add(getMntmHelp());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
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
				}
			});
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		}
		return mntmAbout;
	}
	
	void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("Help/Ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			 }

		    catch(Exception e){
		      		System.out.println("Ayuda no encontrada");
		      		return;
		        }

		   HelpBroker hb = hs.createHelpBroker();

		   hb.enableHelpKey(getRootPane(),"html_inicio", hs);
		   hb.enableHelpOnButton(mntmHelp, "Connection", hs);
		   
		 }
	private JLabel getLblIsbn() {
		if (lblIsbn == null) {
			lblIsbn = new JLabel("ISBN: ");
			lblIsbn.setHorizontalAlignment(SwingConstants.LEFT);
			lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblIsbn;
	}
	private JLabel getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new JLabel("Author:");
			lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblAuthor;
	}
	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type:");
			lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblType;
	}
	private JLabel getLblUnitPrice() {
		if (lblUnitPrice == null) {
			lblUnitPrice = new JLabel("Unit Price:");
			lblUnitPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblUnitPrice;
	}
}
