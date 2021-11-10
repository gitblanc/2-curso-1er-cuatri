/**
 * 
 */
package igu;

import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import player.MusicPlayer;

/**
 * @author blanc
 *
 */
public class Main {

	/**
	 * C�digo que invoca al programa principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MusicPlayer musicp = new MusicPlayer();
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Properties p = new Properties();
					p.put("logoString", "");
					p.put("focusColor", "0 0 0");//cambia el color del foco
					HiFiLookAndFeel.setCurrentTheme(p);
					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(musicp);
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
				}
			}
		});

	}

}
