package logica;

public class Client {

	private String dni;
	private String name;
	private String surname;
	private String password;
	public Client(String dni, String name, String surname, String password) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	public String getDni() {
		return dni;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPassword() {
		return password;
	}
	
	
	
}
