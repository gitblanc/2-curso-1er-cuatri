package logica;

public class Pedido {
	String isbn;
	String title;
	double price;
	int units;
	
	public Pedido(String i, String t, double p, int u){
		this.isbn = i;
		this.title = t;
		this.price = p;
		this.units = u;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
	

}
