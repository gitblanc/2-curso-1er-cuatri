package logic;

import java.util.ArrayList;

public class App {
	
	private FileHelper fh;
	private ArrayList<Cliente> clientes;
	private ArrayList<Libro> libros;
	private Pedido pedido;
	
	public App() {
		fh = new FileHelper();
		clientes = fh.cargarClientes();
		libros = fh.cargarLibros();
	}
	
	public boolean checkLogin(String user, String password) {
		
		for(Cliente c : clientes)
			if(c.getDNI().equals(user) && c.getPassword().equals(password))
				return true;
		
		return false;
	}
	
	public void createPedido(String DNI) {
		for(Cliente c : clientes)
			if(c.getDNI().equals(DNI))
				pedido = new Pedido(c);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}
	
	public void recordPurchase() {
		fh.grabarFichero(pedido);
	}
}
