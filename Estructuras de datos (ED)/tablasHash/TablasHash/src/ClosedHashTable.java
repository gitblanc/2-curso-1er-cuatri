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

	private int numElementos;
	private HashNode<T> tabla[];
	private int tipoExploracion;
	private double minlf;
	private double maxlf;

	/**
	 * 
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

	@Override
	public int getNumOfElems() {
		return this.numElementos;
	}

	@Override
	public int getSize() {
		return this.tabla.length;
	}

	@Override
	public int add(T elemento) {
		// Buscar la posición en la que iría elemento
		if (elemento == null) {
			return -2;
		} else {
			int pos = fHash(elemento);
			int intento = 1;
			while (tabla[pos].getStatus() == HashNode.LLENO && intento < getSize()) {// mientras esté llena y sea menor
																						// que el tamaño de la
				// tabla
				if (tipoExploracion == 1) {
					pos = (fHash(elemento) + intento) % getSize();
				} else if (tipoExploracion == 2) {
					pos = (fHash(elemento) + (intento * intento)) % getSize();
				}
				intento++;
			}
			if (pos == getSize()) {
				return -1;
			}
			tabla[pos].setInfo(elemento);
			this.numElementos++;
			if (calculateFactorCarga() >= MAXIM_LF) {
				redispersion();
			}
			return 0;

		}
	}

	@SuppressWarnings("unchecked")
	private void redispersion() {
		HashNode<T>[] aux = this.tabla;
		int tam = this.tabla.length * 2;
		if (!isPositivePrime(tam)) {
			tam = nextPrimeNumber(tam);
		}
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		this.numElementos = 0;
		for (int i = 0; i < this.tabla.length; i++) {
			tabla[i] = new HashNode<T>();
		}
		for (int k = 0; k < aux.length; k++) {
			if (aux[k].getStatus() == HashNode.LLENO) {
				add(aux[k].getInfo());
			}
		}

	}

	@SuppressWarnings("unchecked")
	private void redispersionInversa() {
		HashNode<T>[] aux = this.tabla;
		int tam = this.tabla.length / 2;
		if (!isPositivePrime(tam)) {
			tam = nextPrimeNumber(tam);
		}
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		this.numElementos = 0;
		for (int i = 0; i < this.tabla.length; i++) {
			tabla[i] = new HashNode<T>();
		}
		for (int k = 0; k < aux.length; k++) {
			if (aux[k].getStatus() == HashNode.LLENO) {
				add(aux[k].getInfo());
			}
		}

	}

	private float calculateFactorCarga() {
		return numElementos / (float) (getSize());
	}

	@Override
	public T find(T elemento) {
		/**
		 * posicion llena y coincide lo devuelves posicion llena y no coincide sigue
		 * buscando posicion borrada y coincide devuelve null posicion borrada y no
		 * coincide sigues buscando posicion vacía return null
		 */
		if (elemento == null) {
			return null;
		} else {
			int pos = fHash(elemento);
			int intento = 0;
			while (pos < getSize() && intento < getSize()) {// mientras esté llena y sea menor que el tamaño de la
				if (tabla[pos].getStatus() == HashNode.LLENO) { // tabla
					if (tabla[pos].getInfo().equals(elemento)) {
						return elemento;
					}
				} else if (tabla[pos].getStatus() == HashNode.BORRADO) {
					if (tabla[pos].getInfo().equals(elemento)) {
						return null;
					}
				}
				if (tipoExploracion == 1) {
					pos = (fHash(elemento) + intento) % getSize();
				} else if (tipoExploracion == 2) {
					pos = (fHash(elemento) + (intento * intento)) % getSize();
				}
				intento++;
			}
			return null;

		}
	}

	@Override
	public int remove(T elemento) {
		/**
		 * si posicion esta llena y coincide lo borras (remove hashnode) devuelve 0 si
		 * está llena pero no coincide sigues buscando si el estado es borrado y está el
		 * elemento devuelve -1 si está borrado y no coincide sigues buscando si está
		 * vacío devuelve -1
		 */
		if (elemento == null) {
			return -2;
		} else if (find(elemento) == null) {
			return -1;
		} else {
			int pos = fHash(elemento);
			int intento = 1;
			while (intento < getSize()) {// mientras esté llena y sea menor que el tamaño de la
				if (tabla[pos].getStatus() == HashNode.LLENO) { // tabla
					if (tabla[pos].getInfo().equals(elemento)) {
						tabla[pos].remove();
						this.numElementos--;
						if (calculateFactorCarga() <= MIN_LF) {
							redispersionInversa();
						}
						return 0;
					}
				} else if (tabla[pos].getStatus() == HashNode.BORRADO) {
					if (tabla[pos].getInfo().equals(elemento)) {
						return -1;
					}
				}
				if (tipoExploracion == 1) {
					pos = (fHash(elemento) + intento) % getSize();
				} else if (tipoExploracion == 2) {
					pos = (fHash(elemento) + (intento * intento)) % getSize();
				}
				intento++;
			}
			return -1;

		}
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		for (int i = 0; i < getSize(); i++) {
			cadena.append(tabla[i].toString());
			cadena.append(";");
		}
		cadena.append("[Size: ");
		cadena.append(getSize());
		cadena.append(" Num.Elems.: ");
		cadena.append(getNumOfElems());
		cadena.append("]");
		return cadena.toString();
	}

	public double getMaxlf() {
		return maxlf;
	}

	public double getMinlf() {
		return minlf;
	}

}
