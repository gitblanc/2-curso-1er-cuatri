/**
 * 
 */

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 *
 */
public class HashNode<T> {
	private T info;
	private int estado;
	public static final int BORRADO = -1;
	public static final int VACIO = 0;
	public static final int LLENO = 1;

	/**
	 *  
	 */
	public HashNode() {
		this.info = null;
		this.estado = VACIO;
	}

	public T getInfo() {
		return this.info;
	}

	public void setInfo(T elemento) {
		this.info = elemento;
		this.estado = LLENO;
	}

	public void remove() {
		// this.info = null; NO PQ ES BORRADO PEREZOSO
		this.estado = BORRADO;
	}

	public int getStatus() {
		return this.estado;
	}

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
