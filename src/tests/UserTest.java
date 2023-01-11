package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.modele.User;
import main.java.modele.Project;

/**
 * The testing class
 */

public class UserTest {

	private User user;
	private Project project1;
	private Project project2;

	@BeforeEach
	public void before() {
		user = new User("Louis22");
		project1 = new Project("Projet 1", " Despript1");
		project1 = new Project("Projet 2", " Despript2");
	}

	@Test
	public void verificationGetLoginTest() {
		assertEquals("Louis22", user.getLogin());

	}
	
	@Test
	public void verificationSetLoginTest() {
		assertEquals("Louis22", user.getLogin());
		user.setLogin("Louis23");
		assertEquals("Louis23", user.getLogin());
	}

	@Test
	public void verificationGetProjectTest() {
		assertEquals(0, this.user.getProjects().size());
		user.add(project1);
		assertEquals(1, this.user.getProjects().size());

		user.add(project2);
		assertEquals(2, this.user.getProjects().size());

	}

}