package logic;

public class User 
{
	public String dni;
	public String name;
	public String surname;
	public String pass;
	
	
	
	
	public User(String dni, String name, String surname, String pass) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.pass = pass;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
}
