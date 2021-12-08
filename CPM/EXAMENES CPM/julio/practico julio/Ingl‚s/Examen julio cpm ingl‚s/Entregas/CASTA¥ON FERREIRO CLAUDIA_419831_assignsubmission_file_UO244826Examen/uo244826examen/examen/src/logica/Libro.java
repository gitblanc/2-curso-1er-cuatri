package logica;

public class Libro {

	String USBN;
	String title;
	String editor;
	String author;
	String type;
	String summary;
	Double price;
	int units;
	
	public Libro(String uSBN, String title, String editor, String author,
			String type, String summary, Double price) {
		super();
		USBN = uSBN;
		this.title = title;
		this.editor = editor;
		this.author = author;
		this.type = type;
		this.summary = summary;
		this.price = price;
	}

	public String getUSBN() {
		return USBN;
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

	public Double getPrice() {
		return price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
	
	
	
}
