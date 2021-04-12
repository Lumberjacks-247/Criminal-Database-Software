package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacadeTest {
	private Facade facade = new Facade();
	private Users users = Users.getInstance();
	private Crimes crimes = Crimes.getInstance();
	private Criminals criminals = Criminals.getInstance();
	private Suspects suspects = Suspects.getInstance();
	private ArrayList<User> userList = users.getUsers();
	private ArrayList<Crime> crimeList = crimes.getCrimes();
	private ArrayList<Criminal> criminalList = criminals.getCriminals();
	private ArrayList<Suspect> suspectList = suspects.getSuspects();
	
	@BeforeEach
	public void setup() {
		Users.getInstance().getUsers().clear();
		Crimes.getInstance().getCrimes().clear();
		Criminals.getInstance().getCriminals().clear();
		Suspects.getInstance().getSuspects().clear();
		DataWriter.saveUsers();
		DataWriter.saveCrimes();
		DataWriter.saveCriminals();
		DataWriter.saveSuspects();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		Crimes.getInstance().getCrimes().clear();
		Criminals.getInstance().getCriminals().clear();
		Suspects.getInstance().getSuspects().clear();
		DataWriter.saveUsers();
		DataWriter.saveCrimes();
		DataWriter.saveCriminals();
		DataWriter.saveSuspects();
	}

	@Test
	public void testCreateValidAccount() {
		facade.createAccount("test1", "name1", "2ndName", 1, "password1");
		facade.login("test1", "password1");
		User theUser = facade.getCurrentUser();
		assertEquals("test1", theUser.getUserName());
	}
	
	@Test
	public void testCreateSaved() {
		facade.createAccount("test2", "name2", "2ndName2", 1, "password2");
		facade.logout();
		facade = new Facade();
		facade.login("test2", "password2");
		User currentUser = facade.getCurrentUser();
		assertEquals("test2", currentUser.getUserName());
	}
	
	@Test
	public void testCreateDuplicateUserName() {
		facade.createAccount("test2", "name2", "2ndName2", 1, "password2");
		boolean isCreated = facade.createAccount("test2", "name2", "2ndName2", 1, "password2");
		assertFalse(isCreated);
	}
	
	@Test
	public void testCreateEmptyUserName() {
		boolean isCreated = facade.createAccount("", "", "", 0, "");
		assertFalse(isCreated);
	}
	
	@Test
	public void testCreateNullUserName() {
		boolean isCreated = facade.createAccount(null, "", "", 0, "");
		assertFalse(isCreated);
	}

    @Test
    public void testCreateNullName1(){
        boolean isCreated = facade.createAccount("", null, "", 0, "");
        assertFalse(isCreated);
    }

    @Test
    public void testCreateNullName2(){
        boolean isCreated = facade.createAccount("", "", null, 0, "");
        assertFalse(isCreated);
    }

    @Test
    public void testCreateNullPassword(){
        boolean isCreated = facade.createAccount("", "", "", 0, null);
        assertFalse(isCreated);
    }

	@Test
	public void testFindCrime() {
		facade.findCrime("test1");
		Crime theCrime = facade.findCrime(null);
		assertEquals("test1", theCrime);
	}

	@Test
	public void testSearchSuspects()	{
		facade.searchSuspects(null);
		Suspect[] theSuspect = facade.searchSuspects(null);
		assertEquals(null, theSuspect);
	}

	@Test
	public void testSearchCriminals()	{
		facade.searchCriminals(null);
		Criminal[] theCriminal = facade.searchCriminals(null);
		assertEquals(null, theCriminal);
	}
}