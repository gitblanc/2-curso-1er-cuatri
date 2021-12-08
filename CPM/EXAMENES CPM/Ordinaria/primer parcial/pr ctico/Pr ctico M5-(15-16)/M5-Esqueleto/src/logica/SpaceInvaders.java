package logica;


public class SpaceInvaders {
	private Tablero tablero;
	private int posicionNave;
	private int puntos;
	private int numeroDado;
	private boolean finalizada;
	

	public SpaceInvaders() {
		inicializarJuego();
	}

	public void inicializarJuego(){
//		puntos =;
//		posicionNave = ;
//		numeroDado = ;
//		finalizada = ;
//		tablero = ;
	}
	
 
	public int getPuntos(){
		return puntos;
	}

	public int getPosicionNave(){
		return posicionNave;
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
//    	if ( ){
//    		
//
//    		}
    		resuelta = true;
//    	}
    	return resuelta;
    }

    	public boolean isPartidaFinalizada(){
		finalizada = false;
//		if  ()
			finalizada = true;
		return finalizada;
	}
}

