package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bookstore {
	
	private static ArrayList<Book> allBooks = null;
	private static ArrayList<Client> clients = null;
	
	public Bookstore(){
		allBooks = new ArrayList<Book>();
		clients = new ArrayList<Client>();
		readFileBooks();
		readFileClients();
	}
	
	public void readFileBooks() {
	    String fileName = "files/libros.dat";
	    String line="";
	    try {
	      BufferedReader file = new BufferedReader(new FileReader(fileName));

	      while (file.ready()) {
	        line = file.readLine();
	        String[] trozos = line.split(":");
	        allBooks.add(new Book(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4],
	        		trozos[5], Float.parseFloat(trozos[6])));
	      }
	      file.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("File not found.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Input/output error.");
	    }
	 }
	
	public void readFileClients() {
	    String fileName = "files/clientes.dat";
	    String line="";
	    try {
	      BufferedReader file = new BufferedReader(new FileReader(fileName));

	      while (file.ready()) {
	        line = file.readLine();
	        String[] trozos = line.split(":");
	        clients.add(new Client(trozos[0], trozos[1], trozos[2], trozos[3]));
	      }
	      file.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("File not found.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Input/output error.");
	    }
	 }

	public static List<Book> getAllBooks(){
		return allBooks;
	}
	
	public List<Client> getAllClients(){
		return clients;
	}
}
