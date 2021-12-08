package logica;

public class Casilla {
	private int valor;
	
	private boolean enemigo = false;
	
	public Casilla() {
		setValor (6);
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void ponerEnemigo() {
		enemigo = true;
	}
	public boolean isEnemigo() {
		return enemigo;
	}
}
