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
	 * Setter para parámetro info
	 */
	public void setInfo(T clave) {
		this.info = clave;
	}

	/*
	 * Getter para el parámetro info
	 */
	public T getInfo() {
		return this.info;
	}

	/**
	 * Setter de left
	 * @param nodo
	 */
	public void setLeft(BSTNode<T> nodo) {
		this.left = nodo;
	}

	public void setRight(BSTNode<T> nodo) {
		this.right = nodo;
	}

	public BSTNode<T> getLeft() {
		return this.left;
	}

	public BSTNode<T> getRight() {
		return this.right;
	}

	public String toString() {
		return info.toString();
	}
}
