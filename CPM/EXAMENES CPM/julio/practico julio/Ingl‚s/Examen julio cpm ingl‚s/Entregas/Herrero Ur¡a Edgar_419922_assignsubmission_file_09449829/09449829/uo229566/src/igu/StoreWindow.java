package igu;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JCheckBox;

import logica.BookStore;
import logica.ElementoCarrito;
import logica.Libro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.MouseEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;

public class StoreWindow extends JFrame {

	/** CLASE RESPONSABLE DEL FILTRADO. **/
	public class FiltraLibros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			refresh();
		}

		private void refresh() {
			modeloLista.removeAllElements();
			addBooks(chkLow.isSelected(), chkMid.isSelected(),
					chkHigh.isSelected());
		}

	}

	List<ElementoCarrito> carrito = new ArrayList<ElementoCarrito>();

	private static final long serialVersionUID = 1L;
	Login login;

	// bookList model.
	BookStore bs = new BookStore();
	DefaultListModel modeloLista;
	DefaultListModel modeloCarrito;

	List<Libro> libros = bs.getLibros();
	FiltraLibros fl = new FiltraLibros();

	private JPanel contentPane;
	private JLabel lblWelcome;
	private JPanel pnLibros;
	private JScrollPane spLibros;
	private JList bookList;
	private JPanel pnFilters;
	private JCheckBox chkLow;
	private JCheckBox chkMid;
	private JCheckBox chkHigh;
	private JLabel lblAvailableFilters;
	private JPanel pnCarrito;
	private JScrollPane spCarrito;
	private JList carritoList;
	private JButton btnBuy;
	private JButton btnCancel;
	private JPanel pnInfo;
	private JScrollPane spInfo;
	private JTextArea txaInfo;
	private JSpinner spAmount;
	private JLabel lblAmount;
	private JButton btnProceed;
	private JLabel lblTotal;
	private JButton btnCancelOrder;
	private JMenuBar menuBar;
	private JMenu mnOptions;
	private JMenuItem mntmCancelTheOrder;
	private JSeparator separator;
	private JMenuItem mntmExit;

	/**
	 * Create the frame.
	 */
	public StoreWindow(Login login) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				StoreWindow.class.getResource("/img/libreria.jpg")));
		setTitle("Welcome to the Store!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 703);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblWelcome());
		this.login = login;
		lblWelcome.setText("Welcome to the store, " + login.username);
		contentPane.add(getPnLibros());

		addBooks(true, true, true);

		chkLow.setSelected(true);
		chkMid.setSelected(true);
		chkHigh.setSelected(true);
		contentPane.add(getPnCarrito());
		contentPane.add(getBtnBuy());
		contentPane.add(getBtnCancel());
		contentPane.add(getPnInfo());
		contentPane.add(getSpAmount());
		contentPane.add(getLblAmount());
		contentPane.add(getBtnProceed());
		contentPane.add(getLblTotal());
		contentPane.add(getBtnCancelOrder());
	}

	private double carritoTotal() {
		double total = 0.0;
		for (ElementoCarrito elemento : carrito)
			total += (elemento.getPrice() * Double.valueOf(elemento
					.getUnidades()));
		return total;
	}

	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome to the store, <nombre>");
			lblWelcome.setBounds(10, 11, 269, 14);
		}
		return lblWelcome;
	}

	private JPanel getPnLibros() {
		if (pnLibros == null) {
			pnLibros = new JPanel();
			pnLibros.setBorder(new TitledBorder(null, "Available Books",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnLibros.setBounds(10, 36, 513, 256);
			pnLibros.setLayout(new BorderLayout(0, 0));
			pnLibros.add(getSpLibros(), BorderLayout.CENTER);
			pnLibros.add(getPnFilters(), BorderLayout.SOUTH);
		}
		return pnLibros;
	}

	private JScrollPane getSpLibros() {
		if (spLibros == null) {
			spLibros = new JScrollPane();
			spLibros.setViewportView(getBookList());
		}
		return spLibros;
	}

	private JList getBookList() {
		if (bookList == null) {
			modeloLista = new DefaultListModel();
			bookList = new JList(modeloLista);
			bookList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int fila = bookList.getSelectedIndex();
					if (fila != -1) {
						Libro selectedBook = bs
								.getLibroByTitle((String) modeloLista.get(fila));
						showInfo(selectedBook);
					}
				}
			});
		}
		return bookList;
	}

	private void showInfo(Libro libro) {
		txaInfo.setText("Title: " + libro.getTitle() + "\n" + "Editor: "
				+ libro.getEditor() + "\n" + "Type: " + libro.getType() + "\n"
				+ "Summary: " + libro.getSummary() + "\n" + "Price: "
				+ libro.getPrice() + "\n");
	}

	private void addBooks(boolean low, boolean mid, boolean high) {
		for (Libro libro : libros) {
			if ((low && (libro.getPrice() < 15))
					|| (mid && (libro.getPrice() >= 15 && libro.getPrice() <= 40))
					|| (high && (libro.getPrice() > 40)))
				modeloLista.addElement(libro.getTitle());
		}
	}

	private JPanel getPnFilters() {
		if (pnFilters == null) {
			pnFilters = new JPanel();
			pnFilters.add(getLblAvailableFilters());
			pnFilters.add(getChkLow());
			pnFilters.add(getChkMid());
			pnFilters.add(getChkHigh());
		}
		return pnFilters;
	}

	private JCheckBox getChkLow() {
		if (chkLow == null) {
			chkLow = new JCheckBox("< 15\u20AC");
			chkLow.addActionListener(fl);
			chkLow.setSelected(true);
		}
		return chkLow;
	}

	private JCheckBox getChkMid() {
		if (chkMid == null) {
			chkMid = new JCheckBox("Between 15\u20AC and 40\u20AC");
			chkMid.addActionListener(fl);
			chkMid.setSelected(true);
		}
		return chkMid;
	}

	private JCheckBox getChkHigh() {
		if (chkHigh == null) {
			chkHigh = new JCheckBox("> 40\u20AC");
			chkHigh.addActionListener(fl);
			chkHigh.setSelected(true);
		}
		return chkHigh;
	}

	private JLabel getLblAvailableFilters() {
		if (lblAvailableFilters == null) {
			lblAvailableFilters = new JLabel("Available filters:");
		}
		return lblAvailableFilters;
	}

	private JPanel getPnCarrito() {
		if (pnCarrito == null) {
			pnCarrito = new JPanel();
			pnCarrito.setBorder(new TitledBorder(null, "You're buying...",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnCarrito.setBounds(10, 396, 513, 200);
			pnCarrito.setLayout(new BorderLayout(0, 0));
			pnCarrito.add(getSpCarrito(), BorderLayout.CENTER);
		}
		return pnCarrito;
	}

	private JScrollPane getSpCarrito() {
		if (spCarrito == null) {
			spCarrito = new JScrollPane();
			spCarrito.setViewportView(getCarritoList());
		}
		return spCarrito;
	}

	private JList getCarritoList() {
		if (carritoList == null) {
			modeloCarrito = new DefaultListModel();
			carritoList = new JList(modeloCarrito);
		}
		return carritoList;
	}

	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Buy");
			btnBuy.setMnemonic('B');
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int fila = bookList.getSelectedIndex();
					if (fila != -1) {
						Libro selectedBook = bs
								.getLibroByTitle((String) modeloLista.get(fila));
						carrito.add(new ElementoCarrito(selectedBook.getISBN(),
								selectedBook.getTitle(), selectedBook
										.getPrice(), (int) spAmount.getValue()));

						modeloCarrito.addElement(selectedBook.getISBN() + " - "
								+ selectedBook.getTitle() + " | " + selectedBook.getPrice() + "€ | "
								+ (int) spAmount.getValue() + " unidades.");
						
						lblTotal.setText("Total: " + carritoTotal() + "€");
						lblTotal.setVisible(true);
						btnProceed.setEnabled(true);
					}
				}
			});
			btnBuy.setBounds(533, 52, 191, 200);
		}
		return btnBuy;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setMnemonic('C');
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int fila = carritoList.getSelectedIndex();
					if (fila != -1) {
						String str = (String) modeloCarrito.get(fila);
						modeloCarrito.remove(fila);
						String[] trozos = str.split(" ");
						carrito.remove(getElemento(trozos[0]));
						
						lblTotal.setText("Total: " + carritoTotal() + "€");
						lblTotal.setVisible(true);
						
						if(modeloCarrito.isEmpty())
							lblTotal.setVisible(false);
						
						if(modeloCarrito.isEmpty())
							btnProceed.setEnabled(false);
					}
				}
			});
			btnCancel.setBounds(533, 405, 191, 191);
		}
		return btnCancel;
	}

	private ElementoCarrito getElemento(String ISBN) {
		for (ElementoCarrito element : carrito)
			if (element.getISBN() == Long.valueOf(ISBN))
				return element;
		return null;
	}

	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setBorder(new TitledBorder(null,
					"More info about the book!", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			pnInfo.setBounds(10, 303, 714, 82);
			pnInfo.setLayout(new BorderLayout(0, 0));
			pnInfo.add(getSpInfo(), BorderLayout.CENTER);
		}
		return pnInfo;
	}

	private JScrollPane getSpInfo() {
		if (spInfo == null) {
			spInfo = new JScrollPane();
			spInfo.setViewportView(getTxaInfo());
		}
		return spInfo;
	}

	private JTextArea getTxaInfo() {
		if (txaInfo == null) {
			txaInfo = new JTextArea();
		}
		return txaInfo;
	}

	private JSpinner getSpAmount() {
		if (spAmount == null) {
			spAmount = new JSpinner();
			spAmount.setToolTipText("Amount of books that you want to buy.");
			spAmount.setModel(new SpinnerNumberModel(new Integer(1),
					new Integer(1), null, new Integer(1)));
			spAmount.setBounds(592, 263, 132, 20);
		}
		return spAmount;
	}

	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount");
			lblAmount.setLabelFor(getSpAmount());
			lblAmount.setBounds(533, 266, 74, 14);
		}
		return lblAmount;
	}

	private JButton getBtnProceed() {
		if (btnProceed == null) {
			btnProceed = new JButton("Proceed");
			btnProceed.setEnabled(false);
			btnProceed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					bs.guardaPedido(carrito);
					reiniciar();
					JOptionPane.showMessageDialog(null, "Su pedido ha sido registrado con éxito.");
				}
			});
			btnProceed.setMnemonic('P');
			btnProceed.setBounds(533, 607, 191, 23);
		}
		return btnProceed;
	}

	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total: ");
			lblTotal.setVisible(false);
			lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTotal.setBounds(20, 607, 302, 23);
		}
		return lblTotal;
	}
	
	private void reiniciar() {
		carrito = new ArrayList<ElementoCarrito>();
		modeloLista.removeAllElements();
		addBooks(true, true, true);
		chkLow.setSelected(true);
		chkMid.setSelected(true);
		chkHigh.setSelected(true);
		modeloCarrito.removeAllElements();
		lblTotal.setVisible(false);
		spAmount.setValue(1);
		txaInfo.setText("");
	}
	private JButton getBtnCancelOrder() {
		if (btnCancelOrder == null) {
			btnCancelOrder = new JButton("Cancel the Order");
			btnCancelOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reiniciar();
					JOptionPane.showMessageDialog(null, "Your order has been cancelled.");
				}
			});
			btnCancelOrder.setMnemonic('P');
			btnCancelOrder.setBounds(332, 607, 191, 23);
		}
		return btnCancelOrder;
	}
	
	void cargaAyuda(){
		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/Ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			 }

		    catch(Exception e){
		      		System.out.println("Ayuda no encontrada");
		      		return;
		        }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.enableHelpKey(getRootPane(),"pag1", hs);
		   
		 }
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnOptions());
		}
		return menuBar;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.add(getMntmCancelTheOrder());
			mnOptions.add(getSeparator());
			mnOptions.add(getMntmExit());
		}
		return mnOptions;
	}
	private JMenuItem getMntmCancelTheOrder() {
		if (mntmCancelTheOrder == null) {
			mntmCancelTheOrder = new JMenuItem("Cancel the Order");
			mntmCancelTheOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reiniciar();
					JOptionPane.showMessageDialog(null, "Your order has been cancelled.");
				}
			});
			mntmCancelTheOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		}
		return mntmCancelTheOrder;
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
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		}
		return mntmExit;
	}
}
