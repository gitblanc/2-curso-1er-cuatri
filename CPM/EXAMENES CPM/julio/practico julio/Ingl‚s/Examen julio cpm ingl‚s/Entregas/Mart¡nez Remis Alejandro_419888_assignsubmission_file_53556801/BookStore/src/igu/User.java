package igu;

public class User {
	private String id;
	private String name;
	private String surname;
	private String password;
	
	public User(String id, String name, String surname, String password){
		setId(id);
		setName(name);
		setSurname(surname);
		setPassword(password);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
