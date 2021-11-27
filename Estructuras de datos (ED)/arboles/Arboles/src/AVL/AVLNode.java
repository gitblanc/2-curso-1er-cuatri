/**
 * 
 */
package AVL;

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 *
 */
public class AVLNode<T extends Comparable<T>> {

	private T info;// info del nodo
	private AVLNode<T> left;// hijo izquierdo
	private AVLNode<T> right;// hijo derecho
	private int balanceFactor;// factor de balance
	private int high;// altura

	/**
	 * Constructor de la clase AVLNode
	 * 
	 * @param clave
	 */
	public AVLNode(T clave) {
		this.info = clave;
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
		this.high = 0;
	}

	/**
	 * Setter para el parámetro info
	 * 
	 * @param clave
	 */
	public void setInfo(T clave) {
		this.info = clave;
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
	 * Setter para el hijo izquierdo
	 * 
	 * @param nodo
	 */
	public void setLeft(AVLNode<T> nodo) {
		this.left = nodo;
	}

	/**
	 * Setter para el hijo derecho
	 * 
	 * @param nodo
	 */
	public void setRight(AVLNode<T> nodo) {
		this.right = nodo;
	}

	/**
	 * Getter para el hijo izquierdo
	 * 
	 * @return left
	 */
	public AVLNode<T> getLeft() {
		return this.left;
	}

	/**
	 * Getter para el hijo derecho
	 * 
	 * @return right
	 */
	public AVLNode<T> getRight() {
		return this.right;
	}

	/**
	 * Getter para la altura
	 * 
	 * @return high
	 */
	public int getHeight() {
		return this.high;
	}

	/**
	 * Getter para el factor de balance
	 * 
	 * @return balanceFactor
	 */
	public int getBF() {
		return this.balanceFactor;
	}

	/**
	 * Método que actualiza el factor de balance de un nodo AVL
	 */
	public void updateBFHeight() {
		// si es null, la altura es -1
		if (getRight() != null && getLeft() == null) {
			this.balanceFactor = getRight().getHeight() - (-1);
			this.high = 1 + Math.max(-1, getRight().getHeight());

		} else if (getRight() != null && getLeft() != null) {
			this.balanceFactor = getRight().getHeight() - getLeft().getHeight();
			this.high = 1 + Math.max(getRight().getHeight(), getLeft().getHeight());
		} else if (getRight() == null && getLeft() == null) {
			this.balanceFactor = 0;
			this.high = 0;
		} else {
			this.balanceFactor = -1 - getLeft().getHeight();
			this.high = 1 + Math.max(getLeft().getHeight(), -1);
		}
	}

	/**
	 * ToString de la clase AVLNode
	 */
	public String toString() {
		return this.info.toString() + ":BF=" + getBF();
	}
}
