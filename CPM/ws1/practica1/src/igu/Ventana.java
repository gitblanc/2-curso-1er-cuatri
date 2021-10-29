package igu;

import java.awt.Color;

import javax.swing.*;

public class Ventana extends JFrame{
	
	private JPanel pnPanelPrincipal;
	private JButton btAceptar;//primero el acr�nimo "bt" y despu�s lo que va a hacer "Aceptar"
    private JButton btCancelar;
    private JLabel lbLabel;
    private JTextField txfTextField;
	
	
	public Ventana() {//constructor
		this.setTitle("Primera ventana");
		this.setBounds(100, 100, 400, 300);//posici�n y tama�o
		
		pnPanelPrincipal = new JPanel();
		pnPanelPrincipal.setBackground(Color.pink);//establecer un color para que no se mezcle con el vac�o
		pnPanelPrincipal.setLayout(null);//para que no coloque botones autom�ticamente
		this.setContentPane(pnPanelPrincipal);//extender el panel
		
		btAceptar = new JButton("Aceptar");
		//btAceptar.setText("Aceptar");
		btAceptar.setBounds(160, 220, 100, 30);
		pnPanelPrincipal.add(btAceptar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(270, 220, 100, 30);
		pnPanelPrincipal.add(btCancelar);
		
		lbLabel = new JLabel("Introduzca su nombre: ");
		lbLabel.setBounds(10, 50, 100, 30);
		pnPanelPrincipal.add(lbLabel);
		
	}

	public static void main(String[] args) {//main
		Ventana ventana = new Ventana();
		ventana.setVisible(true);//esto ha de ser lo �ltimo que se ejecuta

	}

}
