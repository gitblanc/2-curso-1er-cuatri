/**
 * 
 */

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 *
 */
public class HashNode<T> {
	private T info;// contenido del elemento
	private int estado;// estado del elemento(borrado, vacío o lleno)
	public static final int BORRADO = -1;
	public static final int VACIO = 0;
	public static final int LLENO = 1;

	/**
	 * Constructor para la clase HashNode que pone el parámetro info a null y el
	 * estado como vacío
	 */
	public HashNode() {
		this.info = null;
		this.estado = VACIO;
	}

	/**
	 * Getter para el parámetro info
	 * 
	 * @return info
	 */
	public T getInfo() {
		return this.info;
	}

	/**
	 * Setter para el parámetro info Pone el estado a lleno
	 * 
	 * @param elemento
	 */
	public void setInfo(T elemento) {
		this.info = elemento;
		this.estado = LLENO;
	}

	/**
	 * Método que pone el estado del elemento a borrado
	 */
	public void remove() {
		// this.info = null; NO PORQUE ES BORRADO PEREZOSO
		this.estado = BORRADO;
	}

	/**
	 * Getter para el parámetro estado
	 * 
	 * @return estado
	 */
	public int getStatus() {
		return this.estado;
	}

	/**
	 * Método toString()
	 * 
	 * @return cadena
	 */
	public String toString() {
		StringBuilder cadena = new StringBuilder("{");
		switch (getStatus()) {
		case LLENO:
			cadena.append(info.toString());
			break;
		case VACIO:
			cadena.append("_E_");
			break;
		case BORRADO:
			cadena.append("_D_");
		}
		cadena.append("}");
		return cadena.toString();
	}

}
