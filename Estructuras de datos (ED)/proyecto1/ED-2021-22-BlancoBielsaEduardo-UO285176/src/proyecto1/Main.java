/**
 * 
 */
package proyecto1;

import java.io.IOException;

/**
 * @author blanc
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestBench.test("linealdoNothing.csv",1, 40, 5, "proyecto1.Algoritmos", "linealdoNothing" );
			TestBench.test("cuadraticadoNothing.csv",1, 40, 5, "proyecto1.Algoritmos", "cuadraticaNothing" );
			TestBench.test("cubicadoNothing.csv",1, 10, 5, "proyecto1.Algoritmos", "cubicaNothing" );
			TestBench.test("logaritmicadoNothing.csv",1, 10, 5, "proyecto1.Algoritmos", "logaritmicadoNothing" );
			TestBench.test("potenciav02.csv",1, 10, 5, "proyecto1.Algoritmos", "potenciaRecursiva_v0doNothing" );
			TestBench.test("potenciav12.csv",1, 10, 5, "proyecto1.Algoritmos", "potenciaRecursiva_v1doNothing" );
			TestBench.test("potenciav22.csv",1, 10, 5, "proyecto1.Algoritmos", "potenciaRecursiva_v2doNothing" );
			TestBench.test("potenciav32.csv",1, 10, 5, "proyecto1.Algoritmos", "potenciaRecursiva_v3doNothing" );
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}
