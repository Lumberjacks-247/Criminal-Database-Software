import java.util.Scanner;

public class UI {

  private static final String QUITFLAG = "-1";
  private static Scanner scanner = new Scanner(System.in);
  private static Screen display = Screens.start();
  
  public static boolean loop() {
    
    // Display screen
    display.display();
    
    // Grab user input
    String inp = input();

    // Check global quit flag
    if (inp.equals(UI.QUITFLAG)) {
      return false;
    }

    // Advance to next screen
    display = display.next(inp);
    return display == null ? false : true;
  }
  
  private static String input() {
    return scanner.nextLine();  // grab user input
  }

  public static void main(String[] args) { while(UI.loop());}
}
