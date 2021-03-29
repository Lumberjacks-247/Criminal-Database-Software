package src;

/**
 * Displays the results of a search in Facade to the screen.
 * @author Blake Seekings
 * @version 1.0
 * @see FacUIConstants
 */
public class ResScreen extends Screen {
  private Object[] data;

  public ResScreen(Screen parent, Object[] objs) {
    this.parent = parent;
    this.data = objs;
  }

  public void display() {
    String title = UIConstants.center("Results") + "\n";
    title += UIConstants.DIV;

    System.out.println(title);

    int counter = 0;
    System.out.println("(0) Back");
    for (Object obj: this.data) {
      String line = "(" + (++counter) + ") " + obj.toString();
      System.out.println(line);
    }



    System.out.print("\n\n>> ");
  }


  public Screen next(String input) {
    return input.equals("0") ? this.parent : this;
  }
}
