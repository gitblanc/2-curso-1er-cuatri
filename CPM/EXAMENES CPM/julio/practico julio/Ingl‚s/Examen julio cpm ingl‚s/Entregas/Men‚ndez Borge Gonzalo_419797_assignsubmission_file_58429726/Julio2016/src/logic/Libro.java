package logic;

import java.math.BigDecimal;

public class Libro {
	
	private String ISBN;
	private String título;
	private String editorial;
	private String autor;
	private String genero;
	private String resumen;
	private BigDecimal precio;
	
	public Libro(String iSBN, String título, String editorial, String autor, String genero, String resumen, BigDecimal precio) {
		ISBN = iSBN;
		this.título = título;
		this.editorial = editorial;
		this.autor = autor;
		this.genero = genero;
		this.resumen = resumen;
		this.precio = precio;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTítulo() {
		return título;
	}

	public String getEditorial() {
		return editorial;
	}

	public String getAutor() {
		return autor;
	}

	public String getGenero() {
		return genero;
	}

	public String getResumen() {
		return resumen;
	}

	public BigDecimal getPrecio() {
		return precio;
	}
	
	@Override
	public String toString() {
		return título;
	}
}
