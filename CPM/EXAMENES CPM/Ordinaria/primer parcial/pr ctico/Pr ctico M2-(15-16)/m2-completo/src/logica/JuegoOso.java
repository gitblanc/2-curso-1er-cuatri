package logica;


public class JuegoOso {
	private Tablero tablero;
	private int posicionOso;
	private int puntosJugador;
	private int numeroDado;
	private boolean finalizada;
	

	public JuegoOso() {
		inicializarJuego();
	}

	public void inicializarJuego(){
		puntosJugador = 0;
		posicionOso = 0;
		numeroDado = 0;
		finalizada = false;
		tablero = new Tablero();
	}
	
 
	public int getPuntosJugador(){
		return puntosJugador;
	}

	public int getPosicionOso(){
		return posicionOso;
	}
	
	public int getNumeroDado() {
		return numeroDado;
	}
    public boolean lanzarDado(){
    	boolean isPosible = false;
    	numeroDado = Dado.lanzar();
    	if (posicionOso + numeroDado < Tablero.DIM)
    		isPosible = true;	 
    	return isPosible;
    }
    
     
    public boolean isJugadaCorrecta(int y){
		boolean isCorrecta = false;
		if (posicionOso + numeroDado == y)
			isCorrecta = true;		
		return isCorrecta;
	} 
	
    public boolean resolverJugada(int i){
    	boolean resuelta = false;
    	if (isJugadaCorrecta(i)){
    		posicionOso = posicionOso + numeroDado;
    		if(hayEnjambre(posicionOso)){
    			posicionOso = 0;
    			puntosJugador = puntosJugador - 10;}
    		else
    			puntosJugador = puntosJugador + tablero.puntosCasilla(posicionOso);
    		resuelta = true;
    	}
    	return resuelta;
    }
	public boolean isPartidaFinalizada(){
		finalizada = false;
		if  (posicionOso == Tablero.POSICION_META)
			finalizada = true;
		return finalizada;
	}
	
	public boolean hayEnjambre(int posicion) {
		return tablero.getCasilla(posicionOso).isEnjambre();
	}
}

