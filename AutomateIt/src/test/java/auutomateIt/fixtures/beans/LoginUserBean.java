package auutomateIt.fixtures.beans;

public class LoginUserBean {
	private String username;
	private String password;

	public LoginUserBean(String username, String password) {
		this.username=username;
		this.password=password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "LoginUserBean [username=" + username + ", password=" + password + "]";
	}
	
}