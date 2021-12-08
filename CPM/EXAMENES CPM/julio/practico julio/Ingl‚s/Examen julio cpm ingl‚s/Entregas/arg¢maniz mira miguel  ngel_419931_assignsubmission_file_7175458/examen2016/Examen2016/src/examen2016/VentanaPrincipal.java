package examen2016;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.Cliente;
import logica.Fichero;
import logica.FiltraLibros;
import logica.Libro;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JList;

import java.awt.FlowLayout;

import javax.swing.JSlider;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel pnBienvenida;
	private Cliente cliente;
	private JTextField txtBienvenida;
	private JPanel pnFiltro;
	private JPanel pnCesta;
	private JPanel pnLibros;
	private JList list;
	private JPanel pnSlider;
	private JTextPane txpnResumen;
	private JMenuBar menuBar;
	private JMenu mnAcercaDe;
	private JMenuItem mntmAyuda;
	private DefaultListModel<String> listModel;
	private List<Libro> libros;
	private JList list_1;
	private JButton btnAdd;
	private JButton btnRemove;
	private DefaultListModel listModel1;
	private JRadioButton rdbtnLowerThan;
	private JRadioButton rdbtnBetween;
	private JRadioButton rdbtnGreaterThan;
	private JRadioButton rdbtnNoFilter;
	private FiltraLibros filtro;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Cliente cliente) {
		setPreferredSize(new Dimension(1000, 1000));
		setBackground(Color.WHITE);
		setResizable(false);
		this.cliente = cliente;
		setVisible(true);
		setTitle("EII book shop Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/libreria.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnBienvenida());
		contentPane.add(getPnFiltro());
		contentPane.add(getPnCesta());
		contentPane.add(getPnLibros());
		contentPane.add(getScrollPane());

		libros = new ArrayList<Libro>();
		filtro = new FiltraLibros();
	}

	private JPanel getPnBienvenida() {
		if (pnBienvenida == null) {
			pnBienvenida = new JPanel();
			pnBienvenida.setBounds(5, 5, 579, 24);
			pnBienvenida.setBorder(null);
			pnBienvenida.setBackground(Color.WHITE);
			pnBienvenida.add(getTxtBienvenida());
		}
		return pnBienvenida;
	}

	private JTextField getTxtBienvenida() {
		if (txtBienvenida == null) {
			txtBienvenida = new JTextField();
			txtBienvenida.setBorder(null);
			txtBienvenida.setBackground(Color.WHITE);
			txtBienvenida.setEditable(false);
			txtBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
			txtBienvenida.setText("Welcome to the book shop "
					+ cliente.getNombre());
			txtBienvenida.setColumns(30);
		}
		return txtBienvenida;
	}

	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.setBounds(5, 29, 153, 228);
			pnFiltro.setBackground(Color.WHITE);
			pnFiltro.setBorder(new TitledBorder(null, "Filter:",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnFiltro.setLayout(new BorderLayout(0, 0));
			pnFiltro.add(getPnSlider(), BorderLayout.CENTER);
		}
		return pnFiltro;
	}

	private JPanel getPnCesta() {
		if (pnCesta == null) {
			pnCesta = new JPanel();
			pnCesta.setBorder(new TitledBorder(null, "Your purchase:",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnCesta.setBounds(419, 29, 165, 228);
			pnCesta.setBackground(Color.WHITE);
			pnCesta.setLayout(null);
			pnCesta.add(getList_1());
			pnCesta.add(getBtnAdd());
			pnCesta.add(getBtnRemove());
		}
		return pnCesta;
	}

	private JPanel getPnLibros() {
		if (pnLibros == null) {
			pnLibros = new JPanel();
			pnLibros.setBorder(new TitledBorder(null, "Available books:",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnLibros.setBounds(168, 29, 240, 228);
			pnLibros.setBackground(Color.WHITE);
			pnLibros.add(getListLibr());
		}
		return pnLibros;
	}

	private JList getListLibr() {

		if (list == null) {
			listModel = new DefaultListModel();
			Fichero fichero = new Fichero();
			libros = fichero.leerFicheroLibros();
			for (Libro libro : libros) {
				listModel.addElement(libro.getTitulo());
			}
			list = new JList(listModel);
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String titulo = list.getSelectedValue().toString();
					libros = fichero.getLibros();
					for(Libro libro : libros){
						if(libro.getTitulo().equals(titulo)){
							txpnResumen.setText("Autor: " +libro.getAutor()+"\nTipo: "+libro.getTipo()+
									"\nPrecio: "+libro.getPrecio()+"€\nEditor: "+
									libro.getEditor()+"\nResumen: "+libro.getResumen());
						}
					}
				}
			});
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return list;
	}

	private JPanel getPnSlider() {
		if (pnSlider == null) {
			pnSlider = new JPanel();
			pnSlider.setBackground(Color.WHITE);
			pnSlider.setLayout(null);
			pnSlider.add(getRdbtnLowerThan());
			pnSlider.add(getRdbtnBetween());
			pnSlider.add(getRdbtnGreaterThan());
			pnSlider.add(getRdbtnNoFilter());
		}
		return pnSlider;
	}

	private JTextPane getTxpnResumen() {
		if (txpnResumen == null) {
			txpnResumen = new JTextPane();
		}
		return txpnResumen;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnAcercaDe());
		}
		return menuBar;
	}

	private JMenu getMnAcercaDe() {
		if (mnAcercaDe == null) {
			mnAcercaDe = new JMenu("Acerca de");
			mnAcercaDe.setMnemonic('a');
			mnAcercaDe.add(getMntmAyuda());
		}
		return mnAcercaDe;
	}

	private JMenuItem getMntmAyuda() {
		if (mntmAyuda == null) {
			mntmAyuda = new JMenuItem("Ayuda");
			mntmAyuda.setMnemonic('y');
			mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmAyuda;
	}

	private JList getList_1() {
		if (list_1 == null) {
			listModel1 = new DefaultListModel();
			list_1 = new JList(listModel1);
			list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list_1.setBounds(10, 60, 145, 92);
		}
		return list_1;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String string = list.getSelectedValue().toString();
					if (string != null) {
						listModel1.addElement(string);
					}
				}
			});
			btnAdd.setBounds(10, 26, 59, 23);
		}
		return btnAdd;
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index = list_1.getSelectedIndex();
					if (index < 0) {
						listModel1.remove(index);
					}
				}
			});
			btnRemove.setBounds(79, 26, 76, 23);
		}
		return btnRemove;
	}

	private JRadioButton getRdbtnLowerThan() {
		if (rdbtnLowerThan == null) {
			rdbtnLowerThan = new JRadioButton(" lower than 15\u20AC");
			rdbtnLowerThan.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					disabledAllButtons();
					rdbtnLowerThan.setSelected(true);
					listModel.removeAllElements();
					listModel.clear();
					libros = new ArrayList<Libro>();
					libros = filtro.getLibrosFiltrados(0, 14.99);
					for (Libro libro : libros) {
						listModel.addElement(libro.getTitulo());
					}
				}
			});
			rdbtnLowerThan.setBackground(Color.WHITE);
			rdbtnLowerThan.setBounds(6, 7, 105, 23);
		}
		return rdbtnLowerThan;
	}

	private JRadioButton getRdbtnBetween() {
		if (rdbtnBetween == null) {
			rdbtnBetween = new JRadioButton("between 15 & 40\u20AC");

			rdbtnBetween.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					disabledAllButtons();
					rdbtnBetween.setSelected(true);
					listModel.removeAllElements();
					listModel.clear();
					libros = new ArrayList<Libro>();
					libros = filtro.getLibrosFiltrados(15, 40);
					for (Libro libro : libros) {
						listModel.addElement(libro.getTitulo());
					}
				}
			});
			rdbtnBetween.setBackground(Color.WHITE);
			rdbtnBetween.setBounds(5, 33, 133, 23);
		}
		return rdbtnBetween;
	}

	private JRadioButton getRdbtnGreaterThan() {
		if (rdbtnGreaterThan == null) {
			rdbtnGreaterThan = new JRadioButton("greater than 40\u20AC");
			rdbtnGreaterThan.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					disabledAllButtons();
					rdbtnGreaterThan.setSelected(true);
					listModel.removeAllElements();
					listModel.clear();
					libros = new ArrayList<Libro>();
					libros = filtro.getLibrosFiltrados(40.01, 200);
					for (Libro libro : libros) {
						listModel.addElement(libro.getTitulo());
					}
				}
			});
			rdbtnGreaterThan.setBackground(Color.WHITE);
			rdbtnGreaterThan.setBounds(5, 59, 109, 23);
		}
		return rdbtnGreaterThan;
	}

	private JRadioButton getRdbtnNoFilter() {
		if (rdbtnNoFilter == null) {
			rdbtnNoFilter = new JRadioButton("no filter");
			rdbtnNoFilter.setSelected(true);
			rdbtnNoFilter.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					disabledAllButtons();
					rdbtnNoFilter.setSelected(true);
					listModel.removeAllElements();
					listModel.clear();
					libros = new ArrayList<Libro>();
					Fichero fichero = new Fichero();
					libros = fichero.leerFicheroLibros();
					for (Libro libro : libros) {
						listModel.addElement(libro.getTitulo());
					}
				}
			});
			rdbtnNoFilter.setBackground(Color.WHITE);
			rdbtnNoFilter.setBounds(6, 85, 109, 23);
		}
		return rdbtnNoFilter;
	}

	private void disabledAllButtons() {
		int index = libros.size();
		for(int i = 0; i < index;i++){
			libros.remove(i);
		}
		for(int i = 0; i < listModel.getSize(); i++){
			listModel.removeElementAt(i);
		}
		list.clearSelection();
		rdbtnLowerThan.setSelected(false);
		rdbtnBetween.setSelected(false);
		rdbtnGreaterThan.setSelected(false);
		rdbtnNoFilter.setSelected(false);

	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(null, "More information:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setBounds(5, 261, 579, 79);
			scrollPane.setViewportView(getTxpnResumen());
		}
		return scrollPane;
	}
}
