package logic;

public class Client {
	
	private String DNI;
	private String name;
	private String surname;
	private String password;
	
	public Client(String DNI, String name, String surname, String password)
	{
		this.DNI=DNI;
		this.name=name;
		this.surname=surname;
		this.password=password;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
