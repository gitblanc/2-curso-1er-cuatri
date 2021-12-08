package logica;

public class Client {

	private String DNI;
	private String name;
	private String surname;
	private String pass;

	public Client(String dNI, String name, String surname, String pass) {
		DNI = dNI;
		this.name = name;
		this.surname = surname;
		this.pass = pass;
	}

	public String getDNI() {
		return DNI;
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
