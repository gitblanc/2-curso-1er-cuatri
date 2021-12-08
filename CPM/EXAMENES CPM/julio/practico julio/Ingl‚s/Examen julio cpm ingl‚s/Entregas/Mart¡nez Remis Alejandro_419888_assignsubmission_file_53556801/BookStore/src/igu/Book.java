package igu;

public class Book {
	private String isbn;
	private String title;
	private String editor;
	private String author;
	private String type;
	private String summary;
	private String price;
	
	public Book (){
		System.out.println("ERROR: Empty book created. Choose valid arguments");
		setIsbn("");
		setTitle("");
		setEditor("");
		setAuthor("");
		setType("");
		setSummary("");
		setPrice("");
	}
	
	public Book(String isbn, String title, String editor, String author, String type, String summary, String price){
		setIsbn(isbn);
		setTitle(title);
		setEditor(editor);
		setAuthor(author);
		setType(type);
		setSummary(summary);
		setPrice(price);
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
