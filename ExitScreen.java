public class ExitScreen extends Screen {

  public ExitScreen() {}
  public void display() {
    System.out.println("Goodbye!");
  }

  public Screen prev() { return null; }
  public Screen next(String input) { return null; }
} 