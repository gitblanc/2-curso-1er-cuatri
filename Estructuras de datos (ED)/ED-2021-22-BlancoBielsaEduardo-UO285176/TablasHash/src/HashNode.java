/**
 * 
 */

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 *
 */
public class HashNode<T> {
	private T info;// contenido del elemento
	private int estado;// estado del elemento(borrado, vac�o o lleno)
	public static final int BORRADO = -1;
	public static final int VACIO = 0;
	public static final int LLENO = 1;

	/**
	 * Constructor para la clase HashNode que pone el par�metro info a null y el
	 * estado como vac�o
	 */
	public HashNode() {
		this.info = null;
		this.estado = VACIO;
	}

	/**
	 * Getter para el par�metro info
	 * 
	 * @return info
	 */
	public T getInfo() {
		return this.info;
	}

	/**
	 * Setter para el par�metro info Pone el estado a lleno
	 * 
	 * @param elemento
	 */
	public void setInfo(T elemento) {
		this.info = elemento;
		this.estado = LLENO;
	}

	/**
	 * M�todo que pone el estado del elemento a borrado
	 */
	public void remove() {
		// this.info = null; NO PORQUE ES BORRADO PEREZOSO
		this.estado = BORRADO;
	}

	/**
	 * Getter para el par�metro estado
	 * 
	 * @return estado
	 */
	public int getStatus() {
		return this.estado;
	}

	/**
	 * M�todo toString()
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
