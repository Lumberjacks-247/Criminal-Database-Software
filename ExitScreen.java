public class ExitScreen extends Screen {

  public ExitScreen() {
    super(null);
  }
  public void display() {
    System.out.println("Goodbye!");
  }

  public Screen next(String input) { return null; }


} 