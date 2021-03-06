package proyecto1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlgoritmosTests {

	//TESTS RECURSIVOS
	@Test
	void testFactorialRecursivo() {
		assertEquals(1, Algoritmos.factorialRecursivo(0));
		assertEquals(120, Algoritmos.factorialRecursivo(5));
		assertEquals(24, Algoritmos.factorialRecursivo(4));
		assertEquals(9.33262154439441E157, Algoritmos.factorialRecursivo(100));
	}
	
	
	
	@Test
	void testPot2Recursivo() {
		assertEquals(1, Algoritmos.potenciaRecursiva_v0(0));
		assertEquals(4, Algoritmos.potenciaRecursiva_v0(2));
		assertEquals(16, Algoritmos.potenciaRecursiva_v0(4));
		assertEquals(1.073741824E9, Algoritmos.potenciaRecursiva_v0(30));
		
		assertEquals(1, Algoritmos.potenciaRecursiva_v1(0));
		assertEquals(4, Algoritmos.potenciaRecursiva_v1(2));
		assertEquals(16, Algoritmos.potenciaRecursiva_v1(4));
		
		assertEquals(1, Algoritmos.potenciaRecursiva_v2(0));
		assertEquals(4, Algoritmos.potenciaRecursiva_v2(2));
		assertEquals(16, Algoritmos.potenciaRecursiva_v2(4));
		assertEquals(1.073741824E9, Algoritmos.potenciaRecursiva_v2(30));
		
		assertEquals(1, Algoritmos.potenciaRecursiva_v3(0));
		assertEquals(4, Algoritmos.potenciaRecursiva_v3(2));
		assertEquals(16, Algoritmos.potenciaRecursiva_v3(4));
		assertEquals(1.073741824E9, Algoritmos.potenciaRecursiva_v3(30));
	}
	
	
	
	
	
	@Test
	void testFibonacciRecursivo() {
		assertEquals(0, Algoritmos.fibonacciRecursivo(1));
		assertEquals(1, Algoritmos.fibonacciRecursivo(2));
		assertEquals(1, Algoritmos.fibonacciRecursivo(3));
		assertEquals(2, Algoritmos.fibonacciRecursivo(4));
		assertEquals(3, Algoritmos.fibonacciRecursivo(5));
		assertEquals(5, Algoritmos.fibonacciRecursivo(6));
		assertEquals(8, Algoritmos.fibonacciRecursivo(7));
		assertEquals(7.778742049E9, Algoritmos.fibonacciRecursivo(50));
	}
	
	//TESTS ITERATIVOS
	
	@Test
	void testFactorialIterativo() {
		assertEquals(1, Algoritmos.factorialIterativo(0));
		assertEquals(120, Algoritmos.factorialIterativo(5));
		assertEquals(24, Algoritmos.factorialIterativo(4));
	}
	
	@Test
	void testPot2Iterativo() {
		assertEquals(1, Algoritmos.potenciaIterativa(0));
		assertEquals(4, Algoritmos.potenciaIterativa(2));
		assertEquals(16, Algoritmos.potenciaIterativa(4));
		assertEquals(1.2676506002282294E30, Algoritmos.potenciaIterativa(100));
	}
	
	@Test
	void testFibonacciIterativo() {
		assertEquals(0, Algoritmos.fibonacciIterativo(1));
		assertEquals(1, Algoritmos.fibonacciIterativo(2));
		assertEquals(1, Algoritmos.fibonacciIterativo(3));
		assertEquals(2, Algoritmos.fibonacciIterativo(4));
		assertEquals(3, Algoritmos.fibonacciIterativo(5));
		assertEquals(5, Algoritmos.fibonacciIterativo(6));
		assertEquals(8, Algoritmos.fibonacciIterativo(7));
		assertEquals(7.778742049E9, Algoritmos.fibonacciIterativo(50));  
	}
	
}
