package syain;

public class M_User {
	private String login_id;
	private String password;

	public M_User() { }

	public M_User(String login_id, String password) {
		this.login_id = login_id;
		this.password = password;
	}

	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id){
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass){
		this.password = pass;
	}

}
