
public class Facade {

	private Person person;
	private Crime crime;
	private User user;
	protected Password password;

	
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
	
	public static void createAccount(String userName, String userPassword) {
		userName = userName.next();
		userPassword = userPassword.next();
	}
	
	public boolean findUser(String userName) {
		return user.haveUser(userName);
	}
	
	private boolean findPassword(String userPassword) {
		return password.havePassword(userPassword);
	}
	
	public boolean checkPassword(String userName, String userPassword) {
		String password = null;
		if(!findUser(userName)) {
			findPassword(userPassword);
			if (password == userPassword)
				return true;
		}
		return true;
		
	}
	
	public boolean login(String userName, String userPassword) {
		if(findUser(userName)) {
			checkPassword(userName, userPassword);
			if(checkPassword(userName, userPassword) == true) {
				return true;
			}
			return false;
		}
		return false;
		
	}
	
}
