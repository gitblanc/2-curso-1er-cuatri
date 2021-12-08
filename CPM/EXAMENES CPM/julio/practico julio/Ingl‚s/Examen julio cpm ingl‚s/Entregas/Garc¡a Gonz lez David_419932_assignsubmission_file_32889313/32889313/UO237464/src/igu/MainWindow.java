package igu;

import io.FileManagerBook;
import io.FileManagerWrite;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Book;
import logica.Client;
import logica.Order;
import logica.OrderBook;

import javax.swing.JMenuBar;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.help.*;

import java.io.File;
import java.net.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Toolkit;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private LoginWindow parent;
	private Client client;
	private FileManagerBook fR;
	private ArrayList<Book> books;
	private JPanel pnPrincipal;
	private JMenuBar menuBar;
	private JPanel pnNorth;
	private JPanel pnWelcome;
	private JLabel lblWelcome;
	private JLabel lblLogo;
	private JPanel pnSouth;
	private JPanel pnSouthUp;
	private JPanel pnButons;
	private JButton btnBuy;
	private JButton btnCancel;
	private Component verticalStrut;
	private JPanel pnCenter;
	private JPanel pnPrincipalCenter;
	private JPanel pnLeft;
	private JPanel pnBook;
	private JPanel pnRigth;
	private JScrollPane scrBooks;
	private JPanel pnChecks;
	private Component horizontalStrut;
	private JList listBooks;
	private Component horizontalStrut_1;
	private Component verticalStrut_1;
	private JScrollPane scrOrder;
	private JList listOrder;
	private JPanel pnPrice;
	private JLabel lblTotalPrice;
	private JTextField txTotalPrice;
	private JPanel pnAdd;
	private JButton btnAd;
	private JPanel pnDelete;
	private JButton btnDelete;
	private JCheckBox chckbxLower;
	private JCheckBox chckbxBetween;
	private JCheckBox chckbxMore;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private JMenu mnBookshop;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem mntmContents;
	private JSeparator separator;
	private JMenuItem mntmAbout;
	private DefaultListModel<Book> modelBooks;
	private DefaultListModel<OrderBook> modeloListaOrder;
	private JLabel lblUnits;
	private JSpinner spnUnits;
	private Order order;
	private ArrayList<OrderBook> orders;
	private JPanel pnInfo;
	private JScrollPane scrInfo;
	private JTextArea txInfoBook;
	private JMenuItem mntmReset;
	private JSeparator separator_1;
	private JMenuItem mntmExit;
	private JMenuItem mntmLogout;
	private JSeparator separator_2;
	private JMenuItem mntmDeleteFromOrder;
	private JMenuItem mntmAddToOrder;
	private JMenu mnFilter;
	private JMenuItem mntmLessThan;
	private JMenuItem mntmBetween;
	private JMenuItem mntmMoreThan;
	private JCheckBoxMenuItem chckbxmntmTooltips;
	private JSeparator separator_3;

	/**
	 * Create the frame.
	 * 
	 * @param client
	 * @param loginWindow
	 */
	public MainWindow(LoginWindow parent, Client client) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/libreria.jpg")));
		setTitle("BookShop");
		this.parent = parent;
		this.client = client;
		order = new Order();
		orders = order.getDataBase();
		fR = new FileManagerBook("libros.dat");
		books = fR.getDataBaseBooks();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		setLocationRelativeTo(parent);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnPrincipal(), BorderLayout.CENTER);
		contentPane.add(getMenuBar_1(), BorderLayout.NORTH);
		getRootPane().setDefaultButton(getBtnBuy());
		cargaAyuda();
	}

	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(new BorderLayout(0, 0));
			pnPrincipal.add(getPnCenter(), BorderLayout.CENTER);
			pnPrincipal.add(getPnNorth(), BorderLayout.NORTH);
			pnPrincipal.add(getPnSouth(), BorderLayout.SOUTH);
		}
		return pnPrincipal;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnBookshop());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JPanel getPnNorth() {
		if (pnNorth == null) {
			pnNorth = new JPanel();
			pnNorth.setLayout(new BorderLayout(0, 0));
			pnNorth.add(getLblLogo(), BorderLayout.CENTER);
			pnNorth.add(getPnWelcome(), BorderLayout.SOUTH);
		}
		return pnNorth;
	}

	private JPanel getPnWelcome() {
		if (pnWelcome == null) {
			pnWelcome = new JPanel();
			pnWelcome.add(getLblWelcome());
		}
		return pnWelcome;
	}

	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome to the book shop Mr/s "
					+ client.getName() + ".");
			lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblWelcome;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setIcon(new ImageIcon(MainWindow.class
					.getResource("/img/libreria.jpg")));
		}
		return lblLogo;
	}

	private JPanel getPnSouth() {
		if (pnSouth == null) {
			pnSouth = new JPanel();
			pnSouth.setLayout(new GridLayout(2, 0, 0, 0));
			pnSouth.add(getVerticalStrut());
			pnSouth.add(getPnSouthUp());
		}
		return pnSouth;
	}

	private JPanel getPnSouthUp() {
		if (pnSouthUp == null) {
			pnSouthUp = new JPanel();
			pnSouthUp.setLayout(new BorderLayout(0, 0));
			pnSouthUp.add(getPnButons(), BorderLayout.EAST);
		}
		return pnSouthUp;
	}

	private JPanel getPnButons() {
		if (pnButons == null) {
			pnButons = new JPanel();
			pnButons.add(getBtnBuy());
			pnButons.add(getBtnCancel());
		}
		return pnButons;
	}

	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Buy!");
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int res = JOptionPane.showConfirmDialog(rootPane,
							"Are you sure to buy this order?", "Confirm Order",
							JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {
						new FileManagerWrite(order, client, Double
								.parseDouble(getTxTotalPrice().getText()));
						logout();
					}else if(res == JOptionPane.NO_OPTION){
						resetWindow();
					}
				}
			});
		}
		return btnBuy;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetWindow();
				}
			});
			btnCancel.setMnemonic('c');
		}
		return btnCancel;
	}

	private void logout() {
		parent.setVisible(true);
		dispose();
	}

	private Component getVerticalStrut() {
		if (verticalStrut == null) {
			verticalStrut = Box.createVerticalStrut(20);
		}
		return verticalStrut;
	}

	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setLayout(new BorderLayout(0, 0));
			pnCenter.add(getPnPrincipalCenter());
		}
		return pnCenter;
	}

	private JPanel getPnPrincipalCenter() {
		if (pnPrincipalCenter == null) {
			pnPrincipalCenter = new JPanel();
			pnPrincipalCenter.setLayout(new GridLayout(0, 3, 0, 0));
			pnPrincipalCenter.add(getPnLeft());
			pnPrincipalCenter.add(getPnBook());
			pnPrincipalCenter.add(getPnRigth());
		}
		return pnPrincipalCenter;
	}

	private JPanel getPnLeft() {
		if (pnLeft == null) {
			pnLeft = new JPanel();
			pnLeft.setLayout(new GridLayout(0, 1, 0, 0));
			pnLeft.add(getScrBooks());
		}
		return pnLeft;
	}

	private JPanel getPnBook() {
		if (pnBook == null) {
			pnBook = new JPanel();
			pnBook.setLayout(new BorderLayout(0, 0));
			pnBook.add(getPnInfo(), BorderLayout.CENTER);
			pnBook.add(getPnAdd(), BorderLayout.NORTH);
			pnBook.add(getPnDelete(), BorderLayout.SOUTH);
			pnBook.add(getHorizontalStrut_2(), BorderLayout.EAST);
			pnBook.add(getHorizontalStrut_3(), BorderLayout.WEST);
		}
		return pnBook;
	}

	private JPanel getPnRigth() {
		if (pnRigth == null) {
			pnRigth = new JPanel();
			pnRigth.setLayout(new BorderLayout(0, 0));
			pnRigth.add(getPnPrice(), BorderLayout.SOUTH);
			pnRigth.add(getHorizontalStrut_1(), BorderLayout.EAST);
			pnRigth.add(getVerticalStrut_1(), BorderLayout.NORTH);
			pnRigth.add(getScrOrder(), BorderLayout.CENTER);
		}
		return pnRigth;
	}

	private JScrollPane getScrBooks() {
		if (scrBooks == null) {
			scrBooks = new JScrollPane();
			scrBooks.setBorder(null);
			scrBooks.setColumnHeaderView(getPnChecks());
			scrBooks.setRowHeaderView(getHorizontalStrut());
			scrBooks.setViewportView(getListBooks());
		}
		return scrBooks;
	}

	private JPanel getPnChecks() {
		if (pnChecks == null) {
			pnChecks = new JPanel();
			pnChecks.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnChecks.add(getChckbxLower());
			pnChecks.add(getChckbxBetween());
			pnChecks.add(getChckbxMore());
		}
		return pnChecks;
	}

	private Component getHorizontalStrut() {
		if (horizontalStrut == null) {
			horizontalStrut = Box.createHorizontalStrut(20);
		}
		return horizontalStrut;
	}

	private JList getListBooks() {
		if (listBooks == null) {
			listBooks = new JList();
			listBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listBooks.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if (listBooks.getModel().getSize() > 0)
						listBooks.setSelectedIndex(0);
				}
			});
			listBooks.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					escribirInfo((Book) getListBooks().getSelectedValue());
				}
			});
			listBooks.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					escribirInfo((Book) getListBooks().getSelectedValue());
				}
			});
			listBooks.setBorder(null);
			rellenarLista();
		}
		return listBooks;
	}

	private void rellenarLista() {
		modelBooks = new DefaultListModel<Book>();
		for (Book b : books) {
			modelBooks.addElement(b);
		}
		getListBooks().setModel(modelBooks);

	}

	private void escribirInfo(Book b) {
		if (b != null) {
			getTxInfoBook().setText(b.getBookInfo());
		}

	}

	private Component getHorizontalStrut_1() {
		if (horizontalStrut_1 == null) {
			horizontalStrut_1 = Box.createHorizontalStrut(20);
		}
		return horizontalStrut_1;
	}

	private Component getVerticalStrut_1() {
		if (verticalStrut_1 == null) {
			verticalStrut_1 = Box.createVerticalStrut(21);
		}
		return verticalStrut_1;
	}

	private JScrollPane getScrOrder() {
		if (scrOrder == null) {
			scrOrder = new JScrollPane();
			scrOrder.setBorder(null);
			scrOrder.setViewportView(getListOrder());
		}
		return scrOrder;
	}

	private JList getListOrder() {
		if (listOrder == null) {
			listOrder = new JList();
			listOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listOrder.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if (listOrder.getModel().getSize() > 0) {
						listOrder.setSelectedIndex(0);
					}
				}
			});
			listOrder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					OrderBook oB = ((OrderBook) getListOrder()
							.getSelectedValue());
					escribirInfo(oB.getBook());
				}
			});
			listOrder.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					OrderBook oB = ((OrderBook) getListOrder()
							.getSelectedValue());
					escribirInfo(oB.getBook());
				}
			});
			modeloListaOrder = new DefaultListModel<OrderBook>();
			listOrder.setModel(modeloListaOrder);
		}
		return listOrder;
	}

	private JPanel getPnPrice() {
		if (pnPrice == null) {
			pnPrice = new JPanel();
			pnPrice.add(getLblTotalPrice());
			pnPrice.add(getTxTotalPrice());
		}
		return pnPrice;
	}

	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("Total Price:   ");
			lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblTotalPrice;
	}

	private JTextField getTxTotalPrice() {
		if (txTotalPrice == null) {
			txTotalPrice = new JTextField();
			txTotalPrice.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txTotalPrice.getText().length()>0){
						txTotalPrice.selectAll();
					}
				}
			});
			txTotalPrice.setEditable(false);
			txTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txTotalPrice.setColumns(10);
		}
		return txTotalPrice;
	}

	private JPanel getPnAdd() {
		if (pnAdd == null) {
			pnAdd = new JPanel();
			pnAdd.add(getBtnAd());
			pnAdd.add(getLblUnits());
			pnAdd.add(getSpnUnits());
		}
		return pnAdd;
	}

	private JButton getBtnAd() {
		if (btnAd == null) {
			btnAd = new JButton("Add ->>>");
			btnAd.setMnemonic('a');
			btnAd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addElementToOrder();
					calculateTotalPrice();
				}
			});
		}
		return btnAd;
	}

	private void addElementToOrder() {
		Book b = (Book) getListBooks().getSelectedValue();
		if (b != null) {
			modeloListaOrder.clear();
			OrderBook oB = searchOrder(b.getISBN());
			if (oB == null) {
				orders.add(new OrderBook(b, (int) getSpnUnits().getValue()));
			} else {
				oB.sumUnits((int) getSpnUnits().getValue());
			}

			for (OrderBook each : orders) {
				modeloListaOrder.addElement(each);
			}
			getListOrder().setModel(modeloListaOrder);
		}
	}

	private OrderBook searchOrder(String s) {
		if (orders.size() > 0) {
			for (OrderBook b : orders) {
				if (b.getBook().getISBN().equals(s)) {
					return b;
				}
			}
		}
		return null;
	}

	private JPanel getPnDelete() {
		if (pnDelete == null) {
			pnDelete = new JPanel();
			pnDelete.add(getBtnDelete());
		}
		return pnDelete;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("<<<- Delete");
			btnDelete.setMnemonic('d');
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					deleteFromOrderList();
					calculateTotalPrice();
				}
			});
		}
		return btnDelete;
	}

	private void calculateTotalPrice() {
		double price = 0;
		for (OrderBook b : orders) {
			price += b.getBook().getPrice() * b.getUnits();
		}
		price = Math.rint((price * 1000)) / 1000;
		getTxTotalPrice().setText(String.valueOf(price));

	}

	protected void deleteFromOrderList() {
		OrderBook oB = (OrderBook) getListOrder().getSelectedValue();
		if (oB != null) {
			int spnU = (int) getSpnUnits().getValue();
			modeloListaOrder.clear();
			if (spnU < oB.getUnits()) {
				oB.decrementUnits(spnU);
			} else {
				orders.remove(oB);
			}

			for (OrderBook each : orders) {
				modeloListaOrder.addElement(each);
			}
			getListOrder().setModel(modeloListaOrder);
		}

	}

	private int searchOrderPos(String isbn) {
		if (orders.size() > 0) {
			for (int i = 0; i < orders.size(); i++) {
				if (orders.get(i).getBook().getISBN().equals(isbn)) {
					return i;
				}
			}
		}
		return -1;
	}

	private JCheckBox getChckbxLower() {
		if (chckbxLower == null) {
			chckbxLower = new JCheckBox("< 15");
			chckbxLower.setSelected(true);
			chckbxLower.addActionListener(new ListFilter(books, getListBooks(),
					modelBooks, getChckbxLower(), getChckbxBetween(),
					getChckbxMore()));
		}
		return chckbxLower;
	}

	private JCheckBox getChckbxBetween() {
		if (chckbxBetween == null) {
			chckbxBetween = new JCheckBox("15 to 40");
			chckbxBetween.setSelected(true);
			chckbxBetween.addActionListener(new ListFilter(books,
					getListBooks(), modelBooks, getChckbxLower(),
					getChckbxBetween(), getChckbxMore()));
		}
		return chckbxBetween;
	}

	private JCheckBox getChckbxMore() {
		if (chckbxMore == null) {
			chckbxMore = new JCheckBox("> 40");
			chckbxMore.setSelected(true);
			chckbxMore.addActionListener(new ListFilter(books, getListBooks(),
					modelBooks, getChckbxLower(), getChckbxBetween(),
					getChckbxMore()));
		}
		return chckbxMore;
	}

	private Component getHorizontalStrut_2() {
		if (horizontalStrut_2 == null) {
			horizontalStrut_2 = Box.createHorizontalStrut(20);
		}
		return horizontalStrut_2;
	}

	private Component getHorizontalStrut_3() {
		if (horizontalStrut_3 == null) {
			horizontalStrut_3 = Box.createHorizontalStrut(20);
		}
		return horizontalStrut_3;
	}

	private JMenu getMnBookshop() {
		if (mnBookshop == null) {
			mnBookshop = new JMenu("BookShop");
			mnBookshop.setMnemonic('b');
			mnBookshop.add(getMntmAddToOrder());
			mnBookshop.add(getMntmDeleteFromOrder());
			mnBookshop.add(getMnFilter());
			mnBookshop.add(getSeparator_2());
			mnBookshop.add(getMntmLogout());
			mnBookshop.add(getSeparator_1());
			mnBookshop.add(getMntmExit());
		}
		return mnBookshop;
	}

	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setMnemonic('o');
			mnOptions.add(getChckbxmntmTooltips());
			mnOptions.add(getSeparator_3());
			mnOptions.add(getMntmReset());
		}
		return mnOptions;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('h');
			mnHelp.add(getMntmContents());
			mnHelp.add(getSeparator());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents.setMnemonic('c');
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,
					0));
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
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String mes = "BokkShop EII Oviedo.\nApplciation for the July exam.\nBy David Garcia Gonzalez";
					JOptionPane.showMessageDialog(rootPane, mes, "About",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAbout.setMnemonic('a');
		}
		return mntmAbout;
	}

	private JLabel getLblUnits() {
		if (lblUnits == null) {
			lblUnits = new JLabel("Units");
			lblUnits.setLabelFor(getSpnUnits());
			lblUnits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblUnits;
	}

	private JSpinner getSpnUnits() {
		if (spnUnits == null) {
			spnUnits = new JSpinner();
			spnUnits.setModel(new SpinnerNumberModel(new Integer(1),
					new Integer(1), null, new Integer(1)));
		}
		return spnUnits;
	}

	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfo.add(getScrInfo());
		}
		return pnInfo;
	}

	private JScrollPane getScrInfo() {
		if (scrInfo == null) {
			scrInfo = new JScrollPane();
			scrInfo.setViewportView(getTxInfoBook());
		}
		return scrInfo;
	}

	private JTextArea getTxInfoBook() {
		if (txInfoBook == null) {
			txInfoBook = new JTextArea();
			txInfoBook.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txInfoBook.getText().length()>0){
						txInfoBook.selectAll();
					}
				}
			});
			txInfoBook.setEditable(false);
			txInfoBook.setWrapStyleWord(true);
			txInfoBook.setLineWrap(true);
		}
		return txInfoBook;
	}

	private void cargaAyuda() {

		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}

		HelpBroker hb = hs.createHelpBroker();

		hb.enableHelpKey(getRootPane(), "init", hs);
		hb.enableHelpOnButton(getMntmContents(), "init", hs);

	}

	private JMenuItem getMntmReset() {
		if (mntmReset == null) {
			mntmReset = new JMenuItem("Reset");
			mntmReset.setMnemonic('r');
			mntmReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetWindow();

				}
			});
		}
		return mntmReset;
	}

	private void resetWindow() {
		orders.clear();
		modeloListaOrder.clear();
		getListOrder().setModel(modeloListaOrder);
		getTxInfoBook().setText(null);
		getTxTotalPrice().setText(null);
		getChckbxLower().setSelected(true);
		getChckbxBetween().setSelected(true);
		getChckbxMore().setSelected(true);
		getChckbxLower().grabFocus();
		getSpnUnits().setValue(1);
		rellenarLista();
		getChckbxmntmTooltips().setSelected(true);
		setTooltips();
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setMnemonic('e');
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmExit;
	}

	private JMenuItem getMntmLogout() {
		if (mntmLogout == null) {
			mntmLogout = new JMenuItem("Logout");
			mntmLogout.setMnemonic('l');
			mntmLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					logout();
				}
			});
		}
		return mntmLogout;
	}

	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
		}
		return separator_2;
	}

	private JMenuItem getMntmDeleteFromOrder() {
		if (mntmDeleteFromOrder == null) {
			mntmDeleteFromOrder = new JMenuItem("Delete from order");
			mntmDeleteFromOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					deleteFromOrderList();
					calculateTotalPrice();
				}
			});
			mntmDeleteFromOrder.setMnemonic('d');
		}
		return mntmDeleteFromOrder;
	}

	private JMenuItem getMntmAddToOrder() {
		if (mntmAddToOrder == null) {
			mntmAddToOrder = new JMenuItem("Add to order ");
			mntmAddToOrder.setMnemonic('a');
			mntmAddToOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addElementToOrder();
					calculateTotalPrice();
				}
			});
		}
		return mntmAddToOrder;
	}

	private JMenu getMnFilter() {
		if (mnFilter == null) {
			mnFilter = new JMenu("Filter");
			mnFilter.setMnemonic('f');
			mnFilter.add(getMntmLessThan());
			mnFilter.add(getMntmBetween());
			mnFilter.add(getMntmMoreThan());
		}
		return mnFilter;
	}

	private JMenuItem getMntmLessThan() {
		if (mntmLessThan == null) {
			mntmLessThan = new JMenuItem("Less than 15");
			mntmLessThan.setMnemonic('l');
			mntmLessThan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getChckbxLower().doClick();
				}
			});
		}
		return mntmLessThan;
	}

	private JMenuItem getMntmBetween() {
		if (mntmBetween == null) {
			mntmBetween = new JMenuItem("Between 15 & 40");
			mntmBetween.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getChckbxBetween().doClick();
				}
			});
			mntmBetween.setMnemonic('b');
		}
		return mntmBetween;
	}

	private JMenuItem getMntmMoreThan() {
		if (mntmMoreThan == null) {
			mntmMoreThan = new JMenuItem("More than 40");
			mntmMoreThan.setMnemonic('m');
			mntmMoreThan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getChckbxMore().doClick();
				}
			});

		}
		return mntmMoreThan;
	}
	
	private void setTooltips(){
		getBtnAd().setToolTipText("If you have got a book selected in the left list, you add to the order it.");
		getBtnDelete().setToolTipText("If you have got a book selected in the right list, you delete from the order it.");
		getBtnBuy().setToolTipText("If ou have something in the order, you go to confirm dialog to buy it..");
	}
	
	private void resetTooltips(){
		getBtnAd().setToolTipText(null);
		getBtnDelete().setToolTipText(null);
		getBtnBuy().setToolTipText(null);
	}
	private JCheckBoxMenuItem getChckbxmntmTooltips() {
		if (chckbxmntmTooltips == null) {
			chckbxmntmTooltips = new JCheckBoxMenuItem("Tooltips");
			chckbxmntmTooltips.setSelected(true);
			setTooltips();
			chckbxmntmTooltips.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!chckbxmntmTooltips.isSelected()){
						resetTooltips();
					}else{
						setTooltips();
					}
				}
			});
		}
		return chckbxmntmTooltips;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
		}
		return separator_3;
	}
}
