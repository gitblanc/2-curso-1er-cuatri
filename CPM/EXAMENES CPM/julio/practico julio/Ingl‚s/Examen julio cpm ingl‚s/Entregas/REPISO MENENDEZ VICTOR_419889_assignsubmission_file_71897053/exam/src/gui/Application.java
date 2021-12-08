package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JTextArea;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import logic.FiltraLibros;
import logic.Order;

import javax.swing.AbstractListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;

public class Application extends JFrame {
	
	private String name;

	private JPanel contentPane;
	private JPanel welcomepn;
	private JPanel panel;
	private JSplitPane splitPane;
	private JPanel catalogpn;
	private JTextArea information;
	private JPanel filterpn;
	private JPanel cartPanel;
	private JPanel catalogsubpn;
	private JList catalog;
	private JLabel priceFilterlb;
	private JComboBox priceFiltercb;
	private JButton searchbt;
	
	private FiltraLibros libros = new FiltraLibros();
	private Order order = new Order();
	
	private JScrollPane scrollPane;
	private JList list;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JLabel lblWelcome;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane_2;
	private JList list_1;
	private JButton btnNewButton_1;
	private JButton btnConfirm;

	/**
	 * Create the frame.
	 */
	public Application(String name) {
		this.name = name;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getWelcomepn(), BorderLayout.NORTH);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JPanel getWelcomepn() {
		if (welcomepn == null) {
			welcomepn = new JPanel();
			welcomepn.add(getLblWelcome());
		}
		return welcomepn;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnConfirm());
		}
		return panel;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getCatalogpn());
			splitPane.setRightComponent(getCartPanel());
		}
		return splitPane;
	}
	private JPanel getCatalogpn() {
		if (catalogpn == null) {
			catalogpn = new JPanel();
			catalogpn.setLayout(new BorderLayout(0, 0));
			catalogpn.add(getFilterpn(), BorderLayout.NORTH);
			catalogpn.add(getCatalogsubpn(), BorderLayout.CENTER);
			catalogpn.add(getPanel_1(), BorderLayout.SOUTH);
		}
		return catalogpn;
	}
	private JTextArea getInformation() {
		if (information == null) {
			information = new JTextArea();
			information.setWrapStyleWord(true);
			information.setLineWrap(true);
			information.setEditable(false);
		}
		return information;
	}
	private JPanel getFilterpn() {
		if (filterpn == null) {
			filterpn = new JPanel();
			filterpn.add(getPriceFilterlb());
			filterpn.add(getPriceFiltercb());
			filterpn.add(getSearchbt());
		}
		return filterpn;
	}
	private JPanel getCartPanel() {
		if (cartPanel == null) {
			cartPanel = new JPanel();
			cartPanel.setLayout(new BorderLayout(0, 0));
			cartPanel.add(getScrollPane_2(), BorderLayout.CENTER);
			cartPanel.add(getBtnNewButton_1(), BorderLayout.SOUTH);
		}
		return cartPanel;
	}
	private JPanel getCatalogsubpn() {
		if (catalogsubpn == null) {
			catalogsubpn = new JPanel();
			catalogsubpn.setLayout(new GridLayout(0, 1, 0, 0));
			catalogsubpn.add(getScrollPane_1());
			catalogsubpn.add(getScrollPane_1_1());
		}
		return catalogsubpn;
	}
	private JList getCatalog() {
		if (catalog == null) {
			catalog = new JList();
			catalog.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					getInformation().setText(libros.getInformation(catalog.getSelectedIndex()));
				}
			});
			catalog.setModel(new AbstractListModel() {
				String[] values = libros.getTitles();
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		return catalog;
	}
	private JLabel getPriceFilterlb() {
		if (priceFilterlb == null) {
			priceFilterlb = new JLabel("Filter:");
		}
		return priceFilterlb;
	}
	private JComboBox getPriceFiltercb() {
		if (priceFiltercb == null) {
			priceFiltercb = new JComboBox();
			priceFiltercb.setModel(new DefaultComboBoxModel(new String[] {"< 15 \u20AC", "15 - 40 \u20AC", ">40 \u20AC"}));
		}
		return priceFiltercb;
	}
	private JButton getSearchbt() {
		if (searchbt == null) {
			searchbt = new JButton("filter");
			searchbt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					libros.filter(getPriceFiltercb().getSelectedIndex());
					catalog.setModel(new AbstractListModel() {
						String[] values = libros.getTitles();
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
				}
			});
		}
		return searchbt;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getCatalog());
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getInformation());
		}
		return scrollPane_1;
	}
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome " + name);
		}
		return lblWelcome;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnNewButton());
		}
		return panel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("add to cart");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					order.add(libros.getBook(getCatalog().getSelectedIndex()));
					list_1.setModel(new AbstractListModel() {
						String[] values = order.getTitles();
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
				}
			});
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getList_1());
		}
		return scrollPane_2;
	}
	private JList getList_1() {
		if (list_1 == null) {
			list_1 = new JList();
			list_1.setModel(new AbstractListModel() {
				String[] values = order.getTitles();
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		return list_1;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("remove");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					order.remove(list_1.getSelectedIndex());
					list_1.setModel(new AbstractListModel() {
						String[] values = order.getTitles();
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
				}
			});
		}
		return btnNewButton_1;
	}
	private JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton("confirm");
			Application app = this;
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					order.confirm();
					app.dispose();
				}
			});
		}
		return btnConfirm;
	}
}
