import java.util.UUID;


public class User {
	private UUID id;
	private int accessLevel;
	private String userName;
	private String firstName;
	private String lastName;
	private String userPassword;

  public User(String userName, String firstName, String lastName, int accessLevel, String userPassword) {
	  this.id = UUID.randomUUID();
	  this.userName = userName;
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.accessLevel = accessLevel;
	  this.userPassword = userPassword;
  }
  
  public User(UUID id, String userName, String firstName, String lastName, int accessLevel, String userPassword) {
	  this.id = id;
	  this.userName = userName;
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.accessLevel = accessLevel;
	  this.userPassword = userPassword;
  }
  
  public int getAccessLevel() {
    return this.accessLevel;
  }

  public void setAccessLevel(int accLevel) {
    this.accessLevel = accLevel;
  }
  
  public String getUserName() {
	  return this.userName;
  }
  public void setUserName(String userName) {
	  this.userName = userName;
  }

  public String getFirstName() {
    return this.firstName;
  }
  
  public void setFirstName(String name) {
    this.firstName = name;
  }

  public String getLastName() {
    return this.lastName;
  }
 

  public void setLastName(String name) {
    this.lastName = name;
  }
  
  public UUID getID() {
	  return id;
  }
  
  public void setID(UUID id) {
	  this.id = id;
  }
  
  public String getPassword() {
	  return userPassword;
  }
  public void setPassword(String userPassword) {
	  this.userPassword = userPassword;
  }


}