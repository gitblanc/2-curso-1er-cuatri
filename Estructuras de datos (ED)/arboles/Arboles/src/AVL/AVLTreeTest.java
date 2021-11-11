/**
 * 
 */
package AVL;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BST.BSTree;

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
	void RotacionSimple(){
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(10));
		assertEquals(0, tree.addNode(30));
		assertEquals(0, tree.addNode(90));
		System.out.println("InOrder antes de añadir el 95: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(95));
		assertEquals("10	25	30	50	75	90	95", tree.inOrder());
		System.out.println("InOrder despues de añadir el 95: \n" + tree.inOrder());
	}

}
