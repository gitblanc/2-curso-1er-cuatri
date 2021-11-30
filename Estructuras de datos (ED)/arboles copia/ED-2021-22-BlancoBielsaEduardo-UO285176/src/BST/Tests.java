/**
 * 
 */
package BST;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author UO285176
 *
 */
class Tests {

	@Test
	void testSearchNode() {
		BSTree<Integer> tree = new BSTree<>();
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
		BSTree<Integer> tree = new BSTree<>();
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
		BSTree<Integer> tree = new BSTree<>();
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
		BSTree<Integer> tree = new BSTree<>();
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
		BSTree<Integer> tree = new BSTree<>();
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
	
	
}
