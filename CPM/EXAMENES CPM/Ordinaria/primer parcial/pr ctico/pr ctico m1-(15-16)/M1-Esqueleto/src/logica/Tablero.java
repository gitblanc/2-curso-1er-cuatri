package logica;

public class Tablero {
	public static final int DIM = 0;
	public static final int POSICION_META = 0;
	public static final int OCAINICIO = 0;
	public static final int OCAFIN = 0;

	private Casilla[] casillas = new Casilla[DIM];

	public Tablero () {
		for (int i = 0; i < DIM; i++) {
			
		}

	}

	public int puntosCasilla(int posicion) {
		return casillas[posicion].getValor();
	}
	
	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}
}
