package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class User {
	
	private static String name;
	private static String surname;
	private static String ID;
	
	public static boolean doLogin(String user, String pass) {
		boolean logged = false;
		String userFile = "clientes.dat";
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(userFile));
			while(br.ready()) {
				line = br.readLine();
				String[] split = line.split(":");
				if(split[0].equalsIgnoreCase(user) && split[3].equals(pass)) {
					name = split[1];
					surname = split[2];
					ID = split[0];
					logged = true;
					break;
				}
			}
			br.close();
		}
		catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
		return logged;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		User.name = name;
	}

	public static String getSurname() {
		return surname;
	}

	public static void setSurname(String surname) {
		User.surname = surname;
	}

	public static String getID() {
		return ID;
	}

	public static void setID(String iD) {
		ID = iD;
	}
}
