package logica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Fichero {

	public List<Cliente> clientes;
	public List<Libro> libros;

	public List<Cliente> leerFicheroClientes() {
		String nombreFichero = "clientes.dat";
		String linea = "";
		clientes = new ArrayList<Cliente>();
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			// Mientras quede información
			while (fichero.ready()) {
				linea = fichero.readLine();
				if (linea != null) {
					String[] trozos = linea.split(":");
					Cliente cliente = new Cliente(trozos[0], trozos[1],
							trozos[2], trozos[3]);
					if (cliente != null) {
						clientes.add(cliente);
					}
				}
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
		return clientes;
	}
	public List<Libro> getLibros(){
		return leerFicheroLibros();
	}

	public List<Libro> leerFicheroLibros() {
		String nombreFichero = "libros.dat";
		String linea = "";
		libros = new ArrayList<Libro>();
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			// Mientras quede información
			while (fichero.ready()) {
				linea = fichero.readLine();
				if (linea != null) {
					Libro libro = null;
					String[] trozos = linea.split(":");
					libro = new Libro(trozos[0],
							trozos[1], trozos[2], trozos[3], trozos[4],
							trozos[5], Double.parseDouble(trozos[6]));
					if (libro != null) {
						libros.add(libro);
					}
				}
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
		return libros;
	}

	public void grabarFichero(String archivo, List<Libro> lista) {
		String nombreFichero = archivo;
		for (Libro libro : lista) {
			String linea = libro.getTitulo() + ":" + libro.getPrecio()
					+ "€/unidad:" + libro.getUnidades() + " unidades.";
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
}
