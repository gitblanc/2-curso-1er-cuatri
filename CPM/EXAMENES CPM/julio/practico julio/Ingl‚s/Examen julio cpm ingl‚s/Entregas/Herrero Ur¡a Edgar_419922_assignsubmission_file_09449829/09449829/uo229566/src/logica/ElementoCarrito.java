package logica;

public class ElementoCarrito {

	long ISBN;
	String title;
	double price;
	int unidades;

	public ElementoCarrito(long ISBN, String title, double price, int unidades) {
		this.ISBN = ISBN;
		this.title = title;
		this.price = price;
		this.unidades = unidades;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
