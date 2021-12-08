package io;

import java.io.*;
import java.util.ArrayList;

import logica.Client;
import logica.Order;
import logica.OrderBook;

public class FileManagerWrite {

	private Order order;
	private ArrayList<OrderBook> orderDataBase;
	private Client client;
	private double totalPrice;

	public FileManagerWrite(Order order, Client client, double totalPrice) {
		this.order = order;
		orderDataBase = order.getDataBase();
		this.client = client;
		this.totalPrice = totalPrice;
		grabarFichero();
	}

	public void grabarFichero() {
		String nombreFichero = client.getDNI() + ".txt";
		String linea = "";
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(
					nombreFichero));
			fichero.write(linea);
			fichero.newLine();

			linea = "This order is for client " + client.getName()
					+ " with dni: " + client.getDNI();
			fichero.write(linea);
			fichero.newLine();

			int j = linea.length();
			linea = "";
			for (int i = 0; i < j; i++) {
				linea += "-";
			}
			fichero.write(linea);
			fichero.newLine();
			fichero.newLine();

			for (OrderBook b : orderDataBase) {
				linea = "Book " + b.getBook().getISBN() + " with price "
						+ b.getBook().getPrice() + ". Units = " + b.getUnits();
				fichero.write(linea);
				fichero.newLine();
			}
			fichero.newLine();
			fichero.newLine();
			linea = "		Total price is " + totalPrice + ".";
			fichero.write(linea);
			fichero.newLine();

			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}
