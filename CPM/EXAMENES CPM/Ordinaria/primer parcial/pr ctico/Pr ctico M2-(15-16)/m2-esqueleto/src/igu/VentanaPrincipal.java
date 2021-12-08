package igu;

import java.awt.*;
import javax.swing.*;


public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTablero;
	private JButton btDado;
	private JTextField txtDado;
	private JLabel etFoto;
	private JLabel lblPuntuacion;
	private JButton bt0;
	private JButton bt1;
	
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
		setSize(770, 324);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(java.awt.Color.white);
		contentPane.add(getPanelTablero());
		contentPane.add(getBtDado());
		contentPane.add(getTxtDado());
		contentPane.add(getEtFoto());
		setContentPane(contentPane);
		contentPane.add(getLblPuntuacion());
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
			panelTablero = new JPanel();
			panelTablero.setBounds(new Rectangle(42, 161, 667, 83));
			panelTablero.setBackground(java.awt.Color.white);
			panelTablero.add(getBt0());
			panelTablero.add(getBt1());
		}
		return panelTablero;
	}


	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton();
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.setBorderPainted(false);
			btDado.setContentAreaFilled(false);
			btDado.setBounds(new Rectangle(216, 78, 76, 72));
			btDado.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
		}
		return btDado;
	}

	private void habilitarTablero(boolean estado) {
//		Component [] botones = ;
//		for (int i=0; i<botones.length;i++ )
//		{
//			  JButton boton = ;
//		
//		}	
	}
	
	private void representarEstadoJuego(){
//		txtDado.setText("");
//		Component[] botones = ;
//		for (int i=0; i<botones.length;i++ )
//		{
//			  JButton boton = ;
//		      if (i == ){
//		        boton.setIcon(new ImageIcon("src/img/oso.jpg"));
//		      
//			  }
//		      else if (   ) {
//				boton.setIcon(new ImageIcon("src/img/miel.jpg"));
//		
//				}
//		      else 
//					boton.setIcon(null);
//					
//				}
//		    	 
//		}
//		if (    ){
//			JOptionPane.showMessageDialog(null, "Partida finalizada");
//		
//		}
//		else btDado.setEnabled(true);
	}
	
	private void jugar(int i) {
//		if (){
//		    representarEstadoJuego();
//
//		   }		
	}
		
	private JTextField getTxtDado() {
		if (txtDado == null) {
			txtDado = new JTextField();
			txtDado.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 36));
			txtDado.setText(" ");
			txtDado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtDado.setBounds(new Rectangle(302, 95, 57, 50));
		}
		return txtDado;
	}
	
	private JLabel getLblPuntuacion() {
		if (lblPuntuacion == null) {
			lblPuntuacion = new JLabel("Puntuacion:");
			lblPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPuntuacion.setBounds(410, 84, 82, 14);
		}
		return lblPuntuacion;
	}
	
	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton("");
		}
		return bt0;
	}
	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton("");
		}
		return bt1;
	}
} 
