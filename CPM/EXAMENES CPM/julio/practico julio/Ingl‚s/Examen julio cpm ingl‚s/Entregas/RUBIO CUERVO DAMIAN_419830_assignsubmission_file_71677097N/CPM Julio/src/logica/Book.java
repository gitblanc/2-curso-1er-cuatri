package logica;

public class Book {
	String isbn;
	String title;
	String editor;
	String author;
	String type;
	String summary;
	double price;
	
	public Book(String i, String t, String e, String a, String ty, String s, double p){
		this.isbn = i;
		this.title = t;
		this.editor = e;
		this.author = a;
		this.type = ty;
		this.summary = s;
		this.price = p;		
	}

	public String getIsbn() {
		return isbn;
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
