import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author blanc
 *
 */
public class OpenHash<T extends Comparable<T>> extends AbstractHash<T> {

	private int numElementos;
	private AVLTree<T> tabla[];
	private double minlf;
	private double maxlf;

	public static final double MAX_LF = 1;
	public static final double MIN_LF = 0.33;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public OpenHash(int tam) {
		this.numElementos = 0;
		this.minlf = MIN_LF;
		this.maxlf = MAX_LF;
		if (!isPositivePrime(tam))
			tam = nextPrimeNumber(tam);
		this.tabla = (AVLTree<T>[]) Array.newInstance(AVLTree.class, tam);
		for (int i = 0; i < this.tabla.length; i++) {
			tabla[i] = new AVLTree<T>();
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
	
	private float calculateFactorCarga() {
		return numElementos / (float) (getSize());
	}

	@Override
	public int add(T elemento) {
		// Buscar la posición en la que iría elemento
		if (elemento == null) {
			return -2;
		} else {
			int pos = fHash(elemento);
			this.tabla[pos].addNode(elemento);
			this.numElementos++;
			if(calculateFactorCarga() >= MAX_LF) {
				redispersion();
			}
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	private void redispersion() {
		AVLTree<T>[] aux = this.tabla;
		int tam = this.tabla.length * 2;
		if (!isPositivePrime(tam)) {
			tam = nextPrimeNumber(tam);
		}
		this.tabla = (AVLTree<T>[]) Array.newInstance(HashNode.class, tam);
		this.numElementos = 0;
		for (int i = 0; i < this.tabla.length; i++) {
			tabla[i] = new AVLTree<T>();
		}
		for (int k = 0; k < aux.length; k++) {
			ArrayList<T> nodos = new ArrayList<T>();
			if(aux[k].devolverNodos() != null) {
				nodos = aux[k].devolverNodos();
				add(nodos.get(k));
			}
		}
		
	}

	@Override
	public T find(T elemento) {
		if (elemento == null) {
			return null;
		} else {
			int pos = fHash(elemento);
			return this.tabla[pos].searchNode(elemento).getInfo();

		}
	}

	@Override
	public int remove(T elemento) {
		if (elemento == null) {
			return -2;
		} else if (find(elemento) == null) {
			return -1;
		} else {
			int pos = fHash(elemento);
			return this.tabla[pos].removeNode(elemento);

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

	public double getMinlf() {
		return minlf;
	}

	public double getMaxlf() {
		return maxlf;
	}

}
