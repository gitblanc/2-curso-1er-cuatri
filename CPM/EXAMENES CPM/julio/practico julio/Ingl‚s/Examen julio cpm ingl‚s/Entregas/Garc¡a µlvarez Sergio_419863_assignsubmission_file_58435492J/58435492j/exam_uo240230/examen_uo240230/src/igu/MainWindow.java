package igu;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import logica.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import io.FileManager;;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FileManager file;
	private ArrayList<Book> books;
	private JPanel pnDesc;
	private JTextArea txADesc;
	private JLabel lblQuantity;
	private JSpinner spQuantity;
	private JButton btnAdd;
	private JLabel lblPrice;
	private JTextField txPrice;
	private JButton btnBuy;
	private JPanel pnBienvenida;
	private JLabel lblWelcome;
	private JPanel pnCentral;
	private JPanel panel;
	private JCheckBox chbMas;
	private JCheckBox chbEntre;
	private JCheckBox chbMenos;
	private JScrollPane scrollPane;
	private JList<Book> list;
	private DefaultListModel<Book> booksModel;
	private String name;
	private String dni;
	private LogIn parent;
	private ArrayList<Book> purchasedBooks = new ArrayList<Book>();
	private ArrayList<Double> totalPrice = new ArrayList<Double>();
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnAyuda;
	private JMenuItem mntmRestart;
	private JSeparator separator;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JMenuItem mntmAyuda;
	private JSeparator separator_1;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public MainWindow(LogIn log, String name, String dni) {
		
		this.parent = log;
		this.name = name;
		this.dni = dni;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/libreria.jpg")));
		setTitle("Libreria EII Oviedo");
		
		// Load Books from file
		file = new FileManager();
		
		books = file.books;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 496);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnDesc(), BorderLayout.SOUTH);
		contentPane.add(getPnWelcome(), BorderLayout.NORTH);
		contentPane.add(getPnCenter(), BorderLayout.CENTER);
		
		// cargarAyuda();
	}
	private JPanel getPnDesc() {
		if (pnDesc == null) {
			pnDesc = new JPanel();
			GridBagLayout gbl_pnDesc = new GridBagLayout();
			gbl_pnDesc.columnWidths = new int[]{289, 71, 59, 71, 0};
			gbl_pnDesc.rowHeights = new int[]{35, 34, 0};
			gbl_pnDesc.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnDesc.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnDesc.setLayout(gbl_pnDesc);
			GridBagConstraints gbc_txADesc = new GridBagConstraints();
			gbc_txADesc.fill = GridBagConstraints.BOTH;
			gbc_txADesc.gridheight = 2;
			gbc_txADesc.insets = new Insets(0, 0, 0, 5);
			gbc_txADesc.gridx = 0;
			gbc_txADesc.gridy = 0;
			
			GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
			gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
			gbc_lblQuantity.gridx = 1;
			gbc_lblQuantity.gridy = 0;
			
			GridBagConstraints gbc_spQuantity = new GridBagConstraints();
			gbc_spQuantity.fill = GridBagConstraints.HORIZONTAL;
			gbc_spQuantity.insets = new Insets(0, 0, 5, 5);
			gbc_spQuantity.gridx = 2;
			gbc_spQuantity.gridy = 0;
			
			GridBagConstraints gbc_btnAdd = new GridBagConstraints();
			gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
			gbc_btnAdd.gridx = 3;
			gbc_btnAdd.gridy = 0;
			
			GridBagConstraints gbc_lblPrice = new GridBagConstraints();
			gbc_lblPrice.insets = new Insets(0, 0, 0, 5);
			gbc_lblPrice.gridx = 1;
			gbc_lblPrice.gridy = 1;
			
			GridBagConstraints gbc_txPrice = new GridBagConstraints();
			gbc_txPrice.fill = GridBagConstraints.HORIZONTAL;
			gbc_txPrice.insets = new Insets(0, 0, 0, 5);
			gbc_txPrice.gridx = 2;
			gbc_txPrice.gridy = 1;
			
			GridBagConstraints gbc_btnBuy = new GridBagConstraints();
			gbc_btnBuy.gridx = 3;
			gbc_btnBuy.gridy = 1;
			
			pnDesc.add(getTxADesc(), gbc_txADesc);
			pnDesc.add(getLblQuantity(), gbc_lblQuantity);
			pnDesc.add(getSpQuantity(), gbc_spQuantity);
			pnDesc.add(getBtnAdd(), gbc_btnAdd);
			pnDesc.add(getLblPrice(), gbc_lblPrice);
			pnDesc.add(getTxPrice(), gbc_txPrice);
			pnDesc.add(getBtnBuy(), gbc_btnBuy);
		}
		return pnDesc;
	}
	private JTextArea getTxADesc() {
		if (txADesc == null) {
			txADesc = new JTextArea();
			txADesc.setWrapStyleWord(true);
			txADesc.setText("");
			txADesc.setLineWrap(true);
			txADesc.setEditable(false);
		}
		return txADesc;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity:");
			lblQuantity.setLabelFor(getSpQuantity());
			lblQuantity.setDisplayedMnemonic('Q');
			lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblQuantity.setEnabled(false);
		}
		return lblQuantity;
	}
	private JSpinner getSpQuantity() {
		if (spQuantity == null) {
			spQuantity = new JSpinner();
			spQuantity.setEnabled(false);
		}
		return spQuantity;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setMnemonic('A');
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updatePrice();
				}

				
			});
			btnAdd.setEnabled(false);
		}
		return btnAdd;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Price:");
			lblPrice.setDisplayedMnemonic('P');
			lblPrice.setLabelFor(getTxPrice());
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPrice.setEnabled(false);
		}
		return lblPrice;
	}
	private JTextField getTxPrice() {
		if (txPrice == null) {
			txPrice = new JTextField();
			txPrice.setText("0 euros");
			txPrice.setEnabled(false);
			txPrice.setEditable(false);
			txPrice.setColumns(10);
		}
		return txPrice;
	}
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Buy");
			btnBuy.setMnemonic('B');
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					grabarFichero();
					JOptionPane.showMessageDialog(null, "Purchase Completed");
					dispose();
					parent = new LogIn();
					parent.setLocationRelativeTo(null);
					parent.setVisible(true);
					
				}
			});
			btnBuy.setEnabled(false);
		}
		return btnBuy;
	}
	private JPanel getPnWelcome() {
		if (pnBienvenida == null) {
			pnBienvenida = new JPanel();
			pnBienvenida.add(getLblWelcome());
		}
		return pnBienvenida;
	}
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome <dynamic>");
			lblWelcome.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		}
		return lblWelcome;
	}
	private JPanel getPnCenter() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setLayout(new BorderLayout(0, 0));
			pnCentral.add(getPanel(), BorderLayout.NORTH);
			pnCentral.add(getScrollPane(), BorderLayout.CENTER);
		}
		return pnCentral;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getChbLessThan());
			panel.add(getChbBetween());
			panel.add(getChbMoreThan());
		}
		return panel;
	}
	private JCheckBox getChbMoreThan() {
		if (chbMas == null) {
			chbMas = new JCheckBox("More 40 $");
			chbMas.setMnemonic('M');
			chbMas.setSelected(true);
			chbMas.addActionListener(new FiltraLibros(getList(), getChbLessThan(), getChbMoreThan(), getChbBetween(), books, booksModel));
		}
		return chbMas;
	}
	private JCheckBox getChbBetween() {
		if (chbEntre == null) {
			chbEntre = new JCheckBox("Between 15 $ - 40 $");
			chbEntre.setMnemonic('B');
			chbEntre.setSelected(true);
			chbEntre.addActionListener(new FiltraLibros(getList(), getChbLessThan(), getChbMoreThan(), getChbBetween(), books, booksModel));
		}
		
		return chbEntre;
	}
	private JCheckBox getChbLessThan() {
		if (chbMenos == null) {
			chbMenos = new JCheckBox("Less 15 $");
			chbMenos.setMnemonic('L');
			chbMenos.setSelected(true);
			chbMenos.addActionListener(new FiltraLibros(getList(), getChbLessThan(), getChbMoreThan(), getChbBetween(), books, booksModel));
		}
		return chbMenos;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JList<Book> getList() {
		if (list == null) {
			list = new JList<Book>();
			booksModel = new DefaultListModel<Book>();
			for(Book l : books){
				booksModel.addElement(l);
			}
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					btnAdd.setEnabled(true);
					btnBuy.setEnabled(true);
					spQuantity.setEnabled(true);
					lblQuantity.setEnabled(true);
					lblPrice.setEnabled(true);
					updateInfo();
				}
			});
			
			list.setModel(booksModel);
		}
		return list;
	}
	
	private void updateInfo() {
		Book book = list.getSelectedValue();
		String aux = book.getTitle();
		Book temp = new Book("", "", "", "", "", "", 1);
		for(Book l : books){
			if(l.getTitle().equals(aux))
				temp = l;
		}
		txADesc.setText("Author: " + temp.getAuthor() + "\n" +
						"Editor: " + temp.getEditor() + "\n" +
						"Type: " + temp.getType() + "\n" + 
						"Summary: " + temp.getSummary() + "\n" + 
						"Price: " + temp.getPrice() + "\n");
		
	}
	
	private void updatePrice() {
		Book book = list.getSelectedValue();
		String aux = book.getTitle();
		Book temp = new Book("", "", "", "", "", "", 1);
		for(Book l : books){
			if(l.getTitle().equals(aux))
				temp = l;
		}
		purchasedBooks.add(temp);
		int units = (int) spQuantity.getValue();
		double auxprice = (temp.getPrice()*units);
		temp.setQuantity(units);
		totalPrice.add(auxprice);
		double auxprice2 = totalPrice();
		txPrice.setText(String.valueOf(auxprice2));
		
	}
	
	private double totalPrice() {
		double aux = 0.0;
		for(Double p : totalPrice){
			aux+=p;
		}
		return aux;
	}
	
	public void grabarFichero() {
		String nombreFichero = dni + ".dat";
		String linea = "";
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(
					nombreFichero));
			fichero.write(linea);
			fichero.newLine(); // Si se quiere añadir un salto de línea
			for (Book book : purchasedBooks) {
				fichero.write(book.getIsbn()+"	");
				fichero.write(book.getTitle() + "	, Quantity: ");
				String aux = String.valueOf(book.getQuantity());
				System.out.println(aux);
				fichero.write(aux);
				fichero.newLine();
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.setMnemonic('F');
			mnFile.add(getMntmRestart());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Help");
			mnAyuda.setMnemonic('H');
			mnAyuda.add(getMntmHelp());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMntmAbout());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmRestart() {
		if (mntmRestart == null) {
			mntmRestart = new JMenuItem("Restart");
			mntmRestart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					parent = new LogIn();
					parent.setLocationRelativeTo(null);
					parent.setVisible(true);
				}
			});
			mntmRestart.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		}
		return mntmRestart;
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
					System.exit(-1);
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About...");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "UO240230 Sergio Garcia Alvarez");
				}
			});
		}
		return mntmAbout;
	}
	private JMenuItem getMntmHelp() {
		if (mntmAyuda == null) {
			mntmAyuda = new JMenuItem("Help...");
			mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmAyuda;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	
	/*
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
		   hb.enableHelpOnButton(componente, "html_inicio", hs);
		   
		 }
	
	*/

}
