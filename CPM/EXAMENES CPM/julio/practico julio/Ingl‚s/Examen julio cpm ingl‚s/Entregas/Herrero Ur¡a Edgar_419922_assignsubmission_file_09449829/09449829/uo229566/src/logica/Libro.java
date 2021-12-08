package logica;

public class Libro {

	long ISBN;
	double price;
	String title, editor, author, type, summary;

	public Libro(long ISBN, double price, String title, String editor,
			String author, String type, String summary) {
		this.ISBN = ISBN;
		this.price = price;
		this.title = title;
		this.editor = editor;
		this.author = author;
		this.type = type;
		this.summary = summary;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
