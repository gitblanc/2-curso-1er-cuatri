package logica;

import java.util.ArrayList;
import java.util.List;

public class FiltraLibros {

	private List<Libro> libros;
	private List<Libro> librosFiltrados;
	private Fichero archivo;

	public FiltraLibros() {
		this.libros = new ArrayList<Libro>();
		this.librosFiltrados = new ArrayList<Libro>();
		this.archivo = new Fichero();
	}

	public List<Libro> getLibros() {
		libros = archivo.getLibros();
		return libros;
	}

	public List<Libro> getLibrosFiltrados(double minPrecio, double maxPrecio) {
		libros = getLibros();
		if (libros != null) {
			for (Libro libro : libros) {
				if (libro.getPrecio() >= minPrecio
						&& libro.getPrecio() <= maxPrecio) {
					librosFiltrados.add(libro);
				}
			}
		}
		return librosFiltrados;
	}
}
