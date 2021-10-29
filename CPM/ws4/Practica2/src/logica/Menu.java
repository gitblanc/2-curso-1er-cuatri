/**
 * 
 */
package logica;

/**
 * @author blanc
 *
 */
public class Menu {
	private String[] options = { "Ver art�culos", "A�adir al pedido", "Ver el precio total", "Grabar pedido",
			"Obtener c�digo" };

	public int readOption() {
		return Console.readInteger("Option");
	}

	public void show() {
		int i = 1;
		for (String line : options) {
			if ("".equals(line)) {
				System.out.println("");
				continue;
			}
			Console.printf("\t%2d- %s\n", i++, line);
		}
		Console.printf("\n\t%2d- %s\n", 0, "Salir");
	}
}
