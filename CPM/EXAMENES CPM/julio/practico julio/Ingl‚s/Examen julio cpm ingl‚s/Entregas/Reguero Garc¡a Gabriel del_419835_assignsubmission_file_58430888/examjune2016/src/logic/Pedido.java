package logic;

import java.util.ArrayList;

public class Pedido 
{
	public ArrayList<Articulo> total= new ArrayList<Articulo>();
	public float precio;

	public void add(Articulo book) 
	{
		total.add(book);
		price();
	}
	public void remove(Articulo book)
	{
		for(int i=0;i<total.size();i++)
		{
			Articulo aux = total.get(i);
			if(aux.ISBN.equals(book.ISBN))
			{
				total.remove(i);
			}
		}
		price();
	}
	
	public void price()
	{
		precio=0;
		for(int i=0;i<total.size();i++)
		{
			Articulo aux = total.get(i);
			precio=precio+aux.price;
		}
	}

}
