package io;

import java.io.*;
import java.util.ArrayList;

import logica.*;

public class FileManager {

	public ArrayList<Client> clients;
	public ArrayList<Book> books;
	
	public FileManager(){
		clients = new ArrayList<Client>();
		books = new ArrayList<Book>();
		readClients();
		readBooks();
	}

	void readBooks() {
	    String nombreFichero = "libros.dat";
		    String linea="";
		    try {
		      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

		      //Mientras quede información
		      while (fichero.ready()) {
		        linea = fichero.readLine();
		        String[] trozos = linea.split(":");
		        books.add(new Book (trozos[0],trozos[1],trozos[2],trozos[3],trozos[4],trozos[5],Double.valueOf(trozos[6])));
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
		

	void readClients() {
		 String nombreFichero = "clientes.dat";
		    String linea="";
		    try {
		      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

		      //Mientras quede información
		      while (fichero.ready()) {
		        linea = fichero.readLine();
		        String[] trozos = linea.split(":");
		        clients.add(new Client (trozos[0],trozos[1],trozos[2],trozos[3]));
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
		
}


