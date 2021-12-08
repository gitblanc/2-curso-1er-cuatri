package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookStore {

	List<Libro> libros = new ArrayList<Libro>();
	List<Cliente> clientes = new ArrayList<Cliente>();

	public BookStore() {
		libros = fillLibros();
		clientes = fillClientes();
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public Libro getLibroByTitle(String title) {
		for (Libro libro : libros)
			if (libro.getTitle().equals(title))
				return libro;
		return null;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public Cliente login(String DNI, String password) {
		for (Cliente cliente : clientes) {
			if (cliente.getDNI().equals(DNI)
					&& cliente.getPassword().equals(password))
				return cliente;
			//Comentado por Lanvin
			//else
				//return null;
		}
		return null;
	}

	public Cliente getCliente(String DNI) {
		for (Cliente cliente : clientes)
			if (cliente.getDNI().equals(DNI))
				return cliente;
		return null;
	}

	public List<Libro> fillLibros() {
		String nombreFichero = "files/libros.dat";
		String linea = "";
		List<Libro> temp = new ArrayList<Libro>();
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				temp.add(new Libro(toInteger(trozos[0]), toDouble(trozos[6]),
						trozos[1], trozos[2], trozos[3], trozos[4], trozos[5]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
		return temp;
	}

	public List<Cliente> fillClientes() {
		String nombreFichero = "files/clientes.dat";
		String linea = "";
		List<Cliente> temp = new ArrayList<Cliente>();
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				temp.add(new Cliente(trozos[0], trozos[1], trozos[2], trozos[3]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
		return temp;
	}

	public void guardaPedido(List<ElementoCarrito> pedido) {
		String nombreFichero = "files/pdCPM_" + new Random().nextInt() + ".txt";
		String linea = "";
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(
					nombreFichero));

			for (ElementoCarrito elemento : pedido) {
				linea = elemento.getISBN() + " - " + elemento.getTitle() + " - " + elemento.getUnidades();
				fichero.write(linea);
				fichero.newLine();
			}
			
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	private long toInteger(String str) {
		return Long.valueOf(str);
	}

	private double toDouble(String str) {
		return Double.valueOf(str);
	}

}
