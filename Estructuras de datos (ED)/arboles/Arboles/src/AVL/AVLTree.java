package AVL;

/**
 * 
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 */
public class AVLTree<T extends Comparable<T>> {
	private AVLNode<T> raiz;// raiz

	/**
	 * Constructor por defecto de un �rbol AVL
	 */
	public AVLTree() {
		this.raiz = null;
	}

	/**
	 * Condiciones: si el par�metro pasado es null o la ra�z es null devuelve null,
	 * sino devuelve el nodo buscado(llamando al m�todo recursivo).
	 * 
	 * @param clave
	 * @return node
	 */
	public AVLNode<T> searchNode(T clave) {
		if (clave == null || this.raiz == null) {
			return null;
		}
		return searchNodeRecursivo(raiz, clave);
	}

	/**
	 * M�todo privado recursivo que busca el nodo pasado como par�metro
	 * 
	 * @param raiz2
	 * @param clave
	 * @return node
	 */
	private AVLNode<T> searchNodeRecursivo(AVLNode<T> raiz2, T clave) {
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
	 * Condiciones: si la clave es null devuelve -2. Si la ra�z es null devuelve 0.
	 * Si lo encuentra en el �rbol devuelve -1. Si lo puede a�adir llama al m�todo
	 * recursivo y devuelve 0;
	 * 
	 * @param clave
	 * @return int
	 */
	public int addNode(T clave) {
		if (clave == null) {
			return -2;
		} else if (this.raiz == null) {
			this.raiz = new AVLNode<T>(clave);
			return 0;
		} else if (searchNode(clave) != null) {
			return -1;
		} else {
			AVLNode<T> newNode = addNodeRecursivo(this.raiz, clave);

			this.raiz = newNode;
			return 0;
		}
	}

	/**
	 * M�todo privado recursivo que a�ade un nodo al �rbol
	 * 
	 * @param raiz2
	 * @param clave
	 * @return nodo
	 */
	private AVLNode<T> addNodeRecursivo(AVLNode<T> raiz2, T clave) {
		// CompareTo:
		// Si da 1, el de la izq es m�s grande que el parametro
		// Si da negativo, el de la izq es menor que el parametro
		// Si da 0 son iguales
		if (raiz2.getInfo().compareTo(clave) > 0) {
			if (raiz2.getLeft() != null) {
				raiz2.setLeft(addNodeRecursivo(raiz2.getLeft(), clave));
				return updateAndBalanceIfNecesary(raiz2);
			} else {
				raiz2.setLeft(new AVLNode<T>(clave));
				return updateAndBalanceIfNecesary(raiz2);
			}
		} else if (raiz2.getInfo().compareTo(clave) < 0) {
			if (raiz2.getRight() != null) {
				raiz2.setRight(addNodeRecursivo(raiz2.getRight(), clave));
				return updateAndBalanceIfNecesary(raiz2);
			} else {
				raiz2.setRight(new AVLNode<T>(clave));
				return updateAndBalanceIfNecesary(raiz2);
			}
		} else {
			return null;
		}
	}

	/**
	 * M�todo privado que llama a una serie de m�todos privados que realizan las
	 * rotaciones del �rbol para su correcta organizaci�n.
	 * 
	 * @param nodo
	 * @return node
	 */
	private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> nodo) {
		nodo.updateBFHeight();
		if (nodo.getBF() == -2)
			if (nodo.getLeft().getBF() == 1)
				nodo = doubleLeftRotation(nodo);
			else // -1 o cero
				nodo = singleLeftRotation(nodo);
		else if (nodo.getBF() == 2)
			if (nodo.getRight().getBF() == -1)
				nodo = doubleRightRotation(nodo);
			else // 1 o cero
				nodo = singleRightRotation(nodo);
		return nodo;
	}

	/**
	 * M�todo privado que realiza una rotaci�n simple a la derecha
	 * 
	 * @param nodo
	 * @return node
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getRight();
		nodo.setRight(aux.getLeft());
		nodo.updateBFHeight();
		aux.setLeft(nodo);
		aux.updateBFHeight();
		return aux;
	}

	/**
	 * M�todo privado que realiza una rotaci�n doble a la derecha
	 * 
	 * @param nodo
	 * @return node
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		nodo.setRight(singleLeftRotation(nodo.getRight()));
		return singleRightRotation(nodo);
	}

	/**
	 * M�todo privado que realiza una rotaci�n simple a la izquierda
	 * 
	 * @param nodo
	 * @return node
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getLeft();
		nodo.setLeft(aux.getRight());
		nodo.updateBFHeight();
		aux.setRight(nodo);
		aux.updateBFHeight();
		return aux;
	}

	/**
	 * M�todo privado que realiza una rotacion doble a la izquierda
	 * 
	 * @param nodo
	 * @return node
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		nodo.setLeft(singleRightRotation(nodo.getLeft()));
		return singleLeftRotation(nodo);
	}

	/**
	 * Decuelve el recorrido preOrden: ra�z, izquierda, derecha
	 * 
	 * @return cadena
	 */
	public String preOrder() {
		String cadena = recorridoPreOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	/**
	 * M�todo privado recursivo para el preOrden
	 * 
	 * @param raiz2
	 * @return cadena
	 */
	private String recorridoPreOrderRecursivo(AVLNode<T> raiz2) {
		if (raiz2 == null) {
			return "";
		} else {
			String cadena = raiz2.toString();
			cadena += "\t";
			cadena += recorridoPreOrderRecursivo(raiz2.getLeft());
			cadena += recorridoPreOrderRecursivo(raiz2.getRight());
			return cadena;
		}
	}

	/**
	 * Devuelve el recorrido postOrden: izquierda, derecha, ra�z
	 * 
	 * @return cadena
	 */
	public String postOrder() {
		String cadena = recorridoPostOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	/**
	 * M�todo privado recursivo para el recorrido postOrden
	 * 
	 * @param raiz2
	 * @return cadena
	 */
	private String recorridoPostOrderRecursivo(AVLNode<T> raiz2) {
		String cadena = "";
		if (raiz2 != null) {
			cadena += recorridoPostOrderRecursivo(raiz2.getLeft());
			cadena += recorridoPostOrderRecursivo(raiz2.getRight());
			cadena += raiz2.toString() + "\t";
		}
		return cadena;
	}

	/**
	 * Devuelve el recorrido inOrden: izquierda, ra�z, derecha
	 * 
	 * @return cadena
	 */
	public String inOrder() {
		String cadena = recorridoInOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	/**
	 * M�todo privado recursivo para el recorrido inOrden
	 * 
	 * @param raiz2
	 * @return cadena
	 */
	private String recorridoInOrderRecursivo(AVLNode<T> raiz2) {
		String cadena = "";
		if (raiz2 != null) {
			cadena += recorridoInOrderRecursivo(raiz2.getLeft());
			cadena += raiz2.toString() + "\t";
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
	 * M�todo privado recursivo para el removeNode
	 * 
	 * @param raiz
	 * @param clave
	 * @return node
	 */
	private AVLNode<T> removeNodeRecursivo(AVLNode<T> raiz, T clave) {
		if (raiz.getInfo().compareTo(clave) > 0) {
			AVLNode<T> nodo = removeNodeRecursivo(raiz.getLeft(), clave);
			raiz.setLeft(nodo);
			return updateAndBalanceIfNecesary(raiz);
		} else if (raiz.getInfo().compareTo(clave) < 0) {
			AVLNode<T> nodo = removeNodeRecursivo(raiz.getRight(), clave);
			raiz.setRight(nodo);
			return updateAndBalanceIfNecesary(raiz);
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
				AVLNode<T> nodemax = searchMaxClave(raiz.getLeft());
				raiz.setLeft(removeNodeRecursivo(raiz.getLeft(), nodemax.getInfo()));
				raiz.setInfo(nodemax.getInfo());
				return updateAndBalanceIfNecesary(raiz);
			}
		}
	}

	/**
	 * M�todo privado recursivo para el removeNode que busca el hijo mayor
	 * 
	 * @param raiz2
	 * @return node
	 */
	private AVLNode<T> searchMaxClave(AVLNode<T> raiz2) {
		if (raiz2.getRight() != null) {
			return searchMaxClave(raiz2.getRight());
		} else {
			return raiz2;
		}
	}

	// M�TODOS EXTRA

	/**
	 * M�todo p�blico que calcula el padre de un nodo. Condiciones: devuelve null si
	 * el par�metro pasado es nulo. Sino devuelve al padre.
	 * 
	 * @param clave
	 * @return nodo
	 */
	public AVLNode<T> padreDe(T clave) {
		if (clave == null) {
			return null;
		} else {
			return padreDerecursivo(this.raiz, clave);
		}
	}

	/**
	 * M�todo privado recursivo para la obtenci�n del padre de un nodo.
	 * 
	 * @param raiz
	 * @param clave
	 * @return node
	 */
	private AVLNode<T> padreDerecursivo(AVLNode<T> raiz, T clave) {
		// CompareTo:
		// Si da 1, el de la izq es m�s grande que el parametro
		// Si da negativo, el de la izq es menor que el parametro
		// Si da 0 son iguales
		if (raiz.getInfo().compareTo(clave) > 0) {// si raiz es mayor que clave
			if (raiz.getLeft() != null && raiz.getLeft().getInfo().equals(clave)) {
				return raiz;
			} else {
				return padreDerecursivo(raiz.getLeft(), clave);
			}
		} else if (raiz.getInfo().compareTo(clave) < 0) {
			if (raiz.getRight() != null && raiz.getRight().getInfo().equals(clave)) {
				return raiz;
			} else {
				return padreDerecursivo(raiz.getRight(), clave);
			}
		} else {
			return null;
		}
	}

	/**
	 * M�todo que cuenta el n�mero de aristas desde un nodo inicial hasta un nodo
	 * final. Condiciones: si el nodo inicio o el nodo destino o la raiz son nulos o
	 * los nodos son el mismo devuelve 0. Sino devuelve su distancia.
	 * 
	 * @param clave1
	 * @param clave2
	 * @return int
	 */
	public int numAristas(T clave1, T clave2) {
		AVLNode<T> inicio = searchNode(clave1);
		AVLNode<T> fin = searchNode(clave2);
		if (clave1 == null || clave2 == null || this.raiz == null || clave1.equals(clave2) || inicio == null
				|| fin == null) {
			return 0;
		} else {
			return cuentaAltura(inicio, fin);
		}
	}

	/**
	 * M�todo privado recursivo que determina la distancia entre dos nodos,
	 * 
	 * @return int
	 */
	private int cuentaAltura(AVLNode<T> inicio, AVLNode<T> fin) {
		if (inicio.getInfo().compareTo(fin.getInfo()) > 0) {
			return cuentaAltura(inicio.getLeft(), fin) + 1;
		} else if (inicio.getInfo().compareTo(fin.getInfo()) < 0) {
			return cuentaAltura(inicio.getRight(), fin) + 1;
		} else {
			return 0;
		}
	}

}
