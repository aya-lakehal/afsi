package main.java.modele;

import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import main.java.exception.IncorrectAuthentification;

/**
 * this class is for purpose to make the user able to make his inscription in the App
 *
 */
public class InscriptionTmp {
	/**
	 * this method is for the inscription of the user in the App by using LDAP protocol
	 * @param login : the user login
	 * @param password : the user's password
	 *
	 */
	public void inscrire(String login, String password) throws IncorrectAuthentification {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
		env.put(Context.SECURITY_PRINCIPAL, "cn=admin,ou=users,ou=system");
		env.put(Context.SECURITY_CREDENTIALS, "password");
		DirContext dirContext;

		try {
			dirContext = new InitialDirContext(env);
			Inscription inscription = new Inscription(login, password);
			dirContext.bind("cn=login,dc=test-ldap,dc=net", inscription);
			dirContext.close();
		} catch (AuthenticationException ex) {
			throw new IncorrectAuthentification();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
