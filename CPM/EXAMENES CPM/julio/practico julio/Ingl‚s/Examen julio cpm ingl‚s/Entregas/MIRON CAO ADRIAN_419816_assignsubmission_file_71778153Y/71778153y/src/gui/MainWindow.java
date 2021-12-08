package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.io.*;
import java.util.ArrayList;

import logic.Book;
import logic.Client;
import logic.Order;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.help.*;

import java.net.*;
import java.awt.event.MouseAdapter;

import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel pnLogoWelc;
	private JLabel lblLogo;
	private JLabel lblWelc;
	private JPanel pnListOrder;
	private JSplitPane splitPane;
	private JScrollPane scrollPaneList;
	private JList listBooks;
	private DefaultListModel listModel = new DefaultListModel();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Book> booksaux = new ArrayList<Book>();
	private JScrollPane scrollPaneOrder;
	private JTextArea textOrder;
	private JComboBox comboPrices;
	private DefaultComboBoxModel comboModel;
	private String[] comboValues = new String[] {"Select a price range" ,"Less than 15 euros", "Between 15 and 40 euros", "More than 40 euros"};
	private JPanel pnButtonsDesc;
	private FiltraLibros fl;
	private JTextArea textDesc;
	private JPanel pnButtons;
	private JButton btnAdd;
	private JButton btnRemove;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JButton btnConfirm;
	private JScrollPane scrollDesc;
	private Order order;
	private Client cl;
	private MainWindow ref = this;
	private JMenuBar menuBar;
	private JMenu menuBook;
	private JMenuItem mntmAdd;
	private JMenuItem mntmRemove;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem;
	private JMenu menuHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmGuide;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		cargaAyuda();
		fl=new FiltraLibros();
		order=new Order();
		leerFichero();
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/libreria.jpg")));
		handleLogin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnLogoWelc(), BorderLayout.NORTH);
		contentPane.add(getPnListOrder(), BorderLayout.CENTER);
		contentPane.add(getPnButtonsDesc(), BorderLayout.SOUTH);
	}
	
	void leerFichero() {
	    String nombreFichero = "files/libros.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        books.add(new Book(trozos[0],trozos[1],trozos[2],trozos[3],trozos[4],trozos[5],trozos[6]));
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

		   hb.enableHelpKey(getRootPane(),"intro", hs);
		   hb.enableHelpOnButton(getMntmGuide(), "intro", hs);
		   
		 }
	
	private void handleLogin()
	{
		LoginDialog dialogo = new LoginDialog(this);
		dialogo.setLocationRelativeTo(null);
		dialogo.setModal(true);
		dialogo.setVisible(true);
	}

	private JPanel getPnLogoWelc() {
		if (pnLogoWelc == null) {
			pnLogoWelc = new JPanel();
			pnLogoWelc.add(getLblLogo());
			pnLogoWelc.add(getLblWelc());
		}
		return pnLogoWelc;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/img/libreria.jpg")));
		}
		return lblLogo;
	}
	public JLabel getLblWelc() {
		if (lblWelc == null) {
			lblWelc = new JLabel("");
			lblWelc.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblWelc;
	}
	private JPanel getPnListOrder() {
		if (pnListOrder == null) {
			pnListOrder = new JPanel();
			pnListOrder.setLayout(new BorderLayout(0, 0));
			pnListOrder.add(getSplitPane());
			pnListOrder.add(getComboPrices(), BorderLayout.NORTH);
		}
		return pnListOrder;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getScrollPaneList());
			splitPane.setRightComponent(getScrollPaneOrder());
		}
		return splitPane;
	}
	private JScrollPane getScrollPaneList() {
		if (scrollPaneList == null) {
			scrollPaneList = new JScrollPane();
			scrollPaneList.setViewportView(getListBooks());
		}
		return scrollPaneList;
	}
	private JList getListBooks() {
		if (listBooks == null) {
			listBooks = new JList();
			listBooks.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					updateDescription();
				}
			});
			for(Book each: books)
			{
				listModel.addElement(each.getTitle());
				booksaux.add(each);
			}
			listBooks.setModel(listModel);
		}
		
		return listBooks;
	}
	
	private void updateDescription()
	{
		if(listBooks.getSelectedIndex()!=-1)
		{
			Book b = booksaux.get(listBooks.getSelectedIndex());
			textDesc.setText("Author: "+b.getAuthor() + "\nEditor: " + b.getEditor() +
					"\nType:" + b.getType() + "\nPrecio:"+ b.getPrice() + "\nSummary:"+ b.getSummary() );
		}
	}
	
	private JScrollPane getScrollPaneOrder() {
		if (scrollPaneOrder == null) {
			scrollPaneOrder = new JScrollPane();
			scrollPaneOrder.setViewportView(getTextOrder());
		}
		return scrollPaneOrder;
	}
	private JTextArea getTextOrder() {
		if (textOrder == null) {
			textOrder = new JTextArea();
			textOrder.setLineWrap(true);
			textOrder.setWrapStyleWord(true);
			textOrder.setEditable(false);
		}
		return textOrder;
	}
	
	private JScrollPane getScrollDesc()
	{
		if(scrollDesc == null)
		{
			scrollDesc = new JScrollPane(getTextDesc());
			scrollDesc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
		return scrollDesc;
	}
	private JComboBox getComboPrices() {
		if (comboPrices == null) {
			comboPrices = new JComboBox();
			comboPrices.setToolTipText("Filter the booklist by selecting a price range");
			comboModel= new DefaultComboBoxModel(comboValues);
			comboPrices.setModel(comboModel);
			comboPrices.addActionListener(fl);
		}
		return comboPrices;
	}
	private JPanel getPnButtonsDesc() {
		if (pnButtonsDesc == null) {
			pnButtonsDesc = new JPanel();
			pnButtonsDesc.setLayout(new BorderLayout(0, 0));
			pnButtonsDesc.add(getScrollDesc(), BorderLayout.NORTH);
			pnButtonsDesc.add(getPnButtons(), BorderLayout.SOUTH);
		}
		return pnButtonsDesc;
	}
	
	class FiltraLibros implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			refreshList();
		}
	}
	
	private void refreshList()
	{
		listBooks.clearSelection();
		listModel.clear();
		if(comboPrices.getSelectedItem()==comboValues[0])
		{
			for(Book each: books)
			{
				listModel.addElement(each.getTitle());
				booksaux.add(each);
			}
		}
		else if (comboPrices.getSelectedItem()==comboValues[1])
		{
			for(Book each: books)
			{
				if(Float.parseFloat(each.getPrice())<15)
				{
					listModel.addElement(each.getTitle());
					booksaux.add(each);
				}
			}
		}
		else if( comboPrices.getSelectedItem()==comboValues[2])
		{
			for(Book each: books)
			{
				if(Float.parseFloat(each.getPrice())>=15 && Float.parseFloat(each.getPrice())<=40)
				{
					listModel.addElement(each.getTitle());
					booksaux.add(each);
				}
			}
		}
		else if (comboPrices.getSelectedItem()==comboValues[3])
		{
			for(Book each: books)
			{
				if(Float.parseFloat(each.getPrice())>40 )
				{
					listModel.addElement(each.getTitle());
					booksaux.add(each);
				}
			}
		}
	}
	private JTextArea getTextDesc() {
		if (textDesc == null) {
			textDesc = new JTextArea();
			textDesc.setLineWrap(true);
			textDesc.setRows(4);
		}
		return textDesc;
	}
	private JPanel getPnButtons() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.add(getBtnAdd());
			pnButtons.add(getBtnRemove());
			pnButtons.add(getLblTotal());
			pnButtons.add(getTextTotal());
			pnButtons.add(getBtnConfirm());
		}
		return pnButtons;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add book");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addBook();
				}
			});
			btnAdd.setToolTipText("Click this button to add a book to the cart");
		}
		return btnAdd;
	}
	
	private void addBook()
	{
		Book b;
		if(listBooks.getSelectedIndex()!=-1)
		{
			b= booksaux.get(listBooks.getSelectedIndex());
			order.add(b);
			textTotal.setText(order.getPrice()+"");
			textOrder.setText(order.getShoppingCart());
			btnConfirm.setEnabled(true);
		}
	}
	
	private void removeBook()
	{
		Book b;
		if(listBooks.getSelectedIndex()!=-1)
		{
			b=booksaux.get(listBooks.getSelectedIndex());
			order.remove(b);
			textTotal.setText(order.getPrice()+"");
			textOrder.setText(order.getShoppingCart());
			if(order.getPrice()==0)
				btnConfirm.setEnabled(false);
		}
	}
	
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove book");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					removeBook();
				}
			});
			btnRemove.setToolTipText("Click this button to remove a book from the cart");
		}
		return btnRemove;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total price:");
			lblTotal.setLabelFor(getTextTotal());
		}
		return lblTotal;
	}
	private JTextField getTextTotal() {
		if (textTotal == null) {
			textTotal = new JTextField();
			textTotal.setEditable(false);
			textTotal.setColumns(10);
		}
		return textTotal;
	}
	private JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton("Confirm");
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					saveOrder();
					ref.initialize();
					handleLogin();
				}
			});
			btnConfirm.setEnabled(false);
			btnConfirm.setToolTipText("Confirm your order");
		}
		return btnConfirm;
	}
	
	private void saveOrder()
	{
		if(cl!=null)
			order.grabarFichero(cl);
	}
	
	private void initialize()
	{
		lblWelc.setText("");
		listBooks.clearSelection();
		listModel.clear();
		refreshList();
		textDesc.setText("");
		textOrder.setText("");
		textTotal.setText("");
		btnConfirm.setEnabled(false);
		this.setVisible(false);
	}
	
	public Client getCl() {
		return cl;
	}

	public void setCl(Client cl) {
		this.cl = cl;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuBook());
			menuBar.add(getMenuHelp());
		}
		return menuBar;
	}
	private JMenu getMenuBook() {
		if (menuBook == null) {
			menuBook = new JMenu("Book");
			menuBook.add(getMntmAdd());
			menuBook.add(getMntmRemove());
			menuBook.add(getSeparator());
			menuBook.add(getMntmNewMenuItem());
		}
		return menuBook;
	}
	private JMenuItem getMntmAdd() {
		if (mntmAdd == null) {
			mntmAdd = new JMenuItem("Add");
			mntmAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnAdd.doClick();
				}
			});
			mntmAdd.setMnemonic('d');
		}
		return mntmAdd;
	}
	private JMenuItem getMntmRemove() {
		if (mntmRemove == null) {
			mntmRemove = new JMenuItem("Remove");
			mntmRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnRemove.doClick();
				}
			});
			mntmRemove.setMnemonic('r');
		}
		return mntmRemove;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Exit");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ref.dispose();
				}
			});
			mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmNewMenuItem.setMnemonic('x');
		}
		return mntmNewMenuItem;
	}
	private JMenu getMenuHelp() {
		if (menuHelp == null) {
			menuHelp = new JMenu("Help");
			menuHelp.add(getMntmAbout());
			menuHelp.add(getMntmGuide());
		}
		return menuHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Application created by Adrián Mirón for the CPM final exam");
				}
			});
			mntmAbout.setMnemonic('t');
		}
		return mntmAbout;
	}
	private JMenuItem getMntmGuide() {
		if (mntmGuide == null) {
			mntmGuide = new JMenuItem("Guide");
			mntmGuide.setMnemonic('g');
			mntmGuide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmGuide;
	}
}
