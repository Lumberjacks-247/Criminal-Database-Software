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

  /* Private Constants */
  private static final ScreenConsts STARTSCREEN = ScreenConsts.WELCOME;

  /* UI Startup */

  /**
   * Returns the initial Screen for UI to display.
   */
  public static Screen start() {
    return STARTSCREEN.getScreen(null);
  }


  //private static Facade facade = new Facade();

  /*protected static Screen CallFacade(ScreenType scrntype, EditorScreen scrn) {

    String username;
    String password;
    String accessLevel;
    switch (scrntype) {
      case LOGIN:
        username = scrn.getData(0);
        password = scrn.getData(1);
        if (falsefacade.login(username,password)) {
          return CreateScreen(ScreenType.MAINMENU);
        } else {
          System.out.println("\n !!!!!!LOGIN - FAILURE!!!!! \n");
          return scrn;
        }
      case CREATEACCOUNT:
        username = scrn.getData(0);
        password = scrn.getData(1);
        accessLevel = scrn.getData(2); 
        
      default:
        return scrn;
    }


  }*/
  
  /**
   * When passed a given parameter and called, will return the parent of the parameter.
   * @param parent The object of Screen which called for a new screen
   * @return the parent of the parameter
   */
  protected static Screen Parent(Screen parent) {
    return parent.parent();
  }

  /**
   * Creates the Welcom Screen
   * @param parent The Screen instance preceding the new Screen
   * @return The Welcome Screen
   */ 
  protected static Screen Welcome(Screen parent) {

    String titleString = "Welcome";
    String choiceString = "Exit;Login;Create Account";
    String linkString = "EXIT;LOGIN;CREATEACCOUNT";

    Screen newScreen = new TransScreen(titleString, choiceString, linkString);
    return newScreen;
  }

  /**
   * Creates the Main Menu Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Main Menu Screen
   */ 
  protected static Screen MainMenu(Screen parent) {

    String titleString = "Criminal Database Software";
    String choiceString = "Logout;Search;New";
    String linkString = "WELCOME;SEARCH;NEW";

    return new TransScreen(titleString,choiceString,linkString);
  }

  /**
   * Creates the Login Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Login Screen
   */ 
  protected static Screen Login(Screen parent) {

    String titleString = "Login";
    String dataPromptString = "Username;Password";
    String choiceString = "Back;Set Username;Set Password;Login";
    String linkString = "PARENT;ENTERDATA;ENTERDATA;SUBMITDATA";

    return new EditorScreen(titleString,dataPromptString,choiceString,linkString);
  }

  /**
   * Creates the Create Account Screen.
   * @param parent The Screen instance preceding the new Screen
   * @return The Create Account Screen
   */ 
  protected static Screen CreateAccount(Screen parent) {
    
    String titleString = "Create Account";
    String dataPromptString = "Username;Password;First Name;Last Name;Age";
    String choiceString = "Back;Set Username;Set Password;Set First Name;Set Lastname;Set Age;Create Account";
    String linkString = "PARENT;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;SUBMITDATA";

    return new EditorScreen(titleString, dataPromptString, choiceString, linkString);


  }


}
