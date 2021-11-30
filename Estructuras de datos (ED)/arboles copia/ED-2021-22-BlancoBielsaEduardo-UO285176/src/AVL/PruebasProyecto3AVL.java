package AVL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasProyecto3AVL {

	@Test
	void test_Add() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		// Insertar una clave null
		assertEquals(-2, b.addNode(null));
		
		// 5, 18 10 -- RDD(10)
		assertEquals(0,b.addNode(5));
		assertEquals(0,b.addNode(18));
		assertEquals(0,b.addNode(10));
		assertEquals("5:BF=0\t10:BF=0\t18:BF=0",b.inOrder());
		
		// 40, 50 -- RSD(18)
		assertEquals(0,b.addNode(40));
		assertEquals(0,b.addNode(50));
		assertEquals("5:BF=0\t10:BF=1\t18:BF=0\t40:BF=0\t50:BF=0",b.inOrder());
		
		// 15 -- RDD(10)
		assertEquals(0,b.addNode(15));
		assertEquals("5:BF=0\t10:BF=0\t15:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 16 
		assertEquals(0,b.addNode(16));
		assertEquals("5:BF=0\t10:BF=1\t15:BF=1\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 12 
		assertEquals(0,b.addNode(12));
		assertEquals("5:BF=0\t10:BF=1\t12:BF=0\t15:BF=0\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 14 -- RDD(10)
		assertEquals(0,b.addNode(14));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=0\t14:BF=0\t15:BF=0\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 17 -- RDI(18)
		assertEquals(0,b.addNode(17));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// Inserta un elemento que ya existe
		assertEquals(-1,b.addNode(15));
	}

	@Test
	void test_Remove() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		// Borra una clave null
		assertEquals(-2, b.removeNode(null));
		
		// Borra en un árbol vacío
		assertEquals(-2, b.removeNode(12));
		
		// Insertar 5, 18 10, 40, 50, 15, 16, 12, 14, 17
		b.addNode(5);
		b.addNode(18);
		b.addNode(10);
		b.addNode(40);
		b.addNode(50);
		b.addNode(15);
		b.addNode(16);
		b.addNode(12);
		b.addNode(14);
		b.addNode(17);
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// Borra un una clave que es null
		assertEquals(-2, b.removeNode(null));
		
		// Borra un elemento que no existe
		assertEquals(-1, b.removeNode(90));
		
		// Borra una clave sin hijos --> 50
		assertEquals(0, b.removeNode(50));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
		
		// Borra un elemento que no existe
		assertEquals(-1, b.removeNode(50));
		
		// Borra una clave con un hijo izquierdo --> 10
		assertEquals(0, b.removeNode(10));
		assertEquals("5:BF=0\t12:BF=0\t14:BF=0\t15:BF=1\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
	
		// Borra la raíz que tiene dos hijos --> 15
		assertEquals(0, b.removeNode(15));
		assertEquals("5:BF=0\t12:BF=-1\t14:BF=1\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
	
		// Borra la raíz que tiene dos hijos --> 14
		assertEquals(0, b.removeNode(14));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=0\t17:BF=0\t18:BF=0\t40:BF=0",b.inOrder());
		
		// Borra una clave que es hoja --> 17
		assertEquals(0, b.removeNode(17));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=0\t18:BF=1\t40:BF=0",b.inOrder());
		
		// Borra una clave que tiene un hijo derecho --> 18
		assertEquals(0, b.removeNode(18));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=-1\t40:BF=0",b.inOrder());
		
		// Borra una clave que es hoja --> 40
		assertEquals(0, b.removeNode(40));
		assertEquals("5:BF=0\t12:BF=0\t16:BF=0",b.inOrder());
		
		// Borra la raíz que tiene dos hijos --> 12
		assertEquals(0, b.removeNode(12));
		assertEquals("5:BF=1\t16:BF=0",b.inOrder());
		
		// Borra un hijo que es hoja --> 16
		assertEquals(0, b.removeNode(16));
		assertEquals("5:BF=0",b.inOrder());
		
		// Borra la raíz que no tiene hijos
		assertEquals(0, b.removeNode(5));
		
		// Borra el 5 
		assertEquals(-2, b.removeNode(5));
	}
}
