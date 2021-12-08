package logica;

public class Cliente {

	String DNI, nombre, apellido, password;
	
	public Cliente(String dNI, String nombre, String apellido, String password) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getPassword() {
		return password;
	}
	
	
}
