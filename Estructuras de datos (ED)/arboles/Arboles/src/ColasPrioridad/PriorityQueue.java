/**
 * 
 */
package ColasPrioridad;

/**
 * @author UO285176/blanc/Eduardo Blanco Bielsa
 * Interfaz con los m�todos a redefinir en la clase BinaryHeapMin
 *
 */
public interface PriorityQueue<T extends Comparable<T>> {

	public int add(T elemento);

	public T poll();

	public int remove(T elemento);

	public boolean isEmpty();

	public void clear();

	public int cambiarPrioridad(int pos, T elemento);

	@Override
	public String toString();

}
