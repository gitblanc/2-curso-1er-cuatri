package logica;

public class Client {
	String dni;
	String name;
	String surname;
	String password;
	
	public Client(String d, String n, String s, String p){
		this.dni = d;
		this.name = n;
		this.surname = s;
		this.password = p;
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
