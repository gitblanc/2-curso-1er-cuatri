package logic;

import java.util.ArrayList;

public class FiltrarLibros 
{

	int condition=-1;

	public FiltrarLibros(int condition) {
		super();
		this.condition = condition;
	}
	
	public ArrayList<Book> aplicarFiltro(ArrayList<Book> libros)
	{
		ArrayList<Book> librosFiltrados = new ArrayList<Book>();
		if(condition==1)
		{
			for(Book b : libros)
			{
				if(b.price<15)
				{
					librosFiltrados.add(b);
				}
					
			}
		}
		
		else if(condition ==2)
		{
			for(Book b : libros)
			{
				if(b.price>=15 && b.price<=40)
				{
					librosFiltrados.add(b);
				}
					
			}
		}
		
		else if(condition == 3)
		{
			for(Book b : libros)
			{
				if(b.price>40)
				{
					librosFiltrados.add(b);
				}
					
			}
		}
		
		return librosFiltrados;
	}
}
