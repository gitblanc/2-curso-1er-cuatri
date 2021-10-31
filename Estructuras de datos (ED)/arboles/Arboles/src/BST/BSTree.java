/**
 * 
 */
package BST;

/**
 * @author UO285176
 *
 */
public class BSTree<T extends Comparable<T>> {
	private BSTNode<T> raiz;// nodo ra�z del �rbol

	/**
	 * Constructor default para la clase BSTree
	 */
	public BSTree() {
		this.raiz = null;
	}
	
	public BSTNode<T> getRaiz(){
		return this.raiz;
	}

	/**
	 * Si no se encuentra devolver� null
	 * 
	 * @param clave
	 * @return
	 */
	public BSTNode<T> searchNode(T clave) {
		if (clave == null || this.raiz == null) {
			return null;
		}
		return searchNodeRecursivo(raiz, clave);
	}

	private BSTNode<T> searchNodeRecursivo(BSTNode<T> raiz2, T clave) {
		if (raiz2 == null) {
			return null;
		}
		// COMPARE TO devuelve > 0 si obj1 > obj2
		// devuelve < 0 si obj1 < obj2
		// devuelve = 0 si obj1 = obj2
		else if (raiz2.getInfo().compareTo(clave) > 0) {// si la clave es menor que el nodo busca por la izquierda
			return searchNodeRecursivo(raiz.getLeft(), clave);
		} else if (raiz2.getInfo().compareTo(clave) < 0) {// si la clave es mayor que el nodo busca por la derecha
			return searchNodeRecursivo(raiz.getRight(), clave);
		} else if (raiz2.getInfo().compareTo(clave) == 0) {// si la clave es igual que el nodo lo devuelve
			return raiz2;
		} else {// si no lo encuentra devuelve null
			return null;
		}

	}

	/**
	 * Devuelve 0 si a�ade correctamente el elemento al �rbol. Devuelve -2 si la
	 * clave es null. Devuelve -1 si intenta insertar una clave ya existente.
	 * 
	 * @param clave
	 * @return
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
		}else {
			return -1;
		}

	}

	/**
	 * 
	 * @return
	 */
	public String preOrder() {
		String cadena = recorridoPreOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	private String recorridoPreOrderRecursivo(BSTNode<T> raiz2) {
		if(raiz2 == null) {
			return "";
		}else {
			String cadena = raiz2.getInfo().toString();
			cadena += "\t";
			cadena += recorridoPreOrderRecursivo(raiz2.getLeft());
			cadena += recorridoPreOrderRecursivo(raiz2.getRight());
			return cadena;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String postOrder() {
		String cadena = recorridoPostOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	private String recorridoPostOrderRecursivo(BSTNode<T> raiz2) {
		String cadena = "";
		if(raiz2 != null) {
			cadena += recorridoPostOrderRecursivo(raiz2.getLeft());
			cadena += recorridoPostOrderRecursivo(raiz2.getRight());
			cadena += raiz2.getInfo().toString() + "\t";
		}
		return cadena;
	}

	/**
	 * 
	 * @return
	 */
	public String inOrder() {
		String cadena = recorridoInOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	private String recorridoInOrderRecursivo(BSTNode<T> raiz2) {
		String cadena = "";
		if(raiz2 != null) {
			cadena += recorridoInOrderRecursivo(raiz2.getLeft());
			cadena += raiz2.getInfo().toString() + "\t";
			cadena += recorridoInOrderRecursivo(raiz2.getRight());
		}
		return cadena;
	}

	/**
	 * Borra una clave del �rbol. Devuelve 0 si la borra Devuelve -2 si la clave que
	 * intento borrar es null o el �rbol est� vac�o. Devuelve -1 si intenta borrar
	 * una clave que no existe.
	 * 
	 * @param clave
	 * @return
	 */
//	public int removeNode(T clave);
}
