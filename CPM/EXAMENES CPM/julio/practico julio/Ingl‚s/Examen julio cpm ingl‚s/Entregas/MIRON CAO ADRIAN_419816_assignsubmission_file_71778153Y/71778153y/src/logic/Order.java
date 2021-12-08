package logic;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
	
	private ArrayList<Book> books = new ArrayList<Book>();
	private Map<Book,Integer> order = new HashMap<Book,Integer>();
	private double price = 0;
	
	public Order()
	{
		leerFichero();
	}
	
	void leerFichero() {
	    String nombreFichero = "files/libros.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        books.add(new Book(trozos[0],trozos[1],trozos[2],trozos[3],trozos[4],trozos[5],trozos[6]));
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
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void add(Book book)
	{
		int count = order.containsKey(book) ? order.put(book, order.get(book)) : 0;
		order.put(book, count+1);
		price+= Float.parseFloat(book.getPrice());
	}
	
	public void remove(Book book)
	{
		if(order.containsKey(book))
		{
			if(order.get(book) > 0)
			{
				order.put(book, order.get(book)-1);
				if(price!=0)
					price-= Float.parseFloat(book.getPrice());
			}
		}
	}
	
	public String getShoppingCart()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Order:\n");
		for(Map.Entry<Book, Integer> each : order.entrySet())
		{
			if(each.getValue()>0)
				sb.append(each.getKey().getTitle() + " , "+ each.getKey().getPrice() + " : Units x" + each.getValue() + "\n");
		}
		return sb.toString();
	}
	
	public String getOrder()
	{
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Book, Integer> each : order.entrySet())
		{
			if(each.getValue()>0)
				sb.append(each.getKey().getISBN()+ " " + each.getKey().getTitle() + " " + each.getValue() );
		}
		return sb.toString();
	}
	
	public void grabarFichero(Client c) {
	    String nombreFichero = c.getDNI();
	    String linea= getOrder();
	    try {
		BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero));
		fichero.write(linea);
		fichero.newLine(); //Si se quiere añadir un salto de línea
		fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		}
		 catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
	 }
	
}
