package logica;

public class Cliente {

	private String dni;
	private String nombre;
	private String apellido;
	private String contrase�a;
	
	public Cliente(String dni, String nombre, String apellido, String contrase�a) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrase�a = contrase�a;
	}

	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	
}
