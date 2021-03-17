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
  }

  /* UI Startup */
  private static ScreenType start = ScreenType.WELCOME;
  public static Screen start() {
    return CreateScreen(start);
  }


  protected static Screen CallFacade(ScreenType scrntype, EditorScreen scrn) {
    Facade facade = new Facade();

    switch (scrntype) {
      case LOGIN:
        String username = scrn.getData(0);
        //String password = scrn.getData(1);
        if (facade.login(username/*,password*/)) {
          return CreateScreen(ScreenType.MAINMENU);
        } else {
          System.out.println("\n !!!!!!LOGIN - FAILURE!!!!! \n");
          return scrn;
        }
        
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
        return CreateScreen(ScreenType.NULL);

      case MAINMENU:
        return MainMenu();

      default:
        return CreateScreen(ScreenType.NULL);

    }
  }




  protected static Screen WelcomeScreen() {
    String prompt = "";
    prompt += "          Welcome!\n";
    prompt += "---------------------------------\n";
    prompt += "        (0) Exit\n";
    prompt += "        (1) Login\n";
    prompt += "        (2) Create Account\n";

    ScreenType[] links = new ScreenType[3];
    links[0] = ScreenType.PARENT;
    links[1] = ScreenType.LOGIN;
    links[2] = ScreenType.CREATEACCOUNT;

    return new TransScreen(prompt, links);
  }

  protected static Screen MainMenu() {
    String prompt = "";
    prompt += "      Criminal Database Software\n";
    prompt += "-----------------------------------------\n";
    prompt += "              (0) Logout\n";
    prompt += "              (1) Search\n";
    prompt += "              (2) New\n";


    ScreenType[] links = new ScreenType[3];
    links[0] = ScreenType.PARENT;
    links[1] = ScreenType.SEARCH;
    links[2] = ScreenType.NEW;

    return new TransScreen(prompt,links);
  }

  protected static Screen Login() {
    String title = "";
    title += "                 Login       \n";
    title += "--------------------------------------";
  
    String[] dataPrompts = new String[2];
    dataPrompts[0] = "username";
    dataPrompts[1] = "password";

    String choices = "";
    choices += "--------------------------------------\n";
    choices += "       (0) Back\n";
    choices += "       (1) Change username\n";
    choices += "       (2) Change password\n";
    choices += "       (3) Login\n";
 

    ScreenType[] links = new ScreenType[4];
    links[0] = ScreenType.PARENT;
    links[1] = ScreenType.ENTERDATA;
    links[2] = ScreenType.ENTERDATA;
    links[3] = ScreenType.SUBMITDATA;
    
    return new EditorScreen(title,dataPrompts,choices,links);
  }


}
