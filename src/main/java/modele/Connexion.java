package main.java.modele;

import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import main.java.exception.IncorrectAuthentification;

/**
 * this class is for purpose to make the user be able to connect 
 *
 */
public class Connexion {

	private DirContext connection;
	private boolean isConnected;
	
	public Connexion() {
		this.connection = null;
	}
	/**
	 * this method is for the athentification of the user
	 * @param login the login of the user
	 * @param pwd the password of the user
	 *
	 */	
	public void authentification(String login, String pwd) throws IncorrectAuthentification {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
		env.put(Context.SECURITY_PRINCIPAL, "cn="+login+",ou=users,ou=system");
		env.put(Context.SECURITY_CREDENTIALS, pwd);
		try {
			this.connection = new InitialDirContext(env);
			this.isConnected = true;
		} catch (AuthenticationException ex) {
			throw new IncorrectAuthentification();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method make the user be able logout from the app
	 *
	 */
	public void logout() {
		try {
			this.connection.close();
			this.isConnected = false;
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method gives the status isConnected to the user
	 *
	 */	
	public boolean isConnected() {
		return isConnected;
	}
	
}
