package logic;

public class Articulo 
{
	public String ISBN;
	public String titulo;
	public String editor;
	
	public String autor;
	public String gen;
	public String descripcion;
	public float price;
	
	
	public Articulo(String iSBN, String titulo,String editor, String autor, String gen,
			String descripcion, float price) 
	{
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.editor=editor;
		this.autor = autor;
		this.gen = gen;
		this.descripcion = descripcion;
		this.price = price;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String id) {
		this.ISBN = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
}
