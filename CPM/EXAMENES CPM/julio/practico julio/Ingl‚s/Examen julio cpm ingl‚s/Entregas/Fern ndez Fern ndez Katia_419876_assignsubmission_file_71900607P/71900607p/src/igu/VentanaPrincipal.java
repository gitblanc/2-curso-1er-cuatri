package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.Book;
import logic.Bookstore;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel pnWelcome;
	private JLabel lblIcon;
	private JScrollPane scPnWelcomeText;
	private JTextArea txAWelcomeTest;
	private JMenuBar menuBar;
	private JMenu mnApplication;
	private JMenuItem mntmNew;
	private JMenuItem mntmExit;
	private JSeparator separatorApplication;
	private JMenu mnHelp;
	private JMenuItem mntmContents;
	private JMenuItem mntmAbout;
	private JSeparator separatorHelp;
	private JPanel pnSouth;
	private JButton btnCancel;
	private JButton btnBuy;
	private JPanel pnCenter;
	private JPanel pnBook;
	private JPanel pnFilter;
	private JCheckBox chbxUntil15;
	private JCheckBox chckbxUntil40;
	private JCheckBox chckbxAbove40;
	private JPanel pnShowBooks;
	private JPanel pnLabel;
	private JLabel lblAllBooks;
	private JScrollPane scPnBooks;
	private JScrollPane scPnData;
	private JTextArea txAData;
	private JPanel pnSelection;
	private JScrollPane scPnOrder;
	private JPanel pnAddPrice;
	private JButton btnAdd;
	private JTextField txPrice;
	private JList<String> listOrder;
	
	private DefaultListModel<String> modeloLibros;
	private DefaultListModel<String> showModel;
	
	private List<Book> books;

	private JPanel pnNumber;
	private JLabel lblNumberOfBooks;
	private JSpinner spinBooks;
	private JList<String> listBooks;

	private float total = 0;

	private ArrayList<Book> boughtBooks = new ArrayList<Book>();
	
	private String name;
	private String dni;
	
	private VentanaRegistro vR;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPrincipal frame = new VentanaPrincipal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(VentanaRegistro vR, String name, String dni) {	
		this.vR = vR;
		this.name = name;
		this.dni = dni;
		initialize();
		cargaAyuda();
	}
	
	public void initialize(){
		
		books = Bookstore.getAllBooks();
		
		setBackground(new Color(255, 250, 205));
		setTitle("Oviedo book store");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 461);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnWelcome(), BorderLayout.NORTH);
		contentPane.add(getPnSouth(), BorderLayout.SOUTH);
		contentPane.add(getPnCenter(), BorderLayout.CENTER);
		contentPane.add(getPnSelection(), BorderLayout.EAST);
		
		setLocationRelativeTo(null);
		
		getRootPane().setDefaultButton(btnBuy);
		selectAllCheckboxes();
		addElementInList(getChbxUntil15().isSelected(), getChckbxUntil40().isSelected(), getChckbsAbove40().isSelected());	
		listBooks.setSelectedIndex(0);
		spinBooks.setValue(1);
		showModel = new DefaultListModel<>();
		txPrice.setText("");
		listOrder.setModel(showModel);
		
		validate();
	}
	
	public void selectAllCheckboxes(){
		chbxUntil15.setSelected(true);
		chckbxUntil40.setSelected(true);
		chckbxAbove40.setSelected(true);
	}
	
	private JPanel getPnWelcome() {
		if (pnWelcome == null) {
			pnWelcome = new JPanel();
			pnWelcome.setBackground(new Color(255, 250, 205));
			pnWelcome.setLayout(new BorderLayout(20, 0));
			pnWelcome.add(getLblIcon(), BorderLayout.WEST);
			pnWelcome.add(getScPnWelcomeText(), BorderLayout.CENTER);
		}
		return pnWelcome;
	}
	private JLabel getLblIcon() {
		if (lblIcon == null) {
			lblIcon = new JLabel("");
			lblIcon.setToolTipText("Book store icon");
			lblIcon.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		}
		return lblIcon;
	}
	private JScrollPane getScPnWelcomeText() {
		if (scPnWelcomeText == null) {
			scPnWelcomeText = new JScrollPane();
			scPnWelcomeText.setBorder(null);
			scPnWelcomeText.setBackground(new Color(255, 250, 205));
			scPnWelcomeText.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			scPnWelcomeText.setViewportView(getTxAWelcomeTest());
		}
		return scPnWelcomeText;
	}
	private JTextArea getTxAWelcomeTest() {
		if (txAWelcomeTest == null) {
			txAWelcomeTest = new JTextArea();
			txAWelcomeTest.setToolTipText("Welcome message");
			txAWelcomeTest.setLineWrap(true);
			txAWelcomeTest.setWrapStyleWord(true);
			txAWelcomeTest.setBackground(new Color(255, 250, 205));
			txAWelcomeTest.setBorder(null);
			txAWelcomeTest.setFont(new Font("Segoe UI", Font.BOLD, 16));
			txAWelcomeTest.setEditable(false);
			txAWelcomeTest.setText("Welcome to the book store " + name);
		}
		return txAWelcomeTest;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(255, 255, 255));
			menuBar.add(getMnApplication());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnApplication() {
		if (mnApplication == null) {
			mnApplication = new JMenu("Application");
			mnApplication.setMnemonic('A');
			mnApplication.setBackground(new Color(255, 255, 255));
			mnApplication.add(getMntmNew());
			mnApplication.add(getSeparatorApplication());
			mnApplication.add(getMntmExit());
		}
		return mnApplication;
	}
	private JMenuItem getMntmNew() {
		if (mntmNew == null) {
			mntmNew = new JMenuItem("New");
			mntmNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					initialize();
				}
			});
			mntmNew.setMnemonic('N');
			mntmNew.setBackground(new Color(255, 255, 255));
			mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		}
		return mntmNew;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mntmExit.setMnemonic('X');
			mntmExit.setBackground(new Color(255, 255, 255));
		}
		return mntmExit;
	}
	private JSeparator getSeparatorApplication() {
		if (separatorApplication == null) {
			separatorApplication = new JSeparator();
		}
		return separatorApplication;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setBackground(new Color(255, 255, 255));
			mnHelp.setMnemonic('H');
			mnHelp.add(getMntmContents());
			mnHelp.add(getSeparatorHelp());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents.setMnemonic('C');
			mntmContents.setBackground(new Color(255, 255, 255));
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContents;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setMnemonic('B');
			mntmAbout.setBackground(new Color(255, 255, 255));
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Oviedo book store \n" +
							"Human-Computer Interaction \nJune 2016 \nEUITIO Oviedo" , "About Oviedo book store", 1);
				}
			});
		}
		return mntmAbout;
	}
	private JSeparator getSeparatorHelp() {
		if (separatorHelp == null) {
			separatorHelp = new JSeparator();
		}
		return separatorHelp;
	}
	private JPanel getPnSouth() {
		if (pnSouth == null) {
			pnSouth = new JPanel();
			pnSouth.setBackground(new Color(255, 250, 205));
			pnSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
			pnSouth.add(getBtnBuy());
			pnSouth.add(getBtnCancel());
		}
		return pnSouth;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					initialize();
				}
			});
			btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnCancel.setBackground(new Color(255, 255, 255));
		}
		return btnCancel;
	}
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Buy");
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(txPrice.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Select your order and press 'Add' button before buying.");	
					}else{
						grabarFichero();
						JOptionPane.showMessageDialog(null, "Your purchase has been correctly processed.");	
						dispose();
						vR = new VentanaRegistro();
						vR.setLocationRelativeTo(null);
						vR.setModal(true);
						vR.setVisible(true);
					}
				}
			});
			btnBuy.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnBuy.setBackground(new Color(255, 255, 255));
		}
		return btnBuy;
	}
	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setBackground(new Color(255, 250, 205));
			pnCenter.setLayout(new BorderLayout(0, 0));
			pnCenter.add(getPnBook());
		}
		return pnCenter;
	}
	private JPanel getPnBook() {
		if (pnBook == null) {
			pnBook = new JPanel();
			pnBook.setBackground(new Color(255, 250, 205));
			pnBook.setLayout(new BorderLayout(0, 6));
			pnBook.add(getPnFilter(), BorderLayout.NORTH);
			pnBook.add(getPnShowBooks(), BorderLayout.CENTER);
			pnBook.add(getScPnData(), BorderLayout.SOUTH);
		}
		return pnBook;
	}
	private JPanel getPnFilter() {
		if (pnFilter == null) {
			pnFilter = new JPanel();
			pnFilter.setBackground(new Color(255, 250, 205));
			pnFilter.add(getChbxUntil15());
			pnFilter.add(getChckbxUntil40());
			pnFilter.add(getChckbsAbove40());
		}
		return pnFilter;
	}
	private JCheckBox getChbxUntil15() {
		if (chbxUntil15 == null) {
			chbxUntil15 = new JCheckBox("Cheap (<15\u20AC)");
			chbxUntil15.setSelected(true);
			chbxUntil15.setMnemonic('E');
			chbxUntil15.setToolTipText("Books under 15 euros ");
			chbxUntil15.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			chbxUntil15.setBackground(new Color(255, 250, 205));
			chbxUntil15.addActionListener(new FiltraLibros(getListBooks(), chbxUntil15, getChckbxUntil40(), getChckbsAbove40(), modeloLibros));

		}
		return chbxUntil15;
	}
	private JCheckBox getChckbxUntil40() {
		if (chckbxUntil40 == null) {
			chckbxUntil40 = new JCheckBox("Medium (15-40\u20AC)");
			chckbxUntil40.setSelected(true);
			chckbxUntil40.setMnemonic('M');
			chckbxUntil40.setToolTipText("Books between 15 and 40 euros(both included)");
			chckbxUntil40.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			chckbxUntil40.setBackground(new Color(255, 250, 205));
			chckbxUntil40.addActionListener(new FiltraLibros(getListBooks(), getChbxUntil15(), chckbxUntil40, getChckbsAbove40(), modeloLibros));
	
		}
		return chckbxUntil40;
	}
	private JCheckBox getChckbsAbove40() {
		if (chckbxAbove40 == null) {
			chckbxAbove40 = new JCheckBox("Expensive(>40\u20AC)");
			chckbxAbove40.setSelected(true);
			chckbxAbove40.setMnemonic('P');
			chckbxAbove40.setToolTipText("Books more expensive than 40 euros");
			chckbxAbove40.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			chckbxAbove40.setBackground(new Color(255, 250, 205));
			chckbxAbove40.addActionListener(new FiltraLibros(getListBooks(), getChbxUntil15(), getChckbxUntil40(), chckbxAbove40, modeloLibros));
		
		}
		return chckbxAbove40;
	}
	private JPanel getPnShowBooks() {
		if (pnShowBooks == null) {
			pnShowBooks = new JPanel();
			pnShowBooks.setBackground(new Color(255, 250, 205));
			pnShowBooks.setLayout(new BorderLayout(0, 0));
			pnShowBooks.add(getPnLabel(), BorderLayout.NORTH);
			pnShowBooks.add(getScPnBooks(), BorderLayout.CENTER);
		}
		return pnShowBooks;
	}
	private JPanel getPnLabel() {
		if (pnLabel == null) {
			pnLabel = new JPanel();
			pnLabel.setBackground(new Color(255, 250, 205));
			pnLabel.setLayout(new BorderLayout(0, 0));
			pnLabel.add(getLblAllBooks(), BorderLayout.WEST);
		}
		return pnLabel;
	}
	private JLabel getLblAllBooks() {
		if (lblAllBooks == null) {
			lblAllBooks = new JLabel("All books:");
			lblAllBooks.setLabelFor(getListBooks());
			lblAllBooks.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblAllBooks.setDisplayedMnemonic('L');
			lblAllBooks.setBackground(new Color(255, 250, 205));
		}
		return lblAllBooks;
	}
	private JScrollPane getScPnBooks() {
		if (scPnBooks == null) {
			scPnBooks = new JScrollPane();
			scPnBooks.setBackground(new Color(255, 250, 205));
			scPnBooks.setViewportView(getListBooks());
		}
		return scPnBooks;
	}
	private JScrollPane getScPnData() {
		if (scPnData == null) {
			scPnData = new JScrollPane();
			scPnData.setViewportView(getTxAData());
		}
		return scPnData;
	}
	private JTextArea getTxAData() {
		if (txAData == null) {
			txAData = new JTextArea();
			txAData.setRows(5);
			txAData.setLineWrap(true);
			txAData.setWrapStyleWord(true);
			txAData.setToolTipText("Data of the selected book");
			txAData.setEditable(false);
			txAData.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		}
		return txAData;
	}
	private JPanel getPnSelection() {
		if (pnSelection == null) {
			pnSelection = new JPanel();
			pnSelection.setBackground(new Color(255, 250, 205));
			pnSelection.setLayout(new BorderLayout(0, 0));
			pnSelection.add(getScPnOrder(), BorderLayout.NORTH);
			pnSelection.add(getPnAddPrice(), BorderLayout.SOUTH);
			pnSelection.add(getPnNumber(), BorderLayout.CENTER);
		}
		return pnSelection;
	}
	private JScrollPane getScPnOrder() {
		if (scPnOrder == null) {
			scPnOrder = new JScrollPane();
			scPnOrder.setBorder(null);
			scPnOrder.setViewportView(getListOrder());
		}
		return scPnOrder;
	}
	private JPanel getPnAddPrice() {
		if (pnAddPrice == null) {
			pnAddPrice = new JPanel();
			pnAddPrice.setBackground(new Color(255, 250, 205));
			pnAddPrice.add(getBtnAdd());
			pnAddPrice.add(getTxPrice());
		}
		return pnAddPrice;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String title = (String) listBooks.getSelectedValue();
					
					Book selected = new Book("", "", "","","","",0);
					
					for(Book b : books){
						if(b.getTitle().equals(title)){
							selected = b;
						}
					}
					
					if(selected.getPrice() == 0.0){
						JOptionPane.showMessageDialog(null, "Select a book.");
					}else{
						String purchasedBook = selected.getTitle() + ", "+ selected.getPrice() + " €, "
								+ spinBooks.getValue()+" units.";
						showModel.addElement(purchasedBook);
						txPrice.setText(calculatePrice() + " €");
						
						boughtBooks.add(selected);
						int units = (int) spinBooks.getValue();
						selected.setUnits(units);
					}
				}
			});
			btnAdd.setToolTipText("Add the selected book to the shopping cart.");
			btnAdd.setMnemonic('D');
			btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			btnAdd.setBackground(new Color(255, 255, 255));
		}
		return btnAdd;
	}
	private JTextField getTxPrice() {
		if (txPrice == null) {
			txPrice = new JTextField();
			txPrice.setBackground(new Color(255, 255, 255));
			txPrice.setToolTipText("Total price");
			txPrice.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			txPrice.setEditable(false);
			txPrice.setColumns(10);
		}
		return txPrice;
	}
	private JList<String> getListOrder() {
		if (listOrder == null) {
			showModel = new DefaultListModel<String>();
			listOrder = new JList<String>(showModel);
			listOrder.setToolTipText("Books in the shopping cart");
			listOrder.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			listOrder.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Shopping cart", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		}
		return listOrder;
	}
	
	private JPanel getPnNumber() {
		if (pnNumber == null) {
			pnNumber = new JPanel();
			pnNumber.setBackground(new Color(255, 250, 205));
			pnNumber.add(getLblNumberOfBooks());
			pnNumber.add(getSpinBooks());
		}
		return pnNumber;
	}
	private JLabel getLblNumberOfBooks() {
		if (lblNumberOfBooks == null) {
			lblNumberOfBooks = new JLabel("Number of books:");
			lblNumberOfBooks.setLabelFor(getSpinBooks());
			lblNumberOfBooks.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblNumberOfBooks.setDisplayedMnemonic('K');
			lblNumberOfBooks.setBackground(new Color(255, 250, 205));
		}
		return lblNumberOfBooks;
	}
	private JSpinner getSpinBooks() {
		if (spinBooks == null) {
			spinBooks = new JSpinner();
			spinBooks.setToolTipText("Select the number of books");
			spinBooks.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinBooks.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			spinBooks.setBackground(new Color(255, 255, 255));
		}
		return spinBooks;
	}
	private JList<String> getListBooks() {
		if (listBooks == null) {
			listBooks = new JList<String>();
			listBooks.setToolTipText("Available books");
			listBooks.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					showData();
					spinBooks.setValue(1);
				}
			});
			
			listBooks.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			modeloLibros = new DefaultListModel<>();
			
			listBooks.setModel(modeloLibros);
		}
		return listBooks;
	}
	
	public void showData(){
		String title = (String) listBooks.getSelectedValue();
		Book book = new Book("", "", "","","","",0);
		
		for(Book b : books){
			if(b.getTitle().equals(title)){
				book = b;
			}
		}
		
		txAData.setText(book.getInformation());
	}

	
	public void addElementInList(boolean check1, boolean check2, boolean check3){
		
		for(Book b : books){
			if(check1 && (b.getPrice()<15.0) || check2 && (b.getPrice()>=15.0) && (b.getPrice()<=40.0) 
					|| check3 && (b.getPrice()>40.0)){
				String title = b.getTitle();
				modeloLibros.addElement(title);
			}
		}
	}
	
	public float calculatePrice(){
		
		float number = (int) spinBooks.getValue();
		
		String title = (String) listBooks.getSelectedValue();
		Book selected = new Book("", "", "","","","",0);
		
		for(Book b : books){
			if(b.getTitle().equals(title)){
				selected = b;
			}
		}
		
		total += number * selected.getPrice();
		
		return total;
		
	}

	public void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			 }

		    catch(Exception e){
		      		System.out.println("Help not found.");
		      		return;
		        }

		   HelpBroker hb = hs.createHelpBroker();

		   hb.enableHelpKey(getRootPane(),"intro", hs);
		   hb.enableHelpOnButton(mntmContents, "intro", hs);
	 }
	
	public void grabarFichero() {
		String nombreFichero = "files/" + dni + ".dat";
		String linea = "";
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
			fichero.write(linea);
			for (Book b : boughtBooks) {
				fichero.write("ISBN: " + b.getISBN());
				fichero.newLine();
				fichero.write("TITLE: " + b.getTitle());
				fichero.newLine();
				String aux = String.valueOf(b.getUnits());
				fichero.write("UNITS: " + aux);
				fichero.newLine();
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File cannot been saved.");
		} catch (IOException e) {
			new RuntimeException("Input/output error.");
		}
	}
}