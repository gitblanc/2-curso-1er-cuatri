package logic;

public class Cliente {
	
	private String name;
	private String surname;
	private String DNI;
	private String password;
	
	public Cliente(String name, String surname, String dNI, String password) {
		this.name = name;
		this.surname = surname;
		DNI = dNI;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getDNI() {
		return DNI;
	}

	public String getPassword() {
		return password;
	}
}
