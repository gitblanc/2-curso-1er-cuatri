package logica;

public class Cliente {
	private String dni;
	private String name;
	private String surname;
	private String pass;
	
	
	public Cliente(String dni, String name, String surname, String pass) {
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
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", name=" + name + ", surname=" + surname + ", pass=" + pass + "]";
	}
	
}
