package logica;


public class JuegoMinions {
	private Tablero tablero;
	private int posicionMinion;
	private int bananasTotal;
	private int numeroDado;
	private boolean finalizada;
	

	public JuegoMinions() {
		inicializarJuego();
	}

	public void inicializarJuego(){
//		bananasTotal = ;
//		posicionMinion = ;
//		numeroDado = ;
//		finalizada = ;
//		tablero = ;
	}
	
 
	public int getTotalBananas(){
		return bananasTotal;
	}

	public int getPosicionMinion(){
		return posicionMinion;
	}
	
	public int getNumeroDado() {
		return numeroDado;
	}
    public boolean lanzarDado(){
    	boolean isPosible = false;
 //   	numeroDado = ;
//    	if ()
    		isPosible = true;	 
    	return isPosible;
    }
    
     
    public boolean isJugadaCorrecta(int y){
		boolean isCorrecta = false;
//		if ()
//			isCorrecta = true;		
		return isCorrecta;
	} 
	
//    public boolean resolverJugada(int i){
//    	boolean resuelta = false;
//    	if (){
//    		posicionMinion = ;
//    		
//    		resuelta = true;
//    	}
//   	return resuelta;
//    }
    
	public boolean isPartidaFinalizada(){
		finalizada = false;
//		if  ()
			finalizada = true;
		return finalizada;
	}
	
}

