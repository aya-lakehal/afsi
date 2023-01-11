package main.java.exception;

public class IncorrectAuthentification extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IncorrectAuthentification() {
		super("Login ou mot de passe incorrect");
	}
}
