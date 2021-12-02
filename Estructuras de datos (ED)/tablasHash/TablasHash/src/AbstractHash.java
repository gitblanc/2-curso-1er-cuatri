/**
 * 
 */

/**
 * @author blanc
 *
 */
public abstract class AbstractHash<T> {

	abstract public int getNumOfElems();

	abstract public int getSize();

	abstract public int add(T elemento);

	abstract public T find(T elemento);

	abstract public int remove(T elemento);

	abstract public String toString();

	protected int fHash(T elemento) {
		int pos = elemento.hashCode() % getSize();
		if (pos < 0)// si es negativa
			return pos + getSize();// le sumo el tamaño de la tabla
		else
			return pos;
	}

	// averigua si un número es primo o no
	// suponemos que el numero es positivo
	protected boolean isPositivePrime(int numero) {
		// desde el dos hasta la mitad del número

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}
		return true;

	}

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
