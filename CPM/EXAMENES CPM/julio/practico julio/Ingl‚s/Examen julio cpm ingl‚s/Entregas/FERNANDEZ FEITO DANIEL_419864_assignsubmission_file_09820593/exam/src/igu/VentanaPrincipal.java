package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.help.*;

import java.io.File;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Book;
import logica.BookStore;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelTitle;
	private JLabel label;
	private JLabel lblWelcome;
	private JPanel panelButtons;
	private JButton btnBuy;
	private JButton btnCancel;
	private JPanel panelCenter;
	private JPanel panelBooks;
	private JPanel panelSelected;
	private JPanel panelExtra;
	private JList listBook;
	private JTextArea textAreaDescription;
	private JPanel panelAdd;
	private JButton btnAdd;
	private JSpinner spinner;
	private JPanel panel;
	private JCheckBox chckbxlower;
	private JCheckBox chckbxbetween;
	private JCheckBox chckbxgreater;
	private JList listSelected;
	private JPanel panelPrice;
	private JLabel lblTotalPrice;
	private JTextField textField;
	private JMenuBar menuBar;
	private JMenu mnBookstore;
	private JMenuItem mntmReset;
	private JMenuItem mntmExit;
	private JMenu mnOptions;
	private JMenu mnFilter;
	private JMenuItem menuItem15;
	private JMenuItem menuItem1540;
	private JMenuItem menuItem40;
	private JMenu mnHelp;
	private JMenuItem mntmContents;
	private JMenuItem mntmAbout;

	private VentanaDialogo vD;
	private BookStore bS;
	private String id;
	private ArrayList<Book> selectedBooks;
	private VentanaPrincipal ref;
	private DefaultListModel model1;
	private DefaultListModel model2;
	private Filter filter;
	private String client;
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(VentanaDialogo parent, BookStore bs, String client, String id) {
		
		this.client = client;
		filter = new Filter();
		model1 = new DefaultListModel();
		model2 = new DefaultListModel();
		selectedBooks = new ArrayList<Book>();
		this.id = id;
		this.bS = bs;
		this.ref = this;
		vD = parent;
		parent.dispose();
		
		setTitle("Book Store EII Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/libreria.jpg")));		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		setLocationRelativeTo(null);
		setVisible(true);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelTitle(), BorderLayout.NORTH);
		contentPane.add(getPanelButtons(), BorderLayout.SOUTH);
		contentPane.add(getPanelCenter(), BorderLayout.CENTER);
		
		updateList();
		cargaAyuda();
	}
	
	public void updateList(){
		model1.clear();
		loadList(chckbxlower.isSelected(), chckbxbetween.isSelected(), chckbxgreater.isSelected());
	}
	
	public void loadList(boolean lower, boolean between, boolean greater){
		if(lower || between || greater){
			boolean isAdd;			
			for(Book b: bS.getBooks()){
				isAdd = false;
				if(lower && b.getPrice()<15){
					isAdd = true;
				}
				if(between && b.getPrice()>=15 && b.getPrice()<=40){
					isAdd = true;
				}
				if(greater && b.getPrice()>40){
					isAdd = true;
				}
				
				if(isAdd){
					model1.addElement(b.getTitle());
				}
			}
		}
	}
	
	class Filter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			updateList();
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

		   hb.enableHelpKey(getRootPane(), "Intro", hs);
		   hb.enableHelpOnButton(mntmContents, "Intro", hs);
		   hb.enableHelp(panelBooks, "Lists", hs);
		   hb.enableHelp(panelButtons, "Buy", hs);
		   hb.enableHelp(panelSelected, "Lists", hs);
		   hb.enableHelp(panelExtra, "Filter", hs);
		 }
	
	public void reset(){
		textAreaDescription.setText("");
		spinner.setValue(1);
		spinner.setEnabled(false);
		btnAdd.setEnabled(false);
		model2.clear();
		chckbxbetween.setSelected(true);
		chckbxgreater.setSelected(true);
		chckbxlower.setSelected(true);
		updateList();
		textField.setText("0 €");
	}
	
	
	public Book findBookByTitle(String title){
		Book boo = null;
		for(Book b: bS.getBooks()){
			if(b.getTitle().equals(title)){
				boo = b;
			}
		}
		return boo;
	}
	

	private JPanel getPanelTitle() {
		if (panelTitle == null) {
			panelTitle = new JPanel();
			panelTitle.setLayout(new BorderLayout(0, 0));
			panelTitle.add(getLabel(), BorderLayout.CENTER);
			panelTitle.add(getLblWelcome(), BorderLayout.SOUTH);
		}
		return panelTitle;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		}
		return label;
	}
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome to the book store, " + client + "!!");
			lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
			lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblWelcome;
	}
	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelButtons.add(getBtnBuy());
			panelButtons.add(getBtnCancel());
		}
		return panelButtons;
	}
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Buy");
			btnBuy.setToolTipText("Record the books you have selected in a file with your id");
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!selectedBooks.isEmpty()){
						bS.grabarFichero(selectedBooks, id);
						JOptionPane.showMessageDialog(null, "Your order has been registered");
						reset();
					}
				}
			});
		}
		return btnBuy;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setToolTipText("Clear everything");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reset();
				}
			});
		}
		return btnCancel;
	}
	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setLayout(new GridLayout(1, 0, 0, 0));
			panelCenter.add(getPanelBooks());
			panelCenter.add(getPanelExtra());
			panelCenter.add(getPanelSelected());
		}
		return panelCenter;
	}
	private JPanel getPanelBooks() {
		if (panelBooks == null) {
			panelBooks = new JPanel();
			panelBooks.setLayout(new BorderLayout(0, 0));
			panelBooks.add(getListBook(), BorderLayout.CENTER);
			panelBooks.add(getTextAreaDescription(), BorderLayout.SOUTH);
		}
		return panelBooks;
	}
	private JPanel getPanelSelected() {
		if (panelSelected == null) {
			panelSelected = new JPanel();
			panelSelected.setLayout(new BorderLayout(0, 0));
			panelSelected.add(getListSelected());
			panelSelected.add(getPanelPrice(), BorderLayout.SOUTH);
		}
		return panelSelected;
	}
	private JPanel getPanelExtra() {
		if (panelExtra == null) {
			panelExtra = new JPanel();
			panelExtra.setLayout(new BorderLayout(0, 0));
			panelExtra.add(getPanelAdd(), BorderLayout.NORTH);
			panelExtra.add(getPanel(), BorderLayout.CENTER);
		}
		return panelExtra;
	}
	private JList getListBook() {
		if (listBook == null) {
			listBook = new JList(model1);
			listBook.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					btnAdd.setEnabled(true);
					spinner.setEnabled(true);
					
					String title = String.valueOf(listBook.getSelectedValue());
					Book b = findBookByTitle(title);
					
					if(b != null){
						textAreaDescription.setText("ISBN: " + b.getISBN() + " Editor: " + b.getEditor()
								+ " Author: " + b.getAuthor() + " Type: " + b.getType() + " Price: " + b.getPrice() + " Summary: " + b.getSummary());
					}
				}
			});
			listBook.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Available Books", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			listBook.setBackground(UIManager.getColor("Button.background"));
		}
		return listBook;
	}
	private JTextArea getTextAreaDescription() {
		if (textAreaDescription == null) {
			textAreaDescription = new JTextArea();
			textAreaDescription.setLineWrap(true);
			textAreaDescription.setWrapStyleWord(true);
			textAreaDescription.setEditable(false);
			textAreaDescription.setBorder(new TitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textAreaDescription.setBackground(UIManager.getColor("Button.background"));
		}
		return textAreaDescription;
	}
	private JPanel getPanelAdd() {
		if (panelAdd == null) {
			panelAdd = new JPanel();
			panelAdd.add(getSpinner());
			panelAdd.add(getBtnAdd());
		}
		return panelAdd;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(listBook.getSelectedIndex() != -1){
						String title = String.valueOf(listBook.getSelectedValue());
						Book b = findBookByTitle(title);
						b.setAmount(Integer.parseInt(String.valueOf(spinner.getValue())));
						model2.addElement(b.getTitle() + "; " + b.getPrice() + "; Amount: " + b.getAmount());
						double price = Double.parseDouble(textField.getText().substring(0, textField.getText().length() - 1));
						textField.setText(String.valueOf(price+(b.getAmount()*b.getPrice())));
						selectedBooks.add(b);
					}
				}
			});
			btnAdd.setEnabled(false);
			btnAdd.setMnemonic('a');
		}
		return btnAdd;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner.setEnabled(false);
		}
		return spinner;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(3, 0, 0, 0));
			panel.add(getChckbxlower());
			panel.add(getChckbxbetween());
			panel.add(getChckbxgreater());
		}
		return panel;
	}
	private JCheckBox getChckbxlower() {
		if (chckbxlower == null) {
			chckbxlower = new JCheckBox("<15");
			chckbxlower.setSelected(true);
			chckbxlower.setHorizontalAlignment(SwingConstants.CENTER);
			chckbxlower.addActionListener(filter);
		}
		return chckbxlower;
	}
	private JCheckBox getChckbxbetween() {
		if (chckbxbetween == null) {
			chckbxbetween = new JCheckBox("15 - 40");
			chckbxbetween.setSelected(true);
			chckbxbetween.setHorizontalAlignment(SwingConstants.CENTER);
			chckbxbetween.addActionListener(filter);
		}
		return chckbxbetween;
	}
	private JCheckBox getChckbxgreater() {
		if (chckbxgreater == null) {
			chckbxgreater = new JCheckBox(">40");
			chckbxgreater.setSelected(true);
			chckbxgreater.setHorizontalAlignment(SwingConstants.CENTER);
			chckbxgreater.addActionListener(filter);
		}
		return chckbxgreater;
	}
	private JList getListSelected() {
		if (listSelected == null) {
			listSelected = new JList(model2);
			listSelected.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selected books", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			listSelected.setBackground(UIManager.getColor("Button.background"));
		}
		return listSelected;
	}
	private JPanel getPanelPrice() {
		if (panelPrice == null) {
			panelPrice = new JPanel();
			panelPrice.add(getLblTotalPrice());
			panelPrice.add(getTextField());
		}
		return panelPrice;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("Total Price: ");
		}
		return lblTotalPrice;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setText("0 \u20AC");
			textField.setEditable(false);
			textField.setColumns(10);
		}
		return textField;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnBookstore());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnBookstore() {
		if (mnBookstore == null) {
			mnBookstore = new JMenu("BookStore");
			mnBookstore.setMnemonic('b');
			mnBookstore.add(getMntmReset());
			mnBookstore.add(getMntmExit());
		}
		return mnBookstore;
	}
	private JMenuItem getMntmReset() {
		if (mntmReset == null) {
			mntmReset = new JMenuItem("Reset");
			mntmReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
			mntmReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reset();
				}
			});
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
		}
		return mntmExit;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setMnemonic('p');
			mnOptions.add(getMnFilter());
		}
		return mnOptions;
	}
	private JMenu getMnFilter() {
		if (mnFilter == null) {
			mnFilter = new JMenu("Filter");
			mnFilter.setMnemonic('f');
			mnFilter.add(getMenuItem15());
			mnFilter.add(getMenuItem1540());
			mnFilter.add(getMenuItem40());
		}
		return mnFilter;
	}
	private JMenuItem getMenuItem15() {
		if (menuItem15 == null) {
			menuItem15 = new JMenuItem("<15");
			menuItem15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
			menuItem15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(chckbxlower.isSelected()){
						chckbxlower.setSelected(false);
					}
					else{
						chckbxlower.setSelected(true);
					}
					updateList();
				}
			});
			
		}
		return menuItem15;
	}
	private JMenuItem getMenuItem1540() {
		if (menuItem1540 == null) {
			menuItem1540 = new JMenuItem("15 - 40");
			menuItem1540.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
			menuItem1540.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(chckbxbetween.isSelected()){
						chckbxbetween.setSelected(false);
					}
					else{
						chckbxbetween.setSelected(true);
					}
					updateList();
				}
			});
			

		}
		return menuItem1540;
	}
	private JMenuItem getMenuItem40() {
		if (menuItem40 == null) {
			menuItem40 = new JMenuItem(">40");
			menuItem40.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
			menuItem40.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(chckbxgreater.isSelected()){
						chckbxgreater.setSelected(false);
					}
					else{
						chckbxgreater.setSelected(true);
					}
					updateList();
				}
			});
			
		}
		return menuItem40;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('h');
			mnHelp.add(getMntmContents());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		}
		return mntmContents;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "This application was developed by Daniel Fernandez Feito during the CPM exam");
				}
			});
		}
		return mntmAbout;
	}
}
