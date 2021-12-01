package igu;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.text.DateFormat;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnBotones;
	private JPanel pnFechaHora;
	private JPanel pnBandera;
	private JButton btEspañol;
	private JButton btIngles;
	private JButton btFrances;
	private JLabel lbFecha;
	private JLabel lbHora;
	private JLabel lbBandera;
	private JTextArea taTexto;
	//private ResourceBundle mensajes;

	Locale localizacion = Locale.getDefault(Locale.Category.FORMAT);
	private JButton btItaliano;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Ejemplo de Internacionalización");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 320);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnBotones(), BorderLayout.NORTH);
		contentPane.add(getPnFechaHora(), BorderLayout.SOUTH);
		contentPane.add(getPnBandera(), BorderLayout.WEST);
		contentPane.add(getTaTexto(), BorderLayout.CENTER);
		localizar(localizacion);
	}

	private void localizar(Locale localizacion) {
		ResourceBundle mensajes = ResourceBundle.getBundle("rcs/Textos", localizacion);
		getTaTexto().setText(mensajes.getString("texto1"));
		
		setTitle(mensajes.getString("titulo1"));

		String imagenBandera = "/img/" + mensajes.getString("bandera") + ".png";
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource(imagenBandera)));
		lbBandera.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(imagenBandera)));

		Date fechaHora = new Date();
		// Falta que la fecha tenga el formato correspondiente a la localización
		lbFecha.setText(fechaHora.toString());

		DateFormat formatoHora = DateFormat.getTimeInstance(DateFormat.LONG, localizacion);
		lbHora.setText(formatoHora.format(fechaHora));
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			pnBotones.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones.add(getBtEspañol());
			pnBotones.add(getBtIngles());
			pnBotones.add(getBtFrances());
			pnBotones.add(getBtItaliano());
		}
		return pnBotones;
	}

	private JPanel getPnFechaHora() {
		if (pnFechaHora == null) {
			pnFechaHora = new JPanel();
			pnFechaHora.setLayout(new GridLayout(1, 2, 0, 0));
			pnFechaHora.add(getLbFecha());
			pnFechaHora.add(getLbHora());
		}
		return pnFechaHora;
	}

	private JPanel getPnBandera() {
		if (pnBandera == null) {
			pnBandera = new JPanel();
			pnBandera.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			pnBandera.setBackground(Color.WHITE);
			pnBandera.add(getLbBandera());
		}
		return pnBandera;
	}

	private JButton getBtEspañol() {
		if (btEspañol == null) {
			btEspañol = new JButton("es");
			btEspañol.setMnemonic('e');
			btEspañol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale("es"));
				}
			});
		}
		return btEspañol;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton("en");
			btIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("en"));
				}
			});
			btIngles.setMnemonic('n');
		}
		return btIngles;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton("fr");
			btFrances.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("fr"));
				}
			});
			btFrances.setMnemonic('f');
		}
		return btFrances;
	}

	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("");
		}
		return lbFecha;
	}

	private JLabel getLbHora() {
		if (lbHora == null) {
			lbHora = new JLabel("");
		}
		return lbHora;
	}

	private JLabel getLbBandera() {
		if (lbBandera == null) {
			lbBandera = new JLabel("");
			lbBandera.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/españa.PNG")));
		}
		return lbBandera;
	}

	private JTextArea getTaTexto() {
		if (taTexto == null) {
			taTexto = new JTextArea();
			taTexto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			taTexto.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
			taTexto.setWrapStyleWord(true);
			taTexto.setLineWrap(true);
			taTexto.setText("");
		}
		return taTexto;
	}
	private JButton getBtItaliano() {
		if (btItaliano == null) {
			btItaliano = new JButton("it");
			btItaliano.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("it"));
				}
			});
			btItaliano.setMnemonic('i');
		}
		return btItaliano;
	}
}
