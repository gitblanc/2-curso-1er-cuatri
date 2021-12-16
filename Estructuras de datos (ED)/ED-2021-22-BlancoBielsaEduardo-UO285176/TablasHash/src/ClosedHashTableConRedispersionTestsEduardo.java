import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ClosedHashTableConRedispersionTestsEduardo {

	@Test
	void testAdd() {
		// Crea una tabla del tamaño 7 (numero primo)
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(7, 2, 0.16, 0.5);
		// Muestra la tabla. Debera estar vacia y ser de tamaño 7
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 7 Num.Elems.: 0]", tabla.toString());
		// Inserta un null
		assertEquals(-2, tabla.add(null));
		// Inserta elementos con redispersión
		assertEquals(0, tabla.add(14));
		assertEquals(0, tabla.add(21));
		assertEquals(0, tabla.add(28));
		assertEquals(0, tabla.add(30));
		// Si el elemento está repetido devuelve -1
		assertEquals(-1, tabla.add(14));
		System.out.println(tabla.toString());
		assertEquals(
				"{_E_};{_E_};{_E_};{_E_};{21};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{28};{_E_};{30};{14};{_E_};{_E_};[Size: 17 Num.Elems.: 4]",
				tabla.toString());
	}

	@Test
	void testBorrar() {
		// Crea una tabla del tamaño 7 (numero primo)
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(7, 2, 0.16, 0.5);
		// Muestra la tabla. Debera estar vacia y ser de tamaño 7
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 7 Num.Elems.: 0]", tabla.toString());
		// Inserta un null
		assertEquals(-2, tabla.add(null));
		// Inserta elementos con redispersión
		assertEquals(0, tabla.add(14));
		assertEquals(0, tabla.add(21));
		assertEquals(0, tabla.add(28));
		assertEquals(0, tabla.add(30));
		// Si el elemento está repetido devuelve -1
		assertEquals(-1, tabla.add(14));
		System.out.println(tabla.toString());
		assertEquals(
				"{_E_};{_E_};{_E_};{_E_};{21};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{28};{_E_};{30};{14};{_E_};{_E_};[Size: 17 Num.Elems.: 4]",
				tabla.toString());

		// Borramos el 21 y el 30. Se redispersiona de forma inversa
		assertEquals(0, tabla.remove(21));
		assertEquals(0, tabla.remove(30));
		System.out.println(tabla.toString());
		assertEquals("{28};{14};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 7 Num.Elems.: 2]", tabla.toString());
	}

}
