package logica;

public class LibroCompra {
	private Libro libro;
	private int cantidad;

	public LibroCompra(Libro libro, int cantidad) {
		this.libro = libro;
		this.cantidad = cantidad;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void suma(int val) {
		cantidad = cantidad + val;

	}

	public void resta(int val) {
		cantidad = cantidad - val;
	}
	
	@Override
	public String toString() {
		return cantidad + " " + libro.getTitulo() + " / " + libro.getPrecio() + "€";
	}
}
