package logica;

public class Compra {

	long ISBN;
	String titulo;
	int units;
	double price;
	
	public Compra(long iSBN, String titulo, int units, double price) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.units = units;
		this.price = price;
	}
	
	public long getISBN() {
		return ISBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getUnits() {
		return units;
	}
	public double getPrice() {
		return price;
	}
	
	public void setUnits(int units){
		this.units = units;
	}
	
	public String toString(){
		return titulo + " x" + units + " / " + price + "€ per unit";
	}
	
	
}
