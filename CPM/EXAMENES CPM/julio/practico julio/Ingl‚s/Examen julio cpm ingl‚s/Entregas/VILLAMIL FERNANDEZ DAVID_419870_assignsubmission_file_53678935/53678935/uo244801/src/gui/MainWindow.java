package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.*;

import javax.help.*;
import java.net.*;

import java.io.*;
import java.awt.Toolkit;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

public class MainWindow extends JFrame {
	
	private MainWindow reference = this;
	private ArrayList<Client> clients;
	private ArrayList<Book> books;
	private DefaultListModel<String> modeloTabla;
	private FiltraLibros fl;
	private DefaultListModel<String> modeloTablaRes;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnMessage;
	private JLabel lblWelcome;
	public JLabel lblName;
	private JPanel pnButtons;
	private JPanel pnButtons2;
	private JButton btAcept;
	private JButton btCancel;
	private JPanel pnPrecioFinal;
	private JLabel lblTotalPrice;
	private JLabel lblTotalPriceValue;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JScrollPane scrollPane_1;
	private JList<String> list_1;
	private JPanel panel_1;
	private JCheckBox chbLess15;
	private JCheckBox chbMiddle;
	private JCheckBox chbGreatter40;
	private JPanel panel_2;
	private JSpinner spinner;
	private JLabel lblNumberOfBooks;
	private JButton btEnviar;
	private JTextArea taDescription;
	private JMenuBar menuBar;
	private JMenu mnStore;
	private JMenuItem mntmExit;
	private JMenu mnHelp;
	private JMenuItem mntmIntroduction;
	private JSeparator separator;
	private JMenuItem mntmAbout;
	
	private double total;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(false);
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
		total = 0;
		cargaAyuda();
		fl = new FiltraLibros();
		modeloTabla = new DefaultListModel<String>();
		modeloTablaRes = new DefaultListModel<String>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/libreria.jpg")));
		setTitle("Book Store");
		leerFicheroClient();
		leerFicheroBook();
		Login login = new Login(clients, reference);
		login.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 557);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnMessage(), BorderLayout.NORTH);
		contentPane.add(getPnButtons(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
		
		list.setModel(modeloTabla);
		list_1.setModel(modeloTablaRes);
		
		fillList1(getChbLess15().isSelected(), getChbMiddle().isSelected(), getChbGreatter40().isSelected());
		
		showInfo();
	}
	
	private void showInfo(){
		String comp = list.getSelectedValue();
		for(Book b : books){
			if(b.getTitle().equals(comp)){
				taDescription.setText("ISBN: " + b.getIsbn() + " -Title: " + b.getTitle() + " -Editor: " + b.getEditor() + " -Author: " + b.getAuthor() + " -Type: " + b.getType() + " -Summary: "+ b.getSummary() + " -Price: " + String.valueOf(b.getPrice()));
			}
		}
	}
	private void fillList1(boolean less15, boolean middle, boolean greatter40){
		modeloTabla.clear();
		boolean toAdd = false;
		if(less15 || middle || greatter40){
			for(Book b : books){
				toAdd = false;
				if(less15 && b.getPrice()<15){
					toAdd = true;
				}
				else if(middle && b.getPrice()<=40 && b.getPrice()>=15){
					toAdd = true;
				}
				else if(greatter40 && b.getPrice()>40){
					toAdd = true;
				}
				
				
				if(toAdd){
					modeloTabla.addElement(b.getTitle());
				}
			}
		}
	}
	
	class FiltraLibros implements MouseListener{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent arg0) {
			fillList1(getChbLess15().isSelected(), getChbMiddle().isSelected(), getChbGreatter40().isSelected());
			showInfo();
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent arg0) {}

		@Override
		public void mouseExited(java.awt.event.MouseEvent arg0) {}

		@Override
		public void mousePressed(java.awt.event.MouseEvent arg0) {}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent arg0) {}


		
	}
	void leerFicheroClient() {
	    String nombreFichero = "files/clientes.dat";
	    String linea="";
	    clients = new ArrayList<Client>();
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        Client c = new Client(trozos[0], trozos[1], trozos[2], trozos[3]);
	        clients.add(c);
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
	
	void leerFicheroBook() {
	    String nombreFichero = "files/libros.dat";
	    String linea="";
	    books = new ArrayList<Book>();
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        Book b = new Book(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], Double.parseDouble(trozos[6]));
	        books.add(b);
	        modeloTabla.addElement(b.getTitle());
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

	private JPanel getPnMessage() {
		if (pnMessage == null) {
			pnMessage = new JPanel();
			pnMessage.setLayout(new GridLayout(1, 0, 0, 0));
			pnMessage.add(getLblWelcome());
			pnMessage.add(getLblName());
		}
		return pnMessage;
	}
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome");
			lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblWelcome.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblWelcome;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel(" ");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblName;
	}
	private JPanel getPnButtons() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.setLayout(new BorderLayout(0, 0));
			pnButtons.add(getPnButtons2(), BorderLayout.EAST);
			pnButtons.add(getPanel_1(), BorderLayout.CENTER);
		}
		return pnButtons;
	}
	private JPanel getPnButtons2() {
		if (pnButtons2 == null) {
			pnButtons2 = new JPanel();
			pnButtons2.add(getBtAcept());
			pnButtons2.add(getBtCancel());
		}
		return pnButtons2;
	}
	private JButton getBtAcept() {
		if (btAcept == null) {
			btAcept = new JButton("Acept");
			btAcept.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
		}
		return btAcept;
	}
	public void grabarFichero() {
	    String nombreFichero = "result.txt";
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		fichero.write(linea);
		fichero.newLine(); 
		//END OF EXAM
//		for(int i=0; i<)
//			modeloTablaRes.elementAt(arg0)
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }
	private JButton getBtCancel() {
		if (btCancel == null) {
			btCancel = new JButton("Cancel");
			btCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modeloTabla.clear();
					modeloTablaRes.clear();
					lblTotalPriceValue.setText("0");
					chbGreatter40.setSelected(true);
					chbMiddle.setSelected(true);
					chbLess15.setSelected(true);
					fillList1(getChbLess15().isSelected(), getChbMiddle().isSelected(), getChbGreatter40().isSelected());
					showInfo();
					total = 0;
				}
			});
		}
		return btCancel;
	}
	private JPanel getPanel_1() {
		if (pnPrecioFinal == null) {
			pnPrecioFinal = new JPanel();
			pnPrecioFinal.setLayout(new GridLayout(0, 3, 0, 0));
			pnPrecioFinal.add(getLblTotalPrice());
			pnPrecioFinal.add(getLblTotalPriceValue());
			pnPrecioFinal.add(getLblNewLabel());
		}
		return pnPrecioFinal;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("Total price:");
			lblTotalPrice.setForeground(Color.RED);
			lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTotalPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblTotalPrice;
	}
	private JLabel getLblTotalPriceValue() {
		if (lblTotalPriceValue == null) {
			lblTotalPriceValue = new JLabel("0");
			lblTotalPriceValue.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTotalPriceValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTotalPriceValue.setForeground(Color.RED);
		}
		return lblTotalPriceValue;
	}
	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPane_1(), BorderLayout.WEST);
			panel.add(getScrollPane_1_1(), BorderLayout.CENTER);
			panel.add(getPanel_1_1(), BorderLayout.SOUTH);
		}
		return panel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JList<String> getList() {
		if (list == null) {
			list = new JList<String>();
		}
		return list;
	}
	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setColumnHeaderView(getList_1());
		}
		return scrollPane_1;
	}
	private JList<String> getList_1() {
		if (list_1 == null) {
			list_1 = new JList<String>();
		}
		return list_1;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			panel_1.add(getTaDescription());
			panel_1.add(getChbLess15());
			panel_1.add(getChbMiddle());
			panel_1.add(getChbGreatter40());
			panel_1.add(getPanel_2_1());
			panel_1.add(getBtEnviar());
			panel_1.addMouseListener(fl);
		}
		return panel_1;
	}
	private JCheckBox getChbLess15() {
		if (chbLess15 == null) {
			chbLess15 = new JCheckBox("X<15");
			chbLess15.setSelected(true);
		}
		return chbLess15;
	}
	private JCheckBox getChbMiddle() {
		if (chbMiddle == null) {
			chbMiddle = new JCheckBox("15<=X<=40");
			chbMiddle.setSelected(true);
		}
		return chbMiddle;
	}
	private JCheckBox getChbGreatter40() {
		if (chbGreatter40 == null) {
			chbGreatter40 = new JCheckBox("40<X");
			chbGreatter40.setSelected(true);
			//For trying because my MouseListener doesnt work
			chbGreatter40.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					fillList1(getChbLess15().isSelected(), getChbMiddle().isSelected(), getChbGreatter40().isSelected());
					
					showInfo();
				}
			});
		}
		return chbGreatter40;
	}
	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getSpinner());
			panel_2.add(getLblNumberOfBooks());
		}
		return panel_2;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
		}
		return spinner;
	}
	private JLabel getLblNumberOfBooks() {
		if (lblNumberOfBooks == null) {
			lblNumberOfBooks = new JLabel("Number of books");
		}
		return lblNumberOfBooks;
	}
	private JButton getBtEnviar() {
		if (btEnviar == null) {
			btEnviar = new JButton("To shopping list");
			btEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String res = list.getSelectedValue();
					for(Book b : books){
						if(b.getTitle().equals(res)){
							int a = (int) getSpinner().getValue();
							lblTotalPriceValue.setText(String.valueOf(total + b.getPrice() * a));
							total = total + b.getPrice() * a;
							modeloTablaRes.addElement(res + " - Nº of books: "+ String.valueOf(a)+ " - price: " + String.valueOf(b.getPrice() * a));
						}
					}
				}
			});
		}
		return btEnviar;
	}
	private JTextArea getTaDescription() {
		if (taDescription == null) {
			taDescription = new JTextArea();
		}
		return taDescription;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnStore());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnStore() {
		if (mnStore == null) {
			mnStore = new JMenu("Store");
			mnStore.add(getMntmExit());
		}
		return mnStore;
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
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmIntroduction());
			mnHelp.add(getSeparator());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmIntroduction() {
		if (mntmIntroduction == null) {
			mntmIntroduction = new JMenuItem("Introduction");
		}
		return mntmIntroduction;
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
					JOptionPane.showMessageDialog(null, "Exam module for CPM made by David Villamil Fernández");
				}
			});
		}
		return mntmAbout;
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

		hb.enableHelpKey(getRootPane(),"archivoHtml.html", hs);
		//hb.enableHelpOnButton(componente, "html_inicio", hs);
   
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\u20AC");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setForeground(Color.RED);
		}
		return lblNewLabel;
	}
}
