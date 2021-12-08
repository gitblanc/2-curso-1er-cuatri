package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import logica.Book;
import logica.Client;

public class FileManagerBook {

	private String file;
	private ArrayList<Book> dataBaseBooks;

	public FileManagerBook(String file) {
		this.file = file;
		dataBaseBooks = new ArrayList<Book>();
		leerFichero();
	}

	void leerFichero() {
		String nombreFichero = file;
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			// Mientras quede información
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				dataBaseBooks.add(new Book(trozos[0], trozos[1], trozos[2],
						trozos[3], trozos[4], trozos[5], Double
								.valueOf(trozos[6])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	public ArrayList<Book> getDataBaseBooks() {
		return dataBaseBooks;
	}

}
