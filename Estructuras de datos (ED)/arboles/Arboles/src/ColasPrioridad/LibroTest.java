package ColasPrioridad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibroTest {

	@Test
	void testAdd() {
		BinaryHeapMin<Libro> bh = new BinaryHeapMin<>(8);
		assertEquals(0,bh.add(new Libro(1, "1 libro")));
		assertEquals(0,bh.add(new Libro(2, "2 libro")));
		assertEquals(0,bh.add(new Libro(3, "3 libro")));
		assertEquals(0,bh.add(new Libro(4, "4 libro")));
		assertEquals(0,bh.add(new Libro(5, "5 libro")));
		assertEquals(0,bh.add(new Libro(6, "6 libro")));
		
		assertEquals("1 libro	2 libro	3 libro	4 libro	5 libro	6 libro", bh.toString());
	}
	
	@Test
	void testPoll() {
		BinaryHeapMin<Libro> bh = new BinaryHeapMin<>(8);
		assertEquals(0,bh.add(new Libro(1, "1 libro")));
		assertEquals(0,bh.add(new Libro(2, "2 libro")));
		assertEquals(0,bh.add(new Libro(3, "3 libro")));
		assertEquals(0,bh.add(new Libro(4, "4 libro")));
		assertEquals(0,bh.add(new Libro(5, "5 libro")));
		assertEquals(0,bh.add(new Libro(6, "6 libro")));
		assertEquals("1 libro", bh.poll().toString());
		
		assertEquals("2 libro	4 libro	3 libro	6 libro	5 libro", bh.toString());
	}
	
	@Test
	void testRemove() {
		BinaryHeapMin<Libro> bh = new BinaryHeapMin<>(8);
		Libro l1 = new Libro(1, "1 libro");
		Libro l2 = new Libro(1, "NO EXISTE");
		assertEquals(0,bh.add(l1));
		assertEquals(0,bh.add(new Libro(2, "2 libro")));
		assertEquals(0,bh.add(new Libro(3, "3 libro")));
		assertEquals(0,bh.add(new Libro(4, "4 libro")));
		assertEquals(0,bh.add(new Libro(5, "5 libro")));
		assertEquals(0,bh.add(new Libro(6, "6 libro")));
		assertEquals(0, bh.remove(l1));
		assertEquals(-1, bh.remove(l2));
		
		assertEquals("2 libro	4 libro	3 libro	6 libro	5 libro", bh.toString());
	}
	
	@Test
	void testCambiarPrioridad() {
		BinaryHeapMin<Libro> bh = new BinaryHeapMin<>(8);
		Libro l1 = new Libro(1, "NUEVO");
		assertEquals(0,bh.add(new Libro(1, "1 libro")));
		assertEquals(0,bh.add(new Libro(2, "2 libro")));
		assertEquals(0,bh.add(new Libro(3, "3 libro")));
		assertEquals(0,bh.add(new Libro(4, "4 libro")));
		assertEquals(0,bh.add(new Libro(5, "5 libro")));
		assertEquals(0,bh.add(new Libro(6, "6 libro")));
		assertEquals(0, bh.cambiarPrioridad(5, l1));
		
		assertEquals("1 libro	2 libro	NUEVO	4 libro	5 libro	3 libro", bh.toString());
	}

}
