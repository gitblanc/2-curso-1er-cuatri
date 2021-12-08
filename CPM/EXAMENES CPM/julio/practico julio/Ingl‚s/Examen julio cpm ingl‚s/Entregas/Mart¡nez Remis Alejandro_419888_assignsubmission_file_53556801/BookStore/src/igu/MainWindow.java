package igu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import java.awt.FlowLayout;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;

import javax.swing.JSeparator;

import java.awt.event.InputEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import java.net.*;
//import javax.help.*;


public class MainWindow extends JFrame {

	private JPanel pnGeneral;
	private JMenuBar menuBar;
	private JSplitPane splitPane;
	private JList jlOne;
	private JList jlTwo;
	private JPanel pnInformation;
	private JLabel lblWelcome;
	private JPanel pnFilterPrice;
	private JComboBox cbFilter;
	private JButton btnCancel;
	private JPanel pnButtons;
	private JButton btnNext;
	private JPanel pnPrice;
	private JLabel lblTxtPrice;
	private JTextField txtFinalPrice;
	private JMenu mnApplication;
	private JMenu mnHelp;
	private JMenuItem mntmDocumentation;
	private JSeparator separator;
	private JMenuItem mntmAbout;
	private JMenuItem mntmExit;
	private JComboBox comboBox;
	private JButton btnAdd;
	private JButton btnRemove;
	
	User user;
	
	/**
	 * Launch the application.
	 */
	public static void main(User[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow(args[0]);
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
	public MainWindow(User user) {
		setTitle("Book Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 709);
		setJMenuBar(getMenuBar_1());
		pnGeneral = new JPanel();
		pnGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnGeneral);
		pnGeneral.setLayout(new BorderLayout(0, 0));
		pnGeneral.add(getSplitPane());
		pnGeneral.add(getPnInformation(), BorderLayout.EAST);
		readBooks();
		this.user=user;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnApplication());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getJlOne());
			splitPane.setRightComponent(getJlTwo());
		}
		return splitPane;
	}
	private JList getJlOne() {
		if (jlOne == null) {
			jlOne = new JList();
			jlOne.setModel(new AbstractListModel() {
				String[] values = new String[] {"Testing", "Testing2", "Testing 3"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			jlOne.setToolTipText("Books that are currently in the store");
		}
		return jlOne;
	}
	private JList getJlTwo() {
		if (jlTwo == null) {
			jlTwo = new JList();
			jlTwo.setToolTipText("Books that you want to buy");
		}
		return jlTwo;
	}
	private JPanel getPnInformation() {
		if (pnInformation == null) {
			pnInformation = new JPanel();
			pnInformation.setLayout(new BorderLayout(0, 0));
			pnInformation.add(getLblWelcome(), BorderLayout.NORTH);
			pnInformation.add(getPnFilterPrice(), BorderLayout.CENTER);
			pnInformation.add(getPanel_1(), BorderLayout.SOUTH);
		}
		return pnInformation;
	}
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome to the book store Ana");
		}
		return lblWelcome;
	}
	private JPanel getPnFilterPrice() {
		if (pnFilterPrice == null) {
			pnFilterPrice = new JPanel();
			pnFilterPrice.setLayout(null);
			pnFilterPrice.add(getPnPrice());
		}
		return pnFilterPrice;
	}
	private JComboBox getCbFilter() {
		if (cbFilter == null) {
			cbFilter = new JComboBox();
			cbFilter.setBounds(0, 11, 193, 20);
			cbFilter.setModel(new DefaultComboBoxModel(new String[] {"Filter books by price...", "Less than 15 euros", "Between 15 and 40 (both included)", "More than 40"}));
		}
		return cbFilter;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return btnCancel;
	}
	private JPanel getPanel_1() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.add(getBtnNext());
			pnButtons.add(getBtnCancel());
		}
		return pnButtons;
	}
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					grabarFichero();
					System.exit(0);
				}
			});
		}
		return btnNext;
	}
	private JPanel getPnPrice() {
		if (pnPrice == null) {
			pnPrice = new JPanel();
			pnPrice.setBounds(0, 20, 193, 573);
			pnPrice.setLayout(null);
			pnPrice.add(getLblTxtPrice());
			pnPrice.add(getCbFilter());
			pnPrice.add(getTxtFinalPrice());
			pnPrice.add(getComboBox());
			pnPrice.add(getBtnAdd());
			pnPrice.add(getBtnRemove());
		}
		return pnPrice;
	}
	private JLabel getLblTxtPrice() {
		if (lblTxtPrice == null) {
			lblTxtPrice = new JLabel("The final price is:");
			lblTxtPrice.setBounds(0, 361, 193, 14);
		}
		return lblTxtPrice;
	}
	private JTextField getTxtFinalPrice() {
		if (txtFinalPrice == null) {
			txtFinalPrice = new JTextField();
			txtFinalPrice.setEditable(false);
			txtFinalPrice.setEnabled(true);
			txtFinalPrice.setHorizontalAlignment(SwingConstants.CENTER);
			txtFinalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtFinalPrice.setText("0\u20AC");
			txtFinalPrice.setBounds(10, 386, 130, 68);
			txtFinalPrice.setColumns(10);
		}
		return txtFinalPrice;
	}
	private JMenu getMnApplication() {
		if (mnApplication == null) {
			mnApplication = new JMenu("Application");
			mnApplication.setMnemonic('A');
			mnApplication.add(getMenuItem_3());
		}
		return mnApplication;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.add(getMenuItem_1());
			mnHelp.add(getSeparator());
			mnHelp.add(getMenuItem_2());
		}
		return mnHelp;
	}
	private JMenuItem getMenuItem_1() {
		if (mntmDocumentation == null) {
			mntmDocumentation = new JMenuItem("Documentation");
			mntmDocumentation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//cargaAyuda();
				}
			});
			mntmDocumentation.setMnemonic('D');
			mntmDocumentation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmDocumentation;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMenuItem_2() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(rootPane, "This application has been created by Alejandro Martínez Remis (CPM - 2015/2016)");
				}
			});
			mntmAbout.setMnemonic('A');
		}
		return mntmAbout;
	}
	private JMenuItem getMenuItem_3() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmExit.setMnemonic('E');
		}
		return mntmExit;
	}
	
	

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setBounds(57, 125, 89, 23);
		}
		return btnAdd;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.setBounds(57, 159, 89, 23);
		}
		return btnRemove;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			comboBox.setBounds(10, 126, 37, 20);
		}
		return comboBox;
	}
	
	
	void readBooks() {
	    String nombreFichero = "libros.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        loadBook(trozos);
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

	private void loadBook(String[] trozos) {
		Book book = new Book(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], trozos[6]);
		
	}
	
	
	
	public void grabarFichero() {
	    String nombreFichero =user.getId() +".dat";//id.dat
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		fichero.write(linea);
		fichero.newLine(); //Si se quiere añadir un salto de línea
		//...
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }
	
	public void createUser(User user){
		this.user = user;
	}
}
