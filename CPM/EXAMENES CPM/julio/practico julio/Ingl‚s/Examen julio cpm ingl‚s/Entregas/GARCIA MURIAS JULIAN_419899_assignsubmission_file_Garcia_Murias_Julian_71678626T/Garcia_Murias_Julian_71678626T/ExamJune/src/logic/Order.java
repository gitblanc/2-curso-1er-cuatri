package logic;

import java.util.ArrayList;

public class Order {
	
	private Client client;
	
	public Order(){
		totalPrice=(float) 0.0;
		listBooks=new ArrayList<Book>();		
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ArrayList<Book> getListBooks() {
		return listBooks;
	}
	public void setListBooks(ArrayList<Book> listBooks) {
		this.listBooks = listBooks;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	private ArrayList<Book> listBooks;
	private float totalPrice;

	public void calculatePrice() {
		totalPrice=0;
		for(Book b:listBooks){
			totalPrice+=b.getPrize();
		}
		
	}
}
