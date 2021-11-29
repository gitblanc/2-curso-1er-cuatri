/**
 * 
 */
package ColasPrioridad;

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 * Clase extra para las pruebas
 */
public class Libro implements Comparable<Libro>{
	private int priority;//prioridad del libro
	private String name;//nombre del libro
	
	/**
	 * Constructor de la clase libro
	 * @param p
	 * @param n
	 */
	public Libro(int p, String n) {
		if(p >= 0 && n != null && !n.isBlank()) {
			this.priority = p;
			this.name = n;
		}
	}
	
	/**
	 * Getter para el atributo prioridad
	 * @return priority
	 */
	public int getPriority() {
		return this.priority;
	}

	@Override
	/**
	 * Comparador de prioridades.
	 * @return int
	 */
	public int compareTo(Libro o) {
		if(this.priority > o.getPriority()) {
			return 1;
		}else if(this.priority < o.getPriority()) {
			return -1;
		}else {
			return 0;
		}
	}

	/**
	 * ToString de la clase
	 */
	public String toString() {
		return name;
	}

}
