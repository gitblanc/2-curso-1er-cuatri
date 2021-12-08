package logic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {
	private ArrayList<Book> order;
	private double price;
	private String id;
	
	public Order() {
		price = 0;
		order = new ArrayList<Book>();
	}
	
	public void add(Book book) {
		order.add(book);
		price += book.getPrice();
	}
	
	public void remove(int index) {
		remove(this.order.get(index));
	}
	
	private void remove(Book book) {
		order.remove(book);
		price -= book.getPrice();
	}
	
	public void confirm() {
	    String nombreFichero = id + ".dat";
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		for (Book book : order) {
			fichero.write(book.getISBN() + " " + book.getTitle());
		}
		fichero.write(linea);
		fichero.newLine(); //Si se quiere añadir un salto de línea
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }
	
	public String[] getTitles() {
		String[] titles = new String[order.size()];
	    int index = 0;
	    for (Book book : order) {
	    	titles[index] = book.getTitle();
	    	index++;
	    }
	    return titles;
	}
	
}
