package logica;

public class Book {

	private String ISBN;
	private String title;
	private String editor;
	private String author;
	private String type;
	private String summary;
	private double price;

	public Book(String iSBN, String title, String editor, String author,
			String type, String summary, double price) {
		ISBN = iSBN;
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

	@Override
	public String toString() {
		return getTitle();
	}

	public String getBookInfo() {
		return "Editor= " + editor
				+ "\nAuthor= " + author + "\nType= " + type + "\nSummary= "
				+ summary + "\nPrice=" + price;
	}

}
