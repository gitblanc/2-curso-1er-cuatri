/**
 * 
 */
package igu;


import java.awt.EventQueue;

import javax.swing.UIManager;

import logica.Carta;
import logica.Pedido;

/**
 * @author blanc
 *
 */
public class Main {

	/**
	 * Código que invoca al programa principal
	 * @param args
	 */
	public static void main(String[] args) {
		Carta carta = new Carta();
		Pedido pedido = new Pedido();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(carta, pedido);
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		);

	}

}
