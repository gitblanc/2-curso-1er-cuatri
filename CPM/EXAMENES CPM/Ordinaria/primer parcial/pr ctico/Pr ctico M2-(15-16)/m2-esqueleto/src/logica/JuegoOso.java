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
//		puntosJugador =;
//		posicionOso =;
//		numeroDado =;
//		finalizada = ;
//		tablero = 
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
//    	numeroDado = ;
//    	if ()
    		isPosible = true;	 
    	return isPosible;
    }
    
     
    public boolean isJugadaCorrecta(int y){
		boolean isCorrecta = false;
//		if ()
			isCorrecta = true;		
		return isCorrecta;
	} 
	
    public boolean resolverJugada(int i){
    	boolean resuelta = false;
 //   	if (){
 //   		posicionOso = ;
 //   		puntosJugador = puntosJugador + ;
    		resuelta = true;
 //   	}
    	return resuelta;
    }

    	public boolean isPartidaFinalizada(){
		finalizada = false;
//		if  ()
			finalizada = true;
		return finalizada;
	}
}

