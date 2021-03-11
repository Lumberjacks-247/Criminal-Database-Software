public class WelcomeScreen extends Screen {

  public WelcomeScreen() {super();}

  public void display() {
    System.out.println("Welcome to or Criminal Database Software!\n");
    System.out.println("(0) Exit");
    System.out.println("(1) Login");
  }

  public Screen next(String input) {
    
    switch (input) {
      case "0":
        return null;
        //return new ExitScreen();
      case "1":
        return new LoginScreen(this);
      default:
        return this;
    }
  }
}
