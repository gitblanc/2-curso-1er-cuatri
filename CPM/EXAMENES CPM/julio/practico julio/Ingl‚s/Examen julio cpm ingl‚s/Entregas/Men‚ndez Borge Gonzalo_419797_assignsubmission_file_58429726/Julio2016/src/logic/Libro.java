package logic;

import java.math.BigDecimal;

public class Libro {
	
	private String ISBN;
	private String t�tulo;
	private String editorial;
	private String autor;
	private String genero;
	private String resumen;
	private BigDecimal precio;
	
	public Libro(String iSBN, String t�tulo, String editorial, String autor, String genero, String resumen, BigDecimal precio) {
		ISBN = iSBN;
		this.t�tulo = t�tulo;
		this.editorial = editorial;
		this.autor = autor;
		this.genero = genero;
		this.resumen = resumen;
		this.precio = precio;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getT�tulo() {
		return t�tulo;
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
		return t�tulo;
	}
}
