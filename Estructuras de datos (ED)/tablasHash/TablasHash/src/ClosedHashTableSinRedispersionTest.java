import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ClosedHashTableSinRedispersionTest {

	@Test
	public void test1() {
		System.out.println("Pruebas con enteros");
		// Crea una tabla del tamaño 11 y tipo de exploración cuadrática (2)
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(11,2);
		// Muestra la tabla. Debera estar vacia y ser de tamaño 11
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 0]",tabla.toString());
		
		// Inserta un null
		assertEquals(-2,tabla.add(null));

		// Inserta elementos
		assertEquals(0,tabla.add(8));
		assertEquals(0,tabla.add(10));
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 2]",tabla.toString());
		
		assertEquals(0,tabla.add(66));
		System.out.println(tabla.toString());		
		assertEquals("{66};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 3]",tabla.toString());
		
		// Inserta elementos con colision
		assertEquals(0,tabla.add(77));
		System.out.println(tabla.toString());	
		assertEquals("{66};{77};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 4]",tabla.toString());

		assertEquals(0,tabla.add(88));
		System.out.println(tabla.toString());	
		assertEquals("{66};{77};{_E_};{_E_};{88};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 5]",tabla.toString());

		assertEquals(0,tabla.add(89));
		System.out.println(tabla.toString());
		assertEquals("{66};{77};{89};{_E_};{88};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 6]",tabla.toString());
		
		
		// Sigue insertando elementos
		assertEquals(0,tabla.add(3));
		assertEquals(0,tabla.add(6));
		assertEquals(0,tabla.add(7));
		assertEquals(0,tabla.add(20));
		assertEquals(0,tabla.add(16));
		System.out.println(tabla.toString());
		assertEquals("{66};{77};{89};{3};{88};{16};{6};{7};{8};{20};{10};[Size: 11 Num.Elems.: 11]",tabla.toString());
		
	
		//Borra un elemento que existe
		assertEquals(0,tabla.remove(7));
		System.out.println(tabla.toString());
		assertEquals("{66};{77};{89};{3};{88};{16};{6};{_D_};{8};{20};{10};[Size: 11 Num.Elems.: 10]",tabla.toString());
		
		// Borra un null
		assertEquals(-2,tabla.remove(null));
		
		//Borra un elemento que no existe
		assertEquals(-1,tabla.remove(2));
		

		//Borrar elementos
		assertEquals(0,tabla.remove(77));
		System.out.println(tabla.toString());
		assertEquals("{66};{_D_};{89};{3};{88};{16};{6};{_D_};{8};{20};{10};[Size: 11 Num.Elems.: 9]",tabla.toString());

		assertEquals(0,tabla.remove(89));
		System.out.println(tabla.toString());
		assertEquals("{66};{_D_};{_D_};{3};{88};{16};{6};{_D_};{8};{20};{10};[Size: 11 Num.Elems.: 8]",tabla.toString());

		assertEquals(0,tabla.remove(88));
		System.out.println(tabla.toString());
		assertEquals("{66};{_D_};{_D_};{3};{_D_};{16};{6};{_D_};{8};{20};{10};[Size: 11 Num.Elems.: 7]",tabla.toString());

		assertEquals(0,tabla.remove(20));
		System.out.println(tabla.toString());	
		assertEquals("{66};{_D_};{_D_};{3};{_D_};{16};{6};{_D_};{8};{_D_};{10};[Size: 11 Num.Elems.: 6]",tabla.toString());
	
		// Inserta un elemento que ocuparía una posisión ya borrada
		assertEquals(0,tabla.add(44));
		System.out.println(tabla.toString());	
		assertEquals("{66};{44};{_D_};{3};{_D_};{16};{6};{_D_};{8};{_D_};{10};[Size: 11 Num.Elems.: 7]",tabla.toString());

	}
	

}
