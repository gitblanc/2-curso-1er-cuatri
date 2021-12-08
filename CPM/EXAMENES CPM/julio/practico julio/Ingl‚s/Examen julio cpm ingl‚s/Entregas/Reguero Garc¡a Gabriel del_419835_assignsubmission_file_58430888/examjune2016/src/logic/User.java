package logic;

public class User 
{
	public String id;
	public String name;
	public String surname;
	public String password;
	public String getId() {
		return id;
	}
	public User(String id, String name, String surname, String password) 
	{
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	public void setId(String id) 
	{
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
