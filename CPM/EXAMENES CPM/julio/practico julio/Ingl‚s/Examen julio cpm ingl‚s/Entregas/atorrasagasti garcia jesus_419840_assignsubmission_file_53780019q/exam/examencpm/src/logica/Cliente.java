package logica;

public class Cliente {
	
	private String DNI;
	private String name;
	private String surname;
	private String password;
	
	public Cliente(String dNI, String nombre, String apellido, String contrase�a) {
		super();
		DNI = dNI;
		this.name = nombre;
		this.surname = apellido;
		this.password = contrase�a;
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return name;
	}

	public String getApellido() {
		return surname;
	}

	public String getContrase�a() {
		return password;
	}
	
	
	
	

}
