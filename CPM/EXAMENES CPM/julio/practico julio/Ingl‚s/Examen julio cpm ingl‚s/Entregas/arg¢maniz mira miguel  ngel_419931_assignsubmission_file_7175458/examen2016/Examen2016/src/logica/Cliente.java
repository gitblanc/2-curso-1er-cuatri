package logica;

public class Cliente {

	private String dni;
	private String nombre;
	private String apellido;
	private String contraseña;
	
	public Cliente(String dni, String nombre, String apellido, String contraseña) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
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
	public String getContraseña() {
		return contraseña;
	}
	
}
