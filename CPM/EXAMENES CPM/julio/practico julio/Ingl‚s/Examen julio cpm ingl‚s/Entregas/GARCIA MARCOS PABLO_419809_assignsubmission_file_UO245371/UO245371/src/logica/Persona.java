package logica;

public class Persona {
	private String DNI;
	private String name;
	private String surname;
	private String password;

	public String getDNI() {
		return DNI;
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

	public Persona(String DNI, String name, String surname, String password){
		this.DNI=DNI;
		this.name= name;
		this.surname = surname;
		this.password = password; 
		
	}
}
