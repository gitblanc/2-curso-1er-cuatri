package igu;

import logica.JuegoMinions;

import java.awt.*;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTablero;
	private JButton bt0;
	private JButton btDado;
	private JTextField txtDado;
	private JLabel etFoto;
	private JLabel lblPuntuacin;

	
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
		setSize(769, 300);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.add(getPanelTablero());
		contentPane.add(getBtDado());
		contentPane.add(getTxtDado());
		contentPane.add(getEtFoto());
		setContentPane(contentPane);
		contentPane.add(getLblPuntuacin());
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
			panelTablero = new JPanel();
			panelTablero.setBounds(new Rectangle(30, 161, 713, 72));
			panelTablero.setBackground(java.awt.Color.white);
			panelTablero.setLayout(new BoxLayout(panelTablero, BoxLayout.X_AXIS));
			panelTablero.add(getBt0());
		}
		return panelTablero;
	}

	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton();
			bt0.setBackground(new Color(245, 255, 250));
		
		}
		return bt0;
	}

	
		private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton();
			btDado.setBorderPainted(false);
			btDado.setContentAreaFilled(false);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.png")));
			btDado.setBounds(new Rectangle(42, 41, 76, 72));
		}
		return btDado;
	}

	private void habilitarTablero(boolean estado) {
//		Component [] botones = ;
//		for (int i=0; i<botones.length;i++ )
		{
			
		}	
	}
	
	private void representarEstadoJuego(){
		txtDado.setText("");
//		Component[] botones = ;
//		for (int i=0; i<botones.length;i++ )
//		{
//			JButton boton = (JButton) botones[i];
//			if (i == ){
//				boton.setIcon(new ImageIcon("src/img/Minion.png"));
//			}
//			  
//			else
//				boton.setIcon(null);
//			}
//		if (){
//			JOptionPane.showMessageDialog(null, "Partida finalizada");
//					
//		}
//		else btDado.setEnabled(true);
	}
	
	private void jugar(int i) {
		
	}

	private JTextField getTxtDado() {
		if (txtDado == null) {
			txtDado = new JTextField();
			txtDado.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 36));
			txtDado.setText(" ");
			txtDado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtDado.setBounds(new Rectangle(128, 58, 57, 50));
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
} 
