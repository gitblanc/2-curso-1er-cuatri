/**
 * 
 */

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 *
 */
public abstract class AbstractHash<T> {

	abstract public int getNumOfElems();

	abstract public int getSize();

	abstract public int add(T elemento);

	abstract public T find(T elemento);

	abstract public int remove(T elemento);

	abstract public String toString();

	/**
	 * Método que devuelve el HashCode de un elemento
	 * 
	 * @param elemento
	 * @return int
	 */
	protected int fHash(T elemento) {
		int pos = elemento.hashCode() % getSize();
		if (pos < 0)// si es negativa
			return pos + getSize();// le sumo el tamaño de la tabla
		else
			return pos;
	}

	/**
	 * Método que averigua si un número es primo o no suponiendo que el número es
	 * positivo
	 * 
	 * @param numero
	 * @return boolean
	 */
	protected boolean isPositivePrime(int numero) {
		// desde el dos hasta la mitad del número

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}
		return true;

	}

	/**
	 * Método que busca el siguiente número primo al pasado como parámetro
	 * 
	 * @param numero
	 * @return int
	 */
	protected int nextPrimeNumber(int numero) {
		numero++;
		while (true) {
			if (isPositivePrime(numero)) {
				return numero;
			} else {
				numero++;
			}
		}
	}

	/**
	 * Método que busca el número primo mayor por debajo del número pasado como
	 * parámetro
	 * 
	 * @param numero
	 * @return int
	 */
	protected int previousPrimeNumber(int numero) {
		numero--;
		while (numero > 3) {
			if (isPositivePrime(numero)) {
				return numero;
			} else {
				numero--;
			}
		}
		return 3;
	}

}
