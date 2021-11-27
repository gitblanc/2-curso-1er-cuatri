/**
 * 
 */
package BST;

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 *
 */
public class BSTree<T extends Comparable<T>> {
	private BSTNode<T> raiz;// nodo raíz del árbol

	/**
	 * Constructor default para la clase BSTree
	 */
	public BSTree() {
		this.raiz = null;
	}

	/**
	 * Getter para la raíz del árbol
	 * 
	 * @return raiz
	 */
	public BSTNode<T> getRaiz() {
		return this.raiz;
	}

	/**
	 * Condiciones: 1 Si la clave es nula o la raíz es nula, devuelve null. 2
	 * Devuelve null si no lo encuentra o bien el nodo usando un método recursivo
	 * 
	 * @param clave
	 * @return node
	 */
	public BSTNode<T> searchNode(T clave) {
		if (clave == null || this.raiz == null) {
			return null;
		}
		return searchNodeRecursivo(raiz, clave);
	}

	/**
	 * Método privado para encontrar un nodo en el árbol de forma recursiva
	 * 
	 * @param raiz2
	 * @param clave
	 * @return node
	 */
	private BSTNode<T> searchNodeRecursivo(BSTNode<T> raiz2, T clave) {
		if (raiz2 == null) {
			return null;
		}
		// COMPARE TO devuelve > 0 si obj1 > obj2
		// devuelve < 0 si obj1 < obj2
		// devuelve = 0 si obj1 = obj2
		else if (raiz2.getInfo().compareTo(clave) > 0) {// si la clave es menor que el nodo
														// busca por la izquierda
			return searchNodeRecursivo(raiz2.getLeft(), clave);
		} else if (raiz2.getInfo().compareTo(clave) < 0) {// si la clave es mayor que el
															// nodo busca por la derecha
			return searchNodeRecursivo(raiz2.getRight(), clave);
		} else if (raiz2.getInfo().compareTo(clave) == 0) {// si la clave es igual que el nodo lo devuelve
			return raiz2;
		} else {// si no lo encuentra devuelve null
			return null;
		}

	}

	/**
	 * Condiciones: Devuelve 0 si añade correctamente el elemento al árbol. Devuelve
	 * -2 si la clave es null. Devuelve -1 si intenta insertar una clave ya
	 * existente.
	 * 
	 * @param clave
	 * @return int
	 */
	public int addNode(T clave) {
		if (clave == null) {
			return -2;
		} else if (this.raiz == null) {
			this.raiz = new BSTNode<T>(clave);
			return 0;
		} else {
			return addNodeRecursivo(this.raiz, clave);

		}

	}

	/**
	 * Método privado recursivo para añadir un nodo al árbol. Devuelve 0 si lo añade
	 * o -1 si no.
	 * 
	 * @param raiz2
	 * @param clave
	 * @return int
	 */
	private int addNodeRecursivo(BSTNode<T> raiz2, T clave) {
		if (raiz2.getInfo().compareTo(clave) > 0) {
			if (raiz2.getLeft() != null) {
				return addNodeRecursivo(raiz2.getLeft(), clave);
			} else {
				raiz2.setLeft(new BSTNode<T>(clave));
				return 0;
			}
		} else if (raiz2.getInfo().compareTo(clave) < 0) {
			if (raiz2.getRight() != null) {
				return addNodeRecursivo(raiz2.getRight(), clave);
			} else {
				raiz2.setRight(new BSTNode<T>(clave));
				return 0;
			}
		} else {
			return -1;
		}

	}

	/**
	 * Decuelve el recorrido preOrden: raíz, izquierda, derecha
	 * 
	 * @return cadena
	 */
	public String preOrder() {
		String cadena = recorridoPreOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	/**
	 * Método privado recursivo para el preOrden
	 * 
	 * @param raiz2
	 * @return cadena
	 */
	private String recorridoPreOrderRecursivo(BSTNode<T> raiz2) {
		if (raiz2 == null) {
			return "";
		} else {
			String cadena = raiz2.getInfo().toString();
			cadena += "\t";
			cadena += recorridoPreOrderRecursivo(raiz2.getLeft());
			cadena += recorridoPreOrderRecursivo(raiz2.getRight());
			return cadena;
		}
	}

	/**
	 * Devuelve el recorrido postOrden: izquierda, derecha, raíz
	 * 
	 * @return cadena
	 */
	public String postOrder() {
		String cadena = recorridoPostOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	/**
	 * Método privado recursivo para el recorrido postOrden
	 * 
	 * @param raiz2
	 * @return cadena
	 */
	private String recorridoPostOrderRecursivo(BSTNode<T> raiz2) {
		String cadena = "";
		if (raiz2 != null) {
			cadena += recorridoPostOrderRecursivo(raiz2.getLeft());
			cadena += recorridoPostOrderRecursivo(raiz2.getRight());
			cadena += raiz2.getInfo().toString() + "\t";
		}
		return cadena;
	}

	/**
	 * Devuelve el recorrido inOrden: izquierda, raíz, derecha
	 * 
	 * @return cadena
	 */
	public String inOrder() {
		String cadena = recorridoInOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	/**
	 * Método privado recursivo para el recorrido inOrden
	 * 
	 * @param raiz2
	 * @return cadena
	 */
	private String recorridoInOrderRecursivo(BSTNode<T> raiz2) {
		String cadena = "";
		if (raiz2 != null) {
			cadena += recorridoInOrderRecursivo(raiz2.getLeft());
			cadena += raiz2.getInfo().toString() + "\t";
			cadena += recorridoInOrderRecursivo(raiz2.getRight());
		}
		return cadena;
	}

	/**
	 * Borra una clave del árbol. Devuelve 0 si la borra Devuelve -2 si la clave que
	 * intento borrar es null o el árbol estí vacío. Devuelve -1 si intenta borrar
	 * una clave que no existe.
	 * 
	 * @param clave
	 * @return int
	 */
	public int removeNode(T clave) {
		if (clave == null || this.raiz == null) {
			return -2;
		} else if (searchNode(clave) == null) {
			return -1;
		} else {
			this.raiz = removeNodeRecursivo(this.raiz, clave);
			return 0;
		}

	}

	/**
	 * Método privado recursivo para el removeNode
	 * 
	 * @param raiz
	 * @param clave
	 * @return node
	 */
	private BSTNode<T> removeNodeRecursivo(BSTNode<T> raiz, T clave) {
		if (raiz.getInfo().compareTo(clave) > 0) {
			BSTNode<T> nodo = removeNodeRecursivo(raiz.getLeft(), clave);
			raiz.setLeft(nodo);
			return raiz;
		} else if (raiz.getInfo().compareTo(clave) < 0) {
			BSTNode<T> nodo = removeNodeRecursivo(raiz.getRight(), clave);
			raiz.setRight(nodo);
			return raiz;
		} else {// encontrado
				// no tiene hijos
			if (raiz.getLeft() == null && raiz.getRight() == null) {
				return null;
			}
			// tiene un hijo
			if (raiz.getLeft() != null && raiz.getRight() == null) {// hijo izq
				return raiz.getLeft();
			} else if (raiz.getLeft() == null && raiz.getRight() != null) {// hijo derecho
				return raiz.getRight();
			}
			// tiene dos hijos
			else {
				BSTNode<T> nodemax = searchMaxClave(raiz.getLeft());
				raiz.setLeft(removeNodeRecursivo(raiz.getLeft(), nodemax.getInfo()));
				raiz.setInfo(nodemax.getInfo());
				return raiz;
			}
		}
	}

	/**
	 * Método privado recursivo para el removeNode que busca el hijo mayor
	 * 
	 * @param raiz2
	 * @return node
	 */
	private BSTNode<T> searchMaxClave(BSTNode<T> raiz2) {
		if (raiz2.getRight() != null) {
			return searchMaxClave(raiz2.getRight());
		} else {
			return raiz2;
		}
	}
}
