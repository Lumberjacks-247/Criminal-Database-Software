/**
 * Contains constant information for use by UI and other UI involved classes.
 * @author Blake Seekings
 * @version 2.0 Implement ScreenConsts enum
 * @since 3/18/2021
 * @see UI
 * @see Screen
 */
public class UIConstants {
  
  /* Public Constants */
  public static final String DIV = "-------------------------------";
  public static final String PROMPT = ">> ";
  public static final String QUITFLAG = "-1";

  /* UI Startup */

  /**
   * Returns the initial Screen for UI to display.
   */
  public static Screen start() {
    return  ScreenCalls.START.call(null);
  }

  /**
   * Returns the null element, this breaks the Screen sequence completly.
   * @param parent The Screen object which called this method.
   * @return The null element
   */
  public static Screen Null(Screen parent) {
    return null;
  }

  /**
   * Constructs an EnterDataScreen using parametrized data.
   * @param parent The Screen where change in data is requested.
   * @param dataIndex The index of the data in parent.
   * @return The EnterDataScreen which is linked to the parent and a field of data.
   */
  public static EnterDataScreen EnterData(Screen parent, int dataIndex) {
    return new EnterDataScreen(parent, dataIndex);
  }

  /**
   * When passed a given parameter and called, will return the parent of the parameter.
   * @param parent The object of Screen which called for a new screen
   * @return the parent of the parameter
   */
  public static Screen ParentScreen(Screen parent) {
    return parent.getParent();
  }

  /**
   * Creates the Welcome Screen
   * @param parent The Screen instance preceding the new Screen
   * @return The Welcome Screen
   */ 
  public static Screen WelcomeScreen(Screen parent) {

    String titleString = "Welcome";
    String choiceString = "Exit;Login;Create Account";
    String linkString = "S:NULL;S:LOGIN;S:CREATEACCOUNT";

      
    /* Extra Adjustments */
    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(null);
    return screen;

  }

  /**
   * Creates the Main Menu Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Main Menu Screen
   */ 
  public static Screen MainMenuScreen(Screen parent) {

    String titleString = "Criminal Database Software";
    String choiceString = "Logout;Search;New";
    String linkString = "F:LOGOUT;S:SEARCH;S:NEW";

    /* Extra Adjustments */
    Screen screen = new TransScreen(titleString,choiceString,linkString);
    screen.setParent(null);
    return screen;
  }

  /**
   * Creates the Login Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Login Screen
   */ 
  public static Screen LoginScreen(Screen parent) {

    String titleString = "Login";
    String dataPromptString = "Username;Password";
    String choiceString = "Back;Set Username;Set Password;Login";
    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;F:LOGIN";

    /* Extra Adjustments */
    Screen screen = new EditorScreen(titleString, dataPromptString, choiceString, linkString);
    screen.setParent(parent);
    return screen;

  }

  /**
   * Creates the Create Account Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Create Account Screen
   */ 
  public static Screen CreateAccountScreen(Screen parent) {
    
    String titleString = "Create Account";
    String dataPromptString = "Username;Password;First Name;Last Name;Age";
    String choiceString = "Back;Set Username;Set Password;Set First Name;Set Lastname;Set Age;Create Account";
    String linkString = "S:PARENT;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;F:CREATEACCOUNT";

    /* Extra Adjustments */
    Screen screen = new EditorScreen(titleString, dataPromptString, choiceString, linkString);
    screen.setParent(parent);
    return screen;


  }


}
