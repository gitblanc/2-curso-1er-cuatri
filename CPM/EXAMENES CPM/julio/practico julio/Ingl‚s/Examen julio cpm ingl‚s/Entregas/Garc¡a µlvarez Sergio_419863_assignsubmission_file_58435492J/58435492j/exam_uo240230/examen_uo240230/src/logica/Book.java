package logica;

public class Book {
	
	private String isbn;
	private String title;
	private String editor;
	private String author;
	private String type;
	private String summary;
	private double price;
	private int quantity;
	
	
	public Book(String isbn, String title, String editor, String author,
			String type, String summary, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.editor = editor;
		this.author = author;
		this.type = type;
		this.summary = summary;
		this.price = price;
		
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return title;
	}
	
	
	
	

}
