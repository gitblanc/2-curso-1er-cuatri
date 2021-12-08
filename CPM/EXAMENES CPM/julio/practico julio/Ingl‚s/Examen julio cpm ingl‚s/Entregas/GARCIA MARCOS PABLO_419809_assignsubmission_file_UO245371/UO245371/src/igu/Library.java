package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.FiltraLibros;
import logica.Libro;
import logica.ManejadorDatos;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class Library extends JFrame {

	private JPanel contentPane;
	
	private ManejadorDatos md;
	
	private ArrayList<String> array = new ArrayList<>();
	private Map<String, Integer> map = new HashMap<>();
	
	private Libro libroElegido;
	private String libroModificable;
	
	private int index;
	
	
	private JPanel panelTitulo;
	private JPanel panelBotones;
	private JPanel panelTables;
	private JPanel panelEspecificaciones;
	private JLabel lblTitle;
	private JButton btnOk;
	private JPanel panel40;
	private JPanel panel1540;
	private JPanel panel15;
	private JPanel panelFilter;
	private JLabel lblNewLabel;
	private JRadioButton radio15;
	private JRadioButton radio1540;
	private JRadioButton radio40;
	private JPanel panelAll;
	private JRadioButton radioAll;
	
	private ButtonGroup gr = new ButtonGroup();
	private JPanel panelElegidos;
	private JPanel panelDisponibles;
	private JPanel panelBotonElegidos;
	private JPanel panelBotonDisponibles;
	private JScrollPane scrollPaneElegidos;
	private JScrollPane scrollPaneDisponibles;
	private JList<String> listDisponibles;
	
	private ArrayList<Libro> libros;
	
	private String DNI;
	
	private DefaultListModel<String> listaElegidos;
	private DefaultListModel<String> listaDisponibles;
	
	private JMenuBar menuBar;
	private JMenu menuOpciones;
	private JMenu menuHelp;
	private JMenuItem opcionExit;
	private JMenuItem opcionReset;
	private JButton btnSelect;
	private JList<String> listElegidos;
	private JButton btnDelete;
	private Action action;
	private JPanel panelAll2;
	private JLabel lblAll;
	private JLabel lbl40;
	private JLabel lbl1540;
	private JLabel lblNewLabel_1;
	private JPanel panelPrice;
	private JPanel panellblPrice;
	private JLabel lblTotalPrice;
	private JLabel lblPrice;
	private JPanel panelIndiv;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel_2;
	private JLabel lblNewLabel_5;
	private JPanel panel_3;
	private JLabel lblNewLabel_6;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_7;
	private JSpinner spinner;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library frame = new Library();
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
	public Library() {
		setTitle("Libreria EII Oviedo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Library.class.getResource("/img/libreria.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 562);
		
		md = new ManejadorDatos();
		libros = new ArrayList<>();
		libros = md.getLibros();
		
		Dialogo di = new Dialogo();
		di.setVisible(true);
		setJMenuBar(getMenuBar_1());
		DNI = di.getDNI();
		
		getLblTitle().setText("Welcome to the book store " + di.getNombre() );
		
		gr.add(getRadio15());
		gr.add(getRadio1540());
		gr.add(getRadio40());
		gr.add(getRadioAll());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelTitulo(), BorderLayout.NORTH);
		contentPane.add(getPanelBotones(), BorderLayout.SOUTH);
		contentPane.add(getPanelTables(), BorderLayout.CENTER);
		contentPane.add(getPanelEspecificaciones(), BorderLayout.EAST);
	}

	private JPanel getPanelTitulo() {
		if (panelTitulo == null) {
			panelTitulo = new JPanel();
			panelTitulo.add(getLblTitle());
		}
		return panelTitulo;
	}
	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.add(getBtnOk());
		}
		return panelBotones;
	}
	private JPanel getPanelTables() {
		if (panelTables == null) {
			panelTables = new JPanel();
			panelTables.setLayout(new BorderLayout(0, 0));
			panelTables.add(getPanelElegidos());
			panelTables.add(getPanelDisponibles(), BorderLayout.NORTH);
		}
		return panelTables;
	}
	private JPanel getPanelEspecificaciones() {
		if (panelEspecificaciones == null) {
			panelEspecificaciones = new JPanel();
			panelEspecificaciones.setLayout(new BorderLayout(0, 0));
			panelEspecificaciones.add(getPanel40(), BorderLayout.NORTH);
			panelEspecificaciones.add(getPanelAll(), BorderLayout.CENTER);
			panelEspecificaciones.add(getPanelPrice(), BorderLayout.SOUTH);
		}
		return panelEspecificaciones;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("Welcome to the book store Pablo");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		}
		return lblTitle;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("Buy");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!listaElegidos.isEmpty()){
						String trozos[] = new String[listaElegidos.size()+2];
						trozos[0] = "Thank you for you purchase";
						trozos[1] = getLblTotalPrice().getText();
						for (int i=0; i<listaElegidos.size(); i++)
							trozos[i+2] = "ISBN: " + libroElegido(array.get(i)).getISBN() + "  Title: " + array.get(i)+ "  Units: 1";
						md.grabarFichero(DNI, trozos);						
					}
					reset();
				}

				private void reset() {
					array.clear();
					map.clear();
					listaElegidos.clear();
					listaDisponibles.clear();
					for(Libro libro : libros)
						listaDisponibles.addElement(libro.getTitle());
					Dialogo di = new Dialogo();
					di.setVisible(true);
					getLblTitle().setText("Welcome to the book store "+ di.getNombre());
					DNI = di.getTitle();
					
					
				}
			});
		}
		return btnOk;
	}
	private JPanel getPanel40() {
		if (panel40 == null) {
			panel40 = new JPanel();
			panel40.setLayout(new BorderLayout(0, 0));
			panel40.add(getPanel1540(), BorderLayout.NORTH);
			panel40.add(getRadio40(), BorderLayout.EAST);
			panel40.add(getLbl40(), BorderLayout.CENTER);
		}
		return panel40;
	}
	private JPanel getPanel1540() {
		if (panel1540 == null) {
			panel1540 = new JPanel();
			panel1540.setLayout(new BorderLayout(0, 0));
			panel1540.add(getPanel15(), BorderLayout.NORTH);
			panel1540.add(getRadio1540(), BorderLayout.EAST);
			panel1540.add(getLbl1540(), BorderLayout.CENTER);
		}
		return panel1540;
	}
	private JPanel getPanel15() {
		if (panel15 == null) {
			panel15 = new JPanel();
			panel15.setLayout(new BorderLayout(0, 0));
			panel15.add(getPanelFilter(), BorderLayout.NORTH);
			panel15.add(getRadio15(), BorderLayout.EAST);
			panel15.add(getLblNewLabel_1(), BorderLayout.CENTER);
		}
		return panel15;
	}
	private JPanel getPanelFilter() {
		if (panelFilter == null) {
			panelFilter = new JPanel();
			panelFilter.add(getLblNewLabel());
		}
		return panelFilter;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Filter by price:");
		}
		return lblNewLabel;
	}
	private JRadioButton getRadio15() {
		if (radio15 == null) {
			radio15 = new JRadioButton("Less than 15");
			radio15.setAction(getAction());
			/*
			radio15.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					filtrar();
				}
			});
			*/
		}
		return radio15;
	}
	private JRadioButton getRadio1540() {
		if (radio1540 == null) {
			radio1540 = new JRadioButton("Between 15 and 40");
			radio1540.setAction(getAction());
			/*
			radio1540.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					filtrar();
				}
			});
			*/
		}
		return radio1540;
	}
	private JRadioButton getRadio40() {
		if (radio40 == null) {
			radio40 = new JRadioButton("More than 40");
			radio40.setAction(getAction());
			//radio40.addItemListener(new ItemListener() {
				/*
				public void itemStateChanged(ItemEvent arg0) {
					filtrar();
				}
				
			});
			*/
		}
		return radio40;
	}
	private JPanel getPanelAll() {
		if (panelAll == null) {
			panelAll = new JPanel();
			panelAll.setLayout(new BorderLayout(0, 0));
			panelAll.add(getPanelAll2(), BorderLayout.NORTH);
		}
		return panelAll;
	}
	private JRadioButton getRadioAll() {
		if (radioAll == null) {
			radioAll = new JRadioButton("All");
			radioAll.setAction(getAction());
			/*
			radioAll.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					filtrar();
				}
			});
			*/
			radioAll.setToolTipText("");
		}
		return radioAll;
	}
	private JPanel getPanelElegidos() {
		if (panelElegidos == null) {
			panelElegidos = new JPanel();
			panelElegidos.setLayout(new BorderLayout(0, 0));
			panelElegidos.add(getPanelBotonElegidos(), BorderLayout.SOUTH);
			panelElegidos.add(getScrollPaneElegidos(), BorderLayout.CENTER);
		}
		return panelElegidos;
	}
	private JPanel getPanelDisponibles() {
		if (panelDisponibles == null) {
			panelDisponibles = new JPanel();
			panelDisponibles.setLayout(new BorderLayout(0, 0));
			panelDisponibles.add(getPanelBotonDisponibles(), BorderLayout.SOUTH);
			panelDisponibles.add(getScrollPaneDisponibles(), BorderLayout.CENTER);
		}
		return panelDisponibles;
	}
	private JPanel getPanelBotonElegidos() {
		if (panelBotonElegidos == null) {
			panelBotonElegidos = new JPanel();
			panelBotonElegidos.add(getBtnDelete());
		}
		return panelBotonElegidos;
	}
	private JPanel getPanelBotonDisponibles() {
		if (panelBotonDisponibles == null) {
			panelBotonDisponibles = new JPanel();
			panelBotonDisponibles.add(getBtnSelect());
		}
		return panelBotonDisponibles;
	}
	private JScrollPane getScrollPaneElegidos() {
		if (scrollPaneElegidos == null) {
			scrollPaneElegidos = new JScrollPane();
			scrollPaneElegidos.setViewportBorder(new TitledBorder(null, "Selected books", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPaneElegidos.setViewportView(getListElegidos());
		}
		return scrollPaneElegidos;
	}
	private JScrollPane getScrollPaneDisponibles() {
		if (scrollPaneDisponibles == null) {
			scrollPaneDisponibles = new JScrollPane();
			scrollPaneDisponibles.setViewportBorder(new TitledBorder(null, "Available books", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPaneDisponibles.setViewportView(getListDisponibles());
		}
		return scrollPaneDisponibles;
	}
	private JList<String> getListDisponibles() {
		if (listDisponibles == null) {
			listaDisponibles = new DefaultListModel<>();
			for (Libro libro : libros)
				listaDisponibles.addElement(libro.getTitle());
			listDisponibles = new JList<String>(listaDisponibles);
			listDisponibles.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String aux =  getListDisponibles().getSelectedValue();
					libroElegido = libroElegido(aux);
					getLblNewLabel_5().setText(libroElegido.getTitle());
					getLblNewLabel_2().setText(String.valueOf(libroElegido.getPrice()));
					//getSpinner().setValue(map.get(aux));
					getBtnSelect().setEnabled(true);
					
				}
			});
		}
		return listDisponibles;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuOpciones());
			menuBar.add(getMenuHelp());
		}
		return menuBar;
	}
	private JMenu getMenuOpciones() {
		if (menuOpciones == null) {
			menuOpciones = new JMenu("Options");
			menuOpciones.add(getOpcionReset());
			menuOpciones.add(getOpcionExit());
		}
		return menuOpciones;
	}
	private JMenu getMenuHelp() {
		if (menuHelp == null) {
			menuHelp = new JMenu("Help");
		}
		return menuHelp;
	}
	private JMenuItem getOpcionExit() {
		if (opcionExit == null) {
			opcionExit = new JMenuItem("Exit");
			opcionExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			opcionExit.setMnemonic('X');
		}
		return opcionExit;
	}
	private JMenuItem getOpcionReset() {
		if (opcionReset == null) {
			opcionReset = new JMenuItem("Reset");
			opcionReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//reset();
				}
			});
			opcionReset.setMnemonic('R');
		}
		return opcionReset;
	}
	
	public void filtrar(){
		listaDisponibles.clear();
		if(getRadio15().isSelected())
			for(Libro libro : libros)
				if (libro.getPrice() < 15 && !array.contains(libro.getTitle()))
					listaDisponibles.addElement(libro.getTitle());
		if(getRadio1540().isSelected())
			for(Libro libro : libros)
				if (libro.getPrice() > 15 && libro.getPrice() < 40 && !array.contains(libro.getTitle()))
					listaDisponibles.addElement(libro.getTitle());
		if(getRadio40().isSelected() )
			for(Libro libro : libros)
				if (libro.getPrice() > 40  && !array.contains(libro.getTitle()))
					listaDisponibles.addElement(libro.getTitle());
		if(getRadioAll().isSelected())
			for(Libro libro : libros)
				if(!array.contains(libro.getTitle()))
					listaDisponibles.addElement(libro.getTitle());
	}
	
	private JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("Select");
			btnSelect.setEnabled(false);
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listaDisponibles.removeElement(libroElegido.getTitle());
					listaElegidos.addElement("ISBN: " + libroElegido.getISBN() + "  Title: " + libroElegido.getTitle() + "  Editor: " + libroElegido.getEditor()+ "  Author: " + libroElegido.getAuthor()+ "  type: " + libroElegido.getType() + "  Sumarry: " + libroElegido.getSummary()+ "  price " + libroElegido.getPrice());
					array.add(libroElegido.getTitle());
					map.put(libroElegido.getTitle(), 1);
					double totalPrice = 0;
					for (String str : array)
						totalPrice += libroElegido(str).getPrice()*map.get(str);
					String aux = String.valueOf(totalPrice);
					getLblTotalPrice().setText(aux);
					btnSelect.setEnabled(false);
				}
			});
			btnSelect.setMnemonic('S');
		}
		return btnSelect;
	}
	private JList<String> getListElegidos() {
		if (listElegidos == null) {
			listaElegidos = new DefaultListModel<>();
			listElegidos = new JList<String>(listaElegidos);
			listElegidos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//String aux =  getListDisponibles().getSelectedValue();
					index = getListElegidos().getSelectedIndex();
					libroElegido = libroElegido(array.get(index));
					getLblNewLabel_5().setText(libroElegido.getTitle());
					getLblNewLabel_2().setText(String.valueOf(libroElegido.getPrice()));
					getBtnDelete().setEnabled(true);
				}
			});
		}
		return listElegidos;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			
			btnDelete = new JButton("Delete element");
			btnDelete.setMnemonic('D');
			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listaDisponibles.addElement(libroElegido.getTitle());
					listaElegidos.remove(index);
					array.remove(index);
					map.remove(libroElegido.getTitle());
					double totalPrice = 0;
					for (String str : array)
						totalPrice += libroElegido(str).getPrice()*map.get(str);
					String aux = String.valueOf(totalPrice);
					getLblTotalPrice().setText(aux);
					btnDelete.setEnabled(false);
					
				}
			});
		}
		return btnDelete;
	}
	
	private Libro libroElegido(String titulo){
		for(Libro libro : libros)
			if(libro.getTitle().equals(titulo))
				return libro;
		return null;
	}
	
	private class FitrarLibros extends AbstractAction {
		public FitrarLibros() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Filters the values");
		}
		public void actionPerformed(ActionEvent e) {
			filtrar();
		}
	}
	private Action getAction() {
		if (action == null) {
			action = new FitrarLibros();
		}
		return action;
	}
	private JPanel getPanelAll2() {
		if (panelAll2 == null) {
			panelAll2 = new JPanel();
			panelAll2.setLayout(new BorderLayout(0, 0));
			panelAll2.add(getRadioAll(), BorderLayout.EAST);
			panelAll2.add(getLblAll(), BorderLayout.CENTER);
		}
		return panelAll2;
	}
	private JLabel getLblAll() {
		if (lblAll == null) {
			lblAll = new JLabel("All");
			lblAll.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAll;
	}
	private JLabel getLbl40() {
		if (lbl40 == null) {
			lbl40 = new JLabel("More than 40");
			lbl40.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl40;
	}
	private JLabel getLbl1540() {
		if (lbl1540 == null) {
			lbl1540 = new JLabel("Between 15 and 40");
			lbl1540.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl1540;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Less than 15");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
	private JPanel getPanelPrice() {
		if (panelPrice == null) {
			panelPrice = new JPanel();
			panelPrice.setLayout(new BorderLayout(0, 0));
			panelPrice.add(getPanellblPrice(), BorderLayout.NORTH);
			panelPrice.add(getLblTotalPrice());
		}
		return panelPrice;
	}
	private JPanel getPanellblPrice() {
		if (panellblPrice == null) {
			panellblPrice = new JPanel();
			panellblPrice.setLayout(new BorderLayout(0, 0));
			panellblPrice.add(getLblPrice(), BorderLayout.CENTER);
			panellblPrice.add(getPanelIndiv(), BorderLayout.NORTH);
		}
		return panellblPrice;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("0");
			lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTotalPrice;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Total price is:");
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPrice;
	}
	private JPanel getPanelIndiv() {
		if (panelIndiv == null) {
			panelIndiv = new JPanel();
			panelIndiv.setLayout(new BorderLayout(0, 0));
			panelIndiv.add(getPanel(), BorderLayout.NORTH);
			panelIndiv.add(getLblNewLabel_2(), BorderLayout.CENTER);
		}
		return panelIndiv;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_1(), BorderLayout.NORTH);
			panel.add(getLblNewLabel_3(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getLblNewLabel_4());
			panel_1.add(getPanel_2());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("0");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Selected book price:");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("New label");
		}
		return lblNewLabel_4;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getLblNewLabel_5());
			panel_2.add(getPanel_3(), BorderLayout.NORTH);
		}
		return panel_2;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("No book");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_5;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getLblNewLabel_6());
			panel_3.add(getPanel_4(), BorderLayout.NORTH);
		}
		return panel_3;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Selected Book:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_6;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getPanel_5(), BorderLayout.NORTH);
			panel_4.add(getSpinner(), BorderLayout.SOUTH);
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(new BorderLayout(0, 0));
			panel_5.add(getLblNewLabel_7());
		}
		return panel_5;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("How many books do you want?");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_7;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
		}
		return spinner;
	}
	
	//getLblNewLabel_2()
	//getLblNewLabel_5()
}
