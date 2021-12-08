package logica;

public class Pedido {
	
	String title;
	double price;
	int units;
	String ISBN;
	
	public Pedido(String title, double price, int units, String ISBN) {
		super();
		this.title = title;
		this.price = price;
		this.units = units;
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public int getUnits() {
		return units;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Pedido [title=" + title + ", price=" + price + ", units="
				+ units + "]";
	}
	
	
	
	
	

}
