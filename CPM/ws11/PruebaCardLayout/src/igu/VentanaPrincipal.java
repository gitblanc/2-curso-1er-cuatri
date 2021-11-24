/**
 * 
 */
package igu;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * @author blanc
 *
 */
public class VentanaPrincipal extends JFrame {
	public VentanaPrincipal() {
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.YELLOW);
		getContentPane().add(panel1, "panel1");
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.BLUE);
		getContentPane().add(panel2, "panel2");
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.GREEN);
		getContentPane().add(panel3, "panel3");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
