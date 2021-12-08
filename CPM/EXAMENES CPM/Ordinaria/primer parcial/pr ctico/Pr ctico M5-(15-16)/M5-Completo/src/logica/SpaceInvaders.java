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
		puntos = 0;
		posicionNave = 0;
		numeroDado = 0;
		finalizada = false;
		tablero = new Tablero();
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
    	numeroDado = Dado.lanzar();
    	if (posicionNave + numeroDado < Tablero.DIM)
    		isPosible = true;	 
    	return isPosible;
    }
    
     
    public boolean isJugadaCorrecta(int y){
		boolean isCorrecta = false;
		if (posicionNave + numeroDado == y)
			isCorrecta = true;		
		return isCorrecta;
	} 
	
    public boolean resolverJugada(int i){
    	boolean resuelta = false;
    	if (isJugadaCorrecta(i)){
    		posicionNave = posicionNave + numeroDado;
    		puntos = puntos+tablero.puntosCasilla(posicionNave);
    		if(hayEnemigo(posicionNave)){
    			puntos += 500;
    			tablero.getCasilla(posicionNave).quitarEnemigo();	
    		}
    		resuelta = true;
    	}
    	return resuelta;
    }
	public boolean isPartidaFinalizada(){
		finalizada = false;
		if  (posicionNave == Tablero.POSICION_META)
			finalizada = true;
		return finalizada;
	}
	
	public boolean hayEnemigo(int posicion) {
		return tablero.getCasilla(posicion).isEnemigo();
	}
}

