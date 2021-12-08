package logic;

import java.util.Hashtable;

public class Pedido {

	private Cliente cliente;
	private Hashtable<Libro, Integer> compra;
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		compra = new Hashtable<Libro, Integer>();
	}

	public Cliente getCliente() {
		return cliente;
	}	
	
	public void addPurchase(Libro libro, int amount) {
		if (compra.containsKey(libro))
			compra.put(libro, compra.get(libro) + amount);
		else
			compra.put(libro, amount);
	}
	
	public void removeBook(Libro libro) {
		compra.remove(libro);
	}

	public Hashtable<Libro, Integer> getCompra() {
		return compra;
	}
}
