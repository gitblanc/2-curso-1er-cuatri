package logica;

public class Libro {

	private String ISBN;
	private String titulo;
	private String editorial;
	private String autor;
	private String genero;
	private String resumen;
	private double precio;

	public Libro(String ISBN, String titulo, String editorial, String autor, String genero, String resumen,
			double precio) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.editorial = editorial;
		this.autor = autor;
		this.genero = genero;
		this.resumen = resumen;
		this.precio = precio;
	}

	public String getCodigo() {
		return ISBN;
	}

	public void setCodigo(String codigo) {
		this.ISBN = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return titulo + " / " + autor;
	}
	
	

}
