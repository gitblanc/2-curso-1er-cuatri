/**
 * 
 */
package AVL;

import org.junit.jupiter.api.Test;

/**
 * @author blanc
 *
 */
class AVLNodeTest {

	@Test
	void test() {
		AVLNode<Integer> nodo = new AVLNode<>(10);
		System.out.println(nodo.toString());
		nodo.setLeft(new AVLNode<Integer>(2));
		System.out.println(nodo.toString());
		
		System.out.println("Después de actualizar...");
		nodo.updateBFHeight();
		System.out.println(nodo.toString());
		System.out.println(nodo.getLeft().toString());
	}
	
	

}
