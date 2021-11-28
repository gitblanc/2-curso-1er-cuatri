/**
 * 
 */
package evt;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

/**
 * @author blanc
 *
 */
public class Foco implements FocusListener {

	public void focusGained(FocusEvent e) {
		JTextArea text = (JTextArea) e.getSource();
		text.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextArea text = (JTextArea) e.getSource();
		text.setBackground(Color.lightGray);

	}
}
