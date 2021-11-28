/**
 * 
 */
package evt;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author blanc
 *
 */
public class ProcesaTecla extends KeyAdapter {
	public void keyTyped(KeyEvent e) {
		char teclaPulsada = e.getKeyChar();
		if (!Character.isAlphabetic(teclaPulsada)) {
			e.consume();
		}
	}
}
