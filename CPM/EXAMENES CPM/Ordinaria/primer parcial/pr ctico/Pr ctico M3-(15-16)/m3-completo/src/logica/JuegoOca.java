package logica;


public class JuegoOca {
	private Tablero tablero;
	private int posFicha;
	private int puntosJugador;
	private int numeroDado;
	private boolean finalizada;
	

	public JuegoOca() {
		inicializarJuego();
	}

	public void inicializarJuego(){
		puntosJugador = 0;
		posFicha = 0;
		numeroDado = 0;
		finalizada = false;
		tablero = new Tablero();
	}
	
 
	public int getPuntosJugador(){
		return puntosJugador;
	}

	public int getPosicionFicha(){
		return posFicha;
	}
	
	public int getNumeroDado() {
		return numeroDado;
	}
    public boolean lanzarDado(){
    	boolean isPosible = false;
    	numeroDado = Dado.lanzar();
    	if (posFicha + numeroDado < Tablero.DIM)
    		isPosible = true;	 
    	return isPosible;
    }
    
     
    public boolean isJugadaCorrecta(int y){
		boolean isCorrecta = false;
		if (posFicha + numeroDado == y)
			isCorrecta = true;		
		return isCorrecta;
	} 
	
    public boolean resolverJugada(int i){
    	boolean resuelta = false;
    	if (isJugadaCorrecta(i)){
    		posFicha = posFicha + numeroDado;
    		puntosJugador = puntosJugador + tablero.puntosCasilla(posFicha);
    		if(posFicha == Tablero.OCAINICIO)
    			posFicha = Tablero.OCAFIN;
    		resuelta = true;
    	}
    	return resuelta;
    }
	public boolean isPartidaFinalizada(){
		finalizada = false;
		if  (posFicha == Tablero.POSICION_META)
			finalizada = true;
		return finalizada;
	}
}

