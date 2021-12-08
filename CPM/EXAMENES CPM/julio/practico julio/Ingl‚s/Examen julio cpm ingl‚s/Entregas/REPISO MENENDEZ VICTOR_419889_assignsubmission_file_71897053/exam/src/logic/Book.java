package logic;

public class Book {
	private String isbn;
	private String title;
	private String editorial;
	private String author;
	private String genre;
	private String description;
	private double price;
	
	public Book(String isbn, String title, String editorial, String author, String genre, String description, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.genre = genre;
		this.description = description;
		this.price = price;
	}
	
	public String getInformation() {
		String aux = isbn + "\n" + title + "\n" + author + "\nEditorial " + editorial + "\nGenre: " + genre + "\n" + description + "\nPrice: " + price + "€";
		return aux;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getISBN() {
		return isbn;
	}
}
