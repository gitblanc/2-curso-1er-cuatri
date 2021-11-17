package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import player.MusicPlayer;
import player.MyFile;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelNorte;
	private JLabel lblLogo;
	private JSlider sliderVolumen;
	private JPanel panelVolumen;
	private JLabel lblVol;
	private JTextField textVolumen;
	private JPanel panelCentro;
	private JPanel panelLibrerias;
	private JPanel panelPlaylist;
	private JLabel lblLibreria;
	private JLabel lblPlaylist;
	private JPanel panelBotonesLibreria;
	private JButton btnAddPlaylist;
	private JButton btnDelete;
	private JButton btnClear;
	private JPanel panelBotonesPlaylist;
	private JButton btnGoBack;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnGoNext;
	private JButton btnDeletePlaylist;
	private JScrollPane scrollPaneLibreria;
	private JList<MyFile> listLibreria;
	private JScrollPane scrollPanePlaylist;
	private JList<MyFile> listPlaylist;
	private JButton btClearPlaylist;
	private DefaultListModel<MyFile> modeloListLibreria;
	private DefaultListModel<MyFile> modeloListPlaylist;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JFileChooser selector;
	private MusicPlayer musicPlayer;

	/**
	 * Create the frame.
	 * 
	 * @param musicp
	 */
	public VentanaPrincipal(MusicPlayer musicp) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				minimoVentana();
			}
		});
		musicPlayer = musicp;
		setTitle("Heavy Metal Music Player");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/guitarra.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 628);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		getTextVolumen().setText("50");
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		setMinimumSize(new Dimension(550, 250));
	}

	protected void minimoVentana() {
		Dimension d = this.getSize();
		System.out.println(d);

	}

	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setBackground(Color.BLACK);
			panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
			panelNorte.add(getLblLogo());
			panelNorte.add(getSliderVolumen());
			panelNorte.add(getPanelVolumen());
		}
		return panelNorte;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setBackground(Color.BLACK);
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		}
		return lblLogo;
	}

	private JSlider getSliderVolumen() {
		if (sliderVolumen == null) {
			sliderVolumen = new JSlider();
			sliderVolumen.setFocusable(false);
			sliderVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					pintaYCambiaVol();
				}
			});
			sliderVolumen.setPaintLabels(true);
			sliderVolumen.setPaintTicks(true);
			sliderVolumen.setMinorTickSpacing(5);
			sliderVolumen.setMajorTickSpacing(20);
			sliderVolumen.setFont(new Font("Dialog", Font.BOLD, 14));
			sliderVolumen.setBackground(Color.BLACK);
			sliderVolumen.setForeground(Color.WHITE);
		}
		return sliderVolumen;
	}

	private JPanel getPanelVolumen() {
		if (panelVolumen == null) {
			panelVolumen = new JPanel();
			panelVolumen.setBackground(Color.BLACK);
			panelVolumen.add(getLblVol());
			panelVolumen.add(getTextVolumen());
		}
		return panelVolumen;
	}

	private JLabel getLblVol() {
		if (lblVol == null) {
			lblVol = new JLabel("Vol:");
			lblVol.setFont(new Font("Dialog", Font.BOLD, 30));
			lblVol.setForeground(new Color(147, 112, 219));
		}
		return lblVol;
	}

	private JTextField getTextVolumen() {
		if (textVolumen == null) {
			textVolumen = new JTextField();
			textVolumen.setBorder(null);
			textVolumen.setFont(new Font("Dialog", Font.BOLD, 25));
			textVolumen.setBackground(Color.BLACK);
			textVolumen.setForeground(Color.WHITE);
			textVolumen.setEditable(false);
			textVolumen.setColumns(10);
		}
		return textVolumen;
	}

	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setBackground(new Color(0, 0, 0));
			panelCentro.setLayout(new GridLayout(1, 2, 5, 0));
			panelCentro.add(getPanelLibrerias());
			panelCentro.add(getPanelPlaylist());
		}
		return panelCentro;
	}

	private JPanel getPanelLibrerias() {
		if (panelLibrerias == null) {
			panelLibrerias = new JPanel();
			panelLibrerias.setBorder(new LineBorder(new Color(147, 112, 219), 3));
			panelLibrerias.setBackground(new Color(0, 0, 0));
			panelLibrerias.setLayout(new BorderLayout(0, 0));
			panelLibrerias.add(getLblLibreria(), BorderLayout.NORTH);
			panelLibrerias.add(getPanelBotonesLibreria(), BorderLayout.SOUTH);
			panelLibrerias.add(getScrollPaneLibreria(), BorderLayout.CENTER);
		}
		return panelLibrerias;
	}

	private JPanel getPanelPlaylist() {
		if (panelPlaylist == null) {
			panelPlaylist = new JPanel();
			panelPlaylist.setBorder(new LineBorder(new Color(147, 112, 219), 3));
			panelPlaylist.setBackground(new Color(0, 0, 0));
			panelPlaylist.setLayout(new BorderLayout(0, 0));
			panelPlaylist.add(getLblPlaylist(), BorderLayout.NORTH);
			panelPlaylist.add(getPanelBotonesPlaylist(), BorderLayout.SOUTH);
			panelPlaylist.add(getScrollPanePlaylist(), BorderLayout.CENTER);
		}
		return panelPlaylist;
	}

	private JLabel getLblLibreria() {
		if (lblLibreria == null) {
			lblLibreria = new JLabel("\u058D Library \u058D");
			lblLibreria.setHorizontalAlignment(SwingConstants.CENTER);
			lblLibreria.setFont(new Font("Dialog", Font.BOLD, 18));
			lblLibreria.setForeground(new Color(147, 112, 219));
		}
		return lblLibreria;
	}

	private JLabel getLblPlaylist() {
		if (lblPlaylist == null) {
			lblPlaylist = new JLabel("\u266B Playlist \u266B");
			lblPlaylist.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlaylist.setFont(new Font("Dialog", Font.BOLD, 18));
			lblPlaylist.setForeground(new Color(147, 112, 219));
		}
		return lblPlaylist;
	}

	private JPanel getPanelBotonesLibreria() {
		if (panelBotonesLibreria == null) {
			panelBotonesLibreria = new JPanel();
			panelBotonesLibreria.setBackground(new Color(0, 0, 0));
			panelBotonesLibreria.setLayout(new GridLayout(0, 3, 0, 0));
			panelBotonesLibreria.add(getBtnAddPlaylist());
			panelBotonesLibreria.add(getBtnDelete());
			panelBotonesLibreria.add(getBtnClear());
		}
		return panelBotonesLibreria;
	}

	private JButton getBtnAddPlaylist() {
		if (btnAddPlaylist == null) {
			btnAddPlaylist = new JButton("Add to PlayList");
			btnAddPlaylist.setMargin(new Insets(0, 0, 0, 0));
			btnAddPlaylist.setFont(new Font("Arial", Font.BOLD, 16));
			btnAddPlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirAPlayList();
				}
			});
		}
		return btnAddPlaylist;
	}

	private void añadirAPlayList() {
		for (int i = 0; i < getListLibreria().getSelectedValuesList().size(); i++) {
			modeloListPlaylist.addElement(getListLibreria().getSelectedValuesList().get(i));
		}

	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarDeLibreria();
				}
			});
			btnDelete.setMargin(new Insets(0, 0, 0, 0));
			btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnDelete;
	}

	private void eliminarDeLibreria() {
		for (int i = 0; i < getListLibreria().getSelectedValuesList().size(); i++) {
			modeloListLibreria.removeElement(getListLibreria().getSelectedValuesList().get(i));
		}

	}

	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListLibreria.removeAllElements();
				}
			});
			btnClear.setMargin(new Insets(0, 0, 0, 0));
			btnClear.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnClear;
	}

	private JPanel getPanelBotonesPlaylist() {
		if (panelBotonesPlaylist == null) {
			panelBotonesPlaylist = new JPanel();
			panelBotonesPlaylist.setLayout(new GridLayout(0, 6, 0, 0));
			panelBotonesPlaylist.add(getBtnGoBack());
			panelBotonesPlaylist.add(getBtnPlay());
			panelBotonesPlaylist.add(getBtnPause());
			panelBotonesPlaylist.add(getBtnGoNext());
			panelBotonesPlaylist.add(getBtnDeletePlaylist());
			panelBotonesPlaylist.add(getBtClearPlaylist());
		}
		return panelBotonesPlaylist;
	}

	private JButton getBtnGoBack() {
		if (btnGoBack == null) {
			btnGoBack = new JButton("\u25C4\u25C4");
			btnGoBack.setMargin(new Insets(0, 0, 0, 0));
			btnGoBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					previousSong();
				}
			});
			btnGoBack.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnGoBack;
	}

	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("\u25BA");
			btnPlay.setMargin(new Insets(0, 0, 0, 0));
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (modeloListPlaylist.isEmpty()) {
						btnPlay.setEnabled(false);
					} else {
						btnPlay.setEnabled(true);
						play();
					}
				}
			});
			btnPlay.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnPlay;
	}

	private void play() {
		if (getListPlaylist().getSelectedIndex() == -1) {
			getListPlaylist().setSelectedIndex(0);
		}
		musicPlayer.play(getListPlaylist().getSelectedValue().getF());

	}

	private void nextSong() {
		if (getListPlaylist().getSelectedIndex() == -1) {
			getListPlaylist().setSelectedIndex(0);
		} else if (getListPlaylist().getSelectedIndex() == modeloListPlaylist.size() - 1) {
			getListPlaylist().setSelectedIndex(0);
		} else {
			getListPlaylist().setSelectedIndex(getListPlaylist().getSelectedIndex() + 1);
		}
		musicPlayer.play(getListPlaylist().getSelectedValue().getF());
	}

	private void previousSong() {
		if (getListPlaylist().getSelectedIndex() == -1) {
			getListPlaylist().setSelectedIndex(0);
		} else if (getListPlaylist().getSelectedIndex() <= modeloListPlaylist.size() - 1
				&& getListPlaylist().getSelectedIndex() > 0) {
			getListPlaylist().setSelectedIndex(getListPlaylist().getSelectedIndex() - 1);
		} else {
			getListPlaylist().setSelectedIndex(modeloListPlaylist.size() - 1);
		}
		musicPlayer.play(getListPlaylist().getSelectedValue().getF());
	}

	private JButton getBtnPause() {
		if (btnPause == null) {
			btnPause = new JButton("\u25A0");
			btnPause.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					musicPlayer.stop();
				}
			});
			btnPause.setMargin(new Insets(0, 0, 0, 0));
			btnPause.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnPause;
	}

	private JButton getBtnGoNext() {
		if (btnGoNext == null) {
			btnGoNext = new JButton("\u25BA\u25BA");
			btnGoNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nextSong();
				}
			});
			btnGoNext.setMargin(new Insets(0, 0, 0, 0));
			btnGoNext.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnGoNext;
	}

	private JButton getBtnDeletePlaylist() {
		if (btnDeletePlaylist == null) {
			btnDeletePlaylist = new JButton("Del");
			btnDeletePlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarDePlayList();
				}
			});
			btnDeletePlaylist.setMargin(new Insets(0, 0, 0, 0));
			btnDeletePlaylist.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btnDeletePlaylist;
	}

	private void eliminarDePlayList() {
		for (int i = 0; i < getListPlaylist().getSelectedValuesList().size(); i++) {
			modeloListPlaylist.removeElement(getListPlaylist().getSelectedValuesList().get(i));
		}

	}

	private JScrollPane getScrollPaneLibreria() {
		if (scrollPaneLibreria == null) {
			scrollPaneLibreria = new JScrollPane();
			scrollPaneLibreria.setViewportView(getListLibreria());
		}
		return scrollPaneLibreria;
	}

	private JList<MyFile> getListLibreria() {
		if (listLibreria == null) {
			modeloListLibreria = new DefaultListModel<MyFile>();
			listLibreria = new JList<MyFile>(modeloListLibreria);
			listLibreria.setForeground(new Color(248, 248, 255));
			listLibreria.setFont(new Font("Tahoma", Font.PLAIN, 14));
			listLibreria.setBackground(new Color(0, 0, 0));
		}
		return listLibreria;
	}

	private JScrollPane getScrollPanePlaylist() {
		if (scrollPanePlaylist == null) {
			scrollPanePlaylist = new JScrollPane();
			scrollPanePlaylist.setViewportView(getListPlaylist());
		}
		return scrollPanePlaylist;
	}

	private JList<MyFile> getListPlaylist() {
		if (listPlaylist == null) {
			modeloListPlaylist = new DefaultListModel<MyFile>();
			listPlaylist = new JList<MyFile>(modeloListPlaylist);
			listPlaylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 14));
			listPlaylist.setForeground(new Color(248, 248, 255));
			listPlaylist.setBackground(new Color(0, 0, 0));
		}
		return listPlaylist;
	}

	private JButton getBtClearPlaylist() {
		if (btClearPlaylist == null) {
			btClearPlaylist = new JButton("Clear");
			btClearPlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListPlaylist.removeAllElements();
				}
			});
			btClearPlaylist.setMargin(new Insets(0, 0, 0, 0));
			btClearPlaylist.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return btClearPlaylist;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.setMnemonic('F');
			mnFile.add(getMntmOpen());
		}
		return mnFile;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirFicheros();
				}
			});
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmOpen;
	}

	private void abrirFicheros() {
		int respuesta = getSelector().showOpenDialog(null);// presenta la ventana
		if (respuesta == JFileChooser.APPROVE_OPTION) {
			for (int i = 0; i < getSelector().getSelectedFiles().length; i++) {
				if (!modeloListLibreria.contains(getSelector().getSelectedFiles()[i])) {
					modeloListLibreria.addElement(new MyFile(getSelector().getSelectedFiles()[i]));
				}
			}
		}

	}

	public JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);// permite escoger más de un archivo
			selector.setFileFilter(new FileNameExtensionFilter("Archivos mp3", "mp3"));// filtro de archivos
			String documentos = System.getProperty("user.home") +  "/Documents";
			selector.setCurrentDirectory(new File(documentos));//fijamos en documentos
		}
		return selector;
	}

	private void pintaYCambiaVol() {
		getTextVolumen().setText(String.valueOf(getSliderVolumen().getValue()));
		setVolume(getSliderVolumen().getValue());
	}

	private void setVolume(double volume) {
		double volMax = getSliderVolumen().getMaximum();
		musicPlayer.setVolume(volume, volMax);
	}
}
