package ColasPrioridad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryHeapMinTest {

	@Test
	void addTest() {
        BinaryHeapMin<Integer> bh = new BinaryHeapMin<>(8);

        assertEquals(-2, bh.add(null));
        assertEquals(0,bh.add(5));
        assertEquals(0,bh.add(7));
        assertEquals(0,bh.add(8));
        assertEquals(0,bh.add(9));
        assertEquals(0,bh.add(2));
        assertEquals(0, bh.add(0));

        System.out.println("Test");
        System.out.println(bh.toString());
    }
	
	@Test
    void pollTest() {
        BinaryHeapMin<Integer> bh= new BinaryHeapMin<>(8);
        bh.add(5);
        bh.add(8);
        bh.add(6);
        bh.add(10);
        bh.add(15);
        bh.add(7);
        bh.add(12);
        bh.add(24);
        bh.poll();

        System.out.println(bh.toString());
    }
	
	@Test
	void removeTest() {
		BinaryHeapMin<Integer> bh= new BinaryHeapMin<>(8);
		bh.add(5);
        bh.add(8);
        bh.add(6);
        bh.add(10);
        bh.add(15);
        bh.add(7);
        bh.add(12);
        bh.add(24);
        bh.poll();
        System.out.println("Remove:" + bh.toString());
        bh.remove(24);
       // bh.remove(8);
        System.out.println("Removed: " + bh.toString());
	}

}