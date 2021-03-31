package src;
import java.util.Scanner;


/**
 * The main loop which handles user input and cycles Screen objects.
 * @author Blake Seekings
 * @version 1.3
 * @see Screen
 * @see UIConstants
 */
public class UI {
  private static Scanner scanner = new Scanner(System.in);
  private static Screen screen = UIConstants.start();
  

  /**
   * Displays the current Screen, grabs user input, and cycles to the next Screen.
   * @return method call success boolean
   */
  public static boolean display() {

    //cls
    for (int i = 0; i < 100; ++i){
      System.out.println();
    }

    // Display screen
    screen.display();
    
    // Grab user input
    String inp = input();

    // Advance to next screen
    return (screen = screen.next(inp)) == null ? false : true;
  }
  
  /**
   * Grabs input from user.
   * @return String input from user
   */
  private static String input() {
    return scanner.nextLine();  
  }

  public static void main(String[] args) { 
    while(UI.display());
  }

}
