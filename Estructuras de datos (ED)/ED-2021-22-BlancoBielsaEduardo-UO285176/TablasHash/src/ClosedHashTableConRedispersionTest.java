import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ClosedHashTableConRedispersionTest {

	@Test
	public void test1() {
		System.out.println("Pruebas con enteros");
		//Crea una tabla del tamaño 4 (numero no primo)
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(4,2,0.16,0.5);
		//Muestra la tabla. Debera estar vacia y ser de tamaño 5
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 5 Num.Elems.: 0]",tabla.toString());
		
		// Inserta un null
		assertEquals(-2,tabla.add(null));

		//Inserta elementos
		assertEquals(0,tabla.add(8));
		assertEquals(0,tabla.add(10));
		System.out.println(tabla.toString());
		assertEquals("{10};{_E_};{_E_};{8};{_E_};[Size: 5 Num.Elems.: 2]",tabla.toString());

		
		//Inserta y redispersión
		assertEquals(0,tabla.add(66));
		System.out.println(tabla.toString());		
		assertEquals("{66};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{8};{_E_};{10};[Size: 11 Num.Elems.: 3]",tabla.toString());
		
		//Sigue insertando elementos
		assertEquals(0,tabla.add(77));
		assertEquals(0,tabla.add(7));
		
		//Inserta y redispersión
		assertEquals(0,tabla.add(9));
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{7};{77};{8};{9};{10};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{66};{_E_};{_E_};[Size: 23 Num.Elems.: 6]",tabla.toString());
		
		//Sigue insertando elementos
		assertEquals(0,tabla.add(88));
				
		//Borra un elemento que existe
		assertEquals(0,tabla.remove(8));
		System.out.println(tabla.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{7};{77};{_D_};{9};{10};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{88};{66};{_E_};{_E_};[Size: 23 Num.Elems.: 6]",tabla.toString());
		
		
		//Sigue insertando elementos
		assertEquals(0,tabla.add(13));
		assertEquals(0,tabla.add(19));
		
		//Borra un elemento que no existe
		assertEquals(-1,tabla.remove(2));
		
		// Borra un null
		assertEquals(-2,tabla.remove(null));

		//Borrar elementos
		assertEquals(0,tabla.remove(19));
		assertEquals(0,tabla.remove(7));
		assertEquals(0,tabla.remove(77));
		assertEquals(0,tabla.remove(9));
		System.out.println(tabla.toString());	
	
		
		//Borra 
		assertEquals(0,tabla.remove(10));
		assertEquals(0,tabla.remove(13));
		assertEquals(0,tabla.remove(88));
		System.out.println(tabla.toString());	
		assertEquals("{_E_};{66};{_E_};{_E_};{_E_};[Size: 5 Num.Elems.: 1]",tabla.toString());
		
		//Añade y redispersión
		assertEquals(0,tabla.add(-3));
		assertEquals(0,tabla.add(18));
		System.out.println(tabla.toString());	
		assertEquals("{66};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{18};{-3};{_E_};{_E_};[Size: 11 Num.Elems.: 3]",tabla.toString());
}
	
	@Test
	public void test2() {
		System.out.println("\n\nPruebas con cadenas");
		//Crea una tabla del tamaño 10 (numero no primo)
		ClosedHashTable<String> hashTable = new ClosedHashTable<String>(4,1,0.16,0.5);
		//Muestra la tabla. Debera estar vacia y ser de tamaño 11
		assertEquals("{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 5 Num.Elems.: 0]",hashTable.toString());
		System.out.println(hashTable.toString());
		//Inserta elementos
		assertEquals(0,hashTable.add("Pedro")); 
		assertEquals(0,hashTable.add("Marta")); 
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Pedro};{Marta};{_E_};{_E_};[Size: 5 Num.Elems.: 2]",hashTable.toString());
		
		
		//Inserta y redispersión
		assertEquals(0,hashTable.add("Leo")); 
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{_E_};{_E_};{_E_};{Leo};{_E_};{_E_};{Pedro};{Marta};{_E_};{_E_};[Size: 11 Num.Elems.: 3]",hashTable.toString());
				
		
		//Sigue insertando elementos
		assertEquals(0,hashTable.add("Lucia")); 
		assertEquals(0,hashTable.add("Eva")); 
		
		//Inserta y redispersión
		assertEquals(0,hashTable.add("Luis")); 
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Pedro};{_E_};{_E_};{_E_};{_E_};{Eva};{_E_};{Lucia};{_E_};{Leo};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{Marta};{_E_};{_E_};{Luis};{_E_};[Size: 23 Num.Elems.: 6]",hashTable.toString());
		
		
		//Sigue insertando elementos
		assertEquals(0,hashTable.add("Jose")); 	
		System.out.println(hashTable.toString());
		
		//Borra un elemento que existe
		assertEquals(0,hashTable.remove("Jose")); 
		System.out.println(hashTable.toString());
		
		//Sigue insertando elementos
		assertEquals(0,hashTable.add("Lia")); 
		assertEquals(0,hashTable.add("Eli")); 
		assertEquals(0,hashTable.add("aLi")); 
		System.out.println(hashTable.toString());
		
	
		//Borra un elemento que no existe
		assertEquals(-1,hashTable.remove("Alejandro"));
		
		//Borrar elementos
		assertEquals(0,hashTable.remove("Eli"));
		assertEquals(0,hashTable.remove("Lia"));
		assertEquals(0,hashTable.remove("Marta"));
		assertEquals(0,hashTable.remove("Luis"));
		
		//Borra y redispersión inversa
		assertEquals(0,hashTable.remove("Eva"));
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Pedro};{_E_};{_D_};{_E_};{_D_};{_D_};{_E_};{Lucia};{_E_};{Leo};{_E_};{_E_};{_D_};{_E_};{_E_};{_E_};{_E_};{_D_};{_E_};{_E_};{_D_};{aLi};[Size: 23 Num.Elems.: 4]",hashTable.toString());
		
		
		//Inserta un elemento 
		assertEquals(0,hashTable.add("Isabel"));
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Pedro};{Isabel};{_D_};{_E_};{_D_};{_D_};{_E_};{Lucia};{_E_};{Leo};{_E_};{_E_};{_D_};{_E_};{_E_};{_E_};{_E_};{_D_};{_E_};{_E_};{_D_};{aLi};[Size: 23 Num.Elems.: 5]",hashTable.toString());

		//Borra Pedro y Lucia y redispensión inversa
		assertEquals(0,hashTable.remove("Pedro"));
		assertEquals(0,hashTable.remove("Lucia"));
		System.out.println(hashTable.toString());
		assertEquals("{aLi};{Isabel};{_E_};{_E_};{Leo};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 3]",hashTable.toString());
		
		//Borra Leo y aLi y redispensión inversa
		assertEquals(0,hashTable.remove("Leo"));
		assertEquals(0,hashTable.remove("aLi"));
		System.out.println(hashTable.toString());
		assertEquals("{_E_};{Isabel};{_E_};{_E_};{_E_};[Size: 5 Num.Elems.: 1]",hashTable.toString());
	}
}
