package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
	static List<Book> books = new ArrayList<Book>();
	public static List<Book> getBooks() {
		return books;
	}
	public static void populateBooks() {
		String userFile = "libros.dat";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(userFile));
			while(br.ready()) {
				line = br.readLine();
				String[] split = line.split(":");
				books.add(new Book(split[0],split[1], split[2],
								   split[3],split[4], split[5], 
								   Double.parseDouble(split[6])));
			}
			br.close();
		}
		catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	}
	public static Book getBook(String title) {
		for(Book b : books) 
			if(b.getTitle().equals(title))
				return b;
		return null;
	}
	public static void writeTotal(String ID, ArrayList<BoughtBook> bb) {
		String nombreFichero = ID+".dat";
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		for(BoughtBook b : bb) {
			linea = b.getBook().getISBN() + ":" + b.getBook().getTitle() + ":" + b.getUnits();
			fichero.write(linea);
			fichero.newLine(); 
		}
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}
