package ColasPrioridad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryHeapMinTest {

	@Test
	void addTest() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);

		assertEquals(-2, bh.add(null));
		assertEquals(0, bh.add(5));
		assertEquals(-1, bh.add(5));
		assertEquals(0, bh.add(7));
		assertEquals(0, bh.add(8));
		assertEquals(0, bh.add(9));
		assertEquals(0, bh.add(2));
		assertEquals(0, bh.add(0));
		assertEquals("0	5	2	9	7	8", bh.toString());
	}

	@Test
	void pollTest() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);
		assertNull(bh.poll());
		assertEquals(0, bh.add(5));
		assertEquals(0, bh.add(8));
		assertEquals(0, bh.add(6));
		assertEquals(0, bh.add(10));
		assertEquals(0, bh.add(15));
		assertEquals(0, bh.add(7));
		assertEquals(0, bh.add(12));
		assertEquals(0, bh.add(24));
		assertEquals(5, bh.poll());

		assertEquals("6	8	7	10	15	24	12", bh.toString());
	}


	@Test
	void removeTest() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);
		bh.add(5);
		bh.add(8);
		bh.add(6);
		bh.add(10);
		bh.add(15);
		bh.add(7);
		bh.add(12);
		bh.add(24);
		bh.poll();
		bh.remove(24);
		assertEquals("6	8	7	10	15	12", bh.toString());
		bh.remove(8);
		assertEquals("6	12	7	10	15", bh.toString());
	}

	@Test
	void cambiarPrioridadTest() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);
		assertEquals(-1, bh.cambiarPrioridad(6, 30));
		bh.add(12);
		bh.add(14);
		bh.add(15);
		bh.add(20);
		bh.add(16);
		bh.add(17);
		bh.add(19);
		assertEquals("12	14	15	20	16	17	19", bh.toString());
		assertEquals(-2, bh.cambiarPrioridad(-99979876, 30));
		assertEquals(-2, bh.cambiarPrioridad(99979876, 30));
		assertEquals(0, bh.cambiarPrioridad(2, 30));
		assertEquals("12	14	17	20	16	30	19", bh.toString());
	}
	
	@Test
	void cambiarPrioridadTest2() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);
		assertEquals(-1, bh.cambiarPrioridad(6, 30));
		bh.add(12);
		bh.add(14);
		bh.add(15);
		bh.add(20);
		bh.add(16);
		bh.add(17);
		bh.add(19);
		assertEquals("12	14	15	20	16	17	19", bh.toString());
		assertEquals(-2, bh.cambiarPrioridad(-99979876, 30));
		assertEquals(-2, bh.cambiarPrioridad(99979876, 30));
		assertEquals(0, bh.cambiarPrioridad(2, 2));
		assertEquals("2	14	12	20	16	17	19", bh.toString());
	}

	@Test
	void isEmptyTest() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);
		assertTrue(bh.isEmpty());
		bh.add(12);
		assertFalse(bh.isEmpty());
	}
	
	@Test
	void clearTest() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);
		assertEquals(-1, bh.cambiarPrioridad(6, 30));
		bh.add(12);
		bh.add(14);
		bh.add(15);
		bh.add(20);
		bh.add(16);
		bh.add(17);
		bh.add(19);
		bh.clear();
		assertTrue(bh.isEmpty());
	}
}
