/**
 * 
 */
package ColasPrioridad;

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 *
 */
public class BinaryHeapMin<T extends Comparable<T>> implements PriorityQueue<T> {

	private T[] monticulo;// vector montículo
	private int numElementos;// número de elementos

	@SuppressWarnings("unchecked")
	/**
	 * Constructor para la clase BinaryHeapMin que crea un vector de n componentes y
	 * establece el número de elementos a 0
	 * 
	 * @param n
	 */
	public BinaryHeapMin(int n) {
		setMonticulo((T[]) new Comparable[n]);
		setNumElementos(0);
	}

	@Override
	/**
	 * Condiciones: si el parámetro pasado es null devuelve -2. Si el vector está
	 * lleno devuelve -1. Sino aumenta el número de
	 * elementos, lo añade al final, hace un filtrado ascendente y devuelve 0.
	 * 
	 * @return int
	 */
	public int add(T elemento) {
		if (elemento == null) {
			return -2;
		} else if (this.numElementos == this.monticulo.length) {
			return -1;
		} else {
			this.numElementos++;
			this.monticulo[this.numElementos - 1] = elemento;
			filtradoAscendente(numElementos - 1);
			return 0;
		}

	}

	@Override
	/**
	 * Método que devuelve el elemento de la posición 0 del montículo y lo saca.
	 * Condiciones: si el montículo está vacío, devuelve null. Sino asigna en la
	 * posición 0 el último elemento del montículo, realiza un filtro descendente y
	 * devuelve el elemento sacado.
	 * 
	 * @return elemento
	 */
	public T poll() {
		if (getMonticulo()[0] == null) {
			return null;
		} else {
			T elem0 = this.monticulo[0];
			this.monticulo[0] = this.monticulo[this.numElementos - 1];
			this.monticulo[this.numElementos - 1] = null;
			this.numElementos--;
			filtradoDescendente(0);
			return elem0;
		}
	}

	@Override
	/**
	 * Condiciones: si el parámetro pasado es null o el montículo está vacío
	 * devuelve -2. Si no existe el elemento en el montículo devuelve -1. Sino lo
	 * elimina, disminuye el número de elementos, realiza un filtro descendente y
	 * devuelve 0.
	 * 
	 * @return int
	 */
	public int remove(T elemento) {
		if (elemento == null || isEmpty()) {
			return -2;
		} else if (!existsElemento(elemento)) {
			return -1;
		} else {
			int posicion = getPosElemento(elemento);
			this.monticulo[posicion] = this.monticulo[numElementos - 1];
			this.monticulo[numElementos - 1] = null;
			this.numElementos--;
			filtradoDescendente(posicion);
			return 0;
		}
	}

	/**
	 * Método privado que devuelve la posición de un elemento del montículo.
	 * 
	 * @param elemento
	 * @return int
	 */
	private int getPosElemento(T elemento) {
		for (int i = 0; i < numElementos; i++) {
			if (this.monticulo[i].equals(elemento)) {
				return i;
			}
		}
		return 0;

	}

	/**
	 * Método privado que indica si existe o no un elemento en el montículo
	 * 
	 * @param elemento
	 * @return boolean
	 */
	private boolean existsElemento(T elemento) {
		for (int i = 0; i < numElementos; i++) {
			if (this.monticulo[i].equals(elemento)) {
				return true;
			}
		}
		return false;
	}

	@Override
	/**
	 * Método que indica si el montículo está o no vacío.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.numElementos == 0 ? true : false;
	}

	@Override
	/**
	 * Método que vacía el montículo y establece el número de elementos a 0.
	 */
	public void clear() {
		for (int i = 0; i < numElementos; i++) {
			this.monticulo[i] = null;
		}
		this.numElementos = 0;

	}

	@Override
	/**
	 * ToString de la clase BinaryHeapMin
	 * 
	 * @return cadena
	 */
	public String toString() {
		String cadena = "";
		if (!isEmpty()) {
			for (int i = 0; i < numElementos - 1; i++) {
				cadena += this.monticulo[i] + "\t";
			}
			cadena += this.monticulo[numElementos - 1];
		}
		return cadena;
	}

	@Override
	/**
	 * Método que busca el elemento pasado como parámetro, lo compara con el de la
	 * posición pasada y en función de si es mayor o menor realiza un filtro
	 * descendente o ascendente respectivamente. Condiciones: si el montículo está
	 * vacío devuelve -1. Si la posición no es válida devuelve -2. Sino sustituye el
	 * elemento que había en la posición por el nuevo, realiza un filtro ascendente
	 * o descendente en función de si es menor o mayor que el elemento recién
	 * cambiado y devuelve 0.
	 */
	public int cambiarPrioridad(int pos, T elemento) {
		// -2 si la pos es negativa o fuera del vector o el elemento es null
		// -1 si la cola está vacía
		// 0 si se inserta correctamente
		if (isEmpty()) {
			return -1;
		} else if (pos < 0 || pos >= numElementos) {
			return -2;
		} else {
			T original = this.monticulo[pos];
			this.monticulo[pos] = elemento;
			if (elemento.compareTo(original) > 0) {
				filtradoDescendente(pos);
			} else if (elemento.compareTo(original) < 0) {
				filtradoAscendente(pos);
			}
			return 0;
		}
	}

	/**
	 * Getter que devuelve el montículo
	 * 
	 * @return monticulo
	 */
	public T[] getMonticulo() {
		return monticulo;
	}

	/**
	 * Setter para el montículo
	 * 
	 * @param monticulo
	 */
	private void setMonticulo(T[] monticulo) {
		this.monticulo = monticulo;
	}

	/**
	 * Método que devuelve el número de elementos
	 * 
	 * @return int
	 */
	public int getNumElementos() {
		return numElementos;
	}

	private void setNumElementos(int numElementos) {
		this.numElementos = numElementos;
	}

	/**
	 * Método privado recursivo que realiza un filtro ascendente al montículo desde
	 * una posición pasada como parámetro.
	 * 
	 * @param pos
	 */
	private void filtradoAscendente(int pos) {
		while (pos != 0) {
			int posicionPadre = Math.abs((pos - 1) / 2);
			int posicionHijo = pos;
			T padre = this.monticulo[posicionPadre];
			T hijo = this.monticulo[posicionHijo];
			if (padre.compareTo(hijo) > 0) {
				this.monticulo[posicionPadre] = hijo;
				this.monticulo[posicionHijo] = padre;
				filtradoAscendente(posicionPadre);
			}
			break;
		}

	}

	/**
	 * Método privado recursivo que realiza un filtrado descendente al montículo
	 * desde una posición pasada como parámetro.
	 * 
	 * @param pos
	 */
	private void filtradoDescendente(int pos) {
		int posHijoIzq = Math.abs(2 * pos + 1);
		int posHijoDcho = Math.abs(2 * pos + 2);
		int posiciones = posicionesValidas(posHijoIzq, posHijoDcho);
		while (posiciones != -1) {
			int posPadre = pos;
			T padre = this.monticulo[posPadre];
			T hijoIzq = this.monticulo[posHijoIzq];
			T hijoDcho = this.monticulo[posHijoDcho];

			if (posiciones == 0 && hijoIzq != null && hijoDcho != null) {
				if (hijoIzq.compareTo(hijoDcho) < 0) {
					if (padre.compareTo(hijoIzq) > 0) {
						this.monticulo[posPadre] = hijoIzq;
						this.monticulo[posHijoIzq] = padre;
						filtradoDescendente(posHijoIzq);
					}
				} else if (hijoDcho.compareTo(hijoIzq) < 0) {
					if (padre.compareTo(hijoDcho) > 0) {
						this.monticulo[posPadre] = hijoDcho;
						this.monticulo[posHijoDcho] = padre;
						filtradoDescendente(posHijoDcho);
					}
					break;
				}
			} else if (posiciones == 1 && hijoIzq != null) {
				if (padre.compareTo(hijoIzq) > 0) {
					this.monticulo[posPadre] = hijoIzq;
					this.monticulo[posHijoIzq] = padre;
					filtradoDescendente(posHijoIzq);
				}
			}
			break;
		}
	}

	// si las dos son válidas devuelve 0
	// solo la izq válida
	// ninguna válida

	/**
	 * Método privado que devuelve un entero para saber si las posiciones son
	 * válidas. Condiciones: si las dos lo son devuelve 0. Si sólo es válida la de
	 * la izq devuelve 1. Sino devuelve -1.
	 * 
	 * @param posHijoIzq
	 * @param posHijoDcho
	 * @return int
	 */
	private int posicionesValidas(int posHijoIzq, int posHijoDcho) {
		if (posHijoIzq < numElementos && posHijoDcho < numElementos) {
			return 0;
		} else if (posHijoIzq < numElementos && posHijoDcho >= numElementos) {
			return 1;
		} else {
			return -1;
		}
	}

}
