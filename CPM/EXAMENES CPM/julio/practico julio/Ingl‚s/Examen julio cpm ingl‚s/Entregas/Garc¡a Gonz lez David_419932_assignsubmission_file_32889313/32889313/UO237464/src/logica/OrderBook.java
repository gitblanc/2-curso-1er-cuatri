package logica;

public class OrderBook {

	private Book book;
	private int units;

	public OrderBook(Book book, int units) {
		this.book = book;
		this.units = units;
	}

	public Book getBook() {
		return book;
	}

	public int getUnits() {
		return units;
	}

	@Override
	public String toString() {
		return getUnits() + " " + getBook().getTitle() + " "
				+ getBook().getPrice();
	}

	public void sumUnits(int value) {
		units += value;

	}

	public void decrementUnits(int value) {
		units -= value;
	}

}
