package igu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar barraMenu;
	private JToolBar barraHerramientas;
	private JButton btNuevo;
	private JButton btGuardar;
	private JButton btAbrir;
	private JButton btImprimir;
	private JPanel barraEstado;
	private JPanel pnTextos;
	private JScrollPane scOriginal;
	private JScrollPane scTraducido;
	private JTextArea arOriginal;
	private JTextArea arTraducido;
	private JButton btEspañol;
	private JButton btFrances;
	private JButton btIngles;
	private JLabel etDocOriginal;
	private JLabel etIdOriginal;
	private JLabel etDocTraducido;
	private JLabel etIdTraducido;
	private JMenu menuArchivo;
	private JMenu menuEditar;
	private JMenu menuTraducir;
	private JMenu menuHerramientas;
	private JMenu menuAyuda;
	private JMenuItem itGuardarComo;
	private JMenuItem itNuevo;
	private JMenuItem itSalir;
	private Foco focoTexto = new Foco();
	private GrabFocus grabFoco = new GrabFocus();
	private SetBorderPainted borderPainter = new SetBorderPainted();
	private ProcesaTecla pt = new ProcesaTecla();
	private JToggleButton tglbtnNumbers;
	private JCheckBox chckbxNumbers;

	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuArchivo());
			barraMenu.add(getMenuEditar());
			barraMenu.add(getMenuTraducir());
			barraMenu.add(getMenuHerramientas());
			barraMenu.add(getMenuAyuda());
		}
		return barraMenu;
	}

	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(new java.awt.Color(208, 204, 204));
			barraHerramientas.add(getBtNuevo());
			barraHerramientas.add(getBtAbrir());
			barraHerramientas.add(getBtGuardar());
			barraHerramientas.add(getBtImprimir());
			barraHerramientas.add(getBtIngles());
			barraHerramientas.add(getBtEspañol());
			barraHerramientas.add(getBtFrances());
			barraHerramientas.add(getTglbtnNumbers());
			barraHerramientas.add(getChckbxNumbers());
		}
		return barraHerramientas;
	}

	private JButton getBtNuevo() {
		if (btNuevo == null) {
			btNuevo = new JButton();
			btNuevo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Nuevo.png")));
			btNuevo.setBorderPainted(false);
			btNuevo.setContentAreaFilled(false);
			btNuevo.setFocusPainted(false);
			btNuevo.setPreferredSize(new java.awt.Dimension(24, 24));
			btNuevo.setMaximumSize(new java.awt.Dimension(24, 24));
			btNuevo.setMinimumSize(new java.awt.Dimension(24, 24));
			btNuevo.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btNuevo.addMouseListener(borderPainter);
		}
		return btNuevo;
	}

	private JButton getBtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showInputDialog(null, "Introduce el nombre del fichero a guardar:", "Guardado",
							JOptionPane.QUESTION_MESSAGE);
				}
			});
			btGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Guardar.png")));
			btGuardar.setBorderPainted(false);
			btGuardar.setContentAreaFilled(false);
			btGuardar.setPreferredSize(new java.awt.Dimension(24, 24));
			btGuardar.setMaximumSize(new java.awt.Dimension(24, 24));
			btGuardar.setMinimumSize(new java.awt.Dimension(24, 24));
			btGuardar.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btGuardar.addMouseListener(borderPainter);
		}
		return btGuardar;
	}

	private JButton getBtAbrir() {
		if (btAbrir == null) {
			btAbrir = new JButton();
			btAbrir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Abrir.png")));
			btAbrir.setBorderPainted(false);
			btAbrir.setContentAreaFilled(false);
			btAbrir.setMaximumSize(new java.awt.Dimension(24, 24));
			btAbrir.setMinimumSize(new java.awt.Dimension(24, 24));
			btAbrir.setPreferredSize(new java.awt.Dimension(24, 24));
			btAbrir.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btAbrir.addMouseListener(borderPainter);
		}
		return btAbrir;
	}

	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Imprimir.png")));
			btImprimir.setBorderPainted(false);
			btImprimir.setContentAreaFilled(false);
			btImprimir.setMaximumSize(new java.awt.Dimension(24, 24));
			btImprimir.setMinimumSize(new java.awt.Dimension(24, 24));
			btImprimir.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btImprimir.addMouseListener(borderPainter);
		}
		return btImprimir;
	}

	private JPanel getBarraEstado() {
		if (barraEstado == null) {
			barraEstado = new JPanel();
			barraEstado.setLayout(new GridLayout(1, 4, 0, 0));
			barraEstado.add(getEtDocOriginal());
			barraEstado.add(getEtIdOriginal());
			barraEstado.add(getEtDocTraducido());
			barraEstado.add(getEtIdTraducido());
		}
		return barraEstado;
	}

	private JLabel getEtDocOriginal() {
		if (etDocOriginal == null) {
			etDocOriginal = new JLabel();
			etDocOriginal.setText("Documento Original");
			etDocOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocOriginal
					.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocOriginal;
	}

	private JLabel getEtIdOriginal() {
		if (etIdOriginal == null) {
			etIdOriginal = new JLabel();
			etIdOriginal.setText("Español");
			etIdOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etIdOriginal
					.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etIdOriginal;
	}

	private JLabel getEtDocTraducido() {
		if (etDocTraducido == null) {
			etDocTraducido = new JLabel();
			etDocTraducido.setText("Documento traducido");
			etDocTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocTraducido
					.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocTraducido;
	}

	private JLabel getEtIdTraducido() {
		if (etIdTraducido == null) {
			etIdTraducido = new JLabel();
			etIdTraducido.setText("Ingl\u00E9s");
			etIdTraducido
					.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etIdTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		}
		return etIdTraducido;
	}

	private JPanel getPnTextos() {
		if (pnTextos == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			pnTextos = new JPanel();
			pnTextos.setLayout(gridLayout);
			pnTextos.add(getScOriginal(), null);
			pnTextos.add(getScTraducido(), null);
		}
		return pnTextos;
	}

	private JScrollPane getScOriginal() {
		if (scOriginal == null) {
			scOriginal = new JScrollPane();
			scOriginal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Original",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION,
					new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51, 51, 51)));
			scOriginal.setViewportView(getArOriginal());
		}
		return scOriginal;
	}

	private JScrollPane getScTraducido() {
		if (scTraducido == null) {
			scTraducido = new JScrollPane();
			scTraducido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Traducido",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION,
					new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51, 51, 51)));
			scTraducido.setViewportView(getArTraducido());
		}
		return scTraducido;
	}

	private JTextArea getArOriginal() {
		if (arOriginal == null) {
			arOriginal = new JTextArea();
			arOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arOriginal.setWrapStyleWord(true);
			arOriginal.setBackground(java.awt.Color.lightGray);
			arOriginal.setLineWrap(true);
			arOriginal.addFocusListener(focoTexto);

		}
		return arOriginal;
	}

	private JTextArea getArTraducido() {
		if (arTraducido == null) {
			arTraducido = new JTextArea();
			arTraducido.setWrapStyleWord(true);
			arTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arTraducido.setBackground(java.awt.Color.lightGray);
			arTraducido.setLineWrap(true);
			arTraducido.addFocusListener(focoTexto);
		}
		return arTraducido;
	}

	private JButton getBtEspañol() {
		if (btEspañol == null) {
			btEspañol = new JButton();
			btEspañol.setText("ES");
			btEspañol.setFont(new Font("Dialog", Font.PLAIN, 12));
			btEspañol.setBorderPainted(false);
			btEspañol.setPreferredSize(new java.awt.Dimension(24, 24));
			btEspañol.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btEspañol.setMaximumSize(new java.awt.Dimension(24, 24));
			btEspañol.setMinimumSize(new java.awt.Dimension(24, 24));
			btEspañol.setContentAreaFilled(false);

		}
		return btEspañol;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton();
			btFrances.setBorderPainted(false);
			btFrances.setText("FR");
			btFrances.setFont(new Font("Dialog", Font.PLAIN, 12));
			btFrances.setPreferredSize(new java.awt.Dimension(25, 24));
			btFrances.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btFrances.setMaximumSize(new java.awt.Dimension(25, 24));
			btFrances.setMinimumSize(new java.awt.Dimension(25, 24));
			btFrances.setContentAreaFilled(false);
		}
		return btFrances;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton();
			btIngles.setBorderPainted(false);
			btIngles.setText("EN");
			btIngles.setFont(new Font("Dialog", Font.PLAIN, 12));
			btIngles.setPreferredSize(new java.awt.Dimension(24, 24));
			btIngles.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btIngles.setMaximumSize(new java.awt.Dimension(24, 24));
			btIngles.setMinimumSize(new java.awt.Dimension(24, 24));
			btIngles.setContentAreaFilled(false);
		}
		return btIngles;
	}

	private JMenu getMenuArchivo() {
		if (menuArchivo == null) {
			menuArchivo = new JMenu();
			menuArchivo.setMnemonic('A');
			menuArchivo.setText("Archivo");
			menuArchivo.add(getItNuevo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItGuardarComo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItSalir());
		}
		return menuArchivo;
	}

	private JMenu getMenuEditar() {
		if (menuEditar == null) {
			menuEditar = new JMenu();
			menuEditar.setMnemonic('E');
			menuEditar.setText("Editar");
		}
		return menuEditar;
	}

	private JMenu getMenuTraducir() {
		if (menuTraducir == null) {
			menuTraducir = new JMenu();
			menuTraducir.setMnemonic('T');
			menuTraducir.setText("Traducir");
		}
		return menuTraducir;
	}

	private JMenu getMenuHerramientas() {
		if (menuHerramientas == null) {
			menuHerramientas = new JMenu();
			menuHerramientas.setMnemonic('H');
			menuHerramientas.setText("Herramientas");
		}
		return menuHerramientas;
	}

	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setMnemonic('d');
			menuAyuda.setText("Ayuda");
		}
		return menuAyuda;
	}

	private JMenuItem getItGuardarComo() {
		if (itGuardarComo == null) {
			itGuardarComo = new JMenuItem();
			itGuardarComo.setMnemonic('G');
			itGuardarComo.setText("Guardar como...");
		}
		return itGuardarComo;
	}

	private JMenuItem getItNuevo() {
		if (itNuevo == null) {
			itNuevo = new JMenuItem();
			itNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			itNuevo.setMnemonic('N');
			itNuevo.setText("Nuevo");
		}
		return itNuevo;
	}

	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem();
			itSalir.setMnemonic('S');
			itSalir.setText("Salir");
		}
		return itSalir;
	}

	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/icono.png")));
		setSize(981, 586);
		setJMenuBar(getBarraMenu());
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Traductor de Textos");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(getBarraHerramientas(), java.awt.BorderLayout.NORTH);
		contentPane.add(getBarraEstado(), java.awt.BorderLayout.SOUTH);
		contentPane.add(getPnTextos(), java.awt.BorderLayout.CENTER);
		setContentPane(contentPane);
		this.addWindowListener(grabFoco);
	}

	public class Foco implements FocusListener {

		public void focusGained(FocusEvent e) {
			JTextArea text = (JTextArea) e.getSource();
			text.setBackground(Color.WHITE);
		}

		@Override
		public void focusLost(FocusEvent e) {
			JTextArea text = (JTextArea) e.getSource();
			text.setBackground(Color.lightGray);

		}
	}

	public class GrabFocus extends WindowAdapter {

		public void windowOpened(WindowEvent e) {
			arOriginal.grabFocus();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			int answer = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea salir de la aplicación?");
			if (answer == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	public class SetBorderPainted extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			JButton btn = (JButton) e.getSource();
			btn.setBorderPainted(true);
		}

		public void mouseExited(MouseEvent e) {
			JButton btn = (JButton) e.getSource();
			btn.setBorderPainted(false);
		}

	}

	public class ProcesaTecla extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			char teclaPulsada = e.getKeyChar();
			if (!Character.isAlphabetic(teclaPulsada)) {
				e.consume();
			}
		}
	}

	private JToggleButton getTglbtnNumbers() {
		if (tglbtnNumbers == null) {
			tglbtnNumbers = new JToggleButton("Numbers");

			tglbtnNumbers.addKeyListener(pt);
			tglbtnNumbers.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			tglbtnNumbers.setMnemonic('n');
		}
		return tglbtnNumbers;
	}

	private JCheckBox getChckbxNumbers() {
		if (chckbxNumbers == null) {
			chckbxNumbers = new JCheckBox("Numbers");
			chckbxNumbers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (chckbxNumbers.isSelected()) {
						arOriginal.grabFocus();
						arOriginal.addKeyListener(pt);
					}else {
						arOriginal.grabFocus();
						arOriginal.removeKeyListener(pt);
					}
				}
			});

		}
		return chckbxNumbers;
	}
}
