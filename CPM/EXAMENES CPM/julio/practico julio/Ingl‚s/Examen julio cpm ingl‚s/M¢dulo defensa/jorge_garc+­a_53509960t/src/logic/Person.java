package logic;

public class Person {

	private String name;
	private String surname;
	private String phone;
	private String DNI;

	public Person( String name, String surname, String phone, String dNI) {
		
		
		this.name = name;
		this.surname = surname;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

}
