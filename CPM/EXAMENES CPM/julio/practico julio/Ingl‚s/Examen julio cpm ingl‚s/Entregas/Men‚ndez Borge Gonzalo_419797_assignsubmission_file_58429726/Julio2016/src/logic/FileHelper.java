package logic;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class FileHelper {
	
	public static final String PATH_CLIENTES = "files/clientes.dat";
	public static final String PATH_LIBROS = "files/libros.dat";
	public static final String PATH_RECEIPTS = "files/receipts/";

	protected ArrayList<Cliente> cargarClientes() {

	    String linea = "";
	    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	    
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(PATH_CLIENTES));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        clientes.add(new Cliente(trozos[1], trozos[2], trozos[0], trozos[3]));
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	    
	    return clientes;
	 }
	
	protected ArrayList<Libro> cargarLibros() {

	    String linea = "";
	    ArrayList<Libro> libros = new ArrayList<Libro>();
	    
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(PATH_LIBROS));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        libros.add(new Libro(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], new BigDecimal(trozos[6])));
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	    
	    return libros;
	 }

	protected void grabarFichero(Pedido pedido) {
		
	    String nombreFichero = pedido.getCliente().getDNI() + ".dat";
	    StringBuilder sb = new StringBuilder();
	    
	    try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(PATH_RECEIPTS + nombreFichero));
			
			for(Libro libro : pedido.getCompra().keySet()) {
				sb.append("ISBN: ");
				sb.append(libro.getISBN());
				sb.append(" - Title: ");
				sb.append(libro.getTítulo());
				sb.append(" - Units: ");
				sb.append(pedido.getCompra().get(libro));
				
				fichero.write(sb.toString());
				sb.setLength(0);
				fichero.newLine(); //Si se quiere añadir un salto de línea
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
