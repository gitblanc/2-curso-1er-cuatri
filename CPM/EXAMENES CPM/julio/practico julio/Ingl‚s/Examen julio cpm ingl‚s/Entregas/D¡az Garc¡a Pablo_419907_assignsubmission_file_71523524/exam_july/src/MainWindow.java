import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.help.*;

import java.io.*;
import java.net.*;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;



public class MainWindow {

	private JFrame frame;
	private String client;
	private String id;
	private JTextField txtWelcomeToA;
	private int currentuser=0;
	private JList<String> list;
	private LoginDiag login;
	private JPanel panel;
	private JRadioButton rdbtnLessThan;
	private JRadioButton rdbtnBetweenAnd;
	private JLabel lblPriceFilter;
	private JRadioButton rdbtnMoreThan;
	private final ButtonGroup buttonFilterGroup = new ButtonGroup();
	private JPanel panel_1;
	private JTextField bookDcp;
	private JButton btnHelp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
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

		   hb.enableHelpKey(frame,"main", hs);
		   hb.enableHelpOnButton(btnHelp, "main", hs);
		   
		 }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login = new LoginDiag();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		login.setModal(true);
		while (!login.status){login= new LoginDiag();}
		currentuser=login.currentUser;
		client=login.clients[currentuser];
		id=login.id[currentuser];
		frame= new JFrame();
		frame.setBounds(100, 100, 680, 519);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getTxtWelcomeToA(), BorderLayout.NORTH);
		frame.getContentPane().add(getList(), BorderLayout.CENTER);
		frame.getContentPane().add(getPanel(), BorderLayout.WEST);
		frame.getContentPane().add(getPanel_1(), BorderLayout.EAST);
		frame.setVisible(true);
	}
	private JTextField getTxtWelcomeToA() {
		if (txtWelcomeToA == null) {
			txtWelcomeToA = new JTextField();
			txtWelcomeToA.setEditable(false);
			txtWelcomeToA.setHorizontalAlignment(SwingConstants.CENTER);
			txtWelcomeToA.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 16));
			txtWelcomeToA.setText("Welcome to a little book store, "+client.split(":")[0]);
			txtWelcomeToA.setColumns(10);
		}
		return txtWelcomeToA;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setName("Book list");
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					bookDcp.setText("book description");
				}
			});
		}
		return list;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblPriceFilter = new GridBagConstraints();
			gbc_lblPriceFilter.insets = new Insets(0, 0, 5, 0);
			gbc_lblPriceFilter.gridx = 0;
			gbc_lblPriceFilter.gridy = 0;
			panel.add(getLblPriceFilter(), gbc_lblPriceFilter);
			GridBagConstraints gbc_rdbtnLessThan = new GridBagConstraints();
			gbc_rdbtnLessThan.anchor = GridBagConstraints.NORTHWEST;
			gbc_rdbtnLessThan.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnLessThan.gridx = 0;
			gbc_rdbtnLessThan.gridy = 1;
			panel.add(getRdbtnLessThan(), gbc_rdbtnLessThan);
			GridBagConstraints gbc_rdbtnBetweenAnd = new GridBagConstraints();
			gbc_rdbtnBetweenAnd.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnBetweenAnd.gridx = 0;
			gbc_rdbtnBetweenAnd.gridy = 2;
			panel.add(getRdbtnBetweenAnd(), gbc_rdbtnBetweenAnd);
			GridBagConstraints gbc_rdbtnMoreThan = new GridBagConstraints();
			gbc_rdbtnMoreThan.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnMoreThan.anchor = GridBagConstraints.WEST;
			gbc_rdbtnMoreThan.gridx = 0;
			gbc_rdbtnMoreThan.gridy = 3;
			panel.add(getRdbtnMoreThan(), gbc_rdbtnMoreThan);
			GridBagConstraints gbc_btnHelp = new GridBagConstraints();
			gbc_btnHelp.gridx = 0;
			gbc_btnHelp.gridy = 15;
			panel.add(getBtnHelp(), gbc_btnHelp);
		}
		return panel;
	}
	private JRadioButton getRdbtnLessThan() {
		if (rdbtnLessThan == null) {
			rdbtnLessThan = new JRadioButton("Less than 15\u20AC");
			rdbtnLessThan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					list.setModel(new FiltraLibros(0));
				}
			});
			rdbtnLessThan.setSelected(true);
			buttonFilterGroup.add(rdbtnLessThan);
		}
		return rdbtnLessThan;
	}
	private JRadioButton getRdbtnBetweenAnd() {
		if (rdbtnBetweenAnd == null) {
			rdbtnBetweenAnd = new JRadioButton("Between 15 and 40\u20AC");
			rdbtnBetweenAnd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					list.setModel(new FiltraLibros(1));
				}
			});
			buttonFilterGroup.add(rdbtnBetweenAnd);
		}
		return rdbtnBetweenAnd;
	}
	private JLabel getLblPriceFilter() {
		if (lblPriceFilter == null) {
			lblPriceFilter = new JLabel("PRICE FILTER");
		}
		return lblPriceFilter;
	}
	private JRadioButton getRdbtnMoreThan() {
		if (rdbtnMoreThan == null) {
			rdbtnMoreThan = new JRadioButton("More than 40\u20AC");
			rdbtnMoreThan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					list.setModel(new FiltraLibros(2));
				}
			});
			buttonFilterGroup.add(rdbtnMoreThan);
		}
		return rdbtnMoreThan;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getBookDcp());
		}
		return panel_1;
	}
	private JTextField getBookDcp() {
		if (bookDcp == null) {
			bookDcp = new JTextField();
			bookDcp.setEditable(false);
			bookDcp.setColumns(10);
		}
		return bookDcp;
	}
	private JButton getBtnHelp() {
		if (btnHelp == null) {
			btnHelp = new JButton("Help");
		}
		return btnHelp;
	}
	
	
}
