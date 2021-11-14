/**
 * 
 */
package igu;

import src.Pedido;
import src.Ruleta;

/**
 * @author blanc
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		Ruleta ruleta = new Ruleta();
		VentanaPrincipal frame = new VentanaPrincipal(ruleta, pedido);
		frame.setVisible(true);
	}

}
