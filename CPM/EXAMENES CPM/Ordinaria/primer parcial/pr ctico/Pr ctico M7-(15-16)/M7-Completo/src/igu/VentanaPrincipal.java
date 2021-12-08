package igu;

import logica.JuegoMinions;
import logica.Tablero;

import java.awt.*;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	private JuegoMinions juego;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTablero;
	private JButton bt0;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt7;
	private JButton bt8;
	private JButton bt9;	
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
		juego = new JuegoMinions();
		setSize(769, 300);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/Minion.png")));
		setResizable(false);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setTitle("Minion Escape");
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 224));
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
		etFoto.setBounds(new Rectangle(297, 0, 214, 151));
		etFoto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
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
			panelTablero.setBounds(new Rectangle(30, 161, 713, 72));
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
			panelTablero.add(getBt8());
			panelTablero.add(getBt9());
		}
		return panelTablero;
	}

	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton();
			bt0.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Minion.png")));
			bt0.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt0.setBackground(new Color(245, 255, 250));
		
		}
		return bt0;
	}

	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton();
			bt1.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt1.setBackground(new Color(245, 255, 250));
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
			bt2.setBackground(new Color(245, 255, 250));
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
			bt3.setBackground(new Color(245, 255, 250));
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
			bt4.setBackground(new Color(245, 255, 250));
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
			bt5.setBackground(new Color(245, 255, 250));
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
			bt6.setBackground(new Color(245, 255, 250));
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
			bt7.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			bt7.setBackground(new Color(245, 255, 250));
			bt7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(7);
				}});
		}
		return bt7;
	}
	private JButton getBt8() {
		if (bt8 == null) {
			bt8 = new JButton("");
			bt8.setBackground(new Color(245, 255, 250));
			bt8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(8);
				}});
		}
		return bt8;
	}
	private JButton getBt9() {
		if (bt9 == null) {
			bt9 = new JButton("");
			bt9.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/bananas.png")));
			bt9.setBackground(new Color(245, 255, 250));
			bt9.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jugar(9);
				}});
		}
		return bt9;
	}
	
	private JTextField getTxPuntuacion() {
		if (txPuntuacion == null) {
			txPuntuacion = new JTextField();
			txPuntuacion.setEnabled(false);
			txPuntuacion.setBounds(608, 91, 88, 31);
			txPuntuacion.setEditable(false);
			txPuntuacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txPuntuacion.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 24));
		}
		return txPuntuacion;
	}


	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton();
			btDado.setBorder(null);
			btDado.setToolTipText("Clic para lanzar el dado");
			btDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.png")));
			btDado.setBorderPainted(false);
			btDado.setContentAreaFilled(false);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.png")));
			btDado.setBounds(new Rectangle(42, 41, 76, 72));
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
			        	JOptionPane.showMessageDialog(null,"La jugada no es posible, vuelve a tirar");
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
		txPuntuacion.setText(String.valueOf(juego.getTotalBananas()));
		Component[] botones = panelTablero.getComponents();
		for (int i=0; i<botones.length;i++ )
		{
			JButton boton = (JButton) botones[i];
			if (i == juego.getPosicionMinion()){
				boton.setIcon(new ImageIcon("src/img/Minion.png"));
				boton.setDisabledIcon(new ImageIcon("src/img/Minion.png"));
				
				if (juego.hayEnemigo(i)){
				JOptionPane.showMessageDialog(null, "El enemigo te ha quitado la mitad de las bananas");
				}
			}
			  
			else if (juego.hayEnemigo(i)){
				boton.setIcon(new ImageIcon("src/img/enemigo.png"));
				boton.setDisabledIcon(new ImageIcon("src/img/enemigo.png"));
			}
			else if (i==Tablero.POSICION_META){
				boton.setIcon(new ImageIcon("src/img/bananas.png"));
				boton.setDisabledIcon(new ImageIcon("src/img/bananas.png"));
			}
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
			txtDado.setBounds(new Rectangle(128, 58, 57, 50));
			txtDado.setEditable(false);
		}
		return txtDado;
	}

	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Bananas:");
			lblPuntuacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPuntuacin.setBounds(608, 66, 82, 14);
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
			itAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Nombre\nApellido1 Apellido2\nxxxxxxxx-y", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			itAcercaDe.setMnemonic('A');
		}
		return itAcercaDe;
	}	
} 
