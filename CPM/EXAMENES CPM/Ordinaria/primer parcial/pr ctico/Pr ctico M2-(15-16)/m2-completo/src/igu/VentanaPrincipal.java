package igu;

import logica.JuegoOso;
import logica.Tablero;

import java.awt.*;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	private JuegoOso juego;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTablero;
	private JButton bt0;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JTextField txPuntuacion;
	private JButton btDado;
	private JTextField txtDado;
	private JLabel etFoto;
	private JLabel lblPuntuacin;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenuItem itNuevo;
	private JMenuItem itSalir;
	private JSeparator separator;
	private JMenu mnAyuda;
	private JMenuItem itAcercaDe;
	private JButton bt6;
	private JButton bt7;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaPrincipal() {
		juego = new JuegoOso();
		setSize(770, 324);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/miel.jpg")));
		setResizable(false);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setTitle("El juego del Oso y la Miel");
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(java.awt.Color.white);
		contentPane.add(getPanelTablero());
		contentPane.add(getBtDado());
		contentPane.add(getTxtDado());
		contentPane.add(getEtFoto());
		contentPane.add(getTxPuntuacion());
		setContentPane(contentPane);
		contentPane.add(getLblPuntuacin());
		representarEstadoJuego();
		habilitarTablero(false);
	}

	private JLabel getEtFoto() {
	  if (etFoto == null) {
		etFoto = new JLabel();
		etFoto.setBounds(new Rectangle(0, 0, 214, 151));
		etFoto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		etFoto.setText("");
		}
	  return etFoto;
	}
	
	
	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			GridLayout gl_panelTablero = new GridLayout();
			gl_panelTablero.setRows(1);
			gl_panelTablero.setColumns(11);
			panelTablero = new JPanel();
			panelTablero.setBounds(new Rectangle(42, 161, 667, 83));
			panelTablero.setBackground(java.awt.Color.white);
			panelTablero.setLayout(gl_panelTablero);
			panelTablero.add(getBt0(), null);
			panelTablero.add(getBt1(), null);
			panelTablero.add(getBt2(), null);
			panelTablero.add(getBt3(), null);
			panelTablero.add(getBt4(), null);
			panelTablero.add(getBt5(), null);
			panelTablero.add(getBt6());
			panelTablero.add(getBt7());
		}
		return panelTablero;
	}

	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton();
			bt0.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/oso.jpg")));
			bt0.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt0.setBackground(Color.WHITE);
		
		}
		return bt0;
	}

	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton();
			bt1.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt1.setBackground(Color.WHITE);
				bt1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(1);
					}});
		}
		return bt1;
	}

	private JButton getBt2() {
		if (bt2 == null) {
			bt2 = new JButton();
			bt2.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt2.setBackground(Color.WHITE);
				bt2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(2);
				}});
		}
		return bt2;
	}

	private JButton getBt3() {
		if (bt3 == null) {
			bt3 = new JButton();
			bt3.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt3.setBackground(Color.WHITE);
			bt3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(3);
				}});
		}
		return bt3;
	}

	private JButton getBt4() {
		if (bt4 == null) {
			bt4 = new JButton();
			bt4.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt4.setBackground(Color.WHITE);
			bt4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(4);
				}});
		}
		return bt4;
	}

	private JButton getBt5() {
		if (bt5 == null) {
			bt5 = new JButton();
			bt5.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt5.setBackground(Color.WHITE);
			bt5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(5);
				}});
		}
		return bt5;
	}
	
	private JButton getBt6() {
		if (bt6 == null) {
			bt6 = new JButton();
			bt6.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt6.setBackground(Color.WHITE);
			bt6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(6);
				}});
		}
		return bt6;
	}
	private JButton getBt7() {
		if (bt7 == null) {
			bt7 = new JButton();
			bt7.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/miel.jpg")));
			bt7.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt7.setBackground(Color.WHITE);
			bt7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(7);
				}});
		}
		return bt7;
	}
	
	private JTextField getTxPuntuacion() {
		if (txPuntuacion == null) {
			txPuntuacion = new JTextField();
			txPuntuacion.setEnabled(false);
			txPuntuacion.setBounds(410, 109, 88, 31);
			txPuntuacion.setEditable(false);
			txPuntuacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txPuntuacion.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 24));
		}
		return txPuntuacion;
	}


	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton();
			btDado.setToolTipText("Clic para lanzar el dado");
			btDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.setBorderPainted(false);
			btDado.setContentAreaFilled(false);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.setBounds(new Rectangle(216, 78, 76, 72));
			btDado.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			btDado.setMnemonic(java.awt.event.KeyEvent.VK_D);
			btDado.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (juego.lanzarDado()){
						txtDado.setText(String.valueOf(juego.getNumeroDado()));
						habilitarTablero(true);
					    btDado.setEnabled(false);
					    
					    }
			        else {
			        	txtDado.setText(String.valueOf(juego.getNumeroDado()));
			        	JOptionPane.showMessageDialog(null,"La jugada no es posible, cambia el turno. Vuelve a tirar");
			        	habilitarTablero(false);
			        	btDado.setEnabled(true);
			        	txtDado.setText("");
			        }
				  }      
			});
		}
		return btDado;
	}

	private void habilitarTablero(boolean estado) {
		Component [] botones = panelTablero.getComponents();
		for (int i=0; i<botones.length;i++ )
		{
			  JButton boton = (JButton) botones[i];
		      boton.setEnabled(estado);
			}	
	   }
	
	private void representarEstadoJuego(){
		txtDado.setText("");
		txPuntuacion.setText(String.valueOf(juego.getPuntosJugador()));
		Component[] botones = panelTablero.getComponents();
		for (int i=0; i<botones.length;i++ )
		{
			  JButton boton = (JButton) botones[i];
		      if (i == juego.getPosicionOso()){
		        boton.setIcon(new ImageIcon("src/img/oso.jpg"));
		        boton.setDisabledIcon(new ImageIcon("src/img/oso.jpg"));}
		      else if (juego.hayEnjambre(i)){
			        boton.setIcon(new ImageIcon("src/img/enjambre.jpg"));
			        boton.setDisabledIcon(new ImageIcon("src/img/enjambre.jpg"));}
		      else if (i == Tablero.POSICION_META){
			        boton.setIcon(new ImageIcon("src/img/miel.jpg"));
			        boton.setDisabledIcon(new ImageIcon("src/img/miel.jpg"));}
		      else
		    	 boton.setIcon(null);
		}
		if (juego.isPartidaFinalizada()){
			JOptionPane.showMessageDialog(null, "Partida finalizada");
			habilitarTablero(false);			
		}
		else btDado.setEnabled(true);
	}
	
	private void jugar(int i) {
		if (juego.resolverJugada(i)){
		    representarEstadoJuego();
		    habilitarTablero(false);
		   }		
	}

	private JTextField getTxtDado() {
		if (txtDado == null) {
			txtDado = new JTextField();
			txtDado.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 36));
			txtDado.setText(" ");
			txtDado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtDado.setBounds(new Rectangle(302, 95, 57, 50));
			txtDado.setEditable(false);
		}
		return txtDado;
	}

	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuacion:");
			lblPuntuacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPuntuacin.setBounds(410, 84, 82, 14);
		}
		return lblPuntuacin;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('J');
			mnJuego.add(getItNuevo());
			mnJuego.add(getSeparator());
			mnJuego.add(getItSalir());
		}
		return mnJuego;
	}
	private JMenuItem getItNuevo() {
		if (itNuevo == null) {
			itNuevo = new JMenuItem("Nuevo");
			itNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					juego.inicializarJuego();
					representarEstadoJuego();
				}
			});
			itNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
			itNuevo.setMnemonic('N');
		}
		return itNuevo;
	}
	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem("Salir");
			itSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			itSalir.setMnemonic('S');
		}
		return itSalir;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('A');
			mnAyuda.add(getItAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getItAcercaDe() {
		if (itAcercaDe == null) {
			itAcercaDe = new JMenuItem("Acerca de");
			itAcercaDe.setMnemonic('A');
		}
		return itAcercaDe;
	}	
	
} 
