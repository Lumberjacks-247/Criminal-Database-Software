package src;
import java.util.ArrayList;

public class Users {
	private static Users users;
	private ArrayList<User> userList;
	
	private Users() {
		userList = DataLoader.loadUsers();
	}
	
	public static Users getInstance() {
		if(users == null) {
			users = new Users();
		}
		return users;
	}
	
	//check if have user name and password stored.
	public boolean haveUser(String userName, String userPassword) {
		for(User user : userList) {
			if(user.getUserName().equals(userName) && user.getPassword().equals(userPassword)) 
				return true;
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
	
	public boolean addUser(String id, String userName, String firstName, String lastName, int accessLevel, String userPassword) {
		if(haveUser(userName, userPassword))
			return false;
		userList.add(new User(id, userName, firstName, lastName, accessLevel, userPassword));
		return true;
	}
	
	public void saveUsers() {
		DataWriter.saveUsers();
	}



}
