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
		assertNull(tree.searchNode(1));// la clave no existe
		assertNull(tree.searchNode(null));// la clave es nula
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
		assertEquals(-2, tree.addNode(null));// la clave es nula
		assertEquals(0, tree.addNode(6));// la raiz es nula
		assertEquals(0, tree.addNode(2));
		assertEquals(0, tree.addNode(8));
		assertEquals(0, tree.addNode(7));
		assertEquals(0, tree.addNode(9));
		assertEquals(0, tree.addNode(1));
		assertEquals(0, tree.addNode(4));
		assertEquals(0, tree.addNode(3));
		assertEquals(0, tree.addNode(5));
		assertEquals(-1, tree.addNode(6));// ya exist�a la clave
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
		assertEquals("6:BF=-1	2:BF=1	1:BF=0	4:BF=0	3:BF=0	5:BF=0	8:BF=0	7:BF=0	9:BF=0", tree.preOrder());
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
		assertEquals("1:BF=0	3:BF=0	5:BF=0	4:BF=0	2:BF=1	7:BF=0	9:BF=0	8:BF=0	6:BF=-1", tree.postOrder());
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
		assertEquals("1:BF=0	2:BF=1	3:BF=0	4:BF=0	5:BF=0	6:BF=-1	7:BF=0	8:BF=0	9:BF=0", tree.inOrder());
	}

	@Test
	void RotacionSimpleDerecha() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(10));
		assertEquals(0, tree.addNode(30));
		assertEquals(0, tree.addNode(90));
		System.out.println("--Simple derecha--");
		System.out.println("InOrder antes de a�adir el 95: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(95));
		assertEquals("10:BF=0	25:BF=0	30:BF=0	50:BF=0	75:BF=0	90:BF=0	95:BF=0", tree.inOrder());
		System.out.println("InOrder despues de a�adir el 95: \n" + tree.inOrder());
	}

	@Test
	void RotacionSimpleIzquierda() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(10));
		System.out.println("--Simple izquierda--");
		System.out.println("InOrder antes de a�adir el 5: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(5));
		assertEquals("5:BF=0	10:BF=0	25:BF=0	50:BF=-1	75:BF=0", tree.inOrder());
		System.out.println("InOrder despues de a�adir el 5: \n" + tree.inOrder());
	}

	@Test
	void RotacionDobleDerecha() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(30));
		System.out.println("--Doble derecha--");
		System.out.println("InOrder antes de a�adir el 26: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(26));
		assertEquals("25:BF=0	26:BF=0	30:BF=0	50:BF=-1	75:BF=0", tree.inOrder());
		System.out.println("InOrder despues de a�adir el 26: \n" + tree.inOrder());
	}

	@Test
	void RotacionDobleIzquierda() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(50));
		assertEquals(0, tree.addNode(25));
		assertEquals(0, tree.addNode(75));
		assertEquals(0, tree.addNode(60));
		System.out.println("--Doble izquierda--");
		System.out.println("InOrder antes de a�adir el 65: \n" + tree.inOrder());
		assertEquals(0, tree.addNode(65));
		assertEquals("25:BF=0	50:BF=1	60:BF=0	65:BF=0	75:BF=0", tree.inOrder());
		System.out.println("InOrder despues de a�adir el 65: \n" + tree.inOrder());
	}

	@Test
	void padreDeTest() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(9));
		assertEquals(0, tree.addNode(5));
		assertEquals(0, tree.addNode(1));
		assertEquals(0, tree.addNode(10));
		assertEquals(0, tree.addNode(8));
		assertEquals("5:BF=1", tree.padreDe(1).toString());
		assertEquals("9:BF=0", tree.padreDe(8).toString());
	}
	
	@Test
	void numAristas() {
		AVLTree<Integer> tree = new AVLTree<>();
		assertEquals(0, tree.addNode(9));
		assertEquals(0, tree.addNode(5));
		assertEquals(0, tree.addNode(1));
		assertEquals(0, tree.addNode(10));
		assertEquals(0, tree.addNode(8));
		assertEquals(2, tree.numAristas(5, 10));
		assertEquals(1, tree.numAristas(5, 9));
		assertEquals(1, tree.numAristas(5, 1));
		assertEquals(2, tree.numAristas(5, 8));
		assertEquals(0, tree.numAristas(5, 5));
	}

}
