package logic;

import java.awt.Component;

public class Book {

	private String isbn, title, editor, author, type, summary;
	private double price;
	
	public Book(String isbn, String title, String editor, String author, String type, String summary, double price){
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
