package logic;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;

public class Login {
	private ArrayList<User> users = new ArrayList<User>();
	
	public Login() {
		leerFichero();
	}

	void leerFichero() {
	    String nombreFichero = "clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        User user = new User(trozos[0], trozos[1], trozos[2], trozos[3]);
	        users.add(user);
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
	
	public boolean validateUser(String user, String password) {
		return users.contains(new User(user, password));
	}
	
	public String getName(String user, String password) {
		return users.get(users.indexOf(new User(user, password))).getName();
	}
}
