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

	private int numElementos;
	private HashNode<T> tabla[];
	private int tipoExploracion;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, int tipo) {
		this.numElementos = 0;
		this.tipoExploracion = tipo;
		if (!isPositivePrime(tipo)) {
			tam = nextPrimeNumber(tam);
		}
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		for (int i = 0; i < tam; i++) {
			tabla[i] = new HashNode<T>();
		}
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
					pos = fHash(elemento) + intento % getSize();
				} else if (tipoExploracion == 2) {
					pos = fHash(elemento) + (intento * intento) % getSize();
				}
				intento++;
			}
			if (pos == getSize()) {
				return -1;
			}
			tabla[pos].setInfo(elemento);
			this.numElementos++;
			return 0;

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
			int intento = 1;
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
				intento++;
				pos++;
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
						return 0;
					}
				} else if (tabla[pos].getStatus() == HashNode.BORRADO) {
					if (tabla[pos].getInfo().equals(elemento)) {
						return -1;
					}
				}
				intento++;
				pos++;
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

}
