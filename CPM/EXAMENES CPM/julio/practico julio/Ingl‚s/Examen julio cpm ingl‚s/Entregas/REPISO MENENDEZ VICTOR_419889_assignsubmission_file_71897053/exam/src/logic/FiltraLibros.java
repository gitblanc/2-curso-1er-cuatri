package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FiltraLibros {
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Book> filteredBooks = new ArrayList<Book>();
	private String[] titles;
	
	public FiltraLibros() {
		leerFichero();
	}
	
	void leerFichero() {
	    String nombreFichero = "libros.dat";
	    String linea="";
	    ArrayList<String> titles = new ArrayList<String>();
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        Book book = new Book(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], Double.parseDouble(trozos[6]));
	        books.add(book);
	        titles.add(trozos[1]);
	      }
	      this.titles = new String[titles.size()];
	      int index = 0;
	      for (String title : titles) {
	    	  this.titles[index] = title;
	    	  index++;
	      }
	      filteredBooks = books;
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	 }
	
	public void filter(int range) {
		filteredBooks = new ArrayList<Book>();
		ArrayList<String> titles = new ArrayList<String>();
		if (range == 0) {
			for (Book book : books) {
				if (book.getPrice() < 15){
					titles.add(book.getTitle());
					filteredBooks.add(book);
				}
			}
		}
		
		if (range == 1) {
			for (Book book : books) {
				if (book.getPrice() >= 15 && book.getPrice() <= 40){
					titles.add(book.getTitle());
					filteredBooks.add(book);
				}
			}
		}
		
		if (range == 2) {
			for (Book book : books) {
				if (book.getPrice() > 40){
					titles.add(book.getTitle());
					filteredBooks.add(book);
				}
			}
		}
		this.titles = new String[titles.size()];
	    int index = 0;
	    for (String title : titles) {
	    	this.titles[index] = title;
	    	index++;
	    }
	}
	
	public String getInformation(int selected) {
		if (selected >= filteredBooks.size() || selected < 0)
			return "";
		return filteredBooks.get(selected).getInformation();
	}
	
	public Book getBook(int selected) {
		return filteredBooks.get(selected);
	}
	
	public String[] getTitles() {
		return titles;
	}
}
