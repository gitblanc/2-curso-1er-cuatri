package logica;

import java.util.ArrayList;

import java.io.*;

public class ManejadorDatos {
	
	private ArrayList<Libro> libros;
	private ArrayList<Persona> personas;
	
	public ManejadorDatos(){
		libros = new ArrayList<>();
		personas = new ArrayList<>();
		leerFicheroLibros();
		leerFicheroPersonas();
		
	}
	
	void leerFicheroLibros() {
		Libro libro;
	    String nombreFichero = "files/data/libros.dat";    
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	      //for (int i=0; i<4; i++){
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        libro = new Libro(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], Double.parseDouble(trozos[6]));
	        libros.add(libro);
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
	
	void leerFicheroPersonas() {
		Persona persona;
	    String nombreFichero = "files/data/clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	      	persona = new Persona(trozos[0], trozos[1], trozos[2], trozos[3]);
	      	personas.add(persona);
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

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void grabarFichero(String DNI, String trozos[]) {
	    String nombreFichero = "files/output/"+ DNI + ".dat";
	    String linea="";
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		for (int i=0; i<trozos.length; i++)		{
			linea = trozos[i];
			fichero.write(linea);
			fichero.newLine(); //Si se quiere añadir un salto de línea
			}
		//...
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }

}
