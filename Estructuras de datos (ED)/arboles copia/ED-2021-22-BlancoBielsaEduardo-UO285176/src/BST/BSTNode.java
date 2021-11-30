/**
 * 
 */
package BST;

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 *
 */
public class BSTNode<T extends Comparable<T>> {
	private T info;// contenido del nodo
	private BSTNode<T> left;// nodo hijo izquierdo
	private BSTNode<T> right;// nodo hijo derecho

	/*
	 * Constructor para la clase BSTNode
	 */
	public BSTNode(T clave) {
		this.info = clave;
		this.left = null;
		this.right = null;
	}

	/*
	 * Setter para par�metro info
	 */
	public void setInfo(T clave) {
		this.info = clave;
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
	 * Setter del hijo izquierdo
	 * 
	 * @param left
	 */
	public void setLeft(BSTNode<T> nodo) {
		this.left = nodo;
	}

	/**
	 * Setter del hijo derecho
	 * 
	 * @param right
	 */
	public void setRight(BSTNode<T> nodo) {
		this.right = nodo;
	}

	/**
	 * Getter del hijo izquierdo
	 * 
	 * @return left
	 */
	public BSTNode<T> getLeft() {
		return this.left;
	}

	/**
	 * Getter para el hijo derecho
	 * 
	 * @return right
	 */
	public BSTNode<T> getRight() {
		return this.right;
	}

	/**
	 * ToString de la clase BSTNode
	 */
	public String toString() {
		return info.toString();
	}
}
