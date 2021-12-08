package logica;

public class Tablero {
	public static final int DIM = 10;
	public static final int POSICION_META = DIM -1;

	private Casilla[] casillas = new Casilla[DIM];

	public Tablero () {
		for (int i = 0; i < DIM; i++) {
			casillas[i] = new Casilla();
		}
		int posicion = (int) (Math.random() * (DIM-2) + 1);
		casillas[posicion].ponerEnemigo();
	}

	public int puntosCasilla(int posicion) {
		return casillas[posicion].getValor();
	}
	
	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}
}
