package io;

import java.io.*;
import java.util.ArrayList;

import logica.Client;

public class FileManagerClient {

	private String file;
	private ArrayList<Client> dataBaseClients;

	public FileManagerClient(String file) {
		this.file = file;
		dataBaseClients = new ArrayList<Client>();
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
				dataBaseClients.add(new Client(trozos[0], trozos[1], trozos[2],
						trozos[3]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	public ArrayList<Client> getDataBaseClients() {
		return dataBaseClients;
	}

}
