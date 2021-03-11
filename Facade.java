
public class Facade {

	private Person person;
	private Crime crime;
	private User user;
	protected Password password;
	private Users currentUser;

	
	public Facade() {

		person = Person.getInstance(); 
		crime = Crime.getInstance();
		user = User.getInstance();
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
	
	public boolean createAccount(String userName, String firstName, String lastName, int age, String userPassword)
	{
		return user.addUser(userName,  firstName,  lastName,  age,  userPassword);
	}


	public boolean addUser(String userName, String firstName, String lastName, int age, String userPassword) {
		if(findUser(userName))
			return false;
		User.add(new User(userName, firstName, lastName, age, userPassword));
		return true;
	}
	
	public boolean findUser(String userName) {
		return user.haveUser(userName);
	}
	
	public Users getCurrentUser() {
		return currentUser;
	}
	
	public boolean login(String userName) {
		if(!user.haveUser(userName))return false;
		
		currentUser = user.getUser(userName);
		return true;
	}
	
}
