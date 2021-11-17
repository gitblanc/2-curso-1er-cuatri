/**
 * 
 */
package logica;

/**
 * @author blanc
 *
 */
public class UserInterface {
	
	private static final int EXIT = 0;
	private Menu menu = new Menu();
	private Carta carta = new Carta();
	private Pedido pedido = new Pedido();
	
	
	public void show() {
		int option = EXIT;
		do {
			menu.show();
			option = menu.readOption();
			processOption(option);
		}
		while (option != EXIT);
	}

	private void processOption(int option) {
		switch(option) {
		case EXIT:
			return;
		case 1:
			verArtículos();
			break;
		case 2:
			añadirPedido();
			break;
		case 3:
			verPrecio();
			break;	
		case 4:
			grabarPedido();
			break;	
		case 5:
			obtenerCodigoPedido();
			break;
		default:
			System.out.println("Introduce una opci�n v�lida :3");
		}
		
	}

	private void obtenerCodigoPedido() {
		System.out.println(pedido.getCodigo());
		
	}

	private void grabarPedido() {
		pedido.grabarPedido();
		System.out.println("Pedido guardado :)");
		
	}

	private void verPrecio() {
		System.out.println(pedido.getTotal());
		
	}

	private void añadirPedido() {
		Articulo articulo = solicitarpedido();
		pedido.add(articulo, articulo.getUnidades());
		
	}

	private Articulo solicitarpedido() {
		String codigo = Console.readString("�C�digo del art�culo?");
		String tipo = Console.readString("�Tipo del art�culo?");
		String denominacion = Console.readString("�Denominaci�n del art�culo?");
		float precio = Console.readFloat("�C�digo del art�culo?");
		int unidades = Console.readInteger("�Cuantas unidades desea?");
		
		return new Articulo(codigo, tipo, denominacion, precio, unidades);
	}

	private void verArtículos() {
		Articulo[] articulos = carta.getArticulos();
		for(Articulo art: articulos) {
			System.out.println(art.toString() + "\n");
		}
		
	}


}
