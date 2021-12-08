package logica;

public class Casilla {
	private int valor;
	
	private boolean enjambre = false;
	
	public Casilla() {
		setValor (60);
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void ponerEnjambre() {
		enjambre = true;
	}
	public boolean isEnjambre() {
		return enjambre;
	}
}
