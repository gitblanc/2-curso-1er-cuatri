import java.lang.reflect.Array;

/**
 * 
 */

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 * @param <T>
 *
 */
public class ClosedHashTable<T> extends AbstractHash<T> {

	private static final double MIN_LF = 0.16;
	private static final double MAXIM_LF = 0.5;

	private int numElementos;// n�mero de elementos insertados hasta el momento
	private HashNode<T> tabla[];// tabla hash
	private int tipoExploracion;// tipo(1Lineal, 2Cuadr�tica, 3Dispersi�n doble)
	private double minlf;// factor de carga m�nimo
	private double maxlf;// factor de carga m�ximo

	/**
	 * Constructor con dos par�metros para el tama�o y el tipo de exploraci�n. Pone
	 * el n�mero de elementos a 0, el tipo de exploraci�n al pasado como par�metro,
	 * un tama�o primo, crea una tabla vac�a con ese tama�o y establece los l�mites
	 * m�ximo y m�nimo.
	 * 
	 * @param tam
	 * @param tipo
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, int tipo) {
		this.numElementos = 0;
		this.tipoExploracion = tipo;
		if (!isPositivePrime(tam)) {
			tam = nextPrimeNumber(tam);
		}
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		for (int i = 0; i < tam; i++) {
			tabla[i] = new HashNode<T>();
		}
		this.minlf = MIN_LF;
		this.maxlf = MAXIM_LF;
	}

	/**
	 * Constructor con cuatro par�metros para el tama�o, el tipo de exploraci�n, el
	 * m�ximo y el m�nimo. Pone el n�mero de elementos a 0, el tipo de exploraci�n
	 * al pasado como par�metro, un tama�o primo, crea una tabla vac�a con ese
	 * tama�o y establece los l�mites m�ximo y m�nimo con los par�metros m�ximo y
	 * m�nimo.
	 * 
	 * @param tam
	 * @param tipo
	 * @param min
	 * @param max
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, int tipo, double min, double max) {
		this.numElementos = 0;
		this.tipoExploracion = tipo;
		if (!isPositivePrime(tam)) {
			tam = nextPrimeNumber(tam);
		}
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		for (int i = 0; i < tam; i++) {
			tabla[i] = new HashNode<T>();
		}
		this.minlf = min;
		this.maxlf = max;
	}

	/**
	 * Getter para el n�mero de elementos
	 * 
	 * @return numElementos
	 */
	@Override
	public int getNumOfElems() {
		return this.numElementos;
	}

	/**
	 * M�todo que devuelve de la longitud de la tabla hash.
	 * 
	 * @return int
	 */
	@Override
	public int getSize() {
		return this.tabla.length;
	}

	/**
	 * M�todo que a�ade un elemento a la tabla hash. Si es null, devuelve -2. Si no
	 * cabe, devuelve -1. Si lo inserta corectamente devuelve 0.
	 * 
	 * @return int
	 */
	@Override
	public int add(T elemento) {
		// Buscar la posici�n en la que ir�a elemento
		if (elemento == null) {
			return -2;
		}
		if (find(elemento) != null) {
			return -1;
		} else {
			int pos = fHash(elemento);
			int intento = 1;
			while (tabla[pos].getStatus() == HashNode.LLENO && intento < getSize()) {// mientras est� llena y sea menor
																						// que el tama�o de la
				// tabla
				if (this.tipoExploracion == 1) {
					pos = (fHash(elemento) + intento) % getSize();
				} else if (this.tipoExploracion == 2) {
					pos = (fHash(elemento) + (intento * intento)) % getSize();
				}
				intento++;
			}
			if (pos == getSize()) {
				return -1;
			}
			this.tabla[pos].setInfo(elemento);
			this.numElementos++;
			if (calculateFactorCarga() >= MAXIM_LF) {
				redispersion();
			}
			return 0;

		}
	}

	/**
	 * M�todo que hace la redispersi�n de la tabla(multiplica su tama�o por 2 y
	 * reordena los elementos)
	 */
	@SuppressWarnings("unchecked")
	private void redispersion() {
		HashNode<T>[] aux = this.tabla;
		int tam = getSize() * 2;
		if (!isPositivePrime(tam)) {
			tam = nextPrimeNumber(tam);
		}
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		this.numElementos = 0;
		for (int i = 0; i < getSize(); i++) {
			this.tabla[i] = new HashNode<T>();
		}
		for (int k = 0; k < aux.length; k++) {
			if (aux[k].getStatus() == HashNode.LLENO) {
				add(aux[k].getInfo());
			}
		}

	}

	/**
	 * M�todo que hace la redispersi�n inversa de la tabla(reduce su tama�o en 2 y
	 * reordena los elementos)
	 */
	@SuppressWarnings("unchecked")
	private void redispersionInversa() {
		HashNode<T>[] aux = this.tabla;
		int tam = getSize() / 2;
		if (!isPositivePrime(tam)) {
			tam = previousPrimeNumber(tam);// calcula el primo anterior
		}
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		this.numElementos = 0;
		for (int i = 0; i < getSize(); i++) {
			tabla[i] = new HashNode<T>();
		}
		for (int k = 0; k < aux.length; k++) {
			if (aux[k].getStatus() == HashNode.LLENO) {
				add(aux[k].getInfo());
			}
		}

	}

	/**
	 * M�todo que calcula el factor de carga
	 * 
	 * @return float
	 */
	private float calculateFactorCarga() {
		return this.numElementos / (float) (getSize());
	}

	/**
	 * M�todo que busca un elemento en la tabla y lo devuelve. Si no lo encuentra
	 * devuelve null.
	 * 
	 * @return T element
	 */
	@Override
	public T find(T elemento) {
		if (elemento == null) {
			return null;
		} else {
			int pos = fHash(elemento);
			int intento = 0;
			while (pos < getSize() && intento < getSize()) {// mientras est� llena y sea menor que el tama�o de la
				if (this.tabla[pos].getStatus() == HashNode.LLENO) { // tabla
					if (this.tabla[pos].getInfo().equals(elemento)) {
						return elemento;
					}
				} else if (this.tabla[pos].getStatus() == HashNode.BORRADO) {
					if (this.tabla[pos].getInfo().equals(elemento)) {
						return null;
					}
				}
				if (this.tipoExploracion == 1) {
					pos = (fHash(elemento) + intento) % getSize();
				} else if (this.tipoExploracion == 2) {
					pos = (fHash(elemento) + (intento * intento)) % getSize();
				}
				intento++;
			}
			return null;

		}
	}

	/**
	 * M�todo que elimina un elemento de la tabla hash. Si es null, devuelve -2. Si
	 * no lo encuentra devuelve -1. Sino pone su estado a BORRADO(borrado perezoso),
	 * no lo elimina y devuelve 0.
	 * 
	 * @return int
	 */
	@Override
	public int remove(T elemento) {
		if (elemento == null) {
			return -2;
		} else if (find(elemento) == null) {
			return -1;
		} else {
			int pos = fHash(elemento);
			int intento = 1;
			while (intento < getSize()) {// mientras est� llena y sea menor que el tama�o de la
				if (this.tabla[pos].getStatus() == HashNode.LLENO) { // tabla
					if (this.tabla[pos].getInfo().equals(elemento)) {
						this.tabla[pos].remove();
						this.numElementos--;
						if (calculateFactorCarga() <= MIN_LF) {
							redispersionInversa();
						}
						return 0;
					}
				} else if (this.tabla[pos].getStatus() == HashNode.BORRADO) {
					if (this.tabla[pos].getInfo().equals(elemento)) {
						return -1;
					}
				}
				if (this.tipoExploracion == 1) {
					pos = (fHash(elemento) + intento) % getSize();
				} else if (this.tipoExploracion == 2) {
					pos = (fHash(elemento) + (intento * intento)) % getSize();
				}
				intento++;
			}
			return -1;

		}
	}

	/**
	 * M�todo toString()
	 * 
	 * @return cadena
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		for (int i = 0; i < getSize(); i++) {
			cadena.append(this.tabla[i].toString());
			cadena.append(";");
		}
		cadena.append("[Size: ");
		cadena.append(getSize());
		cadena.append(" Num.Elems.: ");
		cadena.append(getNumOfElems());
		cadena.append("]");
		return cadena.toString();
	}

	/**
	 * Getter para el maxlf
	 * 
	 * @return maxlf
	 */
	public double getMaxlf() {
		return this.maxlf;
	}

	/**
	 * Getter para el minlf
	 * 
	 * @return minlf
	 */
	public double getMinlf() {
		return this.minlf;
	}

}
