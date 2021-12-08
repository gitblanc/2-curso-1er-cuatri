package logica;

import java.util.ArrayList;

public class Pedido {

	private ArrayList<LibroCompra> pedidoFinal;

	public Pedido() {
		pedidoFinal = new ArrayList<LibroCompra>();
	}

	
	
	
	public ArrayList<LibroCompra> getPedido() {
		return pedidoFinal;
	}

}
