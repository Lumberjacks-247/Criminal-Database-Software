package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersTest {
	private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();
	
	@BeforeEach
	public void setup() {
		userList.clear();
		userList.add(new User("test1", "joeseph", "Crow", 0, "password1"));
		userList.add(new User("test2", "richard", "Plankton", 0, "password2"));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testHaveUserValidFirstItem() {
		boolean hasTest0 = users.haveUser("test1", "password1");
		assertTrue(hasTest0);
	}
	
	@Test
	void testHaveUserValidLastItem() {
		boolean hasTest1 = users.haveUser("test2", "password2");
		assertTrue(hasTest1);
	}
	
	@Test
	void testHaveUserInValid() {
		boolean hasTest3 = users.haveUser("userNotThere", "passcode");
		assertFalse(hasTest3);
	}
	
	@Test
	void testHaveUserEmpty() {
		boolean hasEmpty = users.haveUser("", "");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveUserNull() {
		boolean hasNull = users.haveUser(null, null);
		assertFalse(hasNull);
    }
}
	