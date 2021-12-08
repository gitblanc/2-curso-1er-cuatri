package logica;

public class Libro {
	String ISBN;
	String title;
	String editor;
	String author;
	String type;
	String summary;
	double price;
	
	public Libro(String ISBN, String title, String editor, String author, String type, String summary, double price){
		this.ISBN = ISBN;
		this.title = title;
		this.editor = editor;
		this.author = author;
		this.type = type;
		this.summary = summary;
		this.price = price;
		
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public String getEditor() {
		return editor;
	}

	public String getAuthor() {
		return author;
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
	
}

//DefaultListModel