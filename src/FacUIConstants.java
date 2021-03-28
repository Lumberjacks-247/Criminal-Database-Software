package src;
//TODO - Add JavaDoc

public class FacUIConstants {
  private static Facade fac = new Facade();
  
  public static Screen searchReports(Screen s) {
    boolean override = true;

    String author = s.getDataValue(0); // Author
    String LofC = s.getDataValue(1); // LofC
    String jurisdiction = s.getDataValue(2); // Jurisdiction
    String TofC = s.getDataValue(3); // TofC
    String Location = s.getDataValue(4); // Location

    //TODO - Create success and failure branches
    if (/*fac.findCrime(crimeName)*/override) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.MAINMENU.call(s);
    }


  }
  public static Screen searchPeople(Screen s) {
    
    boolean override = true;
    String p0 = s.getDataValue(0);
    String p1 = s.getDataValue(1);
    String p2 = s.getDataValue(2);
    String p3 = s.getDataValue(3);
    String p4 = s.getDataValue(4);
    String p5 = s.getDataValue(5);
    String p6 = s.getDataValue(6);
    String p7 = s.getDataValue(7);
    String p8 = s.getDataValue(8);

  
    return ScreenCalls.MAINMENU.call(s);
  }

  public static Screen logout(Screen s) {
    //fac.logout();
    return ScreenCalls.LOGOUT.call(s);
  }

  public static Screen login(Screen s) {
    String username = s.getDataValue(0);
    String password = s.getDataValue(1);

    //TODO - Create success and failure branches
    if (fac.login(username, password)/*override*/) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.WELCOME.call(s);
    }

  }

  public static Screen createAccount(Screen s) {
    String p0 = s.getDataValue(0); //Username
    String p1 = s.getDataValue(1); //Password
    String p2 = s.getDataValue(2); //First Name
    int p3 = Integer.parseInt(s.getDataValue(3)); //Last Name
    String p4 = s.getDataValue(4); //Access Level


    //TODO - Create success and failure branches
    if (fac.createAccount(p0,p1,p2,p3,p4)/*override*/) {
      return ScreenCalls.MAINMENU.call(s);
    } else {
      return ScreenCalls.WELCOME.call(s);
    }
  }


}
