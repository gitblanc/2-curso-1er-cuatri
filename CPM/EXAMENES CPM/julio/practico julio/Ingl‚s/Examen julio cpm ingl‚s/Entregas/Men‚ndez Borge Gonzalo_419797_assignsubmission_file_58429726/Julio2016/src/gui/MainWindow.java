package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import logic.App;
import logic.Libro;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.net.URL;

import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.InputEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainWindow extends JFrame {

	private App app;
	private Login login;
	private FiltraLibros filtraLibros;
	private Confirm confirm;
	private boolean visible;

	private static final long serialVersionUID = 4895490324943613916L;
	private JPanel pnMain;
	private JLabel lblWelcome;
	private JMenuBar mbMainWindow;
	private JMenu mnOptions;
	private JScrollPane spLibros;
	private JPanel pnCenter;
	private JList<Libro> listBooks;
	DefaultListModel<Libro> listModel;
	private JPanel pnWest;
	private JLabel lblPriceFilter;
	private JCheckBox checkbLess15;
	private JCheckBox checkb1540;
	private JCheckBox checkbMore40;
	private JLabel lblBooks;
	private JPanel pnSouth;
	private JPanel pnEast;
	private JLabel lblISBN;
	private JTextField txISBN;
	private JLabel lblEditor;
	private JTextField txEditor;
	private JLabel lblAuthor;
	private JTextField txAuthor;
	private JLabel lblType;
	private JTextField txType;
	private JLabel lblPrice;
	private JTextField txPrice;
	private JLabel lblSummary;
	private JScrollPane spSummary;
	private JTextArea taSummary;
	private JLabel lblInformation;
	private JLabel lblAmount;
	private JSpinner spnCantidad;
	private JButton btnPurchase;
	private JScrollPane spOrder;
	private JLabel lblYourOrder;
	private JButton btnAdd;
	private JTable tbOrder;
	private DefaultTableModel tableModel;
	private JButton btnRemove;
	private JLabel lblTotalPrice;
	private JTextField txTotalPrice;
	private JSeparator sprRemoveTotalPrice;
	private JMenu mnHelp;
	private JMenuItem mntmLogOut;
	private JMenuItem mntmExit;
	private JSeparator sprLogOutExit;
	private JMenuItem mntmAbout;
	private JMenu mnFilter;
	private JMenuItem mntmLess15;
	private JMenuItem mntm1540;
	private JMenuItem mntmMore40;
	private JSeparator sprSelectAllLess15;
	private JMenuItem mntmSelectAll;
	private JMenuItem mntmReset;
	private JMenuItem mntmBookstoreHelp;
	private JPanel pnNorth;
	
	private class FiltraLibros implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			refreshBookList();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainWindow();
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
		app = new App();
		filtraLibros = new FiltraLibros();
		listModel = new DefaultListModel<Libro>();
		visible = false;
		
		setTitle("Librer\u00EDa EII Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/libreria.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 675);
		setMinimumSize(new Dimension(700, 675));
		setJMenuBar(getMbMainWindow());
		pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnMain.setLayout(new BorderLayout(0, 0));
		setContentPane(pnMain);
		pnMain.add(getPnWest(), BorderLayout.WEST);
		pnMain.add(getPnCenter(), BorderLayout.CENTER);
		pnMain.add(getPanel_1(), BorderLayout.EAST);
		pnMain.add(getPnSouth(), BorderLayout.SOUTH);
		pnMain.getRootPane().setDefaultButton(btnPurchase);
		pnMain.add(getPnNorth(), BorderLayout.NORTH);
		login = new Login(this);
		login.setLocationRelativeTo(null);
		login.setModal(true);
		confirm = new Confirm(this);
		confirm.setLocationRelativeTo(null);
		confirm.setModal(true);
		
		cargaAyuda();		
		showLogin();
	}
	
	private void showLogin() {
		login.reset();
		visible = false;
		login.setVisible(true);
		if(visible) {
			lblWelcome.setText("Welcome to the book store " + app.getPedido().getCliente().getName());
			setVisible(true);
		}
		else
			dispose();			
	}

	public App getApp() {
		return app;
	}

	public Login getLogin() {
		return login;
	}
	
	private JLabel getLblWelcome() {
	if (lblWelcome == null) {
		lblWelcome = new JLabel();
		lblWelcome.setText("Welcome to the book store ");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblWelcome.setForeground(SystemColor.textHighlight);
	}
	return lblWelcome;
}
	private JMenuBar getMbMainWindow() {
		if (mbMainWindow == null) {
			mbMainWindow = new JMenuBar();
			mbMainWindow.add(getMnOptions());
			mbMainWindow.add(getMnHelp());
		}
		return mbMainWindow;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setMnemonic('O');
			mnOptions.add(getMntmLogOut());
			mnOptions.add(getMnFilter());
			mnOptions.add(getMntmReset());
			mnOptions.add(getSprLogOutExit());
			mnOptions.add(getMntmExit());
		}
		return mnOptions;
	}
	private JScrollPane getSpLibros() {
		if (spLibros == null) {
			spLibros = new JScrollPane();
			spLibros.setViewportView(getListBooks());
		}
		return spLibros;
	}
	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			GroupLayout gl_pnCenter = new GroupLayout(pnCenter);
			gl_pnCenter.setHorizontalGroup(
				gl_pnCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCenter.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnCenter.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCenter.createSequentialGroup()
								.addComponent(getSpLibros(), GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(gl_pnCenter.createSequentialGroup()
								.addComponent(getLblBooks())
								.addGap(0))))
			);
			gl_pnCenter.setVerticalGroup(
				gl_pnCenter.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_pnCenter.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblBooks())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getSpLibros(), GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
						.addContainerGap())
			);
			pnCenter.setLayout(gl_pnCenter);
		}
		return pnCenter;
	}
	private JList<Libro> getListBooks() {
		if (listBooks == null) {			
			listBooks = new JList<Libro>();
			listBooks.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {					
					listBooks.setSelectedIndex(listBooks.getSelectedIndex() == -1 ? 0 : listBooks.getSelectedIndex());
				}
			});
			listBooks.setFont(new Font("SansSerif", Font.PLAIN, 12));
			listBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			listModel.clear();			
			for(Libro libro : app.getLibros())
				listModel.addElement(libro);
			listBooks.setModel(listModel);
			
			listBooks.addListSelectionListener(new ListSelectionListener() {				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (listBooks.isSelectionEmpty()) {
						txISBN.setText("");
						txEditor.setText("");
						txAuthor.setText("");
						txType.setText("");
						txPrice.setText("");		
						taSummary.setText("");
					}
					else {
						Libro book = listBooks.getSelectedValue();
						txISBN.setText(book.getISBN());
						txEditor.setText(book.getEditorial());
						txAuthor.setText(book.getAutor());
						txType.setText(book.getGenero());
						txPrice.setText(String.valueOf(book.getPrecio()) + "€");		
						taSummary.setText(book.getResumen());
						taSummary.setCaretPosition(0);
					}
				}
			});
			
		}
		return listBooks;
	}
	private JPanel getPnWest() {
		if (pnWest == null) {
			pnWest = new JPanel();
			GroupLayout gl_pnWest = new GroupLayout(pnWest);
			gl_pnWest.setHorizontalGroup(
				gl_pnWest.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnWest.createSequentialGroup()
						.addGap(14)
						.addGroup(gl_pnWest.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblPriceFilter())
							.addComponent(getCheckbLess15(), GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addComponent(getCheckb1540())
							.addComponent(getCheckbMore40()))
						.addContainerGap())
			);
			gl_pnWest.setVerticalGroup(
				gl_pnWest.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnWest.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblPriceFilter())
						.addGap(7)
						.addComponent(getCheckbLess15())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getCheckb1540(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getCheckbMore40(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(216, Short.MAX_VALUE))
			);
			gl_pnWest.linkSize(SwingConstants.VERTICAL, new Component[] {getCheckbMore40(), getCheckb1540(), getCheckbLess15()});
			pnWest.setLayout(gl_pnWest);
		}
		return pnWest;
	}
	private JLabel getLblPriceFilter() {
		if (lblPriceFilter == null) {
			lblPriceFilter = new JLabel("Price filter:");
			lblPriceFilter.setFont(new Font("SansSerif", Font.BOLD, 12));
		}
		return lblPriceFilter;
	}
	private JCheckBox getCheckbLess15() {
		if (checkbLess15 == null) {
			checkbLess15 = new JCheckBox("Less than 15\u20AC");
			checkbLess15.setMnemonic('L');
			checkbLess15.setSelected(true);
			checkbLess15.addChangeListener(filtraLibros);
		}
		return checkbLess15;
	}
	private JCheckBox getCheckb1540() {
		if (checkb1540 == null) {
			checkb1540 = new JCheckBox("15\u20AC to 40\u20AC");
			checkb1540.setMnemonic('t');
			checkb1540.setSelected(true);
			checkb1540.addChangeListener(filtraLibros);
		}
		return checkb1540;
	}
	private JCheckBox getCheckbMore40() {
		if (checkbMore40 == null) {
			checkbMore40 = new JCheckBox("More than 40\u20AC");
			checkbMore40.setMnemonic('M');
			checkbMore40.setSelected(true);
			checkbMore40.addChangeListener(filtraLibros);
		}
		return checkbMore40;
	}
	
	private void refreshBookList() {
		
		boolean less15 = checkbLess15.isSelected(),
				between = checkb1540.isSelected(),
				more40 = checkbMore40.isSelected();
		BigDecimal price;
		listModel.clear();
		
		for (Libro libro : app.getLibros()) {
			price = libro.getPrecio();
			
			if (price.compareTo(new BigDecimal(15)) < 0 && less15)
				listModel.addElement(libro);
			else if (price.compareTo(new BigDecimal(15)) >= 0 && price.compareTo(new BigDecimal(40)) <= 0 && between)
				listModel.addElement(libro);
			else if (price.compareTo(new BigDecimal(40)) > 0 && more40)
				listModel.addElement(libro);				
		}					
	}
	private JLabel getLblBooks() {
		if (lblBooks == null) {
			lblBooks = new JLabel("Books:");
			lblBooks.setLabelFor(getListBooks());
			lblBooks.setDisplayedMnemonic('B');
			lblBooks.setFont(new Font("SansSerif", Font.BOLD, 12));
		}
		return lblBooks;
	}
	private JPanel getPnSouth() {
		if (pnSouth == null) {
			pnSouth = new JPanel();
			GroupLayout gl_pnSouth = new GroupLayout(pnSouth);
			gl_pnSouth.setHorizontalGroup(
				gl_pnSouth.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnSouth.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnSouth.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnSouth.createSequentialGroup()
								.addComponent(getSpOrder(), GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
								.addGroup(gl_pnSouth.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnSouth.createSequentialGroup()
										.addGap(9)
										.addComponent(getBtnRemove(), GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_pnSouth.createSequentialGroup()
										.addGap(9)
										.addComponent(getBtnPurchase()))
									.addGroup(gl_pnSouth.createSequentialGroup()
										.addGap(23)
										.addGroup(gl_pnSouth.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(getTxTotalPrice(), Alignment.LEADING, 0, 0, Short.MAX_VALUE)
											.addComponent(getLblTotalPrice(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGroup(gl_pnSouth.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(getSprRemoveTotalPrice(), GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
							.addComponent(getLblYourOrder(), GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			gl_pnSouth.setVerticalGroup(
				gl_pnSouth.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnSouth.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblYourOrder(), GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnSouth.createParallelGroup(Alignment.BASELINE)
							.addComponent(getSpOrder(), GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addGroup(gl_pnSouth.createSequentialGroup()
								.addComponent(getBtnRemove())
								.addGap(18)
								.addComponent(getSprRemoveTotalPrice(), GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
								.addGap(14)
								.addComponent(getLblTotalPrice())
								.addGap(5)
								.addComponent(getTxTotalPrice(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(16)
								.addComponent(getBtnPurchase())))
						.addContainerGap())
			);
			gl_pnSouth.linkSize(SwingConstants.VERTICAL, new Component[] {getBtnRemove(), getBtnPurchase()});
			gl_pnSouth.linkSize(SwingConstants.HORIZONTAL, new Component[] {getBtnRemove(), getBtnPurchase()});
			pnSouth.setLayout(gl_pnSouth);
		}
		return pnSouth;
	}
	private JPanel getPanel_1() {
		if (pnEast == null) {
			pnEast = new JPanel();
			pnEast.setPreferredSize(new Dimension(250, 500));
			GroupLayout gl_pnEast = new GroupLayout(pnEast);
			gl_pnEast.setHorizontalGroup(
				gl_pnEast.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnEast.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
									.addComponent(getLblSummary(), GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblPrice(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblType(), GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
									.addComponent(getLblAuthor(), GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
									.addComponent(getLblEditor(), GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
									.addComponent(getLblISBN(), GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
									.addComponent(getTxISBN(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxEditor(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxAuthor(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxType(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxPrice(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
							.addComponent(getLblInformation())
							.addComponent(getSpSummary(), GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
							.addGroup(gl_pnEast.createSequentialGroup()
								.addComponent(getLblAmount())
								.addGap(12)
								.addComponent(getSpnCantidad(), GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
								.addComponent(getBtnAdd(), GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
			);
			gl_pnEast.setVerticalGroup(
				gl_pnEast.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnEast.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblInformation())
						.addGap(18)
						.addGroup(gl_pnEast.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblISBN())
							.addComponent(getTxISBN(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnEast.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getTxEditor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGap(9)
								.addComponent(getLblEditor())))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGap(3)
								.addComponent(getLblAuthor()))
							.addComponent(getTxAuthor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
							.addComponent(getTxType(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGap(3)
								.addComponent(getLblType())))
						.addGap(6)
						.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGap(3)
								.addComponent(getLblPrice()))
							.addComponent(getTxPrice(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getLblSummary())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getSpSummary(), GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addGroup(gl_pnEast.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGap(15)
								.addComponent(getLblAmount())
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGap(12)
								.addComponent(getSpnCantidad(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_pnEast.createSequentialGroup()
								.addGap(11)
								.addComponent(getBtnAdd())))
						.addGap(11))
			);
			gl_pnEast.linkSize(SwingConstants.VERTICAL, new Component[] {getTxISBN(), getTxEditor(), getTxAuthor(), getTxType(), getTxPrice()});
			gl_pnEast.linkSize(SwingConstants.HORIZONTAL, new Component[] {getTxISBN(), getTxEditor(), getTxAuthor(), getTxType(), getTxPrice()});
			pnEast.setLayout(gl_pnEast);
		}
		return pnEast;
	}
	private JLabel getLblISBN() {
		if (lblISBN == null) {
			lblISBN = new JLabel("ISBN:");
			lblISBN.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return lblISBN;
	}
	private JTextField getTxISBN() {
		if (txISBN == null) {
			txISBN = new JTextField();
			txISBN.setEditable(false);
			txISBN.setColumns(10);
		}
		return txISBN;
	}
	private JLabel getLblEditor() {
		if (lblEditor == null) {
			lblEditor = new JLabel("Editor:");
			lblEditor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return lblEditor;
	}
	private JTextField getTxEditor() {
		if (txEditor == null) {
			txEditor = new JTextField();
			txEditor.setEditable(false);
			txEditor.setColumns(10);
		}
		return txEditor;
	}
	private JLabel getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new JLabel("Author:");
			lblAuthor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return lblAuthor;
	}
	private JTextField getTxAuthor() {
		if (txAuthor == null) {
			txAuthor = new JTextField();
			txAuthor.setEditable(false);
			txAuthor.setColumns(10);
		}
		return txAuthor;
	}
	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type:");
			lblType.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return lblType;
	}
	private JTextField getTxType() {
		if (txType == null) {
			txType = new JTextField();
			txType.setEditable(false);
			txType.setColumns(10);
		}
		return txType;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Price:");
			lblPrice.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return lblPrice;
	}
	private JTextField getTxPrice() {
		if (txPrice == null) {
			txPrice = new JTextField();
			txPrice.setEditable(false);
			txPrice.setColumns(10);
		}
		return txPrice;
	}
	private JLabel getLblSummary() {
		if (lblSummary == null) {
			lblSummary = new JLabel("Summary:");
			lblSummary.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return lblSummary;
	}
	private JScrollPane getSpSummary() {
		if (spSummary == null) {
			spSummary = new JScrollPane();
			spSummary.setViewportView(getTaSummary());
		}
		return spSummary;
	}
	private JTextArea getTaSummary() {
		if (taSummary == null) {
			taSummary = new JTextArea();
			taSummary.setEditable(false);
			taSummary.setLineWrap(true);
			taSummary.setWrapStyleWord(true);
		}
		return taSummary;
	}
	private JLabel getLblInformation() {
		if (lblInformation == null) {
			lblInformation = new JLabel("Information:");
			lblInformation.setFont(new Font("SansSerif", Font.BOLD, 12));
		}
		return lblInformation;
	}
	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount:");
			lblAmount.setLabelFor(getSpnCantidad());
			lblAmount.setDisplayedMnemonic('n');
			lblAmount.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return lblAmount;
	}
	private JSpinner getSpnCantidad() {
		if (spnCantidad == null) {
			spnCantidad = new JSpinner();
			spnCantidad.setFont(new Font("SansSerif", Font.PLAIN, 12));
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return spnCantidad;
	}
	private JButton getBtnPurchase() {
		if (btnPurchase == null) {
			btnPurchase = new JButton("Purchase");
			btnPurchase.setEnabled(false);
			btnPurchase.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					confirm.reset();
				}
			});
			btnPurchase.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
		return btnPurchase;
	}
	
	private JScrollPane getSpOrder() {
		if (spOrder == null) {
			spOrder = new JScrollPane();
			spOrder.setFont(new Font("SansSerif", Font.PLAIN, 12));
			spOrder.setViewportView(getTbOrder());
		}
		return spOrder;
	}
	private JLabel getLblYourOrder() {
		if (lblYourOrder == null) {
			lblYourOrder = new JLabel("Your order:");
			lblYourOrder.setLabelFor(getTbOrder());
			lblYourOrder.setDisplayedMnemonic('Y');
			lblYourOrder.setFont(new Font("SansSerif", Font.BOLD, 12));
		}
		return lblYourOrder;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setMnemonic('A');
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!listBooks.isSelectionEmpty()) {
						Libro book = listBooks.getSelectedValue();
						updateTable(book);
						app.getPedido().addPurchase(book, (int) spnCantidad.getValue());
						
						BigDecimal newPrice = book.getPrecio().multiply(new BigDecimal((int)spnCantidad.getValue()));
						newPrice = newPrice.add(new BigDecimal(txTotalPrice.getText()));
						txTotalPrice.setText(newPrice.toString());
						
						btnPurchase.setEnabled(true);;
					}
				}
			});
			btnAdd.setFont(new Font("SansSerif", Font.PLAIN, 12));
			btnAdd.setToolTipText("Add specified amount");
		}
		return btnAdd;
	}
	
	private void updateTable(Libro book) {
		String title = book.getTítulo();
		boolean already = false;
		int row = -1;
		
		for(int i = 0; i < tableModel.getRowCount(); i++)
			if(title.equals(tableModel.getValueAt(i, 0))) {
				already = true;
				row = i;
				break;
			}
		
		if(already) {
			int newValue = (int) tableModel.getValueAt(row, 2) + (int) spnCantidad.getValue();
			tableModel.setValueAt( newValue, row, 2);
		}						
		else {
			Object[] newRow = new Object[3];
			
			newRow[0] = title;
			newRow[1] = String.valueOf(book.getPrecio()) + "€";
			newRow[2] = spnCantidad.getValue();
			
			tableModel.addRow(newRow);
		}
	}
	
	private JTable getTbOrder() {
		if (tbOrder == null) {
			tbOrder = new JTable();
			tbOrder.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(tbOrder.getSelectedRow() == -1 && tbOrder.getRowCount() > 0)
						tbOrder.setRowSelectionInterval(0, 0);
				}
			});
			tbOrder.setFont(new Font("SansSerif", Font.PLAIN, 12));
			
			tableModel = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Title", "Unit price", "Units"
					}
				) {
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						Object.class, Object.class, Integer.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				};
			
			tbOrder.setModel(tableModel);
		}
		return tbOrder;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.setMnemonic('R');
			btnRemove.setFont(new Font("SansSerif", Font.PLAIN, 12));
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int row = tbOrder.getSelectedRow();
					
					if (row != -1) {
						
						for(Libro libro : app.getLibros())
							if(libro.getTítulo().equals(tableModel.getValueAt(row, 0))) {
								app.getPedido().removeBook(libro);
								BigDecimal newPrice = libro.getPrecio().multiply(new BigDecimal((int) tableModel.getValueAt(row, 2)));
								newPrice = new BigDecimal(txTotalPrice.getText()).subtract(newPrice);
								txTotalPrice.setText(newPrice.toString()); 
								tableModel.removeRow(row);
								
								if(tableModel.getRowCount() == 0)
									btnPurchase.setEnabled(false);
								
								return;
							}
						
						throw new IllegalStateException("A problem arised trying to remove a book!");
									
					}
				}
			});
			btnRemove.setToolTipText("Remove selected book from your order");
		}
		return btnRemove;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("Total price:");
			lblTotalPrice.setFont(new Font("SansSerif", Font.BOLD, 12));
		}
		return lblTotalPrice;
	}
	private JTextField getTxTotalPrice() {
		if (txTotalPrice == null) {
			txTotalPrice = new JTextField();
			txTotalPrice.setText("0.00");
			txTotalPrice.setEditable(false);
			txTotalPrice.setColumns(10);
		}
		return txTotalPrice;
	}
	private JSeparator getSprRemoveTotalPrice() {
		if (sprRemoveTotalPrice == null) {
			sprRemoveTotalPrice = new JSeparator();
		}
		return sprRemoveTotalPrice;
	}

	protected void reset() {
		
		initialize();		
		
		app = new App();		
		
		setVisible(false);
		showLogin();
	}
	
	private void initialize() {
		
		app.getPedido().getCompra().clear();
		
		checkbLess15.setSelected(true);
		checkb1540.setSelected(true);
		checkbMore40.setSelected(true);
		
		listBooks.clearSelection();
		btnPurchase.setEnabled(false);
		spnCantidad.setValue(1);
		txTotalPrice.setText("0.00");
		
		int numRows = tableModel.getRowCount();
		for(int i = 0; i < numRows; i++)
			tableModel.removeRow(0);
	}
	
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.add(getMntmBookstoreHelp());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmLogOut() {
		if (mntmLogOut == null) {
			mntmLogOut = new JMenuItem("Log out");
			mntmLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			mntmLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		}
		return mntmLogOut;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		}
		return mntmExit;
	}
	private JSeparator getSprLogOutExit() {
		if (sprLogOutExit == null) {
			sprLogOutExit = new JSeparator();
		}
		return sprLogOutExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,	"Librería EII Oviedo\n"
							+ "Version: 1.0\n"
							+ "Proudly coded by Gonzalo Menéndez Borge\n"
							+ "HCI EII 2016");
				}
			});
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		}
		return mntmAbout;
	}
	private JMenu getMnFilter() {
		if (mnFilter == null) {
			mnFilter = new JMenu("Filter");
			mnFilter.setMnemonic('F');
			mnFilter.add(getMntmSelectAll());
			mnFilter.add(getSprSelectAllLess15());
			mnFilter.add(getMntmLess15());
			mnFilter.add(getMntm1540());
			mnFilter.add(getMntmMore40());
		}
		return mnFilter;
	}
	private JMenuItem getMntmLess15() {
		if (mntmLess15 == null) {
			mntmLess15 = new JMenuItem("< 15\u20AC");
			mntmLess15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkbLess15.doClick();
				}
			});
			mntmLess15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		}
		return mntmLess15;
	}
	private JMenuItem getMntm1540() {
		if (mntm1540 == null) {
			mntm1540 = new JMenuItem("15\u20AC - 40\u20AC");
			mntm1540.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkb1540.doClick();
				}
			});
			mntm1540.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
		}
		return mntm1540;
	}
	private JMenuItem getMntmMore40() {
		if (mntmMore40 == null) {
			mntmMore40 = new JMenuItem("> 40\u20AC");
			mntmMore40.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkbMore40.doClick();
				}
			});
			mntmMore40.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
		}
		return mntmMore40;
	}
	private JSeparator getSprSelectAllLess15() {
		if (sprSelectAllLess15 == null) {
			sprSelectAllLess15 = new JSeparator();
		}
		return sprSelectAllLess15;
	}
	private JMenuItem getMntmSelectAll() {
		if (mntmSelectAll == null) {
			mntmSelectAll = new JMenuItem("Select All");
			mntmSelectAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkbLess15.setSelected(true);
					checkb1540.setSelected(true);
					checkbMore40.setSelected(true);
				}
			});
			mntmSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSelectAll;
	}
	private JMenuItem getMntmReset() {
		if (mntmReset == null) {
			mntmReset = new JMenuItem("Reset");
			mntmReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					initialize();
				}
			});
			mntmReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		}
		return mntmReset;
	}
	private JMenuItem getMntmBookstoreHelp() {
		if (mntmBookstoreHelp == null) {
			mntmBookstoreHelp = new JMenuItem("Bookstore help");
			mntmBookstoreHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmBookstoreHelp;
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
		   hb.enableHelpKey(login.getRootPane(), "login", hs);
		   hb.enableHelpOnButton(mntmBookstoreHelp, "intro", hs);
		   hb.enableHelp(pnWest, "filter", hs);
		   hb.enableHelp(pnCenter, "addBooks", hs);
		   hb.enableHelp(pnEast, "addBooks", hs);
		   hb.enableHelp(pnSouth, "modifyOrder", hs);
		 }

	protected void setVisibility(boolean visibility) {
		this.visible = visibility;
	}
	private JPanel getPnNorth() {
		if (pnNorth == null) {
			pnNorth = new JPanel();
			GroupLayout gl_pnNorth = new GroupLayout(pnNorth);
			gl_pnNorth.setHorizontalGroup(
				gl_pnNorth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnNorth.createSequentialGroup()
						.addGap(168)
						.addComponent(getLblWelcome(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(167))
			);
			gl_pnNorth.setVerticalGroup(
				gl_pnNorth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnNorth.createSequentialGroup()
						.addGap(6)
						.addComponent(getLblWelcome(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(4))
			);
			pnNorth.setLayout(gl_pnNorth);
		}
		return pnNorth;
	}
}
