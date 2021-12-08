package logica;

public class Libro {

	long ISBN;
	String titulo, editor, autor, type, summary;
	double price;
	
	public Libro(long iSBN, String titulo, String editor, String autor,
			String type, String summary, double price) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.editor = editor;
		this.autor = autor;
		this.type = type;
		this.summary = summary;
		this.price = price;
	}
	
	public long getISBN() {
		return ISBN;
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
	public String getType() {
		return type;
	}
	public String getSummary() {
		return summary;
	}
	public double getPrice() {
		return price;
	}
	
	public String toString(){
		return titulo;
	}
	
	public String showInfo(){
		StringBuilder sb = new StringBuilder();
		sb.append(titulo + " (" + price + "€)\n");
		sb.append("ISBN: " + ISBN);
		sb.append("Author: " + autor + "\n");
		sb.append("Editor: " + editor + " - Type: " + type);
		sb.append("\nSummary:\n" + summary);
		
		return sb.toString();
	}
	
}
