package logic;

public class Client {

	private String dni, name, surname, password;
	
	public Client(String dni, String name, String surname, String password){
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
