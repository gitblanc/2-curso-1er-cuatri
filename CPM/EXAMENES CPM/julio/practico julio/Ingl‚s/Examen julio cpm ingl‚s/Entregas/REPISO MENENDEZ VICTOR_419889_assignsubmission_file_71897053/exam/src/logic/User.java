package logic;

public class User {
	private String dni;
	private String name;
	private String surnames;
	private String password;
	
	public User(String dni, String name, String surnames, String password) {
		this.dni = dni;
		this.name = name;
		this.surnames = surnames;
		this.password = password;
	}
	
	public User(String dni, String password) {
		this.dni = dni;
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		return user.getDni().equals(dni) && user.getPassword().equals(password);
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getName() {
		return name;
	}
}
