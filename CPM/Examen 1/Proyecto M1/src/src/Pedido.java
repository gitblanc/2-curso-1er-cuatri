/**
 * 
 */
package src;

import java.util.ArrayList;

/**
 * @author blanc
 *
 */
public class Pedido {

	private ArrayList<Articulo> listaPedido;

	public Pedido() {
		listaPedido = new ArrayList<>();
	}

	// Método que añade un elemento a una lista actualizando un campo numérico
	public void add(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;

		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo())) {
				articuloEnPedido = a;
				articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() + unidades);
				break;
			}
		}

		if (articuloEnPedido == null) {
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		}
	}

	@Override
	public String toString() {
		String cadena = "";
		for (Articulo art : listaPedido) {
			cadena += art.toString() + "\n";
		}
		cadena += "Total= " + getTotal() + "€";
		return cadena;
	}

	public float getTotal() {
		float precio = 0;
		for (Articulo art : listaPedido) {
			precio += art.getPrecio();
		}
		return precio;
	}

	public void inicializar() {
		listaPedido.clear();

	}

}
