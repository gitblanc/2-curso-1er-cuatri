package logica;


public class DonkeyKongGame {
	private Tablero tablero;
	private int posMario;
	private int puntosJugador;
	private int numeroDado;
	private boolean finalizada;
	

	public DonkeyKongGame() {
		inicializarJuego();
	}

	public void inicializarJuego(){
//		puntosJugador = ;
//		posMario = ;
//		numeroDado =;
//		finalizada =;
//		tablero = 
	}
	
 
	public int getPuntosJugador(){
		return puntosJugador;
	}

	public int getPosicionFicha(){
		return posMario;
	}
	
	public int getNumeroDado() {
		return numeroDado;
	}
    public boolean lanzarDado(){
    	boolean isPosible = false;
  //  	numeroDado = ;
  //  	if ( )
    		isPosible = true;	 
    	return isPosible;
    }
    
     
    public boolean isJugadaCorrecta(int y){
		boolean isCorrecta = false;
//		if ( )
			isCorrecta = true;		
		return isCorrecta;
	} 
	
    public boolean resolverJugada(int i){
    	boolean resuelta = false;
 //   	if (){
 //   		posFicha = ;
    		puntosJugador = puntosJugador + tablero.puntosCasilla(posMario);
 //   		if()
 //  			
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

