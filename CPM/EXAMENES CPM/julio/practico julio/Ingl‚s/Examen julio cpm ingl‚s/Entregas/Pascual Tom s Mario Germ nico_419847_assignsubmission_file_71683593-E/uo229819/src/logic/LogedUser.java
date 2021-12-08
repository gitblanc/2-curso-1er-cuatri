package logic;

    public class LogedUser {

	public static User logedUser= new User("","","","");

	public LogedUser(User logedUser) {
		super();
		this.logedUser = logedUser;
	}

	static User getLogedUser() {
		return logedUser;
	}

	public void setLogedUser(User logedUser) {
		this.logedUser = logedUser;
	}
	
	
}
