package logica;

public class Tablero {
	public static final int DIM = 9;
	public static final int POSICION_META = DIM -1;
	public static final int OCAINICIO = 2;
	public static final int OCAFIN = 5;

	private Casilla[] casillas = new Casilla[DIM];

	public Tablero () {
		for (int i = 0; i < DIM; i++) {
			casillas[i] = new Casilla();
		}
		casillas[OCAINICIO].setValor(casillas[OCAINICIO].getValor() + 200);
	}

	public int puntosCasilla(int posicion) {
		return casillas[posicion].getValor();
	}
	
	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}
}
