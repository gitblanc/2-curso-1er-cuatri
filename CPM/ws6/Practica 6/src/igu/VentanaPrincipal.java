package igu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logica.Casilla;
import logica.Juego;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelTablero;
	private JLabel lblNave;
	private JButton btnDado;
	private JLabel lblTierra;
	private JLabel lblPuntos;
	private JTextField textFieldPuntos;
	private JButton btnDisparo0;
	private JButton btnDisparo1;
	private JButton btnDisparo2;
	private JButton btnDisparo3;
	private JButton btnDisparo4;
	private JButton btnDisparo5;
	private JButton btnDisparo6;
	private JButton btnDisparo7;
	private JPanel panelDisparos;
	private Juego juego;
	private JLabel lblDisparo;

	/**
	 * Create the frame.
	 * 
	 * @param juego
	 */
	public VentanaPrincipal(Juego juego) {
		setJuego(juego);// almacenar la referencia de memoria del juego real para evitar nullPointers
		setForeground(new Color(0, 0, 0));
		setTitle("Invasi\u00F3n espacial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/invader.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 380);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelTablero());
		contentPane.add(getLblNave());
		contentPane.add(getBtnDado());
		contentPane.add(getLblTierra());
		contentPane.add(getLblPuntos());
		contentPane.add(getTextFieldPuntos());
		contentPane.add(getPanelDisparos());
	}

	private void setJuego(Juego juego2) {
		this.juego = juego2;

	}

	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			panelTablero = new JPanel();
			panelTablero.setBorder(new LineBorder(new Color(238, 130, 238), 5));
			panelTablero.setBackground(new Color(238, 130, 238));
			panelTablero.setBounds(20, 220, 815, 100);
			panelTablero.setLayout(new GridLayout(1, 8, 4, 4));
			panelTablero.add(getBtnDisparo0());
			panelTablero.add(getBtnDisparo1());
			panelTablero.add(getBtnDisparo2());
			panelTablero.add(getBtnDisparo3());
			panelTablero.add(getBtnDisparo4());
			panelTablero.add(getBtnDisparo5());
			panelTablero.add(getBtnDisparo6());
			panelTablero.add(getBtnDisparo7());
			habilitaTablero(false);
		}
		return panelTablero;
	}

	private void habilitaTablero(boolean estado) {// deshabilita los botones del panelTablero
		for (int i = 0; i < getPanelTablero().getComponents().length; i++) {
			getPanelTablero().getComponents()[i].setEnabled(estado);
		}
	}

	private JLabel getLblNave() {
		if (lblNave == null) {
			lblNave = new JLabel("");
			lblNave.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/spaceship.png")));
			lblNave.setBounds(313, 11, 137, 97);
		}
		return lblNave;
	}

	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setBorderPainted(false);
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarJuego();
				}
			});
			btnDado.setToolTipText("Haz click para obtener el n\u00FAmero de disparos");
			btnDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			btnDado.setBounds(10, 11, 110, 110);
		}
		return btnDado;
	}

	private void iniciarJuego() {// se inicia el juego
		lanzarDado();
		pintarDisparos();
		habilitaTablero(true);
		getBtnDado().setEnabled(false);

	}

	private void pintarDisparos() {
		for (int i = 0; i < juego.getDisparos(); i++) {
			getPanelDisparos().add(getLabelDisparo());
		}
		validate();// obliga al panel a repintarse
	}

	private JLabel getLabelDisparo() {
		lblDisparo = new JLabel("");
		lblDisparo.setBorder(new LineBorder(Color.GREEN, 1));
		lblDisparo.setIcon(ImagenFactoria.getImagen());
		return lblDisparo;
	}

	private void lanzarDado() {
		juego.lanzar();

	}

	private JLabel getLblTierra() {
		if (lblTierra == null) {
			lblTierra = new JLabel("");
			lblTierra.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/earth.jpg")));
			lblTierra.setBounds(661, 11, 193, 175);
		}
		return lblTierra;
	}

	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("Puntos");
			lblPuntos.setFont(new Font("Arial Black", Font.PLAIN, 17));
			lblPuntos.setForeground(Color.WHITE);
			lblPuntos.setBounds(575, 22, 76, 14);
		}
		return lblPuntos;
	}

	private JTextField getTextFieldPuntos() {
		if (textFieldPuntos == null) {
			textFieldPuntos = new JTextField();
			textFieldPuntos.setFont(new Font("Arial Black", Font.PLAIN, 17));
			textFieldPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPuntos.setForeground(Color.GREEN);
			textFieldPuntos.setText(this.juego.getPuntos() + "");
			textFieldPuntos.setEditable(false);
			textFieldPuntos.setBackground(Color.BLACK);
			textFieldPuntos.setBounds(565, 47, 86, 31);
			textFieldPuntos.setColumns(10);
		}
		return textFieldPuntos;
	}

	private JButton getBtnDisparo0() {
		if (btnDisparo0 == null) {
			btnDisparo0 = new JButton("");
			btnDisparo0.setBackground(new Color(0, 0, 0));
			btnDisparo0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(0);
				}
			});
		}
		return btnDisparo0;
	}

	private void dispara(int i) {
		juego.dispara(i);
		representaJuego(i);
	}

	private void representaJuego(int i) {
		pintaPuntos();
		despintaDisparo();
		pintaCasilla(i);
		compruebaFin();
		deshabilitaBoton(i);
	}

	private void pintaPuntos() {
		getTextFieldPuntos().setText(String.valueOf(juego.getPuntos()));
	}

	private void despintaDisparo() {
		getPanelDisparos().remove(0);
		getPanelDisparos().repaint();
	}

	private void pintaCasilla(int i) {
		ImageIcon imagen = ImagenFactoria.getImagen(juego.getTablero().getCasillas()[i]);
		((JButton) getPanelTablero().getComponent(i)).setIcon(imagen);
		((JButton) getPanelTablero().getComponent(i)).setDisabledIcon(imagen);
	}

	private void compruebaFin() {
		if (juego.isPartidaFinalizada()) {
			habilitaTablero(false);
			JOptionPane.showMessageDialog(null, "Partida finalizada", "Invasi�n espacial",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void deshabilitaBoton(int i) {
		((JButton) getPanelTablero().getComponent(i)).setEnabled(false);
	}

	private JButton getBtnDisparo1() {
		if (btnDisparo1 == null) {
			btnDisparo1 = new JButton("");
			btnDisparo1.setBackground(new Color(0, 0, 0));
			btnDisparo1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(1);
				}
			});
		}
		return btnDisparo1;
	}

	private JButton getBtnDisparo2() {
		if (btnDisparo2 == null) {
			btnDisparo2 = new JButton("");
			btnDisparo2.setBackground(new Color(0, 0, 0));
			btnDisparo2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(2);
				}
			});
		}
		return btnDisparo2;
	}

	private JButton getBtnDisparo3() {
		if (btnDisparo3 == null) {
			btnDisparo3 = new JButton("");
			btnDisparo3.setBackground(new Color(0, 0, 0));
			btnDisparo3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(3);
				}
			});
		}
		return btnDisparo3;
	}

	private JButton getBtnDisparo4() {
		if (btnDisparo4 == null) {
			btnDisparo4 = new JButton("");
			btnDisparo4.setBackground(new Color(0, 0, 0));
			btnDisparo4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(4);
				}
			});
		}
		return btnDisparo4;
	}

	private JButton getBtnDisparo5() {
		if (btnDisparo5 == null) {
			btnDisparo5 = new JButton("");
			btnDisparo5.setBackground(new Color(0, 0, 0));
			btnDisparo5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(5);
				}
			});
		}
		return btnDisparo5;
	}

	private JButton getBtnDisparo6() {
		if (btnDisparo6 == null) {
			btnDisparo6 = new JButton("");
			btnDisparo6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(6);
				}
			});
			btnDisparo6.setBackground(new Color(0, 0, 0));
		}
		return btnDisparo6;
	}

	private JButton getBtnDisparo7() {
		if (btnDisparo7 == null) {
			btnDisparo7 = new JButton("");
			btnDisparo7.setBackground(new Color(0, 0, 0));
			btnDisparo7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(7);
				}
			});
		}
		return btnDisparo7;
	}

	private JPanel getPanelDisparos() {
		if (panelDisparos == null) {
			panelDisparos = new JPanel();
			panelDisparos.setBackground(new Color(0, 0, 0));
			panelDisparos.setBounds(211, 106, 345, 80);
			panelDisparos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return panelDisparos;
	}
}
