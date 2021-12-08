package io;

import java.io.*;
import java.util.ArrayList;

import logica.Cliente;
import logica.Libro;

public class FileManagement {

	private String fileName;
	private ArrayList<Cliente> clientes;
	private ArrayList<Libro> libros;

	public FileManagement() {
		clientes = new ArrayList<Cliente>();
		libros = new ArrayList<Libro>();
		leerFichero1();
		leerFichero2();
	}

	public String getFile() {
		return fileName;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	void leerFichero1() {
		String nombreFichero = "clientes.dat";
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				clientes.add(new Cliente(trozos[0], trozos[1], trozos[2],
						trozos[3]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	void leerFichero2() {
		String nombreFichero = "libros.dat";
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				libros.add(new Libro(trozos[0], trozos[1], trozos[2],
						trozos[3], trozos[4], trozos[5], Double
								.parseDouble(trozos[6])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	public void grabarFichero() {
		String nombreFichero = "output.dat";
		String linea = "";
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(
					nombreFichero));
			fichero.write(linea);
			fichero.newLine(); // Si se quiere añadir un salto de línea
			// ...
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}