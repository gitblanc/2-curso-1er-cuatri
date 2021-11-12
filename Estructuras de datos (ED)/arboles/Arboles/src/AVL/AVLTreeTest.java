/**
 * 
 */
package AVL;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author blanc
 *
 */
class AVLTreeTest {

	@Test
	void testSearchNode() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertNull(tree.searchNode(1));//la clave no existe
		assertNull(tree.searchNode(null));//la clave es nula
		assertEquals(0, tree.addNode(6));
		assertEquals(0, tree.addNode(2));
		assertEquals(0, tree.addNode(8));
		assertEquals(0, tree.addNode(7));
		assertEquals(0, tree.addNode(9));
		assertEquals(0, tree.addNode(1));
		assertEquals(0, tree.addNode(4));
		assertEquals(0, tree.addNode(3));
		assertEquals(0, tree.addNode(5));
	}
	
	@Test
	void addNode() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(-2, tree.addNode(null));//la clave es nula
		assertEquals(0, tree.addNode(6));//la raiz es nula
		assertEquals(0, tree.addNode(2));
		assertEquals(0, tree.addNode(8));
		assertEquals(0, tree.addNode(7));
		assertEquals(0, tree.addNode(9));
		assertEquals(0, tree.addNode(1));
		assertEquals(0, tree.addNode(4));
		assertEquals(0, tree.addNode(3));
		assertEquals(0, tree.addNode(5));
		assertEquals(-1, tree.addNode(6));//ya exist�a la clave
	}
	
	@Test
	void preOrder() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(6));
		assertEquals(0, tree.addNode(2));
		assertEquals(0, tree.addNode(8));
		assertEquals(0, tree.addNode(7));
		assertEquals(0, tree.addNode(9));
		assertEquals(0, tree.addNode(1));
		assertEquals(0, tree.addNode(4));
		assertEquals(0, tree.addNode(3));
		assertEquals(0, tree.addNode(5));
		assertEquals("6\t2\t1\t4\t3\t5\t8\t7\t9", tree.preOrder());
	}
	
	@Test
	void postOrder() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(6));
		assertEquals(0, tree.addNode(2));
		assertEquals(0, tree.addNode(8));
		assertEquals(0, tree.addNode(7));
		assertEquals(0, tree.addNode(9));
		assertEquals(0, tree.addNode(1));
		assertEquals(0, tree.addNode(4));
		assertEquals(0, tree.addNode(3));
		assertEquals(0, tree.addNode(5));
		assertEquals("1\t3\t5\t4\t2\t7\t9\t8\t6", tree.postOrder());
	}
	
	@Test
	void inOrder() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(6));
		assertEquals(0, tree.addNode(2));
		assertEquals(0, tree.addNode(8));
		assertEquals(0, tree.addNode(7));
		assertEquals(0, tree.addNode(9));
		assertEquals(0, tree.addNode(1));
		assertEquals(0, tree.addNode(4));
		assertEquals(0, tree.addNode(3));
		assertEquals(0, tree.addNode(5));
		assertEquals("1\t2\t3\t4\t5\t6\t7\t8\t9", tree.inOrder());
	}
	
	@Test
	void RotacionSimpleDerecha(){
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(10));
		assertEquals(0, tree.addNode(30));
		assertEquals(0, tree.addNode(90));
		System.out.println("--Simple derecha--");
		System.out.println("InOrder antes de añadir el 95: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(95));
		assertEquals("10	25	30	50	75	90	95", tree.inOrder());
		System.out.println("InOrder despues de añadir el 95: \n" + tree.inOrder());
	}
	
	@Test
	void RotacionSimpleIzquierda(){
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(10));
		System.out.println("--Simple izquierda--");
		System.out.println("InOrder antes de añadir el 5: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(5));
		assertEquals("5	10	25	50	75", tree.inOrder());
		System.out.println("InOrder despues de añadir el 5: \n" + tree.inOrder());
	}
	
	@Test
	void RotacionDobleDerecha(){
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(30));
		System.out.println("--Doble derecha--");
		System.out.println("InOrder antes de añadir el 26: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(26));
		assertEquals("25	26	30	50	75", tree.inOrder());
		System.out.println("InOrder despues de añadir el 26: \n" + tree.inOrder());
	}
	
	@Test
	void RotacionDobleIzquierda(){
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(60));
		System.out.println("--Doble izquierda--");
		System.out.println("InOrder antes de añadir el 65: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(65));
		assertEquals("25	50	60	65	75", tree.inOrder());
		System.out.println("InOrder despues de añadir el 65: \n" + tree.inOrder());
	}

}
