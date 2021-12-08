package logica;

import java.util.ArrayList;
import java.io.*;

public class BookStore {

	private ArrayList<Book> books;
	private ArrayList<Client> clients;
	
	public BookStore(){
		books = new ArrayList<Book>();
		clients = new ArrayList<Client>();
		leerFicheroClients();
		leerFicheroBooks();
	}
	
	void leerFicheroBooks() {
	    String nombreFichero = "files/libros.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");

	        Book b = new Book(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], Double.parseDouble(trozos[6]));
	        books.add(b);
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	 }
	
	void leerFicheroClients() {
	    String nombreFichero = "files/clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	       	
	        Client c = new Client(trozos[0], trozos[1], trozos[2], trozos[3]);
	        clients.add(c);
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	 }
	
	public void grabarFichero(ArrayList<Book> listBooks, String id ) {
	    String nombreFichero = id + ".dat";
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		fichero.write(linea);
		fichero.newLine(); //Si se quiere añadir un salto de línea
		
		for(Book b: listBooks){
			fichero.write("ISBN: " + b.getISBN() + "; Title: " + b.getTitle() + "; Amount: " + b.getAmount());
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
	
	public ArrayList<Client> getClients(){
		return clients;
	}
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	
}
