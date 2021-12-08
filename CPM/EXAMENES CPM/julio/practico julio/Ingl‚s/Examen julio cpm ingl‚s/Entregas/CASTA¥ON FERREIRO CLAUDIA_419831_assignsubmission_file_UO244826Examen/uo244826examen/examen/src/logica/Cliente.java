package logica;

public class Cliente {
	
	String dni;
	String name;
	String surname;
	String pass;
	
	public Cliente(String dni, String name, String surname, String pass) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.pass = pass;
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

	public String getPass() {
		return pass;
	}
	
	
	

}
