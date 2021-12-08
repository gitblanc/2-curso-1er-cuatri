package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.help.*;

import java.io.File;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import logic.Book;
import logic.BoughtBook;
import logic.Library;
import logic.User;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;

import java.awt.Insets;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4509257327715869997L;
	private static boolean logged = false;
	private JPanel pnList;
	private JScrollPane scrollPane;
	private JList<String> lstBooks;
	private JPanel panel;
	private JTextArea taBook;
	private DefaultListModel<String> model;
	private DefaultTableModel tableModel;
	private JPanel pnFilter;
	private JCheckBox chck15;
	private JCheckBox chck40;
	private JCheckBox chckM;
	private JButton btnRefresh;
	private JPanel pnSouth;
	private JPanel pnButtons;
	private JButton btnBuy;
	private JButton btnCancel;
	private JPanel pnEast;
	private static JLabel lblWelcome;
	private JLabel lblPrice;
	private JPanel pnPrice;
	private JTextField txPrice;
	private JPanel pnCenter;
	private JButton btnAddBook;
	private JScrollPane scTable;
	private JTable table;
	private ArrayList<BoughtBook> boughtbooks = new ArrayList<BoughtBook>();
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JMenu mnAbout;
	private JMenuItem mntmHelp;
	
	public void SetLogged(boolean logged) {
		this.logged = logged;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					while(!logged) {
					LoginDialog log = new LoginDialog(frame);
					log.setLocationRelativeTo(null);
					log.setModal(true);
					log.setVisible(true);
					}
					frame.setVisible(true);
					getLblWelcome().setText("Welcome to our shop," + User.getName());
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
		setTitle("Library");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/libreria.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 621);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPnSouth(), BorderLayout.SOUTH);
		getContentPane().add(getPnList(), BorderLayout.WEST);
		getContentPane().add(getPnFilter(), BorderLayout.NORTH);
		getContentPane().add(getPnEast(), BorderLayout.EAST);
		getContentPane().add(getPnCenter(), BorderLayout.CENTER);
		tableModel = new DefaultTableModel();
		tableModel.setColumnCount(3);
		Object[] obj = {"Title", "Units", "Price"};
		tableModel.setColumnIdentifiers(obj);
		getTable().setModel(tableModel);
		setJMenuBar(getMenuBar_1());
		Library.populateBooks();
		initBooks();
	}
	private void cargaAyuda() {

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
		   hb.enableHelpKey(getRootPane(),"indice", hs);
		   hb.enableHelpOnButton(getMntmHelp(), "indice", hs);
		   hb.enableHelp(getMntmHelp(), "indice", hs);
		   
	}
	private void reinit() {
		logged = false;
		while(!logged) {
			LoginDialog log = new LoginDialog(this);
			log.setLocationRelativeTo(null);
			log.setModal(true);
			log.setVisible(true);
			}
		boughtbooks = new ArrayList<BoughtBook>();
		getLblWelcome().setText("Welcome to our shop," + User.getName());
		tableModel = new DefaultTableModel();
		tableModel.setColumnCount(3);
		Object[] obj = {"Title", "Units", "Price"};
		tableModel.setColumnIdentifiers(obj);
		getTable().setModel(tableModel);
		getLblPrice().setText("0");
		initBooks();
		
	}
	private void initBooks() {
		getLstBooks().clearSelection();
		List<Book> list = Library.getBooks();
		model = new DefaultListModel<String>();
		for(Book bk : list) 
			model.addElement(bk.getTitle());
		getLstBooks().setModel(model);
	}
	private JPanel getPnList() {
		if (pnList == null) {
			pnList = new JPanel();
			pnList.setLayout(new BorderLayout(0, 0));
			pnList.add(getPanel(), BorderLayout.CENTER);
		}
		return pnList;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(220, 250));
			scrollPane.setMinimumSize(new Dimension(2, 2));
			scrollPane.setViewportView(getLstBooks());
		}
		return scrollPane;
	}
	protected JList<String> getLstBooks() {
		if (lstBooks == null) {
			lstBooks = new JList<String>();
			lstBooks.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					getTaBook().setText("");
					Book selected = Library.getBook(getLstBooks().getSelectedValue());
					if(selected != null) 
						getTaBook().setText(selected.toString());
					
				}
			});
		}
		return lstBooks;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1, 0, 25));
			panel.add(getScrollPane());
		}
		return panel;
	}
	private JTextArea getTaBook() {
		if (taBook == null) {
			taBook = new JTextArea();
			taBook.setWrapStyleWord(true);
			taBook.setLineWrap(true);
			taBook.setMargin(new Insets(5, 5, 5, 5));
			taBook.setRows(7);
			taBook.setPreferredSize(new Dimension(550, 150));
		}
		return taBook;
	}
	private JPanel getPnFilter() {
		if (pnFilter == null) {
			pnFilter = new JPanel();
			pnFilter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnFilter.add(getChck15());
			pnFilter.add(getChck40());
			pnFilter.add(getChckM());
			pnFilter.add(getBtnRefresh());
		}
		return pnFilter;
	}
	protected JCheckBox getChck15() {
		if (chck15 == null) {
			chck15 = new JCheckBox("< 15");
		}
		return chck15;
	}
	protected JCheckBox getChck40() {
		if (chck40 == null) {
			chck40 = new JCheckBox("15 - 40");
		}
		return chck40;
	}
	protected JCheckBox getChckM() {
		if (chckM == null) {
			chckM = new JCheckBox(" > 40");
		}
		return chckM;
	}
	private JButton getBtnRefresh() {
		if (btnRefresh == null) {
			btnRefresh = new JButton("Filter");
			btnRefresh.setMnemonic('F');
			btnRefresh.addActionListener(new FiltraLibros(this));
		}
		return btnRefresh;
	}
	private JPanel getPnSouth() {
		if (pnSouth == null) {
			pnSouth = new JPanel();
			pnSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnSouth.add(getTaBook());
			pnSouth.add(getPnButtons());
		}
		return pnSouth;
	}
	private JPanel getPnButtons() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.setLayout(new GridLayout(3, 0, 0, 0));
			pnButtons.add(getBtnAddBook());
			pnButtons.add(getBtnBuy());
			pnButtons.add(getBtnCancel());
		}
		return pnButtons;
	}
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Place Order");
			btnBuy.setMnemonic('P');
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Library.writeTotal(User.getID(), boughtbooks);
					reinit();
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
					reinit();
				}
			});
		}
		return btnCancel;
	}
	private JPanel getPnEast() {
		if (pnEast == null) {
			pnEast = new JPanel();
			pnEast.setLayout(new GridLayout(2, 1, 0, 0));
			pnEast.add(getLblWelcome());
			pnEast.add(getPnPrice());
		}
		return pnEast;
	}
	private static JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("");
			lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblWelcome;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Total Price:");
		}
		return lblPrice;
	}
	private JPanel getPnPrice() {
		if (pnPrice == null) {
			pnPrice = new JPanel();
			pnPrice.add(getLblPrice());
			pnPrice.add(getTxPrice());
		}
		return pnPrice;
	}
	private JTextField getTxPrice() {
		if (txPrice == null) {
			txPrice = new JTextField();
			txPrice.setEditable(false);
			txPrice.setColumns(10);
		}
		return txPrice;
	}
	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setLayout(new BorderLayout(0, 0));
			pnCenter.add(getScTable(), BorderLayout.CENTER);
		}
		return pnCenter;
	}
	private JButton getBtnAddBook() {
		if (btnAddBook == null) {
			btnAddBook = new JButton("AddBook");
			btnAddBook.setMnemonic('d');
			btnAddBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Book selected = Library.getBook(getLstBooks().getSelectedValue());
					BoughtBook bb = new BoughtBook();
					
					if(selected != null) {
						bb.setBook(selected);
						if(boughtbooks.contains(bb))
							bb = boughtbooks.get(boughtbooks.indexOf(bb));
						else
							boughtbooks.add(bb);
						bb.setUnits(bb.getUnits()+1);
						bb.setPrice(bb.getBook().calculatePrice(bb.getUnits()));
						
						tableModel.getDataVector().clear();
						tableModel.fireTableDataChanged();
						for(BoughtBook b : boughtbooks) {
							Object[] row = {b.getBook().getTitle(),b.getUnits(),b.getPrice()};
							tableModel.addRow(row);
						}
					}
					double total = 0;
					for(BoughtBook b : boughtbooks)
						total += b.getPrice();
					getTxPrice().setText(String.valueOf(total));
				}
			});
		}
		return btnAddBook;
	}
	private JScrollPane getScTable() {
		if (scTable == null) {
			scTable = new JScrollPane();
			scTable.setPreferredSize(new Dimension(300, 300));
			scTable.setViewportView(getTable());
		}
		return scTable;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnAbout());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.setMnemonic('F');
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			mntmExit.setMnemonic('x');
		}
		return mntmExit;
	}
	private JMenu getMnAbout() {
		if (mnAbout == null) {
			mnAbout = new JMenu("About");
			mnAbout.add(getMntmHelp());
		}
		return mnAbout;
	}
	private JMenuItem getMntmHelp() {
		if (mntmHelp == null) {
			mntmHelp = new JMenuItem("Help");
			mntmHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return mntmHelp;
	}
}
