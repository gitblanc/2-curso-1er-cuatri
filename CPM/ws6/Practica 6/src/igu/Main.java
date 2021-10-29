/**
 * 
 */
package igu;

import java.awt.EventQueue;

import logica.Juego;

/**
 * @author UO285176
 *
 */
public class Main {

	/**
	 * Código que invoca al programa principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(juego);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
