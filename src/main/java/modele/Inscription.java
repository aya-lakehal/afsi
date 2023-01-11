package main.java.modele;

public class Inscription {

	private String login;
	private String password;

	public Inscription(String login, String password) {
		this.login = login;
		this.password = password;

	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

}
