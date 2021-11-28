/**
 * 
 */
package evt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * @author blanc
 *
 */
public class SetBorderPainted extends MouseAdapter {
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBorderPainted(true);
	}

	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBorderPainted(false);
	}

}
