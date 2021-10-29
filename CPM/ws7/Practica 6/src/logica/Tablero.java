package logica;


public class Tablero {

	public static final int DIM = 8;
	Casilla[] casillas;

	public Tablero() {
		casillas = new Casilla[DIM];
		for (int i = 0; i < DIM; i++)
			casillas[i] = new Espacio();
		colocaInvasor();
	}

	private void colocaInvasor() {
		int posicionInvasor = (int) (Math.random() * DIM);
		int posicionMeteorito = (int) (Math.random() * DIM);
		System.out.println("Invasor en: " + posicionInvasor);
		System.out.println("Meteorito en: " + posicionMeteorito);
		casillas[posicionInvasor] = new Invasor();
		casillas[posicionMeteorito] = new Meteorito();
	}

	public Casilla[] getCasillas() {
		return casillas;
	}
}
