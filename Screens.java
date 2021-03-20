public class Screens {

  public static enum ScreenType {
    NULL,
    EXIT,
    PARENT,
    ENTERDATA,
    SUBMITDATA,
    WELCOME,
    LOGIN,
    CREATEACCOUNT,
    MAINMENU
    ;



  }

  /* UI Startup */
  private static ScreenType start = ScreenType.WELCOME;
  public static Screen start() {
    return CreateScreen(start);
  }


  private static Facade facade = new Facade();

  protected static Screen CallFacade(ScreenType scrntype, EditorScreen scrn) {

    String username;
    String password;
    String accessLevel;
    switch (scrntype) {
      case LOGIN:
        username = scrn.getData(0);
        password = scrn.getData(1);
        if (true/*facade.login(username/*,password)*/) {
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


  }
  protected static Screen CreateScreen(ScreenType scrntyp) {
    switch (scrntyp) {

      case NULL:
        return null;

      case EXIT:
        return CreateScreen(ScreenType.NULL);

      case WELCOME:
        return WelcomeScreen();

      case LOGIN:
        return Login();

      case CREATEACCOUNT:
        return CreateAccount();

      case MAINMENU:
        return MainMenu();

      default:
        return CreateScreen(ScreenType.NULL);

    }
  }

  
  protected static Screen EditorScreen(String titleString,String dataPromptString,String choiceString,String linkString) {
    
    String title = "                  " + titleString + "\n";
    title += "-----------------------------------------------------------";

    String[] dataPrompts = dataPromptString.split(";");

    String[] choices = choiceString.split(";");
    String body = "-----------------------------------------------------------\n";

    for (int i = 0; i < choices.length;++i){
      body += "                   (" + i + ") " + choices[i] + " \n"; 
    }


    String[] linkArray = linkString.split(";");
    ScreenType[] links = new ScreenType[linkArray.length];
    for (int i = 0; i < linkArray.length; ++i) {
      links[i] = ScreenType.valueOf(linkArray[i]);
    }


    return new EditorScreen(title,dataPrompts,body,links);


  }

  protected static Screen TransScreen(String titleString,String choiceString,String linkString) {

    String title = "                  " + titleString + "\n";
    title += "-----------------------------------------------------------";

    String[] choices = choiceString.split(";");
    String body = "\n";

    for (int i = 0; i < choices.length;++i){
      body += "                   (" + i + ") " + choices[i] + " \n"; 
    }

    String[] linkArray = linkString.split(";");
    ScreenType[] links = new ScreenType[linkArray.length];
    for (int i = 0; i < linkArray.length; ++i) {
      links[i] = ScreenType.valueOf(linkArray[i]);
    }

    return new TransScreen(title + body, links);


  }




  protected static Screen WelcomeScreen() {

    String titleString = "Welcome";
    String choiceString = "Exit;Login;Create Account";
    String linkString = "EXIT;LOGIN;CREATEACCOUNT";

    return TransScreen(titleString, choiceString, linkString);
  }

  protected static Screen MainMenu() {

    String titleString = "Criminal Database Software";
    String choiceString = "Logout;Search;New";
    String linkString = "WELCOME;SEARCH;NEW";

    return TransScreen(titleString,choiceString,linkString);
  }

  protected static Screen Login() {

    String titleString = "Login";
    String dataPromptString = "Username;Password";
    String choiceString = "Back;Set Username;Set Password;Login";
    String linkString = "PARENT;ENTERDATA;ENTERDATA;SUBMITDATA";

    return EditorScreen(titleString,dataPromptString,choiceString,linkString);
  }

  protected static Screen CreateAccount() {
    
    String titleString = "Create Account";
    String dataPromptString = "Username;Password;First Name;Last Name;Age";
    String choiceString = "Back;Set Username;Set Password;Set First Name;Set Lastname;Set Age;Create Account";
    String linkString = "PARENT;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;ENTERDATA;SUBMITDATA";

    return EditorScreen(titleString, dataPromptString, choiceString, linkString);


  }


}
