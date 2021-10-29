package grafo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author blanc
 *
 */
class Tests {
	Graph<Integer> graph;

	@Test
	// El vector de nodos est� vac�o, devuelve -1
	void testGetNode() {
		graph = new Graph<Integer>(10);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		assertEquals(-1, graph.getNode(num1));
		assertEquals(-1, graph.getNode(num2));
		assertEquals(-1, graph.getNode(num3));
		// Se a�aden 3 objectos al vector de nodos, devuelve sus posiciones
		// correspondientes
		graph.addNode(num1);
		graph.addNode(num2);
		graph.addNode(num3);
		assertEquals(0, graph.getNode(num1));
		assertEquals(1, graph.getNode(num2));
		assertEquals(2, graph.getNode(num3));
	}

	@Test
	// El vector de nodos est� vac�o, devuelve false
	void testExistsNode() {
		graph = new Graph<Integer>(10);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		assertEquals(false, graph.existsNode(num1));
		assertEquals(false, graph.existsNode(num2));
		assertEquals(false, graph.existsNode(num3));
		// El vector de nodos no est� vac�o, devuelve true
		graph.addNode(num1);
		graph.addNode(num2);
		graph.addNode(num3);
		assertEquals(true, graph.existsNode(num1));
		assertEquals(true, graph.existsNode(num2));
		assertEquals(true, graph.existsNode(num3));
	}

	@Test
	// Se inserta un nodo de forma correcta -> devuelve 0
	void testAddNode() {
		graph = new Graph<Integer>(4);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num3));
		assertEquals(true, graph.existsNode(num1));
		assertEquals(true, graph.existsNode(num2));
		assertEquals(true, graph.existsNode(num3));
		// El nodo ya exist�a previamente y si cab�a -> no lo inserta y devuelve -1
		assertEquals(-1, graph.addNode(num1));
		Integer num4 = 4;
		assertEquals(0, graph.addNode(num4));
		assertEquals(true, graph.existsNode(num4));
		// Si ya existe y adem�s no cabe, no lo inserta y devuelve -3
		assertEquals(-3, graph.addNode(num4));
		// Si no existe, pero no cabe, no lo inserta y devuelve -2
		Integer num5 = 5;
		assertEquals(-2, graph.addNode(num5));

	}

	@Test
	// Devuelve true si existe una arista entre los nodos origen y destino, false en
	// caso contrario o no existen los nodos
	void testexistEdge() {
		graph = new Graph<Integer>(4);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addEdge(num1, num2, 3));
		assertEquals(0, graph.addEdge(num2, num1, 3));
		assertEquals(true, graph.existEdge(num1, num2));
		assertEquals(true, graph.existEdge(num2, num1));
		assertEquals(false, graph.existEdge(num3, num1));
	}

	@Test
	// Devuelve el peso de la arista que une el nodo origen y el nodos destino.
	// devuelve -1, -2 y -3 si no existe origen, destino, ambos.Devuelve -4 si no
	// existe
	// la arista.
	void getEdge() {
		graph = new Graph<Integer>(4);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		Integer num4 = 4;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num4));
		assertEquals(0, graph.addEdge(num1, num2, 4));
		assertEquals(0, graph.addEdge(num2, num1, 7));
		assertEquals(4, graph.getEdge(num1, num2));
		assertEquals(7, graph.getEdge(num2, num1));
		// no existe origen
		assertEquals(-1, graph.getEdge(num3, num2));
		// no existe destino
		assertEquals(-2, graph.getEdge(num1, num3));
		// no existen ambois nodos
		assertEquals(-3, graph.getEdge(num3, num3));
		// no existe la arista
		assertEquals(-4, graph.getEdge(num4, num2));
	}

	// Inserta una arista con el peso indicado (> 0) entre dos nodos. Devuelve 0 si
	// la inserta. Devuelve 1, 2 y 3 si no existe nodos origen, destino o ambos
	// respectivamente. Devuelve 4 si ya existe y 8 si el peso no es v�lido
	@Test
	void addEdge() {
		graph = new Graph<Integer>(4);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		Integer num4 = 4;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num4));
		assertEquals(0, graph.addEdge(num1, num2, 4));
		assertEquals(true, graph.existEdge(num1, num2));
		assertEquals(-1, graph.addEdge(num3, num2, 4));
		assertEquals(-2, graph.addEdge(num1, num3, 4));
		assertEquals(-3, graph.addEdge(num3, num3, 4));
		assertEquals(-8, graph.addEdge(num2, num4, -6876));
		assertEquals(-4, graph.addEdge(num1, num2, 4));
	}

	// Borra una arista del grafo que conecta dos nodos. Devuelve 1, 2 y 3 si no
	// existe nodos origen, destino o ambos respectivamente. Devuelve 4 si no existe
	// la arista. Devuelve 0 si la borra
	@Test
	void removeEdge() {
		graph = new Graph<Integer>(4);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		Integer num4 = 4;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num4));
		assertEquals(0, graph.addEdge(num1, num2, 4));
		assertEquals(0, graph.removeEdge(num1, num2));
		assertEquals(-1, graph.removeEdge(num3, num2));
		assertEquals(-2, graph.removeEdge(num1, num3));
		assertEquals(-3, graph.removeEdge(num3, num3));
		assertEquals(-4, graph.removeEdge(num2, num1));
	}

	@Test
	//Borra un nodo. Si lo consigue devuelve 0, sino -1.
	void removeNode() {
		graph = new Graph<Integer>(4);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		Integer num4 = 4;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num4));
		assertEquals(0, graph.removeNode(num2));
		assertEquals(-1, graph.removeNode(num3));
	}

	@Test
	//Test para dijkstra desde nodo num1
	void dijkstra1() {
		graph = new Graph<Integer>(6);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		Integer num4 = 4;
		Integer num5 = 5;
		Integer num6 = 6;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num3));
		assertEquals(0, graph.addNode(num4));
		assertEquals(0, graph.addNode(num5));// vamos a crear el grafo de la p�gina 59
		assertEquals(0, graph.addNode(num6));
		assertEquals(0, graph.addEdge(num1, num2, 1));
		assertEquals(0, graph.addEdge(num1, num5, 10));
		assertEquals(0, graph.addEdge(num1, num4, 3));
		assertEquals(0, graph.addEdge(num2, num3, 5));
		assertEquals(0, graph.addEdge(num3, num5, 1));
		assertEquals(0, graph.addEdge(num4, num3, 2));
		assertEquals(0, graph.addEdge(num4, num5, 6));
		double[] costes = { 0, 1, 5, 3, 6, Double.POSITIVE_INFINITY };
		Assert.assertArrayEquals(costes, graph.dijkstra(num1), 0.0);
	}

	@Test
	//Test para dijkstra desde nodo num1
	void dijkstra2() {
		graph = new Graph<Integer>(6);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		Integer num4 = 4;
		Integer num5 = 5;
		Integer num6 = 6;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num3));
		assertEquals(0, graph.addNode(num4));
		assertEquals(0, graph.addNode(num5));// vamos a crear el grafo de la p�gina 62
		assertEquals(0, graph.addNode(num6));
		assertEquals(0, graph.addEdge(num1, num3, 4));
		assertEquals(0, graph.addEdge(num1, num5, 8));
		assertEquals(0, graph.addEdge(num1, num2, 3));
		assertEquals(0, graph.addEdge(num2, num5, 5));
		assertEquals(0, graph.addEdge(num3, num5, 3));
		assertEquals(0, graph.addEdge(num5, num4, 7));
		assertEquals(0, graph.addEdge(num5, num6, 3));
		assertEquals(0, graph.addEdge(num6, num4, 2));
		double[] costes = { 0, 3, 4, 12, 7, 10 };
		Assert.assertArrayEquals(costes, graph.dijkstra(num1), 0.0);
	}

	@Test
	//Test para dijkstra desde nodo num1
	void dijkstra3() {
		graph = new Graph<Integer>(5);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		Integer num4 = 4;
		Integer num5 = 5;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num3));
		assertEquals(0, graph.addNode(num4));
		assertEquals(0, graph.addNode(num5));// vamos a crear el grafo de seminario
		assertEquals(0, graph.addEdge(num1, num2, 10));
		assertEquals(0, graph.addEdge(num1, num4, 30));
		assertEquals(0, graph.addEdge(num1, num5, 100));
		assertEquals(0, graph.addEdge(num2, num3, 50));
		assertEquals(0, graph.addEdge(num3, num5, 10));
		assertEquals(0, graph.addEdge(num4, num3, 20));
		assertEquals(0, graph.addEdge(num4, num5, 60));
		double[] costes = { 0, 10, 50, 30, 60 };
		Assert.assertArrayEquals(costes, graph.dijkstra(num1), 0.0);
	}

	@Test
	//Test para floyd con nodos Integer
	void floyd1() {
		graph = new Graph<Integer>(5);
		Integer num1 = 1;
		Integer num2 = 2;
		Integer num3 = 3;
		Integer num4 = 4;
		Integer num5 = 5;
		assertEquals(0, graph.addNode(num1));
		assertEquals(0, graph.addNode(num2));
		assertEquals(0, graph.addNode(num3));
		assertEquals(0, graph.addNode(num4));
		assertEquals(0, graph.addNode(num5));
		assertEquals(0, graph.addEdge(num1, num2, 1));
		assertEquals(0, graph.addEdge(num1, num4, 3));
		assertEquals(0, graph.addEdge(num1, num5, 10));
		assertEquals(0, graph.addEdge(num2, num3, 5));
		assertEquals(0, graph.addEdge(num3, num5, 1));
		assertEquals(0, graph.addEdge(num4, num3, 2));
		assertEquals(0, graph.addEdge(num4, num5, 6));
		double[][] costes = { { 0, 1, 5, 3, 6 }, { Double.POSITIVE_INFINITY, 0, 5, Double.POSITIVE_INFINITY, 6 },
				{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, 1 },
				{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 2, 0, 3 }, { Double.POSITIVE_INFINITY,
						Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0 } };
		graph.floyd();
		Assert.assertArrayEquals(costes, graph.getFloydA());

		Integer[][] caminos = { { null, null, 4, null, 4 }, { null, null, null, null, 3 },
				{ null, null, null, null, null }, { null, null, null, null, 3 }, { null, null, null, null, null } };
		Assert.assertArrayEquals(caminos, graph.getFloydP());
	}

	@Test
	//Test para floyd con nodos String
	void floyd2() {
		Graph<String> graph = new Graph<String>(5);
		assertEquals(0, graph.addNode("A"));
		assertEquals(0, graph.addNode("B"));
		assertEquals(0, graph.addNode("C"));
		assertEquals(0, graph.addNode("D"));
		assertEquals(0, graph.addNode("E"));
		assertEquals(0, graph.addEdge("A", "B", 5));
		assertEquals(0, graph.addEdge("B", "D", 3));
		assertEquals(0, graph.addEdge("D", "A", 6));
		assertEquals(0, graph.addEdge("D", "E", 4));
		assertEquals(0, graph.addEdge("A", "C", 1));
		assertEquals(0, graph.addEdge("C", "E", 2));
		double[][] costes = { { 0, 5, 1, 8, 3 }, { 9, 0, 10, 3, 7 },
				{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, 2 },
				{ 6, 11, 7, 0, 4 }, { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
						Double.POSITIVE_INFINITY, 0 } };
		graph.floyd();
		Assert.assertArrayEquals(costes, graph.getFloydA());

		String[][] caminos = { { null, null, null, "B", "C" }, { "D", null, "D", null, "D" },
				{ null, null, null, null, null }, { null, "A", "A", null, null }, { null, null, null, null, null } };
		Assert.assertArrayEquals(caminos, graph.getFloydP());
	}

	@Test
	//Test para el path desde el nodo 1 al 5
	public void path1() {
		Graph<Integer> graph = new Graph<Integer>(6);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addEdge(1, 5, 8);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 4);
		graph.addEdge(3, 5, 3);
		graph.addEdge(2, 5, 5);
		graph.addEdge(5, 4, 7);
		graph.addEdge(5, 6, 3);
		graph.addEdge(6, 4, 2);
		assertEquals("1	(4.0)	3	(3.0)	5", graph.path(1, 5));
	}
	
	@Test
	//Test para el path con un grafo de nodos String desde B a C
	public void path2() {
		Graph<String> graph = new Graph<String>(5);
		assertEquals(0, graph.addNode("A"));
		assertEquals(0, graph.addNode("B"));
		assertEquals(0, graph.addNode("C"));
		assertEquals(0, graph.addNode("D"));
		assertEquals(0, graph.addNode("E"));
		assertEquals(0, graph.addEdge("A", "B", 5));
		assertEquals(0, graph.addEdge("B", "D", 3));
		assertEquals(0, graph.addEdge("D", "A", 6));
		assertEquals(0, graph.addEdge("D", "E", 4));
		assertEquals(0, graph.addEdge("A", "C", 1));
		assertEquals(0, graph.addEdge("C", "E", 2));
		assertEquals("B	(3.0)	D	(6.0)	A	(1.0)	C", graph.path("B", "C"));
	}

	@Test
	//Test para el recorrido en Profundidad desde el nodo 1
	public void recorridoProfundidad1() {
		Graph<Integer> graph = new Graph<Integer>(6);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 4, 3);
		graph.addEdge(4, 4, 5);
		graph.addEdge(4, 3, 6);
		graph.addEdge(3, 2, 4);
		assertEquals("1\t2\t4\t3\t", graph.recorridoProfundidad(1));
	}

	@Test
	//Test para el recorrido en Profundidad desde el nodo 2
	public void recorridoProfundidad2() {
		Graph<Integer> graph = new Graph<Integer>(6);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 4, 3);
		graph.addEdge(4, 4, 5);
		graph.addEdge(4, 3, 6);
		graph.addEdge(3, 2, 4);
		assertEquals("2\t4\t3\t", graph.recorridoProfundidad(2));
	}

	//Test para el recorrido en Profundidad desde el nodo 1
	@Test
	public void recorridoProfundidad3() {
		Graph<Integer> graph = new Graph<Integer>(11);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addNode(7);
		graph.addNode(8);
		graph.addNode(9);
		graph.addNode(10);
		graph.addNode(11);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 6, 1);
		graph.addEdge(1, 8, 1);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 4, 1);
		graph.addEdge(3, 5, 1);
		graph.addEdge(6, 7, 1);
		graph.addEdge(8, 9, 1);
		graph.addEdge(8, 10, 1);
		graph.addEdge(10, 11, 1);
		assertEquals("1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t", graph.recorridoProfundidad(1));
	}

	@Test
	//Test para el recorrido en Profundidad de un grafo con nodos String desde el nodo A
	public void recorridoProfundidad4() {
		Graph<String> graph = new Graph<String>(8);
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addNode("E");
		graph.addNode("F");
		graph.addNode("G");
		graph.addNode("H");
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "C", 1);
		graph.addEdge("A", "E", 1);
		graph.addEdge("B", "F", 1);
		graph.addEdge("C", "F", 1);
		graph.addEdge("C", "G", 1);
		graph.addEdge("F", "G", 1);
		graph.addEdge("G", "H", 1);
		assertEquals("A	B	F	G	H	C	E	", graph.recorridoProfundidad("A"));
	}

	//-------------------------------------
	@Test
	public void testContarSumideros() {
		Graph<Integer> graph = new Graph<Integer>(6);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addEdge(1, 5, 8);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 4);
		graph.addEdge(3, 5, 3);
		graph.addEdge(2, 5, 5);
		graph.addEdge(5, 4, 7);
		graph.addEdge(5, 6, 3);
		graph.addEdge(6, 4, 2);
		assertEquals(1, graph.contarSumideros());
	}
	
	@Test
	public void testContarFuentes() {
		Graph<Integer> graph = new Graph<Integer>(6);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addEdge(1, 5, 8);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 4);
		graph.addEdge(3, 5, 3);
		graph.addEdge(2, 5, 5);
		graph.addEdge(5, 4, 7);
		graph.addEdge(5, 6, 3);
		graph.addEdge(6, 4, 2);
		assertEquals(1, graph.contarFuentes());
	}
	
	@Test
	public void testContarInaccesibles() {
		Graph<Integer> graph = new Graph<Integer>(6);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addEdge(1, 5, 8);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 4);
		graph.addEdge(3, 5, 3);
		graph.addEdge(2, 5, 5);
		graph.addEdge(5, 4, 7);
		graph.addEdge(5, 6, 3);
		graph.addEdge(6, 4, 2);
		assertEquals(1, graph.contarInaccesibles());
	}
	
	@Test
	public void testContarAislados() {
		Graph<Integer> graph = new Graph<Integer>(6);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addEdge(1, 5, 8);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 4);
		graph.addEdge(3, 5, 3);
		graph.addEdge(2, 5, 5);
		graph.addEdge(5, 4, 7);
		graph.addEdge(5, 6, 3);
		graph.addEdge(6, 4, 2);
		assertEquals(0, graph.contarAislados());
	}
	
	@Test
	public void testAveriguaCentro() {
		Graph<Integer> graph = new Graph<Integer>(5);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 2);
		graph.addEdge(3, 4, 2);
		graph.addEdge(3, 5, 4);
		graph.addEdge(4, 3, 3);
		graph.addEdge(4, 2, 1);
		graph.addEdge(5, 4, 5);
		assertEquals(4, graph.averiguaCentro());
	}
	
	@Test
	public void testAveriguaCentro2() {
		Graph<Integer> g = new Graph<Integer>(7);
        int v1 = 1;
        int v2 = 2;
        int v3 = 3;
        int v4 = 4;
        int v5 = 5;
        int v6 = 6;
        int v7 = 7;
        //A�adir los nodos
        assertEquals(0, g.addNode(v1));
        assertEquals(0, g.addNode(v2));
        assertEquals(0, g.addNode(v3));
        assertEquals(0, g.addNode(v4));
        assertEquals(0, g.addNode(v5));
        assertEquals(0, g.addNode(v6));
        assertEquals(0, g.addNode(v7));
        //A�adir las aristas
        assertEquals(0, g.addEdge(v1, v2, 3));
        assertEquals(0, g.addEdge(v1, v3, 4));
        assertEquals(0, g.addEdge(v1, v5, 8));
        assertEquals(0, g.addEdge(v2, v5, 5));
        assertEquals(0, g.addEdge(v3, v5, 3));
        assertEquals(0, g.addEdge(v5, v4, 7));
        assertEquals(0, g.addEdge(v5, v6, 3));
        assertEquals(0, g.addEdge(v6, v4, 2));

        assertEquals(null, g.averiguaCentro());

        
	}
}
