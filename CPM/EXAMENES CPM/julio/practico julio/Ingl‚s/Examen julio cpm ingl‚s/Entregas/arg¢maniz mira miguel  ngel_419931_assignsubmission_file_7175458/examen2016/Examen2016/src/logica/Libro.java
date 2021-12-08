package logica;

public class Libro {

	private String isbn;
	private String titulo;
	private String editor;
	private String autor;
	private String tipo;
	private String resumen;
	private double precio;
	private int unidades;
	
	public Libro(String isbn, String titulo, String editor, String autor,
			String tipo, String resumen, double precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editor = editor;
		this.autor = autor;
		this.tipo = tipo;
		this.resumen = resumen;
		this.precio = precio;
		this.unidades = 0;
	}

	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getEditor() {
		return editor;
	}
	public String getAutor() {
		return autor;
	}
	public String getTipo() {
		return tipo;
	}
	public String getResumen() {
		return resumen;
	}
	public double getPrecio() {
		return precio;
	}	
}
