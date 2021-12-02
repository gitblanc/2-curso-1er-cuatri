package ColasPrioridad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryHeapMinTest {

	@Test
	void addTest() {
		BinaryHeapMin<Integer> b2 = new BinaryHeapMin<>(0);
		assertEquals(-1, b2.add(5));// mont�culo con 0 elementos

		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);

		assertEquals(-2, bh.add(null));
		assertEquals(0, bh.add(5));
		System.out.println(bh.toString());
		assertEquals(0, bh.add(5));
		System.out.println(bh.toString());
		assertEquals(0, bh.add(7));
		System.out.println(bh.toString());
		assertEquals(0, bh.add(8));
		System.out.println(bh.toString());
		assertEquals(0, bh.add(9));
		System.out.println(bh.toString());
		assertEquals(0, bh.add(2));
		System.out.println(bh.toString());
		assertEquals(0, bh.add(0));
		System.out.println(bh.toString());
		assertEquals("0	5	2	8	9	7	5", bh.toString());
	}

	@Test
	void addTest2() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);

		assertEquals(0, bh.add(4));
		assertEquals(0, bh.add(8));
		assertEquals(0, bh.add(9));
		assertEquals(0, bh.add(15));
		assertEquals(0, bh.add(18));
		assertEquals(0, bh.add(11));
		assertEquals(0, bh.add(14));

		assertEquals("4	8	9	15	18	11	14", bh.toString());

		assertEquals(0, bh.add(5));

		assertEquals("4	5	9	8	18	11	14	15", bh.toString());

		assertEquals(-1, bh.add(456));
		assertEquals(-1, bh.add(5));
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
	void pollTest2() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(6);
		assertNull(bh.poll());
		assertEquals(0, bh.add(5));
		assertEquals(5, bh.poll());
		// En el caso de que s�lo hubiese un elemento y se hiciese un poll(), devuelve
		// el elemento y se vac�a el mont�culo
		assertEquals("", bh.toString());

		BinaryHeapMin<Integer> b2 = new BinaryHeapMin<>(8);
		assertNull(b2.poll());
		assertEquals(0, b2.add(4));
		assertEquals(0, b2.add(15));
		assertEquals(0, b2.add(5));
		assertEquals(0, b2.add(9));
		assertEquals(0, b2.add(8));
		assertEquals(0, b2.add(18));
		assertEquals(0, b2.add(11));
		assertEquals(0, b2.add(14));

		assertEquals("4	8	5	14	9	18	11	15", b2.toString());
		assertEquals(4, b2.poll());
		assertEquals("5	8	11	14	9	18	15", b2.toString());
	}

	@Test
	void removeTest() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(30);
		bh.add(2);
		bh.add(4);
		bh.add(36);
		bh.add(22);
		bh.add(25);
		bh.add(38);
		bh.add(63);
		bh.add(50);
		bh.add(30);
		bh.add(20);
		bh.add(32);
		bh.add(41);
		bh.add(39);
		bh.add(99);
		bh.add(65);
		bh.add(60);
		bh.add(51);
		bh.add(75);
		bh.add(42);
		bh.add(55);
		bh.add(31);
		bh.add(40);
		bh.add(33);
		bh.add(90);
		bh.add(80);
		bh.add(95);
		assertEquals(
				"2	4	36	22	20	38	63	50	30	25	32	41	39	99	65	60	51	75	42	55	31	40	33	90	80	95",
				bh.toString());
		assertEquals(0, bh.remove(99));
		assertEquals(0, bh.remove(38));
		assertEquals(0, bh.remove(22));
		assertEquals(0, bh.remove(2));
		assertEquals("4	20	36	30	25	39	63	50	42	31	32	41	80	95	65	60	51	75	90	55	33	40",
				bh.toString());
	}

	@Test
	void removeTest2() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(9);
		bh.add(12);
		bh.add(14);
		bh.add(15);
		bh.add(20);
		bh.add(16);
		bh.add(17);
		bh.add(19);
		bh.add(24);
		bh.add(30);
		assertEquals("12	14	15	20	16	17	19	24	30", bh.toString());
		bh.remove(15);
		assertEquals("12	14	17	20	16	30	19	24", bh.toString());
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
