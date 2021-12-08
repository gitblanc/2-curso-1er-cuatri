package gui;

import javax.help.*;

import java.net.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLEditorKit.Parser;

import logic.Book;
import logic.FiltrarLibros;
import logic.LogedUser;
import logic.User;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;

import java.awt.CardLayout;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Book> books = new ArrayList<Book>();
	private JPanel pnWelcome;
	private JPanel pnList;
	private JTextField txtWelcome;
	private User currentLogedUser = new User("", "", "", "");
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenu mnFile;
	private JMenuItem mntmLogout;
	private JSeparator separator;
	private JMenuItem mntmExit;
	private JMenuItem mntmInfo;
	private JScrollPane scLibros;
	private JList listLibros;
	private JScrollPane scInfo;
	private JTextArea txtAreaInfo;
	private JPanel panel;
	private JButton btAccept;
	private JButton btCancel;
	private DefaultListModel modelLibros = new DefaultListModel();
	private JRadioButton rdBtLess;
	private JRadioButton rdBtBetween;
	private JRadioButton rdBtGreater;
	private JLabel lblFiltros;
	private int condition = 2;
	ButtonGroup bg = new ButtonGroup();
	private JPanel pnCompra;
	private JSpinner spCantidad;
	private JLabel lbCantidad;
	private JTextField txtPrecioTotal;
	private JLabel lblTotal;
	private JButton btnAdd;
	private ArrayList<Book> comprados = new ArrayList<Book>();
	private double compraTotal = 0;
	ArrayList<String> titulosEvaluados;
	ArrayList<Book> filtrados = new ArrayList<Book>();
	
	
	public void setCurrentLogedUser(User currentLogedUser) {
		this.currentLogedUser = currentLogedUser;
	}

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
		setTitle("Libreria \"Book Worm\"");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/libreria.jpg")));
		cargarUsers();
		cargarLibros();
		cargaAyuda();
		
		LoginDialog dialogo = new LoginDialog(users);
		dialogo.setLocationRelativeTo(null);
		dialogo.setModal(true);
		dialogo.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 385);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnWelcome(), BorderLayout.NORTH);
		contentPane.add(getPnList(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		fillLibros();
		bg.add(rdBtLess);
		bg.add(rdBtBetween);
		bg.add(rdBtGreater);
		
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

		  // hb.enableHelpKey(getRootPane(),"html_inicio", hs);
		   //hb.enableHelpOnButton(componente, "html_inicio", hs);
		   
		 }
	

	void cargarUsers() {
		String nombreFichero = "clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        users.add(new User(trozos[0],trozos[1],trozos[2],trozos[3]));
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
	
	void cargarLibros() {
		String nombreFichero = "libros.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        books.add(new Book(trozos[0],trozos[1],trozos[2],trozos[3],trozos[4],trozos[5], Double.valueOf(trozos[6])));
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

	

	private JPanel getPnWelcome() {
		if (pnWelcome == null) {
			pnWelcome = new JPanel();
			pnWelcome.add(getTxtWelcome());
		}
		return pnWelcome;
	}
	private JPanel getPnList() {
		if (pnList == null) {
			pnList = new JPanel();
			pnList.setLayout(null);
			pnList.add(getScLibros());
			pnList.add(getScrollPane_1());
			pnList.add(getRdBtLess());
			pnList.add(getRdBtBetween());
			pnList.add(getRdBtGreater());
			pnList.add(getLblFiltros());
			pnList.add(getPnCompra());
		}
		return pnList;
	}
	private JTextField getTxtWelcome() {
		if (txtWelcome == null) {
			txtWelcome = new JTextField();
			txtWelcome.setHorizontalAlignment(SwingConstants.CENTER);
			txtWelcome.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtWelcome.setEditable(false);
			txtWelcome.setText("Welcome: "+ LogedUser.logedUser.name);
			txtWelcome.setColumns(20);
		}
		return txtWelcome;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmInfo());
		}
		return mnHelp;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmLogout());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmLogout() {
		if (mntmLogout == null) {
			mntmLogout = new JMenuItem("Logout");
			mntmLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					reset();
				}
			});
		}
		return mntmLogout;
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
					
					System.exit(0);
					
				}
			});
		}
		return mntmExit;
	}
	private JMenuItem getMntmInfo() {
		if (mntmInfo == null) {
			mntmInfo = new JMenuItem("Info");
		}
		return mntmInfo;
	}
	private JScrollPane getScLibros() {
		if (scLibros == null) {
			scLibros = new JScrollPane();
			scLibros.setBounds(10, 11, 152, 194);
			scLibros.setViewportView(getListLibros());
		}
		return scLibros;
	}
	private JList getListLibros() {
		if (listLibros == null) {
			listLibros = new JList(modelLibros);
			listLibros.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int selection = listLibros.getSelectedIndex();
					Book b = books.get(selection);
					
					txtAreaInfo.setText(" ISBN: "+ b.getISBN() + "\n " +
							"Title: " + b.getTitle() + "\n " +
							"Editor: " + b.getEditor() + "\n " +
							"Author: " + b.getAuthor() + "\n " +
							"Type: " + b.getType() + "\n " +
							"Summary: " + b.getSummary() + "\n " +
							"Price: "+ b.getPrice() + " $ \n ");	
					
					txtAreaInfo.append(mostrarCompra());
				}
			});
		}
		return listLibros;
	}
	private JScrollPane getScrollPane_1() {
		if (scInfo == null) {
			scInfo = new JScrollPane();
			scInfo.setBounds(172, 11, 249, 194);
			scInfo.setViewportView(getTxtAreaInfo());
		}
		return scInfo;
	}
	private JTextArea getTxtAreaInfo() {
		if (txtAreaInfo == null) {
			txtAreaInfo = new JTextArea();
		}
		return txtAreaInfo;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtAccept());
			panel.add(getBtCancel());
		}
		return panel;
	}
	private JButton getBtAccept() {
		if (btAccept == null) {
			btAccept = new JButton("Aceptar");
			btAccept.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					reset();
					txtAreaInfo.setText("");;
					grabarFichero(LogedUser.logedUser.dni + ".dat");
					LoginDialog dialogo = new LoginDialog(users);
					dialogo.setLocationRelativeTo(null);
					dialogo.setModal(true);
					dialogo.setVisible(true);
				}
			});
			btAccept.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return btAccept;
	}
	
	public void reset()
	{
		txtPrecioTotal.setText("0.0$");
		comprados = new ArrayList<Book>();
		compraTotal = 0;
	}
	
	public boolean yaEvaluados(ArrayList<Book> comprados)
	{

		for(Book b : comprados)
		{
			if(titulosEvaluados.contains(b.title))
			{
				titulosEvaluados.add(b.title);
				return true;
			}
			
		}
		
		return false;
	}
	
	public void grabarFichero(String nombreFichero) {
		 titulosEvaluados = new ArrayList<String>();
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		for(Book b : comprados)
		{
			if(!yaEvaluados(comprados))
			{
				fichero.write(b.getISBN()+":"+b.title+":"+ cantidadComprados(b.ISBN));
				fichero.newLine(); //Si se quiere añadir un salto de línea
			}
		}
		
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }
	
	private int cantidadComprados(String iSBN) {
		int counter=0;
		for(Book b : comprados)
		{
			if(b.ISBN.equals(iSBN))
			{
				counter++;
			}
		}
		
		return counter;
	}

	private JButton getBtCancel() {
		if (btCancel == null) {
			btCancel = new JButton("Cancelar");
			btCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					reset();
					
					LoginDialog dialogo = new LoginDialog(users);
					dialogo.setLocationRelativeTo(null);
					dialogo.setModal(true);
					dialogo.setVisible(true);
					
				}
			});
			btCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return btCancel;
	}
	private JRadioButton getRdBtLess() {
		if (rdBtLess == null) {
			rdBtLess = new JRadioButton("< 15 $");
			rdBtLess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					condition =1;
					modelLibros.clear();
					fillLibros();
				}
			});
			rdBtLess.setBounds(440, 34, 126, 23);
		}
		return rdBtLess;
	}
	private JRadioButton getRdBtBetween() {
		if (rdBtBetween == null) {
			rdBtBetween = new JRadioButton("15-40 $");
			rdBtBetween.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					condition =2;
					modelLibros.clear();
					fillLibros();
				}
			});
			rdBtBetween.setSelected(true);
			rdBtBetween.setBounds(440, 60, 109, 23);
		}
		return rdBtBetween;
	}
	private JRadioButton getRdBtGreater() {
		if (rdBtGreater == null) {
			rdBtGreater = new JRadioButton(">40 $");
			rdBtGreater.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					condition = 3;
					modelLibros.clear();
					fillLibros();
					
				}
			});
			rdBtGreater.setBounds(440, 91, 109, 23);
		}
		return rdBtGreater;
	}
	private JLabel getLblFiltros() {
		if (lblFiltros == null) {
			lblFiltros = new JLabel("Filtros: ");
			lblFiltros.setBounds(431, 13, 118, 14);
		}
		return lblFiltros;
	}
	
	public void fillLibros()
	{
		FiltrarLibros fl = new FiltrarLibros(condition);
		filtrados = fl.aplicarFiltro(books);
		
		for(Book b : filtrados)
		modelLibros.addElement(b.title);
	}
	private JPanel getPnCompra() {
		if (pnCompra == null) {
			pnCompra = new JPanel();
			pnCompra.setBorder(new TitledBorder(null, "Compra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnCompra.setBounds(431, 121, 151, 120);
			pnCompra.setLayout(null);
			pnCompra.add(getSpCantidad());
			pnCompra.add(getLbCantidad());
			pnCompra.add(getTxtPrecioTotal());
			pnCompra.add(getLblTotal());
			pnCompra.add(getBtnAdd());
		}
		return pnCompra;
	}
	private JSpinner getSpCantidad() {
		if (spCantidad == null) {
			spCantidad = new JSpinner();
			spCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spCantidad.setBounds(112, 25, 29, 20);
		}
		return spCantidad;
	}
	private JLabel getLbCantidad() {
		if (lbCantidad == null) {
			lbCantidad = new JLabel("Cantidad");
			lbCantidad.setLabelFor(getSpCantidad());
			lbCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbCantidad.setBounds(14, 27, 88, 14);
		}
		return lbCantidad;
	}
	private JTextField getTxtPrecioTotal() {
		if (txtPrecioTotal == null) {
			txtPrecioTotal = new JTextField();
			txtPrecioTotal.setText("0.00 $");
			txtPrecioTotal.setEditable(false);
			txtPrecioTotal.setBounds(90, 68, 51, 20);
			txtPrecioTotal.setColumns(10);
		}
		return txtPrecioTotal;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setLabelFor(getTxtPrecioTotal());
			lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTotal.setBounds(14, 71, 46, 14);
		}
		return lblTotal;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(listLibros.getSelectedIndex() >=0 && (int)spCantidad.getValue() > 0)
					{
						int selection = listLibros.getSelectedIndex();
						Book b = filtrados.get(selection);
						for(int i = 0; i<(int)spCantidad.getValue();i++)
						{
							comprados.add(b);
							compraTotal = compraTotal + b.price;
							txtPrecioTotal.setText(compraTotal + " $");
						}
					}
					
					txtAreaInfo.append(mostrarCompra());
					
				}
			});
			btnAdd.setBounds(14, 96, 58, 23);
		}
		return btnAdd;
	}
	
	public String mostrarCompra()
	{
		String aux = "\n\n------COMPRA TOTAL:";
		for(Book b : comprados)
		{
			aux = aux +" ISBN: "+ b.getISBN() + "\n " +
					"Title: " + b.getTitle() + "\n " +
					"Editor: " + b.getEditor() + "\n " +
					"Author: " + b.getAuthor() + "\n " +
					"Type: " + b.getType() + "\n " +
					"Summary: " + b.getSummary() + "\n " +
					"Price: "+ b.getPrice() + " $ \n -------------------------";
		}
		
		return aux;
	}
}
