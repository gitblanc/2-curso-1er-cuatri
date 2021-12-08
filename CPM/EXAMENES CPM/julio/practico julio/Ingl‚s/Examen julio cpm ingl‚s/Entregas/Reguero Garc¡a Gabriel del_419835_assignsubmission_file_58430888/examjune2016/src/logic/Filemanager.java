package logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Filemanager
{
	public ArrayList<User> users = new ArrayList<User>();
	public ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	public ArrayList<Articulo> pedido = new ArrayList<Articulo>();
	
	public void leerFicheros() 
	{
	    String nombreFichero = "files/clientes.dat";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready())
	      {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        User aux=new User(trozos[0], trozos[1], trozos[2], trozos[3]);
	        users.add(aux);
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo clientes no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	    
	    nombreFichero = "files/libros.dat";
	    linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready())
	      {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(":");
	        Articulo aux=new Articulo(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4],trozos[5], Float.parseFloat(trozos[6]));
	        articulos.add(aux);
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo articulos no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida");
	    }
	    
	    
	 }
	
	
	public void grabarFichero(String id) 
	{
	    String nombreFichero = "files/"+id+".dat";
	    String linea="";
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

	
	/*public String pedidoToString()
	{
		Articulo aux;
		
		for(int i=0;i<pedido.size();i++)
		{
			aux=pedido.get(i);
			
			
		}
	}*/
}
