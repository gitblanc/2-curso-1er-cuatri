package BST;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArbolesBinariosAddTest{
	
	@SuppressWarnings("deprecation")
	@Test
	public void test1()
	 {
		BSTree<Integer> b = new BSTree<Integer>();

		// Busca en un áarbol vacio y devuelve null
		assertNull(b.searchNode(10));
		// Busca una clave bull y devuelve null
		assertNull(b.searchNode(null));
		
		assertEquals(-2,b.addNode(null));
		assertEquals(0,b.addNode(10));
		assertEquals(0,b.addNode(5));
		assertEquals(0,b.addNode(15));
		assertEquals(0,b.addNode(2));
		assertEquals(0,b.addNode(6));
		assertEquals(0,b.addNode(14));
		assertEquals(0,b.addNode(11));
		assertEquals(0,b.addNode(16));
		
//		//Añade un elemento que ya existe
		assertEquals(-1,b.addNode(15));
		
//		//Busca un nodo que no existe
		assertNull(b.searchNode(500));
		
//		//Recorridos
		assertEquals("2\t5\t6\t10\t11\t14\t15\t16",b.inOrder());
		assertEquals("10\t5\t2\t6\t15\t14\t11\t16",b.preOrder());
		assertEquals("2\t6\t5\t11\t14\t16\t15\t10",b.postOrder());
		
		//Busca un elemento que existe (5)
		assertEquals(new Integer(5),b.searchNode(5).getInfo());
	}

	@Test
	public void test2() {
		BSTree<Integer> b = new BSTree<Integer>();

		assertNull(b.searchNode(50));
		assertEquals(0,b.addNode(10));
		assertEquals(0,b.addNode(100));
		assertEquals(0,b.addNode(60));
		assertEquals(0,b.addNode(30));
		assertEquals(0,b.addNode(2));
		assertEquals(0,b.addNode(-43));
		assertEquals(0,b.addNode(70));
		assertEquals(0,b.addNode(90));
		assertEquals(0,b.addNode(23));
		assertEquals(0,b.addNode(43));
		assertEquals(0,b.addNode(65));
		assertEquals(0,b.addNode(13));
		assertEquals(0,b.addNode(230));
		assertEquals(0,b.addNode(49));
		assertEquals(0,b.addNode(7));
		assertEquals(0,b.addNode(40));
		assertEquals(0,b.addNode(50));
		assertEquals(0,b.addNode(20));
		assertEquals(0,b.addNode(15));
		assertEquals(0,b.addNode(3));

		//Añade un elemento que ya existe
		assertEquals(-1,b.addNode(3));
		
		//Busca un nodo que no existe
		assertNull(b.searchNode(500));
		
		//Recorridos
		assertEquals("-43\t2\t3\t7\t10\t13\t15\t20\t23\t30\t40\t43\t49\t50\t60\t65\t70\t90\t100\t230",b.inOrder());
		assertEquals("10\t2\t-43\t7\t3\t100\t60\t30\t23\t13\t20\t15\t43\t40\t49\t50\t70\t65\t90\t230",b.preOrder());
		assertEquals("-43\t3\t7\t2\t15\t20\t13\t23\t40\t50\t49\t43\t30\t65\t90\t70\t60\t230\t100\t10",b.postOrder());
	}

}