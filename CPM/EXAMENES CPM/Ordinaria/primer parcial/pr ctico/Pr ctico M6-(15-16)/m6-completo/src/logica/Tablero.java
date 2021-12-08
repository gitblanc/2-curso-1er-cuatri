package logica;

public class Tablero {
	public static final int DIM = 9;
	public static final int POSICION_META = DIM -1;
	public static int SKATE = 0;

	private Casilla[] casillas = new Casilla[DIM];

	public Tablero () {
		for (int i = 0; i < DIM; i++) {
			casillas[i] = new Casilla();
		}
		SKATE = (int) (Math.random() * (DIM-2)) + 1;
		casillas[SKATE].setValor(casillas[SKATE].getValor() + 200);
	}

	public int puntosCasilla(int posicion) {
		return casillas[posicion].getValor();
	}
	
	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}
}
