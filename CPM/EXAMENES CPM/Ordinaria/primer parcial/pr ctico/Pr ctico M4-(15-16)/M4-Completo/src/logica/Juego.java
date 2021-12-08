package logica;

import javax.swing.JOptionPane;


public class Juego {
	private final int DIM = 9;
	private final int VALORDADO = 4;
	private final int META = 8;
	private final int SALIDA = 0;
	private int posFantasma=-1;
	private final int VALOR = 70;
	private int[] tableroJuego = new int[DIM];
	private int posFicha ;
	private int puntosJugador;
	private int numeroDado;
	
	private boolean finalizada;
	

	

	public Juego() {
		inicializarJuego();
	}

	public void inicializarJuego(){
		puntosJugador = 0;
		posFicha = 0;
		numeroDado = 0;
		finalizada = false;
		posFantasma = 5;
		generarTablero();
	}
	
	private void generarTablero() {
		tableroJuego[0] = SALIDA;
		for (int i=1; i<DIM; i++){
		  tableroJuego[i] = VALOR;
		 }
	
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
    	numeroDado = (int) (Math.random() * VALORDADO) + 1;
    	if (posFicha + numeroDado < DIM)
    		isPosible = true;	 
    	return isPosible;
    }
    
    private void mueveFantasma()
    {
    	posFantasma = (int) (Math.random() * DIM-2) + 1;
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
    		puntosJugador = puntosJugador + tableroJuego[posFicha];
    		mueveFantasma();
    		
    		
    		
    		resuelta = true;
    	}
    	return resuelta;
    }
	public boolean isPartidaFinalizada(){
		finalizada = false;
		if  (posFicha == META)
			finalizada = true;
		
		if ( posFicha == posFantasma )
		{
			//Game over
			this.finalizada = true;
		}
		
		return finalizada;
	}

	public int getPosicionFantasma() {
		// TODO Auto-generated method stub
		return posFantasma;
	}
}

