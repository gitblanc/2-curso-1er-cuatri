package logic;

import java.util.ArrayList;

public class FiltraLibros {

	public String[] titulos(ArrayList<Articulo> libros) 
	{
		String[] aux= new String[libros.size()];
		for(int i=0;i<libros.size();i++)
		{
			String aux2 = libros.get(i).titulo;
			aux[i]=aux2;
		}
		return aux;
		
	}

	public String[] filtra10(ArrayList<Articulo> libros) 
	{

		ArrayList<Articulo> aux =new  ArrayList<Articulo>();
		for(int i=0;i<libros.size();i++)
		{
			
			Articulo aux2 = libros.get(i);
			if(aux2.price<=15)
			{
				aux.add(aux2);
			}
		}
		return titulos(aux);
		
	}

	public String[] filtra1040(ArrayList<Articulo> libros) 
	{
		ArrayList<Articulo> aux =new  ArrayList<Articulo>();
		for(int i=0;i<libros.size();i++)
		{
			
			Articulo aux2 = libros.get(i);
			if(aux2.price>15||aux2.price<40)
			{
				aux.add(aux2);
			}
		}
		return titulos(aux);
	}

	public String[] filtra40(ArrayList<Articulo> libros) 
	{
		ArrayList<Articulo> aux =new  ArrayList<Articulo>();
		for(int i=0;i<libros.size();i++)
		{
			
			Articulo aux2 = libros.get(i);
			if(aux2.price>=40)
			{
				aux.add(aux2);
			}
		}
		return titulos(aux);
	}

}
