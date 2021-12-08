import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Articulo;
import logic.Filemanager;
import logic.FiltraLibros;
import logic.Pedido;
import logic.User;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.Color;
import javax.help.*;
import java.net.*;


public class Principal extends JFrame {

	public User usuario;
	public ArrayList<User> users = new ArrayList<User>();
	public Filemanager files= new Filemanager();
	public Articulo book;
	public float precio;
	public Pedido pedido;
	
	private JPanel contentPane;


	private Registro dialogo;
	private JPanel panel;
	private JLabel label;
	private JScrollPane scrollPane;
	private JList list;
	private JButton btnConfirmar;
	private JButton btnCancel;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextPane txtData;
	private JLabel lblListOfBooks;
	private JLabel lblBookData;
	private JLabel lblTotalPrice;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JTextField txtPrice;
	private String[] titles=new String[10];
	private ArrayList<Articulo> libros;
	private JLabel lblWelcomeToThe;
	private JPanel panel_2;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JButton btnRemove;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() 
	{
		setTitle("Principal Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 500);
		setResizable(false);
		files.leerFicheros();
		users=files.users;
		libros=files.articulos;
		titles=titulos();
		mostrarRegistro();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnConfirmar());
		contentPane.add(getBtnCancel());
		contentPane.add(getLblListOfBooks());
		contentPane.add(getLblBookData());
		contentPane.add(getLblTotalPrice());
		contentPane.add(getMenuBar_1());
		contentPane.add(getTxtPrice());
		contentPane.add(getLblWelcomeToThe());
		contentPane.add(getPanel_2());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnRemove());
		
	}
	
	
	public String[] titulos()
	{
		String[] aux= new String[libros.size()];
		for(int i=0;i<libros.size();i++)
		{
			String aux2 = libros.get(i).titulo;
			aux[i]=aux2;
		}
		return aux;
		
	}
	
	public void  mostrarRegistro()
	{

		dialogo = new Registro(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setModal(true);
		dialogo.setVisible(true);
	}
	
	public void cerrarRegistro()
	{
		usuario=dialogo.getUser();
		dialogo.dispose();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(91, 21, 318, 155);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getLabel(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(Principal.class.getResource("/img/libreria.jpg")));
		}
		return label;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(getList());
			scrollPane.setBounds(10, 230, 264, 139);
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			DefaultListModel dm= new DefaultListModel();
			for(int i=0;i<titles.length;i++)
			{
				dm.addElement(titles[i]);
			}
			
			list = new JList(dm);
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) 
				{
					if(list.getSelectedIndex()<libros.size())
					{
					Articulo libro = libros.get(list.getSelectedIndex());
					book=libro;
					datos(libro);
					}
				}

				
			});
			list.setBounds(118, 328, 1, 1);
		}
		return list;
	}
	
	private void datos(Articulo libro) 
	{
			String aux="";
			if(libro!=null)
			{
				aux=aux+"ISBN : "+libro.ISBN+"\n";
				aux=aux+"Title : "+libro.titulo+"\n";
				aux=aux+"Editor : "+libro.editor+"\n";
				aux=aux+"Author : "+libro.autor+"\n";
				aux=aux+"Summary : "+libro.descripcion+"\n";
				aux=aux+"Price : "+libro.price+"$ \n";
			}
			
			txtData.setText(aux);
					
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBounds(336, 438, 103, 23);
		}
		return btnConfirmar;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					exit();
				}
			});
			btnCancel.setBounds(447, 438, 89, 23);
		}
		return btnCancel;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("15$ or less");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					FiltraLibros filt= new FiltraLibros();
					String[] aux=filt.filtra10(libros);
					DefaultListModel m = (DefaultListModel) list.getModel();
					m.clear();
					for(int i=0;i<aux.length;i++)
					{
						m.addElement(aux[i]);
					}
					list.setModel(m);
					
				}
			});
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("15$-40$");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{

					FiltraLibros filt= new FiltraLibros();
					String[] aux=filt.filtra1040(libros);
					DefaultListModel m = (DefaultListModel) list.getModel();
					m.clear();
					for(int i=0;i<aux.length;i++)
					{
						m.addElement(aux[i]);
					}
					list.setModel(m);
					
				}
			});
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("40$ or more");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					FiltraLibros filt= new FiltraLibros();
					String[] aux=filt.filtra40(libros);
					DefaultListModel m = (DefaultListModel) list.getModel();
					m.clear();
					for(int i=0;i<aux.length;i++)
					{
						m.addElement(aux[i]);
					}
					list.setModel(m);
					
				}
			});
		}
		return btnNewButton_4;
	}
	private JTextPane getTxtData() {
		if (txtData == null) {
			txtData = new JTextPane();
		}
		return txtData;
	}
	private JLabel getLblListOfBooks() {
		if (lblListOfBooks == null) {
			lblListOfBooks = new JLabel("List of books:");
			lblListOfBooks.setBounds(10, 213, 89, 14);
		}
		return lblListOfBooks;
	}
	private JLabel getLblBookData() {
		if (lblBookData == null) {
			lblBookData = new JLabel("Book data:");
			lblBookData.setBounds(318, 213, 82, 14);
		}
		return lblBookData;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("Total price:");
			lblTotalPrice.setBounds(10, 414, 76, 14);
		}
		return lblTotalPrice;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 546, 21);
			menuBar.add(getMntmNewMenuItem());
		}
		return menuBar;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Help");
		}
		return mntmNewMenuItem;
	}
	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setText("price");
			txtPrice.setEditable(false);
			txtPrice.setBounds(10, 439, 86, 20);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}
	
	public void exit()
	{
		System.exit(0);
	}
	private JLabel getLblWelcomeToThe() {
		if (lblWelcomeToThe == null) {
			lblWelcomeToThe = new JLabel("Welcome to the book shop \n"+" "+usuario.name+" "+usuario.surname);
			lblWelcomeToThe.setForeground(new Color(184, 134, 11));
			lblWelcomeToThe.setBounds(79, 187, 348, 28);
		}
		return lblWelcomeToThe;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(10, 371, 270, 32);
			panel_2.add(getBtnNewButton_2());
			panel_2.add(getBtnNewButton_3());
			panel_2.add(getBtnNewButton_4());
		}
		return panel_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(328, 230, 221, 139);
			scrollPane_1.setViewportView(getTxtData());
		}
		return scrollPane_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Add");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					pedido.add(book);
					txtPrice.setText(pedido.precio+"$");
				}
			});
			btnNewButton.setBounds(125, 438, 63, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					pedido.remove(book);
					txtPrice.setText(pedido.precio+"$");
				}
			});
			btnRemove.setBounds(198, 438, 82, 23);
		}
		return btnRemove;
	}
	
	
}
