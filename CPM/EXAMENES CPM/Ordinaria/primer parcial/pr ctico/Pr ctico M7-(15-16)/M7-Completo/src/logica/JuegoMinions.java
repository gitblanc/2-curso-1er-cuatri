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
		bananasTotal = 0;
		posicionMinion = 0;
		numeroDado = 0;
		finalizada = false;
		tablero = new Tablero();
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
    	numeroDado = Dado.lanzar();
    	if (posicionMinion + numeroDado < Tablero.DIM)
    		isPosible = true;	 
    	return isPosible;
    }
    
     
    public boolean isJugadaCorrecta(int y){
		boolean isCorrecta = false;
		if (posicionMinion + numeroDado == y)
			isCorrecta = true;		
		return isCorrecta;
	} 
	
    public boolean resolverJugada(int i){
    	boolean resuelta = false;
    	if (isJugadaCorrecta(i)){
    		posicionMinion = posicionMinion + numeroDado;
    		if(hayEnemigo(posicionMinion)){
    			bananasTotal = bananasTotal / 2;}
    		else
    			bananasTotal = bananasTotal + tablero.puntosCasilla(posicionMinion);
    		resuelta = true;
    	}
    	return resuelta;
    }
	public boolean isPartidaFinalizada(){
		finalizada = false;
		if  (posicionMinion == Tablero.POSICION_META)
			finalizada = true;
		return finalizada;
	}
	
	public boolean hayEnemigo(int posicion) {
		return tablero.getCasilla(posicion).isEnemigo();
	}
}

