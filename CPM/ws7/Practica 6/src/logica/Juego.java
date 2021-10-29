package logica;

public class Juego {
	
	public static final int maxDisparos = 4;
	int puntos;
	int disparos;
	private Tablero tablero; 
	private boolean invasorEncontrado;
	private boolean meteoritoEncontrado;
	
	
	public Juego(){
		inicializarJuego();
	}
	
	public void inicializarJuego(){
		tablero = new Tablero();
		puntos = 1000;
		disparos = 0;
		invasorEncontrado = false;
		meteoritoEncontrado = false;
	}

	public Tablero getTablero() {
		return tablero;
	}
	
	public void dispara(int i){
		disparos --;
		if (tablero.getCasillas()[i] instanceof Invasor) {
			invasorEncontrado = true;
		}else if(tablero.getCasillas()[i] instanceof Meteorito) {
			puntos = 0;
			setMeteoritoEncontrado(true);
		}
		puntos += tablero.getCasillas()[i].getPuntos();
	}
	
	public boolean isPartidaFinalizada() {
		return (invasorEncontrado || meteoritoEncontrado || disparos == 0);
	}

	public int getPuntos() {
		return puntos;
	}

	public void lanzar() {
		setDisparos(Dado.lanzar());	
	}
	
	public int getDisparos() {
		return disparos;
	}

	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}

	public boolean isMeteoritoEncontrado() {
		return meteoritoEncontrado;
	}
	
	public boolean isInvasorEncontrado() {
		return invasorEncontrado;
	}

	public void setMeteoritoEncontrado(boolean meteoritoEncontrado) {
		this.meteoritoEncontrado = meteoritoEncontrado;
	}
}
