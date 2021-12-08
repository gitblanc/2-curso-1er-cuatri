package logica;

public class Libro {
	
	private String ISBN;
	private String title;
	private String editor;
	private String author;
	private String type;
	private String summary;
	private float price;
	
	public Libro(String iSBN, String title, String editor,String author,String type,
			String summary, float price) {
		super();
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

	public String getType() {
		return type;
	}

	public String getSummary() {
		return summary;
	}

	public float getPrice() {
		return price;
	}
	
	public String getAuthor() {
		return author;
	}
	
	
	
	

}
