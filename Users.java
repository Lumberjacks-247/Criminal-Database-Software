import java.util.ArrayList;

public class Users {
	private static Users users;
	private ArrayList<User> userList;
	
	private Users() {
		userList = DataLoader.getUsers();
	}
	
	public static Users getInstance() {
		if(users == null) {
			users = new Users();
		}
		return users;
	}
	
	//check if password matches with user name
	public boolean haveUser(String userName, String userPassword) {
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}
	
	//just check if user name is there
	public boolean haveUser(String userName) {
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}
	
	public User getUser(String userName) {
		for(User user: userList) {
			if(user.getUserName().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	public ArrayList<User> getUsers(){
		return userList;
	}
	
	public boolean addUser(String userName, String firstName, String lastName, int accessLevel, String userPassword) {
		if(haveUser(userName))
			return false;
		userList.add(new User(userName, firstName, lastName, accessLevel, userPassword));
		return true;
	}
	
	public void saveUsers() {
		DataWriter.saveUsers();
	}



}
