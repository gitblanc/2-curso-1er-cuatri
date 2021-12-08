package logic;

public class Book {
	
	private String ISBN;
	private String title;
	private String editor;
	private String author;
	private String type;
	private String summary;
	private float price;
	
	int units;
	
	public Book(String iSBN, String title, String editor, String author,
			String type, String summary, float price) {
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

	public void setISBN(String iSBN) {
		ISBN = iSBN;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
	public String getInformation(){
		return ("ISBN: " + getISBN() + "\nTitle: " + getTitle() + "\nEditor: " + getEditor() + "\nAuthor: " + getAuthor()+
				"\nType: " + getType() + "\nSummary: " + getSummary() + "\nPrice: " + getPrice());
	}
}
