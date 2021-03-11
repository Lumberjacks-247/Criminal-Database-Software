import java.util.Scanner;

public class UI {
  
  private static Scanner scanner = new Scanner(System.in);

  private static Screen display = new WelcomeScreen();
  
  public static boolean loop() {
    
    // Display screen
    System.out.println("\n\n\n\n##############################################################");
    display.display();
    
    // Grab user input
    System.out.print("\n\nWaiting on user input: ");
    String inp = input();
    if (inp.equals("-1")) {
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
