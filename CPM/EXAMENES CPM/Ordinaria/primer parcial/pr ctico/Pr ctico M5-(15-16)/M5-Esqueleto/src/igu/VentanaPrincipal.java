package igu;

import java.awt.*;

import javax.swing.*;

import logica.SpaceInvaders;
import logica.Tablero;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTablero;
	private JButton btDado;
	private JTextField txtDado;
	private JLabel lblPuntuacin;
	private JLabel lbLogo;
	
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
		setSize(882, 372);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		contentPane.add(getPanelTablero());
		contentPane.add(getBtDado());
		contentPane.add(getTxtDado());
		setContentPane(contentPane);
		contentPane.add(getLblPuntuacin());
		contentPane.add(getLbLogo());
	}
	
	
	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			panelTablero = new JPanel();
			panelTablero.setBorder(new LineBorder(Color.GREEN, 3));
			panelTablero.setBounds(new Rectangle(78, 175, 735, 72));
			panelTablero.setBackground(Color.GREEN);
			panelTablero.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return panelTablero;
	}


	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton();
			btDado.setBorderPainted(false);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.setBounds(new Rectangle(462, 35, 66, 91));
		}
		return btDado;
	}

	private void habilitarTablero(boolean estado) {
//		Component [] botones = ;
//		for (int i=0; i<botones.length;i++ )
//		{
//			 
//			}	
	   }
	
	
	private void representarEstadoJuego(){
		txtDado.setText("");
//		Component[] botones = ;
//		for (int i=0; i<botones.length;i++ )
//		{
//			  JButton boton = ;
//		      if (i == ){
//		        boton.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/nave.png")));
//		        boton.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/nave.png")));}
//		       
//		      else{
//		    		
//		    		}
//		    			
//		    		else	
//		    			boton.setIcon(null);
//		      
//		     
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
			txtDado.setForeground(Color.GREEN);
			txtDado.setBackground(Color.BLACK);
			txtDado.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 36));
			txtDado.setText(" ");
			txtDado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
			txtDado.setBounds(new Rectangle(587, 50, 57, 50));
		}
		return txtDado;
	}

	private void jugar(int i) {
//		if (){
//		   
//		   }		
	}
	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuacion:");
			lblPuntuacin.setForeground(Color.GREEN);
			lblPuntuacin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPuntuacin.setBounds(695, 37, 102, 14);
		}
		return lblPuntuacin;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lbLogo.setBounds(30, 13, 385, 101);
		}
		return lbLogo;
	}
} 
