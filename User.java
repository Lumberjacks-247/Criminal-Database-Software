public class User {
  private int accessLevel;
  private String firstName;
  private String lastName;

  public User() {}
  public int getAccessLevel() {
    return this.accessLevel;
  }

  public void setAccessLevel(int accLevel) {
    this.accessLevel = accLevel;
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


}
