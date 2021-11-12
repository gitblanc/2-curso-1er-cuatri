/**
 * 
 */
package AVL;

/**
 * @author blanc
 *
 */
public class AVLNode<T extends Comparable<T>> {

	private T info;// info del nodo
	private AVLNode<T> left;
	private AVLNode<T> right;
	private int balanceFactor;
	private int high;

	public AVLNode(T clave) {
		this.info = clave;
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
		this.high = 0;
	}

	public void setInfo(T clave) {
		this.info = clave;
	}

	public T getInfo() {
		return this.info;
	}

	public void setLeft(AVLNode<T> nodo) {
		this.left = nodo;
	}

	public void setRight(AVLNode<T> nodo) {
		this.right = nodo;
	}

	public AVLNode<T> getLeft() {
		return this.left;
	}

	public AVLNode<T> getRight() {
		return this.right;
	}

	public int getHeight() {
		return this.high;
	}

	public int getBF() {
		return this.balanceFactor;
	}

	public void updateBFHeight() {
		//si es null, la altura es -1
		if (getRight() != null && getLeft() == null) {
			this.balanceFactor = getRight().getHeight() - (-1);
			this.high = 1 +  Math.max(-1, getRight().getHeight());
			
		} else if (getRight() != null && getLeft() != null) {
			this.balanceFactor = getRight().getHeight() - getLeft().getHeight();
			this.high =  1 + Math.max(getRight().getHeight(), getLeft().getHeight());
		}else {
			this.balanceFactor = -1 - getLeft().getHeight() ;
			this.high = 1 +  Math.max(getLeft().getHeight(), -1);
		}
	}

	public String toString() {
		return this.info.toString() + ":BF=" + getBF();
	}
}