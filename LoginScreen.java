public class LoginScreen extends Screen {

  public LoginScreen(Screen parent) {
    super(parent);
    this.data = new String[2];
  }

  public void display() {
    System.out.println("-------------------------------------");
    System.out.println("Username: " + this.data[0]);
    System.out.println("Password: " + this.data[1]);
    System.out.println("-------------------------------------");
    System.out.println("(0) Back");
    System.out.println("(1) Enter username");
    System.out.println("(2) Enter password");
    System.out.println("(3) Login!");
  }

  public Screen next(String input) {
    switch (input) {
      case "0":
        return this.parent;
      case "1":
        return new EnterDataScreen(this,"Username","0");
      case "2":
        return new EnterDataScreen(this, "Password","1");    
      default:
        return this;
    }
  }
  
}
