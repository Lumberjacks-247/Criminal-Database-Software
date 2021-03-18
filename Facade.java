
public class Facade {

	private Person person;
	private Crime crime;
	private Users user;
	protected Password password;
	private User currentUser;

	
	public Facade() {


		person = Person.getInstance(); 
		crime = Crime.getInstance();
		user = Users.getInstance();
		password = Password.getInstance();
	}
	
	public boolean findPerson(String personName) {
		return person.havePerson(personName);
	}

	public boolean checkPerson(String personName) {
		if(!findPerson(personName)) 
			return false;
		return true;
	}
	
	public boolean editPerson(String personName, String editInfo) {
		if(findPerson(personName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addPerson(String personName, String newPerson) {
		if(!findPerson(personName))
			return false;
		return true;
	}

	public boolean findCrime(String crimeName) {
		return crime.haveCrime(crimeName);
	}

	public boolean checkCrime(String crimeName) {
		if(!findCrime(crimeName)) 
			return false;
		return true;
	}
	
	public boolean editCrime(String crimeName, String editInfo) {
		if(findCrime(crimeName) && editInfo.matches(".*[a-z].*"	))
			return true;
		return false;
	}
	
	public boolean addCrime(String crimeName, String newCrime) {
		if(!findCrime(crimeName))
			return false;
		return true;
	}
	
	public boolean createAccount(String userName, String firstName, String lastName, int accessLevel, String userPassword)
	{
		return user.addUser(userName,  firstName,  lastName,  accessLevel,  userPassword);
	}
	
	public boolean findUser(String userName) {
		return user.haveUser(userName);
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public boolean login(String userName, String userPassword) {
		if(!user.haveUser(userName))
			return false;
		
		currentUser = user.getUser(userName);
		return true;
	}

	public void logout() {
		user.saveUsers();
	}
	
}
