package igu;

import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTablero;
	private JButton bt0;
	private JButton bt1;
	private JTextField txtDado;
	private JLabel lblPuntuacin;
	private JButton btDado;
	
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
		contentPane.add(getTxtDado());
		setContentPane(contentPane);
		contentPane.add(getLblPuntuacin());	
		contentPane.add(getBtDado());
	}
	
	
	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			panelTablero = new JPanel();
			panelTablero.setBounds(new Rectangle(231, 163, 509, 72));
			panelTablero.setBackground(java.awt.Color.white);
			panelTablero.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelTablero.add(getBt0());
			panelTablero.add(getBt1());
		}
		return panelTablero;
	}

	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton();
			bt0.setBackground(new java.awt.Color(244, 164, 96));
		
		}
		return bt0;
	}

	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton();
			bt1.setBackground(new java.awt.Color(244, 164, 96));
		}
		return bt1;
	}

	private void habilitarTablero(boolean estado) {
//		Component [] botones = 
//		for (int i=0; i<botones.length;i++ )
//		{
//			  JButton boton = ;
//		      ;
//			}	
	   }
	
	private void representarEstadoJuego(){
//		txtDado.setText("");
//		Component[] botones = 
//		for (int i=0; i<botones.length;i++ )
//		{
//			  JButton boton = ;
//		      if (i == ){
//		        boton.setIcon(new ImageIcon("src/img/ficha.png"));
//		        boton.setDisabledIcon(new ImageIcon("src/img/ficha.png"));}
//		      else if
//		      else
//		    	 boton.setIcon(null);
//		}
//		if (){
//			JOptionPane.showMessageDialog(null, "Partida finalizada");
//				
//		}
//		else btDado.setEnabled(true);
	}
	private JTextField getTxtDado() {
		if (txtDado == null) {
			txtDado = new JTextField();
			txtDado.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 36));
			txtDado.setText("");
			txtDado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtDado.setBounds(new Rectangle(329, 95, 57, 50));
			txtDado.setEditable(false);
		}
		return txtDado;
	}

	private void jugar(int i) {
//		if (){
//		    representarEstadoJuego();
//		    
//		   }		
	}
	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuacion:");
			lblPuntuacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPuntuacin.setBounds(410, 84, 82, 14);
		}
		return lblPuntuacin;
	}
	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton("");
			btDado.setBorderPainted(false);
			btDado.setBackground(Color.WHITE);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.setBounds(231, 78, 75, 72);
		}
		return btDado;
	}
} 
