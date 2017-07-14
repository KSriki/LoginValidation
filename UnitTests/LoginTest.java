import static org.junit.Assert.*;

import org.junit.Test;

import Backend.User;

public class LoginTest {

	@Test
	public void test() {
		
		User user = new User("John","john@smith.com");
		
		User john = new User("john", "John@smith.com");
		
		assertTrue(user.validateUser(john));
		
		assertTrue(!john.validateUser(new User("mandingo","John@smith.com")));
	}

}
